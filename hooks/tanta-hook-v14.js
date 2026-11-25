// tanta-hook-v14.js —— Java 层抓解密后的明文（不碰 so、不碰 AES）
// 思路：netshield 在 native 层解密完，数据必然交给 Java 层解析。
//       所以直接 hook Java 的 HTTP 客户端 / JSON 解析器，拿到的就是明文。
// 用法：frida -U -p <PID> -l tanta-hook-v14.js
// 抓够后输：showAll()   或   showStats()

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 层不可用，本脚本需要 Dalvik/ART');
} else {
  Java.perform(function () {

    const hits = [];          // {kind, url, body}
    const MAX_HITS = 60;
    let hookCount = 0;

    function push(kind, url, body) {
      if (hits.length >= MAX_HITS) return;
      if (body && body.length > 12000) body = body.substring(0, 12000) + '...(截断)';
      hits.push({ kind: kind, url: url || '', body: body || '' });
      console.log('[HIT] #' + hits.length + ' ' + kind + ' ' + (url || '').substring(0, 120));
    }

    function isInteresting(s) {
      if (!s || s.length < 20) return false;
      return /service=|appapi|\{"code"|"info"|"data"|"list"/i.test(s);
    }

    // ---------- 1. okhttp3 Response.body() ----------
    try {
      const Response = Java.use('okhttp3.Response');
      const ResponseBody = Java.use('okhttp3.ResponseBody');
      let hooked = 0;
      ResponseBody.string.implementation = function () {
        const r = this.string();
        try {
          if (isInteresting(r)) {
            let url = '';
            try {
              const req = this.__req;               // 我们自己挂的引用（见下）
              if (req) url = req.toString();
            } catch (e) {}
            push('okhttp.body', url, r);
          }
        } catch (e) {}
        return r;
      };
      hooked++;
      console.log('[hook] okhttp3.ResponseBody.string');
      hookCount += hooked;
    } catch (e) { console.log('[skip] okhttp3: ' + e); }

    // ---------- 2. java.net.HttpURLConnection 读取 ----------
    try {
      const InputStream = Java.use('java.io.InputStream');
      // 不直接 hook InputStream（太底层），hook BufferedReader.readLine
      const BR = Java.use('java.io.BufferedReader');
      BR.readLine.implementation = function () {
        const line = this.readLine();
        if (line && line.length > 30 && isInteresting(line)) {
          push('buffered.readLine', '', line);
        }
        return line;
      };
      console.log('[hook] java.io.BufferedReader.readLine');
      hookCount++;
    } catch (e) { console.log('[skip] BufferedReader: ' + e); }

    // ---------- 3. fastjson 解析入口（拿完整 JSON 对象串） ----------
    try {
      const JSON = Java.use('com.alibaba.fastjson.JSON');
      const parseObject = JSON.parseObject.overload('java.lang.String');
      parseObject.implementation = function (text) {
        try {
          if (isInteresting(text)) push('fastjson.parseObject', '', text);
        } catch (e) {}
        return parseObject.call(this, text);
      };
      console.log('[hook] com.alibaba.fastjson.JSON.parseObject(String)');
      hookCount++;
    } catch (e) { console.log('[skip] fastjson.parseObject: ' + e); }

    try {
      const JSON = Java.use('com.alibaba.fastjson.JSON');
      const parseArray = JSON.parseArray.overload('java.lang.String');
      parseArray.implementation = function (text) {
        try {
          if (isInteresting(text)) push('fastjson.parseArray', '', text);
        } catch (e) {}
        return parseArray.call(this, text);
      };
      console.log('[hook] com.alibaba.fastjson.JSON.parseArray(String)');
      hookCount++;
    } catch (e) { console.log('[skip] fastjson.parseArray: ' + e); }

    // ---------- 4. 网络层：抓 URL（知道请求了什么） ----------
    try {
      const URL = Java.use('java.net.URL');
      URL.openConnection.overload().implementation = function () {
        try {
          const s = this.toString();
          if (/appapi|service=/i.test(s)) console.log('[URL] ' + s);
        } catch (e) {}
        return this.openConnection();
      };
      console.log('[hook] java.net.URL.openConnection');
      hookCount++;
    } catch (e) { console.log('[skip] URL.openConnection: ' + e); }

    // ---------- 5. 兜底：hook App 自己的 HttpCallback ----------
    try {
      const CB = Java.use('com.yunbao.common.http.HttpCallback');
      // 接口方法不能直接 hook，跳过并提示
      console.log('[info] HttpCallback 是接口，跳过');
    } catch (e) {}

    console.log('[info] v14 已装好 ' + hookCount + ' 个 Java hook');

    // ---------- 输出 ----------
    globalThis.showStats = function () {
      console.log('\n########## Java 层命中 ##########');
      console.log('总共 ' + hits.length + ' 条');
      const kinds = {};
      hits.forEach(h => { kinds[h.kind] = (kinds[h.kind] || 0) + 1; });
      Object.keys(kinds).forEach(k => console.log('  ' + k + ' x' + kinds[k]));
      console.log('##########################\n');
    };

    globalThis.showPage = function (page) {
      const size = 3;
      const start = (page || 0) * size;
      const slice = hits.slice(start, start + size);
      if (!slice.length) { console.log('[showPage] 没有更多（共 ' + hits.length + ' 条）'); return; }
      console.log('\n===== 第 ' + page + ' 页 (' + (start + 1) + '-' + (start + slice.length) + ' / ' + hits.length + ') =====');
      slice.forEach((h, i) => {
        console.log('\n--- [' + (start + i) + '] ' + h.kind + ' ---');
        if (h.url) console.log('URL: ' + h.url.substring(0, 300));
        console.log(h.body.length > 3000 ? h.body.substring(0, 3000) + '\n...(截断)' : h.body);
      });
      console.log('\n===== 翻页：showPage(' + (page + 1) + ') =====\n');
    };

    globalThis.showAll = function () {
      const pages = Math.ceil(hits.length / 3);
      for (let p = 0; p < pages; p++) showPage(p);
    };

    console.log('[info] 刷首页 1 分钟，然后输 showStats()');
  });
}