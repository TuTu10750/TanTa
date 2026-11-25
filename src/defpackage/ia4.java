package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;

/* loaded from: /tmp/classes2.dex */
public abstract class ia4 {
    public static final j8 a;
    public static final du0 b;

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NullabilityQualifier.values().length];
            try {
                iArr[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        r51 r51Var = qu1.u;
        r51Var.getClass();
        a = new du0(r51Var);
        r51 r51Var2 = qu1.v;
        r51Var2.getClass();
        b = new du0(r51Var2);
    }

    public static final j8 e(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new CompositeAnnotations(b30.I0(list)) : (j8) b30.y0(list);
        }
        fl3.a("At least one Annotations object expected");
        return null;
    }

    public static final z00 f(z00 z00Var, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a aVar, TypeComponentPosition typeComponentPosition) {
        bt1 bt1Var = bt1.a;
        if (!da4.a(typeComponentPosition) || !(z00Var instanceof m00)) {
            return null;
        }
        if (aVar.c() == MutabilityQualifier.READ_ONLY && typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            m00 m00Var = (m00) z00Var;
            if (bt1Var.c(m00Var)) {
                return bt1Var.a(m00Var);
            }
        }
        if (aVar.c() == MutabilityQualifier.MUTABLE && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
            m00 m00Var2 = (m00) z00Var;
            if (bt1Var.d(m00Var2)) {
                return bt1Var.b(m00Var2);
            }
        }
        return null;
    }

    public static final j8 g() {
        return a;
    }

    public static final Boolean h(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a aVar, TypeComponentPosition typeComponentPosition) {
        if (!da4.a(typeComponentPosition)) {
            return null;
        }
        NullabilityQualifier d = aVar.d();
        int i = d == null ? -1 : a.a[d.ordinal()];
        if (i == 1) {
            return Boolean.TRUE;
        }
        if (i != 2) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static final boolean i(fx1 fx1Var) {
        fx1Var.getClass();
        return ja4.c(qp3.a, fx1Var);
    }
}
