/**
 * 探他（Tanta）Rex 模块 v1.0
 * 基于 2026-11-24 实测抓包（fastjson 明文）
 *
 * 模块 ID：user.tanta10
 * 数据源：只能用运行时注入的 endpoint（本地代理端口或经授权配置的主机）
 *
 * 关键约束（Rex 运行时）：
 *  - 无 fetch / XMLHttpRequest / WebSocket / setTimeout / require
 *  - 只有 Widget.http、Promise、async/await、JSON、Map、Set、Date、Math
 *  - HTTP 响应键：statusCode / data / headers；404/500 抛错；204 → data=""
 *
 * 鉴权：uid + token + signplus(HMAC-SHA256) + timestamp
 *   ⚠️ signplus 需要 HMAC 密钥。Rex 无 crypto API，无法本地计算。
 *   → 模块必须由外部提供「已签好的完整 URL」或「signplus 服务」。
 *   → 未提供时，模块进入 NO_SIGNER 状态，只显示说明，不发请求。
 */

(function () {
  'use strict';

  var MODULE_ID = 'user.tanta10';
  var TTL_MS = 24 * 3600 * 1000;
  var STORE_KEY = '__TANTA10__';
  var MAX_CACHE = 800;

  // ========== 配置（运行时注入，不内置任何域名/token） ==========
  function getConfig() {
    var c = {};
    try { c = JSON.parse(Widget.storage.get('tanta10_cfg') || '{}'); } catch (e) { c = {}; }
    return {
      // 端模式：local_proxy（真机本地代理端口）| configured_host（授权域名）
      mode: c.mode || '',
      // local_proxy: 端口号，如 37377（每次启动会变）
      port: c.port || 0,
      // configured_host: 形如 https://api.example.com
      host: c.host || '',
      uid: c.uid || '',
      token: c.token || '',
      // signplus 提供方式：'none' | 'upstream'（由上游/代理补签）
      signer: c.signer || 'none',
      // 上游签名服务基址（必须有 HMAC key 的那一侧）
      signerBase: c.signerBase || '',
      language: c.language || 'zh-cn'
    };
  }

  function baseUrl(cfg) {
    if (cfg.mode === 'local_proxy' && cfg.port) return 'http://127.0.0.1:' + cfg.port;
    if (cfg.mode === 'configured_host' && cfg.host) return cfg.host.replace(/\/+$/, '');
    return '';
  }

  // ========== 工具 ==========
  function now() { return Date.now(); }
  function b64encode(s) {
    // Rex 无 btoa/TextEncoder；手写 base64（UTF-8 安全）
    var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
    var bytes = utf8Bytes(s);
    var out = '', i = 0;
    while (i < bytes.length) {
      var b1 = bytes[i++], b2 = i < bytes.length ? bytes[i++] : -1, b3 = i < bytes.length ? bytes[i++] : -1;
      out += chars[b1 >> 2];
      out += chars[((b1 & 3) << 4) | ((b2 < 0 ? 0 : b2) >> 4)];
      out += b2 < 0 ? '=' : chars[((b2 & 15) << 2) | ((b3 < 0 ? 0 : b3) >> 6)];
      out += b3 < 0 ? '=' : chars[b3 & 63];
    }
    return out;
  }
  function utf8Bytes(str) {
    var out = [];
    for (var i = 0; i < str.length; i++) {
      var c = str.charCodeAt(i);
      if (c < 0x80) out.push(c);
      else if (c < 0x800) { out.push(0xc0 | (c >> 6), 0x80 | (c & 0x3f)); }
      else { out.push(0xe0 | (c >> 12), 0x80 | ((c >> 6) & 0x3f), 0x80 | (c & 0x3f)); }
    }
    return out;
  }

  // ========== 数据模型（基于实测，CLIENT_EXPECTED_MODEL） ==========
  function normalizeRoom(r) {
    if (!r || typeof r !== 'object') return null;
    var id = r.room_id != null ? String(r.room_id) : (r.uid != null ? String(r.uid) : null);
    if (!id) return null;
    var type = r.type;
    var paid = (type === 2 || type === '2');
    var tv = r.type_val;
    var cost = 0;
    if (tv !== undefined && tv !== null && tv !== '') { var n = parseInt(tv, 10); if (!isNaN(n)) cost = n; }
    var viewers = 0;
    if (r.nums !== undefined && r.nums !== null) { var v = parseInt(r.nums, 10); if (!isNaN(v)) viewers = v; }
    return {
      id: id,
      uid: r.uid != null ? Number(r.uid) : 0,
      name: r.user_nickname || '未命名',
      title: r.title || '',
      avatar: r.avatar || '',
      thumb: r.thumb || r.avatar || '',
      stream: r.stream || '',
      viewers: viewers,
      paid: paid,
      cost: paid ? cost : 0,
      type: type == null ? 0 : Number(type),
      platform: r.live_platform == null ? 0 : Number(r.live_platform),
      level: r.level_anchor || '',
      pkuid: r.pkuid == null ? 0 : Number(r.pkuid)
    };
  }

  // 兼容两种实测结构：
  //  A) {ret, data:{code,msg,info:[{list:[...]}]}}   （完整包装）
  //  B) {has_more, latest_revision, list:[...]}      （扁平）
  function parseListResponse(resp) {
    var out = { rooms: [], hasMore: false, revision: '', err: null };

    if (!resp || typeof resp !== 'object') { out.err = 'BAD_RESPONSE'; return out; }

    // 外层 ret
    if (resp.ret !== undefined && resp.ret !== 200 && resp.ret !== '200') {
      out.err = 'RET_' + resp.ret; return out;
    }
    var node = resp;
    if (resp.data && typeof resp.data === 'object') {
      node = resp.data;
      if (node.code !== undefined && node.code !== 0 && node.code !== '0') {
        out.err = 'CODE_' + node.code + (node.msg ? (' ' + node.msg) : '');
        return out;
      }
    } else if (resp.code !== undefined && resp.code !== 0 && resp.code !== '0') {
      out.err = 'CODE_' + resp.code + (resp.msg ? (' ' + resp.msg) : '');
      return out;
    }

    // 找 list
    var list = null;
    if (Array.isArray(node.list)) list = node.list;
    else if (Array.isArray(node.info) && node.info.length) {
      // info[0].list
      for (var i = 0; i < node.info.length; i++) {
        var it = node.info[i];
        if (it && Array.isArray(it.list)) { list = it.list; break; }
      }
      if (!list && typeof node.info[0] === 'object') list = node.info;
    }
    if (!list) { out.err = 'NO_LIST'; return out; }

    out.hasMore = !!node.has_more;
    out.revision = node.latest_revision || '';
    for (var j = 0; j < list.length; j++) {
      var r = normalizeRoom(list[j]);
      if (r) out.rooms.push(r);
    }
    if (!out.rooms.length) out.err = null; // 空列表不算错
    return out;
  }

  // ========== 请求 ==========
  function buildListUrl(cfg, liveClassId, offset, cursorR) {
    var base = baseUrl(cfg);
    if (!base) return null;
    var params = [
      'service=Home.getClassLiveCursor',
      'language=' + encodeURIComponent(cfg.language),
      'liveclassid=' + (liveClassId || 1),
      'uid=' + encodeURIComponent(cfg.uid),
      'token=' + encodeURIComponent(cfg.token)
    ];
    if (offset > 0) {
      var cur = b64encode(JSON.stringify({ r: cursorR || '', o: offset }));
      params.push('cursor=' + encodeURIComponent(cur));
    }
    return base + '/appapi/?' + params.join('&');
  }

  async function httpGetJson(url, cfg) {
    if (!url) return { ok: false, err: 'NO_URL' };
    var finalUrl = url;
    // 需要签名时交给上游补签（模块自己不持有 HMAC key）
    if (cfg.signer === 'upstream' && cfg.signerBase) {
      var signed;
      try {
        signed = await Widget.http.post(cfg.signerBase + '/sign', { url: url, ts: now() });
      } catch (e) {
        return { ok: false, err: 'SIGNER_FAIL ' + (e && e.message ? e.message : e) };
      }
      if (signed && signed.statusCode === 200 && signed.data) {
        try {
          var d = typeof signed.data === 'string' ? JSON.parse(signed.data) : signed.data;
          if (d && d.url) finalUrl = d.url;
        } catch (e2) { return { ok: false, err: 'SIGNER_BAD_JSON' }; }
      } else {
        return { ok: false, err: 'SIGNER_HTTP_' + (signed && signed.statusCode) };
      }
    } else if (cfg.signer === 'none') {
      return { ok: false, err: 'NO_SIGNER' };
    }

    var resp;
    try {
      resp = await Widget.http.get(finalUrl, {
        headers: {
          'X-App-Version': '3.9.2.5',
          'X-App-Source': 'android',
          'Accept': 'application/json, text/plain, */*',
          'User-Agent': 'Dalvik/2.1.0 (Linux; U; Android 17)'
        }
      });
    } catch (e) {
      return { ok: false, err: 'HTTP_ERR ' + (e && e.message ? e.message : e) };
    }
    if (!resp) return { ok: false, err: 'NO_RESP' };
    if (resp.statusCode !== 200) return { ok: false, err: 'HTTP_' + resp.statusCode };
    var body = resp.data;
    if (!body) return { ok: false, err: 'EMPTY_BODY' };
    if (typeof body === 'string') {
      try { body = JSON.parse(body); } catch (e) { return { ok: false, err: 'BAD_JSON' }; }
    }
    return { ok: true, data: body };
  }

  // ========== 缓存 ==========
  function cacheGet(k) {
    try {
      var all = JSON.parse(Widget.storage.get(STORE_KEY) || '{}');
      var e = all[k];
      if (e && (now() - e.t) < TTL_MS) return e.v;
    } catch (err) {}
    return null;
  }
  function cacheSet(k, v) {
    try {
      var all = JSON.parse(Widget.storage.get(STORE_KEY) || '{}');
      all[k] = { t: now(), v: v };
      var keys = Object.keys(all);
      if (keys.length > MAX_CACHE) {
        keys.sort(function (a, b) { return all[a].t - all[b].t; });
        while (keys.length > MAX_CACHE) delete all[keys.shift()];
      }
      Widget.storage.set(STORE_KEY, JSON.stringify(all));
    } catch (err) {}
  }

  // ========== 模块入口 ==========
  async function loadHome(page) {
    var cfg = getConfig();
    var offset = (page || 0) * 30;
    var ck = 'home_' + offset;
    var cached = cacheGet(ck);
    if (cached) return cached;

    if (!baseUrl(cfg) || cfg.signer === 'none') {
      return {
        rooms: [], hasMore: false, err: 'NO_ENDPOINT',
        hint: '未配置接入地址或签名服务：' +
          (baseUrl(cfg) ? '' : '缺 endpoint；') +
          (cfg.signer === 'none' ? '缺 signer；' : '')
      };
    }

    var url = buildListUrl(cfg, 1, offset, cfg.cursorR || '');
    var r = await httpGetJson(url, cfg);
    if (!r.ok) {
      return { rooms: [], hasMore: false, err: r.err, hint: degrade(r.err) };
    }
    var parsed = parseListResponse(r.data);
    if (!parsed.err) cacheSet(ck, parsed);
    return parsed;
  }

  function degrade(err) {
    if (!err) return '';
    if (err.indexOf('NO_SIGNER') >= 0) return '未配置签名服务（signplus 需 HMAC 密钥，Rex 无法本地算）';
    if (err.indexOf('NO_ENDPOINT') >= 0) return '未配置接入地址';
    if (err.indexOf('HTTP_401') >= 0 || err.indexOf('HTTP_403') >= 0) return '鉴权失效，需重新登录取 token';
    if (err.indexOf('CODE_') >= 0) return '业务错误：' + err;
    if (err.indexOf('BAD_JSON') >= 0) return '返回非 JSON（可能被拦截）';
    return err;
  }

  // ========== Rex 导出 ==========
  return {
    id: MODULE_ID,
    name: '探他',
    // 列表页
    async loadHome(page) {
      var res = await loadHome(page || 0);
      if (res.err) {
        return {
          items: [],
          hint: '⚠️ ' + (res.hint || res.err),
          hasMore: false
        };
      }
      var items = res.rooms.map(function (r) {
        var tag = r.paid ? ('💰' + r.cost + '币') : '免费';
        return {
          id: r.id,
          title: '[' + tag + '] ' + r.name,
          subtitle: r.title,
          image: r.thumb || r.avatar,
          meta: { viewers: r.viewers, stream: r.stream, uid: r.uid }
        };
      });
      return { items: items, hasMore: res.hasMore, revision: res.revision };
    },

    // 详情页
    async loadDetail(item) {
      if (!item || !item.id) return { title: '加载失败', description: '无房间信息' };
      var cfg = getConfig();
      return {
        title: item.title || item.id,
        description: [
          '房间：' + item.id,
          '主播：' + (item.meta && item.meta.uid ? item.meta.uid : ''),
          '观众：' + (item.meta && item.meta.viewers ? item.meta.viewers : 0),
          '推流：' + (item.meta && item.meta.stream ? item.meta.stream : '')
        ].join('\n')
      };
    },

    // 配置读写
    async setConfig(cfgStr) {
      Widget.storage.set('tanta10_cfg', cfgStr || '{}');
      return '配置已保存';
    },
    async getConfig() { return Widget.storage.get('tanta10_cfg') || '{}'; },

    // 调试
    async debugState() {
      var cfg = getConfig();
      return 'mode=' + (cfg.mode || '未设置') +
        ' port=' + cfg.port +
        ' host=' + (cfg.host || '未设置') +
        ' signer=' + cfg.signer;
    }
  };
})();