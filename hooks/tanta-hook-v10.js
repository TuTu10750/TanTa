// tanta-hook-v10.js —— 剥隧道头 + 抓真响应
// 关键发现：netshield 在本地回环上用自有隧道格式，响应前 4 行是元数据：
//   <ts1>\n<ts2>\n<flag>\n<len>\n<真正的 HTTP 响应 / JSON / 二进制>
// v10 改动：
//   1. 自动剥掉 4 行隧道头，只打真正的 HTTP 响应
//   2. gzip(1f 8b) 单独标记并 dump hex（贴出来我离线解）
//   3. fd=310 心跳(312B)、fd=89 控制("nysv") 静音
//   4. 请求侧保持 v9 行为
// 用法：frida -U -p <PID> -l tanta-hook-v10.js
// 抓够后：dumpSummary() / rpc.exports.dumpResp() / rpc.exports.dumpGzip()

'use strict';

const services = {};
let reqCount = 0, respCount = 0, gzipCount = 0, silentCount = 0;
const out = { reqs: [], resps: [], gzips: [] };
const SILENT_FDS = {};

function findExport(name) {
  if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
  if (typeof Module.getGlobalExportByName === 'function') { try { return Module.getGlobalExportByName(name); } catch (e) {} }
  if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
  return null;
}

function readBytes(p, max) { try { return new Uint8Array(p.readByteArray(max)); } catch (e) { return null; } }
function toHex(u8, max) { const n = Math.min(u8.length, max || 96); let s = ''; for (let i = 0; i < n; i++) s += u8[i].toString(16).padStart(2, '0'); return s; }
function tryStr(p, max) { try { return p.readUtf8String(max); } catch (e) { return null; } }
function isGzip(u8) { return u8 && u8.length > 2 && u8[0] === 0x1f && u8[1] === 0x8b; }
function asciiRatio(u8) {
  let p = 0; const n = Math.min(u8.length, 400);
  for (let i = 0; i < n; i++) { const b = u8[i]; if ((b >= 0x20 && b < 0x7f) || b === 0x0a || b === 0x0d || b === 0x09) p++; }
  return n ? p / n : 0;
}

// 静音识别：心跳 312B 固定结构 / netshield 控制通道 "nysv"
function shouldSilence(fd, u8, len) {
  if (SILENT_FDS[fd] === false) return false;
  if (SILENT_FDS[fd] === true) return true;
  // 控制通道：以 "nysv" 开头
  if (u8.length >= 4 && u8[0] === 0x6e && u8[1] === 0x79 && u8[2] === 0x73 && u8[3] === 0x76) { SILENT_FDS[fd] = true; console.log('[silent] fd=' + fd + ' 判定为 netshield 控制通道(nysv)'); return true; }
  // 心跳：312 字节，前 4 字节 01 00 00 00，偏移 4 处 2 字节递增
  if (len === 312 && u8[0] === 1 && u8[1] === 0 && u8[2] === 0 && u8[3] === 0) { silentCount++; return true; }
  return false;
}

// 剥隧道头：如果前 4 行是纯数字/短数字，认为有隧道头
function stripTunnel(s) {
  if (!s) return { body: s, tunnel: null };
  const m = s.match(/^(\d{10,16})\n(\d{10,16})\n(\d{1,3})\n(\d{2,8})\n/);
  if (!m) return { body: s, tunnel: null };
  const tunnel = { ts1: m[1], ts2: m[2], flag: m[3], len: m[4] };
  // 长度字段如果是文本长度，用不上；直接切到第 4 个 \n 之后
  const idx = m[0].length;
  return { body: s.substring(idx), tunnel };
}

function classify(s) {
  if (!s) return null;
  if (/^GET |^POST |^PUT |^DELETE |^HEAD |^OPTIONS /i.test(s)) return 'request';
  if (/^HTTP\/1\.[01] \d{3}/i.test(s)) return 'response';
  if (/^[\s]*[\[{]/.test(s) && /"/.test(s)) return 'json';
  return null;
}

function extractServices(s) {
  const re = /service=([A-Za-z0-9_.]+)/g; let m;
  while ((m = re.exec(s)) !== null) { const k = m[1]; services[k] = (services[k] || 0) + 1; }
}

function dump(tag, s, n) {
  console.log('\n========== ' + tag + ' len=' + n + ' ==========');
  console.log(n > 6000 ? s.substring(0, 6000) + '\n...(截断)' : s);
  console.log('========== end ==========\n');
}

function hookExport(name, hooks) {
  const p = findExport(name);
  if (!p) { console.log('[miss] ' + name); return; }
  try { Interceptor.attach(p, hooks); console.log('[hook] ' + name + ' @ ' + p); }
  catch (e) { console.log('[fail] ' + name + ': ' + e); }
}

console.log('[info] hook v10 loading ...');

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

function handleInbound(fd, buf, len) {
  const u8 = readBytes(buf, Math.min(len, 65536));
  if (!u8) return;
  if (shouldSilence(fd, u8, len)) return;

  // gzip
  if (isGzip(u8)) {
    gzipCount++;
    const hex = toHex(u8, 400);
    out.gzips.push({ fd, ts: Date.now(), len, hex });
    console.log('[GZIP] fd=' + fd + ' len=' + len + ' head=' + toHex(u8, 24));
    // 如果不大，整段 hex 给出来方便解
    if (len <= 4096) console.log('[GZIP-FULL] fd=' + fd + ' hex=' + toHex(u8, len));
    return;
  }

  const ratio = asciiRatio(u8);
  if (ratio < 0.6) {
    if (len <= 2048 && len > 16) console.log('[BIN] fd=' + fd + ' len=' + len + ' ratio=' + ratio.toFixed(2) + ' head=' + toHex(u8, 48));
    return;
  }

  const s = tryStr(buf, Math.min(len, 16384));
  if (!s) return;

  const { body, tunnel } = stripTunnel(s);
  const kind = classify(body);
  if (kind === 'response' || kind === 'json') {
    respCount++;
    out.resps.push({ fd, ts: Date.now(), len, tunnel, raw: body });
    dump('[RESP' + (tunnel ? '-T' : '') + '] fd=' + fd, body, len);
    return;
  }
  // 剥了隧道头还是不像 HTTP/JSON，但有可读内容
  if (ratio > 0.9 && s.length > 80) {
    console.log('[PARTIAL] fd=' + fd + ' len=' + len + (tunnel ? ' tunnel' : '') + ' ' + JSON.stringify((tunnel ? body : s).substring(0, 200)));
  }
}

hookExport('recvfrom', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 0) handleInbound(this.fd, this.buf, n); }
});

hookExport('read', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 8) handleInbound(this.fd, this.buf, n); }
});

globalThis.dumpSummary = function () {
  console.log('\n\n########## 汇总 ##########');
  console.log('请求 ' + reqCount + '  响应 ' + respCount + '  gzip ' + gzipCount + '  心跳(已静音) ' + silentCount);
  console.log('--- service 清单 ---');
  Object.keys(services).sort().forEach(k => console.log('  ' + k + '  x' + services[k]));
  console.log('##########################\n');
};

rpc.exports = {
  dump: function () { dumpSummary(); return Object.keys(services); },
  dumpResp: function () { return out.resps.slice(-6); },
  dumpGzip: function () { return out.gzips.slice(-6); },
  respText: function (i) { const r = out.resps[out.resps.length - 1 - (i || 0)]; return r ? r.raw : null; }
};

console.log('[info] hook v10 loaded.');
console.log('[info] 刷首页后：dumpSummary() / rpc.exports.dumpResp() / rpc.exports.dumpGzip()');