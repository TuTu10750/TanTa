package defpackage;

import com.zzhoujay.richtext.ImageHolder;

/* loaded from: /tmp/classes2.dex */
public abstract /* synthetic */ class p14 {
    public static final int a(String str, int i, int i2, int i3) {
        return (int) n14.c(str, i, i2, i3);
    }

    public static final long b(String str, long j, long j2, long j3) {
        String d = n14.d(str);
        if (d == null) {
            return j;
        }
        Long r = ew3.r(d);
        if (r == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d + '\'').toString());
        }
        long longValue = r.longValue();
        if (j2 <= longValue && longValue <= j3) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String d = n14.d(str);
        return d == null ? str2 : d;
    }

    public static final boolean d(String str, boolean z) {
        String d = n14.d(str);
        return d != null ? Boolean.parseBoolean(d) : z;
    }

    public static /* synthetic */ int e(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = ImageHolder.MATCH_PARENT;
        }
        return n14.b(str, i, i2, i3);
    }

    public static /* synthetic */ long f(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return n14.c(str, j, j4, j3);
    }
}
