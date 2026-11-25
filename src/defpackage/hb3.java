package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public final class hb3 extends ku0 {

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JavaTypeFlexibility.values().length];
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JavaTypeFlexibility.INFLEXIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @Override // defpackage.ku0
    public ta4 a(oa4 oa4Var, lu0 lu0Var, TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, fx1 fx1Var) {
        ta4 va4Var;
        oa4Var.getClass();
        lu0Var.getClass();
        typeParameterUpperBoundEraser.getClass();
        fx1Var.getClass();
        if (!(lu0Var instanceof dt1)) {
            return super.a(oa4Var, lu0Var, typeParameterUpperBoundEraser, fx1Var);
        }
        dt1 dt1Var = (dt1) lu0Var;
        if (!dt1Var.i()) {
            dt1Var = dt1Var.l(JavaTypeFlexibility.INFLEXIBLE);
        }
        int i = a.a[dt1Var.g().ordinal()];
        if (i == 1) {
            return new va4(Variance.INVARIANT, fx1Var);
        }
        if (i != 2 && i != 3) {
            u.a();
            return null;
        }
        if (oa4Var.p().b()) {
            List parameters = fx1Var.N0().getParameters();
            parameters.getClass();
            va4Var = !parameters.isEmpty() ? new va4(Variance.OUT_VARIANCE, fx1Var) : n.t(oa4Var, dt1Var);
        } else {
            va4Var = new va4(Variance.INVARIANT, DescriptorUtilsKt.j(oa4Var).H());
        }
        va4Var.getClass();
        return va4Var;
    }
}
