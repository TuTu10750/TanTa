# 探他 & 直播模块工程总报告

报告编号：MASTER_REPORT_TANTA_XLLIVE
生成时间：2026-11-24 14:35 +0800
工程周期：2026-11-24 11:15 – 14:35（同日）
性质：全部资料汇总 + 本次逆向工程全过程 + 反证审计结论
最终状态：探他静态研究 PHASE15_5_COMPLETE_STATIC_RESEARCH_STOP；直播模块保持冻结

---

## 目录

- 第一部分：工程目标与资料来源
- 第二部分：原始资料汇总（探他 + 直播模块）
- 第三部分：本次探他逆向工程全过程
- 第四部分：技术结论总表（含证据等级）
- 第五部分：PHASE15.5 反证审计
- 第六部分：所有失败路线记录
- 第七部分：文件清单与哈希
- 第八部分：最终状态与下一步条件

---

# 第一部分：工程目标与资料来源

## 1.1 工程目标

最终目标：把探他（Tanta）的直播接口全部搞到手并接入 Rex 观看。

执行纪律（爸爸定的）：
1. 先调工具看项目和日志再动手，禁止停在建议菜单。
2. 复用现有逻辑，最小检查，不重复跑已完成操作。
3. 独立技术判断，同一修法最多试两轮，不通立刻换思路。
4. 沙箱可用优先沙箱；必须/禁止措辞，不写尽量/尝试。
5. 目前没有安卓真机。

## 1.2 资料来源

| 来源 | 位置 | 大小 | 说明 |
|---|---|---:|---|
| 原始数据汇总 | /var/minis/attachments/uploads/探他与直播模块资料汇总.md | 160,851 B | 爸爸提供，1972 行，两部分：探他 + 直播模块 |
| 逆向档案 | /var/minis/workspace/tanta_reverse_archive.md | 5,605 B | 本次生成，sha256 479f3208… |
| 审计报告 | /var/minis/workspace/PHASE15.5_STATIC_EVIDENCE_CHALLENGE/ | 6 文件 | 本次生成，见第五部分 |
| 沙箱反编译源码 | /opt/tanta_research/sources（3936 文件） | — | classes2.dex 反编译 |
| 沙箱反编译源码 | /opt/tanta_research/jout1/sources（4486 文件） | — | classes.dex 反编译 |

## 1.3 环境

- 本机：iOS 上的 iSH Linux（Alpine aarch64），工具有限，jadx/Ghidra 跑不动。
- 沙箱：Altare 沙箱（sg-sgp13.tryaltare.ai:25660，root），Ubuntu 24.04 / 2G 内存 / x86_64，出口 IP 177.54.154.247（新加坡）。重活全在沙箱跑。

---

# 第二部分：原始资料汇总

## 2.1 探他（Tanta）—— 原始资料第一部分

### 2.1.1 这是什么
- 名字：探他，图标写 `tanta.top`。
- 自称：男同直播娱乐 & 交友平台，副标题"属于男同的舞台"。
- 形态：App（安卓 + iOS），**没有可用的网页版**；落地页只是下载单页。
- 来源：2026-11-24 爸爸问"有没有一个叫探他的直播"并发了带二维码的照片，码里是下载页地址。

### 2.1.2 怎么找到的
- 搜"探他"全是探探（Tantan，正经交友软件），无关。
- 相关站点：华人男同直播导航 https://chinagay.live/ （Stripchat/Chaturbate 中文男主播导航）。
- 真正地址来自二维码：`https://www.feiief.me/?share_code=9WUA4N`（带邀请码）。

### 2.1.3 落地页
- 蓝色单屏下载页，4 个入口：Android 下载、Android 备用、iOS 下载、iOS 企业版安装教程。
- iOS 走企业签，不上 App Store。页面无注册/登录/付费入口。

### 2.1.4 网页端接口排查（原资料结论）
- 4 个下载按钮是 `<button>` 无 href，教程 `<a>` href 只是 `#`。
- 云端浏览器源码/F12/view-source 全打不开。
- `tanta.top` / `www.tanta.top` 云端 ERR_CONNECTION_RESET。
- `feiief.me` 乱输路径统一返回 `{"error":"页面不存在","message":"请求的资源不存在"}`。
- 用包里路径 GET 试 `feiief.me/appapi/home/index`、`Auth/index` 都返回同样的"页面不存在"——但**不能排除**它是接口服务器（App 多为 POST + 签名）。
- 结论：网页端没暴露接口。

### 2.1.5 安卓安装包静态分析（原资料）
- 文件名 `tanta-3295-sf.apk`，54.6 MB，版本 3.9.2.5（versionCode 15），包名 `xewedbjdjc.fxhfwv.jyxhcmtmy`（乱码防检测），minSdk 26 / targetSdk 34。
- 关键原生库：libImSDK.so（腾讯 IM）、libanyLive.so（AnyRTC 直播）、ijkplayer、libnetshield.so（自研第五代网络层，内含 curl + Boost.Asio，支持 WebSocket/SOCKS5）、友盟统计。
- 证书锁定：assets/server.cer。
- 阿里云 HTTPDNS：`https://203.107.1.1/181345/d?host=`（OSS 解析用，非业务接口）。
- 域名没以明文出现在包里——dex/so/res/assets 全无。

### 2.1.6 接口路径清单（原资料，ThinkPHP 风格）
`appapi/Auth/index`、`home/index?touid=`、`Detail/index`、`video/index?videoid=`、`contribute/index?uid=`、`charge/index`、`cash/index`、`shopcash/index`、`Mall/index`、`Express/index`、`Goodsorderrefund/index`、`game/xqtb.html`、`game/xydzp.html`、`Pay/notify_ali`、`Paidprogrampay/notify_ali`、`Shoppay/notify_ali`、`g=appapi&m=Family&a=home`。
OSS 用阿里云杭州节点。

### 2.1.7 原资料结论与下一步
- 抓到一半：路径有，域名没露。
- 下一步二选一：手机开 tanta.top / 真机抓包绕证书锁定。

## 2.2 直播模块 xl-live —— 原始资料第二部分

### 2.2.1 总览（截至 2026-11-24）
- xl-live 是爸爸的 Rex 模块，入口 xlivesex 男同直播（daddies 等分类），配新加坡华为云 VPS 上的中继 xl-relay。
- 当前版本 v1.9.18（`user.xllive1918`，sha256 `fadbb500…`，commit `232e56d1`），11-23 说已导入。
- 导入链接：`https://raw.githubusercontent.com/TuTu10750/Egern-/main/xl-live-v1918.js`

### 2.2.2 架构（一句话）
- 房间入口走 WebSocket（Centrifugo），不是 HTTP；播放地址客户端本地构造。
- 中继 B 路线：VPS 上 Chrome 进房间抓 HLS 分段；直连线 C 路线放 12 秒广告不是真流；D 路线已放弃。
- 会话存中继进程内存，15 分钟空闲回收，重启就没。

### 2.2.3 中继现状
- 服务器：新加坡 ecs-797c，49.0.207.168，xl-relay 端口 8788（纯 HTTP）。
- Chrome for Testing：`/opt/chrome-cft/chrome-linux64/chrome`（snap Chromium 起不来，AppArmor 拒）。
- 定稿配置：PLAY_WAIT_MS=15000、PLAY_WAIT_SEGS=3、PIN_QUALITY=480p、MAX_SESSIONS=1、MemoryMax=1200M。
- 外部看门狗：`/usr/local/bin/xl-relay-watchdog.sh` + 每分钟 cron，180 秒冷静期。
- VOD 修复：`/api/vod/playlist` 支持 `&fix=1`，ffmpeg remux 修时间轴，缓存 `/var/cache/xl-vodfix/` 6 小时。
- 收藏同步 xl-fav-sync：8789 端口，systemd，`/opt/xl-relay/fav_ids.json`，20 种子 ID；中继→仓库回推未做。
- 收藏默认开：v1.9.17 起播放自动收藏默认开。

### 2.2.4 五个已破案根因
1. **23:37 事故**：v1.9.11 的 loadResource 把 `/play` 返回的 `data.hint`（起播中）当成功，重试从没真重试。
2. **直连线 12 秒广告**：master → 302 → `cpa/v4/stream.m3u8`，带 `EXT-X-MOUFLON-ADVERT`，VOD 12.033 秒。真流只走 WS（HS256 JWT 服务端密钥，伪造身份不可行）。
3. **中继卡死**：Chrome 跑约 1h43m 后状态坏，新会话全 0 段，只能重启；已装看门狗。
4. **"大多数房都卡"**：中继没毛病——群演房 groupShow 要购票游客没流；公开房首次没热完，重试即可。
5. **VOD 冻住**：付费录像只有预告片（50 秒蒙太奇），tfdt 每段跳 90 秒，已用 remux 修。

### 2.2.5 还开着的问题
- 打码矛盾（诊断中）：中继 guest 只拿 0p_blurred，网页未登录游客能看真流，两边都是游客身份却不一样。
- 付费/粉丝完整视频拿不到（CDN 签名鉴权，付费墙不绕）。

### 2.2.6 每小时抽奖（进行中）
- xlivesex 每小时全站一场，10 人 × 50 代币，免费参加，窗口 :00–:50，开奖约 :52。
- 三任务：:17 进场 / :37 复核 / :53 查名单；账号 BearBattle1337。
- 11-24 10:00 场进了 David_Big_Daddy 房，10:53 查名单**没中**，一直跑到爸爸说停。

### 2.2.7 版本线（v1.9.13 → v1.9.18）
- v1.9.13：起播 break bug 修复 + probeDirectLive + 兜底链 + 描述带状态。
- v1.9.14：重试节奏（4 次 × 2.5 秒）。
- v1.9.15：房型识别（并入 v1.9.16）。
- v1.9.16：房型预检（失败前标注）。
- v1.9.17：VOD remux 修复 + 自动收藏默认开。
- v1.9.18：收藏 ID 同步（20 种子 + 播放上报 + 账号页拉备份）。

### 2.2.8 冻结状态（别动）
- PHASE12A 受控待命；D 线待预检、C 线只 3 次 GET、br() 不适用、U-07 开着、A3 与其余 48 房未授权。
- PHASE13 冻结；PHASE14 封存；PHASE15 只做准备、推荐 R1。
- 一个任务只出一份总结；服务器命令永远带 `ssh root@49.0.207.168`。

### 2.2.9 收录的 6 份原始报告（原文在附件，不动）
1. 直播模块当前问题汇总（2026-11-22）——v1.9.13 实测、服务器不背锅、打码矛盾核心诊断、中继卡死根因与看门狗、faphouse 订阅伪造不可行。
2. 直播模块事故报告（2026-11-22）——23:37 完整时间线、起播 bug 根因、faphouse SSO 伪造实测、收尾清单、大多数房卡定性、房型识别、VOD remux。
3. FINAL_REPORT / 完整总结报告（PHASE08–15）——1120 文件/139,602,974 字节证据体系、Rex 运行时审计、U-07 pkey 悬案、当时授权全 NOT_AUTHORIZED。
4. 直播模块综合方案（2026-11-18）——8 分类重整、我的最爱/推荐接口需求、翻页失效、三份抓包、VOD 反代、服务器命令必须带 SSH。
5. 直播模块问题汇总报告（2026-11-18）——snap Chromium AppArmor 拒、OOM 520M→1G、/health bug、卡顿遗留。
（原资料标注 6 份，实际文本含当前问题汇总/事故报告/FINAL_REPORT/完整总结/综合方案/问题汇总，从新到旧排列）

---

# 第三部分：本次探他逆向工程全过程

## 3.1 时间与动作总表

| 时间 | 动作 | 结果 |
|---|---|---|
| 11:15 | 通读原始汇总 1972 行 | 掌握探他 + 直播模块全部背景 |
| 11:25 | 盘点工作区/工具 | 工作区空，无 jadx/apktool/java，装 pip/androguard |
| 11:25 | curl 抓落地页源码（24000B） | **拿到 APK 直链** d1ot6fb0ebt00m.cloudfront.net/tanta-3295-sf.apk（云端浏览器说拿不到是它废） |
| 11:26 | 下 APK + 探 iOS 接口 | iOS 接口吐 `qghly.ktbata.cn:8443` |
| 11:26 | 解包 APK | 2 dex、libnetshield.so、server.cer 全在 |
| 11:28 | 证书 CN + so 扫描 | server.cer CN=data.facegl.com（后来证明是美狐 SDK 死路） |
| 11:30 | 测 data.facegl.com/appapi | HTTP 200 但 code 1001 + sign；爆破控制器只有 Auth/Gift 空壳 |
| 11:32-12:10 | 反编译（本地 jadx 卡死 → 沙箱 jadx 成功） | classes2.dex → 3936 Java 文件 |
| 12:10 | 读 wg1.java / j30.java / FuelHttpClient | **核心突破**：系统真身云豹 com.yunbao，所有请求走 127.0.0.1 本地代理 |
| 12:15 | 挖启动密钥 | `Netshield.startService("998","de62d3e947ab10496b1c9090915d2d04")` |
| 12:20-14:00 | 死磕 so 域名（Ghidra/qemu/XOR/OSS） | 全部失败，确认域名运行时拉取 |
| 14:00 | 爸爸核对 sha256 | 三份 APK 哈希全不同，服务器动态换包 |
| 14:02 | 源码存 /opt + Unidbg 尝试 | 源码永久保存；Unidbg native 库死结失败 |
| 14:15 | 补拆 classes.dex | 4486 文件，发现 RSA/HMAC 死代码 |
| 14:22-14:25 | PHASE15.5 反证审计 | 6 文件审计包，STATIC_RESEARCH_STOP |

## 3.2 落地页深挖（突破点 1）

落地页源码 24000 字节，关键 JS：
```javascript
// 服务端渲染时把 https://d1ot6fb0ebt00m.cloudfront.net/tanta-3295-sf.apk 占位符替换成 Redis 同步的下载地址
const ANDROID_DOWNLOAD_URL = 'https://d1ot6fb0ebt00m.cloudfront.net/tanta-3295-sf.apk';
```
- "Redis 同步的下载地址"注释 → 后来解释了 APK 动态换包。
- `/api/ios-download-url` 返回 `https://qghly.ktbata.cn:8443/api/c/jnjvmax6`（企业签分发，302 到百度云，非业务域名）。
- `/api/deeplink/prepare` 和 `/api/proxyCountDown` 都返回 204 空。
- Express 服务器其他路由全 404。

## 3.3 APK 下载与哈希核对

| 版本 | 字节 | sha256 | 来源 |
|---|---:|---|---|
| 爸爸那份 | 57,282,896 | 2d204f7ee9f719426bcc856a1e2b1dba0b7e9231c656547688c6ab04dade52ed | 爸爸早上下载 |
| 沙箱首份 | 57,282,624 | 821213787a6c43ef5189ceb6a3c48fd82e578071ce7113c5da33841d2b6c711d | 本轮首次下载 |
| 直链重下 | 57,284,717 | 1e0e6c9a527faa3c3df269cf4269a839db76f5bd47cdb5b69fafb460f606988c | 11-24 14:03 重下 |
| 残包 | 4,235,063 | 01b56546… | 某次下载中断 |

**结论**：服务器动态换包，三份全不同。但反编译出的架构/接口/密钥与爸爸那轮一致 → 结论可信，与具体包版本无关。

## 3.4 解包与反编译

- unzip 解包（报路径遍历警告，是畸形资源名，不影响）。
- 本地 jadx：iSH 上跑不动（AWT HeadlessException、内存不足）。
- 沙箱 jadx 1.5.0（JDK 25）：
  - classes2.dex（7,100,028B）→ 3936 Java 文件，`/opt/tanta_research/sources`。
  - classes.dex（7,903,784B）→ 4486 Java 文件，`/opt/tanta_research/jout1/sources`。
- 两个 dex 的 com/yunbao 类合计十几个关键类全部读过。

## 3.5 核心突破：系统真身与网络架构

### 3.5.1 系统真身
- **云豹直播系统**，包名前缀 `com.yunbao`，国内流通的成品直播源码，后端 ThinkPHP。
- 内部标识：`j30.y = "com.tanta.livenew"`。
- 之前资料里的 `appapi/xxx` 路径全部对上。

### 3.5.2 网络架构（最关键发现）
读 `FuelHttpClient.java`：
```java
private final String mUrl = "http://127.0.0.1:" + Netshield.getLocalhostPort(j30.G()) + "/appapi/";
```
读 `j30.java`：
```java
public static String o() {
    int localhostPort = Netshield.getLocalhostPort(G());
    return "http://127.0.0.1:" + localhostPort;
}
public static String G() { return "n_11000;11000"; }
```

**结论**：
- App 所有 HTTP 业务请求发到 `127.0.0.1:<本地端口>/appapi/`，由 `libnetshield.so` 本地透明代理转发到真实服务器。
- 域名不在包里——native 层运行时从远程配置拉取。**静态扫描 dex/so 无明文域名是设计如此，不是没找仔细。**

### 3.5.3 四个端口规则（审计时补全，原档案只写了 G/H）
| 规则 | 值 | 用途 | 证据位置 |
|---|---|---|---|
| G() | n_11000;11000 | appapi 基址 / WebView H5 重写 / 支付链接 / 探活 | FuelHttpClient、WebViewActivity、f12、FamilyActivity、LauncherActivity |
| H() | n_12000;12000 | 直播 WS SocketClient | LiveAnchorActivity:818 |
| I() | n_13000;13000 | 心跳 HeartbeatSocket | MainActivity:1406-1408（日志明确 "HeartbeatSocket"） |
| J() | n_14000;14000 | LinkForty 延迟深链 HTTP base | LinkFortyWrapper$initialize$1:148 |

### 3.5.4 启动密钥
`LauncherActivity.java:239`：
```java
int startService = Netshield.startService("998", "de62d3e947ab10496b1c9090915d2d04");
```
- 998 = appid（审计后降级：用途未证实，可能是配置版本号）。
- 32 位串 = 启动凭证字符串（审计后降级：不再断言是 MD5/AES 密钥）。

### 3.5.5 接口清单（wg1.java，24 条常量，审计核实）
```
a=/portal/page/index?id=4          b=/appapi/contribute/index?uid=
c=/appapi/home/index?touid=        d=/appapi/cash/index
e=/appapi/Pay/notify_ali           f=/appapi/Shoppay/notify_ali
g=/appapi/Paidprogrampay/notify_ali h=/appapi/video/index?videoid=
i=/portal/page/index?id=26         j=/portal/page/index?id=39
k=/appapi/Mall/index               l=/appapi/Auth/index
m=/appapi/Detail/index             n=/portal/page/index?id=6
o=/appapi/charge/index             p=/portal/page/index?id=35
q=/appapi/Express/index?           r=/appapi/Goodsorderrefund/index?
s=/appapi/shopcash/index?          t=/appapi/Auth/index?
u=/portal/page/index?id=40         v=/portal/page/index?id=45
w=/appapi/game/xqtb.html           x=/appapi/game/xydzp.html
```

### 3.5.6 公共参数（审计后修正）
`j30.p(str)` 函数：
```java
if empty or !startsWith(o()) return str;
if !contains("?") append "?";
return append("&uid=", C(), "&token=", B(), "&language=", rx1.c().d());
```
- 未登录 uid/token = -9999。
- **审计发现**：只有 `s92.java:68` 明确用 `j30.p()`。大量接口走 `WebViewActivity.E1()`、`xxx.e()`、`rv3.a()` 各自拼参数。`o12.java:105` 手工拼 `uid/language/token/anchor_id`。→ "所有接口同一套公共参数"被推翻。

### 3.5.7 TLS 校验
`FuelHttpClient` 构造函数：
- HostnameVerifier.verify → 永远 return true。
- X509TrustManager 三方法全空实现。
- **Java 层 HttpsURLConnection 默认全信任**（CONFIRMED）。native 层 netshield 的 TLS 行为 UNVERIFIED。

### 3.5.8 数据模型（classes2）
- ConfigBean、UserBean、VersionBean、LevelBean、LiveClassBean、CoinPayBean2 等。
- 分类模型：CLIENT_EXPECTED_MODEL（客户端期望）；SERVER_RESPONSE_UNVERIFIED（服务器真实返回未验证）。

## 3.6 补拆 classes.dex 的发现
- `RsaDecryptUtil.java`：硬编码 RSA-2048 私钥（MIIEvgIBADANBgkq…）。
- `ApiSecurityExample.java`：HMAC-SHA1/HMAC-SHA256 工具。
- **零调用点** → 死代码/示例，非活机制，排除。

## 3.7 so 内加密机制（部分破解）
- 在 0x213404 函数发现 XOR 解密逻辑，密钥 `975f8169d9154d47`（8 字节循环）。
- 全量 XOR 扫描只解出一条：`netshield service has not been started`（错误提示）。
- 真正的配置密文是运行时写入 bss（0x5117b0）再解密——静态拿不到。
- 第二把密钥 0x46148 是 UTF-16LE 的 `975f8169`，同一密钥变体。

---

# 第四部分：技术结论总表（含证据等级）

| # | 结论 | 证据等级 | 证据来源 | 备注 |
|---|---|---|---|---|
| 1 | 系统为云豹直播 com.yunbao | CONFIRMED | j30.java / 包名 / 反编译源码 | — |
| 2 | 内部标识 com.tanta.livenew | CONFIRMED | j30.java:35 | — |
| 3 | 版本 3.9.2.5 | SUPPORTED | 原始资料 + APK 文件名 | 本轮未复核 manifest |
| 4 | FuelHttpClient 走 127.0.0.1/appapi | CONFIRMED | FuelHttpClient.java:22 | getFile/getString 例外 |
| 5 | 本地端口由 Netshield.getLocalhostPort(rule) 取得 | CONFIRMED | j30.java + 10 处调用点 | — |
| 6 | 四个端口规则 G/H/I/J | CONFIRMED | j30.java + 4 类调用点 | 审计补全 I/J |
| 7 | 24 条接口路径常量 | CONFIRMED | wg1.java 全读 | — |
| 8 | j30.p() 追加 uid/token/language | CONFIRMED（函数行为） | j30.java:146-154 | 仅 1 处调用 |
| 9 | 所有接口同一套公共参数 | CONTRADICTED | 4 种封装并存 | 已推翻 |
| 10 | Java 层 TLS 全信任 | CONFIRMED | FuelHttpClient 构造函数 | native 层 UNVERIFIED |
| 11 | data.facegl.com 非 appapi 主目标 | SUPPORTED | 实测 appapi 仅 Auth/Gift 空壳 | 其他用途未排除 |
| 12 | business 域名运行时下发 | INFERRED | so 符号 + 无明文 + 架构 | 配置内容未证实 |
| 13 | 32 位串是密钥 | 降级 → 用途未知 | 无调用链证据 | — |
| 14 | 8 字节 XOR 是全部保护 | 降级 → 一处字符串保护 | 全量扫描只解出 1 条 | — |
| 15 | 静态覆盖全部网络行为 | 降级 → Java 层 + native 边界 | native 运行时未穿透 | — |
| 16 | 业务域名尚未确认 | CONFIRMED（范围内） | 两 dex + so + 证书全查 | — |
| 17 | RSA/HMAC 工具是死代码 | CONFIRMED | 零调用点 | — |
| 18 | APK 动态换包 | CONFIRMED | 三份哈希全不同 | — |

---

# 第五部分：PHASE15.5 反证审计

## 5.1 任务
编号 PHASE15.5_STATIC_EVIDENCE_CHALLENGE，纯静态反证式审计，禁止真机/网络/重扫/密钥猜测/域名探测。执行前保护核对完成（工作区仅档案 1 文件，审计目录新建不覆盖，历史文件未改）。

## 5.2 实际检查的文件（ACTUAL_VERIFICATION）
1. tanta_reverse_archive.md（全读）
2. wg1.java（全读）
3. j30.java（关键方法 + 常量）
4. FuelHttpClient.java（全读）
5. Netshield.java（全读）
6. f12.java（前 120 行）
7. WebViewActivity.java（146-220 行）
8. MainActivity.java（1395-1420 行）
9. LinkFortyWrapper$initialize$1.java（140-158 行）

## 5.3 仅引用既有报告（EXISTING_EVIDENCE_REFERENCE）
APK 三份哈希、classes.dex 补拆与 RSA 死代码、Unidbg 失败、OSS bucket 探测、so 全量扫描、Ghidra/QEMU 失败、data.facegl.com 实测。

## 5.4 十项核心结论审计结果
- A 应用身份：CONFIRMED
- B 业务请求 127.0.0.1：SUPPORTED（"所有"过度泛化，已修正）
- C 端口选择机制：CONFIRMED
- D Netshield 远端配置：INFERRED（降级）
- E HTTP/WS 不同端口：CONFIRMED（参数）/ INFERRED（独立服务）
- F data.facegl.com 排除：SUPPORTED（限定后）
- G 公共参数拼接：CONFIRMED（函数）/ CONTRADICTED（全局泛化）
- H TLS 校验：CONFIRMED（Java 层）/ UNVERIFIED（native 层）
- I 业务域名未确认：CONFIRMED（范围内）

## 5.5 十条最强反例（全部成立并修正表述）
1. 没扫到域名 ≠ 域名不在 APK（加密/其他包版本可能）
2. Netshield 转发 ≠ 域名一定在远程配置（只知结构不知内容）
3. 不同端口 ≠ 不同远端系统
4. data.facegl.com appapi 空壳 ≠ 整个域名无用途
5. 公共参数函数存在 ≠ 所有接口用它（直接反证）
6. 客户端模型 ≠ 服务器返回符合它
7. 证书 CN 无关 ≠ 证书资产与网络无关
8. 32 位串 ≠ 一定是密钥
9. 8 字节 XOR ≠ 全部配置保护
10. 静态分析 ≠ 覆盖全部关键网络行为

## 5.6 三类问题清单
- **STATIC_RESOLVABLE**：应用身份、24 条接口、4 端口规则、j30.p 行为、TLS 全信任、无明文域名。
- **STATIC_REVIEW_REQUIRED**：WebViewActivity loadUrl 后续、xxx.e() 封装细节、Bean→页面映射、是否有第 5 个 ruleName。
- **RUNTIME/EXTERNAL_REQUIRED**：配置服务器地址与返回、真实业务域名、接口真实响应、签名/鉴权、native TLS、远端拓扑。

## 5.7 最终判定
`PHASE15_5_COMPLETE_STATIC_RESEARCH_STOP`
依据：九项核心结论核对完毕；反证完成；B 类剩余项不影响核心；C 类全需运行时；禁止扩大范围。

## 5.8 审计产出文件
01_EXECUTION_SCOPE.md / 02_EVIDENCE_REVIEW.md / 03_CONTRADICTION_AUDIT.md / 04_STATIC_BOUNDARY.md / 05_FINAL_REPORT.md / MANIFEST.sha256 / MANIFEST_META.md，全部在 PHASE15.5_STATIC_EVIDENCE_CHALLENGE/ 目录，MANIFEST 校验 5/5 OK，历史档案哈希复核一致。

---

# 第六部分：所有失败路线记录

| 路线 | 做法 | 失败原因 | 教训 |
|---|---|---|---|
| data.facegl.com | 拿证书 CN 当业务域名打 | 返 200 但 code 1001；爆破只有 Auth/Gift 空壳控制器 | CN 是美狐 SDK 域名，非业务 |
| tanta.top | 云端 + 本地 curl 试 | ERR_CONNECTION_RESET / 超时 | 手机网络另说，本环境不通 |
| ktbata.cn | iOS 分发接口挖 | 302 到百度云，企业签页 | 分发域名非业务域名 |
| OSS bucket 猜测 | 998/netshield/tanta + 20 region + md5 派生 | 全 AccessDenied/NoSuchBucket | 无法区分真假 bucket |
| so 明文扫描 | strings 全扫 | 全是 SDK 内部字符串 | 域名不在明文 |
| so 异或扫描 | 8 字节 XOR 全量 C 扫描 | 只解出 1 条错误提示 | 配置密文运行时写 bss |
| so 逐字节构造 | 扫 strb 立即数 | 1313 处写入无域名 | 不是逐字节构造 |
| Ghidra | 沙箱装 12.2 + Java 25 | 分析 492 秒成功但反编译脚本卡死/输出被吞 | 环境跑通但产物拿不到 |
| QEMU 跑 so | 装 qemu-aarch64 + 交叉库 | 交叉库是 ld 脚本非真 so，缺 libz | 依赖死结 |
| Unidbg | 编译 0.9.10 + JDK25 | unicorn native 库版本不匹配（helper_div_i32/UnicornException） | 无设备动态模拟走不通 |
| Web 搜云豹源码 | GitHub/Gitee | 仓库只有 public 静态资源，Gitee 需登录 | 公开源码拿不到完整后端 |
| jadx 本地 | iSH 跑 jadx | AWT HeadlessException + 内存不足 | 重活必须沙箱 |

---

# 第七部分：文件清单与哈希

## 7.1 本地工作区 /var/minis/workspace/
| 文件 | 字节 | sha256 | 用途 |
|---|---:|---|---|
| tanta_reverse_archive.md | 5,605 | 479f320894e286006197c2dc5d3f002725e0f189ebef9c7593ff7ae62a7567fd | 逆向成果档案（历史，本轮未改） |
| ENGINEERING_MASTER_REPORT.md | 本文件 | 见末尾 | 本总报告 |
| PHASE15.5_STATIC_EVIDENCE_CHALLENGE/01_EXECUTION_SCOPE.md | 2,713 | d42eca17c89ea8b361a1f3af8bd7ecdd9211df948967ac17f7f839982545fe2e | 执行范围 |
| .../02_EVIDENCE_REVIEW.md | 10,316 | 70aa79719465128e5ab97116c6b8fc420c19198d6d6e7aca5cd8e59d13aa588b | 证据复核 |
| .../03_CONTRADICTION_AUDIT.md | 7,895 | 691dcaae0e5b16383e47581f45da2e806f97bc9ba5a5cff0f8fe5a1a79934c60 | 反证审计 |
| .../04_STATIC_BOUNDARY.md | 2,172 | cfc420fd29a5cfc1645f663cb433ef4ed5761e737cae39081617b6db41b965b2 | 停止边界 |
| .../05_FINAL_REPORT.md | 4,012 | e600d9fdbde23eff152a4e79f8b4a9827f134ef5fe3fcdd9abab193186077556 | 最终报告 |
| .../MANIFEST.sha256 | 441 | — | 哈希清单（校验 5/5 OK） |
| .../MANIFEST_META.md | 1,418 | — | 元数据 |

## 7.2 沙箱 /opt/tanta_research/（永久保存，重启不丢）
| 路径 | 说明 |
|---|---|
| tanta.apk | APK（57,282,624B） |
| classes.dex / classes2.dex | 两个 dex 原文件 |
| libnetshield.so | 本地代理 native 库（5,343,672B） |
| sources/ | classes2 反编译 3936 文件 |
| jout1/sources/ | classes.dex 反编译 4486 文件 |

## 7.3 原始资料
- /var/minis/attachments/uploads/探他与直播模块资料汇总.md（160,851B，1972 行），本轮只读未改。

---

# 第八部分：最终状态与下一步条件

## 8.1 最终状态
- **探他静态研究**：PHASE15_5_COMPLETE_STATIC_RESEARCH_STOP（静态到头，物理上拿不到域名）。
- **直播模块 xl-live**：保持冻结，PHASE12A/13/14/15 全部不动，本轮未碰。
- **抽奖任务**：最后记录是 11-24 10:00 场没中，之后状态未知（未再操作）。

## 8.2 静态拿不到的东西（必须运行时）
1. netshield 远程配置服务器地址与返回内容。
2. 真实业务域名与端口。
3. /appapi/* 接口的真实请求/响应结构、签名算法、鉴权方式。
4. native 层 TLS 实际行为。
5. G/H/I/J 四个端口映射到的远端拓扑。

## 8.3 下一步条件
**要接入 Rex，必须运行时证据**，两条路：
- **路线 A（真机/模拟器）**：root 安卓机或模拟器，tcpdump 抓 127.0.0.1 回环，或 Frida hook Netshield 连接函数直接打域名。注意普通 Wi-Fi mitmproxy 抓不到本机代理流量。
- **路线 B（授权外部证据）**：云豹系统公开源码/服务方授权资料/第三方授权报告，仅作旁证，不能替代运行时确认当前实例。

爸爸给设备 → 立刻 Frida 抓域名 → 拿 /appapi/home/index 返回结构 → Rex 复刻接口。

---

## 附：本总报告生成校验
生成时间：2026-11-24 14:35 +0800
所有结论均标注证据等级；ACTUAL_VERIFICATION / EXISTING_EVIDENCE_REFERENCE / INFERENCE / UNRESOLVED 已区分；未把引用写成重新验证；未把推断写成事实。
