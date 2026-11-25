package defpackage;

import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: /tmp/classes2.dex */
public class v70 extends wa0 {
    public final KDeclarationContainerImpl a;

    public v70(KDeclarationContainerImpl kDeclarationContainerImpl) {
        kDeclarationContainerImpl.getClass();
        this.a = kDeclarationContainerImpl;
    }

    @Override // defpackage.wa0, defpackage.va0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public KCallableImpl i(e eVar, qc4 qc4Var) {
        eVar.getClass();
        qc4Var.getClass();
        return new KFunctionImpl(this.a, eVar);
    }

    @Override // defpackage.va0
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public KCallableImpl c(o33 o33Var, qc4 qc4Var) {
        o33Var.getClass();
        qc4Var.getClass();
        int i = (o33Var.e0() != null ? 1 : 0) + (o33Var.k0() != null ? 1 : 0);
        if (o33Var.i0()) {
            if (i == 0) {
                return new KMutableProperty0Impl(this.a, o33Var);
            }
            if (i == 1) {
                return new KMutableProperty1Impl(this.a, o33Var);
            }
            if (i == 2) {
                return new d(this.a, o33Var);
            }
        } else {
            if (i == 0) {
                return new KProperty0Impl(this.a, o33Var);
            }
            if (i == 1) {
                return new KProperty1Impl(this.a, o33Var);
            }
            if (i == 2) {
                return new kotlin.reflect.jvm.internal.e(this.a, o33Var);
            }
        }
        qw1.a("Unsupported property: ", o33Var);
        return null;
    }
}
