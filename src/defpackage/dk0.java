package defpackage;

import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class dk0 {
    public static final String a(m00 m00Var, la4 la4Var) {
        m00Var.getClass();
        la4Var.getClass();
        String f = la4Var.f(m00Var);
        if (f != null) {
            return f;
        }
        ra0 b = m00Var.b();
        b.getClass();
        String d = ls3.b(m00Var.getName()).d();
        d.getClass();
        if (b instanceof kv2) {
            r51 d2 = ((kv2) b).d();
            if (d2.d()) {
                return d;
            }
            StringBuilder sb = new StringBuilder();
            String b2 = d2.b();
            b2.getClass();
            sb.append(fw3.E(b2, '.', '/', false, 4, null));
            sb.append('/');
            sb.append(d);
            return sb.toString();
        }
        m00 m00Var2 = b instanceof m00 ? (m00) b : null;
        if (m00Var2 == null) {
            xb4.a("Unexpected container: ", b, " for ", m00Var);
            return null;
        }
        String c = la4Var.c(m00Var2);
        if (c == null) {
            c = a(m00Var2, la4Var);
        }
        return c + '$' + d;
    }

    public static /* synthetic */ String b(m00 m00Var, la4 la4Var, int i, Object obj) {
        if ((i & 2) != 0) {
            la4Var = ma4.a;
        }
        return a(m00Var, la4Var);
    }

    public static final boolean c(a aVar) {
        aVar.getClass();
        if (aVar instanceof c) {
            return true;
        }
        fx1 returnType = aVar.getReturnType();
        returnType.getClass();
        if (!d.C0(returnType)) {
            return false;
        }
        fx1 returnType2 = aVar.getReturnType();
        returnType2.getClass();
        return (n.l(returnType2) || (aVar instanceof q33)) ? false : true;
    }

    public static final Object d(fx1 fx1Var, lv1 lv1Var, na4 na4Var, la4 la4Var, yu1 yu1Var, d91 d91Var) {
        Object d;
        fx1 fx1Var2;
        Object d2;
        fx1Var.getClass();
        lv1Var.getClass();
        na4Var.getClass();
        la4Var.getClass();
        d91Var.getClass();
        fx1 b = la4Var.b(fx1Var);
        if (b != null) {
            return d(b, lv1Var, na4Var, la4Var, yu1Var, d91Var);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.c.q(fx1Var)) {
            return d(l04.a(fx1Var), lv1Var, na4Var, la4Var, yu1Var, d91Var);
        }
        qp3 qp3Var = qp3.a;
        Object b2 = wa4.b(qp3Var, fx1Var, lv1Var, na4Var);
        if (b2 != null) {
            Object a = wa4.a(lv1Var, b2, na4Var.d());
            d91Var.invoke(fx1Var, a, na4Var);
            return a;
        }
        ea4 N0 = fx1Var.N0();
        if (N0 instanceof IntersectionTypeConstructor) {
            IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) N0;
            fx1 h = intersectionTypeConstructor.h();
            if (h == null) {
                h = la4Var.e(intersectionTypeConstructor.c());
            }
            return d(TypeUtilsKt.y(h), lv1Var, na4Var, la4Var, yu1Var, d91Var);
        }
        z00 v = N0.v();
        if (v == null) {
            yb4.a("no descriptor for type constructor of ", fx1Var);
            return null;
        }
        if (xu0.m(v)) {
            Object c = lv1Var.c("error/NonExistentClass");
            la4Var.a(fx1Var, (m00) v);
            return c;
        }
        boolean z = v instanceof m00;
        if (z && d.c0(fx1Var)) {
            if (fx1Var.L0().size() != 1) {
                qm.a("arrays must have one type argument");
                return null;
            }
            ta4 ta4Var = (ta4) fx1Var.L0().get(0);
            fx1 type = ta4Var.getType();
            type.getClass();
            if (ta4Var.b() == Variance.IN_VARIANCE) {
                d2 = lv1Var.c("java/lang/Object");
            } else {
                Variance b3 = ta4Var.b();
                b3.getClass();
                d2 = d(type, lv1Var, na4Var.f(b3, true), la4Var, yu1Var, d91Var);
            }
            return lv1Var.b("[" + lv1Var.a(d2));
        }
        if (!z) {
            if (v instanceof oa4) {
                fx1 j = TypeUtilsKt.j((oa4) v);
                if (fx1Var.O0()) {
                    j = TypeUtilsKt.w(j);
                }
                return d(j, lv1Var, na4Var, la4Var, null, FunctionsKt.b());
            }
            if ((v instanceof r94) && na4Var.b()) {
                return d(((r94) v).U(), lv1Var, na4Var, la4Var, yu1Var, d91Var);
            }
            yb4.a("Unknown type ", fx1Var);
            return null;
        }
        if (vo1.b(v) && !na4Var.c() && (fx1Var2 = (fx1) py0.a(qp3Var, fx1Var)) != null) {
            return d(fx1Var2, lv1Var, na4Var.g(), la4Var, yu1Var, d91Var);
        }
        if (na4Var.e() && d.l0((m00) v)) {
            d = lv1Var.e();
        } else {
            m00 m00Var = (m00) v;
            m00 a2 = m00Var.a();
            a2.getClass();
            d = la4Var.d(a2);
            if (d == null) {
                if (m00Var.i() == ClassKind.ENUM_ENTRY) {
                    ra0 b4 = m00Var.b();
                    b4.getClass();
                    m00Var = (m00) b4;
                }
                m00 a3 = m00Var.a();
                a3.getClass();
                d = lv1Var.c(a(a3, la4Var));
            }
        }
        d91Var.invoke(fx1Var, d, na4Var);
        return d;
    }

    public static /* synthetic */ Object e(fx1 fx1Var, lv1 lv1Var, na4 na4Var, la4 la4Var, yu1 yu1Var, d91 d91Var, int i, Object obj) {
        if ((i & 32) != 0) {
            d91Var = FunctionsKt.b();
        }
        return d(fx1Var, lv1Var, na4Var, la4Var, yu1Var, d91Var);
    }
}
