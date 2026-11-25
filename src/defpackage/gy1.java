package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public final class gy1 extends o1 {
    public final ey1 k;
    public final gt1 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy1(ey1 ey1Var, gt1 gt1Var, int i, ra0 ra0Var) {
        super(ey1Var.e(), ra0Var, new LazyJavaAnnotations(ey1Var, gt1Var, false, 4, null), gt1Var.getName(), Variance.INVARIANT, false, i, xr3.a, ey1Var.a().v());
        ey1Var.getClass();
        gt1Var.getClass();
        ra0Var.getClass();
        this.k = ey1Var;
        this.l = gt1Var;
    }

    @Override // defpackage.g2
    public List F0(List list) {
        list.getClass();
        return this.k.a().r().i(this, list, this.k);
    }

    @Override // defpackage.g2
    public void K0(fx1 fx1Var) {
        fx1Var.getClass();
    }

    @Override // defpackage.g2
    public List L0() {
        return M0();
    }

    public final List M0() {
        Collection upperBounds = this.l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            zp3 i = this.k.d().q().i();
            i.getClass();
            zp3 I = this.k.d().q().I();
            I.getClass();
            return r20.e(KotlinTypeFactory.d(i, I));
        }
        ArrayList arrayList = new ArrayList(t20.v(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            gy1 gy1Var = this;
            arrayList.add(this.k.g().o((ur1) it.next(), et1.b(TypeUsage.COMMON, false, false, gy1Var, 3, null)));
            this = gy1Var;
        }
        return arrayList;
    }
}
