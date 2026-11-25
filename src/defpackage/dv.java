package defpackage;

import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.DispatchException;

/* loaded from: /tmp/classes2.dex */
public abstract class dv {
    public static final void a(u60 u60Var, Throwable th) {
        if (th instanceof DispatchException) {
            th = ((DispatchException) th).getCause();
        }
        Result.Companion companion = Result.INSTANCE;
        u60Var.resumeWith(Result.b(b.a(th)));
        throw th;
    }

    public static final void b(u60 u60Var, u60 u60Var2) {
        try {
            u60 c = IntrinsicsKt__IntrinsicsJvmKt.c(u60Var);
            Result.Companion companion = Result.INSTANCE;
            fn0.b(c, Result.b(qc4.a));
        } catch (Throwable th) {
            a(u60Var2, th);
        }
    }

    public static final void c(b91 b91Var, Object obj, u60 u60Var) {
        try {
            u60 c = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(b91Var, obj, u60Var));
            Result.Companion companion = Result.INSTANCE;
            fn0.b(c, Result.b(qc4.a));
        } catch (Throwable th) {
            a(u60Var, th);
        }
    }
}
