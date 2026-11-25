package defpackage;

import kotlin.Result;
import kotlin.b;

/* loaded from: /tmp/classes2.dex */
public abstract class cn {
    static {
        Object b;
        try {
            Result.Companion companion = Result.INSTANCE;
            b = Result.b(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            b = Result.b(b.a(th));
        }
        if (Result.g(b)) {
            b = Boolean.TRUE;
        }
        Object b2 = Result.b(b);
        Boolean bool = Boolean.FALSE;
        if (Result.f(b2)) {
            b2 = bool;
        }
        ((Boolean) b2).getClass();
    }

    public static final bn a(n81 n81Var) {
        n81Var.getClass();
        return new w40(n81Var);
    }
}
