# 04_STATIC_BOUNDARY.md

## 三类问题清单

### A. STATIC_RESOLVABLE（现有静态资料已能回答）
| 问题 | 答案 | 证据 |
|---|---|---|
| 应用是什么系统 | 云豹直播 com.yunbao | j30.java / 包名 |
| 接口路径有哪些 | wg1.java 24 条常量 | wg1.java（本轮实际读取） |
| HTTP 基址怎么来 | 127.0.0.1 + getLocalhostPort(G()) | FuelHttpClient.java（本轮实际读取） |
| 本地端口规则有几个 | G/H/I/J 四个 | j30.java + 4 处调用（本轮实际读取） |
| j30.p() 干什么 | 追加 uid/token/language | j30.java 146-154（本轮实际读取） |
| 是否所有接口都走 j30.p() | 否，多封装并存 | 调用点扫描（本轮实际读取） |
| TLS 校验 | Java 层 HttpsURLConnection 默认全信任 | FuelHttpClient.java（本轮实际读取） |
| 静态有无明文域名 | 无 | 两 dex 源码 + 档案（引用+本轮抽查） |

### B. STATIC_REVIEW_REQUIRED（现有资料有相关证据但未核对）
| 问题 | 相关证据位置 | 本轮处理 |
|---|---|---|
| WebViewActivity loadUrl 后续是否统一补参 | WebViewActivity.java m1() 已读 146-220，后续未读完 | 登记，未扩大 |
| xxx.e(String) 请求封装细节 | qh1/y32/rd4/ec2/nr4 等已定位 | 登记，未逐个读 |
| Bean→页面映射完整表 | com/yunbao/common/bean/* 存在 | 登记，未全量 |
| 是否存在第 5 个 ruleName | j30 A-E 常量非端口规则 | 登记，未扩大 |

### C. RUNTIME_OR_AUTHORIZED_EXTERNAL_EVIDENCE_REQUIRED
| 问题 | 为何静态不可答 |
|---|---|
| netshield 配置服务器地址/返回 | native 运行时拉取，so 反编译未穿透 |
| 真实业务域名 | 配置下发，包内无明文 |
| 接口真实响应结构 | 需服务器响应 |
| 签名算法/鉴权 | 需请求样本 + 服务端行为 |
| G/H/I/J 远端拓扑 | 需运行时连接观测 |
| native TLS 行为 | 需运行观测 |

## 停止判定
STATIC_RESEARCH_STOP

理由：核心问题（九个）全部已答；反证审计完成；剩余 B 类不触及核心且属可选；C 类全部需运行时或授权外部证据。按任务规则，禁止因 C 类重启全量扫描或扩大研究范围。
