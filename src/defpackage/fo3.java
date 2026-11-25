package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public abstract class fo3 extends eo3 {
    public static Set i(Set set, Iterable iterable) {
        set.getClass();
        iterable.getClass();
        Collection<?> C = x20.C(iterable);
        if (C.isEmpty()) {
            return b30.M0(set);
        }
        if (!(C instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(C);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!((Set) C).contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static Set j(Set set, Object obj) {
        set.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet(sc2.e(set.size()));
        boolean z = false;
        for (Object obj2 : set) {
            boolean z2 = true;
            if (!z && dq1.a(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    public static Set k(Set set, Iterable iterable) {
        int size;
        set.getClass();
        iterable.getClass();
        Integer w = t20.w(iterable);
        if (w != null) {
            size = set.size() + w.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(sc2.e(size));
        linkedHashSet.addAll(set);
        x20.A(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static Set l(Set set, Object obj) {
        set.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet(sc2.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(obj);
        return linkedHashSet;
    }
}
