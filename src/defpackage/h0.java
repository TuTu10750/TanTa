package defpackage;

import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public final class h0 extends pj0 {
    public final zp3 b;
    public final zp3 c;

    public h0(zp3 zp3Var, zp3 zp3Var2) {
        zp3Var.getClass();
        zp3Var2.getClass();
        this.b = zp3Var;
        this.c = zp3Var2;
    }

    public final zp3 U() {
        return W0();
    }

    @Override // defpackage.gd4
    /* renamed from: V0 */
    public zp3 T0(j jVar) {
        jVar.getClass();
        return new h0(W0().T0(jVar), this.c);
    }

    @Override // defpackage.pj0
    public zp3 W0() {
        return this.b;
    }

    public final zp3 Z0() {
        return this.c;
    }

    @Override // defpackage.zp3
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public h0 R0(boolean z) {
        return new h0(W0().R0(z), this.c.R0(z));
    }

    @Override // defpackage.pj0
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public h0 X0(c cVar) {
        cVar.getClass();
        fx1 a = cVar.a(W0());
        a.getClass();
        fx1 a2 = cVar.a(this.c);
        a2.getClass();
        return new h0((zp3) a, (zp3) a2);
    }

    @Override // defpackage.pj0
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public h0 Y0(zp3 zp3Var) {
        zp3Var.getClass();
        return new h0(zp3Var, this.c);
    }
}
