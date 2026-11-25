package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class hb4 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final fx1 a(fx1 fx1Var) {
        fx1Var.getClass();
        if (fx1Var instanceof gb4) {
            return ((gb4) fx1Var).H();
        }
        return null;
    }

    public static final gd4 b(gd4 gd4Var, fx1 fx1Var) {
        gd4Var.getClass();
        fx1Var.getClass();
        return d(gd4Var, a(fx1Var));
    }

    public static final gd4 c(gd4 gd4Var, fx1 fx1Var, n81 n81Var) {
        gd4Var.getClass();
        fx1Var.getClass();
        n81Var.getClass();
        fx1 a = a(fx1Var);
        return d(gd4Var, a != null ? (fx1) n81Var.invoke(a) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final gd4 d(gd4 gd4Var, fx1 fx1Var) {
        gd4Var.getClass();
        if (gd4Var instanceof gb4) {
            return d(((gb4) gd4Var).F0(), fx1Var);
        }
        if (fx1Var == null || dq1.a(fx1Var, gd4Var)) {
            return gd4Var;
        }
        if (gd4Var instanceof zp3) {
            return new cq3((zp3) gd4Var, fx1Var);
        }
        if (gd4Var instanceof l31) {
            return new p31((l31) gd4Var, fx1Var);
        }
        u.a();
        return null;
    }
}
