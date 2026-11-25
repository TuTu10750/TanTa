package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.k;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public abstract class ot3 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends k {
        public final /* synthetic */ List d;

        public a(List list) {
            this.d = list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.k
        public ta4 k(ea4 ea4Var) {
            ea4Var.getClass();
            if (!this.d.contains(ea4Var)) {
                return null;
            }
            z00 v = ea4Var.v();
            v.getClass();
            return n.s((oa4) v);
        }
    }

    public static final fx1 a(List list, List list2, d dVar) {
        fx1 p = TypeSubstitutor.g(new a(list)).p((fx1) b30.b0(list2), Variance.OUT_VARIANCE);
        if (p == null) {
            p = dVar.y();
        }
        p.getClass();
        return p;
    }

    public static final fx1 b(oa4 oa4Var) {
        oa4Var.getClass();
        ra0 b = oa4Var.b();
        b.getClass();
        if (b instanceof a10) {
            List parameters = ((a10) b).k().getParameters();
            parameters.getClass();
            ArrayList arrayList = new ArrayList(t20.v(parameters, 10));
            Iterator it = parameters.iterator();
            while (it.hasNext()) {
                ea4 k = ((oa4) it.next()).k();
                k.getClass();
                arrayList.add(k);
            }
            List upperBounds = oa4Var.getUpperBounds();
            upperBounds.getClass();
            return a(arrayList, upperBounds, DescriptorUtilsKt.j(oa4Var));
        }
        if (!(b instanceof e)) {
            ik.a("Unsupported descriptor type to build star projection type based on type parameters of it");
            return null;
        }
        List typeParameters = ((e) b).getTypeParameters();
        typeParameters.getClass();
        ArrayList arrayList2 = new ArrayList(t20.v(typeParameters, 10));
        Iterator it2 = typeParameters.iterator();
        while (it2.hasNext()) {
            ea4 k2 = ((oa4) it2.next()).k();
            k2.getClass();
            arrayList2.add(k2);
        }
        List upperBounds2 = oa4Var.getUpperBounds();
        upperBounds2.getClass();
        return a(arrayList2, upperBounds2, DescriptorUtilsKt.j(oa4Var));
    }
}
