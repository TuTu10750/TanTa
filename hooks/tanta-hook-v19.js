// tanta-hook-v19.js —— 专抓「游客注册 / VIP 身份」相关
// 目的：找出 App 首次启动时，哪个接口决定了「我是不是 VIP」
//       以及请求里有没有可伪造的 role/vip/grade 参数
//
// 用法：frida -U -p <PID> -l D:\浏览器\tanta-hook-v19.js
//   然后【彻底杀掉 App，重新打开】（不是切后台）
//   等进首页后，输：showStartup()

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    const startup = [];      // 启动/注册相关请求
    const vipHits = [];      // 带 vip/role/grade 的请求或返回
    const allSvc = {};
    const respBuf = [];      // 所有返回，用于事后挖

    function nowStr() {
      const d = new Date();
      return d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
    }

    // ---------- 1. 抓所有 URL 请求 ----------
    function handleUrl(s) {
      try {
        const m = s.match(/service=([A-Za-z0-9_.]+)/);
        if (!m) return;
        const svc = m[1];
        allSvc[svc] = (allSvc[svc] || 0) + 1;

        // 启动/注册类
        if (/Auth|Login|Register|Guest|User\.(?:info|index|reg)|Config|Version|Init|Start/i.test(svc)) {
          startup.push({ t: nowStr(), svc: svc, url: s });
          console.log('[START] ' + svc + '  ' + s.substring(s.indexOf('?') + 1, 300));
        }

        // 带可疑参数的
        const q = s.indexOf('?') >= 0 ? s.substring(s.indexOf('?') + 1) : '';
        const mRole = q.match(/(?:^|&)(role|isvip|is_vip|vip|grade|level|usertype|user_type|type)=([^&]*)/);
        if (mRole) {
          vipHits.push('REQ ' + svc + ' ' + mRole[1] + '=' + mRole[2]);
          console.log('[VIP-PARAM] ' + svc + '  ' + mRole[1] + '=' + mRole[2]);
        }
      } catch (e) {}
    }

    try {
      const URL = Java.use('java.net.URL');
      URL.openConnection.overload().implementation = function () {
        try { handleUrl(this.toString()); } catch (e) {}
        return this.openConnection();
      };
      console.log('[hook] URL.openConnection');
    } catch (e) { console.log('[skip] URL: ' + e); }

    // ---------- 2. 抓所有返回，找 vip 字段 ----------
    function handleResp(text, src) {
      try {
        if (!text || text.length < 10 || text.length > 200000) return;
        respBuf.push({ t: nowStr(), src: src, text: text });
        if (respBuf.length > 80) respBuf.shift();

        // 找 VIP 相关字段
        const re = /"(isvip|is_vip|vip|vip_level|vip_expire|vip_expire_time|role|grade|user_type|usertype)"\s*:\s*("?[^",}]*"?)/g;
        let m;
        let found = [];
        while ((m = re.exec(text)) !== null) {
          found.push(m[1] + '=' + m[2]);
        }
        if (found.length) {
          const line = 'RESP ' + found.join(' ');
          if (vipHits.indexOf(line) < 0) {
            vipHits.push(line);
            console.log('[VIP-RESP] ' + found.join(' '));
          }
        }
      } catch (e) {}
    }

    try {
      const JSON = Java.use('com.alibaba.fastjson.JSON');
      const po = JSON.parseObject.overload('java.lang.String');
      po.implementation = function (text) {
        try { handleResp(text, 'parseObject'); } catch (e) {}
        return po.call(this, text);
      };
      const pa = JSON.parseArray.overload('java.lang.String');
      pa.implementation = function (text) {
        try { handleResp(text, 'parseArray'); } catch (e) {}
        return pa.call(this, text);
      };
      console.log('[hook] fastjson');
    } catch (e) { console.log('[skip] fastjson: ' + e); }

    // ---------- 3. 抓 UserBean / 本地存储里的 VIP 字段 ----------
    try {
      const UserBean = Java.use('com.yunbao.common.bean.UserBean');
      const fields = ['getIsVip', 'getVip', 'getRole', 'getGrade', 'getUserType', 'getLevel'];
      fields.forEach(function (fn) {
        try {
          if (UserBean[fn]) {
            console.log('[UserBean] 有方法 ' + fn);
          }
        } catch (e) {}
      });
    } catch (e) { console.log('[skip] UserBean: ' + e); }

    // ---------- 输出 ----------
    globalThis.showStartup = function () {
      console.log('\n########## 启动/注册请求 ##########');
      if (!startup.length) { console.log('(没抓到，App 可能没重启)'); }
      startup.forEach(function (s, i) {
        console.log('[' + i + '] ' + s.t + '  ' + s.svc);
        console.log('    ' + s.url.substring(0, 500));
      });

      console.log('\n########## VIP 相关字段 ##########');
      if (!vipHits.length) { console.log('(没找到任何 vip/role/grade 字段)'); }
      Array.from(new Set(vipHits)).slice(0, 30).forEach(function (h) { console.log('  ' + h); });

      console.log('\n########## 全部 service ##########');
      Object.keys(allSvc).sort().forEach(function (k) { console.log('  ' + k + '  x' + allSvc[k]); });
      console.log('##########################\n');
    };

    globalThis.showStartResp = function () {
      console.log('\n########## 启动阶段返回（前10条）##########');
      respBuf.slice(0, 10).forEach(function (r, i) {
        console.log('\n--- [' + i + '] ' + r.t + ' ' + r.src + ' len=' + r.text.length + ' ---');
        console.log(r.text.substring(0, 1200));
      });
      console.log('##########################\n');
    };

    console.log('[info] v19 loaded');
    console.log('[info] 现在【彻底杀掉 App 再重开】');
    console.log('[info] 进首页后输：showStartup()  然后 showStartResp()');
  });
}