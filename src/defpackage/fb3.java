package defpackage;

import defpackage.np1;

/* loaded from: /tmp/classes2.dex */
public abstract class fb3 extends eb3 {
    public static float b(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int c(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long d(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static double e(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static float f(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int g(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long h(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static int i(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static long j(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static np1 k(int i, int i2) {
        return np1.d.a(i, i2, -1);
    }

    public static np1 l(np1 np1Var, int i) {
        np1Var.getClass();
        eb3.a(i > 0, Integer.valueOf(i));
        np1.a aVar = np1.d;
        int g = np1Var.g();
        int h = np1Var.h();
        if (np1Var.i() <= 0) {
            i = -i;
        }
        return aVar.a(g, h, i);
    }

    public static pp1 m(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? pp1.e.a() : new pp1(i, i2 - 1);
    }
}
