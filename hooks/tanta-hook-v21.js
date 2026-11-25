// tanta-hook-v21.js —— 验证 H1：时段锁是否依赖客户端上报的 header timestamp
//
// 背景：请求结构里 signplus 在 URL 参数、timestamp 在 HTTP header，二者物理分离
// 假设：服务端用 header timestamp 判断时段，signplus 不覆盖 header
//
// 用法：
//   frida -U -p <PID> -l D:\浏览器\tanta-hook-v21.js
//   fakeHour(19, 30)     → 把 timestamp 伪装成 19:30 的秒数（免费时段边缘）
//   fakeHour(12, 0)      → 伪装成 12:00
//   fakeNow()            → 恢复真实时间戳
//   showLog()            → 看改写记录
//   showEntry()          → 看 checkLive 返回码
//
// 判定：
//   返回 code=0        → H1 成立，时段锁靠 header timestamp
//   仍返回 40018       → 服务端用自己的时间
//   返回签名/参数错误   → timestamp 参与签名

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    var fakeTs = null;          // 伪装的时间戳（秒）
    var fakeLabel = '';
    var rewriteLog = [];
    var entryResp = [];
    var MAX = 200;

    function ts() {
      var d = new Date();
      function p(n) { return n < 10 ? '0' + n : '' + n; }
      return p(d.getHours()) + ':' + p(d.getMinutes()) + ':' + p(d.getSeconds());
    }

    function log(s) {
      if (rewriteLog.length >= MAX) rewriteLog.shift();
      rewriteLog.push(ts() + ' ' + s);
      console.log('[TS] ' + s);
    }

    // 计算「今天某时某分」的秒级时间戳
    function makeTs(hour, minute) {
      var d = new Date();
      d.setHours(hour, minute || 0, 0, 0);
      return Math.floor(d.getTime() / 1000);
    }

    // ---------- 1. HttpURLConnection.setRequestProperty ----------
    try {
      var HUC = Java.use('java.net.HttpURLConnection');
      var setRP = HUC.setRequestProperty;
      setRP.implementation = function (key, value) {
        try {
          var k = String(key).toLowerCase();
          if (k === 'timestamp' && fakeTs) {
            log('改写 ' + key + ': ' + value + ' → ' + fakeTs + ' (' + fakeLabel + ')');
            return setRP.call(this, key, String(fakeTs));
          }
        } catch (e) {}
        return setRP.call(this, key, value);
      };
      console.log('[hook] HttpURLConnection.setRequestProperty');
    } catch (e) { console.log('[skip] HttpURLConnection: ' + e); }

    // ---------- 2. okhttp3.Request.Builder.header / addHeader ----------
    try {
      var RB = Java.use('okhttp3.Request$Builder');
      var h1 = RB.header;
      h1.implementation = function (key, value) {
        try {
          if (String(key).toLowerCase() === 'timestamp' && fakeTs) {
            log('okhttp header 改写: ' + value + ' → ' + fakeTs);
            return h1.call(this, key, String(fakeTs));
          }
        } catch (e) {}
        return h1.call(this, key, value);
      };
      if (RB.addHeader) {
        var h2 = RB.addHeader;
        h2.implementation = function (key, value) {
          try {
            if (String(key).toLowerCase() === 'timestamp' && fakeTs) {
              log('okhttp addHeader 改写: ' + value + ' → ' + fakeTs);
              return h2.call(this, key, String(fakeTs));
            }
          } catch (e) {}
          return h2.call(this, key, value);
        };
      }
      console.log('[hook] okhttp3.Request$Builder.header/addHeader');
    } catch (e) { console.log('[skip] okhttp: ' + e); }

    // ---------- 3. 观察 checkLive 响应码 ----------
    function watchResp(text, src) {
      try {
        if (!text || text.length < 20) return;
        var mc = text.match(/"code"\s*:\s*(-?\d+)/);
        var mr = text.match(/"ret"\s*:\s*(-?\d+)/);
        if (!mc && !mr) return;
        var code = mc ? mc[1] : ('ret=' + mr[1]);
        var tag = '';
        if (text.indexOf('"fail_msg"') >= 0) tag = 'FAIL';
        else if (text.indexOf('"stream"') >= 0) tag = 'ROOM-OK';
        else if (text.indexOf('"vip"') >= 0) tag = 'VIP-INFO';
        if (tag) {
          var rec = ts() + ' [' + src + '] ' + tag + ' code=' + code + ' len=' + text.length;
          if (entryResp.length >= MAX) entryResp.shift();
          entryResp.push(rec);
          console.log('[RESP] ' + tag + ' code=' + code + ' len=' + text.length);
          if (code === '0' && text.length < 6000) {
            console.log('--- code=0 完整响应 ---');
            console.log(text);
            console.log('--- end ---');
          }
        }
      } catch (e) {}
    }

    try {
      var JSON = Java.use('com.alibaba.fastjson.JSON');
      var po = JSON.parseObject.overload('java.lang.String');
      po.implementation = function (text) {
        try { watchResp(text, 'fastjson'); } catch (e) {}
        return po.call(this, text);
      };
      var pa = JSON.parseArray.overload('java.lang.String');
      pa.implementation = function (text) {
        try { watchResp(text, 'fastjson-array'); } catch (e) {}
        return pa.call(this, text);
      };
      console.log('[hook] fastjson');
    } catch (e) { console.log('[skip] fastjson: ' + e); }

    // ---------- 输出 ----------
    globalThis.fakeHour = function (hour, minute) {
      fakeTs = makeTs(hour, minute || 0);
      fakeLabel = hour + ':' + (minute || 0);
      var dt = new Date(fakeTs * 1000);
      console.log('[TS] 已启用伪装：' + dt.toString() + '  ts=' + fakeTs);
      console.log('[TS] 现在去点一个房，观察返回码');
    };

    globalThis.fakeNow = function () {
      fakeTs = null;
      fakeLabel = '';
      console.log('[TS] 已恢复真实时间戳');
    };

    globalThis.showLog = function () {
      console.log('\n########## 时间戳改写记录 ##########');
      if (!rewriteLog.length) console.log('（没有改写——可能 App 不走这两个 API，或没触发请求）');
      rewriteLog.slice(-40).forEach(function (l) { console.log('  ' + l); });
      console.log('####################################\n');
    };

    globalThis.showEntry = function () {
      console.log('\n########## 响应码记录 ##########');
      if (!entryResp.length) console.log('（没抓到）');
      entryResp.slice(-20).forEach(function (l) { console.log('  ' + l); });
      console.log('##############################\n');
    };

    console.log('[info] v21 loaded');
    console.log('[info] 命令：fakeHour(19,30)  /  fakeHour(12,0)  /  fakeNow()');
    console.log('[info] 然后点房，输 showEntry() 看返回码');
  });
}