package defpackage;

import kotlin.Pair;

/* loaded from: /tmp/classes2.dex */
public final class p40 {
    public final int a = 1440;
    public final int b = 10800;
    public final double c = 0.4d;
    public final long d = 40960000;
    public final long e = 10240000;

    public final q40 a(int i, int i2) {
        int i3;
        if (i <= 0 || i2 <= 0) {
            return new q40(0, 0, 0, false, null, 24, null);
        }
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        double d = min;
        double d2 = d / max;
        long j = i * i2;
        int i4 = this.a;
        int i5 = (int) (i4 / d2);
        if (max >= this.b && d2 > this.c) {
            i5 = i4;
            i4 = (int) (i4 * d2);
        }
        if (j > this.d && (i3 = (int) (d * 0.25d)) < i4) {
            i5 = (int) (i3 / d2);
            i4 = i3;
        }
        if (i4 <= min) {
            min = i4;
            max = i5;
        }
        long j2 = min * max;
        long j3 = this.e;
        if (j2 > j3) {
            double floor = Math.floor(Math.sqrt(j3 / j2) * 1000.0d) / 1000.0d;
            min = (int) (min * floor);
            max = (int) (max * floor);
        }
        int max2 = Math.max(2, (min / 2) * 2);
        int max3 = Math.max(2, (max / 2) * 2);
        Pair pair = i < i2 ? new Pair(Integer.valueOf(max2), Integer.valueOf(max3)) : new Pair(Integer.valueOf(max3), Integer.valueOf(max2));
        int intValue = ((Number) pair.getFirst()).intValue();
        int intValue2 = ((Number) pair.getSecond()).intValue();
        long j4 = intValue * intValue2;
        int max4 = Math.max(20, (int) (j4 * (j4 < 500000 ? 5.0E-4d : j4 < 1000000 ? 1.5E-4d : j4 < 3000000 ? 1.1E-4d : 2.5E-5d)));
        if (d2 < 0.2d && max4 < 400) {
            max4 = Math.max(max4, 250);
        }
        int i6 = max4;
        boolean z = d2 <= 0.5d;
        return new q40(intValue, intValue2, i6, z, z ? Integer.valueOf(i6) : null);
    }
}
