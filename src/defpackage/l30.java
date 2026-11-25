package defpackage;

import android.util.SparseIntArray;

/* loaded from: /tmp/classes2.dex */
public abstract class l30 {
    public static SparseIntArray a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.put(1, q83.h1);
        a.put(2, q83.l1);
        a.put(3, q83.i1);
    }

    public static int a(int i) {
        return a.get(i);
    }

    public static int b(int i) {
        return i == 1 ? q83.A1 : q83.z1;
    }
}
