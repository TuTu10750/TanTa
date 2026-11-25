// tanta-hook-v8.js —— 抓全：真接口清单 + 请求/响应全文
// v7 已证明：明文 HTTP 在本地回环上跑（不是加密），只是 v7 只打了 32 字节头
// v8 改动：
//   1. sendto / recvfrom 双向都判断明文，HTTP 请求/响应全文打印
//   2. 自动收集所有 service=XXX，尾部汇总真实接口清单
//   3. 打印 uid/token/signplus，方便复刻
// 用法：frida -U -p <探他PID> -l tanta-hook-v8.js
// 想随时看汇总：输入 rpc.exports.dump() 或等末尾输出

'use strict';

const services = {};   // service名 -> count
let reqCount = 0;
let respCount = 0;

function findExport(name) {
  if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
  if (typeof Module.getGlobalExportByName === 'function') { try { return Module.getGlobalExportByName(name); } catch (e) {} }
  if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
  return null;
}

function tryStr(p, max) {
  try { return p.readUtf8String(max); } catch (e) { return null; }
}

// 严格判断是不是明文 HTTP / JSON
function classify(s) {
  if (!s) return null;
  if (/^GET |^POST |^PUT |^DELETE |^HEAD |^OPTIONS /i.test(s)) return 'request';
  if (/^HTTP\/1\.[01] \d{3}/i.test(s)) return 'response';
  if (/^[\s]*[\[{]/.test(s) && /"/.test(s)) return 'json';
  return null;
}

function parseSockaddr(sa) {
  try {
    const fam = sa.readU16();
    if (fam === 2) {
      const port = (sa.add(2).readU8() << 8) | sa.add(3).readU8();
      return [sa.add(4).readU8(), sa.add(5).readU8(), sa.add(6).readU8(), sa.add(7).readU8()].join('.') + ':' + port;
    }
    if (fam === 10) {
      const port = (sa.add(2).readU8() << 8) | sa.add(3).readU8();
      let parts = []; for (let i = 0; i < 16; i += 2) parts.push(sa.add(8 + i).readU16().toString(16));
      return '[' + parts.join(':') + ']:' + port;
    }
    return 'family=' + fam;
  } catch (e) { return '<?>'; }
}

const localFds = {};

function extractServices(s) {
  const re = /service=([A-Za-z0-9_.]+)/g;
  let m;
  while ((m = re.exec(s)) !== null) {
    const name = m[1];
    services[name] = (services[name] || 0) + 1;
  }
}

function extractAuth(s) {
  const out = {};
  const pick = (k) => { const m = s.match(new RegExp(k + '=([^&\\s\\r\\n]+)')); return m ? m[1] : null; };
  ['uid', 'token', 'signplus', 'timestamp'].forEach(k => { const v = pick(k); if (v) out[k] = v; });
  return out;
}

function dumpFull(tag, s, n) {
  console.log('\n========== ' + tag + ' len=' + n + ' ==========');
  console.log(n > 6000 ? s.substring(0, 6000) + '\n...(截断，原始长 ' + n + ')' : s);
  console.log('========== end ==========\n');
}

function hookExport(name, hooks) {
  const p = findExport(name);
  if (!p) { console.log('[miss] ' + name); return; }
  try { Interceptor.attach(p, hooks); console.log('[hook] ' + name + ' @ ' + p); }
  catch (e) { console.log('[fail] ' + name + ': ' + e); }
}

console.log('[info] hook v8 loading ...');

hookExport('connect', {
  onEnter(a) { this.fd = a[0].toInt32(); this.dst = parseSockaddr(a[1]); },
  onLeave(r) {
    const d = this.dst || '';
    if (/^127\.0\.0\.1:|^\[::1\]:|7f:100/.test(d)) { localFds[this.fd] = d; }
    else { console.log('[connect-OUT] fd=' + this.fd + ' -> ' + d); }
  }
});

// 发方向（App -> 本地代理 的请求）
hookExport('sendto', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    const s = tryStr(this.buf, Math.min(n, 8192));
    const kind = classify(s);
    if (kind === 'request' || kind === 'json') {
      reqCount++;
      extractServices(s);
      const auth = extractAuth(s);
      if (Object.keys(auth).length) console.log('[AUTH] fd=' + this.fd + ' ' + JSON.stringify(auth));
      dumpFull('[REQ' + (localFds[this.fd] ? '-lo' : '') + '] fd=' + this.fd, s, n);
    }
  }
});

// 收方向（本地代理 -> App 的响应）
hookExport('recvfrom', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    const s = tryStr(this.buf, Math.min(n, 8192));
    const kind = classify(s);
    if (kind === 'response' || kind === 'json') {
      respCount++;
      dumpFull('[RESP] fd=' + this.fd, s, n);
    }
  }
});

// 汇总输出
globalThis.dumpSummary = function () {
  console.log('\n\n########## 真实接口清单（service= 收集）##########');
  const keys = Object.keys(services).sort();
  if (!keys.length) { console.log('(还没抓到任何 service=，先刷首页)'); return; }
  keys.forEach(k => console.log('  ' + k + '   x' + services[k]));
  console.log('########## 共 ' + keys.length + ' 个 service，' + reqCount + ' 个请求，' + respCount + ' 个响应 ##########\n');
};

rpc.exports = { dump: function () { dumpSummary(); return Object.keys(services); } };

console.log('[info] hook v8 loaded.');
console.log('[info] 刷首页 + 点房间，抓够后输入：dumpSummary()');
console.log('[info] 或者在 frida 里输入：rpc.exports.dump()');