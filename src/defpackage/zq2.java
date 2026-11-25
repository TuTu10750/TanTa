package defpackage;

import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.j;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public final class zq2 extends pj0 implements yq2 {
    public final zp3 b;

    public zq2(zp3 zp3Var) {
        zp3Var.getClass();
        this.b = zp3Var;
    }

    @Override // defpackage.t80
    public boolean A0() {
        return true;
    }

    @Override // defpackage.pj0, defpackage.fx1
    public boolean O0() {
        return false;
    }

    @Override // defpackage.gd4
    /* renamed from: U0 */
    public zp3 R0(boolean z) {
        return z ? W0().R0(true) : this;
    }

    @Override // defpackage.pj0
    public zp3 W0() {
        return this.b;
    }

    public final zp3 Z0(zp3 zp3Var) {
        zp3 R0 = zp3Var.R0(false);
        return !TypeUtilsKt.t(zp3Var) ? R0 : new zq2(R0);
    }

    @Override // defpackage.zp3
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public zq2 T0(j jVar) {
        jVar.getClass();
        return new zq2(W0().T0(jVar));
    }

    @Override // defpackage.pj0
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public zq2 Y0(zp3 zp3Var) {
        zp3Var.getClass();
        return new zq2(zp3Var);
    }

    @Override // defpackage.t80
    public fx1 z0(fx1 fx1Var) {
        fx1Var.getClass();
        gd4 Q0 = fx1Var.Q0();
        if (!TypeUtilsKt.t(Q0) && !n.l(Q0)) {
            return Q0;
        }
        if (Q0 instanceof zp3) {
            return Z0((zp3) Q0);
        }
        if (Q0 instanceof l31) {
            l31 l31Var = (l31) Q0;
            return hb4.d(KotlinTypeFactory.d(Z0(l31Var.V0()), Z0(l31Var.W0())), hb4.a(Q0));
        }
        vt1.a("Incorrect type: ", Q0);
        return null;
    }
}
