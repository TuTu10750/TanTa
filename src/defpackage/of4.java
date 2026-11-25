package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;

/* loaded from: /tmp/classes2.dex */
public abstract class of4 {
    public static final nf4 a(ProtoBuf$Class protoBuf$Class, ap2 ap2Var, cb4 cb4Var, n81 n81Var, n81 n81Var2) {
        aq3 aq3Var;
        List R0;
        protoBuf$Class.getClass();
        ap2Var.getClass();
        cb4Var.getClass();
        n81Var.getClass();
        n81Var2.getClass();
        if (protoBuf$Class.L0() <= 0) {
            if (!protoBuf$Class.n1()) {
                return null;
            }
            zo2 b = cp2.b(ap2Var, protoBuf$Class.I0());
            ProtoBuf$Type i = e43.i(protoBuf$Class, cb4Var);
            if ((i != null && (aq3Var = (aq3) n81Var.invoke(i)) != null) || (aq3Var = (aq3) n81Var2.invoke(b)) != null) {
                return new uo1(b, aq3Var);
            }
            throw new IllegalStateException(("cannot determine underlying type for value class " + cp2.b(ap2Var, protoBuf$Class.E0()) + " with property " + b).toString());
        }
        List<Integer> M0 = protoBuf$Class.M0();
        M0.getClass();
        ArrayList arrayList = new ArrayList(t20.v(M0, 10));
        for (Integer num : M0) {
            num.getClass();
            arrayList.add(cp2.b(ap2Var, num.intValue()));
        }
        Pair a = g94.a(Integer.valueOf(protoBuf$Class.P0()), Integer.valueOf(protoBuf$Class.O0()));
        if (dq1.a(a, g94.a(Integer.valueOf(arrayList.size()), 0))) {
            List<Integer> Q0 = protoBuf$Class.Q0();
            Q0.getClass();
            R0 = new ArrayList(t20.v(Q0, 10));
            for (Integer num2 : Q0) {
                num2.getClass();
                R0.add(cb4Var.a(num2.intValue()));
            }
        } else {
            if (!dq1.a(a, g94.a(0, Integer.valueOf(arrayList.size())))) {
                throw new IllegalStateException(("class " + cp2.b(ap2Var, protoBuf$Class.E0()) + " has illegal multi-field value class representation").toString());
            }
            R0 = protoBuf$Class.R0();
        }
        R0.getClass();
        ArrayList arrayList2 = new ArrayList(t20.v(R0, 10));
        Iterator it = R0.iterator();
        while (it.hasNext()) {
            arrayList2.add(n81Var.invoke(it.next()));
        }
        return new vn2(b30.Q0(arrayList, arrayList2));
    }
}
