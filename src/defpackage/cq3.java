package defpackage;

import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public final class cq3 extends pj0 implements gb4 {
    public final zp3 b;
    public final fx1 c;

    public cq3(zp3 zp3Var, fx1 fx1Var) {
        zp3Var.getClass();
        fx1Var.getClass();
        this.b = zp3Var;
        this.c = fx1Var;
    }

    @Override // defpackage.gb4
    public fx1 H() {
        return this.c;
    }

    @Override // defpackage.gd4
    /* renamed from: U0 */
    public zp3 R0(boolean z) {
        gd4 d = hb4.d(F0().R0(z), H().Q0().R0(z));
        d.getClass();
        return (zp3) d;
    }

    @Override // defpackage.gd4
    /* renamed from: V0 */
    public zp3 T0(j jVar) {
        jVar.getClass();
        gd4 d = hb4.d(F0().T0(jVar), H());
        d.getClass();
        return (zp3) d;
    }

    @Override // defpackage.pj0
    public zp3 W0() {
        return this.b;
    }

    @Override // defpackage.gb4
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public zp3 F0() {
        return W0();
    }

    @Override // defpackage.pj0
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public cq3 X0(c cVar) {
        cVar.getClass();
        fx1 a = cVar.a(W0());
        a.getClass();
        return new cq3((zp3) a, cVar.a(H()));
    }

    @Override // defpackage.pj0
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public cq3 Y0(zp3 zp3Var) {
        zp3Var.getClass();
        return new cq3(zp3Var, H());
    }

    @Override // defpackage.zp3
    public String toString() {
        return "[@EnhancedForWarnings(" + H() + ")] " + F0();
    }
}
