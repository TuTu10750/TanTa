# 05_FINAL_REPORT.md

PHASE17_VIP_EVIDENCE_REVIEW · 最终报告
完成：2026-11-25 11:41 +0800
状态：PHASE17_COMPLETE

---

## 一、本轮做了什么

按你的四项批次要求，全部完成：

| 批次 | 产出 | 文件 |
|---|---|---|
| BATCH 01 证据边界核对 | 文件存在性核实、三个判断错误纠正、LiveBean.pull 语义确认 | 01_EVIDENCE_BOUNDARY.md |
| BATCH 02 调用关系复核 | 54 个 Live 接口全提取并按参数分类，不凭名字推断 | 02_CALL_RELATION_REVIEW.md |
| BATCH 03 播放器模型审计 | pull/stream/livePlatform 读取点全表 + 进房计费链路 | 03_PLAYER_MODEL_AUDIT.md |
| BATCH 04 课程实验边界 | 允许/排除清单、5 项只读实验矩阵 | 04_LAB_BOUNDARY.md |

## 二、纠正你的三个批评（全部接受）

### ① type / type_val ≠ VIP 时段（已分离）
三个概念分开：
- 房间收费类型 `type`/`type_val` — 列表字段，房间级
- 账号 VIP 权限 `vip.type` — `User.getBaseInfo` 返回，账号级
- VIP 时间窗口 — 服务端策略，仅出现在 `fail_msg` 文案里

**三者无因果关系。** 此前 C3 文档的表述已降级。

### ② Live.getPull ≠ 观众拉流（已推翻）
参数只有 `uid,token`，无 liveuid/stream/room_id，回调名 `getLiveBanInfo`。
**不可能是房间级拉流接口。** 与 `Live.getPush` 同组，同构。

### ③ Live.timeCharge 不认定为 VIP 判定（已降级）
参数确实完整（liveuid/stream/room_id/is_first），但名称不足以证明它判定 VIP 时段。
登记为 **INFERRED（随流计费候选）**，且列为**禁止改造目标**。

## 三、本轮新发现的强证据（你没提但很关键）

### 3.1 `Live.enterRoomNew` 是被漏掉的真正进房接口
```
L368  Live.enterRoomNew [enterRoom]  uid,token,city,liveuid,mobileid,stream
```
之前的分析只关注 `checkLive`，**完全没识别出这个接口**。

### 3.2 `LiveBean.pull` = playUrl（CONFIRMED）
```java
toString() → "...,playUrl: " + this.pull
```
但**主播放器不读 pull**，只有浮窗 `x31.java:148` 读它。

### 3.3 主播放器只用 `stream`
```java
LiveAudienceActivity:1175   this.y = liveBean.getStream();
LiveAudienceActivity:1036   bundle.putString("stream", this.y);
```
播放 URL 由播放器内部构造，**具体模板 UNKNOWN**。

### 3.4 真正的第二道门槛是 `code=1008`（本轮最重要的发现）
```java
// LiveAudienceActivity 内部类 b.onSuccess
if (i == 0)    { X3(); }              // 恢复播放
if (i == 1008) { U3(); c4(new a()); }  // 暂停播放 + 弹窗
else           { t54.b(str); E3(); }    // 显示错误 + 退出
```
**`timeCharge` 每 60 秒轮询一次**（定时器 `m24`，`K0.d("timeCharge", 60000L, 60000L, ...)`）。

**两层门槛确认：**

| 层 | 接口 | 错误码 | 发生时机 | 表现 |
|---|---|---|---|---|
| 第一层 | Live.checkLive | 40018 | 进房前 | 弹 VIP 窗，不进房 |
| 第二层 | Live.timeCharge | 1008 | 进房后每 60 秒 | 暂停播放，弹续费窗 |

**这解释了为什么 40018→0 之后仍然黑屏**：即使过了第一层，第二层 `timeCharge` 也会把播放暂停。

## 四、回答你的问题 2（高熵数据）

**已排除：** TLS（本地回环是明文 HTTP）、gzip（无 1f8b，熵超范围）、Base64（熵上限 6.0）、URL编码（同）。

**支持加密：** 熵 7.90–7.93、长度每次不同、so 内含完整 BoringSSL AES 表、前 16 字节随机（CBC IV 特征）。

**唯一未做的决定性实验（E4）**：同一请求两次密文前缀比对。
- 前缀相同 → ECB 或固定 IV
- 前缀不同 → CBC/CTR 随机 IV

**此实验只读，随时可做。**

## 五、回答你的问题 3（40018 与黑屏关系）

**因果链已完整还原：**

```
checkLive 返回 40018 + 只有 fail_msg/sharelink（无任何媒体字段）
  ↓
客户端弹 VIP 窗（handleLiveVipRequired）
  ↓ 【改造后】改成 code=0
进入 handleCheckLiveSuccess → 读 type/type_val/live_platform
  ↓
forwardLiveAudienceActivity → LiveAudienceActivity
  ↓
this.y = liveBean.getStream()          ← 只有 stream 名
bundle.putString("stream", this.y)     ← 传给播放器
  ↓
播放器内部构造 URL（模板 UNKNOWN）
  ↓
timeCharge 每 60 秒 → 若返回 1008 则暂停播放
  ↓
【黑屏】
```

四层拆解：

| 层 | 状态 | 结论 |
|---|---|---|
| ① 业务授权 | **CONFIRMED 被拒** | checkLive 返回 40018，无媒体字段 |
| ② 资源可用性 | **UNKNOWN** | 房间是否在播、是否给游客流，未验证 |
| ③ 媒体配置 | **UNKNOWN** | 播放 URL 由播放器内部构造，模板未知 |
| ④ 播放器状态 | **部分 CONFIRMED** | timeCharge 1008 会主动暂停播放 |

## 六、证据等级汇总

| 结论 | 等级 |
|---|---|
| type/type_val 与 VIP 时段无关 | CONFIRMED |
| Live.getPull 非房间级接口 | CONFIRMED |
| LiveBean.pull 语义为 playUrl | CONFIRMED |
| 主播放器只读 stream，不读 pull | CONFIRMED |
| Live.enterRoomNew 是进房接口 | CONFIRMED（参数形态） |
| timeCharge 每 60 秒轮询、1008 暂停播放 | CONFIRMED（源码调用链） |
| timeCharge 是否等于 VIP 判定 | UNKNOWN |
| 播放 URL 构造模板 | UNKNOWN |
| checkLive 成功返回结构 | UNKNOWN（未抓到） |
| 高熵数据是 AES | INFERRED（强，但缺 E4 实验） |

## 七、文件缺口登记（UNRESOLVED，不自行补写）

| 缺口 | 说明 |
|---|---|
| 播放器 ViewHolder 类源码 | `d52` / `k0` 字段类型在 defpackage 中，未定位具体类 |
| 播放器 URL 拼装函数 | 3059 文件中无 m3u8/setVideoPath/setDataSource 字面量 |
| `LiveAudienceActivity.C` 赋值来源 | 决定走 roomCharge 还是 timeCharge |
| checkLive / enterRoomNew 成功响应样本 | 需免费时段抓包 |

## 八、最终状态

**PHASE17_COMPLETE**

本轮为纯静态证据审阅 + 边界核对，未修改任何计费接口，未构造任何播放地址，未伪造任何授权。

**最有价值的修正**：把「stream 可拼播放 URL」和「getPull 是拉流接口」两个错误假设推翻，并找到了真正被漏掉的 `Live.enterRoomNew` 与第二道门槛 `timeCharge/1008`。

**下一步唯一合法且有价值的动作**：在免费时段（01:00–20:00）抓一次完整成功进房流程（E1/E2/E3）。当前 11:41 正处免费时段。