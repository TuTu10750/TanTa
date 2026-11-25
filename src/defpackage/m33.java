package defpackage;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class m33 {
    public static final List a(zo2 zo2Var) {
        zo2Var.getClass();
        String b = zo2Var.b();
        b.getClass();
        return pu1.c(b) ? s20.o(b(zo2Var)) : pu1.d(b) ? f(zo2Var) : al.a.b(zo2Var);
    }

    public static final zo2 b(zo2 zo2Var) {
        zo2Var.getClass();
        zo2 e = e(zo2Var, "get", false, null, 12, null);
        return e == null ? e(zo2Var, "is", false, null, 8, null) : e;
    }

    public static final zo2 c(zo2 zo2Var, boolean z) {
        zo2Var.getClass();
        return e(zo2Var, "set", false, z ? "is" : null, 4, null);
    }

    public static final zo2 d(zo2 zo2Var, String str, boolean z, String str2) {
        if (zo2Var.j()) {
            return null;
        }
        String d = zo2Var.d();
        d.getClass();
        if (!fw3.J(d, str, false, 2, null) || d.length() == str.length()) {
            return null;
        }
        char charAt = d.charAt(str.length());
        if ('a' <= charAt && charAt < '{') {
            return null;
        }
        if (str2 != null) {
            return zo2.i(str2 + hw3.o0(d, str));
        }
        if (!z) {
            return zo2Var;
        }
        String c = iv.c(hw3.o0(d, str), true);
        if (zo2.k(c)) {
            return zo2.i(c);
        }
        return null;
    }

    public static /* synthetic */ zo2 e(zo2 zo2Var, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return d(zo2Var, str, z, str2);
    }

    public static final List f(zo2 zo2Var) {
        zo2Var.getClass();
        return s20.p(c(zo2Var, false), c(zo2Var, true));
    }
}
