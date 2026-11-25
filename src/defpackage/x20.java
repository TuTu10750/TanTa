package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: /tmp/classes2.dex */
public abstract class x20 extends w20 {
    public static boolean A(Collection collection, Iterable iterable) {
        collection.getClass();
        iterable.getClass();
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean B(Collection collection, Object[] objArr) {
        collection.getClass();
        objArr.getClass();
        return collection.addAll(pb.e(objArr));
    }

    public static final Collection C(Iterable iterable) {
        iterable.getClass();
        return iterable instanceof Collection ? (Collection) iterable : b30.I0(iterable);
    }

    public static final boolean D(Iterable iterable, n81 n81Var, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (((Boolean) n81Var.invoke(it.next())).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static final boolean E(List list, n81 n81Var, boolean z) {
        int i;
        if (!(list instanceof RandomAccess)) {
            list.getClass();
            return D(ka4.a(list), n81Var, z);
        }
        int m = s20.m(list);
        if (m >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                Object obj = list.get(i2);
                if (((Boolean) n81Var.invoke(obj)).booleanValue() != z) {
                    if (i != i2) {
                        list.set(i, obj);
                    }
                    i++;
                }
                if (i2 == m) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int m2 = s20.m(list);
        if (i > m2) {
            return true;
        }
        while (true) {
            list.remove(m2);
            if (m2 == i) {
                return true;
            }
            m2--;
        }
    }

    public static boolean F(List list, n81 n81Var) {
        list.getClass();
        n81Var.getClass();
        return E(list, n81Var, true);
    }

    public static Object G(List list) {
        list.getClass();
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(s20.m(list));
    }

    public static Object H(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(s20.m(list));
    }
}
