package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public final class rw implements oa4 {
    public final oa4 a;
    public final ra0 b;
    public final int c;

    public rw(oa4 oa4Var, ra0 ra0Var, int i) {
        oa4Var.getClass();
        ra0Var.getClass();
        this.a = oa4Var;
        this.b = ra0Var;
        this.c = i;
    }

    @Override // defpackage.oa4
    public boolean E() {
        return this.a.E();
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return this.a.W(va0Var, obj);
    }

    @Override // defpackage.z00
    public oa4 a() {
        oa4 a = this.a.a();
        a.getClass();
        return a;
    }

    @Override // defpackage.ta0
    public ra0 b() {
        return this.b;
    }

    @Override // defpackage.oa4
    public lu3 g0() {
        return this.a.g0();
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // defpackage.oa4
    public int getIndex() {
        return this.c + this.a.getIndex();
    }

    @Override // defpackage.ep2
    public zo2 getName() {
        return this.a.getName();
    }

    @Override // defpackage.oa4
    public List getUpperBounds() {
        return this.a.getUpperBounds();
    }

    @Override // defpackage.xa0
    public xr3 j() {
        return this.a.j();
    }

    @Override // defpackage.oa4, defpackage.z00
    public ea4 k() {
        return this.a.k();
    }

    @Override // defpackage.oa4
    public boolean m0() {
        return true;
    }

    @Override // defpackage.oa4
    public Variance p() {
        return this.a.p();
    }

    public String toString() {
        return this.a + "[inner-copy]";
    }

    @Override // defpackage.z00
    public zp3 u() {
        return this.a.u();
    }
}
