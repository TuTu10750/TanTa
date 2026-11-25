package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.calls.a;

/* loaded from: /tmp/classes2.dex */
public abstract class td3 {
    public static final Constructor a(aw1 aw1Var) {
        a B;
        aw1Var.getClass();
        KCallableImpl b = if4.b(aw1Var);
        Member b2 = (b == null || (B = b.B()) == null) ? null : B.b();
        if (b2 instanceof Constructor) {
            return (Constructor) b2;
        }
        return null;
    }

    public static final Field b(iw1 iw1Var) {
        iw1Var.getClass();
        KPropertyImpl d = if4.d(iw1Var);
        if (d != null) {
            return d.M();
        }
        return null;
    }

    public static final Method c(iw1 iw1Var) {
        iw1Var.getClass();
        return d(iw1Var.f());
    }

    public static final Method d(aw1 aw1Var) {
        a B;
        aw1Var.getClass();
        KCallableImpl b = if4.b(aw1Var);
        Member b2 = (b == null || (B = b.B()) == null) ? null : B.b();
        if (b2 instanceof Method) {
            return (Method) b2;
        }
        return null;
    }

    public static final Method e(fw1 fw1Var) {
        fw1Var.getClass();
        return d(fw1Var.g());
    }

    public static final Type f(lw1 lw1Var) {
        lw1Var.getClass();
        Type q = ((KTypeImpl) lw1Var).q();
        return q == null ? TypesJVMKt.f(lw1Var) : q;
    }
}
