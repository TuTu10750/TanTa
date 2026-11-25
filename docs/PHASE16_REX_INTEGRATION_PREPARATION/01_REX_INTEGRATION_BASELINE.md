# 01_REX_INTEGRATION_BASELINE.md

任务：PHASE16_REX_INTEGRATION_PREPARATION / BATCH 01 Rex 工程现状盘点
创建时间：2026-11-24 14:33 +0800

## 执行前检查（ACTUAL_VERIFICATION）

检查范围：本地 /var/minis 全部目录、沙箱 /opt /root、共享 /var/minis/shared。

| 检查项 | 结果 |
|---|---|
| Rex 项目目录 | **未找到** |
| 现有模块源码（*.js 业务模块） | **未找到**（仅有 skill 模板 js，无关） |
| xl-live 模块源码 | **未找到**（历史 minis://workspace/xl-live-v19xx.js 链接指向的实体文件不在当前环境） |
| 现有接口适配机制 | 无源码，无法实际验证 |
| 现有请求封装机制 | 无源码，无法实际验证 |
| 现有数据解析机制 | 无源码，无法实际验证 |
| 现有页面展示机制 | 无源码，无法实际验证 |
| 现有错误处理机制 | 无源码，无法实际验证 |
| 当前项目修改状态 | 无可修改的 Rex 工程 |
| 未提交修改 | 不适用 |
| 冻结文件 | xl-live 冻结成果（PHASE12-15）不在本环境，未触碰 |

**唯一可访问的 Rex 相关资料**（EXISTING_EVIDENCE_REFERENCE）：
- `/var/minis/shared/xl-live-docs/FINAL_REPORT-5e89cef5.md`（26,581 B，sha256 5e89cef5…）
  - 内容：xl-live v1.9.11→v1.9.13 事故复盘与修复方案（会话完整记录）
  - 含模块代码片段（loadResource/loadDetail）、模块 ID 命名规则、线路返回结构、Rex 运行时约束描述

## 从 FINAL_REPORT 引用的 Rex 结构信息（EXISTING_CODE_REFERENCE，非重新验证）

1. **模块入口/生命周期**：
   - 模块 ID 命名：`user.xllive1913`，子模块前缀 `xl1913-*`；导入链接 raw.githubusercontent.com/TuTu10750/Egern-/main/xl-live-v19xx.js
   - 模块导出 `loadDetail`（详情解析）与 `loadResource`（线路解析）两个入口
   - 生命周期：模块级缓存 + 本地持久化（Widget.storage），24h TTL

2. **数据传递机制**：
   - `loadResource` 返回线路数组，每条含 name/url/desc 字段
   - Rex 隐藏 url 为空的行（5.4 问题根源）——展示层由 Rex 控制
   - 线路类型：「直播·中继」「直播·直连」「录像·中继/原始/直连」

3. **请求封装机制**：
   - `apiGet("/api/live/play", {id,user})` 封装 Rex 的 Widget.http
   - Rex 运行时约束（来自原始资料 Rex 运行时审计）：可用 Promise/async-await/JSON/Map/Widget.storage/Widget.http/间接 eval；**不可用 fetch/XMLHttpRequest/WebSocket/setTimeout/require/URL/TextEncoder**

4. **页面渲染机制**：
   - Rex 三列卡片网格，卡片下仅 TITLE；详情页由模块 loadDetail 返回描述文本

5. **错误处理机制**：
   - 空 url 行被 Rex 隐藏 → 用描述字段带状态文案绕过
   - 外站 http(s) 链接 guard：loadDetail throw / loadResource return []

6. **兼容要求**：
   - 模块必须纯 ES5/受限 JS（无原生 setTimeout、无 WebSocket）
   - 模块 ID/内层 ID 必须全唯一（覆盖导入不清除注册）

## 可复用代码 / 不可复用代码
- **可复用（设计模式层面，EXISTING_CODE_REFERENCE）**：loadResource 线路数组结构、apiGet 请求封装、描述字段带状态、持久化回退链（内存→cache→storage→过期提示）
- **不可复用**：xl-live 具体业务代码（直播中继/VOD/收藏），与探他无关且属冻结模块；当前环境无实体源码可拷贝

## 冻结文件
- xl-live PHASE12/13/14/15 全部冻结，本轮未访问其源码（本环境无）、未修改。

## 环境限制结论
**Rex 工程源码不可访问 → 按停止条件 1，停止一切项目修改。** BATCH 03/04 只能做设计层与模拟层，不能落地为可导入 Rex 的实体模块。

## 证据类型标记
- ACTUAL_VERIFICATION：目录/文件存在性检查（Rex 源码缺失）
- EXISTING_CODE_REFERENCE：FINAL_REPORT 中的模块结构片段
- INFERENCE：无
- UNRESOLVED：Rex 工程实体路径、可拷贝的模块框架源码、现有代码的未提交修改状态
