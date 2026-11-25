package defpackage;

import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

/* loaded from: /tmp/classes2.dex */
public abstract class rw1 {
    public static final rv1 a(uv1 uv1Var) {
        rv1 b;
        uv1Var.getClass();
        if (uv1Var instanceof rv1) {
            return (rv1) uv1Var;
        }
        Object obj = null;
        if (!(uv1Var instanceof nw1)) {
            qw1.a("Cannot calculate JVM erasure for type: ", uv1Var);
            return null;
        }
        List upperBounds = ((nw1) uv1Var).getUpperBounds();
        Iterator it = upperBounds.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            lw1 lw1Var = (lw1) next;
            lw1Var.getClass();
            z00 v = ((KTypeImpl) lw1Var).p().N0().v();
            m00 m00Var = v instanceof m00 ? (m00) v : null;
            if (m00Var != null && m00Var.i() != ClassKind.INTERFACE && m00Var.i() != ClassKind.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        lw1 lw1Var2 = (lw1) obj;
        if (lw1Var2 == null) {
            lw1Var2 = (lw1) b30.d0(upperBounds);
        }
        return (lw1Var2 == null || (b = b(lw1Var2)) == null) ? zd3.b(Object.class) : b;
    }

    public static final rv1 b(lw1 lw1Var) {
        rv1 a;
        lw1Var.getClass();
        uv1 k = lw1Var.k();
        if (k != null && (a = a(k)) != null) {
            return a;
        }
        qw1.a("Cannot calculate JVM erasure for type: ", lw1Var);
        return null;
    }
}
