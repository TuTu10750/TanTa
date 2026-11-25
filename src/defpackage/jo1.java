package defpackage;

import android.content.res.Resources;

/* loaded from: /tmp/classes2.dex */
public final class jo1 {
    public static final jo1 a = new jo1();

    public static final int a(float f) {
        Resources system = Resources.getSystem();
        system.getClass();
        return (int) ((f * system.getDisplayMetrics().density) + 0.5f);
    }

    public final float b(io1 io1Var, float f, int i) {
        io1Var.getClass();
        return (f / 2.0f) + ((io1Var.f() + io1Var.l()) * i);
    }

    public final float c(float f) {
        return f / 2.0f;
    }
}
