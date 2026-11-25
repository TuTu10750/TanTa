package defpackage;

import kotlin.Result;
import kotlin.b;

/* loaded from: /tmp/classes2.dex */
public abstract class na0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(u60 u60Var) {
        Object b;
        if (u60Var instanceof en0) {
            return ((en0) u60Var).toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            b = Result.b(u60Var + '@' + b(u60Var));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            b = Result.b(b.a(th));
        }
        if (Result.d(b) != null) {
            b = u60Var.getClass().getName() + '@' + b(u60Var);
        }
        return (String) b;
    }
}
