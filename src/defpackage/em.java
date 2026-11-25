package defpackage;

import com.zzhoujay.richtext.cache.CacheIOHelper;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class em extends OutputStream {
    public static final byte[] f = new byte[0];
    public List a;
    public int b;
    public int c;
    public byte[] d;
    public int e;

    public em() {
        this(CacheIOHelper.BUFFER_SIZE);
    }

    public em(int i) {
        this.a = new ArrayList();
        if (i >= 0) {
            b(i);
        } else {
            StringBuffer stringBuffer = new StringBuffer("Negative initial size: ");
            stringBuffer.append(i);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public final byte[] a(int i) {
        return (byte[]) this.a.get(i);
    }

    public final void b(int i) {
        if (this.b < this.a.size() - 1) {
            this.c += this.d.length;
            int i2 = this.b + 1;
            this.b = i2;
            this.d = a(i2);
            return;
        }
        byte[] bArr = this.d;
        if (bArr == null) {
            this.c = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.c);
            this.c += this.d.length;
        }
        this.b++;
        byte[] bArr2 = new byte[i];
        this.d = bArr2;
        this.a.add(bArr2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public synchronized byte[] g() {
        int i = this.e;
        if (i == 0) {
            return f;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            byte[] a = a(i3);
            int min = Math.min(a.length, i);
            System.arraycopy(a, 0, bArr, i2, min);
            i2 += min;
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }

    public String toString() {
        return new String(g());
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        try {
            int i2 = this.e;
            int i3 = i2 - this.c;
            if (i3 == this.d.length) {
                b(i2 + 1);
                i3 = 0;
            }
            this.d[i3] = (byte) i;
            this.e++;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this) {
            try {
                int i4 = this.e;
                int i5 = i4 + i2;
                int i6 = i4 - this.c;
                while (i2 > 0) {
                    int min = Math.min(i2, this.d.length - i6);
                    System.arraycopy(bArr, i3 - i2, this.d, i6, min);
                    i2 -= min;
                    if (i2 > 0) {
                        b(i5);
                        i6 = 0;
                    }
                }
                this.e = i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
