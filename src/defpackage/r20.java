package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;

/* loaded from: /tmp/classes2.dex */
public abstract class r20 {
    public static List a(List list) {
        list.getClass();
        return ((ListBuilder) list).t();
    }

    public static final Object[] b(Object[] objArr, boolean z) {
        objArr.getClass();
        if (z && dq1.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        copyOf.getClass();
        return copyOf;
    }

    public static List c() {
        return new ListBuilder(0, 1, null);
    }

    public static List d(int i) {
        return new ListBuilder(i);
    }

    public static List e(Object obj) {
        List singletonList = Collections.singletonList(obj);
        singletonList.getClass();
        return singletonList;
    }

    public static Object[] f(int i, Object[] objArr) {
        objArr.getClass();
        if (i < objArr.length) {
            objArr[i] = null;
        }
        return objArr;
    }
}
