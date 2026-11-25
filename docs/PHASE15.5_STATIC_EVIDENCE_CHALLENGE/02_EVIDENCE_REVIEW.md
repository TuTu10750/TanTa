# 02_EVIDENCE_REVIEW.md

证据等级：CONFIRMED / SUPPORTED / INFERRED / UNVERIFIED / CONTRADICTED / NOT_AVAILABLE

## BATCH 01 · 九项结论证据核对

### A. 应用身份与版本
- 原始结论：云豹直播 com.yunbao，包名 xewedbjdjc.fxhfwv.jyxhcmtmy，版本 3.9.2.5，内部标识 com.tanta.livenew
- 证据位置：j30.java 第 35 行 `public static String y = "com.tanta.livenew";`；档案第一节
- 证据类型：反编译源码直接字段 + 档案记录
- 直接支持：是（内部标识）；版本号来自前期资料，本轮未复核 APK manifest
- 过度推断：无
- 审计结论：应用身份 CONFIRMED（源码直接）；版本 3.9.2.5 为 SUPPORTED（引自档案，本轮未复核 manifest）
- 等级：CONFIRMED（身份）/ SUPPORTED（版本）

### B. App 业务请求进入 127.0.0.1
- 原始结论：所有业务请求发往 http://127.0.0.1:<port>/appapi/
- 证据位置：FuelHttpClient.java 第 22 行 `mUrl = "http://127.0.0.1:" + Netshield.getLocalhostPort(j30.G()) + "/appapi/"`；j30.java o() 第 139-144 行
- 证据类型：反编译源码直接字段
- 直接支持：部分支持。FuelHttpClient 确实用 127.0.0.1，但并非"所有"请求——getFile()/getString() 直接用传入的完整 URL（第 62、67 行），不经过 mUrl
- 过度推断：是。"所有业务请求"过度泛化
- 审计结论：修正为"FuelHttpClient 的 get/post 走 127.0.0.1:<port>/appapi/；getFile/getString 及 WebView 直接使用完整 URL，部分经端口重写"
- 等级：SUPPORTED（修正后）

### C. Netshield 本地端口选择机制
- 原始结论：port = Netshield.getLocalhostPort("n_11000;11000")
- 证据位置：j30.java G() 第 96-98 行返回 "n_11000;11000"；FuelHttpClient 第 22 行调用 getLocalhostPort(j30.G())
- 证据类型：源码直接
- 直接支持：是
- 过度推断：无，但档案漏了 H/I/J 三个端口参数（见 BATCH 03）
- 审计结论：CONFIRMED，但需补充完整端口表
- 等级：CONFIRMED

### D. Netshield 远端配置结论
- 原始结论：libnetshield.so 启动时连远程配置服务器拉真实域名/路由
- 证据位置：档案第一节（基于 so 字符串 getCheckServersFromOSS/getConfigFromCheckServersByHttp、Register 符号、LauncherActivity startService）
- 证据类型：native 符号 + 启动参数 + 推断
- 直接支持：否。so 里有 getCheckServersFromOSS 等符号，但本轮未（也不能）反编译确认其确实执行远程拉取；无实际网络证据
- 过度推断：是。"真实域名/路由"是推断；只能确认 so 具备从 OSS/check-servers 取配置的代码结构
- 审计结论：降级为"so 含配置拉取相关符号；远端配置内容、是否含业务域名均为推断"
- 等级：INFERRED

### E. HTTP 与 WS 使用不同端口参数
- 原始结论：HTTP 用 G()=n_11000，WS 用 H()=n_12000，独立端口
- 证据位置：j30.java G()/H()；FuelHttpClient 用 G()；LiveAnchorActivity 第 818 行 `new SocketClient("ws://127.0.0.1:"+Netshield.getLocalhostPort(j30.H()), this)`
- 证据类型：源码直接
- 直接支持：是（不同参数字符串确实存在且被用于不同客户端）
- 过度推断："属于独立远端服务"是推断
- 审计结论：端口参数不同 CONFIRMED；是否独立服务 INFERRED
- 等级：CONFIRMED（参数）/ INFERRED（服务独立性）

### F. data.facegl.com 排除结论
- 原始结论：空壳，非业务域名
- 证据位置：档案第一节（实测 appapi 只有 Auth/Gift 空壳控制器，Auth 返回 1001）
- 证据类型：前轮实测响应 + 证书 CN
- 直接支持：部分。前轮确实实测该域名 appapi 只有两个控制器；但"整个域名没有业务用途"过强
- 过度推断：是。只能说"不是探他业务 API 主域名"
- 审计结论：降级为"非业务主域名；排除作为 appapi 目标"
- 等级：SUPPORTED（限定后）

### G. 公共参数拼接结论
- 原始结论：j30.p() 给 URL 追加 &uid/&token/&language
- 证据位置：j30.java p() 第 146-154 行
- 直接支持：函数本身 CONFIRMED
- 过度推断：是。档案暗示"所有接口都使用"，但实测调用点少：仅 s92.java 第 68 行 `loadUrl(j30.p(wg1.p))` 明确调用 p()；大量 wg1 字段通过 WebViewActivity.E1()、xxx.e()、rv3.a() 各自拼参数，不经 p()
- 审计结论：p() 存在且行为确认 CONFIRMED；"所有接口使用公共参数"降级为 NOT_SUPPORTED/CONTRADICTED
- 等级：CONFIRMED（函数）/ CONTRADICTED（全局泛化）

### H. TLS 校验结论
- 原始结论：TLS 校验写死全信任，无需证书
- 证据位置：FuelHttpClient.java 第 24-55 行：HostnameVerifier.verify 返回 true；X509TrustManager 三个方法空实现
- 直接支持：是。源码直接
- 过度推断："无需证书"限定：这是 HttpsURLConnection 默认设置，影响使用该默认配置的请求；不代表 native 层 netshield 也全信任
- 审计结论：Java 层 HttpsURLConnection 默认信任全部 CONFIRMED；native 层 TLS 行为 UNVERIFIED
- 等级：CONFIRMED（Java 层）/ UNVERIFIED（native 层）

### I. 业务域名尚未确认
- 原始结论：静态无法确认业务域名
- 证据位置：档案全篇 + 本轮两个 dex 源码复查无明文 URL
- 直接支持：是（现有证据确实没有）
- 过度推断：无。注意这是否定结论，证据充分性受限于已检查范围
- 审计结论：CONFIRMED（在已检查范围内）
- 等级：CONFIRMED（范围限定）

## BATCH 02 · 调用关系复核

### 已核实接口清单
wg1.java 共 24 个静态 final String 字段（a-x），全部 `j30.o() + 路径`：
- a=/portal/page/index?id=4, b=/appapi/contribute/index?uid=, c=/appapi/home/index?touid=
- d=/appapi/cash/index, e=/appapi/Pay/notify_ali, f=/appapi/Shoppay/notify_ali
- g=/appapi/Paidprogrampay/notify_ali, h=/appapi/video/index?videoid=
- i=/portal/page/index?id=26, j=/portal/page/index?id=39, k=/appapi/Mall/index
- l=/appapi/Auth/index, m=/appapi/Detail/index, n=/portal/page/index?id=6
- o=/appapi/charge/index, p=/portal/page/index?id=35, q=/appapi/Express/index?
- r=/appapi/Goodsorderrefund/index?, s=/appapi/shopcash/index?, t=/appapi/Auth/index?
- u=/portal/page/index?id=40, v=/portal/page/index?id=45
- w=/appapi/game/xqtb.html, x=/appapi/game/xydzp.html
档案把 portal 的 7 条合并写成一行，内容无遗漏但表现形式不完整。

### 接口调用点（已核实）
- wg1.e：ac2.java:372, n21.java:105, sa2.java:265, LiveActivity.java:571
- wg1.m（房间详情）：nb2.java:317 WebViewActivity.E1
- wg1.l（Auth/index）：nb2.java:329 WebViewActivity.E1
- wg1.b（打赏）：o12.java:105 用 rv3.a 手拼 uid/language/token/anchor_id
- wg1.c（home/index）：le4.java:63 传给 ro3Var.d()；le4.java:67 拼 this.b
- wg1.q（Express）：a1.java:167 / j0.java:166 手拼 orderid/user_type
- wg1.w/x（游戏）：i22.java:278 / h22.java:306 传给 IjkMediaPlayer
- wg1.s（shopcash）：BuyerAccountActivity.java:138 / SellerAccountActivity.java:146
- wg1.p：s92.java:68 唯一明确用 j30.p() 的调用点

### 未验证参数
- WebViewActivity 内最终 HTTP 请求是否自动经 j30.p()：未核对 WebViewActivity 完整 loadUrl 后续；登记 UNVERIFIED（需静态核对但本轮边界允许，未做深挖）
- 每个接口的完整参数名/签名：UNVERIFIED（无运行时响应）

### 矛盾及修正建议
- 矛盾：档案"公共参数所有接口通用" vs 源码显示多种封装方式并存
- 修正：改为"存在多种请求封装；j30.p() 是其中一种，仅少数调用点明确使用"

## BATCH 03 · HTTP/WS 架构反证

### 端口参数全表（本轮新核实，档案遗漏）
- G() = n_11000;11000 → appapi 基址（FuelHttpClient）、WebViewActivity 重写、f12/Family/ThreeDistribut 支付链接重写、LauncherActivity 探活
- H() = n_12000;12000 → LiveAnchorActivity WS SocketClient
- I() = n_13000;13000 → MainActivity HeartbeatSocket（日志明确 "HeartbeatSocket" + SocketClient）
- J() = n_14000;14000 → LinkFortyWrapper deferred deeplink HTTP base

### 已证实结构
- 至少 4 个逻辑端口通道（G/H/I/J），全部经 Netshield.getLocalhostPort(ruleName) 取得本地端口
- HTTP 通道：G（appapi）、I（心跳 WS，虽走 HTTP URL 但交给 SocketClient）、J（LinkForty HTTP）
- WS 通道：H（直播主播端 SocketClient）

### 推断关系
- 4 个 ruleName 共享同一 netshield 远端配置：INFERRED（都调同一 native 函数，但配置内容未知）

### 未知关系
- 这些端口是否映射到不同远端服务、相同服务不同路径、或同一服务不同协议：UNKNOWN

### 修正后架构图（文字）
App 业务逻辑 → 多种封装（FuelHttpClient get/post、WebViewActivity.E1、xxx.e()、rv3.a() 拼接、SocketClient）
→ 统一经 Netshield.getLocalhostPort(ruleName) 得到本地端口（G/H/I/J 四类规则）
→ 访问 127.0.0.1:<port>
→ netshield native 转发（目标未知，配置运行时加载）
→ 远端业务服务器（未知）

## BATCH 04 · 数据模型与页面关联

### 已有模型证据
- com/yunbao/common/bean/*（前轮已见）：CoinPayBean2、ConfigBean、UserBean、VersionBean、LiveClassBean、LevelBean（源码存在）
- j30.java：UserBean/ConfigBean 缓存于字段 j/d，SharedPreferences key userInfo
- f12.java：CoinPayBean2.ChargeConfigBean 用于支付页渲染

### 页面关联证据
- wg1.e（Pay/notify_ali）→ ac2/n21/sa2/LiveActivity 支付相关页面
- wg1.m（Detail/index）→ nb2.java 房间详情 WebView
- wg1.b（contribute）→ o12.java 打赏
- wg1.c（home/index）→ le4.java 分享/复制
- wg1.q/r/s → 订单/退款/店铺 WebView

### 区分等级
- CLIENT_EXPECTED_MODEL：Bean 类字段结构（CoinPayBean2 等）— CONFIRMED 存在
- CLIENT_UI_MODEL：f12/ac2/nb2 等页面绑定关系 — SUPPORTED（源码调用点直接）
- CLIENT_CACHE_MODEL：j30 内 SharedPreferences/字段缓存 — CONFIRMED
- SERVER_RESPONSE_UNVERIFIED：所有接口的真实返回结构 — UNVERIFIED
- UNKNOWN：Bean 字段与实际 JSON 的对应关系 — UNKNOWN

### 结论
现有资料有进一步静态利用价值（可继续从调用点重建页面-接口映射），但不属于本轮必须；服务器响应结构必须运行时确认。
