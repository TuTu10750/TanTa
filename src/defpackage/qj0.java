package defpackage;

import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class qj0 extends pj0 {
    public final zp3 b;

    public qj0(zp3 zp3Var) {
        zp3Var.getClass();
        this.b = zp3Var;
    }

    @Override // defpackage.gd4
    /* renamed from: U0 */
    public zp3 R0(boolean z) {
        return z == O0() ? this : W0().R0(z).T0(M0());
    }

    @Override // defpackage.gd4
    /* renamed from: V0 */
    public zp3 T0(j jVar) {
        jVar.getClass();
        return jVar != M0() ? new bq3(this, jVar) : this;
    }

    @Override // defpackage.pj0
    public zp3 W0() {
        return this.b;
    }
}
