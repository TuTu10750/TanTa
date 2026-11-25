package defpackage;

import defpackage.tm;
import java.io.OutputStream;
import java.util.NoSuchElementException;

/* loaded from: /tmp/classes2.dex */
public class f02 extends tm {
    public final byte[] b;
    public int c = 0;

    /* loaded from: /tmp/classes2.dex */
    public class b implements tm.a {
        public int a;
        public final int b;

        public b() {
            this.a = 0;
            this.b = f02.this.size();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(b());
        }

        @Override // tm.a
        public byte b() {
            try {
                byte[] bArr = f02.this.b;
                int i = this.a;
                this.a = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public f02(byte[] bArr) {
        this.b = bArr;
    }

    public static int C(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public boolean A(f02 f02Var, int i, int i2) {
        if (i2 > f02Var.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i + i2 > f02Var.size()) {
            int size2 = f02Var.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.b;
        byte[] bArr2 = f02Var.b;
        int B = B() + i2;
        int B2 = B();
        int B3 = f02Var.B() + i;
        while (B2 < B) {
            if (bArr[B2] != bArr2[B3]) {
                return false;
            }
            B2++;
            B3++;
        }
        return true;
    }

    public int B() {
        return 0;
    }

    @Override // java.lang.Iterable
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public tm.a iterator() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tm) || size() != ((tm) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof f02) {
            return A((f02) obj, 0, size());
        }
        if (obj instanceof fi3) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb = new StringBuilder(valueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public int hashCode() {
        int i = this.c;
        if (i == 0) {
            int size = size();
            i = s(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    @Override // defpackage.tm
    public void n(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, i, bArr, i2, i3);
    }

    @Override // defpackage.tm
    public int o() {
        return 0;
    }

    @Override // defpackage.tm
    public boolean p() {
        return true;
    }

    @Override // defpackage.tm
    public boolean q() {
        int B = B();
        return te4.f(this.b, B, size() + B);
    }

    @Override // defpackage.tm
    public int s(int i, int i2, int i3) {
        return C(i, this.b, B() + i2, i3);
    }

    @Override // defpackage.tm
    public int size() {
        return this.b.length;
    }

    @Override // defpackage.tm
    public int t(int i, int i2, int i3) {
        int B = B() + i2;
        return te4.g(i, this.b, B, i3 + B);
    }

    @Override // defpackage.tm
    public int u() {
        return this.c;
    }

    @Override // defpackage.tm
    public String w(String str) {
        return new String(this.b, B(), size(), str);
    }

    @Override // defpackage.tm
    public void z(OutputStream outputStream, int i, int i2) {
        outputStream.write(this.b, B() + i, i2);
    }
}
