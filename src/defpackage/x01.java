package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* loaded from: /tmp/classes2.dex */
public final class x01 implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result b(a aVar, a aVar2, m00 m00Var) {
        aVar.getClass();
        aVar2.getClass();
        if (!(aVar2 instanceof o33) || !(aVar instanceof o33)) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        o33 o33Var = (o33) aVar2;
        o33 o33Var2 = (o33) aVar;
        return !dq1.a(o33Var.getName(), o33Var2.getName()) ? ExternalOverridabilityCondition.Result.UNKNOWN : (yr1.a(o33Var) && yr1.a(o33Var2)) ? ExternalOverridabilityCondition.Result.OVERRIDABLE : (yr1.a(o33Var) || yr1.a(o33Var2)) ? ExternalOverridabilityCondition.Result.INCOMPATIBLE : ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
