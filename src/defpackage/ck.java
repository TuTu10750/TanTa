package defpackage;

import defpackage.tm;

/* loaded from: /tmp/classes2.dex */
public class ck extends f02 {
    public final int d;
    public final int e;

    /* loaded from: /tmp/classes2.dex */
    public class b implements tm.a {
        public int a;
        public final int b;

        public b() {
            int B = ck.this.B();
            this.a = B;
            this.b = B + ck.this.size();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(b());
        }

        @Override // tm.a
        public byte b() {
            int i = this.a;
            if (i >= this.b) {
                zm.a();
                return (byte) 0;
            }
            byte[] bArr = ck.this.b;
            this.a = i + 1;
            return bArr[i];
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

    public ck(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            b13.a(29, "Offset too small: ", i);
            throw null;
        }
        if (i2 < 0) {
            b13.a(29, "Length too small: ", i);
            throw null;
        }
        if (i + i2 <= bArr.length) {
            this.d = i;
            this.e = i2;
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("Offset+Length too large: ");
        sb.append(i);
        sb.append("+");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // defpackage.f02
    public int B() {
        return this.d;
    }

    @Override // defpackage.f02, java.lang.Iterable
    /* renamed from: D */
    public tm.a iterator() {
        return new b();
    }

    @Override // defpackage.f02, defpackage.tm
    public void n(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, B() + i, bArr, i2, i3);
    }

    @Override // defpackage.f02, defpackage.tm
    public int size() {
        return this.e;
    }
}
