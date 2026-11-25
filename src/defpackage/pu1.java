package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class pu1 {
    public static final pu1 a = new pu1();
    public static final r51 b;
    public static final q00 c;
    public static final q00 d;
    public static final q00 e;

    static {
        r51 r51Var = new r51("kotlin.jvm.JvmField");
        b = r51Var;
        q00 m = q00.m(r51Var);
        m.getClass();
        c = m;
        q00 m2 = q00.m(new r51("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        m2.getClass();
        d = m2;
        q00 e2 = q00.e("kotlin/jvm/internal/RepeatableContainer");
        e2.getClass();
        e = e2;
    }

    public static final String b(String str) {
        str.getClass();
        if (f(str)) {
            return str;
        }
        return "get" + iv.a(str);
    }

    public static final boolean c(String str) {
        str.getClass();
        return fw3.J(str, "get", false, 2, null) || fw3.J(str, "is", false, 2, null);
    }

    public static final boolean d(String str) {
        str.getClass();
        return fw3.J(str, "set", false, 2, null);
    }

    public static final String e(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder("set");
        sb.append(f(str) ? str.substring(2) : iv.a(str));
        return sb.toString();
    }

    public static final boolean f(String str) {
        str.getClass();
        if (!fw3.J(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char charAt = str.charAt(2);
        return dq1.b(97, charAt) > 0 || dq1.b(charAt, 122) > 0;
    }

    public final q00 a() {
        return e;
    }
}
