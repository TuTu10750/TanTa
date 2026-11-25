package com.umeng.analytics.pro;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class au {
    private static String a = "";
    private static String b = "";
    private static final String c = "hw_sc.build.platform.version";
    private static final String d = "ro.build.version.emui";
    private static final String e = "ro.build.version.magic";
    private static final String f = "ro.miui.ui.version.name";
    private static final String g = "ro.build.version.opporom";
    private static final String h = "ro.vivo.os.name";
    private static final String i = "ro.vivo.os.version";
    private static final String j = "ro.build.version.oplusrom";
    private static final String k = "ro.rom.version";

    public static String a(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return a;
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return b;
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
    
        if (r5.equals("XIAOMI") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c4, code lost:
    
        if (r5.equals("REALME") != false) goto L46;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0010. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.lang.String r5) {
        /*
            java.lang.String r0 = "ro.build.version.magic"
            java.lang.String r5 = c(r5)     // Catch: java.lang.Throwable -> Ld9
            int r1 = r5.hashCode()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = "ro.build.version.emui"
            java.lang.String r3 = "EMUI"
            java.lang.String r4 = "ColorOS"
            switch(r1) {
                case -1881642058: goto Lbe;
                case -1706170181: goto La9;
                case -602397472: goto L86;
                case 2432928: goto L7d;
                case 2634924: goto L68;
                case 68924490: goto L42;
                case 77852109: goto L39;
                case 2141820391: goto L15;
                default: goto L13;
            }
        L13:
            goto Ld1
        L15:
            java.lang.String r0 = "HUAWEI"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            boolean r5 = a()     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto L30
            java.lang.String r5 = "hw_sc.build.platform.version"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "HarmonyOS"
            com.umeng.analytics.pro.au.a = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L30:
            com.umeng.analytics.pro.au.a = r3     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = d(r2)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L39:
            java.lang.String r0 = "REDMI"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            goto Lb1
        L42:
            java.lang.String r1 = "HONOR"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            java.lang.String r5 = d(r0)     // Catch: java.lang.Throwable -> Ld9
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Ld9
            if (r5 != 0) goto L5f
            java.lang.String r5 = "MagicUI"
            com.umeng.analytics.pro.au.a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = d(r0)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L5f:
            com.umeng.analytics.pro.au.a = r3     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = d(r2)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L68:
            java.lang.String r0 = "VIVO"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            java.lang.String r5 = "Funtouch"
            com.umeng.analytics.pro.au.a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.vivo.os.version"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        L7d:
            java.lang.String r0 = "OPPO"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            goto Lc6
        L86:
            java.lang.String r0 = "ONEPLUS"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
            java.lang.String r5 = "HydrogenOS"
            com.umeng.analytics.pro.au.a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.rom.version"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Ld9
            if (r0 == 0) goto La6
            com.umeng.analytics.pro.au.a = r4     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.build.version.oplusrom"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
        La6:
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        La9:
            java.lang.String r0 = "XIAOMI"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
        Lb1:
            java.lang.String r5 = "MIUI"
            com.umeng.analytics.pro.au.a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.miui.ui.version.name"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        Lbe:
            java.lang.String r0 = "REALME"
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> Ld9
            if (r5 == 0) goto Ld1
        Lc6:
            com.umeng.analytics.pro.au.a = r4     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = "ro.build.version.opporom"
            java.lang.String r5 = d(r5)     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
            return
        Ld1:
            java.lang.String r5 = "Android"
            com.umeng.analytics.pro.au.a = r5     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch: java.lang.Throwable -> Ld9
            com.umeng.analytics.pro.au.b = r5     // Catch: java.lang.Throwable -> Ld9
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.au.e(java.lang.String):void");
    }
}
