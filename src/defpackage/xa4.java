package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class xa4 {
    public static final zp3 a(fx1 fx1Var) {
        fx1Var.getClass();
        gd4 Q0 = fx1Var.Q0();
        zp3 zp3Var = Q0 instanceof zp3 ? (zp3) Q0 : null;
        if (zp3Var != null) {
            return zp3Var;
        }
        vt1.a("This is should be simple type: ", fx1Var);
        return null;
    }

    public static final fx1 b(fx1 fx1Var, List list, j8 j8Var) {
        fx1Var.getClass();
        list.getClass();
        j8Var.getClass();
        return e(fx1Var, list, j8Var, null, 4, null);
    }

    public static final fx1 c(fx1 fx1Var, List list, j8 j8Var, List list2) {
        fx1Var.getClass();
        list.getClass();
        j8Var.getClass();
        list2.getClass();
        if ((list.isEmpty() || list == fx1Var.L0()) && j8Var == fx1Var.getAnnotations()) {
            return fx1Var;
        }
        j M0 = fx1Var.M0();
        if ((j8Var instanceof a21) && j8Var.isEmpty()) {
            j8Var = j8.a0.b();
        }
        j a = y94.a(M0, j8Var);
        gd4 Q0 = fx1Var.Q0();
        if (Q0 instanceof l31) {
            l31 l31Var = (l31) Q0;
            return KotlinTypeFactory.d(d(l31Var.V0(), list, a), d(l31Var.W0(), list2, a));
        }
        if (Q0 instanceof zp3) {
            return d((zp3) Q0, list, a);
        }
        u.a();
        return null;
    }

    public static final zp3 d(zp3 zp3Var, List list, j jVar) {
        zp3Var.getClass();
        list.getClass();
        jVar.getClass();
        return (list.isEmpty() && jVar == zp3Var.M0()) ? zp3Var : list.isEmpty() ? zp3Var.T0(jVar) : zp3Var instanceof vu0 ? ((vu0) zp3Var).Z0(list) : KotlinTypeFactory.j(jVar, zp3Var.N0(), list, zp3Var.O0(), null, 16, null);
    }

    public static /* synthetic */ fx1 e(fx1 fx1Var, List list, j8 j8Var, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fx1Var.L0();
        }
        if ((i & 2) != 0) {
            j8Var = fx1Var.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return c(fx1Var, list, j8Var, list2);
    }

    public static /* synthetic */ zp3 f(zp3 zp3Var, List list, j jVar, int i, Object obj) {
        if ((i & 1) != 0) {
            list = zp3Var.L0();
        }
        if ((i & 2) != 0) {
            jVar = zp3Var.M0();
        }
        return d(zp3Var, list, jVar);
    }
}
