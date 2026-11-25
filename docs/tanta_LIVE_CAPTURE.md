# 探他 实测抓包成果（2026-11-24 23:40）

来源：Frida hook Java 层 fastjson.parseObject（真实运行时数据，非推断）
状态：**明文已获得，接口全通**

---

## 一、真实业务域名

```
CDN / 图片：tanta-0928.kkdsdj.cn
API 基址：http://127.0.0.1:<动态端口>/appapi/   （经 netshield 本地代理）
```
- 端口每次启动变（实测 40429 → 37377）
- 业务 API 走本地代理，真实服务器域名仍未知（不影响使用，因为客户端本来就连本地）

---

## 二、鉴权参数（实测）

```
uid=2001231
token=8c36ae41906ea08f49861c9f84fcc636
signplus=<64位小写hex，每次不同>   ← HMAC-SHA256
timestamp=<10位unix秒>
X-App-Version: 3.9.2.5
X-App-Source: android
User-Agent: Dalvik/2.1.0 (Linux; U; Android ...)
```

**signplus 对应 classes.dex 里的 `ApiSecurityExample.hmacSha256()`** —— 之前判死代码，实为活机制。

---

## 三、已确认接口（service 参数式）

基址：`/appapi/?service=<Name>&<params>`

| service | 参数 | 用途 |
|---|---|---|
| `Home.getClassLiveCursor` | `liveclassid`, `cursor`(base64), `language` | 分类房间列表（分页） |
| `Home.getFollow` | `live_type=0`, `p=1` | 关注列表（页码分页） |
| `Home.getSlide` | 无 | 首页轮播 |
| `Live.checkLive` | `liveuid`, `stream` | 进房前检查 |
| `User.promotion` | 无 | 推广 |

### 分页游标
`cursor` = base64(JSON)，格式 `{"r":"<16位hex>","o":<offset>}`
实测 o：60 / 90 / 120 / 150，r 每次会话变（如 `c921ad04814d6e28`、`bde395562e766833`）

---

## 四、列表返回结构（实测原文）

```json
{
  "has_more": true,
  "latest_revision": "3b17b1ad6de9bde1",
  "list": [
    {
      "room_id": "live_1817466",
      "uid": 1817466,
      "user_nickname": "阿陈",
      "title": "刷礼物提要求加v接私",
      "avatar": "https://tanta-0928.kkdsdj.cn/avatar/20261028/1817466/91134839.webp",
      "thumb": "https://tanta-0928.kkdsdj.cn/avatar/20261028/1817466/91134839.webp",
      "stream": "1817466_1795529924",
      "nums": "5109",
      "type": 2,
      "type_val": "99",
      "live_platform": 4,
      "level_anchor": "1",
      "pkuid": 0,
      "goodNum": ""
    }
  ]
}
```

### 字段语义
| 字段 | 含义 | 备注 |
|---|---|---|
| `room_id` | 房间号 | 可能带 `live_` 前缀，也可能纯数字 |
| `uid` | 主播 ID | 数字 |
| `user_nickname` | 主播昵称 | |
| `title` | 房间标题 | |
| `avatar` / `thumb` | 头像/封面 | 完整 URL |
| `stream` | 推流名 | `<uid>_<时间戳>` |
| `nums` | 观众数 | **字符串**不是数字 |
| `type` | **房型** | **0=普通(免费)，2=付费** |
| `type_val` | **付费金额** | "99"/"30"=币数，""/"0"=免费 |
| `live_platform` | 平台标识 | 4 |
| `level_anchor` | 主播等级 | 字符串 |
| `pkuid` | PK 对手 | 0=无 |

### 付费时段问题的答案
**列表里 `type=2` 就是要付费的房，`type=0` 是免费房。**
晚上 8 点到凌晨 1 点的限制体现在 `type` / `type_val`，客户端能直接筛出来。

---

## 五、加密机制结论（重要）

| 层 | 状态 |
|---|---|
| 本地回环 HTTP 请求 | **明文**，可直接读 |
| 业务响应（native 层） | **AES 加密**（熵 7.9+，非 gzip） |
| Java 层解析前 | **明文**（fastjson.parseObject 拦截成功） |

**结论：不需要逆 AES。直接 hook Java 层拿明文即可。** 这是本次工程的关键突破。

---

## 六、抓包工具链（已跑通）

| 工具 | 版本 | 状态 |
|---|---|---|
| frida (客户端) | 17.26.2 | 可用 |
| frida-server | 17.27.5（root 跑） | 可用 |
| hook 点 | `fastjson.JSON.parseObject(String)` | **命中** |
| hook 点 | `okhttp3.ResponseBody.string` | 装了未命中 |
| 设备 | Andarium 虚拟机 | `192.168.1.11:5555` |

### Frida 17 注意事项
- `Module.findExportByName` 已移除 → 用 `Module.findGlobalExportByName`
- 自动补全会刷屏 → 命令一次敲完回车

---

## 七、待确认（下一轮）

1. `Home.getClassLiveCursor` 完整返回（code 字段、next 游标）
2. `Home.getFollow` 返回结构
3. `Home.getSlide` 返回结构
4. `liveclassid` 有哪些值（对应哪些分类）
5. 进房间时调用的接口（`Live.checkLive` 之后的）
6. 视频/VOD 接口

---

抓包文件：tanta-hook-v14.js（Java 层，已成功）
时点：2026-11-24 23:40 CST