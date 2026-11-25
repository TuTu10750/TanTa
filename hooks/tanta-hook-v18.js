// tanta-hook-v18.js —— 精确 hook 所有 HttpCallback 子类的 onSuccess
// v17 失败原因：hook 了父类 HttpCallback.onSuccess，但子类 @Override 覆盖了，抓不到调用
// v18 做法：
//   1. Java.enumerateClassLoaders 遍历，找所有 extends HttpCallback 的子类
//   2. 对每个子类的 onSuccess(int,String,String[]) 逐一 hook
//   3. 40018 -> 0 并补齐 JSON
//   4. 打印每次调用（不管 code 是多少），确保能看到真实流量
//
// 用法：frida -U -p <PID> -l D:\浏览器\tanta-hook-v18.js
//   然后点房，输 showResult()

'use strict';

if (!Java.available) {
  console.log('[fatal] Java 不可用');
} else {
  Java.perform(function () {

    let blockCount = 0;
    let sawCalls = 0;
    const callLog = [];
    const blocked = [];
    const plays = [];

    const FILL_JSON = JSON.stringify({
      live_type: 0, voice_type: 0, type: 0, type_val: 0,
      type_msg: '', live_platform: 4
    });

    function patchOne(className) {
      try {
        const Cls = Java.use(className);
        if (Cls.onSuccess === undefined) return false;
        const over = Cls.onSuccess.overload('int', 'java.lang.String', '[Ljava.lang.String;');
        over.implementation = function (code, msg, dataArr) {
          let c = code;
          try {
            sawCalls++;
            if (callLog.length < 60) callLog.push(className + ' code=' + code + ' msg=' + String(msg).substring(0, 80));
            console.log('[CB] ' + className.split('.').pop() + ' code=' + code);
            if (c === 40018) {
              blockCount++;
              const orig = (dataArr && dataArr.length > 0 && dataArr[0] != null) ? String(dataArr[0]) : '';
              console.log('[BYPASS] 40018 -> 0  #' + blockCount);
              if (orig) console.log('[BYPASS] 原: ' + orig.substring(0, 240));
              try {
                if (dataArr && dataArr.length > 0) {
                  let obj = {};
                  try { obj = JSON.parse(orig); } catch (e) {}
                  const filled = {
                    live_type: obj.live_type != null ? obj.live_type : 0,
                    voice_type: obj.voice_type != null ? obj.voice_type : 0,
                    type: obj.type != null ? obj.type : 0,
                    type_val: obj.type_val != null ? obj.type_val : 0,
                    type_msg: obj.type_msg != null ? obj.type_msg : '',
                    live_platform: obj.live_platform != null ? obj.live_platform : 4
                  };
                  dataArr[0] = JSON.stringify(filled);
                  blocked.push({ o: orig.substring(0, 160), f: JSON.stringify(filled) });
                } else {
                  blocked.push({ o: '(empty)', f: FILL_JSON });
                }
              } catch (e) { console.log('[BYPASS-ERR] ' + e); }
              c = 0;
            }
          } catch (e) { console.log('[err] ' + e); }
          return over.call(this, c, msg, dataArr);
        };
        console.log('[hook] ' + className);
        return true;
      } catch (e) {
        return false;
      }
    }

    // ---- 1. 遍历所有类加载器，找 HttpCallback 子类 ----
    let hooked = 0;
    const seen = {};
    try {
      const Base = Java.use('com.yunbao.common.http.HttpCallback');
      Java.enumerateClassLoaders({
        onMatch: function (loader) {
          try {
            const loaderCls = Java.use('java.lang.ClassLoader');
            // 用 Base.class 的父类链不可行，改用 loadClass 尝试枚举不现实
            // 替代：直接在默认 loader 环境下走 Java.enumerateLoadedClasses
          } catch (e) {}
        },
        onComplete: function () {}
      });
    } catch (e) { console.log('[skip] enumerateClassLoaders: ' + e); }

    // ---- 2. 用 enumerateLoadedClasses 找出所有已加载的 HttpCallback 子类 ----
    try {
      Java.enumerateLoadedClasses({
        onMatch: function (name) {
          if (seen[name]) return;
          if (name.indexOf('HttpCallback') < 0 && name.indexOf('CheckLive') < 0 && name.indexOf('$1') < 0) return;
          seen[name] = 1;
          if (patchOne(name)) hooked++;
        },
        onComplete: function () {
          console.log('[info] 已 hook ' + hooked + ' 个回调类');
        }
      });
    } catch (e) { console.log('[skip] enumerateLoadedClasses: ' + e); }

    // ---- 3. 重点：直接点名 CheckLivePresenter 的内部类 ----
    const targets = [
      'com.yunbao.main.presenter.CheckLivePresenter$1',
      'com.yunbao.main.presenter.CheckLivePresenter$2'
    ];
    targets.forEach(function (t) {
      if (seen[t]) return;
      if (patchOne(t)) { hooked++; seen[t] = 1; }
    });

    // ---- 4. 兜底 hook fastjson 抓播放地址 ----
    try {
      const JSON = Java.use('com.alibaba.fastjson.JSON');
      const po = JSON.parseObject.overload('java.lang.String');
      po.implementation = function (text) {
        try {
          if (text && text.length > 20 && text.length < 80000) {
            const m2 = text.match(/(https?:\/\/[^\s"\\]{10,}\.m3u8[^\s"\\]*)/);
            if (m2) { plays.push(m2[1]); console.log('[PLAY] ' + m2[1]); }
          }
        } catch (e) {}
        return po.call(this, text);
      };
    } catch (e) {}

    // ---- 输出 ----
    globalThis.showResult = function () {
      console.log('\n########## 结果 ##########');
      console.log('已 hook 类数: ' + hooked);
      console.log('回调触发次数: ' + sawCalls);
      console.log('40018 拦截改写: ' + blockCount);
      console.log('播放地址: ' + plays.length);
      if (callLog.length) {
        console.log('--- 回调记录 ---');
        callLog.forEach(function (l) { console.log('  ' + l); });
      } else {
        console.log('--- 没有回调触发（说明没点房，或走的不是这个回调）---');
      }
      if (plays.length) { console.log('--- 播放地址 ---'); plays.slice(-5).forEach(function (u) { console.log('  ' + u); }); }
      console.log('##########################\n');
    };

    globalThis.rehook = function () {
      hooked = 0;
      Java.enumerateLoadedClasses({
        onMatch: function (name) {
          if (name.indexOf('HttpCallback') < 0 && name.indexOf('CheckLive') < 0) return;
          if (seen[name]) return;
          seen[name] = 1;
          if (patchOne(name)) hooked++;
        },
        onComplete: function () { console.log('[rehook] 共 ' + hooked + ' 个'); }
      });
    };

    console.log('[info] v18 loaded, hook 了 ' + hooked + ' 个类');
    console.log('[info] 现在点房，然后 showResult()');
  });
}