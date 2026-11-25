package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector;
import kotlin.reflect.jvm.internal.impl.types.e;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: /tmp/classes2.dex */
public abstract class cq1 {
    public static final gd4 a(List list) {
        zp3 V0;
        list.getClass();
        int size = list.size();
        if (size == 0) {
            fl3.a("Expected some types");
            return null;
        }
        if (size == 1) {
            return (gd4) b30.y0(list);
        }
        ArrayList arrayList = new ArrayList(t20.v(list, 10));
        Iterator it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            gd4 gd4Var = (gd4) it.next();
            z = z || gx1.a(gd4Var);
            if (gd4Var instanceof zp3) {
                V0 = (zp3) gd4Var;
            } else {
                if (!(gd4Var instanceof l31)) {
                    u.a();
                    return null;
                }
                if (e.a(gd4Var)) {
                    return gd4Var;
                }
                V0 = ((l31) gd4Var).V0();
                z2 = true;
            }
            arrayList.add(V0);
        }
        if (z) {
            return xu0.d(ErrorTypeKind.A0, list.toString());
        }
        if (!z2) {
            return TypeIntersector.a.c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(t20.v(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(q31.d((gd4) it2.next()));
        }
        TypeIntersector typeIntersector = TypeIntersector.a;
        return KotlinTypeFactory.d(typeIntersector.c(arrayList), typeIntersector.c(arrayList2));
    }
}
