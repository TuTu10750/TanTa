// tanta-hook-v17.js —— 强攻付费时段锁
// 目标：把服务端返回的 code=40018（需要vip）改成 0（成功），让客户端走正常进房流程
//
// 原理（来自 CheckLivePresenter 源码）：
//   onSuccess(int code, String msg, String[] data)
//   if (code == 0)        -> handleCheckLiveSuccess  -> 进房
//   if (code == 40018)    -> handleLiveVipRequired   -> 弹 vip 窗
//   else                  -> handleCheckLiveFailure
//
// 做法：
//   1. hook com.yunbao.common.http.HttpCallback.onSuccess
//   2. 拿到 code==40018 时，改写为 0
//   3. 同时补齐 data[0] 的 JSON（补 type/type_val/live_platform/live_type）
//      因为 40018 的 body 是 {fail_msg, sharelink}，缺字段会让进房逻辑读成 0
//   4. 打印后续有没有拿到播放地址
//
// 用法：frida -U -p <PID> -l D:\浏览器\tanta-hook-v17.js
//   然后点一个房（付费时段任意房）
//   输 showResult() 看结果

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    let blockCount = 0;
    const blocked = [];     // 被改写的记录
    const plays = [];       // 拿到的播放地址
    const respLog = [];

    const MARK = '[FAIL]';

    // ---------- 1. hook HttpCallback.onSuccess ----------
    try {
      const HttpCallback = Java.use('com.yunbao.common.http.HttpCallback');
      const onSuccess = HttpCallback.onSuccess;
      onSuccess.implementation = function (code, msg, dataArr) {
        try {
          let c = code;
          // 40018 = 需要 vip（付费时段锁 / 房型锁）
          if (c === 40018) {
            blockCount++;
            console.log('[BYPASS] code 40018 -> 0  第 ' + blockCount + ' 次');
            try {
              if (dataArr && dataArr.length > 0 && dataArr[0] != null) {
                const orig = String(dataArr[0]);
                console.log('[BYPASS] 原始返回: ' + orig.substring(0, 300));
                let obj = {};
                try { obj = JSON.parse(orig); } catch (e) { obj = {}; }
                // 补齐进房必需字段
                const filled = {
                  live_type: obj.live_type != null ? obj.live_type : 0,
                  voice_type: obj.voice_type != null ? obj.voice_type : 0,
                  type: obj.type != null ? obj.type : 0,
                  type_val: obj.type_val != null ? obj.type_val : 0,
                  type_msg: obj.type_msg != null ? obj.type_msg : '',
                  live_platform: obj.live_platform != null ? obj.live_platform : 4
                };
                const newJson = JSON.stringify(filled);
                dataArr[0] = newJson;
                blocked.push({ orig: orig.substring(0, 200), fixed: newJson });
                console.log('[BYPASS] 改写为: ' + newJson);
              } else {
                // 完全没有 data，自己造一个
                const newJson = JSON.stringify({
                  live_type: 0, voice_type: 0, type: 0, type_val: 0,
                  type_msg: '', live_platform: 4
                });
                if (dataArr && dataArr.length > 0) dataArr[0] = newJson;
                blocked.push({ orig: '(empty)', fixed: newJson });
                console.log('[BYPASS] 无 data，造了一个: ' + newJson);
              }
            } catch (e) { console.log('[BYPASS-ERR] ' + e); }
            c = 0;
          }
          return onSuccess.call(this, c, msg, dataArr);
        } catch (e) {
          console.log('[hook-err] ' + e);
          return onSuccess.call(this, code, msg, dataArr);
        }
      };
      console.log('[hook] HttpCallback.onSuccess  (40018 -> 0)');
    } catch (e) { console.log('[skip] HttpCallback: ' + e); }

    // ---------- 2. 抓进房后拿到的播放地址 ----------
    try {
      const JSON = Java.use('com.alibaba.fastjson.JSON');
      const po = JSON.parseObject.overload('java.lang.String');
      po.implementation = function (text) {
        try {
          if (text && text.length > 20 && text.length < 80000) {
            respLog.push(text);
            if (respLog.length > 50) respLog.shift();
            const keys = ['hls', 'pull', 'playurl', 'play_url', 'live_url', 'stream_url', 'm3u8'];
            for (let i = 0; i < keys.length; i++) {
              const re = new RegExp('"' + keys[i] + '"\\s*:\\s*"([^"]{8,})"');
              const m = text.match(re);
              if (m) {
                const u = m[1].replace(/\\\//g, '/');
                if (/\.m3u8|\.flv|https?:\/\//.test(u)) {
                  plays.push(u);
                  console.log('[PLAY] ' + u);
                  break;
                }
              }
            }
            const m2 = text.match(/(https?:\/\/[^\s"\\]{10,}\.m3u8[^\s"\\]*)/);
            if (m2) { plays.push(m2[1]); console.log('[PLAY] ' + m2[1]); }
          }
        } catch (e) {}
        return po.call(this, text);
      };
      console.log('[hook] fastjson (抓播放地址)');
    } catch (e) { console.log('[skip] fastjson: ' + e); }

    // ---------- 3. 兜底：hook 真正的播放器创建 ----------
    // 如果能进到 LiveAudienceActivity，说明第一关过了
    try {
      const LAA = Java.use('com.yunbao.live.activity.LiveAudienceActivity');
      console.log('[info] LiveAudienceActivity 类可见（进房目标类）');
    } catch (e) {
      console.log('[skip] LiveAudienceActivity: ' + e);
    }

    // ---------- 输出 ----------
    globalThis.showResult = function () {
      console.log('\n########## 结果 ##########');
      console.log('拦截改写次数: ' + blockCount);
      console.log('播放地址条数: ' + plays.length);
      if (plays.length) {
        console.log('--- 播放地址 ---');
        plays.slice(-8).forEach(function (u) { console.log('  ' + u); });
      } else {
        console.log('--- 没有拿到播放地址 ---');
      }
      if (blocked.length) {
        console.log('--- 改写记录（最近3条）---');
        blocked.slice(-3).forEach(function (b) {
          console.log('  原: ' + b.orig);
          console.log('  改: ' + b.fixed);
        });
      }
      console.log('##########################\n');
    };

    globalThis.showResp = function (i) {
      const idx = (i == null) ? (respLog.length - 1) : i;
      const t = respLog[idx];
      if (!t) { console.log('没有第 ' + idx + ' 条'); return; }
      console.log('\n===== RESP[' + idx + '] len=' + t.length + ' =====');
      console.log(t.substring(0, 3000));
      console.log('=====\n');
    };

    console.log('[info] v17 loaded');
    console.log('[info] 现在去点一个房（付费时段任意房都行）');
    console.log('[info] 然后输 showResult()');
    console.log('[info] 如果弹窗还在，把 Frida 窗口输出贴给我');
  });
}