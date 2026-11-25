package defpackage;

import android.util.SparseIntArray;

/* loaded from: /tmp/classes2.dex */
public abstract class eb2 {
    public static SparseIntArray a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.put(0, u83.p);
        a.put(1, u83.q);
        a.put(2, u83.r);
        a.put(3, u83.s);
    }

    public static int a(int i) {
        return a.get(i);
    }
}
