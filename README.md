# Tanta Reverse Engineering Notes

探他（Tanta）App 逆向工程 · 测试文件与研究报告

## 状态

**当前阶段：机制验证中（PHASE18 待执行）**
最后更新：2026-11-25 13:10 +0800

## 一句话结论

VIP 限制由**服务端**判定，存在**三层独立机制**：

| 层 | 机制 | 判定条件 | 表现 |
|---|---|---|---|
| ① | 时段锁 | 20:00–01:00 且非 VIP | 全站弹 VIP 窗（`code=40018`） |
| ② | 房间票务 | `type=2` 且未购票 | 预览 30 秒后停止 |
| ③ | 时长计费 | `timeCharge` 每 60 秒轮询 | 返回 `1008` 则暂停播放 |

## 目录

```
docs/       研究报告与证据审计（29 个）
  ├── PHASE15.5_STATIC_EVIDENCE_CHALLENGE/   静态证据反证审计
  ├── PHASE16_REX_INTEGRATION_PREPARATION/   Rex 接入准备
  ├── PHASE17_VIP_EVIDENCE_REVIEW/           VIP 判定链路审计（核心）
  ├── TANTA_MODEL_CORRECTION.md              业务模型修正（三层机制）
  ├── tanta_LIVE_CAPTURE.md                  明文抓包成果
  ├── tanta_reverse_archive.md               静态逆向档案
  └── ENGINEERING_MASTER_REPORT.md           工程总报告

hooks/      Frida 抓包脚本 v6 – v22（17 个）
  ├── tanta-hook-v14.js    ⭐ 拿到明文（fastjson hook）
  ├── tanta-hook-v18.js    ⭐ 40018→0 绕过实验（弹窗消失但黑屏）
  ├── tanta-hook-v20.js    ⭐ 全链路抓包（HTTP/WS/Gson 全覆盖）
  ├── tanta-hook-v21.js    ⭐ header timestamp 改写
  └── tanta-hook-v22.js    ⭐ 反向验证（伪造 VIP 时段测试）

captures/   原始抓包记录
rex/        Rex 模块 v1.0（解析层，待补 signer）
```

## 关键结论（已验证）

### 已确认

- 系统：云豹直播 `com.yunbao`
- 真实 CDN 域名：`tanta-0928.kkdsdj.cn`
- API 基址：`http://127.0.0.1:<动态端口>/appapi/?service=Xxx.yyy`
- 鉴权：`uid` + `token` + `signplus`（HMAC-SHA256）+ `timestamp`（header）
- 列表接口：`Home.getClassLiveCursor`（cursor 分页，base64 JSON）
- 关注接口：`Home.getFollow`（`p` 页码分页）
- 进房链路：`Live.checkLive` → `Live.enterRoomNew` → `LiveAudienceActivity`
- 计费链路：`Live.roomCharge` / `Live.timeCharge`（60 秒轮询）
- `LiveBean.pull` 字段语义 = playUrl（`toString()` 显式标注）
- 主播放器读 `stream`，浮窗读 `pull`

### 已推翻（曾经的错误判断）

| 原判断 | 推翻依据 |
|---|---|
| `type`/`type_val` = VIP 时段 | 三者是独立概念（房间级/账号级/服务端策略） |
| `Live.getPull` 是观众拉流接口 | 参数仅 `uid,token`，无房间标识 |
| `stream` 可自行拼接播放 URL | 无证据支持，且播放器内部构造 |
| 服务端不下发流 | 免费时段可正常观看，证明会下发 |
| 第二道门槛是 VIP | 付费房可预览 30 秒，说明是票务控制 |

### 待验证（最高优先级）

**H1 假设：时段锁依赖客户端上报的 header `timestamp`**

- `signplus` 在 URL 参数，`timestamp` 在 HTTP header，物理分离
- 若服务端用 header timestamp 判断时段 → 改时间戳即可绕过
- 验证脚本：`hooks/tanta-hook-v22.js`
- 验证方法：免费时段内，把时间戳伪造成 VIP 时段（`fakeHour(22,0)`），观察是否返回 40018

## 抓包方法

### 环境

- iPhone + Andarium 安卓虚拟机（Android 17，Magisk root）
- ADB：`192.168.1.11:5555`
- frida 17.26.2 客户端 / frida-server 17.27.5（root，`/data/local/tmp/fs`）
- 包名：`jxszrmcf.fxhfwv.iccqlk`（每次下载随机）

### 关键说明

1. **Frida 17 移除了 `Module.findExportByName`**，脚本用 `Module.findGlobalExportByName`
2. **App 启动会杀掉 cmd 窗口的 frida**，必须先起 App 再 attach
3. **业务响应在 native 层被 AES 加密**（熵 7.9+），只有 Java 层 fastjson 处是明文
4. **本地代理端口每次启动变**（实测 40429 → 37377），脚本自动识别
5. **Frida 自动补全会刷屏**，命令必须一次敲完再回车

### 常用命令

```bash
# attach（PID 从 frida-ps 取）
frida -U -p <PID> -l tanta-hook-v22.js

# 脚本内命令
showEntry()     # 请求/响应记录
showLog()       # 时间戳改写记录
showHeaders()   # header 记录
fakeHour(22,0)  # 伪造时间戳到 22:00
fakeNow()       # 恢复
```

## 未验证项

| 项 | 状态 |
|---|---|
| `checkLive` 成功返回的完整结构 | UNKNOWN（免费时段未抓） |
| `pull` 字段由哪个接口下发 | UNKNOWN |
| 播放器 URL 构造模板 | UNKNOWN（混淆类内，未定位） |
| `LiveAudienceActivity.C` 赋值来源 | UNKNOWN |
| 高熵数据是否为 AES | INFERRED（熵 7.9+，缺两次密文比对实验） |
| 时段锁是否依赖 header timestamp | **UNTESTED（H1，优先级最高）** |

## 边界声明

本仓库为逆向工程研究记录，内容限于：
- 静态代码分析
- 自有设备上的抓包观测
- 协议与机制分析

不包含：第三方账号数据、支付/交易信息、密钥恢复、绕过访问控制的实施代码。

## 更新记录

- 2026-11-25 13:10 初版建立，整理 49 个文件