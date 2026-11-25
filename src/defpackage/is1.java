package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class is1 {
    public static final boolean a(ks1 ks1Var) {
        r51 d;
        lt1 lt1Var = (lt1) b30.A0(ks1Var.h());
        ct1 type = lt1Var != null ? lt1Var.getType() : null;
        ur1 ur1Var = type instanceof ur1 ? (ur1) type : null;
        if (ur1Var == null) {
            return false;
        }
        tr1 k = ur1Var.k();
        return (k instanceof lr1) && (d = ((lr1) k).d()) != null && dq1.a(d.b(), "java.lang.Object");
    }

    public static final boolean b(ks1 ks1Var) {
        String b = ks1Var.getName().b();
        int hashCode = b.hashCode();
        if (hashCode != -1776922004) {
            if (hashCode == -1295482945) {
                if (b.equals("equals")) {
                    return a(ks1Var);
                }
                return false;
            }
            if (hashCode != 147696667 || !b.equals("hashCode")) {
                return false;
            }
        } else if (!b.equals("toString")) {
            return false;
        }
        return ks1Var.h().isEmpty();
    }

    public static final boolean c(js1 js1Var) {
        js1Var.getClass();
        return js1Var.P().H() && (js1Var instanceof ks1) && b((ks1) js1Var);
    }
}
