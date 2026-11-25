// tanta-hook-v7.js —— 精简版：只盯收方向和出站
// 目标：找到 netshield 解密后的明文（响应 JSON / Host 头）
// 用法：frida -U -p <探他PID> -l tanta-hook-v7.js
// v7 相比 v6 的改动：
//   1. sendto 只打摘要（len + 前 32 字节 hex），不刷屏
//   2. recvfrom 全文 dump（找明文 JSON / HTTP 头）
//   3. 额外 hook 出站 connect 目标，识别 47.243.x 那种外部服务器
//   4. 不再 hook write/read/syscall（v6 已证明无数据）

'use strict';

function findExport(name) {
  if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
  if (typeof Module.getGlobalExportByName === 'function') { try { return Module.getGlobalExportByName(name); } catch (e) {} }
  if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
  const mods = Process.enumerateModules();
  for (let i = 0; i < mods.length; i++) {
    try { const a = mods[i].enumerateExports(); for (let j = 0; j < a.length; j++) if (a[j].name === name) return a[j].address; } catch (e2) {}
  }
  return null;
}

function hex32(p, len) {
  const n = Math.min(len, 32);
  try { return Array.from(new Uint8Array(p.readByteArray(n))).map(b => b.toString(16).padStart(2, '0')).join(' '); }
  catch (e) { return '<err>'; }
}

function tryStr(p, max) {
  try { return p.readUtf8String(max); } catch (e) { return null; }
}

function looksPlain(s) {
  if (!s) return false;
  // HTTP 头 / JSON / URL / 域名特征
  return /^(GET |POST |PUT |DELETE |HEAD |OPTIONS |HTTP\/)/i.test(s)
      || /^[\s]*[\[{"]/.test(s)
      || /https?:\/\//i.test(s)
      || /Host:\s*\S+/i.test(s)
      || /\bappapi\b/i.test(s)
      || /\.[a-z]{2,6}\b/.test(s.slice(0, 200));
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

const localFds = {};   // fd -> dst，标记本地回环
const remoteFds = {};  // fd -> dst，标记外部

function hookExport(name, hooks) {
  const p = findExport(name);
  if (!p) { console.log('[miss] ' + name); return; }
  try { Interceptor.attach(p, hooks); console.log('[hook] ' + name + ' @ ' + p); }
  catch (e) { console.log('[fail] ' + name + ': ' + e); }
}

console.log('[info] hook v7 loading ...');

hookExport('connect', {
  onEnter(a) { this.fd = a[0].toInt32(); this.dst = parseSockaddr(a[1]); },
  onLeave(r) {
    const d = this.dst || '';
    if (/^127\.0\.0\.1:|^\[::1\]:/.test(d)) { localFds[this.fd] = d; console.log('[connect-lo] fd=' + this.fd + ' -> ' + d); }
    else { remoteFds[this.fd] = d; console.log('[connect-OUT] fd=' + this.fd + ' -> ' + d); }
  }
});

// 发方向：只打摘要
hookExport('sendto', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    console.log('[sendto] fd=' + this.fd + ' len=' + n + ' head=' + hex32(this.buf, n));
  }
});

// 收方向：全文找明文
hookExport('recvfrom', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) {
    const n = r.toInt32(); if (n <= 0) return;
    const s = tryStr(this.buf, Math.min(n, 4096));
    if (looksPlain(s)) {
      console.log('\n========== [recvfrom-PLAIN] fd=' + this.fd + ' len=' + n + ' ==========');
      console.log(n > 4000 ? s.substring(0, 4000) + '\n...(截断)' : s);
      console.log('========== end ==========\n');
    } else {
      console.log('[recvfrom] fd=' + this.fd + ' len=' + n + ' (密文/二进制) head=' + hex32(this.buf, n));
    }
  }
});

console.log('[info] hook v7 loaded.');
console.log('[info] 关键看两样：1) [recvfrom-PLAIN] 出现明文  2) [connect-OUT] 有哪些外部服务器');
console.log('[info] 先刷首页 2 分钟，再点进一个房间');