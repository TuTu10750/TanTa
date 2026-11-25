// tanta-hook-v6.js  —— 探他 netshield 抓包 v6
// 相比 v5 补上：sendto / recvfrom / writev / readv + syscall trace
// 用法：frida -U -p <探他PID> -l D:\浏览器\tanta-hook-v6.js
// 重点监听 127.0.0.1:<netshield端口>（本次报告的是 40429，每次启动会变，脚本自动识别）

'use strict';

const NETSHIELD_PORT_HINT = 40429; // 只是提示用，脚本不依赖它

function hexdumpSafe(p, len, max) {
  max = max || 2048;
  if (len > max) len = max;
  try { return hexdump(p, { length: len, ansi: false }); } catch (e) { return '<hexdump fail: ' + e + '>'; }
}

function tryReadString(p, max) {
  try { return p.readUtf8String(max); } catch (e) { return null; }
}

// 从 sockaddr 里解析 IP:port
function parseSockaddr(sa) {
  try {
    const family = sa.readU16();
    if (family === 2) { // AF_INET
      const port = (sa.add(2).readU8() << 8) | sa.add(3).readU8();
      const ip = [sa.add(4).readU8(), sa.add(5).readU8(), sa.add(6).readU8(), sa.add(7).readU8()].join('.');
      return ip + ':' + port;
    }
    if (family === 10) { // AF_INET6
      const port = (sa.add(2).readU8() << 8) | sa.add(3).readU8();
      let parts = [];
      for (let i = 0; i < 16; i += 2) parts.push(sa.add(8 + i).readU16().toString(16));
      return '[' + parts.join(':') + ']:' + port;
    }
    return 'family=' + family;
  } catch (e) { return '<sockaddr err>'; }
}

function findExport(name) {
  // Frida 17 移除了 Module.findExportByName，兼容多版本
  if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name);
  if (typeof Module.getGlobalExportByName === 'function') { try { return Module.getGlobalExportByName(name); } catch (e) {} }
  if (typeof Module.findExportByName === 'function') return Module.findExportByName(null, name);
  // 兜底：手动扫已加载模块
  const mods = Process.enumerateModules();
  for (let i = 0; i < mods.length; i++) {
    try {
      const e = mods[i].findExportByName ? mods[i].findExportByName(name) : null;
      if (e) return e;
    } catch (e2) {}
    try {
      const arr = mods[i].enumerateExports();
      for (let j = 0; j < arr.length; j++) if (arr[j].name === name) return arr[j].address;
    } catch (e3) {}
  }
  return null;
}

function hookExport(name, hooks) {
  const p = findExport(name);
  if (!p) { console.log('[miss] ' + name + ' not found'); return; }
  try {
    Interceptor.attach(p, hooks);
    console.log('[hook] ' + name + ' @ ' + p);
  } catch (e) { console.log('[fail] ' + name + ': ' + e); }
}

function dumpHttpLike(tag, fd, buf, len) {
  if (!buf || len <= 0) return;
  let head = tryReadString(buf, Math.min(len, 1200));
  if (head === null) { console.log(tag + ' fd=' + fd + ' len=' + len + '\n' + hexdumpSafe(buf, len)); return; }
  // 只打印看起来像 HTTP / JSON 的
  const isHttp = /^(GET|POST|PUT|DELETE|HEAD|OPTIONS|HTTP\/1|HTTP\/2)/i.test(head);
  const isJson = /^[\s]*[\[{]/.test(head);
  if (isHttp || isJson) {
    console.log('\n===== ' + tag + ' fd=' + fd + ' len=' + len + ' =====');
    console.log(head.length > 3000 ? head.substring(0, 3000) + '\n...(truncated)' : head);
  } else {
    console.log(tag + ' fd=' + fd + ' len=' + len + ' (非HTTP/JSON 首字节: ' + JSON.stringify(head.substring(0, 40)) + ')');
  }
}

console.log('[info] hook v6 loading...');

// ---- connect：识别目标，标记 netshield fd ----
const loopFds = {};
hookExport('connect', {
  onEnter(args) {
    this.fd = args[0].toInt32();
    try { this.dst = parseSockaddr(args[1]); } catch (e) { this.dst = '<err>'; }
  },
  onLeave(ret) {
    if (ret.toInt32() === 0 || ret.toInt32() === -1) {
      const isLocal = /^127\.0\.0\.1:|^\[::1\]:/.test(this.dst || '');
      if (isLocal) {
        loopFds[this.fd] = this.dst;
        console.log('[connect-lo] fd=' + this.fd + ' -> ' + this.dst);
      } else {
        console.log('[connect] fd=' + this.fd + ' -> ' + this.dst);
      }
    }
  }
});

function tagOf(fd) { return loopFds[fd] ? '[lo:' + loopFds[fd] + ']' : ''; }

// ---- sendto ----
hookExport('sendto', {
  onEnter(args) {
    this.fd = args[0].toInt32();
    this.buf = args[1];
    this.len = args[2].toInt32();
  },
  onLeave(ret) {
    const n = ret.toInt32();
    if (n > 0) dumpHttpLike('[sendto' + tagOf(this.fd) + ']', this.fd, this.buf, n);
  }
});

// ---- recvfrom ----
hookExport('recvfrom', {
  onEnter(args) {
    this.fd = args[0].toInt32();
    this.buf = args[1];
    this.len = args[2].toInt32();
  },
  onLeave(ret) {
    const n = ret.toInt32();
    if (n > 0) dumpHttpLike('[recvfrom' + tagOf(this.fd) + ']', this.fd, this.buf, n);
  }
});

// ---- writev ----
hookExport('writev', {
  onEnter(args) {
    this.fd = args[0].toInt32();
    this.iov = args[1];
    this.cnt = args[2].toInt32();
  },
  onLeave(ret) {
    const n = ret.toInt32();
    if (n <= 0) return;
    // 拼 iov
    try {
      let total = 0, chunks = [];
      for (let i = 0; i < this.cnt && i < 16; i++) {
        const base = this.iov.add(i * 16).readPointer();
        const l = this.iov.add(i * 16 + 8).readU64().toNumber();
        chunks.push(hexdumpSafe(base, l, 512));
        total += l;
      }
      console.log('\n===== [writev' + tagOf(this.fd) + '] fd=' + this.fd + ' iovcnt=' + this.cnt + ' total=' + total + ' =====');
      console.log(chunks.join('\n---iov---\n'));
    } catch (e) { console.log('[writev err] ' + e); }
  }
});

// ---- readv ----
hookExport('readv', {
  onEnter(args) {
    this.fd = args[0].toInt32();
    this.iov = args[1];
    this.cnt = args[2].toInt32();
  },
  onLeave(ret) {
    const n = ret.toInt32();
    if (n <= 0) return;
    try {
      let chunks = [];
      for (let i = 0; i < this.cnt && i < 16; i++) {
        const base = this.iov.add(i * 16).readPointer();
        const l = this.iov.add(i * 16 + 8).readU64().toNumber();
        chunks.push(hexdumpSafe(base, l, 512));
      }
      console.log('\n===== [readv' + tagOf(this.fd) + '] fd=' + this.fd + ' iovcnt=' + this.cnt + ' =====');
      console.log(chunks.join('\n---iov---\n'));
    } catch (e) { console.log('[readv err] ' + e); }
  }
});

// ---- 保留 send/recv 兼容（v4/v5 已证明无数据，留着兜底）----
hookExport('send', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 0) dumpHttpLike('[send' + tagOf(this.fd) + ']', this.fd, this.buf, n); }
});
hookExport('recv', {
  onEnter(a) { this.fd = a[0].toInt32(); this.buf = a[1]; this.len = a[2].toInt32(); },
  onLeave(r) { const n = r.toInt32(); if (n > 0) dumpHttpLike('[recv' + tagOf(this.fd) + ']', this.fd, this.buf, n); }
});

// ---- syscall trace（最后兜底：如果上面全无输出，说明走裸 syscall）----
hookExport('syscall', {
  onEnter(args) {
    // 只关心 sendto/recvfrom/sendmsg/recvmsg 的 syscall 号
    // aarch64: sendto=206 recvfrom=207 sendmsg=211 recvmsg=212
    try {
      const nr = args[0].toInt32();
      this.isNet = [206, 207, 211, 212].indexOf(nr) >= 0;
      if (this.isNet) {
        this.nr = nr;
        // syscall(nr, fd, buf, len, ...)
        this.fd = args[1].toInt32();
        this.buf = args[2];
        this.len = args[3].toInt32();
        console.log('[syscall] nr=' + nr + ' fd=' + this.fd + ' len=' + this.len);
      }
    } catch (e) {}
  },
  onLeave(ret) {
    if (this.isNet && ret.toInt32() > 0) {
      dumpHttpLike('[syscall-' + this.nr + tagOf(this.fd) + ']', this.fd, this.buf, ret.toInt32());
    }
  }
});

console.log('[info] hook v6 loaded. 刷首页，看 [sendto-lo] / [recvfrom-lo] / [writev-lo] / [syscall] 输出');