package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class x40 {
    public static final p04 a = new p04("CLOSED");

    public static final y40 b(y40 y40Var) {
        while (true) {
            Object g = y40Var.g();
            if (g == a) {
                return y40Var;
            }
            y40 y40Var2 = (y40) g;
            if (y40Var2 != null) {
                y40Var = y40Var2;
            } else if (y40Var.m()) {
                return y40Var;
            }
        }
    }

    public static final Object c(hl3 hl3Var, long j, b91 b91Var) {
        while (true) {
            if (hl3Var.c >= j && !hl3Var.k()) {
                return jl3.a(hl3Var);
            }
            Object g = hl3Var.g();
            if (g == a) {
                return jl3.a(a);
            }
            hl3 hl3Var2 = (hl3) ((y40) g);
            if (hl3Var2 == null) {
                hl3Var2 = (hl3) b91Var.invoke(Long.valueOf(hl3Var.c + 1), hl3Var);
                if (hl3Var.o(hl3Var2)) {
                    if (hl3Var.k()) {
                        hl3Var.n();
                    }
                }
            }
            hl3Var = hl3Var2;
        }
    }
}
