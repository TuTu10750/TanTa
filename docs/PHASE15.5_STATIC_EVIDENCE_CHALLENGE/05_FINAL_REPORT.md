# 05_FINAL_REPORT.md

任务：PHASE15.5_STATIC_EVIDENCE_CHALLENGE
完成时间：2026-11-24 14:30 +0800
最终状态：PHASE15_5_COMPLETE_STATIC_RESEARCH_STOP

## 10 项最终报告要求逐项回答

1. **本轮实际完成了哪些工作？**
   执行前保护核对；建立独立审计目录；核对九项核心结论的证据来源与等级；最小范围复核 wg1/j30/FuelHttpClient/Netshield/WebViewActivity/MainActivity/LinkForty/f12 的调用关系；HTTP/WS 架构反证；数据模型分类；十条最强反对者审计；停止边界判定；生成本套报告与哈希清单。

2. **哪些文件被实际检查？**
   tanta_reverse_archive.md；wg1.java；j30.java（关键方法与常量）；FuelHttpClient.java；Netshield.java；f12.java（前 120 行）；WebViewActivity.java（146-220）；MainActivity.java（1395-1420）；LinkFortyWrapper$initialize$1.java（140-158）。详见 01_EXECUTION_SCOPE.md。

3. **哪些文件只是引用既有报告，未重新检查？**
   APK 三份哈希对比；classes.dex 补拆与 RSA/HMAC 死代码结论；Unidbg 失败；OSS bucket 探测；so 全量扫描；Ghidra/QEMU 失败；data.facegl.com 实测。均为 EXISTING_EVIDENCE_REFERENCE。

4. **哪些结论被确认？**
   应用内部标识；FuelHttpClient 用 127.0.0.1；G/H/I/J 四 ruleName 参数；j30.p() 函数行为；Java 层 TLS 全信任；wg1.java 24 条路径常量；已检查范围内无明文业务域名；业务域名尚未确认。

5. **哪些结论被降级？**
   - Netshield 远端配置：INFERRED（原近似事实表述）
   - data.facegl.com 排除：SUPPORTED 且限定为"非 appapi 主目标"
   - HTTP/WS 独立服务：INFERRED
   - 公共参数全局通用：CONTRADICTED
   - 32 位启动串"是密钥"：改为"启动凭证字符串，用途未知"
   - 8 字节 XOR 解释全部保护：降级为"一处字符串保护"
   - 静态覆盖全部关键网络行为：降级为"Java 层 + native 边界，未穿透运行时"

6. **哪些结论被推翻？**
   - "所有业务请求都走 127.0.0.1:<port>/appapi/"（getFile/getString/WebView 等有多路径）
   - "所有接口都使用相同公共参数"（调用点直接反证）
   - "HTTP 与 WS 只有 G/H 两个端口规则"（漏 I/J）

7. **是否发现新证据？**
   本轮未产生新的运行时证据；在已有源码中发现前轮未归档的证据：j30.I()/J() 两个端口规则、j30.p() 调用点稀少、多请求封装方式（WebViewActivity.E1/xxx.e/rv3.a/SocketClient）。

8. **是否发现历史结论过度推断？**
   是，共 7 项，见第 5 点和 03_CONTRADICTION_AUDIT.md 十条反例。

9. **是否存在未解决问题？**
   存在，全部为 C 类：真实业务域名、配置服务器、接口响应、签名/鉴权、native TLS、远端拓扑。均需运行时或授权外部证据，本轮不突破边界。

10. **静态研究是否已经到达停止边界？**
    是。九项核心结论已核对，反证完成，B 类剩余项不影响核心，C 类不可静态解决。判定 STATIC_RESEARCH_STOP。

11. **下一步是否需要运行时证据？**
    是。要接入 Rex 必须拿到真实业务域名、请求/响应结构、鉴权方式，均需运行时或授权外部证据。

12. **是否存在合法授权的非运行时替代证据来源？**
    可能存在：云豹直播系统公开源码/文档（若与探他版本匹配）、服务方授权资料、第三方已授权研究报告。但这些只能作为旁证，不能替代运行时确认当前实例的域名与响应。

## 证据类型标记
- ACTUAL_VERIFICATION：本轮实读的 10 个文件及其结论
- EXISTING_EVIDENCE_REFERENCE：APK 哈希、Unidbg/Ghidra/QEMU/OSS/cert 实测等历史报告引用
- INFERENCE：Netshield 远端配置内容、端口到远端拓扑映射、签名用途
- UNRESOLVED：C 类全部问题

## 最终状态
PHASE15_5_COMPLETE_STATIC_RESEARCH_STOP

执行结束后停止，等待总控审核。本轮不启动下一阶段。
