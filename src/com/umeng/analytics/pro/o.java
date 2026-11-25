package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.h;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class o {
    private static byte[] E;
    private static byte[] F;
    private static byte[] G;
    private static byte[] H;
    private static final ComponentCallbacks2 I;
    public static String a;
    private ArrayList<b> B;
    private ArrayList<c> D;
    boolean b;
    boolean c;
    com.umeng.analytics.vshelper.a f;
    Application.ActivityLifecycleCallbacks g;
    private final Map<String, Long> h;
    private boolean u;
    private int v;
    private int w;
    private static JSONArray i = new JSONArray();
    private static Object j = new Object();
    private static Application k = null;
    private static volatile boolean l = true;
    private static volatile boolean m = false;
    private static volatile String n = "";
    private static volatile long o = 0;
    private static volatile boolean p = true;
    private static volatile String q = "";
    private static volatile long r = 0;
    private static Object s = new Object();
    private static boolean t = false;
    static String d = null;
    static int e = -1;
    private static boolean x = true;
    private static Object y = new Object();
    private static cf z = new com.umeng.analytics.vshelper.b();
    private static Object A = new Object();
    private static Object C = new Object();

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final o a = new o();

        private a() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b {
        private String b;
        private long c;
        private String d;

        @Deprecated
        public b(String str, long j) {
            this.b = str;
            this.c = j;
            this.d = null;
        }

        public b(String str, long j, String str2) {
            this.b = str;
            this.c = j;
            this.d = str2;
        }

        public String a() {
            return this.b;
        }

        public void a(long j) {
            this.c = j;
        }

        public void a(String str) {
            this.b = str;
        }

        public long b() {
            return this.c;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.d;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c {
        private String b;
        private String c;
        private boolean d;
        private long e;
        private String f;
        private String g;

        @Deprecated
        public c(String str, String str2, boolean z, long j, String str3) {
            this.b = str;
            this.c = str2;
            this.d = z;
            this.e = j;
            this.f = str3;
            this.g = null;
        }

        public c(String str, String str2, boolean z, long j, String str3, String str4) {
            this.b = str;
            this.c = str2;
            this.d = z;
            this.e = j;
            this.f = str3;
            this.g = str4;
        }

        public String a() {
            return this.b;
        }

        public void a(long j) {
            this.e = j;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(boolean z) {
            this.d = z;
        }

        public String b() {
            return this.c;
        }

        public void b(String str) {
            this.c = str;
        }

        public void c(String str) {
            this.f = str;
        }

        public boolean c() {
            return this.d;
        }

        public long d() {
            return this.e;
        }

        public void d(String str) {
            this.g = str;
        }

        public String e() {
            return this.f;
        }

        public String f() {
            return this.g;
        }
    }

    static {
        byte[] bArr = {95, 101, 90, 111, 109, 100, 90, 40, 90, 100, 110, 90, 60, 90, 112, 100, 110, 105, 110, 110};
        E = bArr;
        byte[] bArr2 = {100, 75, 90, 70, 82, 110, 105, 90, 82};
        F = bArr2;
        byte[] bArr3 = {90, 110, 75, 99, 97, 110, 110, 99, 99, 110, 100, 109, 99, 109, 99};
        G = bArr3;
        byte[] bArr4 = {100, 64, 100, 110, 112, 99, 112, 100, 98, 110, 110, 97, 112, 100, 99, 99};
        H = bArr4;
        byte b2 = (byte) (bArr[0] + 2);
        bArr[0] = b2;
        bArr[1] = (byte) (b2 + ek.k);
        byte b3 = (byte) (bArr[2] + 10);
        bArr[2] = b3;
        bArr[3] = (byte) (bArr[3] + 3);
        byte b4 = (byte) (bArr[4] + 2);
        bArr[4] = b4;
        bArr[5] = (byte) (b3 + 5);
        byte b5 = (byte) (bArr[6] + 10);
        bArr[6] = b5;
        byte b6 = (byte) (bArr[7] + 6);
        bArr[7] = b6;
        bArr[8] = b2;
        bArr[9] = (byte) (b4 + 1);
        byte b7 = (byte) (bArr[10] + 2);
        bArr[10] = b7;
        bArr[11] = b6;
        byte b8 = (byte) (bArr[12] + 5);
        bArr[12] = b8;
        bArr[13] = (byte) (b2 + 2);
        byte b9 = (byte) (b7 + 4);
        bArr[14] = b9;
        byte b10 = (byte) (bArr[15] + 5);
        bArr[15] = b10;
        byte b11 = (byte) (bArr[16] + 8);
        bArr[16] = b11;
        bArr[17] = b10;
        bArr[18] = b9;
        byte b12 = (byte) (b11 + 3);
        bArr[19] = b12;
        byte b13 = (byte) (bArr2[0] + 9);
        bArr2[0] = b13;
        bArr2[1] = (byte) (bArr2[1] + 7);
        byte b14 = (byte) (b5 + 1);
        bArr2[2] = b14;
        bArr2[3] = (byte) (b14 + 1);
        bArr2[4] = b14;
        byte b15 = (byte) (bArr2[5] + 4);
        bArr2[5] = b15;
        byte b16 = (byte) (b13 + 5);
        bArr2[6] = b16;
        bArr2[7] = (byte) (bArr2[7] + 11);
        bArr2[8] = b16;
        bArr3[0] = (byte) (bArr3[0] + 9);
        bArr3[1] = (byte) (bArr[1] + 7);
        bArr3[2] = bArr[3];
        bArr3[3] = (byte) (bArr[1] + 4);
        bArr3[4] = bArr2[2];
        bArr3[6] = (byte) (bArr3[6] + 6);
        bArr3[7] = b8;
        bArr3[9] = (byte) (bArr3[9] + 6);
        bArr3[10] = (byte) (bArr3[10] + 5);
        bArr3[11] = b11;
        bArr3[12] = b10;
        bArr3[13] = b9;
        bArr3[14] = b12;
        bArr4[0] = (byte) (bArr4[0] + 9);
        bArr4[1] = (byte) (bArr4[1] + 9);
        byte b17 = bArr[1];
        bArr4[2] = b17;
        bArr4[3] = (byte) (bArr[3] + 1);
        bArr4[4] = b9;
        bArr4[5] = b15;
        byte b18 = bArr2[0];
        bArr4[6] = (byte) (b18 + 8);
        bArr4[7] = b18;
        bArr4[8] = (byte) (bArr4[8] + 3);
        bArr4[10] = (byte) (bArr4[10] + 6);
        bArr4[12] = b9;
        bArr4[13] = bArr3[12];
        bArr4[14] = (byte) (bArr3[5] + 1);
        bArr4[15] = b17;
        I = new ComponentCallbacks2() { // from class: com.umeng.analytics.pro.o.2
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i2) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "onTrimMemory: " + i2);
                if (i2 == 20) {
                    o.y();
                } else if (i2 == 40) {
                    o.y();
                }
            }
        };
    }

    private o() {
        this.h = new HashMap();
        this.u = false;
        this.b = false;
        this.c = false;
        this.v = 0;
        this.w = 0;
        this.B = new ArrayList<>();
        this.D = new ArrayList<>();
        this.f = PageNameMonitor.getInstance();
        this.g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.o.3
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                o.z.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (o.y) {
                        try {
                            if (o.x) {
                                return;
                            }
                        } finally {
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        com.umeng.analytics.b.a().i();
                    }
                } else {
                    o.this.d(activity);
                    com.umeng.analytics.b.a().i();
                    o.this.b = false;
                    o.z.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (o.y) {
                        try {
                            if (o.x) {
                                boolean unused = o.x = false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    o.this.b(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    o.this.b(activity);
                }
                o.z.c(activity);
                o.x();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (o.this.v <= 0) {
                        if (o.d == null) {
                            o.d = UUID.randomUUID().toString();
                        }
                        if (o.e == -1) {
                            o.e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (o.e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            o.e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, m.ar);
                            }
                        } else if (o.e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", o.d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    int i2 = o.this.w;
                    o oVar = o.this;
                    if (i2 < 0) {
                        o.f(oVar);
                    } else {
                        o.g(oVar);
                    }
                }
                if (!o.l) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: local switch is off!");
                    return;
                }
                if (!o.m) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: cloud switch is off!");
                    return;
                }
                String a3 = o.this.a(activity);
                if (a3 == null || a3.isEmpty()) {
                    return;
                }
                String packageName = DeviceConfig.getPackageName(UMGlobalContext.getAppContext());
                if (packageName.isEmpty() || packageName.equalsIgnoreCase(a3)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PI: internal path switch, or pkg is null. ignore it.");
                    return;
                }
                long unused = o.o = System.currentTimeMillis();
                String unused2 = o.n = a3;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>PI: p: " + a3 + "; ts: " + o.o);
                String a4 = o.this.a(activity, a3);
                synchronized (o.A) {
                    o.this.B.add(new b(o.n, o.o, a4));
                    String unused3 = o.n = "";
                    long unused4 = o.o = 0L;
                }
                if (UMConfigure.getInitStatus()) {
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), com.umeng.ccg.c.u, com.umeng.ccg.d.a(), null, 0L);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                UMLog uMLog = UMConfigure.umDebugLog;
                MobclickAgent.PageMode pageMode = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    boolean isChangingConfigurations = activity.isChangingConfigurations();
                    o oVar = o.this;
                    if (isChangingConfigurations) {
                        o.b(oVar);
                        return;
                    }
                    o.c(oVar);
                    if (o.this.v <= 0) {
                        if (o.e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = o.e;
                        if (i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", o.d);
                            hashMap.put("reason", "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (o.d != null) {
                                o.d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            try {
                if (k != null) {
                    z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            try {
                if (k == null && context != null) {
                    if (context instanceof Activity) {
                        k = ((Activity) context).getApplication();
                    } else if (context instanceof Application) {
                        k = (Application) context;
                    }
                    k.registerComponentCallbacks(I);
                }
                try {
                    if (new File(context.getFilesDir().getAbsolutePath() + File.separator + bz.n).exists()) {
                        m = true;
                    }
                } catch (Throwable unused) {
                }
                oVar = a.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Activity activity) {
        try {
            Field declaredField = Class.forName(new String(E)).getDeclaredField(new String(F));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "getPi error.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Activity activity, String str) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                return null;
            }
            Bundle extras = intent.getExtras();
            Uri data = intent.getData();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("source_package", str);
            jSONObject.put("target_activity", activity.getClass().getName());
            if (data != null) {
                jSONObject.put("dp_uri", data.toString());
            } else {
                jSONObject.put("dp_uri", JSONObject.NULL);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (extras != null) {
                for (String str2 : extras.keySet()) {
                    try {
                        Object obj = extras.get(str2);
                        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double)) {
                            jSONObject2.put(str2, obj);
                        }
                    } catch (Throwable unused) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "Extract extras error for key: " + str2);
                    }
                }
            }
            jSONObject.put("extras", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Intent Extras: " + jSONObject3);
            return Base64.encodeToString(ay.a(jSONObject3.getBytes(), UMConfigure.sAppkey.getBytes()), 0);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "Extract external intent extras error: " + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(UMGlobalContext.getAppContext().getPackageManager());
            }
            String packageName = component != null ? component.getPackageName() : "";
            String className = component != null ? component.getClassName() : "";
            Bundle extras = intent.getExtras();
            Uri data = intent.getData();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("source_package", packageName);
            jSONObject.put("target_activity", className);
            if (data != null) {
                jSONObject.put("dp_uri", data.toString());
            } else {
                jSONObject.put("dp_uri", JSONObject.NULL);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    try {
                        Object obj = extras.get(str);
                        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double)) {
                            jSONObject2.put(str, obj);
                        }
                    } catch (Throwable unused) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "[PO] Extract extras error for key: " + str);
                    }
                }
            }
            jSONObject.put("extras", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[PO] Intent Extras: " + jSONObject3);
            return Base64.encodeToString(ay.a(jSONObject3.getBytes(), UMConfigure.sAppkey.getBytes()), 0);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "[PO] Extract intent extras error: " + th.getMessage());
            return null;
        }
    }

    public static void a(Context context, String str) {
        if (e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", d);
            hashMap.put("reason", str);
            if (d != null) {
                d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public static void a(boolean z2) {
        l = z2;
    }

    public static /* synthetic */ int b(o oVar) {
        int i2 = oVar.w;
        oVar.w = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (y) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f.activityResume(str);
            if (!this.b) {
                c(activity);
                synchronized (y) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            this.b = false;
            if (TextUtils.isEmpty(a)) {
                a = str;
            } else {
                if (a.equals(str)) {
                    return;
                }
                c(activity);
                synchronized (y) {
                    com.umeng.analytics.b.a().h();
                }
            }
        }
    }

    public static void b(boolean z2) {
        p = z2;
    }

    public static /* synthetic */ int c(o oVar) {
        int i2 = oVar.v;
        oVar.v = i2 - 1;
        return i2;
    }

    private void c(Activity activity) {
        a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.h) {
            this.h.put(a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (j) {
                    jSONArray = i.toString();
                    i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(h.d.a.c, new JSONArray(jSONArray));
                    l.a(context).a(x.a().c(), jSONObject, l.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean c() {
        boolean z2;
        synchronized (s) {
            z2 = t;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.h) {
                try {
                    if (a == null && activity != null) {
                        a = activity.getPackageName() + "." + activity.getLocalClassName();
                    }
                    if (TextUtils.isEmpty(a) || !this.h.containsKey(a)) {
                        j2 = 0;
                        j3 = 0;
                    } else {
                        j2 = this.h.get(a).longValue();
                        j3 = System.currentTimeMillis() - j2;
                        this.h.remove(a);
                    }
                } finally {
                }
            }
            synchronized (j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(g.v, a);
                    jSONObject.put("duration", j3);
                    jSONObject.put(g.x, j2);
                    jSONObject.put("type", 0);
                    i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static /* synthetic */ int f(o oVar) {
        int i2 = oVar.w;
        oVar.w = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int g(o oVar) {
        int i2 = oVar.v;
        oVar.v = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x() {
        synchronized (s) {
            try {
                if (!t) {
                    t = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y() {
        synchronized (s) {
            try {
                if (t) {
                    t = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void z() {
        if (this.u) {
            return;
        }
        this.u = true;
        Application application = k;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.g);
        }
    }

    public boolean a() {
        return this.u;
    }

    public void b() {
        if (p) {
            try {
                final String packageName = DeviceConfig.getPackageName(UMGlobalContext.getAppContext());
                Class<?> cls = Class.forName(new String(E).concat("Thread"));
                Object invoke = cls.getMethod(new String(G).concat("Thread"), null).invoke(null, null);
                Field declaredField = cls.getDeclaredField(new String(H));
                declaredField.setAccessible(true);
                Instrumentation instrumentation = (Instrumentation) declaredField.get(invoke);
                if (instrumentation == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "PO: attach failed.");
                } else {
                    instrumentation.addMonitor(new Instrumentation.ActivityMonitor() { // from class: com.umeng.analytics.pro.o.1
                        @Override // android.app.Instrumentation.ActivityMonitor
                        public Instrumentation.ActivityResult onStartActivity(Intent intent) {
                            if (intent == null) {
                                return super.onStartActivity(null);
                            }
                            if (TextUtils.equals(intent.getPackage(), packageName)) {
                                return super.onStartActivity(intent);
                            }
                            ComponentName component = intent.getComponent();
                            if ((component == null || !TextUtils.equals(component.getPackageName(), packageName)) && o.k != null) {
                                try {
                                    ComponentName resolveActivity = intent.resolveActivity(o.k.getPackageManager());
                                    if (resolveActivity != null && !TextUtils.equals(resolveActivity.getPackageName(), packageName)) {
                                        long unused = o.r = System.currentTimeMillis();
                                        String unused2 = o.q = resolveActivity.getPackageName();
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>PO: p: " + o.q + "; ts: " + o.r);
                                        String a2 = o.this.a(intent);
                                        synchronized (o.C) {
                                            o.this.D.add(new c(resolveActivity.getPackageName(), resolveActivity.getClassName(), o.t, o.r, Base64.encodeToString(ay.a(Log.getStackTraceString(new Throwable()).getBytes(), UMConfigure.sAppkey.getBytes()), 0), a2));
                                            String unused3 = o.q = "";
                                            long unused4 = o.r = 0L;
                                        }
                                        if (UMConfigure.getInitStatus()) {
                                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), com.umeng.ccg.c.v, com.umeng.ccg.d.a(), null, 0L);
                                        }
                                    }
                                } catch (Throwable unused5) {
                                }
                                return super.onStartActivity(intent);
                            }
                            return super.onStartActivity(intent);
                        }
                    });
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "PO: attach success.");
                }
            } catch (Throwable unused) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "PO: attach failed.");
            }
        }
    }

    public void b(Context context) {
        synchronized (y) {
            if (!x) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
                return;
            }
            x = false;
            Activity globleActivity = DeviceConfig.getGlobleActivity(context);
            if (globleActivity == null) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
            b(globleActivity);
        }
    }

    public void d() {
        this.u = false;
        Application application = k;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.g);
            k = null;
        }
    }

    public void e() {
        d((Activity) null);
        d();
    }

    public ArrayList<b> f() {
        ArrayList<b> arrayList = new ArrayList<>();
        synchronized (A) {
            int i2 = 0;
            while (i2 < this.B.size()) {
                try {
                    o oVar = this;
                    arrayList.add(new b(this.B.get(i2).a(), this.B.get(i2).b(), this.B.get(i2).c()));
                    i2++;
                    this = oVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.B.clear();
        }
        return arrayList;
    }

    public ArrayList<c> g() {
        ArrayList<c> arrayList = new ArrayList<>();
        synchronized (C) {
            int i2 = 0;
            while (i2 < this.D.size()) {
                try {
                    o oVar = this;
                    arrayList.add(new c(this.D.get(i2).a(), this.D.get(i2).b(), this.D.get(i2).c(), this.D.get(i2).d(), this.D.get(i2).e(), this.D.get(i2).f()));
                    i2++;
                    this = oVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.D.clear();
        }
        return arrayList;
    }

    public boolean h() {
        boolean z2;
        synchronized (C) {
            z2 = !this.D.isEmpty();
        }
        return z2;
    }
}
