// tanta-hook-v16.js —— 两条腿一起走
// A 线：改 X-App-Version 试版本豁免（脚本自动改 header，你不用手动改）
// B 线：抓 VOD/录像接口，看付费时段录像是否还能看
//
// 用法：frida -U -p <PID> -l D:\浏览器\tanta-hook-v16.js
//   然后：resetVer()            回到真实版本
//         tryVer('3.9.0')       试某个版本号
//         tryVer('3.8.5')       再试一个
//         showVod()             看抓到的录像接口
//         showAll()             看全部 service 统计
//         showResp()            看最近几条返回

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    // ========== A 线：版本号伪装 ==========
    let verOverride = null;              // null = 用真实版本
    const REAL_VER = '3.9.2.5';

    try {
      const HashMap = Java.use('java.util.HashMap');
      const URL = Java.use('java.net.URL');

      // 在 openConnection 返回的 HttpURLConnection 上改 header
      URL.openConnection.overload().implementation = function () {
        const conn = this.openConnection();
        try {
          const s = this.toString();
          if (/\/appapi\//.test(s)) {
            const v = verOverride || REAL_VER;
            conn.setRequestProperty('X-App-Version', v);
            if (verOverride) console.log('[VER] 已伪装 X-App-Version = ' + v);
          }
        } catch (e) {}
        return conn;
      };
      console.log('[hook] URL.openConnection (版本伪装已挂)');
    } catch (e) { console.log('[skip] 版本伪装: ' + e); }

    // okhttp 路径也改
    try {
      const ReqBuilder = Java.use('okhttp3.Request$Builder');
      const orig = ReqBuilder.header;
      ReqBuilder.header.implementation = function (name, value) {
        try {
          if (verOverride && String(name).toLowerCase() === 'x-app-version') {
            console.log('[VER] okhttp header 伪装 = ' + verOverride);
            return orig.call(this, name, verOverride);
          }
        } catch (e) {}
        return orig.call(this, name, value);
      };
      console.log('[hook] okhttp3.Request$Builder.header');
    } catch (e) { console.log('[skip] okhttp header: ' + e); }

    globalThis.resetVer = function () { verOverride = null; console.log('[VER] 恢复真实版本 ' + REAL_VER); };
    globalThis.tryVer = function (v) { verOverride = String(v); console.log('[VER] 从下一次请求开始伪装为 ' + v + '（现在去点一个房）'); };

    // ========== B 线：抓 VOD / 录像 / 全部 service ==========
    const allServices = {};
    const vodCalls = [];
    const respTexts = [];

    try {
      const URL2 = Java.use('java.net.URL');
      URL2.openConnection.overload().implementation = function () {
        try {
          const s = this.toString();
          const m = s.match(/service=([A-Za-z0-9_.]+)/);
          if (m) {
            const svc = m[1];
            allServices[svc] = (allServices[svc] || 0) + 1;
            // VOD / 录像相关
            if (/Video|Vod|Record|video|record|history|replay/i.test(svc)) {
              vodCalls.push({ service: svc, url: s, t: Date.now() });
              console.log('[VOD] ' + svc + '  ' + s.substring(0, 240));
            }
          }
        } catch (e) {}
        return this.openConnection();
      };
    } catch (e) {}

    try {
      const J = Java.use('com.alibaba.fastjson.JSON');
      const po = J.parseObject.overload('java.lang.String');
      po.implementation = function (text) {
        try {
          if (text && text.length > 20 && text.length < 60000) {
            respTexts.push(text);
            if (respTexts.length > 60) respTexts.shift();
            // 找 m3u8 / flv
            const m3 = text.match(/(https?:\/\/[^\s"\\]{10,}\.m3u8[^\s"\\]*)/);
            if (m3) console.log('[PLAY] ' + m3[1].replace(/\\\//g, '/'));
            // 录像字段
            if (/"videos?"|"records?"|"replay"/i.test(text)) {
              console.log('[VOD-RESP] 发现录像字段，长度=' + text.length);
            }
          }
        } catch (e) {}
        return po.call(this, text);
      };
      const pa = J.parseArray.overload('java.lang.String');
      pa.implementation = function (text) {
        try {
          if (text && text.length > 20 && text.length < 60000) {
            respTexts.push(text);
            if (respTexts.length > 60) respTexts.shift();
            const m3 = text.match(/(https?:\/\/[^\s"\\]{10,}\.m3u8[^\s"\\]*)/);
            if (m3) console.log('[PLAY] ' + m3[1].replace(/\\\//g, '/'));
          }
        } catch (e) {}
        return pa.call(this, text);
      };
      console.log('[hook] fastjson');
    } catch (e) { console.log('[skip] fastjson: ' + e); }

    // ========== 输出 ==========
    globalThis.showAll = function () {
      console.log('\n########## 全部 service ##########');
      const keys = Object.keys(allServices).sort();
      if (!keys.length) { console.log('(空，先操作 App)'); return; }
      keys.forEach(function (k) { console.log('  ' + k + '  x' + allServices[k]); });
      console.log('############### 共 ' + keys.length + ' 个 ###############\n');
    };

    globalThis.showVod = function () {
      console.log('\n########## VOD / 录像请求 ##########');
      if (!vodCalls.length) { console.log('(没抓到录像请求，去主播主页看看)'); return; }
      vodCalls.forEach(function (v, i) { console.log('[' + i + '] ' + v.url.substring(0, 400)); });
      console.log('########## 共 ' + vodCalls.length + ' 条 ##########\n');
    };

    globalThis.showResp = function (idx) {
      const i = (idx == null) ? (respTexts.length - 1) : idx;
      const t = respTexts[i];
      if (!t) { console.log('没有第 ' + i + ' 条（共 ' + respTexts.length + ' 条）'); return; }
      console.log('\n===== RESP[' + i + '] len=' + t.length + ' =====');
      console.log(t.substring(0, 3500));
      console.log('=====\n');
    };

    console.log('[info] v16 loaded');
    console.log('[info] A 线：tryVer("3.9.0") 然后点房；resetVer() 恢复');
    console.log('[info] B 线：去主播主页/录像页逛一圈，然后 showVod()');
  });
}