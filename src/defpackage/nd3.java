package defpackage;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: /tmp/classes2.dex */
public final class nd3 extends pd3 implements rs1 {
    public final Class b;
    public final Collection c;
    public final boolean d;

    public nd3(Class cls) {
        cls.getClass();
        this.b = cls;
        this.c = s20.k();
    }

    @Override // defpackage.pd3
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public Class Q() {
        return this.b;
    }

    @Override // defpackage.hr1
    public Collection getAnnotations() {
        return this.c;
    }

    @Override // defpackage.rs1
    public PrimitiveType getType() {
        if (dq1.a(Q(), Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.b(Q().getName()).i();
    }

    @Override // defpackage.hr1
    public boolean o() {
        return this.d;
    }
}
