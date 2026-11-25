package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class ue4 {
    public static final long a(String str, int i, int i2) {
        long j;
        str.getClass();
        long j2 = 0;
        if (i < 0) {
            se4.a("beginIndex < 0: ", i);
            return 0L;
        }
        if (i2 < i) {
            re4.a("endIndex < beginIndex: ", i2, " < ", i);
            return 0L;
        }
        if (i2 > str.length()) {
            re4.a("endIndex > string.length: ", i2, " > ", str.length());
            return 0L;
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                j2++;
            } else {
                if (charAt < 2048) {
                    j = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    j = 3;
                } else {
                    int i3 = i + 1;
                    char charAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j2++;
                        i = i3;
                    } else {
                        j2 += 4;
                        i += 2;
                    }
                }
                j2 += j;
            }
            i++;
        }
        return j2;
    }

    public static /* synthetic */ long b(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return a(str, i, i2);
    }
}
