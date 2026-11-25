// tanta-hook-v13.js —— 数据直接打印到屏幕，不写文件、不用 adb
// 用法：
//   frida -U -p <PID> -l tanta-hook-v13.js
//   刷首页 1 分钟
//   输  showAll()      逐个批次打印（每批 10 条）
//   或  showPage(0)    看第 0 页，showPage(1) 看第 1 页
//   或  showStats()    只看统计，先判断是什么
// 每行格式： [i] fd=228 len=1818 ratio=0.35 hex=<前 200 字节 hex> b64=<前 64 字节 base64>

'use strict';

const services = {};
let reqCount = 0, silentCount = 0;
const SILENT_FDS = {};
const bins = [];          // {fd, len, ratio, hex, b64, b64full}
const MAX_KEEP = 400;
const MAX_KEEP_BYTES = 16384;

function findExport(name) {
  if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
  if (typeof Module.getGlobalExportByName === 'function') { try { return Module.getGlobalExportByName(name); } catch (e) {} }
  if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
  return null;
}
function readBytes(p, max) { try { return new Uint8Array(p.readByteArray(max)); } catch (e) { return null; } }
function tryStr(p, max) { try { return p.readUtf8String(max); } catch (e) { return null; } }
function toHex(u8, max) { const n = Math.min(u8.length, max || 64); let s = ''; for (let i = 0; i < n; i++) s += u8[i].toString(16).padStart(2, '0'); return s; }
const B64 = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
function b64(u8, max) {
  const n = Math.min(u8.length, max || u8.length);
  let s = '', i = 0;
  while (i < n) {
    const b1 = u8[i++], b2 = i < n ? u8[i++] : -1, b3 = i < n ? u8[i++] : -1;
    s += B64[b1 >> 2];
    s += B64[((b1 & 3) << 4) | ((b2 < 0 ? 0 : b2) >> 4)];
    s += b2 < 0 ? '=' : B64[((b2 & 15) << 2) | ((b3 < 0 ? 0 : b3) >> 6)];
    s += b3 < 0 ? '=' : B64[b3 & 63];
  }
  return s;
}
function asciiRatio(u8) {
  let p = 0; const n = Math.min(u8.length, 400);
  for (let i = 0; i < n; i++) { const b = u8[i]; if ((b >= 0x20 && b < 0x7f) || b === 0x0a || b === 0x0d || b === 0x09) p++; }
  return n ? p / n : 0;
}
function isGzip(u8) { return u8 && u8.length > 2 && u8[0] === 0x1f && u8[1] === 0x8b; }
function entropy(u8) {
  const freq = new Array(256).fill(0);
  for (let i = 0; i < u8.length; i++) freq[u8[i]]++;
  let e = 0;
  for (let i = 0; i < 256; i++) if (freq[i]) { const p = freq[i] / u8.length; e -= p * Math.log2(p); }
  return e;
}

function shouldSilence(fd, u8, len) {
  if (SILENT_FDS[fd] === true) return true;
  if (SILENT_FDS[fd] === false) return false;
  if (u8.length >= 4 && u8[0] === 0x6e && u8[1] === 0x79 && u8[2] === 0x73 && u8[3] === 0x76) { SILENT_FDS[fd] = true; console.log('[silent] fd=' + fd + ' nysv'); return true; }
  if (len === 312 && u8[0] === 1) { silentCount++; SILENT_FDS[fd] = true; return true; }
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

function hookExport(name, hooks) {
  const p = findExport(name);
  if (!p) { console.log('[miss] ' + name); return; }
  try { Interceptor.attach(p, hooks); console.log('[hook] ' + name + ' @ ' + p); }
  catch (e) { console.log('[fail] ' + name + ': ' + e); }
}

console.log('[info] hook v13 loading ...');

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
  const u8 = readBytes(buf, Math.min(len, MAX_KEEP_BYTES));
  if (!u8) return;
  if (shouldSilence(fd, u8, len)) return;

  const ratio = asciiRatio(u8);
  const s = ratio > 0.6 ? tryStr(buf, Math.min(len, 8192)) : null;
  if (s) {
    const k = classify(s);
    if (k === 'response' || k === 'json') { console.log('[PLAIN] fd=' + fd + ' len=' + len); return; }
    if (/^\d{10,16}\n\d{10,16}\n/.test(s)) return;   // 隧道头（图片）
  }
  if (len < 24) return;
  if (bins.length >= MAX_KEEP) return;

  bins.push({
    fd: fd, len: len, ratio: ratio,
    gz: isGzip(u8), ent: entropy(u8),
    hex: toHex(u8, 200),
    b64: b64(u8, 96),
    b64full: u8.length <= 2048 ? b64(u8, u8.length) : null
  });
  if (bins.length % 25 === 0) console.log('[bin] 已收集 ' + bins.length + ' 条');
}

hookExport('recvfrom', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 0) handleInbound(this.fd, this.buf, n); }
});
hookExport('read', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 16) handleInbound(this.fd, this.buf, n); }
});

// ============ 输出命令 ============

globalThis.showStats = function () {
  console.log('\n########## 统计 ##########');
  console.log('请求 ' + reqCount + ' 条，二进制 ' + bins.length + ' 条，心跳 ' + silentCount);
  console.log('--- service ---');
  Object.keys(services).sort().forEach(k => console.log('  ' + k + '  x' + services[k]));
  console.log('--- 二进制分布 ---');
  const byLen = {};
  bins.forEach(b => { byLen[b.len] = (byLen[b.len] || 0) + 1; });
  Object.keys(byLen).sort((a, b) => a - b).slice(0, 40).forEach(l => {
    const sample = bins.find(b => b.len == l);
    console.log('  len=' + l + '  x' + byLen[l] + '  熵=' + sample.ent.toFixed(2) + '  gzip=' + sample.gz + '  ratio=' + sample.ratio.toFixed(2));
  });
  console.log('##########################\n');
};

globalThis.showPage = function (page) {
  const size = 10;
  const start = (page || 0) * size;
  const slice = bins.slice(start, start + size);
  if (!slice.length) { console.log('[showPage] 没有更多（共 ' + bins.length + ' 条，第 ' + page + ' 页为空）'); return; }
  console.log('\n===== 第 ' + page + ' 页 (' + (start + 1) + '-' + (start + slice.length) + ' / ' + bins.length + ') =====');
  slice.forEach((b, i) => {
    console.log('[' + (start + i) + '] fd=' + b.fd + ' len=' + b.len + ' 熵=' + b.ent.toFixed(2) + ' gz=' + b.gz);
    console.log('     hex=' + b.hex);
    if (b.b64full) console.log('     B64FULL=' + b.b64full);
    else console.log('     b64=' + b.b64 + '  (仅前96字节)');
  });
  console.log('===== 结束，翻页：showPage(' + (page + 1) + ') =====\n');
};

globalThis.showAll = function () {
  const pages = Math.ceil(bins.length / 10);
  for (let p = 0; p < pages; p++) showPage(p);
};

rpc.exports = { stats: function () { return { req: reqCount, bins: bins.length }; } };

console.log('[info] v13 loaded.');
console.log('[info] 刷首页 1 分钟后输：showStats()  然后 showPage(0)  showPage(1) ...');