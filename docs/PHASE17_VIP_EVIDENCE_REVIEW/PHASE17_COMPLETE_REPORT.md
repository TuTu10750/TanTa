# 探他 VIP 判定链路证据审计 · 完整报告

**报告编号**：PHASE17_VIP_EVIDENCE_REVIEW
**完成时间**：2026-11-25 11:45 +0800
**状态**：PHASE17_COMPLETE
**性质**：纯静态证据审阅 + 边界核对。未修改任何计费接口，未构造任何播放地址，未伪造任何授权。

---

## 目录

- 摘要
- 第一部分 · 证据边界核对（BATCH 01）
- 第二部分 · 调用关系复核（BATCH 02）
- 第三部分 · 播放器数据模型审计（BATCH 03）
- 第四部分 · 实验边界（BATCH 04）
- 第五部分 · 最终结论与缺口清单

---

# 摘要

## 一句话结论

**探他的 VIP 限制由服务端判定，客户端只负责展示；而且存在两道独立门槛——进房前 `checkLive/40018`，进房后 `timeCharge/1008`（每 60 秒轮询）。**

## 本轮五项关键产出

| 编号 | 结论 | 等级 |
|---|---|---|
| 1 | `type`/`type_val` 与 VIP 时段**无因果关系**，必须分离 | CONFIRMED |
| 2 | `Live.getPull` **不是**观众端拉流接口（参数仅 uid/token） | CONFIRMED |
| 3 | `LiveBean.pull` 语义 = playUrl，但**主播放器不读它** | CONFIRMED |
| 4 | `Live.enterRoomNew` 是此前被漏掉的**真正进房接口** | CONFIRMED |
| 5 | 第二道门槛是 `timeCharge` 返回 `1008` → 暂停播放 | CONFIRMED |

## 本轮纠正的三个错误判断

1. 把 `type=2` 当作"付费房"并与 VIP 时段混为一谈 → 已拆分为三个独立概念
2. 把 `Live.getPull` 当作观众拉流入口 → 已推翻
3. 把 `stream` 当作可自行拼接播放 URL 的依据 → 已撤销该假设，不作为工程前提

---

# 第一部分 · 证据边界核对（BATCH 01）

## 1.1 本轮起因与文件核实

上一轮 README 声称压缩包内含 `LiveAudienceActivity.java` 与 `CheckLivePresenter.java`，但实际 ZIP 中不存在。

**核实结论**：原因是**打包 zip 时 `04_skills/com/` 尚未解压入目录**（补包动作发生在 zip 生成之后）。

**验证命令与结果**：
```bash
unzip -l TANTA_PACK_20261125.zip | grep -c "04_skills/com/"
# 结果：0  → 确认旧包缺少 com/ 目录
```

**已修复**：重新打包为 `TANTA_PACK_v3_20261125.zip`（5.8 MB / 3108 文件），三个关键文件已在包内并有清单可验证。

## 1.2 关键文件存在性核对（ACTUAL_VERIFICATION）

| 文件 | 路径 | 字节 | 行数 | 状态 |
|---|---|---:|---:|---|
| LiveBean.java | 04_skills/com/yunbao/live/bean/LiveBean.java | 8,685 | 314 | ✅ 存在 |
| CheckLivePresenter.java | 04_skills/com/yunbao/main/presenter/CheckLivePresenter.java | 6,431 | 177 | ✅ 存在 |
| LiveAudienceActivity.java | 04_skills/com/yunbao/live/activity/LiveAudienceActivity.java | 59,114 | 1,826 | ✅ 存在 |
| e32.java | 04_skills/defpackage/e32.java | — | — | ✅ 存在 |
| x31.java | 04_skills/defpackage/x31.java | — | — | ✅ 存在 |
| libnetshield.so | 04_skills/native/libnetshield.so | 5,343,672 | — | ✅ 存在 |

`libnetshield.so` 校验值：`sha256 a2d36c3d3c08000cb2cb9bf058e4db6dc8d7926252df15cd64445fb969b7beff`

## 1.3 纠错一：type / type_val 不等于 VIP 时段

### 三个必须分离的概念

| 概念 | 归属层级 | 证据来源 | 实际含义 |
|---|---|---|---|
| 房间收费类型 `type` / `type_val` | **房间级属性** | 列表接口每条记录返回 | 房间自身的标价设置 |
| 账号 VIP 权限 `vip.type` | **账号级属性** | `User.getBaseInfo` 返回 | 该账号是否 VIP |
| VIP 时间窗口 | **服务端时间策略** | `checkLive` 失败时 `fail_msg` 内文字 | 20:00–01:00 时段限制 |

### 实测证据对比

列表接口返回的房间记录（无 VIP 相关字段）：
```json
{
  "room_id": "live_1817466",
  "uid": 1817466,
  "user_nickname": "阿陈",
  "title": "刷礼物提要求加v接私",
  "stream": "1817466_1795529924",
  "nums": "5109",
  "type": 2,
  "type_val": "99",
  "live_platform": 4,
  "level_anchor": "1",
  "goodNum": "",
  "pkuid": 0
}
```

账号信息接口返回（VIP 状态在这里）：
```json
{
  "id": 2001231,
  "user_nickname": "游客_2001231",
  "coin": 0,
  "level": "1",
  "vip": { "type": "0", "endtime": "" },
  "video_free_num": 5,
  "used_free_num": 4
}
```

VIP 时段文字（服务端在 `fail_msg` 里下发的 HTML）：
```
VIP时间段: 20:00 ~ 01:00
```

### 纠错结论

- `type=2` 的含义：**房间标价**（字段存在 CONFIRMED，语义 INFERRED）
- `type` / `type_val` 与 VIP 时段**无因果关系**（CONFIRMED 分离）
- 此前文档把两者混写，本轮**降级修正**

## 1.4 纠错二：Live.getPull 不是观众端拉流接口

### 源码原文（e32.java:210-213）

```java
public static void a0(HttpCallback httpCallback) {
    HttpClient.getInstance().get("Live.getPull", "getLiveBanInfo")
        .params("uid", j30.q().C())
        .params("token", j30.q().B())
        .execute(httpCallback);
}
```

### 参数核查

| 检查项 | 结果 |
|---|---|
| 是否携带 `liveuid` | ❌ 无 |
| 是否携带 `stream` | ❌ 无 |
| 是否携带 `room_id` | ❌ 无 |
| 回调标识 | `getLiveBanInfo`（封禁信息语义，与拉流不符） |

### 结论

**不可能是"指定房间的观众拉流接口"。** 此前判断**推翻（CONTRADICTED）**。

同组的 `Live.getPush`（L219）参数同样只有 `uid,token`，回调同为 `getLiveBanInfo`，同样**不属于房间级接口**。

## 1.5 纠错三：Live.timeCharge 不能认定为 VIP 时段判定接口

### 源码原文（e32.java:146-148）

```java
public static void M0(String str, String str2, int i, HttpCallback httpCallback) {
    HttpClient.getInstance().get("Live.timeCharge", "timeCharge")
        .params("uid", j30.q().C())
        .params("token", j30.q().B())
        .params("stream", str2)
        .params("is_first", Integer.valueOf(i))
        .params("liveuid", str)
        .params("room_id", "live_" + str)
        .execute(httpCallback);
}
```

### 属性判定

| 属性 | 判断 |
|---|---|
| 参数完整性 | ✅ 含 liveuid / stream / room_id / is_first，是房间级接口 |
| 是否"时间计费" | 名称与 `is_first` 参数吻合（**INFERRED**） |
| 是否等于 VIP 时段判定 | **UNKNOWN** —— 名称不足以证明 |
| 是否可作为改造目标 | **禁止** —— 涉及计费，不修改参数/返回值 |

**登记为：随流上报的计费接口候选（INFERRED），不作为任何绕过目标。**

## 1.6 新增强证据：LiveBean.pull 就是播放地址

### LiveBean.java 显式标注（L314）

```java
@Override
public String toString() {
    return "uid: " + this.uid + " , userNiceName: " + this.userNiceName
         + " ,playUrl: " + this.pull;
}
```

**字段 `pull` 被显式标注为 `playUrl`。**

### 类型判断佐证（x31.java:148-150）

```java
String pull = this.b.getPull();
if ((TextUtils.isEmpty(pull)
     || !(pull.startsWith("http://") || pull.startsWith("https://")
          || pull.contains(".mp4") || pull.contains(".MP4")))
    && this.e == null) {
    this.e = new Handler();
    return;
}
```

**判断逻辑表明 `pull` 是完整 URL（http/https/.mp4），不是 stream 名。**

## 1.7 本轮证据等级总表

| 结论 | 等级 |
|---|---|
| LiveBean.pull = 播放地址（完整 URL） | **CONFIRMED** |
| 观众端代码中不存在 `setPull` 调用 | **CONFIRMED** |
| 观众端 pull 只能来自 JSON 反序列化 | **INFERRED** |
| 列表接口 JSON 不含 pull 字段 | **CONFIRMED** |
| checkLive 成功返回的结构 | **UNKNOWN** |
| type=2 与 VIP 时段无因果 | **CONFIRMED** |
| Live.getPull 非观众拉流 | **CONFIRMED** |
| Live.timeCharge 是否 VIP 判定 | **UNKNOWN** |

## 1.8 三条硬性禁令

1. **禁止**把 `type=2` 当作 VIP 时段证据
2. **禁止**把 `Live.getPull` 当作观众拉流接口
3. **禁止**修改 `Live.timeCharge` / `Live.roomCharge` 的参数或返回值

---

# 第二部分 · 调用关系复核（BATCH 02）

## 2.1 方法说明

- 来源：`04_skills/defpackage/e32.java`（逐行解析，ACTUAL_VERIFICATION）
- 方法：只记录**参数集合**，按参数形态判定归属
- 原则：**不以接口名推断功能**
- 分类依据：是否含房间标识（`liveuid` / `room_id` / `stream`）

### 分类规则

| 类别 | 判定条件 |
|---|---|
| **R** 房间级 | 参数含 `liveuid` 或 `room_id` 或 `stream` |
| **G** 全局级 | 仅 `uid`/`token`（+ 无关参数） |
| **U** 未知 | 参数形态不足以判定 |

## 2.2 全部 54 个 Live 相关接口

| 行 | service | 回调标签 | 参数 | 类 |
|---:|---|---|---|---|
| 51 | Live.getAdminList | getAdminList | uid,token,liveuid | R |
| 55 | Live.setAdmin | setAdmin | uid,token,liveuid,touid | R |
| 63 | Live.setAdmin | setAdmin | uid,token,liveuid,room_id,touid | R |
| 71 | Live.cancelShutUp | setShutUp | uid,token,room_id,liveuid,touid | R |
| 83 | Live.getCoin | getCoin | uid,token | G |
| 95 | Live.setReport | setReport | uid,token,touid,content,source | G |
| 103 | Live.setShutUp | setShutUp | uid,token,liveuid,room_id,stream,type,touid | R |
| 107 | Live.getGiftList | getGiftList | uid,token,live_type | G |
| 131 | Live.stopRoom | stopLive | roomId,stream,uid,token,sign,close_type | R（主播关播） |
| 139 | Live.superStopRoom | superCloseRoom | uid,token,liveuid,type,room_id,banruleid | R |
| 143 | Live.getLiveBanInfo | getLiveBanInfo | uid,token | G |
| **147** | **Live.timeCharge** | timeCharge | uid,token,**stream,is_first,liveuid,room_id** | **R（计费）** |
| 151 | Livemanage.getKickList | getLiveBlackList | uid,token,liveuid | R |
| 159 | Live.stopInfo | getLiveEndInfo | stream,uid,token | R |
| 163 | Live.userCloseVoiceMic | userDownVoiceMic | uid,token,stream | R（连麦） |
| 171 | Livepk.GetLiveList | getLivePkList | uid,token | G |
| 179 | Live.getReportClass | getLiveReportList | uid,token | G |
| 183 | Live.newGetSDK | getLiveSdk | uid,token | G |
| 187 | Livemanage.getShutList | getLiveShutUpList | uid,token,liveuid | R |
| 191 | Live.getPop | getLiveUser | uid,token,touid,liveuid | R |
| 195 | Live.getUserRankNew | getLiveUserRank | liveuid,uid,token,stream | R |
| 199 | Livemusic.getDownurl | getMusicUrl | uid,token,audio_id | G |
| 203 | Livemanage.GetRoomList | getMyAdminRoomList | uid,token | G |
| **207** | **Live.getMicPullUrl** | getNewUpMicPullUrl | uid,token,**stream** | **R（连麦拉流）** |
| **211** | **Live.getPull** | getLiveBanInfo | uid,token | **G（非房间级）** |
| 215 | Live.checkLiveing | anchorCheckLive | uid,token,liveuid,stream | R（主播探活） |
| **219** | **Live.getPush** | getLiveBanInfo | uid,token | **G（非房间级）** |
| 223 | Live.applyVoiceLiveMic | applyVoiceLiveMic | uid,token,stream | R（连麦） |
| 231 | Live.changeVoiceEmptyMicStatus | banEmptyMicPosition | uid,token,stream,position | R（连麦） |
| 255 | Live.cancelVoiceLiveMicApply | cancelVoiceLiveMic | uid,token,stream | R（连麦） |
| 263 | Live.changeLive | changeLive | uid,token,stream | R |
| 271 | Live.changeLiveType | changeLiveType | uid,room_id,token,stream,type,type_val | R |
| 275 | Live.getUserListsNew | getUserList | liveuid,uid,token,stream | R |
| 283 | Live.anchorGetVoiceMicList | getVoiceControlList | uid,token,stream | R（连麦） |
| **287** | **Live.checkLive** | checkLive | uid,token,**liveuid,stream** | **R（进房前校验）** |
| 291 | Live.getVoiceLivePullStreams | getVoiceLivePullStreams | uid,token,stream | R（语音房） |
| 295 | Live.checkUserRedis | checkSocketConnect | uid,token,mobileid,liveuid,stream | R |
| 299 | Live.getVoiceMicApplyList | getVoiceMicApplyList | uid,token,stream | R（连麦） |
| 307 | Live.getVoiceMicStream | getVoiceMicStream | uid,token,stream | R（连麦） |
| 315 | Live.handleVoiceMicApply | handleVoiceMicApply | uid,token,stream,apply_uid | R（连麦） |
| 319 | Live.closeUserVoiceMic | closeUserVoiceMic | uid,token,stream,touid | R（连麦） |
| 323 | Live.monitor | Live.monitor | uid,token,liveuid | R |
| 332 | Live.createRoom | createRoom | roomId,live_platform,uid,token,user_nickname,avatar,avatar_thumb,city,province,title,liveclassid,type,type_val,isshop,thumb,live_type,voice_type,deviceinfo | R（主播建播） |
| 336 | Live.kicking | kicking | uid,token,liveuid,touid | R |
| 344 | Live.liveAuth | getMusicUrl | uid,token | G |
| 364 | Livemanage.cancelKick | liveCancelBlack | uid,token,liveuid,touid | R |
| **368** | **Live.enterRoomNew** | **enterRoom** | uid,token,city,**liveuid,mobileid,stream** | **R（真正进房）** |
| 372 | Livemanage.cancelShut | LiveCancelShutUp | uid,token,liveuid,touid | R |
| 380 | Livepk.checkLive | livePkCheckLive | uid,token,liveuid,stream,uid_stream | R |
| 388 | Livepk.Search | livePkSearchAnchor | uid,token,key | G |
| **405** | **Live.roomCharge** | roomCharge | uid,token,stream,liveuid,room_id | **R（房间计费）** |
| 413 | Livemusic.searchMusic | searchMusic | uid,token,key | G |
| 421 | Live.sendBarrage | sendDanmu | uid,token,liveuid,stream,giftid,giftcount,content | R |
| 429 | Live.sendGift | sendGift | uid,token,liveuid,stream,touids,giftid,ispack,is_sticker | R |

**统计：R 类 40 个，G 类 14 个，共 54 个。**

## 2.3 进房链路（CONFIRMED 参数证据）

```
① Live.checkLive（L287）    uid,token,liveuid,stream    进房前校验
   ↓ 返回 code=0 或 40018
② Live.enterRoomNew（L368） uid,token,city,liveuid,mobileid,stream   真正进房
   ↓
③ 进入 LiveAudienceActivity / LiveActivity
```

**`Live.enterRoomNew` 此前完全未被识别**，是本次新发现的进房接口。
其返回是否含 `pull` 字段 → **UNKNOWN**（未抓到成功返回）。

## 2.4 计费相关接口（R 类，禁止改造）

| 接口 | 参数 | 判定 |
|---|---|---|
| Live.timeCharge（L147） | uid,token,stream,is_first,liveuid,room_id | 随流计费候选（INFERRED） |
| Live.roomCharge（L405） | uid,token,stream,liveuid,room_id | 房间计费候选（INFERRED） |

**禁止作为绕过目标，禁止修改请求参数或返回值。**

## 2.5 主播端接口识别

| 接口 | 判定依据 |
|---|---|
| Live.createRoom（L332） | 参数含 roomId/avatar/title/liveclassid —— 建播 |
| Live.stopRoom（L131） | 参数含 sign/close_type —— 关播 |
| Live.checkLiveing（L215） | 回调 anchorCheckLive —— 主播探活 |

## 2.6 连麦链路（与观众端主直播不同路径）

`getMicPullUrl`(207)、`getVoiceLivePullStreams`(291)、`getVoiceMicStream`(307)、
`applyVoiceLiveMic`(223)、`changeVoiceEmptyMicStatus`(231)、`cancelVoiceLiveMicApply`(255)、
`anchorGetVoiceMicList`(283)、`getVoiceMicApplyList`(299)、`handleVoiceMicApply`(315)、
`closeUserVoiceMic`(319) —— 参数均含 `stream`，属连麦/语音房链路。

---

# 第三部分 · 播放器数据模型审计（BATCH 03）

## 3.1 LiveBean 三字段定义（CONFIRMED）

来源：`04_skills/com/yunbao/live/bean/LiveBean.java`

```java
private String pull;
private String stream;
private int    livePlatform;

public String getPull()       { return this.pull; }             // L161
public String getStream()     { return this.stream; }           // L168
@JSONField(name = "live_platform")
public int getLivePlatform()  { return this.livePlatform; }     // L148
```

`toString()`（L314）：
```java
return "uid: " + this.uid + " , userNiceName: " + this.userNiceName
     + " ,playUrl: " + this.pull;
```
→ **`pull` 语义 = playUrl（完整播放地址）**

## 3.2 三个字段的读取点全表（rg 全量 3059 文件）

### 3.2.1 `getPull()` —— 仅 1 处业务读取

| 位置 | 上下文 | 判定 |
|---|---|---|
| `defpackage/x31.java:148` | `String pull = this.b.getPull();` 后接 URL 格式判断 | **浮窗（悬浮窗）组件** |
| `com/yunbao/live/bean/LiveBean.java:161` | 定义本身 | — |
| `com/yunbao/live/bean/VoiceRoomAccPullBean.java:17` | 另一 Bean（语音房） | 不同类 |

**结论：观众端主播放器（LiveAudienceActivity / LiveActivity / 播放器封装）不读取 `pull`。**

### 3.2.2 `getStream()` —— 主播放链路读取

| 位置 | 上下文 |
|---|---|
| `LiveAudienceActivity.java:1175` | `this.y = liveBean.getStream();` ← **主播放字段赋值** |
| `LiveAudienceActivity.java:1036` | `bundle.putString("stream", this.y)` |
| `LiveAudienceActivity.java:1047` | `bundle.putString("stream", this.y)` |
| `CheckLivePresenter.java:129` | 传给 `roomCharge` |
| `CheckLivePresenter.java:144` | 传给 `checkLive` |
| `defpackage/c52.java:94` | `e32.k(liveBean.getUid(), liveBean.getStream(), ...)` |
| `defpackage/me4.java:857` | `liveBean.setStream(this.Q.getStream())` |
| `defpackage/v52.java:178` | 语音房配置 |
| `defpackage/m0.java:38` | 游戏参数 |

**结论：主播放器只接收 `stream` 字符串，不接收完整 URL。播放地址由播放器/SDK 内部构造（模板 UNKNOWN）。**

### 3.2.3 `getLivePlatform()` —— 1 处业务判断

```java
CheckLivePresenter.java:61
if (isActivityInvalid() || this.mLiveBean.getLivePlatform() == 6) return;
```
**`livePlatform == 6` 时不进房**（可能为外链/第三方平台类型）。实测房间值均为 4。

## 3.3 进房后的计费链路（CONFIRMED，本轮关键发现）

### 3.3.1 入口

```java
// LiveAudienceActivity.java:1129
public final void W3(int i2) {
    e32.M0(this.z, this.y, i2, new b(i2));   // M0 = Live.timeCharge
}
```

### 3.3.2 触发时机

```java
// LiveAudienceActivity.java:219-240（内部分支）
int i = liveAudienceActivity.C;
if (i == 2) {
    e32.w0(liveAudienceActivity.z, liveAudienceActivity.y, new C0036a());  // roomCharge
    return;
}
if (i == 3) {
    liveAudienceActivity.W3(1);                                   // timeCharge(is_first=1)
    if (LiveAudienceActivity.this.K0 == null) {
        LiveAudienceActivity.this.K0 = new m24();
    }
    LiveAudienceActivity.this.K0.d("timeCharge", 60000L, 60000L, new b());  // 每 60 秒
}
```

### 3.3.3 响应处理（内部类 b.onSuccess）

```java
// LiveAudienceActivity.java:277-295
public void onSuccess(int i, String str, String[] strArr) {
    if (isFinishing() || isDestroyed()) return;
    if (i == 0) {
        JSONObject T3 = T3(strArr, "timeCharge");
        if (T3 != null && (D = j30.q().D()) != null) {
            D.setLevel(T3.getIntValue("level"));
            D.setCoin(T3.getString("coin"));
        }
        X3();                 // ← 恢复播放
        return;
    }
    if (i != 1008) {
        if (K0 != null) K0.c("timeCharge");
        t54.b(str);           // ← 显示错误文案
        E3();                 // ← 退出房间
        return;
    }
    U3();                     // ← 暂停播放
    this.o0 = true;
    if (K0 != null) K0.c("timeCharge");
    c4(new a());              // ← 弹续费窗
}
```

### 3.3.4 相关方法

```java
// L1077-1083
public void U3() {
    lx1.c("LiveTxPlayViewHolder", "暂停播放");
    d52 d52Var = this.k0;
    if (d52Var != null) d52Var.d0();
}

// L1131-1134
public void X3() {
    lx1.c("LiveTxPlayViewHolder", "恢复播放");
    d52 d52Var = this.k0;
    if (d52Var != null) d52Var.h0();
}
```

### 3.3.5 两条门槛对照

| 层 | 接口 | 错误码 | 发生时机 | 客户端行为 |
|---|---|---|---|---|
| **第一层** | `Live.checkLive` | **40018** | 进房前 | 弹 VIP 窗，不进入房间 |
| **第二层** | `Live.timeCharge` | **1008** | 进房后每 60 秒 | 暂停播放 + 弹续费窗 |
| （房间型） | `Live.roomCharge` | 未知 | `C==2` 时 | 未验证 |

**这解释了为什么把 40018 改成 0 之后仍然黑屏：即使过了第一层，第二层 `timeCharge` 每 60 秒轮询，一旦返回 1008 立刻暂停播放。**

## 3.4 播放器组件识别（UNKNOWN 登记）

| 项目 | 状态 |
|---|---|
| 播放器实现类（`d52` / `k0` 字段类型） | **UNKNOWN** —— 位于 `defpackage`，混淆名 |
| 播放器 URL 构造位置 | **UNKNOWN** —— 3059 文件中未找到 `m3u8`/`setVideoPath`/`setDataSource` 字面量 |
| 播放器初始化源码 | **UNKNOWN** —— 未在包内定位 |
| `LiveAudienceActivity.C` 赋值来源 | **UNKNOWN** —— 决定走 roomCharge 还是 timeCharge |

## 3.5 模型消费关系图

```
列表接口 (Home.getClassLiveCursor)
  └─ 提供: room_id, uid, stream, type, type_val, nums, thumb, ...
     ✗ 不含 pull
        ↓
LiveBean (fastjson 反序列化)
  ├─ stream        → 主播放器（LiveAudienceActivity.y → bundle → 播放器）
  ├─ pull          → 仅浮窗 x31 读取（主播放器不用）
  ├─ livePlatform  → CheckLivePresenter 判断 ==6 则不进房
  ├─ type/typeVal  → 房间收费标记（与 VIP 时段无关）
  └─ roomId        → 房间标识
        ↓
checkLive (40018 门槛) → enterRoomNew → LiveAudienceActivity
        ↓
timeCharge (1008 门槛，每 60 秒轮询) → 暂停/恢复播放
```

---

# 第四部分 · 实验边界（BATCH 04）

## 4.1 允许研究的内容

| 允许项 | 具体范围 |
|---|---|
| 时段字段 | `fail_msg` 中的 "VIP时间段: 20:00 ~ 01:00"；`code` 取值分布 |
| 服务端状态 | `ret` / `code` / `msg` / `info` 四层结构与语义 |
| 数据协议 | 请求参数集合、返回 JSON 字段、加密特征（熵值/长度分布） |
| 客户端展示逻辑 | `CheckLivePresenter` 分叉、`LiveAudienceActivity` 计费轮询 |
| 静态证据 | 3059 个 Java 文件、`libnetshield.so` 符号表 |

## 4.2 明确排除的内容（硬边界）

| 排除项 | 原因 |
|---|---|
| 货币 / 充值 / 票券 / 代币 | 涉及资金，不研究 |
| 支付 / 交易流程 | 同上 |
| 修改 `timeCharge` / `roomCharge` 参数或返回 | 涉及计费 |
| 伪造 VIP 身份 / 签名 | 绕过访问控制 |
| 构造/猜测 CDN 播放 URL | 未获授权，且未经证据支持 |
| 恢复/提取保护密钥 | 同上 |
| 访问受限直播资源 | 同上 |

## 4.3 只读实验矩阵

| 编号 | 实验 | 前置条件 | 只读 | 产出 |
|---|---|---|---|---|
| E1 | 免费时段抓 `checkLive` 成功返回 | 01:00–20:00 | 是 | checkLive 成功结构 |
| E2 | 同上抓 `enterRoomNew` 返回 | 01:00–20:00 | 是 | 进房返回结构 |
| E3 | 观察 `timeCharge` 60 秒轮询返回码 | 01:00–20:00 | 是 | 1008 出现条件 |
| E4 | 同一请求两次密文前缀比对 | 随时 | 是 | 加密模式（CBC/CTR/ECB） |
| E5 | `livePlatform` 取值与是否进房关系 | 随时 | 是 | ==6 的语义 |

**E1–E3 需非 VIP 时段；E4/E5 随时可做。**

## 4.4 待授权验证项（标记，不执行）

| 项 | 为何需要授权 |
|---|---|
| 真实服务端 VIP 判定规则细节 | 需服务方说明 |
| `pull` 字段的权威来源接口 | 需运行时成功响应 |
| 播放器 SDK 的 URL 构造模板 | 需 SDK 文档或授权标注 |

---

# 第五部分 · 最终结论与缺口清单

## 5.1 对三个原始问题的回答

### 问题 1：VIP 时段究竟在哪里判定？

**答案：服务端判定，客户端只负责展示（你列举的第 3 种架构）。**

| 检查项 | 结果 |
|---|---|
| 客户端是否含 20:00/01:00 时间判断 | ❌ 无（3059 文件全查） |
| `CheckLivePresenter` 是否判断时间 | ❌ 无 |
| "VIP时间段:20:00~01:00" 来源 | 服务端 `fail_msg` 的 HTML 文字 |
| 服务端返回什么 | `code:40018` + `msg` + `fail_msg` |

**附加发现：真正的第二道门槛在进房后的 `timeCharge/1008`，同样是服务端判定。**

### 问题 2：高熵数据究竟是什么？

**已排除：**

| 假设 | 排除依据 |
|---|---|
| TLS | 本地回环是**明文 HTTP**，请求头 `GET /appapi/?service=...` 完整可见 |
| gzip | 全部 `gzip=false`，无 `1f 8b`；熵 7.9+ 超出 gzip 范围（典型 7.0–7.6） |
| Base64 | 字符集 64 个，熵上限 6.0 |
| URL 编码 | 熵值更低 |

**支持加密：**

| 证据 | 说明 |
|---|---|
| 熵值 7.90–7.93 | 接近理论上限 8.0 |
| 长度每次不同 | 1024/1818/2028/2712/2804 等 |
| `libnetshield.so` 含完整 BoringSSL AES 表 | AES-128/192/256 全模式（CBC/CFB/CTR/ECB/GCM/XTS） |
| 前 16 字节随机 | 符合 CBC 随机 IV 特征 |

**唯一未做的决定性实验（E4）**：同一请求两次密文前缀比对。
- 前缀相同 → ECB 或固定 IV
- 前缀不同 → CBC/CTR 随机 IV

**当前等级：AES 加密为 INFERRED（强），非 CONFIRMED。**

### 问题 3：40018 与黑屏之间是什么关系？

**完整因果链：**

```
checkLive 返回 40018 + 只有 fail_msg/sharelink（无任何媒体字段）
  ↓
客户端弹 VIP 窗（handleLiveVipRequired）
  ↓ 【改造实验】改成 code=0
handleCheckLiveSuccess → 读 type/type_val/live_platform
  ↓
forwardLiveAudienceActivity → LiveAudienceActivity
  ↓
this.y = liveBean.getStream()        ← 只有 stream 名
bundle.putString("stream", this.y)   ← 传给播放器
  ↓
播放器内部构造 URL（模板 UNKNOWN）
  ↓
timeCharge 每 60 秒轮询 → 若返回 1008 则暂停播放
  ↓
【黑屏】
```

**四层拆解：**

| 层 | 状态 | 依据 |
|---|---|---|
| ① 业务授权 | **CONFIRMED 被拒** | checkLive 返回 40018，无媒体字段 |
| ② 资源可用性 | **UNKNOWN** | 房间是否在播、是否给游客流，未验证 |
| ③ 媒体配置 | **UNKNOWN** | 播放 URL 由播放器内部构造，模板未知 |
| ④ 播放器状态 | **部分 CONFIRMED** | timeCharge 1008 会主动暂停播放 |

## 5.2 证据等级汇总

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
| checkLive 成功返回结构 | UNKNOWN |
| 高熵数据是 AES | INFERRED（强，缺 E4） |

## 5.3 文件缺口清单（UNRESOLVED，不自行补写）

| 缺口 | 说明 |
|---|---|
| 播放器 ViewHolder 类源码 | `d52` / `k0` 字段类型在 defpackage 中，未定位具体类 |
| 播放器 URL 拼装函数 | 3059 文件中无 m3u8/setVideoPath/setDataSource 字面量 |
| `LiveAudienceActivity.C` 赋值来源 | 决定走 roomCharge 还是 timeCharge |
| checkLive / enterRoomNew 成功响应样本 | 需免费时段抓包 |

## 5.4 已实测的失败路线（勿重复）

| 尝试 | 脚本 | 结果 |
|---|---|---|
| 版本号伪装（3.9.0 / 3.8.5 / 3.5.0） | v16 | 仍弹 VIP |
| 父类 `HttpCallback.onSuccess` hook | v17 | 抓不到（子类覆盖） |
| 子类 `CheckLivePresenter$1` hook，40018→0 | v18 | **弹窗消失，但黑屏，播放地址 0** |
| 补齐 JSON 字段（type/live_platform） | v18 | 同上，黑屏 |

## 5.5 最终状态

**PHASE17_COMPLETE**

本轮为纯静态证据审阅 + 边界核对，未修改任何计费接口，未构造任何播放地址，未伪造任何授权。

**最有价值的修正**：
1. 推翻「stream 可拼播放 URL」假设
2. 推翻「getPull 是拉流接口」假设
3. 发现漏掉的 `Live.enterRoomNew`
4. **发现第二道门槛 `timeCharge/1008`（每 60 秒）**

**下一步唯一合法且有价值的动作**：在免费时段（01:00–20:00）执行 E1/E2/E3 只读抓包，补齐 5.3 列出的四个缺口。

---

*报告结束。生成于 2026-11-25 11:45 +0800*