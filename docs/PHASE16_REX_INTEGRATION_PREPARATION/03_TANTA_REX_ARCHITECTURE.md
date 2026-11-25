# 03_TANTA_REX_ARCHITECTURE.md

任务：PHASE16_REX_INTEGRATION_PREPARATION / BATCH 03 接入架构设计
创建时间：2026-11-24 14:36 +0800
性质：设计蓝图（DESIGN / INFERENCE），非可导入实体模块（Rex 源码不可访问，见 BATCH 01）

## 3.0 设计原则（来自任务）
1. 复用 Rex 现有架构（FINAL_REPORT 的 xl-live 模式为唯一可引用样板）
2. 不重新创造已有机制
3. 不影响其他模块
4. 不修改冻结直播模块
5. 不把未知第三方行为写成确定逻辑
6. 不把 MOCK 当真实响应
7. 不构建绕过认证/付费墙/访问控制的机制
8. 不提取/保存第三方秘密配置、凭证、密钥

## 3.1 模块入口（DESIGN）
- 模块 ID：`user.tanta<version>`（如 user.tanta010），内层 ID `tanta<version>-*`，Scheme `tanta<version>://room`
- 导出入口（参照 xl-live 模式）：
  - `loadDetail(p)` → 返回房间详情描述（列表/卡片用）
  - `loadResource(p)` → 返回线路数组 `[{name,url,desc}]`
  - `loadHome(page)` / `loadVideos(uid)` → 首页/视频（可选）
- 生命周期：模块级内存缓存 + Widget.storage 持久化（TTL 24h，上限 1000），关闭时 cancel 挂起请求

## 3.2 接口适配层（DESIGN，边界明确）
- adapter 函数 `apiGet(path, params)`：底层用 Rex 的 Widget.http（不可用 fetch/XHR）
- **唯一已知真实基址是本地代理** `http://127.0.0.1:<port>/appapi/`，port = Netshield.getLocalhostPort(G())
- 设计边界：adapter 配置里 `BASE_MODE` 有两个值：
  - `LOCAL_PROXY`（需运行时提供 port，当前 UNKNOWN）
  - `CONFIGURED_HOST`（需合法授权的域名 + 端口，当前 UNKNOWN）
- **禁止**猜测域名、禁止内置任何第三方地址；无输入时 adapter 返回明确错误"NO_ENDPOINT_CONFIGURED"

## 3.3 数据模型层（DESIGN，全部 CLIENT_EXPECTED_MODEL）
```
RoomList   { code, msg, info:[{id,user_nicename/username,title,avatar,isLive,viewers,status}] }
RoomDetail { code, info:{ id, title, stream_name, anchor, status } }
Line       { name, url, desc }   // loadResource 输出
VideoItem  { id, title, cover, duration, accessMode, cost }
```
- 所有字段为期望模型，字段名以 `_UNVERIFIED` 标注；真实 JSON 结构未知
- 解析器必须容错：缺字段给默认值、类型异常给 null、不抛错中断整个列表

## 3.4 状态管理层（DESIGN）
- 状态枚举：UNINITIALIZED / READY / LOADING / PLAYING / ERROR / NO_ENDPOINT / GATE_BLOCKED
- 转换：模块初始化→UNINITIALIZED；配置 endpoint 后→READY；请求中→LOADING；成功解析出 url→PLAYING；空数据/字段异常→ERROR；endpoint 未配置→NO_ENDPOINT
- 错误分支写进线路 desc（绕过 Rex 隐藏空 url 行，复用 xl-live 5.4 教训）

## 3.5 页面展示层（DESIGN）
- 列表页：三列卡片，标题 + 状态文案（复用 Rex 现有 UI 机制）
- 详情页：loadDetail 返回描述文本；loadResource 返回线路数组
- 空 url 行不输出（避免 Rex 隐藏导致用户无提示），用 desc 文案承载状态

## 3.6 错误处理层（DESIGN）
| 场景 | 处理 |
|---|---|
| NO_ENDPOINT | 线路 desc 显示"未配置接入地址"，不发起请求 |
| 请求异常 | 捕获 String(e.message)，desc 显示错误，返回空线路数组 |
| 空数据 | desc 显示"暂无数据" |
| 缺失字段 | 解析器填默认值，记录 UNKNOWN 字段计数 |
| 类型异常 | 跳过异常条目，不中断列表 |
| 模块关闭 | cancel 所有挂起请求，清内存缓存（持久化保留） |

## 3.7 测试数据层（DESIGN，见 BATCH 04）
- 独立 MOCK 数据集，文件名带 MOCK_ 前缀，与真实证据物理分离
- 只用于验证解析/状态/映射逻辑，不冒充真实响应

## 3.8 接口适配边界（关键）
- adapter 只做 URL 拼接 + Widget.http 调用 + JSON 解析
- **不内置**：域名、端口数值、token、签名、密钥、配置拉取逻辑
- 这些必须由运行时合法输入注入（真机抓包得到的 endpoint 或授权测试数据）
- 无输入 = 模块停在 NO_ENDPOINT，不猜测不连接

## 3.9 与冻结模块的关系
- 本设计不引用、不复制、不修改 xl-live 任何代码（直播中继/VOD/收藏/WS 抓流）
- 探他是独立平台，线路来源与 xl-live 完全不同，无共享逻辑

## 3.10 明确不设计的东西（超范围）
- 不设计绕过 netshield 本地代理的方法
- 不设计获取第三方配置/域名/凭证的逻辑
- 不设计付费墙/权限绕过
- 不设计真实直播流解密（native 层行为未知）

## 证据类型
DESIGN/INFERENCE：全部为设计蓝图；无 ACTUAL_VERIFICATION（Rex 源码不可访问）；未产出可导入实体模块。
