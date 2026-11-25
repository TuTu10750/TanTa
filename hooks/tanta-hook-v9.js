// tanta-hook-v9.js —— 专攻响应体
// v8 只能抓到请求，响应一条没抓到。原因推测：响应被 gzip 压缩 / 走的不是 recvfrom
// v9 策略：
//   1. recvfrom / read 两个方向都扫，只要出现可读 ASCII 就 dump（不要求完整 HTTP 头）
//   2. 识别 gzip magic (1f 8b) 并单独标记
//   3. 把响应原始字节 hex 导出到文件，方便离线解压
//   4. 请求照旧抓（保留 service 汇总）
// 用法：frida -U -p <PID> -l tanta-hook-v9.js
// 抓够后：dumpSummary()

'use strict';

const services = {};
let reqCount = 0, respCount = 0, gzipCount = 0;
const out = { reqs: [], resps: [], gzips: [] };

function findExport(name) {
  if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
  if (typeof Module.getGlobalExportByName === 'function') { try { return Module.getGlobalExportByName(name); } catch (e) {} }
  if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
  return null;
}

function readBytes(p, max) {
  try { return new Uint8Array(p.readByteArray(max)); } catch (e) { return null; }
}

function toHex(u8, max) {
  const n = Math.min(u8.length, max || 96);
  let s = '';
  for (let i = 0; i < n; i++) s += u8[i].toString(16).padStart(2, '0');
  return s;
}

function tryStr(p, max) {
  try { return p.readUtf8String(max); } catch (e) { return null; }
}

// 宽松判断：可读 ASCII 占比
function asciiRatio(u8) {
  let printable = 0;
  const n = Math.min(u8.length, 400);
  for (let i = 0; i < n; i++) {
    const b = u8[i];
    if ((b >= 0x20 && b < 0x7f) || b === 0x0a || b === 0x0d || b === 0x09) printable++;
  }
  return n ? printable / n : 0;
}

function isGzip(u8) { return u8 && u8.length > 2 && u8[0] === 0x1f && u8[1] === 0x8b; }

function classify(s) {
  if (!s) return null;
  if (/^GET |^POST |^PUT |^DELETE |^HEAD |^OPTIONS /i.test(s)) return 'request';
  if (/^HTTP\/1\.[01] \d{3}/i.test(s)) return 'response';
  if (/^[\s]*[\[{]/.test(s) && /"/.test(s)) return 'json';
  return null;
}

const localFds = {};

function extractServices(s) {
  const re = /service=([A-Za-z0-9_.]+)/g; let m;
  while ((m = re.exec(s)) !== null) { const k = m[1]; services[k] = (services[k] || 0) + 1; }
}

function dump(tag, s, n) {
  console.log('\n========== ' + tag + ' len=' + n + ' ==========');
  console.log(n > 5000 ? s.substring(0, 5000) + '\n...(截断)' : s);
  console.log('========== end ==========\n');
}

function hookExport(name, hooks) {
  const p = findExport(name);
  if (!p) { console.log('[miss] ' + name); return; }
  try { Interceptor.attach(p, hooks); console.log('[hook] ' + name + ' @ ' + p); }
  catch (e) { console.log('[fail] ' + name + ': ' + e); }
}

console.log('[info] hook v9 loading ...');

hookExport('connect', {
  onEnter(a) { this.fd = a[0].toInt32(); },
  onLeave(r) {
    if (r.toInt32() === 0) { /* 只记本地 */ }
  }
});

// ---- 请求方向：sendto ----
hookExport('sendto', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    const s = tryStr(this.buf, Math.min(n, 8192));
    if (classify(s) !== 'request') return;
    reqCount++;
    extractServices(s);
    out.reqs.push({ fd: this.fd, ts: Date.now(), len: n, raw: s });
  }
});

// ---- 响应方向：recvfrom + read，宽松判断 ----
function handleInbound(tagName, fd, buf, len) {
  if (!buf || len <= 0) return;
  const u8 = readBytes(buf, Math.min(len, 65536));
  if (!u8) return;

  // gzip?
  if (isGzip(u8)) {
    gzipCount++;
    out.gzips.push({ fd, ts: Date.now(), len, hex: toHex(u8, 200) });
    console.log('[GZIP] fd=' + fd + ' len=' + len + ' head=' + toHex(u8, 32));
    return;
  }

  const ratio = asciiRatio(u8);
  const s = (ratio > 0.75) ? tryStr(buf, Math.min(len, 8192)) : null;

  if (s) {
    const kind = classify(s);
    if (kind === 'response' || kind === 'json') {
      respCount++;
      out.resps.push({ fd, ts: Date.now(), len, raw: s });
      dump('[RESP] fd=' + fd, s, len);
      return;
    }
    // 有可读内容但不是完整 HTTP，也打出来（可能是分片）
    if (ratio > 0.9 && s.length > 60) {
      console.log('[PARTIAL] fd=' + fd + ' len=' + len + ' ' + JSON.stringify(s.substring(0, 160)));
      return;
    }
  }

  // 二进制/密文：只在 len 不大时打 hex 头
  if (len <= 2048 && len > 8) {
    console.log('[BIN] fd=' + fd + ' len=' + len + ' ratio=' + ratio.toFixed(2) + ' head=' + toHex(u8, 48));
  }
}

hookExport('recvfrom', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    handleInbound('recvfrom', this.fd, this.buf, n);
  }
});

hookExport('read', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    if (n > 8) handleInbound('read', this.fd, this.buf, n);
  }
});

globalThis.dumpSummary = function () {
  console.log('\n\n########## 汇总 ##########');
  console.log('请求 ' + reqCount + '  响应 ' + respCount + '  gzip ' + gzipCount);
  console.log('--- service 清单 ---');
  Object.keys(services).sort().forEach(k => console.log('  ' + k + '  x' + services[k]));
  console.log('##########################\n');
};

rpc.exports = {
  dump: function () { dumpSummary(); return Object.keys(services); },
  dumpReq: function () { return out.reqs.slice(-10); },
  dumpResp: function () { return out.resps.slice(-10); },
  dumpGzip: function () { return out.gzips.slice(-20); }
};

console.log('[info] hook v9 loaded. 刷首页，然后 dumpSummary() / rpc.exports.dumpResp() / rpc.exports.dumpGzip()');