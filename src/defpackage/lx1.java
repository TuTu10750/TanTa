package defpackage;

import android.util.Log;

/* loaded from: /tmp/classes2.dex */
public abstract class lx1 {
    public static boolean a;

    public static void a(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void b(String str) {
        c("log--->", str);
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void e(boolean z) {
        a = z;
    }
}
