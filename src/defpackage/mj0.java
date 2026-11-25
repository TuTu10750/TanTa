package defpackage;

import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.l;

/* loaded from: /tmp/classes2.dex */
public abstract class mj0 extends l {
    public final l c;

    public mj0(l lVar) {
        lVar.getClass();
        this.c = lVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public boolean a() {
        return this.c.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public j8 d(j8 j8Var) {
        j8Var.getClass();
        return this.c.d(j8Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public ta4 e(fx1 fx1Var) {
        fx1Var.getClass();
        return this.c.e(fx1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public boolean f() {
        return this.c.f();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public fx1 g(fx1 fx1Var, Variance variance) {
        fx1Var.getClass();
        variance.getClass();
        return this.c.g(fx1Var, variance);
    }
}
