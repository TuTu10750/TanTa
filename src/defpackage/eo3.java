package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptySet;

/* loaded from: /tmp/classes2.dex */
public abstract class eo3 extends do3 {
    public static Set e() {
        return EmptySet.a;
    }

    public static LinkedHashSet f(Object... objArr) {
        objArr.getClass();
        return (LinkedHashSet) rb.b0(objArr, new LinkedHashSet(sc2.e(objArr.length)));
    }

    public static final Set g(Set set) {
        set.getClass();
        int size = set.size();
        return size != 0 ? size != 1 ? set : do3.d(set.iterator().next()) : e();
    }

    public static Set h(Object... objArr) {
        objArr.getClass();
        return rb.u0(objArr);
    }
}
