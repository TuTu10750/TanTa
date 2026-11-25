package defpackage;

import java.util.Comparator;

/* loaded from: /tmp/classes2.dex */
public abstract class fw3 extends ew3 {
    public static /* synthetic */ boolean A(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return z(str, i, str2, i2, i3, z);
    }

    public static String B(CharSequence charSequence, int i) {
        charSequence.getClass();
        if (i < 0) {
            sm.a("Count 'n' must be non-negative, but was ", i, 46);
            return null;
        }
        if (i == 0) {
            return "";
        }
        int i2 = 1;
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length != 1) {
            StringBuilder sb = new StringBuilder(charSequence.length() * i);
            if (1 <= i) {
                while (true) {
                    sb.append(charSequence);
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
            return sb.toString();
        }
        char charAt = charSequence.charAt(0);
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = charAt;
        }
        return new String(cArr);
    }

    public static final String C(String str, char c, char c2, boolean z) {
        str.getClass();
        if (!z) {
            String replace = str.replace(c, c2);
            replace.getClass();
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (ky.d(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static final String D(String str, String str2, String str3, boolean z) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int i = 0;
        int W = hw3.W(str, str2, 0, z);
        if (W < 0) {
            return str;
        }
        int length = str2.length();
        int c = fb3.c(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, W);
            sb.append(str3);
            i = W + length;
            if (W >= str.length()) {
                break;
            }
            W = hw3.W(str, str2, W + c, z);
        } while (W > 0);
        sb.append((CharSequence) str, i, str.length());
        return sb.toString();
    }

    public static /* synthetic */ String E(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return C(str, c, c2, z);
    }

    public static /* synthetic */ String F(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return D(str, str2, str3, z);
    }

    public static boolean G(String str, String str2, int i, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.startsWith(str2, i) : z(str, i, str2, 0, str2.length(), z);
    }

    public static boolean H(String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.startsWith(str2) : z(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean I(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return G(str, str2, i, z);
    }

    public static /* synthetic */ boolean J(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return H(str, str2, z);
    }

    public static String t(char[] cArr) {
        cArr.getClass();
        return new String(cArr);
    }

    public static String u(char[] cArr, int i, int i2) {
        cArr.getClass();
        p1.a.a(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    public static boolean v(String str, String str2, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.endsWith(str2) : z(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean w(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return v(str, str2, z);
    }

    public static boolean x(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Comparator y(ov3 ov3Var) {
        ov3Var.getClass();
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        comparator.getClass();
        return comparator;
    }

    public static final boolean z(String str, int i, String str2, int i2, int i3, boolean z) {
        str.getClass();
        str2.getClass();
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }
}
