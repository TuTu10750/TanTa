package defpackage;

import com.zzhoujay.richtext.ImageHolder;

/* loaded from: /tmp/classes2.dex */
public abstract class ew3 extends dw3 {
    public static Integer p(String str) {
        str.getClass();
        return q(str, 10);
    }

    public static final Integer q(String str, int i) {
        boolean z;
        int i2;
        int i3;
        str.getClass();
        jy.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        int i5 = -2147483647;
        if (dq1.b(charAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i5 = ImageHolder.WRAP_CONTENT;
                z = true;
            }
        } else {
            z = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int b = jy.b(str.charAt(i2), i);
            if (b < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / i))) || (i3 = i4 * i) < i5 + b) {
                return null;
            }
            i4 = i3 - b;
            i2++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static Long r(String str) {
        str.getClass();
        return s(str, 10);
    }

    public static final Long s(String str, int i) {
        boolean z;
        str.getClass();
        jy.a(i);
        int length = str.length();
        Long l = null;
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (dq1.b(charAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z = false;
                i2 = 1;
            } else {
                if (charAt != '-') {
                    return null;
                }
                j = Long.MIN_VALUE;
                i2 = 1;
            }
        } else {
            z = false;
        }
        long j2 = 0;
        long j3 = -256204778801521550L;
        while (i2 < length) {
            int b = jy.b(str.charAt(i2), i);
            if (b < 0) {
                return l;
            }
            if (j2 < j3) {
                if (j3 != -256204778801521550L) {
                    return l;
                }
                j3 = j / i;
                if (j2 < j3) {
                    return l;
                }
            }
            Long l2 = l;
            int i3 = i2;
            long j4 = j2 * i;
            long j5 = b;
            if (j4 < j + j5) {
                return l2;
            }
            j2 = j4 - j5;
            i2 = i3 + 1;
            l = l2;
        }
        return z ? Long.valueOf(j2) : Long.valueOf(-j2);
    }
}
