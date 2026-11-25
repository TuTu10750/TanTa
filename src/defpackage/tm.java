package defpackage;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: /tmp/classes2.dex */
public abstract class tm implements Iterable {
    public static final tm a = new f02(new byte[0]);

    /* loaded from: /tmp/classes2.dex */
    public interface a extends Iterator {
        byte b();
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends OutputStream {
        public static final byte[] f = new byte[0];
        public final int a;
        public final ArrayList b;
        public int c;
        public byte[] d;
        public int e;

        public b(int i) {
            if (i < 0) {
                ik.a("Buffer size < 0");
                throw null;
            }
            this.a = i;
            this.b = new ArrayList();
            this.d = new byte[i];
        }

        public synchronized int H() {
            return this.c + this.e;
        }

        public synchronized tm T() {
            g();
            return tm.i(this.b);
        }

        public final byte[] a(byte[] bArr, int i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            return bArr2;
        }

        public final void b(int i) {
            this.b.add(new f02(this.d));
            int length = this.c + this.d.length;
            this.c = length;
            this.d = new byte[Math.max(this.a, Math.max(i, length >>> 1))];
            this.e = 0;
        }

        public final void g() {
            int i = this.e;
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                this.b.add(new f02(this.d));
                this.d = f;
            } else if (i > 0) {
                this.b.add(new f02(a(bArr, i)));
            }
            this.c += this.e;
            this.e = 0;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(H()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            try {
                if (this.e == this.d.length) {
                    b(1);
                }
                byte[] bArr = this.d;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr[i2] = (byte) i;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            try {
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i3 = this.e;
                if (i2 <= length - i3) {
                    System.arraycopy(bArr, i, bArr2, i3, i2);
                    this.e += i2;
                } else {
                    int length2 = bArr2.length - i3;
                    System.arraycopy(bArr, i, bArr2, i3, length2);
                    int i4 = i2 - length2;
                    b(i4);
                    System.arraycopy(bArr, i + length2, this.d, 0, i4);
                    this.e = i4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static tm g(Iterator it, int i) {
        if (i == 1) {
            return (tm) it.next();
        }
        int i2 = i >>> 1;
        return g(it, i2).h(g(it, i - i2));
    }

    public static tm i(Iterable iterable) {
        Collection collection;
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            collection = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                collection.add((tm) it.next());
            }
        }
        return collection.isEmpty() ? a : g(collection.iterator(), collection.size());
    }

    public static tm j(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static tm k(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new f02(bArr2);
    }

    public static tm l(String str) {
        try {
            return new f02(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            hh4.a("UTF-8 not supported?", e);
            return null;
        }
    }

    public static b r() {
        return new b(128);
    }

    public tm h(tm tmVar) {
        int size = size();
        int size2 = tmVar.size();
        if (size + size2 < 2147483647L) {
            return fi3.D(this, tmVar);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void m(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            rm.a(30, "Source offset < 0: ", i);
            return;
        }
        if (i2 < 0) {
            rm.a(30, "Target offset < 0: ", i2);
            return;
        }
        if (i3 < 0) {
            rm.a(23, "Length < 0: ", i3);
            return;
        }
        int i4 = i + i3;
        if (i4 > size()) {
            rm.a(34, "Source end offset < 0: ", i4);
            return;
        }
        int i5 = i2 + i3;
        if (i5 > bArr.length) {
            rm.a(34, "Target end offset < 0: ", i5);
        } else if (i3 > 0) {
            n(bArr, i, i2, i3);
        }
    }

    public abstract void n(byte[] bArr, int i, int i2, int i3);

    public abstract int o();

    public abstract boolean p();

    public abstract boolean q();

    public abstract int s(int i, int i2, int i3);

    public abstract int size();

    public abstract int t(int i, int i2, int i3);

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract int u();

    public byte[] v() {
        int size = size();
        if (size == 0) {
            return f.a;
        }
        byte[] bArr = new byte[size];
        n(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String w(String str);

    public String x() {
        try {
            return w("UTF-8");
        } catch (UnsupportedEncodingException e) {
            hh4.a("UTF-8 not supported?", e);
            return null;
        }
    }

    public void y(OutputStream outputStream, int i, int i2) {
        if (i < 0) {
            rm.a(30, "Source offset < 0: ", i);
            return;
        }
        if (i2 < 0) {
            rm.a(23, "Length < 0: ", i2);
            return;
        }
        int i3 = i + i2;
        if (i3 > size()) {
            rm.a(39, "Source end offset exceeded: ", i3);
        } else if (i2 > 0) {
            z(outputStream, i, i2);
        }
    }

    public abstract void z(OutputStream outputStream, int i, int i2);
}
