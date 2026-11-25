package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public abstract class rb extends pb {

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterable, bw1 {
        public final /* synthetic */ Object[] a;

        public a(Object[] objArr) {
            this.a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return db.a(this.a);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b implements bn3 {
        public final /* synthetic */ Object[] a;

        public b(Object[] objArr) {
            this.a = objArr;
        }

        @Override // defpackage.bn3
        public Iterator iterator() {
            return db.a(this.a);
        }
    }

    public static final boolean A(int[] iArr, int i) {
        iArr.getClass();
        return L(iArr, i) >= 0;
    }

    public static boolean B(Object[] objArr, Object obj) {
        objArr.getClass();
        return M(objArr, obj) >= 0;
    }

    public static List C(Object[] objArr) {
        objArr.getClass();
        return (List) D(objArr, new ArrayList());
    }

    public static final Collection D(Object[] objArr, Collection collection) {
        objArr.getClass();
        collection.getClass();
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static Object E(Object[] objArr) {
        objArr.getClass();
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object F(Object[] objArr) {
        objArr.getClass();
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static int G(Object[] objArr) {
        objArr.getClass();
        return objArr.length - 1;
    }

    public static Integer H(int[] iArr, int i) {
        iArr.getClass();
        if (i < 0 || i >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static Object I(Object[] objArr, int i) {
        objArr.getClass();
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static final int J(byte[] bArr, byte b2) {
        bArr.getClass();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b2 == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int K(char[] cArr, char c) {
        cArr.getClass();
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int L(int[] iArr, int i) {
        iArr.getClass();
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static int M(Object[] objArr, Object obj) {
        objArr.getClass();
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (dq1.a(obj, objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final Appendable N(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n81 n81Var) {
        objArr.getClass();
        appendable.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            vv3.a(appendable, obj, n81Var);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String P(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n81 n81Var) {
        objArr.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return ((StringBuilder) N(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, n81Var)).toString();
    }

    public static /* synthetic */ String Q(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n81 n81Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            n81Var = null;
        }
        CharSequence charSequence5 = charSequence4;
        n81 n81Var2 = n81Var;
        return P(objArr, charSequence, charSequence2, charSequence3, i, charSequence5, n81Var2);
    }

    public static Object R(Object[] objArr) {
        objArr.getClass();
        if (objArr.length != 0) {
            return objArr[G(objArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int S(byte[] bArr, byte b2) {
        bArr.getClass();
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (b2 == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static final int T(int[] iArr, int i) {
        iArr.getClass();
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static List U(Object[] objArr, n81 n81Var) {
        objArr.getClass();
        n81Var.getClass();
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(n81Var.invoke(obj));
        }
        return arrayList;
    }

    public static char V(char[] cArr) {
        cArr.getClass();
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        ik.a("Array has more than one element.");
        return (char) 0;
    }

    public static Object W(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        ik.a("Array has more than one element.");
        return null;
    }

    public static Object X(Object[] objArr) {
        objArr.getClass();
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static List Y(byte[] bArr, pp1 pp1Var) {
        bArr.getClass();
        pp1Var.getClass();
        return pp1Var.isEmpty() ? s20.k() : pb.c(pb.m(bArr, pp1Var.n().intValue(), pp1Var.m().intValue() + 1));
    }

    public static final Object[] Z(Object[] objArr, Comparator comparator) {
        objArr.getClass();
        comparator.getClass();
        if (objArr.length == 0) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        pb.u(copyOf, comparator);
        return copyOf;
    }

    public static List a0(Object[] objArr, Comparator comparator) {
        objArr.getClass();
        comparator.getClass();
        return pb.e(Z(objArr, comparator));
    }

    public static final Collection b0(Object[] objArr, Collection collection) {
        objArr.getClass();
        collection.getClass();
        for (Object obj : objArr) {
            collection.add(obj);
        }
        return collection;
    }

    public static List c0(byte[] bArr) {
        bArr.getClass();
        int length = bArr.length;
        return length != 0 ? length != 1 ? l0(bArr) : r20.e(Byte.valueOf(bArr[0])) : s20.k();
    }

    public static List d0(char[] cArr) {
        cArr.getClass();
        int length = cArr.length;
        return length != 0 ? length != 1 ? m0(cArr) : r20.e(Character.valueOf(cArr[0])) : s20.k();
    }

    public static List e0(double[] dArr) {
        dArr.getClass();
        int length = dArr.length;
        return length != 0 ? length != 1 ? n0(dArr) : r20.e(Double.valueOf(dArr[0])) : s20.k();
    }

    public static List f0(float[] fArr) {
        fArr.getClass();
        int length = fArr.length;
        return length != 0 ? length != 1 ? o0(fArr) : r20.e(Float.valueOf(fArr[0])) : s20.k();
    }

    public static List g0(int[] iArr) {
        iArr.getClass();
        int length = iArr.length;
        return length != 0 ? length != 1 ? p0(iArr) : r20.e(Integer.valueOf(iArr[0])) : s20.k();
    }

    public static List h0(long[] jArr) {
        jArr.getClass();
        int length = jArr.length;
        return length != 0 ? length != 1 ? q0(jArr) : r20.e(Long.valueOf(jArr[0])) : s20.k();
    }

    public static List i0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        return length != 0 ? length != 1 ? r0(objArr) : r20.e(objArr[0]) : s20.k();
    }

    public static List j0(short[] sArr) {
        sArr.getClass();
        int length = sArr.length;
        return length != 0 ? length != 1 ? s0(sArr) : r20.e(Short.valueOf(sArr[0])) : s20.k();
    }

    public static List k0(boolean[] zArr) {
        zArr.getClass();
        int length = zArr.length;
        return length != 0 ? length != 1 ? t0(zArr) : r20.e(Boolean.valueOf(zArr[0])) : s20.k();
    }

    public static final List l0(byte[] bArr) {
        bArr.getClass();
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final List m0(char[] cArr) {
        cArr.getClass();
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    public static final List n0(double[] dArr) {
        dArr.getClass();
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final List o0(float[] fArr) {
        fArr.getClass();
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static final List p0(int[] iArr) {
        iArr.getClass();
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static final List q0(long[] jArr) {
        jArr.getClass();
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static List r0(Object[] objArr) {
        objArr.getClass();
        return new ArrayList(s20.h(objArr, false, 1, null));
    }

    public static final List s0(short[] sArr) {
        sArr.getClass();
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    public static final List t0(boolean[] zArr) {
        zArr.getClass();
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static Set u0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) b0(objArr, new LinkedHashSet(sc2.e(objArr.length))) : do3.d(objArr[0]) : eo3.e();
    }

    public static Iterable v0(final Object[] objArr) {
        objArr.getClass();
        return new do1(new l81() { // from class: qb
            @Override // defpackage.l81
            public final Object invoke() {
                Iterator w0;
                w0 = rb.w0(objArr);
                return w0;
            }
        });
    }

    public static Iterable w(Object[] objArr) {
        objArr.getClass();
        return objArr.length == 0 ? s20.k() : new a(objArr);
    }

    public static final Iterator w0(Object[] objArr) {
        return db.a(objArr);
    }

    public static bn3 x(Object[] objArr) {
        objArr.getClass();
        return objArr.length == 0 ? kn3.i() : new b(objArr);
    }

    public static List x0(Object[] objArr, Object[] objArr2) {
        objArr.getClass();
        objArr2.getClass();
        int min = Math.min(objArr.length, objArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(g94.a(objArr[i], objArr2[i]));
        }
        return arrayList;
    }

    public static final boolean y(byte[] bArr, byte b2) {
        bArr.getClass();
        return J(bArr, b2) >= 0;
    }

    public static boolean z(char[] cArr, char c) {
        cArr.getClass();
        return K(cArr, c) >= 0;
    }
}
