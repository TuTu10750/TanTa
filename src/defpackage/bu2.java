package defpackage;

import android.content.Context;
import defpackage.or4;

/* loaded from: /tmp/classes2.dex */
public abstract class bu2 {
    public static void a(Context context) {
        lr4.b = or4.b.a.b(context.getApplicationContext());
        lr4.a = true;
    }

    public static boolean b() {
        if (lr4.a) {
            return lr4.b;
        }
        kc1.a("SDK Need Init First!");
        return false;
    }

    public static String c(Context context) {
        if (lr4.a) {
            return or4.b.a.a(context.getApplicationContext(), "OUID");
        }
        kc1.a("SDK Need Init First!");
        return null;
    }
}
