# 探他（Tanta）逆向成果档案

生成时间：2026-11-24
状态：静态逆向完成；业务域名需运行时获取（真机抓包）

## 一、已确认事实

### 应用身份
- 系统：云豹直播（com.yunbao），包名 xewedbjdjc.fxhfwv.jyxhcmtmy
- 版本 3.9.2.5，versionCode 15，minSdk 26 / targetSdk 34
- 内部标识：包名字符串 com.tanta.livenew（j30.y 字段）
- APK：d1ot6fb0ebt00m.cloudfront.net/tanta-3295-sf.apk（57,282,624 字节，已下载）
- 落地页：feiief.me/?share_code=9WUA4N

### 网络架构（关键）
- App 所有业务请求发往 `http://127.0.0.1:<port>/appapi/`
- port = Netshield.getLocalhostPort("n_11000;11000")
- libnetshield.so 是本地透明代理，启动时连远程配置服务器拉真实域名/路由
- 所以：包内无明文业务域名，静态扫描 dex/so 全部无果（已验证）
- 证书锁定 assets/server.cer，CN=data.facegl.com（美狐美颜 SDK 域名，非业务域名，实测 appapi 只有 Auth/Gift 空壳）

### 启动配置
- LauncherActivity: `Netshield.startService("998", "de62d3e947ab10496b1c9090915d2d04")`
- 998 = appid；de62d3e947ab10496b1c9090915d2d04 = 32位密钥（可能是 MD5/AES key）
- 解密密钥（so 内异或）：975f8169d9154d47（8 字节循环 XOR）

### Auth 签名
- GET/POST `https://data.facegl.com/appapi/Auth/index` 返回
  `{"code":1001,"msg":"非法请求","timestamp":"<13位>","sign":"<64字节base64>"}`
- sign 前 32 位跨请求固定 → 对固定内容签名，非请求签名
- 该域名是空壳，仅 Auth/Gift 两个控制器存活

## 二、完整接口路径清单（来自 wg1.java）

所有 URL = j30.o() + 路径，j30.o() = "http://127.0.0.1:"+port

- /appapi/Auth/index          登录认证
- /appapi/home/index?touid=  首页
- /appapi/Detail/index       房间详情
- /appapi/video/index?videoid=  视频
- /appapi/contribute/index?uid= 打赏
- /appapi/charge/index       充值
- /appapi/cash/index         提现
- /appapi/shopcash/index?
- /appapi/Mall/index         商城
- /appapi/Express/index?
- /appapi/Goodsorderrefund/index?
- /appapi/Pay/notify_ali
- /appapi/Shoppay/notify_ali
- /appapi/Paidprogrampay/notify_ali
- /appapi/Auth/index?
- /appapi/game/xqtb.html
- /appapi/game/xydzp.html
- /portal/page/index?id=4/6/26/35/39/40/45

### 公共参数
j30.p() 给 URL 追加：&uid=<C()>&token=<B()>&language=<rx1.c().d()>
未登录 uid/token = -9999

### HTTP 客户端
- FuelHttpClient：URL = "http://127.0.0.1:"+port+"/appapi/"
- TLS 校验被写死全信任（return true），无需证书
- 会话走 CookieManager ACCEPT_ALL

### 直播流
- LiveAnchorActivity: `new SocketClient("ws://127.0.0.1:"+Netshield.getLocalhostPort(j30.H()))`
- j30.H() = "n_12000;12000"（WS 走独立端口）
- 推流用 libanyLive.so（AnyRTC）

## 三、关键源码文件（沙箱 /tmp/jout2/sources）
- defpackage/wg1.java          接口路径清单
- defpackage/j30.java          全局配置、域名构造、uid/token
- com/yunbao/common/http/fuel/FuelHttpClient.java  HTTP 客户端
- com/yunbao/phonelive/activity/LauncherActivity.java  netshield 启动密钥
- com/netshield/Netshield.java  JNI 接口定义

## 六、APK 哈希核对（2026-11-24 14:00）
- 爸爸版本：57,282,896 字节，sha256 `2d204f7ee9f719426bcc856a1e2b1dba0b7e9231c656547688c6ab04dade52ed`
- 沙箱首份：57,282,624 字节，sha256 `821213787a6c43ef5189ceb6a3c48fd82e578071ce7113c5da33841d2b6c711d`
- 直链重下：57,284,717 字节，sha256 `1e0e6c9a527faa3c3df269cf4269a839db76f5bd47cdb5b69fafb460f606988c`
- 多次下载还出现过 4,235,063 字节残包
- **结论：三份全不同，服务器在动态换包**（落地页源码注释"Redis 同步的下载地址"印证）
- 但反编译出的架构/接口/密钥与爸爸那轮静态分析完全一致 → 结论可信，与具体包版本无关
- 源码已永久保存：`/opt/tanta_research/sources`（3936 文件）+ libnetshield.so / classes2.dex / tanta.apk 同目录

## 八、classes.dex 补拆（2026-11-24 14:15）
- 之前只反编译了 classes2.dex；classes.dex（7,903,784 字节，4486 类）补拆完成
- 存于 `/opt/tanta_research/jout1/sources`
- 含 com/yunbao 11 个类、com/netshield 2 个类
- 发现 `RsaDecryptUtil.java`（硬编码 RSA-2048 私钥）+ `ApiSecurityExample.java`（HMAC-SHA1/256）
- **但全源码零调用点** → 死代码/示例，非活机制，排除
- 两个 dex 合起来确认：无任何明文业务域名

## 七、Unidbg 动态模拟尝试（失败）
- 目的：无设备直接跑 so，hook connect 抓域名 = 静态环境下的 Frida
- Unidbg 0.9.10 编译成功（Maven + JDK25，跳过 gpg/javadoc）
- 卡死点：unicorn native 库版本死结——`unicorn-1.0.15.jar` 的 `libunicorn_java.so` 依赖 `helper_div_i32`，与 `unidbg-unicorn2` 的 `libunicorn.so` 不配套；换配套库则缺 `unicorn.UnicornException` 类
- 结论：此路不通，停止

## 四、已排除的路线（全部实测失败）
- `data.facegl.com`：空壳，非业务域名
- `qghly.ktbata.cn:8443`：iOS 企业签分发页，302 到百度云
- OSS bucket 猜测（998/netshield/tanta/派生 md5）：全 AccessDenied/NoSuchBucket
- so 静态字符串全扫（明文/异或/逐字节/SIMD）：无业务域名
- Ghidra 反编译 so：环境跑通但反编译卡死
- qemu 直接跑 so：缺 Android 运行库，卡死

## 五、下一步（唯一可行路线）
真机抓包：装 App，用 HTTP 抓包工具对 127.0.0.1 本地端口抓包，
拿到 netshield 转发的目标域名 + /appapi/home/index 返回结构，
即可在 Rex 里复刻接口。
