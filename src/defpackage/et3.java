package defpackage;

import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: /tmp/classes2.dex */
public abstract class et3 {
    public static final StackTraceElement a = new ub().a();
    public static final String b;
    public static final String c;

    static {
        Object b2;
        Object b3;
        try {
            Result.Companion companion = Result.INSTANCE;
            b2 = Result.b(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            b2 = Result.b(b.a(th));
        }
        if (Result.d(b2) != null) {
            b2 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        b = (String) b2;
        try {
            b3 = Result.b(et3.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            b3 = Result.b(b.a(th2));
        }
        if (Result.d(b3) != null) {
            b3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        c = (String) b3;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
