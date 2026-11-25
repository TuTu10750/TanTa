# 02_CALL_RELATION_REVIEW.md

PHASE17_VIP_EVIDENCE_REVIEW / BATCH 02 · 已有调用关系复核
创建：2026-11-25 11:34 +0800

来源：`04_skills/defpackage/e32.java`（ACTUAL_VERIFICATION，逐行解析）
方法：只记录**参数集合**，按参数形态判定归属；**不以接口名推断功能**。
分类依据：是否含房间标识（liveuid / room_id / stream）。

---

## 一、分类规则（先立规则再归类）

| 类别 | 判定条件 |
|---|---|
| **R** 房间级（可指向具体房间） | 参数含 liveuid 或 room_id 或 stream 之一 |
| **G** 全局级（只带账号） | 仅 uid/token（+ 无关参数） |
| **U** 未知 | 参数形态不足以判定 |

---

## 二、全部 54 个 Live 相关接口（按行号）

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
| 131 | Live.stopRoom | stopLive | roomId,stream,uid,token,sign,close_type | R |
| 139 | Live.superStopRoom | superCloseRoom | uid,token,liveuid,type,room_id,banruleid | R |
| 143 | Live.getLiveBanInfo | getLiveBanInfo | uid,token | G |
| **147** | **Live.timeCharge** | timeCharge | uid,token,**stream,is_first,liveuid,room_id** | **R** |
| 151 | Livemanage.getKickList | getLiveBlackList | uid,token,liveuid | R |
| 159 | Live.stopInfo | getLiveEndInfo | stream,uid,token | R |
| 163 | Live.userCloseVoiceMic | userDownVoiceMic | uid,token,stream | R |
| 171 | Livepk.GetLiveList | getLivePkList | uid,token | G |
| 179 | Live.getReportClass | getLiveReportList | uid,token | G |
| 183 | Live.newGetSDK | getLiveSdk | uid,token | G |
| 187 | Livemanage.getShutList | getLiveShutUpList | uid,token,liveuid | R |
| 191 | Live.getPop | getLiveUser | uid,token,touid,liveuid | R |
| 195 | Live.getUserRankNew | getLiveUserRank | liveuid,uid,token,stream | R |
| 199 | Livemusic.getDownurl | getMusicUrl | uid,token,audio_id | G |
| 203 | Livemanage.GetRoomList | getMyAdminRoomList | uid,token | G |
| **207** | **Live.getMicPullUrl** | getNewUpMicPullUrl | uid,token,**stream** | **R** |
| **211** | **Live.getPull** | getLiveBanInfo | uid,token | **G（非房间级）** |
| 215 | Live.checkLiveing | anchorCheckLive | uid,token,liveuid,stream | R |
| **219** | **Live.getPush** | getLiveBanInfo | uid,token | **G（非房间级）** |
| 223 | Live.applyVoiceLiveMic | applyVoiceLiveMic | uid,token,stream | R |
| 231 | Live.changeVoiceEmptyMicStatus | banEmptyMicPosition | uid,token,stream,position | R |
| 255 | Live.cancelVoiceLiveMicApply | cancelVoiceLiveMic | uid,token,stream | R |
| 263 | Live.changeLive | changeLive | uid,token,stream | R |
| 271 | Live.changeLiveType | changeLiveType | uid,room_id,token,stream,type,type_val | R |
| 275 | Live.getUserListsNew | getUserList | liveuid,uid,token,stream | R |
| 283 | Live.anchorGetVoiceMicList | getVoiceControlList | uid,token,stream | R |
| **287** | **Live.checkLive** | checkLive | uid,token,**liveuid,stream** | **R（进房前校验）** |
| 291 | Live.getVoiceLivePullStreams | getVoiceLivePullStreams | uid,token,stream | R |
| 295 | Live.checkUserRedis | checkSocketConnect | uid,token,mobileid,liveuid,stream | R |
| 299 | Live.getVoiceMicApplyList | getVoiceMicApplyList | uid,token,stream | R |
| 307 | Live.getVoiceMicStream | getVoiceMicStream | uid,token,stream | R |
| 315 | Live.handleVoiceMicApply | handleVoiceMicApply | uid,token,stream,apply_uid | R |
| 319 | Live.closeUserVoiceMic | closeUserVoiceMic | uid,token,stream,touid | R |
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

统计：R 类 40 个，G 类 14 个。

---

## 三、关键接口的职责判定（只按参数与调用点）

### 3.1 进房链路（CONFIRMED 参数证据）

```
① Live.checkLive（L287）      uid,token,liveuid,stream      进房前校验
   ↓ 返回 code=0 或 40018
② Live.enterRoomNew（L368）   uid,token,city,liveuid,mobileid,stream   真正进房
   ↓
③ 进入 LiveAudienceActivity / LiveActivity
```

**`Live.enterRoomNew` 此前完全未被识别**，是本次新发现的进房接口。
其返回是否含 `pull` 字段 → **UNKNOWN**（未抓到成功返回）。

### 3.2 Live.getPull / Live.getPush（CONTRADICTED 为房间级）

两者参数均为 `uid,token`，回调名均为 `getLiveBanInfo`。
**判定：非房间级，不能返回指定房间的播放地址。**
可能用途（INFERRED，未验证）：账号级封禁状态查询。

### 3.3 计费相关（R 类，禁止改造）

| 接口 | 参数 | 判定 |
|---|---|---|
| Live.timeCharge（L147） | uid,token,stream,is_first,liveuid,room_id | 随流计费候选（INFERRED） |
| Live.roomCharge（L405） | uid,token,stream,liveuid,room_id | 房间计费候选（INFERRED） |

**禁止**把它们作为绕过目标，也禁止修改请求参数或返回值。

### 3.4 主播端接口（按调用点区分）

| 接口 | 判定依据 |
|---|---|
| Live.createRoom（L332） | 参数含 roomId/avatar/title/liveclassid —— 建播 |
| Live.stopRoom（L131） | 参数含 sign/close_type —— 关播 |
| Live.checkLiveing（L215） | 回调 anchorCheckLive —— 主播探活 |

### 3.5 连麦相关（R 类）

`getMicPullUrl`（207）、`getVoiceLivePullStreams`（291）、`getVoiceMicStream`（307）、`applyVoiceLiveMic`（223）等，
参数均含 `stream`，属连麦/语音房链路，**与观众端主直播拉流不是同一路径**。

---

## 四、本轮未解决的缺口（UNRESOLVED）

| 缺口 | 原因 |
|---|---|
| `Live.checkLive` 成功时的返回结构 | 从未抓到（一直是 40018） |
| `Live.enterRoomNew` 的返回结构 | 从未抓到 |
| `pull` 字段由哪个接口下发 | 观众端无 setPull 调用，只能靠反序列化，来源接口未知 |
| `Live.getPull`/`getPush` 的真实用途 | 参数不含房间，用途未知 |

**下一步唯一能补缺口的方式：在非 VIP 时段（01:00–20:00）抓一次完整成功进房流程。**
这属于运行时观测，本轮不执行。