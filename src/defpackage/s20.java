package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: /tmp/classes2.dex */
public abstract class s20 extends r20 {
    public static final Collection g(Object[] objArr, boolean z) {
        objArr.getClass();
        return new ab(objArr, z);
    }

    public static /* synthetic */ Collection h(Object[] objArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return g(objArr, z);
    }

    public static final int i(List list, Comparable comparable, int i, int i2) {
        list.getClass();
        s(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int a = s30.a((Comparable) list.get(i4), comparable);
            if (a < 0) {
                i = i4 + 1;
            } else {
                if (a <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int j(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return i(list, comparable, i, i2);
    }

    public static List k() {
        return EmptyList.a;
    }

    public static pp1 l(Collection collection) {
        collection.getClass();
        return new pp1(0, collection.size() - 1);
    }

    public static int m(List list) {
        list.getClass();
        return list.size() - 1;
    }

    public static List n(Object... objArr) {
        objArr.getClass();
        return objArr.length > 0 ? pb.e(objArr) : k();
    }

    public static List o(Object obj) {
        return obj != null ? r20.e(obj) : k();
    }

    public static List p(Object... objArr) {
        objArr.getClass();
        return rb.C(objArr);
    }

    public static List q(Object... objArr) {
        objArr.getClass();
        return objArr.length == 0 ? new ArrayList() : new ArrayList(g(objArr, true));
    }

    public static final List r(List list) {
        list.getClass();
        int size = list.size();
        return size != 0 ? size != 1 ? list : r20.e(list.get(0)) : k();
    }

    public static final void s(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void t() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void u() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
