package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class lv2 extends ua0 implements kv2 {
    public final r51 e;
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lv2(mm2 mm2Var, r51 r51Var) {
        super(mm2Var, j8.a0.b(), r51Var.h(), xr3.a);
        mm2Var.getClass();
        r51Var.getClass();
        this.e = r51Var;
        this.f = "package " + r51Var + " of " + mm2Var;
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        va0Var.getClass();
        return va0Var.f(this, obj);
    }

    @Override // defpackage.ua0, defpackage.ra0, defpackage.qf4, defpackage.ta0
    public mm2 b() {
        ra0 b = super.b();
        b.getClass();
        return (mm2) b;
    }

    @Override // defpackage.kv2
    public final r51 d() {
        return this.e;
    }

    @Override // defpackage.ua0, defpackage.xa0
    public xr3 j() {
        xr3 xr3Var = xr3.a;
        xr3Var.getClass();
        return xr3Var;
    }

    @Override // defpackage.sa0
    public String toString() {
        return this.f;
    }
}
