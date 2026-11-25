package defpackage;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.k;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* loaded from: /tmp/classes2.dex */
public abstract class lf4 {
    public static final fx1 a(fx1 fx1Var) {
        return (fx1) CapturedTypeApproximationKt.a(fx1Var).d();
    }

    public static final String b(ea4 ea4Var) {
        StringBuilder sb = new StringBuilder();
        c("type: " + ea4Var, sb);
        c("hashCode: " + ea4Var.hashCode(), sb);
        c("javaClass: " + ea4Var.getClass().getCanonicalName(), sb);
        for (ra0 b = ea4Var.b(); b != null; b = b.b()) {
            c("fqName: " + DescriptorRenderer.g.q(b), sb);
            c("javaClass: " + b.getClass().getCanonicalName(), sb);
        }
        return sb.toString();
    }

    public static final StringBuilder c(String str, StringBuilder sb) {
        str.getClass();
        sb.append(str);
        sb.append('\n');
        return sb;
    }

    public static final fx1 d(fx1 fx1Var, fx1 fx1Var2, ca4 ca4Var) {
        fx1Var.getClass();
        fx1Var2.getClass();
        ca4Var.getClass();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new jx3(fx1Var, null));
        ea4 N0 = fx1Var2.N0();
        while (!arrayDeque.isEmpty()) {
            jx3 jx3Var = (jx3) arrayDeque.poll();
            fx1 b = jx3Var.b();
            ea4 N02 = b.N0();
            if (ca4Var.a(N02, N0)) {
                boolean O0 = b.O0();
                for (jx3 a = jx3Var.a(); a != null; a = a.a()) {
                    fx1 b2 = a.b();
                    List L0 = b2.L0();
                    if (L0 == null || !L0.isEmpty()) {
                        Iterator it = L0.iterator();
                        while (it.hasNext()) {
                            Variance b3 = ((ta4) it.next()).b();
                            Variance variance = Variance.INVARIANT;
                            if (b3 != variance) {
                                fx1 n = CapturedTypeConstructorKt.f(k.c.a(b2), false, 1, null).c().n(b, variance);
                                n.getClass();
                                b = a(n);
                                break;
                            }
                        }
                    }
                    b = k.c.a(b2).c().n(b, Variance.INVARIANT);
                    b.getClass();
                    O0 = O0 || b2.O0();
                }
                ea4 N03 = b.N0();
                if (ca4Var.a(N03, N0)) {
                    return n.p(b, O0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(N03) + ", \n\nsupertype: " + b(N0) + " \n" + ca4Var.a(N03, N0));
            }
            for (fx1 fx1Var3 : N02.c()) {
                fx1Var3.getClass();
                arrayDeque.add(new jx3(fx1Var3, jx3Var));
            }
        }
        return null;
    }
}
