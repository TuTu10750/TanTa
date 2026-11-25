package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.r;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.idtracking.i;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class c implements UMLogDataProtocol {
    public static final String b = "preInitInvokedFlag";
    public static final String c = "policyGrantInvokedFlag";
    public static final String d = "policyGrantResult";
    private static int f = 1;
    private Context e;
    public static final String a = be.b().b(be.q);
    private static Class<?> g = null;
    private static Method h = null;
    private static Method i = null;
    private static Method j = null;
    private static volatile String k = "";
    private static volatile String l = "";
    private static boolean m = false;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(bv.x), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader == null || !buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a2 = bg.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a2);
                }
            }
        }).start();
    }

    public static void a(final Context context, final boolean z) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(i.a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = bg.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a2) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(i.c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(i.b, a2);
                        edit2.commit();
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: write oaid to sp complete.");
                    }
                    if (DeviceConfig.isHonorDevice() && sharedPreferences != null) {
                        SharedPreferences.Editor edit3 = sharedPreferences.edit();
                        edit3.putString(com.umeng.commonsdk.statistics.idtracking.c.b, a2);
                        edit3.commit();
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: write oaid to sp complete.");
                    }
                    if (z) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        Class<?> cls = g;
        if (cls == null || (method = h) == null || j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, null);
            if (invoke == null) {
                return "";
            }
            String str = (String) j.invoke(invoke, null);
            try {
                l = str;
                return str;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bv.g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(bv.g), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader == null || !buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    private static void c() {
        try {
            g = ZIDManager.class;
            Method declaredMethod = ZIDManager.class.getDeclaredMethod("getInstance", null);
            if (declaredMethod != null) {
                h = declaredMethod;
            }
            Method declaredMethod2 = g.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                i = declaredMethod2;
            }
            Method declaredMethod3 = g.getDeclaredMethod("getSDKVersion", null);
            if (declaredMethod3 != null) {
                j = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            SharedPreferences sharedPreferences = context.getSharedPreferences(i.a, 0);
                            if (sharedPreferences == null || sharedPreferences.getString(i.b, "").equalsIgnoreCase(str)) {
                                return;
                            }
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(i.b, str);
                            edit.commit();
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }

    private void d() {
        bx a2 = bx.a(this.e);
        by a3 = a2.a(bz.c);
        if (a3 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a3.a;
                String str2 = a3.b;
                JSONObject a4 = new com.umeng.commonsdk.statistics.b().a(this.e.getApplicationContext(), new JSONObject(a3.c), new JSONObject(a3.d), a3.e, str2, a3.f);
                if (a4 == null || !a4.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a2.a(bz.c, str);
                a2.b();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(android.content.Context r10) {
        /*
            r9 = this;
            if (r10 != 0) goto L4
            goto L8d
        L4:
            java.lang.String r9 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r0 = "debugkey"
            java.lang.String r1 = com.umeng.common.b.a(r10, r9, r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L8d
            java.lang.String r2 = "startTime"
            java.lang.String r2 = com.umeng.common.b.a(r10, r9, r2)
            java.lang.String r3 = "period"
            java.lang.String r9 = com.umeng.common.b.a(r10, r9, r3)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r4 = 0
            if (r3 != 0) goto L2f
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L2f
            long r2 = r2.longValue()     // Catch: java.lang.Throwable -> L2f
            goto L30
        L2f:
            r2 = r4
        L30:
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            if (r6 != 0) goto L3f
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch: java.lang.Throwable -> L3f
            long r6 = r9.longValue()     // Catch: java.lang.Throwable -> L3f
            goto L40
        L3f:
            r6 = r4
        L40:
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            java.lang.String r8 = "MobclickRT"
            if (r9 == 0) goto L83
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 != 0) goto L4b
            goto L83
        L4b:
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r2 = 60000(0xea60, double:2.9644E-319)
            long r6 = r6 * r2
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L6c
            java.lang.String r9 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r8, r9)
            java.lang.String r9 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r10, r9)
            boolean r9 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r9 == 0) goto L8d
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L8d
        L6c:
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            r9.put(r0, r1)
            boolean r10 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r10 != 0) goto L8d
            java.lang.String r10 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r8, r10)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r9)
            goto L8d
        L83:
            java.lang.String r9 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r8, r9)
            java.lang.String r9 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r10, r9)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private void e() {
        if (m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            a(this.e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.e.getSharedPreferences(i.a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(i.b, str);
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(c.this.e, a.w, b.a(c.this.e).a(), null);
                }
            });
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a2 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a2.getDeclaredMethod("getInstance", null);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a2, null)) == null || (declaredMethod = a2.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.e);
            f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.e != null) {
                        UMWorkDispatch.sendEvent(c.this.e, a.x, b.a(c.this.e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.e, true);
        }
    }

    private static void f(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bz.l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    private void g() {
        if (f <= 0) {
            h();
            e(this.e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.e)) {
            f(this.e);
            UMInnerManager.sendInnerPackage(this.e);
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.at) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.e)) {
                Context context = this.e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), null, 5000L);
            }
            Context context2 = this.e;
            UMWorkDispatch.sendEvent(context2, r.a.z, CoreProtocol.getInstance(context2), null);
            Context context3 = this.e;
            UMWorkDispatch.sendEvent(context3, a.t, b.a(context3).a(), null);
        }
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(k)) {
            return k;
        }
        Class<?> cls = g;
        if (cls == null || (method = h) == null || i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, null);
            if (invoke == null) {
                return "";
            }
            String str = (String) i.invoke(invoke, this.e);
            try {
                k = str;
                return str;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0306 A[Catch: all -> 0x0469, TryCatch #2 {all -> 0x0469, blocks: (B:28:0x00a7, B:30:0x00af, B:32:0x00be, B:33:0x00c1, B:34:0x00cc, B:59:0x015c, B:63:0x018d, B:70:0x01a5, B:72:0x01c1, B:74:0x01c7, B:75:0x01d7, B:77:0x0202, B:83:0x020c, B:85:0x0210, B:87:0x0224, B:112:0x02c2, B:114:0x02d9, B:116:0x02e4, B:119:0x02eb, B:121:0x02f1, B:123:0x02fc, B:127:0x0306, B:129:0x030c, B:131:0x0317, B:133:0x031d), top: B:19:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x031d A[Catch: all -> 0x0469, TRY_LEAVE, TryCatch #2 {all -> 0x0469, blocks: (B:28:0x00a7, B:30:0x00af, B:32:0x00be, B:33:0x00c1, B:34:0x00cc, B:59:0x015c, B:63:0x018d, B:70:0x01a5, B:72:0x01c1, B:74:0x01c7, B:75:0x01d7, B:77:0x0202, B:83:0x020c, B:85:0x0210, B:87:0x0224, B:112:0x02c2, B:114:0x02d9, B:116:0x02e4, B:119:0x02eb, B:121:0x02f1, B:123:0x02fc, B:127:0x0306, B:129:0x030c, B:131:0x0317, B:133:0x031d), top: B:19:0x007a }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void workEvent(java.lang.Object r11, int r12) {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }
}
