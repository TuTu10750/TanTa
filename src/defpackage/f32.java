package defpackage;

import android.util.SparseIntArray;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class f32 {
    public static SparseIntArray a;
    public static SparseIntArray b;
    public static List c;
    public static SparseIntArray d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.put(1, t83.h0);
        a.put(2, t83.i0);
        a.put(3, t83.j0);
        a.put(4, t83.k0);
        a.put(5, t83.l0);
        a.put(6, t83.m0);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        b = sparseIntArray2;
        sparseIntArray2.put(0, t83.R);
        b.put(1, t83.S);
        b.put(2, t83.T);
        b.put(3, t83.U);
        b.put(4, t83.V);
        b.put(5, t83.W);
        b.put(6, t83.X);
        b.put(7, t83.Y);
        b.put(8, t83.Z);
        b.put(9, t83.a0);
        c = Arrays.asList(Integer.valueOf(t83.Y0), Integer.valueOf(t83.Z0), Integer.valueOf(t83.a1), Integer.valueOf(t83.b1), Integer.valueOf(t83.c1), Integer.valueOf(t83.d1), Integer.valueOf(t83.e1), Integer.valueOf(t83.f1), Integer.valueOf(t83.g1), Integer.valueOf(t83.h1), Integer.valueOf(t83.i1), Integer.valueOf(t83.j1), Integer.valueOf(t83.k1), Integer.valueOf(t83.l1), Integer.valueOf(t83.m1), Integer.valueOf(t83.n1), Integer.valueOf(t83.o1), Integer.valueOf(t83.p1), Integer.valueOf(t83.q1));
        a();
    }

    public static void a() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        sparseIntArray.put(0, t83.e);
        d.put(1, t83.f);
        d.put(2, t83.g);
        d.put(3, t83.h);
        d.put(4, t83.i);
        d.put(5, t83.j);
        d.put(6, t83.k);
        d.put(7, t83.l);
        d.put(8, t83.m);
        d.put(9, t83.n);
        d.put(10, t83.o);
        d.put(11, t83.p);
        d.put(12, t83.q);
        d.put(13, t83.r);
        d.put(14, t83.s);
        d.put(15, t83.t);
    }

    public static int b(int i) {
        return b.get(i);
    }

    public static List c() {
        return c;
    }

    public static SparseIntArray d() {
        if (d == null) {
            a();
        }
        return d;
    }
}
