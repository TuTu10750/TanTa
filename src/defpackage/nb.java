package defpackage;

import java.lang.reflect.Array;

/* loaded from: /tmp/classes2.dex */
public abstract class nb {
    public static final Object[] a(Object[] objArr, int i) {
        objArr.getClass();
        Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
        newInstance.getClass();
        return (Object[]) newInstance;
    }

    public static final void b(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }
}
