package defpackage;

import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlinx.coroutines.DispatchException;

/* loaded from: /tmp/classes2.dex */
public abstract class oc4 {
    public static final Void a(ek3 ek3Var, DispatchException dispatchException) {
        ek3Var.O(new w30(dispatchException.getCause(), false, 2, null));
        throw dispatchException.getCause();
    }

    public static final boolean b(ek3 ek3Var, Throwable th) {
        return true;
    }

    public static final void c(b91 b91Var, Object obj, u60 u60Var) {
        u60 a = ma0.a(u60Var);
        try {
            d context = a.getContext();
            Object f = g44.f(context, null);
            try {
                ma0.b(a);
                Object d = !(b91Var instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.d(b91Var, obj, a) : ((b91) ka4.e(b91Var, 2)).invoke(obj, a);
                g44.d(context, f);
                if (d != eq1.e()) {
                    a.resumeWith(Result.b(d));
                }
            } catch (Throwable th) {
                g44.d(context, f);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (th instanceof DispatchException) {
                th = ((DispatchException) th).getCause();
            }
            Result.Companion companion = Result.INSTANCE;
            a.resumeWith(Result.b(b.a(th)));
        }
    }

    public static final Object d(ek3 ek3Var, Object obj, b91 b91Var) {
        return e(ek3Var, true, obj, b91Var);
    }

    public static final Object e(ek3 ek3Var, boolean z, Object obj, b91 b91Var) {
        Object w30Var;
        Object P;
        try {
            w30Var = !(b91Var instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.d(b91Var, obj, ek3Var) : ((b91) ka4.e(b91Var, 2)).invoke(obj, ek3Var);
        } catch (DispatchException e) {
            a(ek3Var, e);
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            w30Var = new w30(th, false, 2, null);
        }
        if (w30Var != eq1.e() && (P = ek3Var.P(w30Var)) != wt1.b) {
            ek3Var.u0();
            if (!(P instanceof w30)) {
                return wt1.h(P);
            }
            if (z || b(ek3Var, ((w30) P).a)) {
                throw ((w30) P).a;
            }
            if (w30Var instanceof w30) {
                throw ((w30) w30Var).a;
            }
            return w30Var;
        }
        return eq1.e();
    }
}
