package defpackage;

import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: /tmp/classes2.dex */
public final class kc4 extends ed4 {
    public kc4(short s) {
        super(Short.valueOf(s));
    }

    @Override // defpackage.k50
    public fx1 a(mm2 mm2Var) {
        mm2Var.getClass();
        m00 a = FindClassInModuleKt.a(mm2Var, e.a.A0);
        zp3 u = a != null ? a.u() : null;
        return u == null ? xu0.d(ErrorTypeKind.C0, "UShort") : u;
    }

    @Override // defpackage.k50
    public String toString() {
        return ((Number) b()).intValue() + ".toUShort()";
    }
}
