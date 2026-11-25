# 01_EVIDENCE_BOUNDARY.md

PHASE17_VIP_EVIDENCE_REVIEW / BATCH 01 · 证据边界核对
创建：2026-11-25 11:33 +0800

## 0. 本轮起因

上一轮 README 声称 ZIP 内含 `04_skills/com/yunbao/live/activity/LiveAudienceActivity.java` 与 `CheckLivePresenter.java`，
但实际 ZIP 中不存在——经核实原因：**打包 zip 时 `04_skills/com/` 尚未解压入目录**（补包在 zip 生成之后）。
本轮已重新打包：`TANTA_PACK_v2_20261125.zip`（5.8MB / 3102 文件），三个关键文件已在包内。

同时用户指出三个必须纠正的判断错误，本轮全部接受。

---

## 1. 文件存在性核对（ACTUAL_VERIFICATION）

| 文件 | 路径 | 字节 | 状态 |
|---|---|---:|---|
| LiveBean.java | 04_skills/com/yunbao/live/bean/LiveBean.java | 8,685 | ✅ 存在 |
| CheckLivePresenter.java | 04_skills/com/yunbao/main/presenter/CheckLivePresenter.java | 6,431（177 行） | ✅ 存在 |
| LiveAudienceActivity.java | 04_skills/com/yunbao/live/activity/LiveAudienceActivity.java | 59,114（1826 行） | ✅ 存在 |
| e32.java | 04_skills/defpackage/e32.java | — | ✅ 存在 |
| x31.java | 04_skills/defpackage/x31.java | — | ✅ 存在 |
| libnetshield.so | 04_skills/native/libnetshield.so | 5,343,672 | ✅ 存在（sha256 a2d36c3d…） |

旧 ZIP 核对结果：`unzip -l TANTA_PACK_20261125.zip | grep -c "04_skills/com/"` → **0**，确认旧包缺 com/ 目录。

---

## 2. 三个判断错误的纠正（CONFIRMED 修正）

### 纠错 1：type / type_val 不等于 VIP 时段

| 概念 | 归属 | 证据 |
|---|---|---|
| 房间收费类型 `type` / `type_val` | **房间级属性**，由列表接口返回 | 列表 JSON 每条记录含 type/type_val |
| 账号 VIP 权限 | **账号级**，`vip.type` | `User.getBaseInfo` 返回 `"vip":{"type":"0","endtime":""}` |
| VIP 时间窗口 | **服务端时间策略** | `checkLive` 失败时 `fail_msg` 文案含 "VIP时间段: 20:00 ~ 01:00" |

**三者必须分开，不得互相推导。** 此前 tanta_LIVE_CAPTURE.md 把 type=2 表述为"付费房"，未与 VIP 时段区分，本轮降级为：
- `type=2` 的含义：**房间标价**（CONFIRMED 字段存在，语义为 INFERRED）
- 与 VIP 时段**无因果关系**（CONFIRMED 分离）

### 纠错 2：Live.getPull 不是观众端拉流接口

原文（e32.java:210-213）：
```java
public static void a0(HttpCallback httpCallback) {
    HttpClient.getInstance().get("Live.getPull", "getLiveBanInfo")
        .params("uid", j30.q().C())
        .params("token", j30.q().B())
        .execute(httpCallback);
}
```

| 检查项 | 结果 |
|---|---|
| 是否带 liveuid | ❌ 无 |
| 是否带 stream | ❌ 无 |
| 是否带 room_id | ❌ 无 |
| 回调标签 | `getLiveBanInfo`（暗示"封禁信息"，与拉流语义不符） |

**结论：不可能是"指定房间的观众拉流接口"。** 此前把它列为拉流入口的判断**被推翻（CONTRADICTED）**。
同组 `Live.getPush`（L219）参数同样只有 uid/token，回调同为 getLiveBanInfo，同样不属于房间级接口。

### 纠错 3：Live.timeCharge 不能认定为 VIP 时段判定接口

原文（e32.java:146-148）：
```java
public static void M0(String str, String str2, int i, HttpCallback httpCallback) {
    HttpClient.getInstance().get("Live.timeCharge", "timeCharge")
        .params("uid", ...).params("token", ...)
        .params("stream", str2)
        .params("is_first", Integer.valueOf(i))
        .params("liveuid", str)
        .params("room_id", "live_" + str)
        .execute(httpCallback);
}
```

| 属性 | 判断 |
|---|---|
| 参数完整性 | ✅ 有 liveuid/stream/room_id/is_first，是房间级接口 |
| 是否"时间计费" | 名称与 is_first 参数吻合（INFERRED） |
| 是否等于 VIP 时段判定 | **UNKNOWN**，名称不足以证明 |
| 是否可作为改造目标 | **禁止**——涉及计费，不修改其参数/返回值 |

**结论：登记为"随流上报的计费接口候选（INFERRED）"，不作为任何绕过目标。**

---

## 3. 一条新的强证据：LiveBean.pull 就是播放地址（CONFIRMED）

`LiveBean.java` 第 314 行 toString：
```java
return "uid: " + this.uid + " , userNiceName: " + this.userNiceName + " ,playUrl: " + this.pull;
```
**字段 `pull` 被显式标注为 `playUrl`。**

`x31.java:148-150` 的判断进一步佐证：
```java
String pull = this.b.getPull();
if ((TextUtils.isEmpty(pull) || !(pull.startsWith("http://") || pull.startsWith("https://")
     || pull.contains(".mp4") || pull.contains(".MP4"))) && this.e == null) { ... }
```
**pull 是完整 URL（http/https/.mp4），不是 stream 名。**

---

## 4. 证据等级总表（本轮）

| 结论 | 等级 |
|---|---|
| LiveBean.pull = 播放地址（完整 URL） | **CONFIRMED**（toString 标注 + 类型判断） |
| 观众端代码中不存在 `setPull` 调用 | **CONFIRMED**（rg 全量 3059 文件，仅主播端 1 处） |
| 观众端 pull 只能来自 JSON 反序列化 | **INFERRED**（fastjson 自动 setter） |
| 列表接口 JSON 不含 pull 字段 | **CONFIRMED**（实测抓包 + 字段清单比对） |
| checkLive 成功返回的结构 | **UNKNOWN**（从未抓到，一直是 40018） |
| type=2 与 VIP 时段无因果 | **CONFIRMED** |
| Live.getPull 非观众拉流 | **CONFIRMED** |
| Live.timeCharge 是否 VIP 判定 | **UNKNOWN** |

---

## 5. 会话内必须坚持的三条禁令

1. **禁止**把 `type=2` 当作 VIP 时段证据。
2. **禁止**把 `Live.getPull` 当作观众拉流接口。
3. **禁止**修改 `Live.timeCharge` / `Live.roomCharge` 的参数或返回值（涉及计费）。