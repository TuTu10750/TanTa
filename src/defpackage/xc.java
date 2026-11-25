package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class xc extends d1 {
    public fb a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xc() {
        /*
            r1 = this;
            it0 r0 = defpackage.it0.a
            r0.getClass()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xc.<init>():void");
    }

    public xc(fb fbVar) {
        fbVar.getClass();
        this.a = fbVar;
    }

    @Override // defpackage.d1
    public final fb g() {
        return this.a;
    }

    public final void i(rv1 rv1Var, Object obj) {
        rv1Var.getClass();
        obj.getClass();
        int d = h().d(rv1Var);
        int g = this.a.g();
        if (g == 0) {
            this.a = new vt2(obj, d);
            return;
        }
        if (g == 1) {
            fb fbVar = this.a;
            fbVar.getClass();
            vt2 vt2Var = (vt2) fbVar;
            if (vt2Var.i() == d) {
                this.a = new vt2(obj, d);
                return;
            } else {
                gb gbVar = new gb();
                this.a = gbVar;
                gbVar.h(vt2Var.i(), vt2Var.j());
            }
        }
        this.a.h(d, obj);
    }
}
