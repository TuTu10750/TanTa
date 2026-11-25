package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class tz1 {
    public static final Object[] d(int i) {
        if (i >= 0) {
            return new Object[i];
        }
        ik.a("capacity must be non-negative.");
        return null;
    }

    public static final Object[] e(Object[] objArr, int i) {
        objArr.getClass();
        return Arrays.copyOf(objArr, i);
    }

    public static final void f(Object[] objArr, int i) {
        objArr.getClass();
        objArr[i] = null;
    }

    public static final void g(Object[] objArr, int i, int i2) {
        objArr.getClass();
        while (i < i2) {
            f(objArr, i);
            i++;
        }
    }

    public static final boolean h(Object[] objArr, int i, int i2, List list) {
        if (i2 != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!dq1.a(objArr[i + i3], list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final int i(Object[] objArr, int i, int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i + i4];
            i3 = (i3 * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return i3;
    }

    public static final String j(Object[] objArr, int i, int i2, Collection collection) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i3];
            if (obj == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
