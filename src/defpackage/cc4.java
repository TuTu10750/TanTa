package defpackage;

import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: /tmp/classes2.dex */
public final class cc4 extends ed4 {
    public cc4(long j) {
        super(Long.valueOf(j));
    }

    @Override // defpackage.k50
    public fx1 a(mm2 mm2Var) {
        mm2Var.getClass();
        m00 a = FindClassInModuleKt.a(mm2Var, e.a.C0);
        zp3 u = a != null ? a.u() : null;
        return u == null ? xu0.d(ErrorTypeKind.C0, "ULong") : u;
    }

    @Override // defpackage.k50
    public String toString() {
        return ((Number) b()).longValue() + ".toULong()";
    }
}
