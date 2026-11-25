package defpackage;

import java.util.Map;
import kotlin.collections.a;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;

/* loaded from: /tmp/classes2.dex */
public final class gr1 {
    public static final gr1 a = new gr1();
    public static final zo2 b;
    public static final zo2 c;
    public static final zo2 d;
    public static final Map e;

    static {
        zo2 i = zo2.i("message");
        i.getClass();
        b = i;
        zo2 i2 = zo2.i("allowedTargets");
        i2.getClass();
        c = i2;
        zo2 i3 = zo2.i("value");
        i3.getClass();
        d = i3;
        e = a.l(g94.a(e.a.H, qu1.d), g94.a(e.a.L, qu1.f), g94.a(e.a.P, qu1.i));
    }

    public static /* synthetic */ d8 f(gr1 gr1Var, dr1 dr1Var, ey1 ey1Var, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return gr1Var.e(dr1Var, ey1Var, z);
    }

    public final d8 a(r51 r51Var, hr1 hr1Var, ey1 ey1Var) {
        dr1 a2;
        r51Var.getClass();
        hr1Var.getClass();
        ey1Var.getClass();
        if (dq1.a(r51Var, e.a.y)) {
            r51 r51Var2 = qu1.h;
            r51Var2.getClass();
            dr1 a3 = hr1Var.a(r51Var2);
            if (a3 != null || hr1Var.o()) {
                return new JavaDeprecatedAnnotationDescriptor(a3, ey1Var);
            }
        }
        r51 r51Var3 = (r51) e.get(r51Var);
        if (r51Var3 == null || (a2 = hr1Var.a(r51Var3)) == null) {
            return null;
        }
        return f(a, a2, ey1Var, false, 4, null);
    }

    public final zo2 b() {
        return b;
    }

    public final zo2 c() {
        return d;
    }

    public final zo2 d() {
        return c;
    }

    public final d8 e(dr1 dr1Var, ey1 ey1Var, boolean z) {
        dr1Var.getClass();
        ey1Var.getClass();
        q00 l = dr1Var.l();
        if (dq1.a(l, q00.m(qu1.d))) {
            return new JavaTargetAnnotationDescriptor(dr1Var, ey1Var);
        }
        if (dq1.a(l, q00.m(qu1.f))) {
            return new JavaRetentionAnnotationDescriptor(dr1Var, ey1Var);
        }
        if (dq1.a(l, q00.m(qu1.i))) {
            return new JavaAnnotationDescriptor(ey1Var, dr1Var, e.a.P);
        }
        if (dq1.a(l, q00.m(qu1.h))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(ey1Var, dr1Var, z);
    }
}
