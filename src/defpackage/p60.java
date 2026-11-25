package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.a;

/* loaded from: /tmp/classes2.dex */
public final class p60 extends z1 implements sn1 {
    public final a c;
    public final zo2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p60(a aVar, fx1 fx1Var, zo2 zo2Var, bc3 bc3Var) {
        super(fx1Var, bc3Var);
        aVar.getClass();
        fx1Var.getClass();
        this.c = aVar;
        this.d = zo2Var;
    }

    @Override // defpackage.sn1
    public zo2 a() {
        return this.d;
    }

    public a c() {
        return this.c;
    }

    public String toString() {
        return "Cxt { " + c() + " }";
    }
}
