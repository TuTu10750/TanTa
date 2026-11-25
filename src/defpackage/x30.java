package defpackage;

import kotlin.Result;
import kotlin.b;

/* loaded from: /tmp/classes2.dex */
public abstract class x30 {
    public static final Object a(Object obj, u60 u60Var) {
        if (!(obj instanceof w30)) {
            return Result.b(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.b(b.a(((w30) obj).a));
    }

    public static final Object b(Object obj) {
        Throwable d = Result.d(obj);
        return d == null ? obj : new w30(d, false, 2, null);
    }

    public static final Object c(Object obj, zu zuVar) {
        Throwable d = Result.d(obj);
        return d == null ? obj : new w30(d, false, 2, null);
    }
}
