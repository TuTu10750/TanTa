// 探他 (Tanta) 抓包 hook v5
// 相对 v4 的改动（v4 已验证能 attach 上，抓到大量 [connect-lo] 到 127.0.0.1:40429，
// 但一条 [send-lo]/[recv-lo] 都没有 —— 说明 App 发数据没走 libc 的 send/recv，
// 很可能走的是 sendmsg/recvmsg（Boost.Asio/curl 常用）或 write/read）：
//   1) 新增 hook sendmsg / recvmsg（读 msghdr 里的第一个 iovec）。
//   2) 新增 hook write / read（只看 fd 在回环表里的，即连向 127.0.0.1 的 socket；
//      文件读写不在表里，不会误报）。
//   3) 保留 v4 的全部 hook（connect/getaddrinfo/send/recv/close）。
// 用法（App 先手动打开、停在首页，再贴；不要用 -f 启动）：
//   frida -U -p <PID> -l tanta-hook-v5.js
// 关键输出：[connect-lo] 是连本地代理的端口（已确认是 40429），
//           [send-lo]/[sendmsg-lo]/[write-lo] 是发给本地代理的 HTTP（应含 /appapi/...），
//           [recv-lo]/[recvmsg-lo]/[read-lo] 是本地代理回的 API 响应（应含 "code"/"data"）。
// 注意：进程名是「探他」，不要用 -n <包名>，用 -p <PID>。

function log(tag, msg) {
  send('[' + tag + '] ' + msg);
}

// ---- fd -> "ip:port" ----
var fdMap = {};

log('diag', 'Process.getModuleByName=' + typeof Process.getModuleByName +
  ' Process.enumerateModules=' + typeof Process.enumerateModules +
  ' Interceptor.attach=' + typeof Interceptor.attach);

var libc = null;
try {
  libc = Process.getModuleByName('libc.so');
} catch (e) {
  log('diag', 'getModuleByName threw: ' + e);
}
if (!libc) {
  try {
    var mods = Process.enumerateModules();
    for (var i = 0; i < mods.length; i++) {
      if (mods[i].name === 'libc.so' || mods[i].path.indexOf('/libc.so') !== -1) {
        libc = mods[i];
        break;
      }
    }
    log('diag', 'libc via enumerateModules: ' + (libc ? libc.name + ' @ ' + libc.base : 'null'));
  } catch (e) {
    log('diag', 'enumerateModules failed: ' + e);
  }
}
if (libc) {
  log('diag', 'libc module: ' + libc.name + ' @ ' + libc.base +
    ' findExportByName=' + typeof libc.findExportByName +
    ' enumerateExports=' + typeof libc.enumerateExports);
}

function hookFn(name, callbacks) {
  if (!libc) {
    log('err', name + ': no libc module');
    return;
  }
  var ptr = null;
  try {
    ptr = libc.findExportByName(name);
  } catch (e) {
    log('err', name + ' findExportByName threw: ' + e);
    return;
  }
  if (ptr === null) {
    log('err', name + ': not found in libc.so');
    return;
  }
  try {
    Interceptor.attach(ptr, callbacks);
    log('info', name + ' hooked @ ' + ptr);
  } catch (e) {
    log('err', name + ' attach failed: ' + e);
  }
}

function parseAddr(addr) {
  // 返回 { ip, port } 或 null
  try {
    var family = addr.readU16();
    if (family === 2) { // AF_INET
      var port = (addr.add(2).readU8() << 8) | addr.add(3).readU8();
      var ip = addr.add(4).readU8() + '.' + addr.add(5).readU8() + '.' +
               addr.add(6).readU8() + '.' + addr.add(7).readU8();
      return { ip: ip, port: port };
    }
  } catch (e) {}
  return null;
}

function isLoopback(dest) {
  return !!dest && dest.indexOf('127.0.0.1:') === 0;
}

// 把一段内存尽量读成文本，读不出就给 hex 前缀，方便确认到底有没有数据在走
function preview(buf, len, maxChars) {
  if (!buf || len <= 0) return null;
  try {
    var n = Math.min(len, maxChars || 1024);
    var s = buf.readUtf8String(n);
    if (s && s.length > 0) return s;
  } catch (e) {}
  try {
    var n2 = Math.min(len, 64);
    var hex = '';
    for (var i = 0; i < n2; i++) {
      var b = buf.add(i).readU8();
      hex += ('0' + b.toString(16)).slice(-2) + ' ';
    }
    return '[hex ' + len + 'B] ' + hex;
  } catch (e) {}
  return null;
}

// ---- connect：全部记下来，回环单独标 [connect-lo] ----
hookFn('connect', {
  onEnter: function (args) {
    try {
      var fd = args[0].toInt32();
      var dst = parseAddr(args[1]);
      if (dst) {
        var dest = dst.ip + ':' + dst.port;
        fdMap[fd] = dest;
        if (isLoopback(dest)) {
          log('connect-lo', 'fd=' + fd + ' -> ' + dest);
        } else {
          log('connect', 'fd=' + fd + ' -> ' + dest);
        }
      }
    } catch (e) {}
  }
});

// ---- getaddrinfo：看查了什么域名 ----
hookFn('getaddrinfo', {
  onEnter: function (args) {
    try {
      var host = args[0].readCString();
      if (host) log('dns', host);
    } catch (e) {}
  }
});

// ---- send：回环全文 dump，非回环只记含 /appapi/ 或 Host: 的 ----
function dumpBuf(tag, buf, len, force) {
  if (len <= 0 || len > 16384) return;
  try {
    var s = preview(buf, len, 1024);
    if (!s) return;
    if (force || s.indexOf('/appapi/') !== -1 || s.indexOf('Host:') !== -1 ||
        s.indexOf('"code"') !== -1 || s.indexOf('"data"') !== -1) {
      var head = s.split('\r\n').slice(0, 10).join(' | ');
      log(tag, head);
    }
  } catch (e) {}
}

hookFn('send', {
  onEnter: function (args) {
    try {
      var fd = args[0].toInt32();
      var lo = isLoopback(fdMap[fd]);
      dumpBuf(lo ? 'send-lo' : 'send', args[1], args[2].toInt32(), lo);
    } catch (e) {}
  }
});

// ---- recv：回环全文 dump，非回环只记含 /appapi/ / "code" / "data" / HTTP 的 ----
hookFn('recv', {
  onEnter: function (args) {
    try {
      this.fd = args[0].toInt32();
      this.buf = args[1];
    } catch (e) {}
  },
  onLeave: function (retval) {
    try {
      var len = retval.toInt32();
      if (len > 0 && len < 65536) {
        var lo = isLoopback(fdMap[this.fd]);
        dumpBuf(lo ? 'recv-lo' : 'recv', this.buf, Math.min(len, 2048), lo);
      }
    } catch (e) {}
  }
});

// ---- sendmsg：msghdr +16 是 msg_iov 指针，+24 是 iov 数量；只读第一个 iovec ----
// 64 位 struct msghdr: name(0,8) namelen(8,4) pad(12,4) iov(16,8) iovlen(24,8) ...
// 64 位 struct iovec: base(0,8) len(8,8)
function firstIovec(msg) {
  try {
    var iov = msg.add(16).readPointer();
    if (iov.isNull()) return null;
    var base = iov.readPointer();
    var len = iov.add(8).readU64().toNumber();
    if (base.isNull() || len <= 0) return null;
    return { base: base, len: len };
  } catch (e) {}
  return null;
}

hookFn('sendmsg', {
  onEnter: function (args) {
    try {
      var fd = args[0].toInt32();
      var lo = isLoopback(fdMap[fd]);
      var iv = firstIovec(args[1]);
      if (iv) dumpBuf(lo ? 'sendmsg-lo' : 'sendmsg', iv.base, Math.min(iv.len, 16384), lo);
    } catch (e) {}
  }
});

hookFn('recvmsg', {
  onEnter: function (args) {
    try {
      this.fd = args[0].toInt32();
      this.msg = args[1];
    } catch (e) {}
  },
  onLeave: function (retval) {
    try {
      var len = retval.toInt32();
      if (len > 0 && len < 65536) {
        var lo = isLoopback(fdMap[this.fd]);
        var iv = firstIovec(this.msg);
        if (iv) dumpBuf(lo ? 'recvmsg-lo' : 'recvmsg', iv.base, Math.min(len, 2048), lo);
      }
    } catch (e) {}
  }
});

// ---- write / read：只看 fd 在回环表里的（socket）；文件读写不在表里 ----
hookFn('write', {
  onEnter: function (args) {
    try {
      var fd = args[0].toInt32();
      var lo = isLoopback(fdMap[fd]);
      if (lo) dumpBuf('write-lo', args[1], args[2].toInt32(), true);
    } catch (e) {}
  }
});

hookFn('read', {
  onEnter: function (args) {
    try {
      this.fd = args[0].toInt32();
      this.buf = args[1];
    } catch (e) {}
  },
  onLeave: function (retval) {
    try {
      var len = retval.toInt32();
      if (len > 0 && len < 65536 && isLoopback(fdMap[this.fd])) {
        dumpBuf('read-lo', this.buf, Math.min(len, 2048), true);
      }
    } catch (e) {}
  }
});

// ---- close：清 fd 表 ----
hookFn('close', {
  onEnter: function (args) {
    try {
      delete fdMap[args[0].toInt32()];
    } catch (e) {}
  }
});

log('info', 'hook v5 loaded, waiting for traffic...');
