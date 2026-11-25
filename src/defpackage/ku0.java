package defpackage;

import kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public abstract class ku0 {
    public static /* synthetic */ ta4 b(ku0 ku0Var, oa4 oa4Var, lu0 lu0Var, TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, fx1 fx1Var, int i, Object obj) {
        if (obj != null) {
            qm.a("Super calls with default arguments not supported in this target, function: computeProjection");
            return null;
        }
        if ((i & 8) != 0) {
            fx1Var = typeParameterUpperBoundEraser.c(oa4Var, lu0Var);
        }
        return ku0Var.a(oa4Var, lu0Var, typeParameterUpperBoundEraser, fx1Var);
    }

    public ta4 a(oa4 oa4Var, lu0 lu0Var, TypeParameterUpperBoundEraser typeParameterUpperBoundEraser, fx1 fx1Var) {
        oa4Var.getClass();
        lu0Var.getClass();
        typeParameterUpperBoundEraser.getClass();
        fx1Var.getClass();
        return new va4(Variance.OUT_VARIANCE, fx1Var);
    }
}
