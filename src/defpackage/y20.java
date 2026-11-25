package defpackage;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class y20 extends x20 {
    public static List L(List list) {
        list.getClass();
        return new oh3(list);
    }

    public static final int M(List list, int i) {
        if (i >= 0 && i <= s20.m(list)) {
            return s20.m(list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new pp1(0, s20.m(list)) + "].");
    }

    public static final int N(List list, int i) {
        return s20.m(list) - i;
    }

    public static final int O(List list, int i) {
        if (i >= 0 && i <= list.size()) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new pp1(0, list.size()) + "].");
    }
}
