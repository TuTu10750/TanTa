package com.uc.crashsdk.a;

import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.framework.UMModuleRegister;
import defpackage.jr4;

/* loaded from: /tmp/classes2.dex */
public class d {
    static final /* synthetic */ boolean a = true;
    private static boolean b = true;
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g;
    private static String i;
    private static final Object c = new Object();
    private static final Object h = new Object();

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.H() ? 900000L : 90000L);
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (a) {
                return;
            }
            jr4.a();
            return;
        }
        synchronized (c) {
            try {
                g = null;
                a(!com.uc.crashsdk.b.F());
                if (g.b(g)) {
                    h.a(g);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(boolean r10) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (h) {
            i = null;
        }
    }

    public static byte[] d() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean e() {
        if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.L()) {
            a(true);
            return b;
        }
        return true;
    }

    private static String f() {
        String a2;
        String str = i;
        if (!g.a(str)) {
            return str;
        }
        synchronized (h) {
            try {
                a2 = g.a(com.uc.crashsdk.b.j(), (com.uc.crashsdk.g.S() ? "https://errlogos.umeng.com" : "https://errlog.umeng.com").concat("/api/crashsdk/validate"), true);
                i = a2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    private static String g() {
        byte[] bArr;
        String f2;
        byte[] a2;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.a);
        a(sb, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb, cl.n, com.uc.crashsdk.a.a());
        a(sb, "cver", "3.3.2.2");
        a(sb, "ctag", "umeng");
        a(sb, "inter", com.uc.crashsdk.g.S() ? "true" : "false");
        a(sb, bv.x, "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.j());
        c.a(bArr3, 4, c.a());
        c.a(bArr3, 8, d());
        c.a(bArr3, 12, com.uc.crashsdk.a.f());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (f2 = f()) == null || (a2 = c.a(f2, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a2, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }
}
