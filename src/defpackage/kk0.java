package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class kk0 {
    public static final z00 a(ra0 ra0Var) {
        ra0Var.getClass();
        ra0 b = ra0Var.b();
        if (b != null && !(ra0Var instanceof kv2)) {
            if (!b(b)) {
                return a(b);
            }
            if (b instanceof z00) {
                return (z00) b;
            }
        }
        return null;
    }

    public static final boolean b(ra0 ra0Var) {
        ra0Var.getClass();
        return ra0Var.b() instanceof kv2;
    }

    public static final boolean c(e eVar) {
        zp3 u;
        fx1 y;
        fx1 returnType;
        eVar.getClass();
        ra0 b = eVar.b();
        m00 m00Var = b instanceof m00 ? (m00) b : null;
        if (m00Var != null) {
            m00 m00Var2 = vo1.f(m00Var) ? m00Var : null;
            if (m00Var2 != null && (u = m00Var2.u()) != null && (y = TypeUtilsKt.y(u)) != null && (returnType = eVar.getReturnType()) != null && dq1.a(eVar.getName(), fu2.e) && ((TypeUtilsKt.n(returnType) || TypeUtilsKt.o(returnType)) && eVar.h().size() == 1)) {
                fx1 type = ((h) eVar.h().get(0)).getType();
                type.getClass();
                if (dq1.a(TypeUtilsKt.y(type), y) && eVar.p0().isEmpty() && eVar.k0() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final m00 d(mm2 mm2Var, r51 r51Var, z82 z82Var) {
        z00 z00Var;
        MemberScope x0;
        mm2Var.getClass();
        r51Var.getClass();
        z82Var.getClass();
        if (r51Var.d()) {
            return null;
        }
        r51 e = r51Var.e();
        e.getClass();
        MemberScope s = mm2Var.t0(e).s();
        zo2 g = r51Var.g();
        g.getClass();
        z00 e2 = s.e(g, z82Var);
        m00 m00Var = e2 instanceof m00 ? (m00) e2 : null;
        if (m00Var != null) {
            return m00Var;
        }
        r51 e3 = r51Var.e();
        e3.getClass();
        m00 d = d(mm2Var, e3, z82Var);
        if (d == null || (x0 = d.x0()) == null) {
            z00Var = null;
        } else {
            zo2 g2 = r51Var.g();
            g2.getClass();
            z00Var = x0.e(g2, z82Var);
        }
        if (z00Var instanceof m00) {
            return (m00) z00Var;
        }
        return null;
    }
}
