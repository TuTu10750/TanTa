package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.a;
import kotlin.reflect.jvm.internal.impl.types.k;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class pc2 {
    public static final k a(m00 m00Var, m00 m00Var2) {
        m00Var.getClass();
        m00Var2.getClass();
        m00Var.w().size();
        m00Var2.w().size();
        k.a aVar = k.c;
        List w = m00Var.w();
        w.getClass();
        ArrayList arrayList = new ArrayList(t20.v(w, 10));
        Iterator it = w.iterator();
        while (it.hasNext()) {
            arrayList.add(((oa4) it.next()).k());
        }
        List w2 = m00Var2.w();
        w2.getClass();
        ArrayList arrayList2 = new ArrayList(t20.v(w2, 10));
        Iterator it2 = w2.iterator();
        while (it2.hasNext()) {
            zp3 u = ((oa4) it2.next()).u();
            u.getClass();
            arrayList2.add(TypeUtilsKt.a(u));
        }
        return k.a.e(aVar, a.s(b30.Q0(arrayList, arrayList2)), false, 2, null);
    }
}
