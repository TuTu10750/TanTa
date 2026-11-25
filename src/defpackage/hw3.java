package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: /tmp/classes2.dex */
public abstract class hw3 extends fw3 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements bn3 {
        public final /* synthetic */ CharSequence a;

        public a(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // defpackage.bn3
        public Iterator iterator() {
            return new iz1(this.a);
        }
    }

    public static final String A0(CharSequence charSequence, pp1 pp1Var) {
        charSequence.getClass();
        pp1Var.getClass();
        return charSequence.subSequence(pp1Var.n().intValue(), pp1Var.m().intValue() + 1).toString();
    }

    public static final String B0(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int Z = Z(str, c, 0, false, 6, null);
        return Z == -1 ? str2 : str.substring(Z + 1, str.length());
    }

    public static String C0(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int a0 = a0(str, str2, 0, false, 6, null);
        return a0 == -1 ? str3 : str.substring(a0 + str2.length(), str.length());
    }

    public static /* synthetic */ String D0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return B0(str, c, str2);
    }

    public static /* synthetic */ String E0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return C0(str, str2, str3);
    }

    public static String F0(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int f0 = f0(str, c, 0, false, 6, null);
        return f0 == -1 ? str2 : str.substring(f0 + 1, str.length());
    }

    public static /* synthetic */ String G0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return F0(str, c, str2);
    }

    public static final String H0(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int Z = Z(str, c, 0, false, 6, null);
        return Z == -1 ? str2 : str.substring(0, Z);
    }

    public static final String I0(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int a0 = a0(str, str2, 0, false, 6, null);
        return a0 == -1 ? str3 : str.substring(0, a0);
    }

    public static /* synthetic */ String J0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return H0(str, c, str2);
    }

    public static /* synthetic */ String K0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return I0(str, str2, str3);
    }

    public static final boolean L(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return Z(charSequence, c, 0, z, 2, null) >= 0;
    }

    public static final String L0(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int f0 = f0(str, c, 0, false, 6, null);
        return f0 == -1 ? str2 : str.substring(0, f0);
    }

    public static final boolean M(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return charSequence2 instanceof String ? a0(charSequence, (String) charSequence2, 0, z, 2, null) >= 0 : Y(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    public static String M0(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        int g0 = g0(str, str2, 0, false, 6, null);
        return g0 == -1 ? str3 : str.substring(0, g0);
    }

    public static /* synthetic */ boolean N(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return L(charSequence, c, z);
    }

    public static /* synthetic */ String N0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return L0(str, c, str2);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return M(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String O0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return M0(str, str2, str3);
    }

    public static final boolean P(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return charSequence.length() > 0 && ky.d(charSequence.charAt(U(charSequence)), c, z);
    }

    public static CharSequence P0(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean c = jy.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!c) {
                    break;
                }
                length--;
            } else if (c) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final boolean Q(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? fw3.w((String) charSequence, (String) charSequence2, false, 2, null) : n0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static String Q0(String str, char... cArr) {
        str.getClass();
        cArr.getClass();
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = rb.z(cArr, str.charAt(!z ? i : length));
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static /* synthetic */ boolean R(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return P(charSequence, c, z);
    }

    public static String R0(String str, char... cArr) {
        CharSequence charSequence;
        str.getClass();
        cArr.getClass();
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!rb.z(cArr, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static /* synthetic */ boolean S(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Q(charSequence, charSequence2, z);
    }

    public static pp1 T(CharSequence charSequence) {
        charSequence.getClass();
        return new pp1(0, charSequence.length() - 1);
    }

    public static int U(CharSequence charSequence) {
        charSequence.getClass();
        return charSequence.length() - 1;
    }

    public static final int V(CharSequence charSequence, char c, int i, boolean z) {
        charSequence.getClass();
        return (z || !(charSequence instanceof String)) ? b0(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static final int W(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? Y(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static final int X(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        np1 pp1Var = !z2 ? new pp1(fb3.c(i, 0), fb3.g(i2, charSequence.length())) : fb3.k(fb3.g(i, U(charSequence)), fb3.c(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int g = pp1Var.g();
            int h = pp1Var.h();
            int i3 = pp1Var.i();
            if ((i3 <= 0 || g > h) && (i3 >= 0 || h > g)) {
                return -1;
            }
            int i4 = g;
            while (true) {
                String str = (String) charSequence2;
                boolean z3 = z;
                if (fw3.z(str, 0, (String) charSequence, i4, str.length(), z3)) {
                    return i4;
                }
                if (i4 == h) {
                    return -1;
                }
                i4 += i3;
                z = z3;
            }
        } else {
            boolean z4 = z;
            int g2 = pp1Var.g();
            int h2 = pp1Var.h();
            int i5 = pp1Var.i();
            if ((i5 <= 0 || g2 > h2) && (i5 >= 0 || h2 > g2)) {
                return -1;
            }
            int i6 = g2;
            while (true) {
                boolean z5 = z4;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z4 = z5;
                if (n0(charSequence4, 0, charSequence3, i6, charSequence2.length(), z5)) {
                    return i6;
                }
                if (i6 == h2) {
                    return -1;
                }
                i6 += i5;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static /* synthetic */ int Y(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return X(charSequence, charSequence2, i, i2, z, z2);
    }

    public static /* synthetic */ int Z(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return V(charSequence, c, i, z);
    }

    public static /* synthetic */ int a0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return W(charSequence, str, i, z);
    }

    public static final int b0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        cArr.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(rb.V(cArr), i);
        }
        int c = fb3.c(i, 0);
        int U = U(charSequence);
        if (c > U) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(c);
            for (char c2 : cArr) {
                if (ky.d(c2, charAt, z)) {
                    return c;
                }
            }
            if (c == U) {
                return -1;
            }
            c++;
        }
    }

    public static boolean c0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!jy.c(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final int d0(CharSequence charSequence, char c, int i, boolean z) {
        charSequence.getClass();
        return (z || !(charSequence instanceof String)) ? h0(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static final int e0(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? X(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = U(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return d0(charSequence, c, i, z);
    }

    public static /* synthetic */ int g0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = U(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return e0(charSequence, str, i, z);
    }

    public static final int h0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        cArr.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(rb.V(cArr), i);
        }
        for (int g = fb3.g(i, U(charSequence)); -1 < g; g--) {
            char charAt = charSequence.charAt(g);
            for (char c : cArr) {
                if (ky.d(c, charAt, z)) {
                    return g;
                }
            }
        }
        return -1;
    }

    public static bn3 i0(CharSequence charSequence) {
        charSequence.getClass();
        return new a(charSequence);
    }

    public static final List j0(CharSequence charSequence) {
        charSequence.getClass();
        return SequencesKt___SequencesKt.S(i0(charSequence));
    }

    public static final bn3 k0(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        s0(i2);
        return new vj0(charSequence, i, i2, new b91() { // from class: gw3
            @Override // defpackage.b91
            public final Object invoke(Object obj, Object obj2) {
                Pair m0;
                m0 = hw3.m0(cArr, z, (CharSequence) obj, ((Integer) obj2).intValue());
                return m0;
            }
        });
    }

    public static /* synthetic */ bn3 l0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return k0(charSequence, cArr, i, z, i2);
    }

    public static final Pair m0(char[] cArr, boolean z, CharSequence charSequence, int i) {
        charSequence.getClass();
        int b0 = b0(charSequence, cArr, i, z);
        if (b0 < 0) {
            return null;
        }
        return g94.a(Integer.valueOf(b0), 1);
    }

    public static final boolean n0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!ky.d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String o0(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return z0(str, charSequence, false, 2, null) ? str.substring(charSequence.length()) : str;
    }

    public static String p0(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return S(str, charSequence, false, 2, null) ? str.substring(0, str.length() - charSequence.length()) : str;
    }

    public static String q0(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return r0(str, charSequence, charSequence);
    }

    public static final String r0(String str, CharSequence charSequence, CharSequence charSequence2) {
        str.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        return (str.length() >= charSequence.length() + charSequence2.length() && z0(str, charSequence, false, 2, null) && S(str, charSequence2, false, 2, null)) ? str.substring(charSequence.length(), str.length() - charSequence2.length()) : str;
    }

    public static final void s0(int i) {
        if (i >= 0) {
            return;
        }
        se4.a("Limit must be non-negative, but was ", i);
    }

    public static final List t0(CharSequence charSequence, char[] cArr, boolean z, int i) {
        charSequence.getClass();
        cArr.getClass();
        if (cArr.length == 1) {
            return u0(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable w = SequencesKt___SequencesKt.w(l0(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(t20.v(w, 10));
        Iterator it = w.iterator();
        while (it.hasNext()) {
            arrayList.add(A0(charSequence, (pp1) it.next()));
        }
        return arrayList;
    }

    public static final List u0(CharSequence charSequence, String str, boolean z, int i) {
        s0(i);
        int i2 = 0;
        int W = W(charSequence, str, 0, z);
        if (W == -1 || i == 1) {
            return r20.e(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? fb3.g(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, W).toString());
            i2 = str.length() + W;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            W = W(charSequence, str, i2, z);
        } while (W != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List v0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return t0(charSequence, cArr, z, i);
    }

    public static final boolean w0(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return charSequence.length() > 0 && ky.d(charSequence.charAt(0), c, z);
    }

    public static final boolean x0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? fw3.J((String) charSequence, (String) charSequence2, false, 2, null) : n0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean y0(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return w0(charSequence, c, z);
    }

    public static /* synthetic */ boolean z0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return x0(charSequence, charSequence2, z);
    }
}
