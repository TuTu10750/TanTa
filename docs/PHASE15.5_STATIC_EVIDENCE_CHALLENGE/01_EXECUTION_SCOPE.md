# 01_EXECUTION_SCOPE.md

任务：PHASE15.5_STATIC_EVIDENCE_CHALLENGE（离线静态证据反证审计）
创建时间：2026-11-24 14:22 +0800
性质：反证式证据审计，非重新逆向、非扫描、非运行时、非网络访问

## 执行前保护核对（ACTUAL_VERIFICATION）
- 工作区 /var/minis/workspace：仅 1 个文件 tanta_reverse_archive.md（5605B，sha256 479f320894e286006197c2dc5d3f002725e0f189ebef9c7593ff7ae62a7567fd）
- 审计目录 PHASE15.5_STATIC_EVIDENCE_CHALLENGE：执行前不存在，本轮新建，未覆盖任何既有内容
- 原始资料：/var/minis/attachments/uploads/探他与直播模块资料汇总.md（160851B），未修改
- 沙箱成果：/opt/tanta_research/sources（3936 文件）、/opt/tanta_research/jout1/sources（4486 文件）、so/dex/apk 齐全，未修改
- 历史文件：tanta_reverse_archive.md 仅读取，未修改

## 实际检查的文件（ACTUAL_VERIFICATION）
1. tanta_reverse_archive.md（本地，全读）
2. /opt/tanta_research/sources/defpackage/wg1.java（沙箱，全读）
3. /opt/tanta_research/sources/defpackage/j30.java（沙箱，关键方法 + 常量）
4. /opt/tanta_research/sources/com/yunbao/common/http/fuel/FuelHttpClient.java（沙箱，全读）
5. /opt/tanta_research/sources/com/netshield/Netshield.java（沙箱，全读）
6. /opt/tanta_research/sources/defpackage/f12.java（沙箱，前 120 行）
7. /opt/tanta_research/sources/com/yunbao/common/activity/WebViewActivity.java（146-220 行）
8. /opt/tanta_research/sources/com/yunbao/main/activity/MainActivity.java（1395-1420 行）
9. /opt/tanta_research/sources/com/yunbao/main/LinkFortyWrapper$initialize$1.java（140-158 行）
10. /opt/tanta_research/jout1/sources/com/yunbao/common/http/ApiSecurityExample.java（前轮已读，本轮引用）
11. /opt/tanta_research/jout1/sources/com/yunbao/common/http/RsaMaterial.java（前轮已读，本轮引用）

## 仅引用既有报告、未重新验证（EXISTING_EVIDENCE_REFERENCE）
- APK 哈希三份对比：引用 tanta_reverse_archive.md 第六节
- classes.dex 补拆与 RSA 死代码结论：引用档案第八节
- Unidbg 失败：引用档案第七节
- OSS bucket 探测、so 全量扫描、Ghidra/QEMU 失败：引用档案第四节
- data.facegl.com 实测：引用档案第一节/第四节

## 本轮禁止项执行情况
未做：真机/网络请求/App 安装启动/访问业务服务器/重新反编译/全量 DEX 扫描/全量 SO 扫描/Ghidra/QEMU/XOR/MD5/AES 密钥猜测/域名猜测枚举/凭证提取/修改历史文件/修改原始二进制。
全部禁止项均遵守。

## 边界
本轮只回答"现有证据是否支持结论"，不回答"真实服务器返回什么"。
