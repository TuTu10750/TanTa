// tanta-hook-v20.js —— 抓「成功进房全链路」，一个不漏
// 起因：v19 只 hook 了 fastjson + URL.openConnection，漏了 WebSocket / Gson / 其他 JSON 库
// 目标：在免费时段点一个免费房(type=0)，抓到：
//   1. checkLive 的完整成功返回（有没有 pull？）
//   2. enterRoomNew 的返回
//   3. timeCharge 的返回码
//   4. pull / hls / m3u8 / playurl 这些字段到底从哪个响应来
//
// 用法：
//   frida -U -p <PID> -l D:\浏览器\tanta-hook-v20.js
//   点一个【免费房】（type=0，列表里不带💰的）
//   showTimeline()   按时间顺序看请求-响应
//   showFields()     只看命中的字段(pull/m3u8/playurl)
//   showEntry()      只看 checkLive/enterRoom/timeCharge

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    var events = [];        // 时间线 {t, kind, detail}
    var fieldHits = [];     // 字段命中
    var entryCalls = [];    // 关键接口
    var MAX = 400;

    function ts() {
      var d = new Date();
      function p(n) { return n < 10 ? '0' + n : '' + n; }
      return p(d.getHours()) + ':' + p(d.getMinutes()) + ':' + p(d.getSeconds()) + '.' + (d.getMilliseconds());
    }

    function log(kind, detail) {
      if (events.length >= MAX) events.shift();
      events.push({ t: ts(), kind: kind, detail: detail });
      console.log('[' + kind + '] ' + detail);
    }

    // ---------- 字段扫描：找 pull / m3u8 / playurl ----------
    var FIELD_RE = /"(pull|hls|m3u8|playurl|play_url|live_url|stream_url|pull_url|pullUrl|flv)"\s*:\s*"([^"]{6,})"/g;
    var URL_RE = /(https?:\/\/[^\s"\\]{10,}\.(?:m3u8|flv|mp4)[^\s"\\]*)/g;

    function scanFields(text, src) {
      if (!text || text.length < 20) return;
      var m, found = [];
      FIELD_RE.lastIndex = 0;
      while ((m = FIELD_RE.exec(text)) !== null) {
        found.push(m[1] + ' = ' + m[2].substring(0, 200));
      }
      URL_RE.lastIndex = 0;
      while ((m = URL_RE.exec(text)) !== null) {
        found.push('URL: ' + m[1]);
      }
      if (found.length) {
        var rec = '[' + src + '] ' + found.join('  |  ');
        fieldHits.push(rec);
        console.log('[FIELD] ' + rec);
      }
    }

    // ---------- 关键接口识别 ----------
    var ENTRY = ['Live.checkLive', 'Live.enterRoomNew', 'Live.timeCharge', 'Live.roomCharge', 'Live.checkLiveing'];
    function isEntry(url) {
      for (var i = 0; i < ENTRY.length; i++) {
        if (url.indexOf(ENTRY[i]) >= 0) return ENTRY[i];
      }
      return null;
    }

    // ---------- 1. HTTP 请求 URL ----------
    try {
      var URL = Java.use('java.net.URL');
      URL.openConnection.overload().implementation = function () {
        try {
          var u = this.toString();
          var e = isEntry(u);
          if (e) {
            var q = u.indexOf('?') >= 0 ? u.substring(u.indexOf('?') + 1) : '';
            entryCalls.push({ t: ts(), dir: 'REQ', svc: e, detail: q });
            log('ENTRY-REQ', e + '  ' + q);
          } else if (u.indexOf('/appapi/') >= 0) {
            var m = u.match(/service=([A-Za-z0-9_.]+)/);
            if (m) log('REQ', m[1]);
          }
        } catch (ex) {}
        return this.openConnection();
      };
      console.log('[hook] java.net.URL.openConnection');
    } catch (e) { console.log('[skip] URL: ' + e); }

    // ---------- 2. fastjson ----------
    try {
      var JSON = Java.use('com.alibaba.fastjson.JSON');
      var po = JSON.parseObject.overload('java.lang.String');
      po.implementation = function (text) {
        try {
          scanFields(text, 'fastjson.parseObject');
          checkEntryResp(text);
        } catch (e) {}
        return po.call(this, text);
      };
      var pa = JSON.parseArray.overload('java.lang.String');
      pa.implementation = function (text) {
        try {
          scanFields(text, 'fastjson.parseArray');
          checkEntryResp(text);
        } catch (e) {}
        return pa.call(this, text);
      };
      console.log('[hook] fastjson parseObject/parseArray');
    } catch (e) { console.log('[skip] fastjson: ' + e); }

    // ---------- 3. Gson（v19 漏掉的） ----------
    try {
      var Gson = Java.use('com.google.gson.Gson');
      var fromJson = Gson.fromJson;
      if (fromJson && fromJson.overloads && fromJson.overloads.length) {
        var n = 0;
        fromJson.overloads.forEach(function (ov) {
          try {
            var sigs = ov.argumentTypes.map(function (t) { return t.className; }).join(',');
            if (sigs.indexOf('java.lang.String') >= 0) {
              ov.implementation = function () {
                var args = Array.prototype.slice.call(arguments);
                try {
                  for (var i = 0; i < args.length; i++) {
                    if (args[i] != null && typeof args[i] === 'string') {
                      scanFields(String(args[i]), 'gson.fromJson');
                      checkEntryResp(String(args[i]));
                    }
                  }
                } catch (e) {}
                return ov.apply(this, args);
              };
              n++;
            }
          } catch (e2) {}
        });
        console.log('[hook] Gson.fromJson (' + n + ' overloads)');
      }
    } catch (e) { console.log('[skip] Gson: ' + e + '（可能没装这个库）'); }

    // ---------- 4. okhttp 响应体 ----------
    try {
      var RB = Java.use('okhttp3.ResponseBody');
      if (RB.string) {
        RB.string.implementation = function () {
          var r = this.string();
          try {
            if (r && r.length > 20) {
              scanFields(r, 'okhttp.body');
              checkEntryResp(r);
            }
          } catch (e) {}
          return r;
        };
        console.log('[hook] okhttp3.ResponseBody.string');
      }
    } catch (e) { console.log('[skip] okhttp: ' + e); }

    // ---------- 5. WebSocket（v19 完全漏掉的） ----------
    try {
      var RWS = Java.use('okhttp3.internal.ws.RealWebSocket');
      var onMessage = RWS.onReadMessage;
      if (onMessage && onMessage.overloads) {
        onMessage.overloads.forEach(function (ov) {
          ov.implementation = function () {
            var args = Array.prototype.slice.call(arguments);
            try {
              for (var i = 0; i < args.length; i++) {
                if (args[i] != null) {
                  var s = null;
                  try { s = String(args[i]); } catch (e2) {}
                  if (s && s.length > 10 && s.length < 100000) {
                    log('WS-IN', s.substring(0, 300));
                    scanFields(s, 'websocket');
                  }
                }
              }
            } catch (e) {}
            return ov.apply(this, args);
          };
        });
        console.log('[hook] okhttp3 WebSocket.onReadMessage');
      }
    } catch (e) { console.log('[skip] RealWebSocket: ' + e); }

    // 自定义 SocketClient（云豹的 WS 封装）
    try {
      var SC = Java.use('com.yunbao.live.socket.SocketClient');
      if (SC) {
        console.log('[info] 找到 SocketClient 类');
      }
      // 同时 hook 通用 WebSocket 接口
      var WSif = Java.use('okhttp3.WebSocket');
      console.log('[info] okhttp3.WebSocket 接口可见');
    } catch (e) { console.log('[skip] SocketClient: ' + e); }

    // ---------- 6. 原始 Socket 读写（最后兜底） ----------
    try {
      var Socket = Java.use('java.net.Socket');
      var getInputStream = Socket.getInputStream;
      getInputStream.implementation = function () {
        try { log('SOCKET', 'getInputStream 被调用（可能有非 HTTP 流量）'); } catch (e) {}
        return getInputStream.call(this);
      };
    } catch (e) {}

    // ---------- 关键接口响应识别 ----------
    function checkEntryResp(text) {
      if (!text || text.length < 20) return;
      // 只在含 code 的响应里判断
      if (text.indexOf('"code"') < 0 && text.indexOf('"ret"') < 0) return;
      var mCode = text.match(/"code"\s*:\s*(\d+)/);
      var mRet = text.match(/"ret"\s*:\s*(\d+)/);
      var code = mCode ? mCode[1] : (mRet ? 'ret=' + mRet[1] : '?');
      // 识别是哪个接口的响应：看有没有特征字段
      var tag = null;
      if (text.indexOf('"fail_msg"') >= 0) tag = 'checkLive-FAIL(40018?)';
      else if (text.indexOf('"coin"') >= 0 && text.indexOf('"level"') >= 0 && text.length < 3000) tag = 'timeCharge?';
      else if (text.indexOf('"pull"') >= 0) tag = 'HAS-PULL';
      else if (text.indexOf('"stream"') >= 0 && text.indexOf('"live_platform"') >= 0) tag = 'roomInfo?';

      if (tag) {
        var rec = { t: ts(), dir: 'RESP', svc: tag, code: code, len: text.length };
        entryCalls.push(rec);
        log('ENTRY-RESP', tag + ' code=' + code + ' len=' + text.length);
        // 打完整内容（如果不大）
        if (text.length <= 4000) {
          console.log('--- 完整响应 ---');
          console.log(text);
          console.log('--- end ---');
        }
      }
    }

    // ---------- 输出命令 ----------
    globalThis.showTimeline = function () {
      console.log('\n########## 时间线（最近 60 条）##########');
      events.slice(-60).forEach(function (e) {
        console.log(e.t + ' [' + e.kind + '] ' + e.detail.substring(0, 200));
      });
      console.log('########################################\n');
    };

    globalThis.showFields = function () {
      console.log('\n########## 字段命中（pull / m3u8 / playurl）##########');
      if (!fieldHits.length) {
        console.log('（一条都没有——说明这些字段没出现在任何 JSON 里）');
      } else {
        Array.from(new Set(fieldHits)).slice(-20).forEach(function (h) { console.log('  ' + h); });
      }
      console.log('####################################################\n');
    };

    globalThis.showEntry = function () {
      console.log('\n########## 进房相关（checkLive / enterRoom / timeCharge）##########');
      if (!entryCalls.length) { console.log('（没抓到，确认点了房）'); }
      entryCalls.forEach(function (r, i) {
        console.log('[' + i + '] ' + r.t + ' ' + r.dir + ' ' + r.svc + (r.code ? (' code=' + r.code) : '') + (r.detail ? (' ' + r.detail.substring(0, 300)) : ''));
      });
      console.log('##############################################################\n');
    };

    globalThis.showAll = function () { showFields(); showEntry(); };

    console.log('[info] v20 loaded');
    console.log('[info] 现在点一个【免费房】（type=0，无💰标记）');
    console.log('[info] 然后依次输：showFields()  showEntry()  showTimeline()');
  });
}