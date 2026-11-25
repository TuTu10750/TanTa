// tanta-hook-v22.js —— 反向验证 H1：现在免费时段，把时间戳伪造成 VIP 时段，看是否被拒
//
// 逻辑：
//   对照组 = 真实时间戳（现在 13:06，免费时段）→ 应该能看
//   实验组 = 伪造成 22:00（VIP 时段）→ 若被拒 40018，则证明服务端信客户端时间戳
//
// 用法：
//   frida -U -p <PID> -l D:\浏览器\tanta-hook-v22.js
//
//   第一步（对照）：直接点一个免费房 → 记录 showEntry() 的 code
//   第二步（实验）：fakeHour(22, 0) → 再点同一个免费房 → 看是否弹 VIP
//   第三步：fakeNow() 恢复
//
// 命令：
//   showHeaders()   看 App 都设置了哪些 header（确认 timestamp 走哪条路）
//   showLog()       看改写记录
//   showEntry()     看响应码
//   fakeHour(22,0)  伪造时间戳
//   fakeNow()       恢复

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    var fakeTs = null;
    var fakeLabel = '';
    var rewriteLog = [];
    var headerLog = [];
    var entryResp = [];
    var MAX = 300;

    function ts() {
      var d = new Date();
      function p(n) { return n < 10 ? '0' + n : '' + n; }
      return p(d.getHours()) + ':' + p(d.getMinutes()) + ':' + p(d.getSeconds());
    }
    function push(arr, s) {
      if (arr.length >= MAX) arr.shift();
      arr.push(ts() + ' ' + s);
    }
    function makeTs(hour, minute) {
      var d = new Date();
      d.setHours(hour, minute || 0, 0, 0);
      return Math.floor(d.getTime() / 1000);
    }

    // ============ 1. 通用 header 记录 + 改写 ============
    function hookSetProp(className, methodName, label) {
      try {
        var C = Java.use(className);
        if (!C[methodName]) return;
        var m = C[methodName];
        m.implementation = function (key, value) {
          try {
            var k = String(key);
            push(headerLog, label + ' ' + k + ' = ' + String(value).substring(0, 80));
            if (k.toLowerCase() === 'timestamp' && fakeTs) {
              push(rewriteLog, label + ' 改写 ' + value + ' → ' + fakeTs + ' [' + fakeLabel + ']');
              console.log('[TS-REWRITE] ' + label + ': ' + value + ' → ' + fakeTs);
              return m.call(this, key, String(fakeTs));
            }
          } catch (e) {}
          return m.call(this, key, value);
        };
        console.log('[hook] ' + className + '.' + methodName);
      } catch (e) { console.log('[skip] ' + className + ': ' + e); }
    }

    hookSetProp('java.net.URLConnection', 'setRequestProperty', 'URLConnection');
    hookSetProp('java.net.HttpURLConnection', 'setRequestProperty', 'HttpURLConnection');
    hookSetProp('okhttp3.Request$Builder', 'header', 'okhttp.header');
    hookSetProp('okhttp3.Request$Builder', 'addHeader', 'okhttp.addHeader');

    // okhttp3.Headers$Builder.add
    try {
      var HB = Java.use('okhttp3.Headers$Builder');
      var add = HB.add;
      add.implementation = function (key, value) {
        try {
          var k = String(key);
          push(headerLog, 'HeadersBuilder ' + k + ' = ' + String(value).substring(0, 80));
          if (k.toLowerCase() === 'timestamp' && fakeTs) {
            push(rewriteLog, 'HeadersBuilder 改写 ' + value + ' → ' + fakeTs);
            console.log('[TS-REWRITE] HeadersBuilder: ' + value + ' → ' + fakeTs);
            return add.call(this, key, String(fakeTs));
          }
        } catch (e) {}
        return add.call(this, key, value);
      };
      console.log('[hook] okhttp3.Headers$Builder.add');
    } catch (e) { console.log('[skip] HeadersBuilder: ' + e); }

    // ============ 2. 抓请求 URL ============
    try {
      var URL = Java.use('java.net.URL');
      URL.openConnection.overload().implementation = function () {
        try {
          var u = this.toString();
          if (u.indexOf('/appapi/') >= 0) {
            var m = u.match(/service=([A-Za-z0-9_.]+)/);
            if (m) {
              var svc = m[1];
              console.log('[REQ] ' + svc);
              push(entryResp, 'REQ ' + svc);
            }
          }
        } catch (e) {}
        return this.openConnection();
      };
      console.log('[hook] URL.openConnection');
    } catch (e) {}

    // ============ 3. 抓响应码 ============
    function watchResp(text, src) {
      try {
        if (!text || text.length < 15) return;
        var mc = text.match(/"code"\s*:\s*(-?\d+)/);
        if (!mc) return;
        var code = mc[1];
        var tag = '?';
        if (text.indexOf('"fail_msg"') >= 0) tag = 'FAIL-40018?';
        else if (text.indexOf('"stream"') >= 0 && text.indexOf('"live_platform"') >= 0) tag = 'ROOM-OK';
        else if (text.indexOf('"vip"') >= 0) tag = 'VIP-INFO';
        else if (text.indexOf('"list"') >= 0) tag = 'LIST';
        else if (text.indexOf('"coin"') >= 0) tag = 'CHARGE?';

        var line = src + ' ' + tag + ' code=' + code + ' len=' + text.length;
        push(entryResp, line);
        console.log('[RESP] ' + tag + ' code=' + code + ' len=' + text.length);

        if (code === '0' && text.length < 5000 && (tag === 'ROOM-OK' || tag === 'FAIL-40018?')) {
          console.log('===== code=0 完整响应 =====');
          console.log(text);
          console.log('===== end =====');
        }
        if (code === '40018') {
          console.log('===== 40018 完整响应 =====');
          console.log(text.substring(0, 1500));
          console.log('===== end =====');
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
        try { watchResp(text, 'fastjson-arr'); } catch (e) {}
        return pa.call(this, text);
      };
      console.log('[hook] fastjson');
    } catch (e) { console.log('[skip] fastjson: ' + e); }

    // ============ 输出命令 ============
    globalThis.fakeHour = function (hour, minute) {
      fakeTs = makeTs(hour, minute || 0);
      fakeLabel = hour + ':' + (minute || 0);
      var dt = new Date(fakeTs * 1000);
      console.log('[TS] 启用伪装 ' + dt.toString() + '  ts=' + fakeTs);
      console.log('[TS] 现在去点一个【免费房】，看是否弹 VIP');
    };

    globalThis.fakeNow = function () {
      fakeTs = null;
      fakeLabel = '';
      console.log('[TS] 已恢复真实时间戳');
    };

    globalThis.showHeaders = function () {
      console.log('\n########## Header 记录（最近 30 条）##########');
      if (!headerLog.length) {
        console.log('（没有记录——App 可能不走标准 header API）');
      }
      headerLog.slice(-30).forEach(function (l) { console.log('  ' + l); });
      console.log('##############################################\n');
    };

    globalThis.showLog = function () {
      console.log('\n########## 时间戳改写 ##########');
      if (!rewriteLog.length) console.log('（没有改写——说明 App 没走这些 API，或没触发）');
      rewriteLog.slice(-20).forEach(function (l) { console.log('  ' + l); });
      console.log('################################\n');
    };

    globalThis.showEntry = function () {
      console.log('\n########## 请求/响应记录 ##########');
      if (!entryResp.length) console.log('（没抓到）');
      entryResp.slice(-40).forEach(function (l) { console.log('  ' + l); });
      console.log('##################################\n');
    };

    globalThis.showAll = function () { showEntry(); showLog(); showHeaders(); };

    console.log('[info] v22 loaded');
    console.log('[info] 步骤：1) 直接点免费房(对照)  2) fakeHour(22,0) 再点同一个房(实验)');
    console.log('[info] 随时可输：showEntry() / showLog() / showHeaders()');
  });
}