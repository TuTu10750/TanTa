# 02_TANTA_STATIC_CONTRACT.md

任务：PHASE16_REX_INTEGRATION_PREPARATION / BATCH 02 Tanta 静态信息整理
创建时间：2026-11-24 14:35 +0800
来源：ENGINEERING_MASTER_REPORT.md + tanta_reverse_archive.md（EXISTING_EVIDENCE_REFERENCE，本轮未重新反编译/扫描）

## 2.1 应用身份
| 项 | 值 | 等级 |
|---|---|---|
| 系统 | 云豹直播 com.yunbao | CONFIRMED |
| 内部标识 | com.tanta.livenew | CONFIRMED |
| 包名 | xewedbjdjc.fxhfwv.jyxhcmtmy | CONFIRMED（原资料+反编译） |
| 版本 | 3.9.2.5 | SUPPORTED |
| 接口风格 | ThinkPHP 风格 /appapi/（客户端经本地代理） | CONFIRMED |

## 2.2 已确认接口路径（wg1.java 24 条，CONFIRMED）
```
b=/appapi/contribute/index?uid=       c=/appapi/home/index?touid=
d=/appapi/cash/index                  e=/appapi/Pay/notify_ali
f=/appapi/Shoppay/notify_ali          g=/appapi/Paidprogrampay/notify_ali
h=/appapi/video/index?videoid=        k=/appapi/Mall/index
l=/appapi/Auth/index                  m=/appapi/Detail/index
o=/appapi/charge/index                q=/appapi/Express/index?
r=/appapi/Goodsorderrefund/index?     s=/appapi/shopcash/index?
t=/appapi/Auth/index?                 w=/appapi/game/xqtb.html
x=/appapi/game/xydzp.html
a/i/j/n/p/u/v = /portal/page/index?id=4/26/39/6/35/40/45
```
每条 = `j30.o() + 路径`；`j30.o() = "http://127.0.0.1:" + Netshield.getLocalhostPort(G())`

## 2.3 HTTP 本地端口结构（CONFIRMED）
- 基址：`http://127.0.0.1:<port>/appapi/`
- 端口来源：`Netshield.getLocalhostPort(ruleName)`，ruleName 四类：
  - G=n_11000;11000 → appapi / H5 / 支付链接 / 探活
  - H=n_12000;12000 → 直播 WS
  - I=n_13000;13000 → 心跳 SocketClient
  - J=n_14000;14000 → LinkForty 深链

## 2.4 WS 本地端口结构（CONFIRMED 结构 / UNVERIFIED 内容）
- LiveAnchorActivity: `new SocketClient("ws://127.0.0.1:"+Netshield.getLocalhostPort(j30.H()), this)`
- 协议栈、消息格式、认证：UNKNOWN（native 代理转发，静态不可见）

## 2.5 公共参数函数（CONFIRMED 函数 / 调用点稀少）
`j30.p(str)`：若 str 以本地基址开头，补 `&uid=<C()>&token=<B()>&language=<rx1.c().d()>`；未登录 uid/token=-9999。
**注意**：仅 s92.java 明确调用；其他接口走 WebViewActivity.E1 / xxx.e() / rv3.a() 各自拼参。不能假设所有接口同参。

## 2.6 请求封装（已确认四种，CONFIRMED）
1. FuelHttpClient.get/post → mUrl + serviceName（走本地基址）
2. WebViewActivity.E1(context,url) → Intent 传 URL 给 WebView 页
3. xxx.e(url) 系列（qh1/y32/rd4/ec2/nr4 等）→ 未知内部封装（UNVERIFIED）
4. rv3.a(...) 手工拼参数
5. i22/h22 把 wg1.w/x 直接交给 IjkMediaPlayer（游戏 HLS）

## 2.7 已知客户端数据模型（CLIENT_EXPECTED_MODEL，仅期望非真实响应）
- ConfigBean / UserBean / VersionBean / LevelBean / LiveClassBean / CoinPayBean2
- j30 缓存：内存字段 + Widget.storage(key userInfo)，TTL 24h，上限 1000 条
- **SERVER_RESPONSE_UNVERIFIED**：所有接口的真实 JSON 结构未知

## 2.8 已知页面/业务模块（CONFIRMED 调用点）
- 房间详情 wg1.m → nb2.java WebViewActivity.E1
- 登录 Auth wg1.l → nb2.java
- 打赏 wg1.b → o12.java（手拼 uid/language/token/anchor_id）
- 分享 wg1.c → le4.java
- 订单/退款 wg1.q/r/s → BuyerAccount/SellerAccount/BuyerRefundDetail
- 游戏 wg1.w/x → i22/h22 IjkMediaPlayer
- 提现 wg1.d → MyProfitActivity

## 2.9 TLS（CONFIRMED Java 层）
FuelHttpClient 设 HostnameVerifier 全 true + X509TrustManager 空实现。native 层 TLS 行为 UNVERIFIED。

## 2.10 未验证信息清单（UNKNOWN / UNVERIFIED）
| 项 | 状态 |
|---|---|
| 真实业务域名 | UNKNOWN（运行时下发） |
| 配置服务器地址 | UNKNOWN |
| /appapi/* 真实返回 JSON | UNVERIFIED |
| 签名算法 / 鉴权要求 | UNVERIFIED |
| 服务端错误码 | UNKNOWN |
| WS 消息格式 | UNKNOWN |
| 真实权限/付费状态 | UNKNOWN |
| 直播内容访问权 | UNKNOWN |
| 32 位启动串用途 | UNKNOWN |
| netshield 远端配置内容 | UNVERIFIED |
| G/H/I/J 远端拓扑 | UNKNOWN |

## 2.11 边界声明
本轮未重新反编译、未扫描 DEX/SO、未跑 Ghidra/QEMU/Unidbg、未猜测域名/凭证/签名。全部为既有成果引用。
