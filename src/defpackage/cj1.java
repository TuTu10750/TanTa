package defpackage;

import android.content.Context;

/* loaded from: /tmp/classes2.dex */
public abstract class cj1 {
    public static boolean a(Context context) {
        if (aj1.p(context) == null) {
            return false;
        }
        return aj1.n();
    }

    public static String b(Context context) {
        aj1 p = aj1.p(context);
        if (p == null) {
            return null;
        }
        return p.u();
    }
}
