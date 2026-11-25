package defpackage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /tmp/classes2.dex */
public abstract class pb extends ob {

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends p1 implements RandomAccess {
        public final /* synthetic */ byte[] b;

        public a(byte[] bArr) {
            this.b = bArr;
        }

        @Override // defpackage.j1, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return i(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // defpackage.j1
        public int h() {
            return this.b.length;
        }

        public boolean i(byte b) {
            return rb.y(this.b, b);
        }

        @Override // defpackage.p1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return k(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // defpackage.j1, java.util.Collection
        public boolean isEmpty() {
            return this.b.length == 0;
        }

        @Override // defpackage.p1, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Byte get(int i) {
            return Byte.valueOf(this.b[i]);
        }

        public int k(byte b) {
            return rb.J(this.b, b);
        }

        public int l(byte b) {
            return rb.S(this.b, b);
        }

        @Override // defpackage.p1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return l(((Number) obj).byteValue());
            }
            return -1;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends p1 implements RandomAccess {
        public final /* synthetic */ int[] b;

        public b(int[] iArr) {
            this.b = iArr;
        }

        @Override // defpackage.j1, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return i(((Number) obj).intValue());
            }
            return false;
        }

        @Override // defpackage.j1
        public int h() {
            return this.b.length;
        }

        public boolean i(int i) {
            return rb.A(this.b, i);
        }

        @Override // defpackage.p1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return k(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // defpackage.j1, java.util.Collection
        public boolean isEmpty() {
            return this.b.length == 0;
        }

        @Override // defpackage.p1, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer get(int i) {
            return Integer.valueOf(this.b[i]);
        }

        public int k(int i) {
            return rb.L(this.b, i);
        }

        public int l(int i) {
            return rb.T(this.b, i);
        }

        @Override // defpackage.p1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return l(((Number) obj).intValue());
            }
            return -1;
        }
    }

    public static final List c(byte[] bArr) {
        bArr.getClass();
        return new a(bArr);
    }

    public static List d(int[] iArr) {
        iArr.getClass();
        return new b(iArr);
    }

    public static List e(Object[] objArr) {
        objArr.getClass();
        List a2 = sb.a(objArr);
        a2.getClass();
        return a2;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        bArr.getClass();
        bArr2.getClass();
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static int[] g(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        iArr.getClass();
        iArr2.getClass();
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    public static long[] h(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        jArr.getClass();
        jArr2.getClass();
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    public static Object[] i(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        objArr.getClass();
        objArr2.getClass();
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
        return objArr2;
    }

    public static /* synthetic */ byte[] j(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return f(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ int[] k(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return g(iArr, iArr2, i, i2, i3);
    }

    public static /* synthetic */ Object[] l(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return i(objArr, objArr2, i, i2, i3);
    }

    public static byte[] m(byte[] bArr, int i, int i2) {
        bArr.getClass();
        nb.b(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        copyOfRange.getClass();
        return copyOfRange;
    }

    public static char[] n(char[] cArr, int i, int i2) {
        cArr.getClass();
        nb.b(i2, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
        copyOfRange.getClass();
        return copyOfRange;
    }

    public static Object[] o(Object[] objArr, int i, int i2) {
        objArr.getClass();
        nb.b(i2, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i, i2);
        copyOfRange.getClass();
        return copyOfRange;
    }

    public static final void p(int[] iArr, int i, int i2, int i3) {
        iArr.getClass();
        Arrays.fill(iArr, i2, i3, i);
    }

    public static void q(Object[] objArr, Object obj, int i, int i2) {
        objArr.getClass();
        Arrays.fill(objArr, i, i2, obj);
    }

    public static /* synthetic */ void r(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        p(iArr, i, i2, i3);
    }

    public static /* synthetic */ void s(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        q(objArr, obj, i, i2);
    }

    public static final void t(Object[] objArr) {
        objArr.getClass();
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static final void u(Object[] objArr, Comparator comparator) {
        objArr.getClass();
        comparator.getClass();
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
