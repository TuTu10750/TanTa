// tanta-hook-v11.js —— 把二进制响应原样导出，离线分析
// 目的：把每个 [BIN] 的完整字节存成 base64 文件，pull 回来跑 gzip/AES 识别
// 输出：/data/local/tmp/tanta_bins.txt（每行：fd|len|base64）
// 用法：frida -U -p <PID> -l tanta-hook-v11.js
// 收满后用：adb pull /data/local/tmp/tanta_bins.txt D:\浏览器\tanta_bins.txt

'use strict';

const services = {};
let reqCount = 0, binCount = 0, silentCount = 0;
const SILENT_FDS = {};
const MAX_BIN = 8192;      // 单条最大 8KB
const MAX_LINES = 400;     // 最多 400 条，防止文件过大

const FILE = '/data/local/tmp/tanta_bins.txt';
let collected = [];

function findExport(name) {
  if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
  if (typeof Module.getGlobalExportByName === 'function') { try { return Module.getGlobalExportByName(name); } catch (e) {} }
  if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
  return null;
}
function readBytes(p, max) { try { return new Uint8Array(p.readByteArray(max)); } catch (e) { return null; } }
function tryStr(p, max) { try { return p.readUtf8String(max); } catch (e) { return null; } }
function b64(u8) {
  // Frida 有 Base64 吗？没有标准实现，手写
  const T = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
  let s = '', i = 0;
  while (i < u8.length) {
    const b1 = u8[i++], b2 = i < u8.length ? u8[i++] : -1, b3 = i < u8.length ? u8[i++] : -1;
    s += T[b1 >> 2];
    s += T[((b1 & 3) << 4) | ((b2 < 0 ? 0 : b2) >> 4)];
    s += b2 < 0 ? '=' : T[((b2 & 15) << 2) | ((b3 < 0 ? 0 : b3) >> 6)];
    s += b3 < 0 ? '=' : T[b3 & 63];
  }
  return s;
}

function asciiRatio(u8) {
  let p = 0; const n = Math.min(u8.length, 400);
  for (let i = 0; i < n; i++) { const b = u8[i]; if ((b >= 0x20 && b < 0x7f) || b === 0x0a || b === 0x0d || b === 0x09) p++; }
  return n ? p / n : 0;
}
function isGzip(u8) { return u8 && u8.length > 2 && u8[0] === 0x1f && u8[1] === 0x8b; }

function shouldSilence(fd, u8, len) {
  if (SILENT_FDS[fd] === true) return true;
  if (SILENT_FDS[fd] === false) return false;
  if (u8.length >= 4 && u8[0] === 0x6e && u8[1] === 0x79 && u8[2] === 0x73 && u8[3] === 0x76) { SILENT_FDS[fd] = true; console.log('[silent] fd=' + fd + ' nysv 控制通道'); return true; }
  if (len === 312 && u8[0] === 1 && u8[1] === 0) { silentCount++; SILENT_FDS[fd] = true; return true; }
  return false;
}

function classify(s) {
  if (!s) return null;
  if (/^GET |^POST |^PUT |^DELETE |^HEAD |^OPTIONS /i.test(s)) return 'request';
  if (/^HTTP\/1\.[01] \d{3}/i.test(s)) return 'response';
  if (/^[\s]*[\[{]/.test(s) && /"/.test(s)) return 'json';
  return null;
}
function extractServices(s) { const re = /service=([A-Za-z0-9_.]+)/g; let m; while ((m = re.exec(s)) !== null) { const k = m[1]; services[k] = (services[k] || 0) + 1; } }

// 收集二进制并写文件
function collect(fd, u8, len) {
  if (collected.length >= MAX_LINES) return;
  const slice = u8.length > MAX_BIN ? u8.subarray(0, MAX_BIN) : u8;
  collected.push(fd + '|' + len + '|' + b64(slice));
  binCount++;
  if (collected.length % 20 === 0) flush();
}

function flush() {
  if (!collected.length) return;
  try {
    const f = new File(FILE, 'a');
    f.write(collected.join('\n') + '\n');
    f.flush(); f.close();
    console.log('[write] 追加 ' + collected.length + ' 条 -> ' + FILE);
  } catch (e) { console.log('[write-fail] ' + e); }
  collected = [];
}

function hookExport(name, hooks) {
  const p = findExport(name);
  if (!p) { console.log('[miss] ' + name); return; }
  try { Interceptor.attach(p, hooks); console.log('[hook] ' + name + ' @ ' + p); }
  catch (e) { console.log('[fail] ' + name + ': ' + e); }
}

console.log('[info] hook v11 loading ...');
try { const f = new File(FILE, 'w'); f.write(''); f.flush(); f.close(); console.log('[init] 清空 ' + FILE); } catch (e) { console.log('[init-fail] ' + e); }

hookExport('sendto', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    const s = tryStr(this.buf, Math.min(n, 8192));
    if (classify(s) !== 'request') return;
    reqCount++; extractServices(s);
  }
});

function handleInbound(fd, buf, len) {
  const u8 = readBytes(buf, Math.min(len, 65536));
  if (!u8) return;
  if (shouldSilence(fd, u8, len)) return;

  if (isGzip(u8)) { console.log('[GZIP] fd=' + fd + ' len=' + len); collect(fd, u8, len); return; }

  const ratio = asciiRatio(u8);
  const s = ratio > 0.6 ? tryStr(buf, Math.min(len, 8192)) : null;
  if (s) {
    const k = classify(s);
    if (k === 'response' || k === 'json') { console.log('[PLAIN] fd=' + fd + ' len=' + len + ' ' + JSON.stringify(s.substring(0, 120))); return; }
    // 隧道头 + 图片头，忽略
    if (/^\d{10,16}\n\d{10,16}\n/.test(s)) return;
  }
  // 其他全当二进制，收集
  if (len >= 24) { console.log('[BIN] fd=' + fd + ' len=' + len + ' ratio=' + ratio.toFixed(2)); collect(fd, u8, len); }
}

hookExport('recvfrom', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 0) handleInbound(this.fd, this.buf, n); }
});

hookExport('read', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 16) handleInbound(this.fd, this.buf, n); }
});

globalThis.dumpSummary = function () {
  flush();
  console.log('\n########## 汇总 ##########');
  console.log('请求 ' + reqCount + '  二进制 ' + (binCount + collected.length) + '  心跳 ' + silentCount);
  Object.keys(services).sort().forEach(k => console.log('  ' + k + '  x' + services[k]));
  console.log('文件：' + FILE);
  console.log('##########################\n');
};
globalThis.saveNow = function () { flush(); console.log('[saved]'); };

rpc.exports = {
  dump: function () { flush(); return Object.keys(services); },
  save: function () { flush(); return binCount; }
};

console.log('[info] v11 loaded. 刷首页 -> 输 saveNow() -> adb pull ' + FILE);