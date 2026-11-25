package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public abstract class b30 extends z20 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements bn3 {
        public final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // defpackage.bn3
        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    public static Object A0(List list) {
        list.getClass();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List B0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            List J0 = J0(iterable);
            w20.y(J0);
            return J0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return I0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        pb.t((Comparable[]) array);
        return pb.e(array);
    }

    public static List C0(Iterable iterable, Comparator comparator) {
        iterable.getClass();
        comparator.getClass();
        if (!(iterable instanceof Collection)) {
            List J0 = J0(iterable);
            w20.z(J0, comparator);
            return J0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return I0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        pb.u(array, comparator);
        return pb.e(array);
    }

    public static List D0(Iterable iterable, int i) {
        iterable.getClass();
        if (i < 0) {
            ll3.a("Requested element count ", i, " is less than zero.");
            return null;
        }
        if (i == 0) {
            return s20.k();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return I0(iterable);
            }
            if (i == 1) {
                return r20.e(a0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return s20.r(arrayList);
    }

    public static List E0(List list, int i) {
        list.getClass();
        if (i < 0) {
            ll3.a("Requested element count ", i, " is less than zero.");
            return null;
        }
        if (i == 0) {
            return s20.k();
        }
        int size = list.size();
        if (i >= size) {
            return I0(list);
        }
        if (i == 1) {
            return r20.e(m0(list));
        }
        ArrayList arrayList = new ArrayList(i);
        if (list instanceof RandomAccess) {
            for (int i2 = size - i; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
        } else {
            ListIterator listIterator = list.listIterator(size - i);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static byte[] F0(Collection collection) {
        collection.getClass();
        byte[] bArr = new byte[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((Number) it.next()).byteValue();
            i++;
        }
        return bArr;
    }

    public static final Collection G0(Iterable iterable, Collection collection) {
        iterable.getClass();
        collection.getClass();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static int[] H0(Collection collection) {
        collection.getClass();
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List I0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return s20.r(J0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return s20.k();
        }
        if (size != 1) {
            return K0(collection);
        }
        return r20.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List J0(Iterable iterable) {
        iterable.getClass();
        return iterable instanceof Collection ? K0((Collection) iterable) : (List) G0(iterable, new ArrayList());
    }

    public static List K0(Collection collection) {
        collection.getClass();
        return new ArrayList(collection);
    }

    public static Set L0(Iterable iterable) {
        iterable.getClass();
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) G0(iterable, new LinkedHashSet());
    }

    public static Set M0(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            return eo3.g((Set) G0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return eo3.e();
        }
        if (size != 1) {
            return (Set) G0(iterable, new LinkedHashSet(sc2.e(collection.size())));
        }
        return do3.d(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static Set N0(Iterable iterable, Iterable iterable2) {
        iterable.getClass();
        iterable2.getClass();
        Set L0 = L0(iterable);
        x20.A(L0, iterable2);
        return L0;
    }

    public static Iterable O0(final Iterable iterable) {
        iterable.getClass();
        return new do1(new l81() { // from class: a30
            @Override // defpackage.l81
            public final Object invoke() {
                Iterator P0;
                P0 = b30.P0(iterable);
                return P0;
            }
        });
    }

    public static final Iterator P0(Iterable iterable) {
        return iterable.iterator();
    }

    public static List Q0(Iterable iterable, Iterable iterable2) {
        iterable.getClass();
        iterable2.getClass();
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t20.v(iterable, 10), t20.v(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(g94.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static boolean R(Iterable iterable, n81 n81Var) {
        iterable.getClass();
        n81Var.getClass();
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!((Boolean) n81Var.invoke(it.next())).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static bn3 S(Iterable iterable) {
        iterable.getClass();
        return new a(iterable);
    }

    public static boolean T(Iterable iterable, Object obj) {
        iterable.getClass();
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : f0(iterable, obj) >= 0;
    }

    public static List U(Iterable iterable) {
        iterable.getClass();
        return I0(L0(iterable));
    }

    public static List V(Iterable iterable, int i) {
        ArrayList arrayList;
        iterable.getClass();
        if (i < 0) {
            ll3.a("Requested element count ", i, " is less than zero.");
            return null;
        }
        if (i == 0) {
            return I0(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i;
            if (size <= 0) {
                return s20.k();
            }
            if (size == 1) {
                return r20.e(l0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i < size2) {
                        arrayList.add(list.get(i));
                        i++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= i) {
                arrayList.add(obj);
            } else {
                i2++;
            }
        }
        return s20.r(arrayList);
    }

    public static List W(List list, int i) {
        list.getClass();
        if (i >= 0) {
            return D0(list, fb3.c(list.size() - i, 0));
        }
        ll3.a("Requested element count ", i, " is less than zero.");
        return null;
    }

    public static List X(Iterable iterable, n81 n81Var) {
        iterable.getClass();
        n81Var.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((Boolean) n81Var.invoke(obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static List Y(Iterable iterable) {
        iterable.getClass();
        return (List) Z(iterable, new ArrayList());
    }

    public static final Collection Z(Iterable iterable, Collection collection) {
        iterable.getClass();
        collection.getClass();
        for (Object obj : iterable) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static Object a0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            return b0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object b0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object c0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object d0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object e0(List list, int i) {
        list.getClass();
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final int f0(Iterable iterable, Object obj) {
        iterable.getClass();
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                s20.u();
            }
            if (dq1.a(obj, obj2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Set g0(Iterable iterable, Iterable iterable2) {
        iterable.getClass();
        iterable2.getClass();
        Collection C = x20.C(iterable2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : iterable) {
            if (C.contains(obj)) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public static final Appendable h0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n81 n81Var) {
        iterable.getClass();
        appendable.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            vv3.a(appendable, obj, n81Var);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static /* synthetic */ Appendable i0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n81 n81Var, int i2, Object obj) {
        return h0(iterable, appendable, (i2 & 2) != 0 ? ", " : charSequence, (i2 & 4) != 0 ? "" : charSequence2, (i2 & 8) == 0 ? charSequence3 : "", (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : n81Var);
    }

    public static final String j0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n81 n81Var) {
        iterable.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return ((StringBuilder) h0(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, n81Var)).toString();
    }

    public static /* synthetic */ String k0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n81 n81Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            n81Var = null;
        }
        CharSequence charSequence5 = charSequence4;
        n81 n81Var2 = n81Var;
        return j0(iterable, charSequence, charSequence2, charSequence3, i, charSequence5, n81Var2);
    }

    public static Object l0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            return m0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object m0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(s20.m(list));
    }

    public static Object n0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(list.size() - 1);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static Object o0(List list) {
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static List p0(Iterable iterable, n81 n81Var) {
        iterable.getClass();
        n81Var.getClass();
        ArrayList arrayList = new ArrayList(t20.v(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(n81Var.invoke(it.next()));
        }
        return arrayList;
    }

    public static final Comparable q0(Iterable iterable) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Comparable r0(Iterable iterable) {
        iterable.getClass();
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List s0(Iterable iterable, Object obj) {
        iterable.getClass();
        ArrayList arrayList = new ArrayList(t20.v(iterable, 10));
        boolean z = false;
        for (Object obj2 : iterable) {
            boolean z2 = true;
            if (!z && dq1.a(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    public static List t0(Iterable iterable, Iterable iterable2) {
        iterable.getClass();
        iterable2.getClass();
        if (iterable instanceof Collection) {
            return v0((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        x20.A(arrayList, iterable);
        x20.A(arrayList, iterable2);
        return arrayList;
    }

    public static List u0(Iterable iterable, Object obj) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return w0((Collection) iterable, obj);
        }
        ArrayList arrayList = new ArrayList();
        x20.A(arrayList, iterable);
        arrayList.add(obj);
        return arrayList;
    }

    public static List v0(Collection collection, Iterable iterable) {
        collection.getClass();
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            x20.A(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List w0(Collection collection, Object obj) {
        collection.getClass();
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object x0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            return y0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        ik.a("Collection has more than one element.");
        return null;
    }

    public static Object y0(List list) {
        list.getClass();
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        ik.a("List has more than one element.");
        return null;
    }

    public static Object z0(Iterable iterable) {
        iterable.getClass();
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return list.get(0);
            }
            return null;
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }
}
