package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class c2 {
    public static final c2 a = new c2();

    public final boolean a(ya4 ya4Var, aq3 aq3Var, aq3 aq3Var2) {
        if (ya4Var.i(aq3Var) == ya4Var.i(aq3Var2) && ya4Var.j0(aq3Var) == ya4Var.j0(aq3Var2)) {
            if ((ya4Var.D0(aq3Var) == null) == (ya4Var.D0(aq3Var2) == null) && ya4Var.g0(ya4Var.d(aq3Var), ya4Var.d(aq3Var2))) {
                if (ya4Var.h0(aq3Var, aq3Var2)) {
                    return true;
                }
                int i = ya4Var.i(aq3Var);
                for (int i2 = 0; i2 < i; i2++) {
                    u94 y0 = ya4Var.y0(aq3Var, i2);
                    u94 y02 = ya4Var.y0(aq3Var2, i2);
                    if (ya4Var.k(y0) != ya4Var.k(y02)) {
                        return false;
                    }
                    if (!ya4Var.k(y0) && (ya4Var.m(y0) != ya4Var.m(y02) || !c(ya4Var, ya4Var.q(y0), ya4Var.q(y02)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean b(ya4 ya4Var, hx1 hx1Var, hx1 hx1Var2) {
        ya4Var.getClass();
        hx1Var.getClass();
        hx1Var2.getClass();
        return c(ya4Var, hx1Var, hx1Var2);
    }

    public final boolean c(ya4 ya4Var, hx1 hx1Var, hx1 hx1Var2) {
        if (hx1Var == hx1Var2) {
            return true;
        }
        aq3 b = ya4Var.b(hx1Var);
        aq3 b2 = ya4Var.b(hx1Var2);
        if (b != null && b2 != null) {
            return a(ya4Var, b, b2);
        }
        o31 l0 = ya4Var.l0(hx1Var);
        o31 l02 = ya4Var.l0(hx1Var2);
        return l0 != null && l02 != null && a(ya4Var, ya4Var.g(l0), ya4Var.g(l02)) && a(ya4Var, ya4Var.f(l0), ya4Var.f(l02));
    }
}
