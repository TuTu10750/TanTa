package com.umeng.analytics.pro;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.cj;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cx;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class cn implements cm.a {
    private static final String a = "newver";
    private static final String j = ".um_ncc_init_beacon_987654321";
    private static final String k = ".um_ncc_local_config";
    private volatile String b = "";
    private static Map<String, ArrayList<co>> c = new HashMap();
    private static int d = 0;
    private static ArrayList<ArrayList<co>> e = new ArrayList<>();
    private static volatile int f = -1;
    private static volatile boolean g = false;
    private static volatile boolean h = false;
    private static final Object i = new Object();
    private static volatile JSONObject l = null;
    private static final Object m = new Object();

    /* loaded from: /tmp/classes2.dex */
    public class a {
        public String a;
        public int b;
        public int c;

        public a(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        private static final cn a = new cn();

        private b() {
        }
    }

    public static cn a() {
        return b.a;
    }

    private co a(cx cxVar, cx.b bVar) {
        int i2;
        long j2;
        if (bVar == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new cq(bVar.d()));
            if (bVar.a() != null && !bVar.a().isEmpty()) {
                arrayList.add(new cw(new HashSet(bVar.a())));
            }
            if (bVar.c() != null && !bVar.c().isEmpty()) {
                arrayList.add(new cr(new HashSet(bVar.c())));
            }
            if (bVar.e() != null && bVar.f() != null) {
                arrayList.add(new cv(bVar.e(), bVar.f()));
            }
            String a2 = cxVar.e().a();
            if (!TextUtils.isEmpty(a2)) {
                try {
                    i2 = Integer.parseInt(a2);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                arrayList.add(new ct(i2));
            }
            if (bVar.g() != null) {
                try {
                    j2 = Long.parseLong(bVar.g());
                } catch (NumberFormatException unused2) {
                    j2 = 0;
                }
                arrayList.add(new cs(bVar.h(), j2));
            }
            return new co(bVar.h(), arrayList);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: buildAction error: " + th.getMessage());
            return null;
        }
    }

    private JSONObject a(String str, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev1");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put(com.umeng.ccg.a.G, i2);
            jSONObject.put("result", i3);
            JSONObject a2 = ap.a(UMGlobalContext.getAppContext(), new JSONArray("[\"uapp\"]"), "uapp");
            a2.put("wkMode", f);
            JSONObject a3 = ap.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a3 != null) {
                return ap.a(a2, a3);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(Context context, long j2) {
        if (j2 > 0) {
            try {
                SharedPreferences a2 = cz.a(context);
                if (a2 != null) {
                    SharedPreferences.Editor edit = a2.edit();
                    edit.putLong("config_ts", j2);
                    edit.apply();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: updateVersion : ts = " + j2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Context context, String str, JSONObject jSONObject) {
        Object a2;
        try {
            final String optString = jSONObject.has("actionName") ? jSONObject.optString("actionName") : "";
            if (TextUtils.isEmpty(optString)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>[ncc]: target is empty, ignore umc_cfg process");
                return;
            }
            final int optInt = jSONObject.has(com.umeng.ccg.a.G) ? jSONObject.optInt(com.umeng.ccg.a.G) : 0;
            if (optInt != 0) {
                JSONObject a3 = a(optString, optInt, 0);
                if (a3 != null) {
                    aw.a(new ar(ar.b, a3), 0L, TimeUnit.SECONDS);
                    return;
                }
                return;
            }
            JSONObject d2 = d();
            if (d2 == null || (a2 = ax.a(d2.optString(bv.aF), d2.optString(bv.aB), new Class[]{String.class}, context, new Object[]{d2.optString(bv.av)})) == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("ss", Base64.encodeToString(ay.a(DeviceConfig.getPackageName(context).getBytes(), UMUtils.genSin()), 0).trim());
            ax.a(d2.optString("m"), d2.optString("x"), new Class[]{String.class, String.class, String[].class, Bundle.class, Activity.class, ax.a(d2.optString(bv.aD)), Handler.class}, a2, new Object[]{optString, "u20@24m_PS_DK_ANA", null, bundle, null, new AccountManagerCallback<Bundle>() { // from class: com.umeng.analytics.pro.cn.3
                @Override // android.accounts.AccountManagerCallback
                public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                    int i2 = 1;
                    try {
                        accountManagerFuture.getResult();
                        i2 = 0;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [ncc]: umc_cfg p s!");
                    } catch (Throwable unused) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [ncc]: umc_cfg p f!");
                    }
                    cm.a(UMGlobalContext.getAppContext(), 305, cn.a(), new a(optString, optInt, i2));
                }
            }, null});
        } catch (Throwable unused) {
        }
    }

    private synchronized void a(Context context, JSONObject jSONObject, String str) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: saveConfigFile: context is null!");
            return;
        }
        if (jSONObject == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: saveConfigFile: config is null!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: saveConfigFile: version is empty!");
            return;
        }
        long parseLong = Long.parseLong(str);
        byte[] a2 = ay.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
        if (a2 != null && a2.length > 1) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), k));
            try {
                fileOutputStream.write(a2);
                fileOutputStream.flush();
                at.a(fileOutputStream);
                a(context, parseLong);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: saveConfigFile success.");
            } catch (Throwable th) {
                at.a(fileOutputStream);
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033 A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:50:0x0010, B:52:0x0018, B:54:0x001c, B:8:0x0025, B:10:0x0033, B:12:0x003f, B:14:0x0049, B:16:0x004d, B:17:0x004f, B:20:0x00ad, B:22:0x00b1, B:23:0x00b3, B:32:0x00ba, B:25:0x00b4, B:26:0x00b6), top: B:49:0x0010, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad A[Catch: all -> 0x0021, TryCatch #1 {all -> 0x0021, blocks: (B:50:0x0010, B:52:0x0018, B:54:0x001c, B:8:0x0025, B:10:0x0033, B:12:0x003f, B:14:0x0049, B:16:0x004d, B:17:0x004f, B:20:0x00ad, B:22:0x00b1, B:23:0x00b3, B:32:0x00ba, B:25:0x00b4, B:26:0x00b6), top: B:49:0x0010, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.umeng.analytics.pro.cx.a r9, java.util.ArrayList<com.umeng.analytics.pro.co> r10) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.cn.a(com.umeng.analytics.pro.cx$a, java.util.ArrayList):void");
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: checkFetchCondition: online version = " + str);
        try {
            long parseLong = Long.parseLong(str);
            if (!TextUtils.isEmpty(this.b) && this.b.equalsIgnoreCase(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: local cache version == online version, ignore.");
                return;
            }
            SharedPreferences a2 = cz.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                long j2 = a2.getLong("config_ts", 0L);
                if (j2 == parseLong) {
                    this.b = str;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: local version == online version, ignore.");
                    return;
                }
                this.b = str;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: local version != online version, send FETCH_NEW_CONFIG msg. local version = " + j2);
                cm.a(UMGlobalContext.getAppContext(), 101, a(), str, 5000L);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(ArrayList<co> arrayList, int i2, int i3) {
        e.clear();
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * i2;
            int min = Math.min(i5 + i2, arrayList.size());
            ArrayList<co> arrayList2 = new ArrayList<>();
            while (i5 < min) {
                arrayList2.add(arrayList.get(i5));
                i5++;
            }
            e.add(arrayList2);
        }
    }

    private boolean a(cx cxVar) {
        if (cxVar.a() != 200 || cxVar.e() == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: invalid config file.");
            return false;
        }
        if (TextUtils.isEmpty(cxVar.c())) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: invalid config version.");
            return false;
        }
        cx.a e2 = cxVar.e();
        if (e2 == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: config data is null.");
            return false;
        }
        List<cx.b> e3 = e2.e();
        if (e3 != null && !e3.isEmpty()) {
            return true;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: targets is empty");
        return false;
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(cl.g)) {
            return false;
        }
        try {
            if (200 == jSONObject.optInt(cl.g) && jSONObject.has(cl.i)) {
                return jSONObject.has(cl.b);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(String str) {
        long j2;
        List<cx.b> list = null;
        try {
        } catch (Exception unused) {
        }
        synchronized (m) {
            try {
                cx a2 = cx.a(l);
                if (!a(a2)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: updateActionExecTime: parse ConfigData error. abort update.");
                    return;
                }
                list = a2.e().e();
                if (list != null) {
                    for (cx.b bVar : list) {
                        if (str.equals(bVar.h())) {
                            if (bVar.g() != null) {
                                try {
                                    j2 = Long.parseLong(bVar.g());
                                } catch (NumberFormatException unused2) {
                                    j2 = 0;
                                }
                                new cs(str, j2).d();
                                return;
                            }
                            return;
                        }
                    }
                }
            } finally {
            }
        }
    }

    private void c(Context context) {
        try {
            if (new File(context.getFilesDir(), j).exists()) {
                f = 0;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Beacon file exists, work mode set to init dispatch");
            } else {
                f = 1;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Beacon file not exists, work mode set to foreground dispatch (default)");
            }
        } catch (Throwable th) {
            f = 1;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: Error checking beacon file, work mode set to foreground dispatch (default): " + th.getMessage());
        }
    }

    private JSONObject d() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ay.b(UMUtils.genUmc(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ay.a(byteArray, UMUtils.genSin());
            String str = new String(byteArray);
            byteArrayOutputStream.reset();
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void d(Context context) {
        try {
            File file = new File(context.getFilesDir(), j);
            if (file.exists()) {
                return;
            }
            file.createNewFile();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Beacon file created");
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: Error creating beacon file: " + th.getMessage());
        }
    }

    private void e(Context context) {
        try {
            File file = new File(context.getFilesDir(), j);
            if (file.exists()) {
                file.delete();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Beacon file deleted");
            }
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: Error deleting beacon file: " + th.getMessage());
        }
    }

    private void f(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(a, new UMImprintChangeCallback() { // from class: com.umeng.analytics.pro.cn.4
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                cm.a(UMGlobalContext.getAppContext(), 107, cn.a(), str2);
            }
        });
    }

    public JSONObject a(String str, String str2, String str3, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", "$$_umc_ev2");
            jSONObject.put("ts", j2);
            jSONObject.put("tt", str);
            jSONObject.put("flag", str2);
            jSONObject.put("ss", str3);
            if (z) {
                jSONObject.put("cd", 1);
            } else {
                jSONObject.put("cd", 0);
            }
            JSONObject a2 = ap.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
            JSONObject a3 = ap.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a2 == null || a3 == null) {
                return null;
            }
            return ap.a(a2, a3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(final Context context) {
        c(context);
        ck.a(new cg() { // from class: com.umeng.analytics.pro.cn.1
            @Override // com.umeng.analytics.pro.cg
            public void a(JSONObject jSONObject) {
                if (jSONObject == null) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: onConfigReady: empty config!");
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: onConfigReady:" + jSONObject);
                cm.a(context, 201, cn.a(), jSONObject, 3000L);
            }
        });
        if (f == 1) {
            ck.a(new cj.a() { // from class: com.umeng.analytics.pro.cn.2
                @Override // com.umeng.analytics.pro.cj.a
                public void a() {
                    cn.this.b();
                }

                @Override // com.umeng.analytics.pro.cj.a
                public void b() {
                    cn.this.c();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.umeng.analytics.pro.cn] */
    /* JADX WARN: Type inference failed for: r0v17, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v18, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    @Override // com.umeng.analytics.pro.cm.a
    public void a(Object obj, int i2) {
        String str;
        JSONObject optJSONObject;
        int i3;
        Context appContext;
        Object obj2 = this;
        try {
            if (i2 == 305) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv GET_UMC_PROCESS_RESULT msg.");
                a aVar = (a) obj;
                JSONObject a2 = obj2.a(aVar.a, aVar.b, aVar.c);
                if (a2 != null) {
                    aw.a(new ar(ar.b, a2), 0L, TimeUnit.SECONDS);
                    return;
                }
                return;
            }
            JSONObject jSONObject = null;
            switch (i2) {
                case 101:
                    if (obj == null || !(obj instanceof String)) {
                        return;
                    }
                    JSONObject b2 = ap.b(UMGlobalContext.getAppContext(), (String) obj);
                    if (b2 != null) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc] send request. body: " + b2);
                        aw.a(new cy(cy.a, b2), 0L, TimeUnit.SECONDS);
                        return;
                    }
                    return;
                case 102:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv FETCH_RESPONSE msg.");
                    if (obj == null || !(obj instanceof JSONObject)) {
                        cm.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        return;
                    }
                    JSONObject optJSONObject2 = ((JSONObject) obj).optJSONObject("config");
                    if (obj2.a(optJSONObject2)) {
                        cm.a(UMGlobalContext.getAppContext(), 103, a(), optJSONObject2);
                        return;
                    } else {
                        cm.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        return;
                    }
                case 103:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv FETCH_SUCCESS msg.");
                    Context appContext2 = UMGlobalContext.getAppContext();
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj;
                    String optString = jSONObject2.optString(cl.n);
                    if (TextUtils.isEmpty(optString)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: version field missing.");
                        return;
                    } else {
                        obj2.a(appContext2, jSONObject2, optString);
                        return;
                    }
                case 104:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv FETCH_FAILED msg.");
                    return;
                case 105:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv LOAD_CONFIG msg.");
                    try {
                        try {
                            jSONObject = obj2.b(UMGlobalContext.getAppContext());
                            int i4 = (jSONObject == null || (obj2 = obj2.a(jSONObject)) == 0) ? 0 : 1;
                            obj2 = new JSONObject();
                            obj2.put("result", i4);
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        obj2 = new JSONObject();
                        obj2.put("result", (Object) 0);
                        if (jSONObject != null) {
                            str = "config";
                            obj2 = obj2;
                        }
                    }
                    if (jSONObject != null) {
                        str = "config";
                        obj2 = obj2;
                        obj2.put(str, jSONObject);
                    }
                    cm.a(UMGlobalContext.getAppContext(), 106, a(), obj2);
                    return;
                case 106:
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject3 = (JSONObject) obj;
                    if (jSONObject3.has("result") && (jSONObject3.optInt("result") & 1) != 0) {
                        if (!jSONObject3.has("config") || (optJSONObject = jSONObject3.optJSONObject("config")) == null) {
                            ck.b((JSONObject) null);
                        } else {
                            ck.b(optJSONObject);
                        }
                    }
                    obj2.f(UMGlobalContext.getAppContext());
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), a, "");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: manual check imprint newver value: " + imprintProperty);
                    obj2.a(imprintProperty);
                    return;
                case 107:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv IMPRINT_NEWVER_CHANGED msg.");
                    if (obj != null) {
                        try {
                            if (obj instanceof String) {
                                String str2 = (String) obj;
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: newver value changed newver : ".concat(str2));
                                obj2.a(str2);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "[imprint] process error " + th.getMessage());
                            return;
                        }
                    }
                    return;
                default:
                    switch (i2) {
                        case 201:
                            try {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv PARSE_CONFIG msg.");
                                if (obj == null || !(obj instanceof JSONObject)) {
                                    return;
                                }
                                JSONObject jSONObject4 = (JSONObject) obj;
                                if ((jSONObject4.has(cl.i) ? jSONObject4.optInt(cl.i) : 1) == 1) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: status is 1, don't dispatch.");
                                    return;
                                }
                                if (!jSONObject4.has(cl.b)) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: no data field, don't dispatch.");
                                    return;
                                }
                                JSONObject optJSONObject3 = jSONObject4.optJSONObject(cl.b);
                                if (optJSONObject3 == null || optJSONObject3.length() <= 0) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: empty config value, don't dispatch.");
                                    return;
                                }
                                if (optJSONObject3.has(cl.j)) {
                                    try {
                                        if (Integer.parseInt(optJSONObject3.optString(cl.j, SdkVersion.MINI_VERSION)) == 0) {
                                            Context appContext3 = UMGlobalContext.getAppContext();
                                            if (appContext3 != null) {
                                                obj2.d(appContext3);
                                            }
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Init dispatch mode, beacon file will be created");
                                        } else {
                                            Context appContext4 = UMGlobalContext.getAppContext();
                                            if (appContext4 != null) {
                                                obj2.e(appContext4);
                                            }
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Foreground dispatch mode, beacon file will be deleted");
                                        }
                                    } catch (NumberFormatException unused3) {
                                        Context appContext5 = UMGlobalContext.getAppContext();
                                        if (appContext5 != null) {
                                            obj2.e(appContext5);
                                        }
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Foreground dispatch mode (default), beacon file will be deleted");
                                    }
                                } else {
                                    Context appContext6 = UMGlobalContext.getAppContext();
                                    if (appContext6 != null) {
                                        obj2.e(appContext6);
                                    }
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Foreground dispatch mode (default), beacon file will be deleted");
                                }
                                synchronized (m) {
                                    try {
                                        l = jSONObject4;
                                        if (f == 0 && l != null) {
                                            cm.a(UMGlobalContext.getAppContext(), 202, a(), l, 2000L);
                                        }
                                        if (f == 1 && g && l != null) {
                                            synchronized (i) {
                                                if (!h && (appContext = UMGlobalContext.getAppContext()) != null) {
                                                    h = true;
                                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Supplement sending PROCESS_WHEN_TO_FRONT msg after PARSE_CONFIG");
                                                    cm.a(appContext, 203, a(), l);
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    } finally {
                                    }
                                }
                                return;
                            } catch (Throwable th3) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: PARSE_CONFIG error: " + th3.getMessage());
                                return;
                            }
                        case 202:
                            try {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv PROCESS_WHEN_INIT msg.");
                                if (!com.umeng.ccg.b.a(com.umeng.ccg.a.i)) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Local switch of [umc_cfg] is off, ignore this command.");
                                    return;
                                }
                                if (f != 0) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Work mode is not init dispatch, ignore PROCESS_WHEN_INIT");
                                    return;
                                }
                                int b3 = ck.b();
                                if (b3 > 0) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Ignore act up action because act up flag value is: " + b3);
                                    return;
                                }
                                if (obj instanceof JSONObject) {
                                    cx a3 = cx.a((JSONObject) obj);
                                    if (!obj2.a(a3)) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: invalid config data, just stop dispatch.");
                                        return;
                                    }
                                    if (a3.d() == 1) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: config status is 1, not allow dispatch when INIT");
                                        return;
                                    }
                                    cx.a e2 = a3.e();
                                    if (e2 == null) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: config data is null when INIT, just stop dispatch.");
                                        return;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    Iterator<cx.b> it = a3.e().e().iterator();
                                    while (it.hasNext()) {
                                        co a4 = obj2.a(a3, it.next());
                                        if (a4 != null) {
                                            arrayList.add(a4);
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        return;
                                    }
                                    obj2.a(e2, arrayList);
                                    return;
                                }
                                return;
                            } catch (Throwable th4) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: PROCESS_WHEN_INIT error: " + th4.getMessage());
                                return;
                            }
                        case 203:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv PROCESS_WHEN_TO_FRONT msg.");
                            if (!com.umeng.ccg.b.a(com.umeng.ccg.a.i)) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Local switch of [umc_cfg] is off, ignore this command.");
                                return;
                            }
                            int b4 = ck.b();
                            if (b4 > 0) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Ignore act up action because act up flag value is: " + b4);
                                return;
                            }
                            if (f != 1) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Work mode is not foreground dispatch, ignore PROCESS_WHEN_TO_FRONT");
                                synchronized (i) {
                                    h = false;
                                }
                                return;
                            }
                            try {
                                if (obj instanceof JSONObject) {
                                    cx a5 = cx.a((JSONObject) obj);
                                    if (!obj2.a(a5)) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: invalid config data, just stop dispatch.");
                                        return;
                                    }
                                    if (a5.d() == 1) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: config status is 1, not allow dispatch when foreground");
                                        return;
                                    }
                                    cx.a e3 = a5.e();
                                    if (e3 == null) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: config data is null when to foreground");
                                        return;
                                    }
                                    List<cx.b> e4 = e3.e();
                                    if (e4 != null && !e4.isEmpty()) {
                                        ArrayList arrayList2 = new ArrayList();
                                        Iterator<cx.b> it2 = e4.iterator();
                                        while (it2.hasNext()) {
                                            co a6 = obj2.a(a5, it2.next());
                                            if (a6 != null) {
                                                arrayList2.add(a6);
                                            }
                                        }
                                        if (arrayList2.isEmpty()) {
                                            return;
                                        }
                                        obj2.a(e3, arrayList2);
                                        return;
                                    }
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: targets is empty when to foreground");
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: PROCESS_WHEN_TO_FRONT error: " + th5.getMessage());
                                return;
                            }
                        case 204:
                            try {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: recv PROCESS_ONE_TASK msg.");
                                if (obj instanceof JSONObject) {
                                    JSONObject jSONObject5 = (JSONObject) obj;
                                    int optInt = jSONObject5.optInt("currentIndex", 0);
                                    JSONObject optJSONObject4 = jSONObject5.optJSONObject("batchParams");
                                    if (optJSONObject4 == null) {
                                        UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: batchParams is null");
                                        return;
                                    }
                                    String optString2 = optJSONObject4.optString("batchId");
                                    int optInt2 = optJSONObject4.optInt("appsPerBatch", 1);
                                    int optInt3 = optJSONObject4.optInt(cl.l, 20);
                                    int optInt4 = optJSONObject4.optInt("processedCount", 0);
                                    int optInt5 = optJSONObject4.optInt("currentBatchIndex", 0);
                                    int optInt6 = optJSONObject4.optInt("totalBatches", 1);
                                    ArrayList<co> arrayList3 = c.get(optString2);
                                    if (arrayList3 != null && !arrayList3.isEmpty()) {
                                        if (optInt >= arrayList3.size()) {
                                            i3 = optInt4;
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: batch processing completed for batchId: " + optString2);
                                            c.remove(optString2);
                                            int i5 = optInt5 + 1;
                                            if (i5 >= optInt6) {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: all batches processing completed");
                                                if (f == 1) {
                                                    synchronized (i) {
                                                        h = false;
                                                    }
                                                }
                                            } else if (i5 < e.size()) {
                                                ArrayList<co> arrayList4 = e.get(i5);
                                                StringBuilder sb = new StringBuilder("batch_");
                                                int i6 = d + 1;
                                                d = i6;
                                                sb.append(i6);
                                                String sb2 = sb.toString();
                                                c.put(sb2, arrayList4);
                                                JSONObject jSONObject6 = new JSONObject();
                                                jSONObject6.put("batchId", sb2);
                                                jSONObject6.put("appsPerBatch", optInt2);
                                                jSONObject6.put(cl.l, optInt3);
                                                jSONObject6.put("processedCount", 0);
                                                jSONObject6.put("currentBatchIndex", i5);
                                                jSONObject6.put("totalBatches", optInt6);
                                                JSONObject jSONObject7 = new JSONObject();
                                                jSONObject7.put("batchParams", jSONObject6);
                                                jSONObject7.put("currentIndex", 0);
                                                cm.a(UMGlobalContext.getAppContext(), 204, a(), jSONObject7, optInt3 * 1000);
                                            }
                                        } else {
                                            i3 = optInt4;
                                        }
                                        co coVar = arrayList3.get(optInt);
                                        JSONObject b5 = coVar.b();
                                        optJSONObject4.put("processedCount", i3 + 1);
                                        if (b5 != null) {
                                            String optString3 = b5.optString("actionName");
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: processing task: " + optString3);
                                            obj2.a(UMGlobalContext.getAppContext(), optString3, b5);
                                            obj2.b(optString3);
                                        } else {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: action " + coVar.a() + " not allowed to execute, skip");
                                        }
                                        int i7 = optInt + 1;
                                        if (i7 < arrayList3.size()) {
                                            JSONObject jSONObject8 = new JSONObject();
                                            jSONObject8.put("batchParams", optJSONObject4);
                                            jSONObject8.put("currentIndex", i7);
                                            cm.a(UMGlobalContext.getAppContext(), 204, a(), jSONObject8);
                                            return;
                                        }
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: batch processing completed for batchId: " + optString2);
                                        c.remove(optString2);
                                        int i8 = optInt5 + 1;
                                        if (i8 >= optInt6) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: all batches processing completed");
                                            if (f == 1) {
                                                synchronized (i) {
                                                    h = false;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        if (i8 < e.size()) {
                                            ArrayList<co> arrayList5 = e.get(i8);
                                            StringBuilder sb3 = new StringBuilder("batch_");
                                            int i9 = d + 1;
                                            d = i9;
                                            sb3.append(i9);
                                            String sb4 = sb3.toString();
                                            c.put(sb4, arrayList5);
                                            JSONObject jSONObject9 = new JSONObject();
                                            jSONObject9.put("batchId", sb4);
                                            jSONObject9.put("appsPerBatch", optInt2);
                                            jSONObject9.put(cl.l, optInt3);
                                            jSONObject9.put("processedCount", 0);
                                            jSONObject9.put("currentBatchIndex", i8);
                                            jSONObject9.put("totalBatches", optInt6);
                                            JSONObject jSONObject10 = new JSONObject();
                                            jSONObject10.put("batchParams", jSONObject9);
                                            jSONObject10.put("currentIndex", 0);
                                            cm.a(UMGlobalContext.getAppContext(), 204, a(), jSONObject10, optInt3 * 1000);
                                            return;
                                        }
                                        return;
                                    }
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: actions is null or empty for batchId: " + optString2);
                                    return;
                                }
                                return;
                            } catch (Throwable th6) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "[ncc]: PROCESS_ONE_TASK error: " + th6.getMessage());
                                if (f == 1) {
                                    synchronized (i) {
                                        h = false;
                                        return;
                                    }
                                }
                                return;
                            }
                        default:
                            return;
                    }
            }
        } catch (Throwable unused4) {
        }
    }

    public synchronized JSONObject b(Context context) {
        FileInputStream fileInputStream;
        JSONObject jSONObject = null;
        if (!new File(context.getFilesDir(), k).exists()) {
            return null;
        }
        try {
            fileInputStream = context.openFileInput(k);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(ay.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
            try {
                at.a(fileInputStream);
            } catch (Throwable unused2) {
            }
            jSONObject = jSONObject2;
        } catch (Throwable unused3) {
            at.a(fileInputStream);
            return jSONObject;
        }
        return jSONObject;
    }

    public void b() {
        g = true;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: App switched to foreground");
        if (f != 1) {
            if (f == -1) {
                f = 1;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Work mode set to foreground dispatch");
                return;
            }
            return;
        }
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext == null) {
            synchronized (i) {
                h = false;
            }
            return;
        }
        synchronized (m) {
            if (l == null) {
                synchronized (i) {
                    h = false;
                }
            }
            synchronized (i) {
                if (h) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: Foreground processing is already in progress, ignore new foreground event");
                } else {
                    h = true;
                    cm.a(appContext, 203, a(), l);
                }
            }
        }
    }

    public void c() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[ncc]: App switched to background");
    }
}
