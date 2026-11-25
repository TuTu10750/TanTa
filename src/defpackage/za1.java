package defpackage;

import android.util.SparseIntArray;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class za1 {
    public static SparseIntArray a;
    public static SparseIntArray b;
    public static Map c;
    public static Map d;
    public static SparseIntArray e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.put(1, r83.e);
        a.put(3, r83.l);
        a.put(4, r83.d);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        b = sparseIntArray2;
        sparseIntArray2.put(1, c93.i);
        b.put(3, c93.j);
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put("1-1", Integer.valueOf(r83.s));
        c.put("1-2", Integer.valueOf(r83.t));
        c.put("1-3", Integer.valueOf(r83.u));
        c.put("1-4", Integer.valueOf(r83.v));
        c.put("1-5", Integer.valueOf(r83.w));
        c.put("1-6", Integer.valueOf(r83.x));
        c.put("1-7", Integer.valueOf(r83.y));
        c.put("1-8", Integer.valueOf(r83.z));
        c.put("1-9", Integer.valueOf(r83.A));
        c.put("1-10", Integer.valueOf(r83.B));
        c.put("1-11", Integer.valueOf(r83.C));
        c.put("1-12", Integer.valueOf(r83.D));
        c.put("1-13", Integer.valueOf(r83.E));
        c.put("1-14", Integer.valueOf(r83.s));
        c.put("2-1", Integer.valueOf(r83.F));
        c.put("2-2", Integer.valueOf(r83.G));
        c.put("2-3", Integer.valueOf(r83.H));
        c.put("2-4", Integer.valueOf(r83.I));
        c.put("2-5", Integer.valueOf(r83.J));
        c.put("2-6", Integer.valueOf(r83.K));
        c.put("2-7", Integer.valueOf(r83.L));
        c.put("2-8", Integer.valueOf(r83.M));
        c.put("2-9", Integer.valueOf(r83.N));
        c.put("2-10", Integer.valueOf(r83.O));
        c.put("2-11", Integer.valueOf(r83.P));
        c.put("2-12", Integer.valueOf(r83.Q));
        c.put("2-13", Integer.valueOf(r83.R));
        c.put("2-14", Integer.valueOf(r83.F));
        c.put("3-1", Integer.valueOf(r83.S));
        c.put("3-2", Integer.valueOf(r83.T));
        c.put("3-3", Integer.valueOf(r83.U));
        c.put("3-4", Integer.valueOf(r83.V));
        c.put("3-5", Integer.valueOf(r83.W));
        c.put("3-6", Integer.valueOf(r83.X));
        c.put("3-7", Integer.valueOf(r83.Y));
        c.put("3-8", Integer.valueOf(r83.Z));
        c.put("3-9", Integer.valueOf(r83.a0));
        c.put("3-10", Integer.valueOf(r83.b0));
        c.put("3-11", Integer.valueOf(r83.c0));
        c.put("3-12", Integer.valueOf(r83.d0));
        c.put("3-13", Integer.valueOf(r83.e0));
        c.put("3-14", Integer.valueOf(r83.S));
        c.put("4-1", Integer.valueOf(r83.f0));
        c.put("4-2", Integer.valueOf(r83.g0));
        c.put("4-3", Integer.valueOf(r83.h0));
        c.put("4-4", Integer.valueOf(r83.i0));
        c.put("4-5", Integer.valueOf(r83.j0));
        c.put("4-6", Integer.valueOf(r83.k0));
        c.put("4-7", Integer.valueOf(r83.l0));
        c.put("4-8", Integer.valueOf(r83.m0));
        c.put("4-9", Integer.valueOf(r83.n0));
        c.put("4-10", Integer.valueOf(r83.o0));
        c.put("4-11", Integer.valueOf(r83.p0));
        c.put("4-12", Integer.valueOf(r83.q0));
        c.put("4-13", Integer.valueOf(r83.r0));
        c.put("4-14", Integer.valueOf(r83.f0));
        HashMap hashMap2 = new HashMap();
        d = hashMap2;
        hashMap2.put(SdkVersion.MINI_VERSION, Integer.valueOf(r83.g));
        d.put("2", Integer.valueOf(r83.h));
        d.put("3", Integer.valueOf(r83.i));
        d.put("4", Integer.valueOf(r83.j));
        d.put("5", Integer.valueOf(r83.k));
        d.put("6", Integer.valueOf(r83.f));
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        e = sparseIntArray3;
        sparseIntArray3.put(1, r83.m);
        e.put(2, r83.n);
        e.put(3, r83.o);
        e.put(4, r83.p);
    }

    public static int a(int i) {
        return a.get(i);
    }

    public static int b(int i) {
        return b.get(i);
    }

    public static int c(String str) {
        return ((Integer) d.get(str)).intValue();
    }

    public static int d(int i) {
        return e.get(i);
    }

    public static int e(String str) {
        return ((Integer) c.get(str)).intValue();
    }
}
