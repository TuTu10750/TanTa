// tanta-hook-v15.js —— 专抓「进房」请求，看清付费校验参数
// 目的：点开一个 type=2（付费）的房，抓出：
//   1. 请求了哪些 service
//   2. 完整 query 参数（看有没有 is_vip/type/level/paid 这类自报字段）
//   3. 请求体（POST 的话）
//   4. 返回内容（看服务端给不给播放地址）
//   5. 响应里的播放 URL（hls / m3u8 / pull / playurl）
// 用法：frida -U -p <PID> -l tanta-hook-v15.js
//   ！！！先点一个付费房，再点一个免费房做对照！！！
//   然后输：showRoom() / showPay()

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    const roomCalls = [];   // 进房相关请求
    const allServices = {};
    const payHints = [];    // 疑似付费字段
    const MAX = 80;

    function pushRoom(rec) {
      if (roomCalls.length >= MAX) return;
      roomCalls.push(rec);
      console.log('[ROOM] ' + rec.service + '  params=' + (rec.params || '').substring(0, 300));
    }

    // ---------- 抓 URL：全量记录 service + 完整参数 ----------
    try {
      const URL = Java.use('java.net.URL');
      URL.openConnection.overload().implementation = function () {
        try {
          const s = this.toString();
          if (/\/appapi\/|service=/i.test(s)) {
            const m = s.match(/service=([A-Za-z0-9_.]+)/);
            const svc = m ? m[1] : '?';
            allServices[svc] = (allServices[svc] || 0) + 1;
            const qIdx = s.indexOf('?');
            const params = qIdx >= 0 ? s.substring(qIdx + 1) : '';
            // 只记录进房/付费相关的
            if (/Live\.|Room\.|checkLive|enterRoom|charge|pay|vip|paid|buy|order/i.test(svc) ||
                /liveuid=|roomid=|room_id=/.test(params)) {
              pushRoom({ service: svc, params: params, url: s, t: Date.now() });
              // 找可疑自报字段
              ['is_vip', 'isvip', 'vip', 'type', 'level', 'paid', 'noble', 'is_paid', 'role', 'grade'].forEach(function (k) {
                const re = new RegExp('(?:^|&)' + k + '=([^&]*)');
                const mm = params.match(re);
                if (mm) payHints.push(k + '=' + mm[1] + '  @' + svc);
              });
            }
          }
        } catch (e) {}
        return this.openConnection();
      };
      console.log('[hook] java.net.URL.openConnection');
    } catch (e) { console.log('[skip] URL: ' + e); }

    // ---------- 抓 POST 请求体 ----------
    try {
      const OkBody = Java.use('okhttp3.RequestBody');
      OkBody.writeTo.implementation = function (sink) {
        try {
          const s = this.toString();
          if (s && s.length > 2) {
            console.log('[POST-BODY] ' + s.substring(0, 600));
            if (/is_vip|vip|type|level|paid|uid/i.test(s)) {
              payHints.push('POST: ' + s.substring(0, 400));
            }
          }
        } catch (e) {}
        return this.writeTo(sink);
      };
      console.log('[hook] okhttp3.RequestBody.writeTo');
    } catch (e) { console.log('[skip] RequestBody: ' + e); }

    // ---------- 抓返回：快照所有 parse（含进房返回）----------
    const respTexts = [];
    try {
      const JSON = Java.use('com.alibaba.fastjson.JSON');
      const p1 = JSON.parseObject.overload('java.lang.String');
      p1.implementation = function (text) {
        try {
          if (text && text.length > 20 && text.length < 40000) {
            respTexts.push(text);
            if (respTexts.length > 40) respTexts.shift();
            // 找播放地址
            const play = extractPlay(text);
            if (play) console.log('[PLAY-URL] ' + play);
          }
        } catch (e) {}
        return p1.call(this, text);
      };
      const p2 = JSON.parseArray.overload('java.lang.String');
      p2.implementation = function (text) {
        try {
          if (text && text.length > 20 && text.length < 40000) {
            respTexts.push(text);
            if (respTexts.length > 40) respTexts.shift();
            const play = extractPlay(text);
            if (play) console.log('[PLAY-URL] ' + play);
          }
        } catch (e) {}
        return p2.call(this, text);
      };
      console.log('[hook] fastjson parseObject/parseArray');
    } catch (e) { console.log('[skip] fastjson: ' + e); }

    function extractPlay(s) {
      // 常见字段：hls / m3u8 / pull / playurl / play_url / live_url / stream_url
      const keys = ['hls', 'm3u8', 'pull', 'playurl', 'play_url', 'playurl_hd', 'live_url', 'stream_url', 'url'];
      for (let i = 0; i < keys.length; i++) {
        const re = new RegExp('"' + keys[i] + '"\\s*:\\s*"([^"]{10,})"');
        const m = s.match(re);
        if (m && /\.m3u8|\.flv|https?:\/\//.test(m[1])) {
          return m[1].replace(/\\\//g, '/');
        }
      }
      // 兜底：直接找 m3u8
      const m2 = s.match(/(https?:\/\/[^\s"\\]{10,}\.m3u8[^\s"\\]*)/);
      return m2 ? m2[1] : null;
    }

    // ============ 输出 ============
    globalThis.showRoom = function () {
      console.log('\n########## 进房请求 ##########');
      if (!roomCalls.length) { console.log('(没抓到，先点一个付费房)'); return; }
      roomCalls.forEach(function (r, i) {
        console.log('\n--- [' + i + '] ' + r.service + ' ---');
        console.log(r.url.substring(0, 800));
        const m = r.params.match(/signplus=([0-9a-f]+)/);
        if (m) console.log('  signplus=' + m[1]);
      });
      console.log('\n########## 全部 service ##########');
      Object.keys(allServices).sort().forEach(function (k) { console.log('  ' + k + '  x' + allServices[k]); });
      console.log('##########################\n');
    };

    globalThis.showPay = function () {
      console.log('\n########## 疑似付费字段 ##########');
      if (!payHints.length) { console.log('(没找到自报字段，说明可能全靠签名保护)'); return; }
      Array.from(new Set(payHints)).slice(0, 40).forEach(function (h) { console.log('  ' + h); });
      console.log('##########################\n');
    };

    globalThis.showResp = function (idx) {
      const i = (idx == null) ? (respTexts.length - 1) : idx;
      const t = respTexts[i];
      if (!t) { console.log('[showResp] 没有第 ' + i + ' 条'); return; }
      console.log('\n===== RESP[' + i + '] len=' + t.length + ' =====');
      console.log(t.substring(0, 4000));
      console.log('===== 共有 ' + respTexts.length + ' 条，showResp(0..' + (respTexts.length - 1) + ') =====\n');
    };

    console.log('[info] v15 loaded');
    console.log('[info] 现在去点【一个付费房】，再点【一个免费房】做对照');
    console.log('[info] 然后输：showRoom()  showPay()  showResp()');
  });
}