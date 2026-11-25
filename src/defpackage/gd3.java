package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: /tmp/classes2.dex */
public final class gd3 extends uc3 implements bs1 {
    public final Enum c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd3(zo2 zo2Var, Enum r3) {
        super(zo2Var, null);
        r3.getClass();
        this.c = r3;
    }

    @Override // defpackage.bs1
    public q00 b() {
        Class<?> cls = this.c.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        cls.getClass();
        return ReflectClassUtilKt.a(cls);
    }

    @Override // defpackage.bs1
    public zo2 d() {
        return zo2.i(this.c.name());
    }
}
