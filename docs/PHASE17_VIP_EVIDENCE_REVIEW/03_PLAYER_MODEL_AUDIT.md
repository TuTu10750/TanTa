# 03_PLAYER_MODEL_AUDIT.md

PHASE17_VIP_EVIDENCE_REVIEW / BATCH 03 · 播放器数据模型审计
创建：2026-11-25 11:38 +0800

## 一、LiveBean 三个字段的定义（CONFIRMED）

来源：`04_skills/com/yunbao/live/bean/LiveBean.java`

```java
private String pull;          // L45 附近
private String stream;
private int    livePlatform;

public String getPull()   { return this.pull; }        // L161
public String getStream() { return this.stream; }      // L168
@JSONField(name = "live_platform")
public int getLivePlatform() { return this.livePlatform; }  // L148
```

`toString()`（L314）：
```java
return "uid: " + this.uid + " , userNiceName: " + this.userNiceName + " ,playUrl: " + this.pull;
```
→ **`pull` 语义 = playUrl（完整播放地址）**

---

## 二、三个字段的读取点全表（ACTUAL_VERIFICATION · rg 全量 3059 文件）

### 2.1 `getPull()` —— 仅 1 处业务读取

| 位置 | 上下文 | 判定 |
|---|---|---|
| `defpackage/x31.java:148` | `String pull = this.b.getPull();` 后接 `startsWith("http://") \|\| https:// \|\| .mp4` | **浮窗（悬浮窗）组件** |
| `com/yunbao/live/bean/LiveBean.java:161` | 定义本身 | — |
| `com/yunbao/live/bean/VoiceRoomAccPullBean.java:17` | 另一 Bean（语音房） | 不同类 |

**结论：观众端主播放器（LiveAudienceActivity / LiveActivity / 播放器封装）不读取 `pull`。**

### 2.2 `getStream()` —— 主播放链路读取

| 位置 | 上下文 |
|---|---|
| `LiveAudienceActivity.java:1175` | `this.y = liveBean.getStream();` ← **主播放字段赋值** |
| `LiveAudienceActivity.java:1036/1047` | `bundle.putString("stream", this.y)` → 传给播放器 |
| `CheckLivePresenter.java:129/144` | 传给 `roomCharge` / `checkLive` |
| `defpackage/c52.java:94` | `e32.k(liveBean.getUid(), liveBean.getStream(), ...)` |
| `defpackage/me4.java:857` | `liveBean.setStream(this.Q.getStream())` |
| `defpackage/v52.java:178` | 语音房配置 |
| `defpackage/m0.java:38` | 游戏参数 |

**结论：主播放器只接收 `stream` 字符串，不接收完整 URL。播放地址由播放器/SDK 内部构造（UNKNOWN 具体模板）。**

### 2.3 `getLivePlatform()` —— 1 处业务判断

```java
CheckLivePresenter.java:61
if (isActivityInvalid() || this.mLiveBean.getLivePlatform() == 6) return;
```
**`livePlatform == 6` 时不进房**（可能是外链/第三方平台类型）。实测房间值均为 4。

---

## 三、播放器组件识别（UNKNOWN 部分登记）

| 项目 | 状态 |
|---|---|
| 播放器实现类（`d52`、`k0` 字段类型） | **UNKNOWN** —— 位于 `defpackage`，混淆名 |
| 播放器 URL 构造位置 | **UNKNOWN** —— 3059 文件中未找到 `m3u8`/`setVideoPath`/`setDataSource` 字面量 |
| 播放器初始化源码 | **UNKNOWN** —— 未在包内定位 |

**证据缺口登记（不自行补写）：**
1. 播放器 ViewHolder 类（`d52`）源码 —— 若在包内请检索 `04_skills/defpackage/d52.java`
2. 播放器 URL 拼装函数 —— 需进一步在 defpackage 内按 SDK 调用特征检索
3. `LiveAudienceActivity.C` 字段的赋值来源（决定走 roomCharge 还是 timeCharge）

---

## 四、进房后的计费链路（CONFIRMED，本轮关键发现）

来源：`LiveAudienceActivity.java` L200-200、L1100-1135、L243-295

```
进入房间后
  ↓
字段 C：C==2 → e32.w0(...) = Live.roomCharge
        C==3 → W3(1) → Live.timeCharge(is_first=1)
        C 其他值 → 未覆盖（UNKNOWN）
  ↓
timeCharge 响应（内部类 b.onSuccess）
  ├─ code == 0    → 读 level / coin → X3() 恢复播放
  ├─ code == 1008 → U3() 暂停播放 → c4(弹窗) → 60 秒后重试
  └─ 其他 code    → t54.b(msg) 显示提示 → E3() 退出房间
  ↓
定时器 m24：每 60 秒触发一次 W3(1)，循环 timeCharge
```

**关键结论：**
- `Live.timeCharge` 是**进房后的周期性计费校验**，每 60 秒一次。
- **`code == 1008` = 时长/费用不足 → 暂停播放**。这是"进去后卡住"的真实机制。
- `code == 40018`（checkLive 阶段）= 进房前 VIP 门槛。

**两层门槛不同：**

| 门槛 | 接口 | 码 | 阶段 | 表现 |
|---|---|---|---|---|
| 第一层 | Live.checkLive | 40018 | 进房前 | 弹 VIP 窗，不进房 |
| 第二层 | Live.timeCharge | 1008 | 进房后 | 暂停播放，弹续费窗 |

---

## 五、模型消费关系图

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
timeCharge (1008 门槛，每 60 秒)
```

---

## 六、本轮禁止项执行确认

- 未修改 `Live.timeCharge` / `Live.roomCharge` 的任何参数或返回值
- 未构造、未推断任何 CDN 播放地址
- 未把 `stream` 当作可拼 URL 的依据
- 缺源码登记为 UNKNOWN，未自行补写