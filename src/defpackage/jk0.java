package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.k;
import kotlin.reflect.jvm.internal.impl.types.l;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class jk0 {
    public static /* synthetic */ void a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(format);
        }
    }

    public static TypeSubstitutor b(List list, l lVar, ra0 ra0Var, List list2) {
        if (list == null) {
            a(0);
        }
        if (lVar == null) {
            a(1);
        }
        if (ra0Var == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        TypeSubstitutor c = c(list, lVar, ra0Var, list2, null);
        if (c != null) {
            return c;
        }
        jk.a("Substitution failed");
        return null;
    }

    public static TypeSubstitutor c(List list, l lVar, ra0 ra0Var, List list2, boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (lVar == null) {
            a(6);
        }
        if (ra0Var == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            oa4 oa4Var = (oa4) it.next();
            pa4 Q0 = pa4.Q0(ra0Var, oa4Var.getAnnotations(), oa4Var.E(), oa4Var.p(), oa4Var.getName(), i, xr3.a, oa4Var.g0());
            hashMap.put(oa4Var.k(), new va4(Q0.u()));
            hashMap2.put(oa4Var, Q0);
            list2.add(Q0);
            i++;
        }
        k j = k.j(hashMap);
        TypeSubstitutor h = TypeSubstitutor.h(lVar, j);
        TypeSubstitutor h2 = TypeSubstitutor.h(lVar.h(), j);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            oa4 oa4Var2 = (oa4) it2.next();
            pa4 pa4Var = (pa4) hashMap2.get(oa4Var2);
            for (fx1 fx1Var : oa4Var2.getUpperBounds()) {
                z00 v = fx1Var.N0().v();
                fx1 p = (((v instanceof oa4) && TypeUtilsKt.k((oa4) v)) ? h : h2).p(fx1Var, Variance.OUT_VARIANCE);
                if (p == null) {
                    return null;
                }
                if (p != fx1Var && zArr != null) {
                    zArr[0] = true;
                }
                pa4Var.M0(p);
            }
            pa4Var.V0();
        }
        return h;
    }
}
