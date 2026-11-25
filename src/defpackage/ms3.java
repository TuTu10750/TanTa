package defpackage;

import defpackage.gj0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public abstract class ms3 {
    public static final h0 a(fx1 fx1Var) {
        fx1Var.getClass();
        gd4 Q0 = fx1Var.Q0();
        if (Q0 instanceof h0) {
            return (h0) Q0;
        }
        return null;
    }

    public static final zp3 b(fx1 fx1Var) {
        fx1Var.getClass();
        h0 a = a(fx1Var);
        if (a != null) {
            return a.Z0();
        }
        return null;
    }

    public static final boolean c(fx1 fx1Var) {
        fx1Var.getClass();
        return fx1Var.Q0() instanceof gj0;
    }

    public static final gd4 d(gd4 gd4Var, boolean z) {
        gd4Var.getClass();
        gj0 c = gj0.a.c(gj0.d, gd4Var, z, false, 4, null);
        if (c != null) {
            return c;
        }
        zp3 g = g(gd4Var);
        return g != null ? g : gd4Var.R0(false);
    }

    public static final IntersectionTypeConstructor e(IntersectionTypeConstructor intersectionTypeConstructor) {
        fx1 fx1Var;
        Collection c = intersectionTypeConstructor.c();
        ArrayList arrayList = new ArrayList(t20.v(c, 10));
        Iterator it = c.iterator();
        boolean z = false;
        while (true) {
            fx1Var = null;
            if (!it.hasNext()) {
                break;
            }
            fx1 fx1Var2 = (fx1) it.next();
            if (n.l(fx1Var2)) {
                fx1Var2 = f(fx1Var2.Q0(), false, 1, null);
                z = true;
            }
            arrayList.add(fx1Var2);
        }
        if (!z) {
            return null;
        }
        fx1 h = intersectionTypeConstructor.h();
        if (h != null) {
            if (n.l(h)) {
                h = f(h.Q0(), false, 1, null);
            }
            fx1Var = h;
        }
        return new IntersectionTypeConstructor(arrayList).l(fx1Var);
    }

    public static /* synthetic */ gd4 f(gd4 gd4Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return d(gd4Var, z);
    }

    public static final zp3 g(fx1 fx1Var) {
        IntersectionTypeConstructor e;
        ea4 N0 = fx1Var.N0();
        IntersectionTypeConstructor intersectionTypeConstructor = N0 instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) N0 : null;
        if (intersectionTypeConstructor == null || (e = e(intersectionTypeConstructor)) == null) {
            return null;
        }
        return e.g();
    }

    public static final zp3 h(zp3 zp3Var, boolean z) {
        zp3Var.getClass();
        gj0 c = gj0.a.c(gj0.d, zp3Var, z, false, 4, null);
        if (c != null) {
            return c;
        }
        zp3 g = g(zp3Var);
        return g == null ? zp3Var.R0(false) : g;
    }

    public static /* synthetic */ zp3 i(zp3 zp3Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return h(zp3Var, z);
    }

    public static final zp3 j(zp3 zp3Var, zp3 zp3Var2) {
        zp3Var.getClass();
        zp3Var2.getClass();
        return gx1.a(zp3Var) ? zp3Var : new h0(zp3Var, zp3Var2);
    }

    public static final gq2 k(gq2 gq2Var) {
        gq2Var.getClass();
        return new gq2(gq2Var.W0(), gq2Var.N0(), gq2Var.Y0(), gq2Var.M0(), gq2Var.O0(), true);
    }
}
