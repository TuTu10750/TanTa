package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class vo1 {
    public static final r51 a;
    public static final q00 b;

    static {
        r51 r51Var = new r51("kotlin.jvm.JvmInline");
        a = r51Var;
        q00 m = q00.m(r51Var);
        m.getClass();
        b = m;
    }

    public static final boolean a(a aVar) {
        aVar.getClass();
        if (!(aVar instanceof q33)) {
            return false;
        }
        o33 B0 = ((q33) aVar).B0();
        B0.getClass();
        return e(B0);
    }

    public static final boolean b(ra0 ra0Var) {
        ra0Var.getClass();
        return (ra0Var instanceof m00) && (((m00) ra0Var).y0() instanceof uo1);
    }

    public static final boolean c(fx1 fx1Var) {
        fx1Var.getClass();
        z00 v = fx1Var.N0().v();
        if (v != null) {
            return b(v);
        }
        return false;
    }

    public static final boolean d(ra0 ra0Var) {
        ra0Var.getClass();
        return (ra0Var instanceof m00) && (((m00) ra0Var).y0() instanceof vn2);
    }

    public static final boolean e(rf4 rf4Var) {
        uo1 n;
        rf4Var.getClass();
        if (rf4Var.k0() != null) {
            return false;
        }
        ra0 b2 = rf4Var.b();
        zo2 zo2Var = null;
        m00 m00Var = b2 instanceof m00 ? (m00) b2 : null;
        if (m00Var != null && (n = DescriptorUtilsKt.n(m00Var)) != null) {
            zo2Var = n.c();
        }
        return dq1.a(zo2Var, rf4Var.getName());
    }

    public static final boolean f(ra0 ra0Var) {
        ra0Var.getClass();
        return b(ra0Var) || d(ra0Var);
    }

    public static final fx1 g(fx1 fx1Var) {
        uo1 n;
        fx1Var.getClass();
        z00 v = fx1Var.N0().v();
        m00 m00Var = v instanceof m00 ? (m00) v : null;
        if (m00Var == null || (n = DescriptorUtilsKt.n(m00Var)) == null) {
            return null;
        }
        return (zp3) n.d();
    }
}
