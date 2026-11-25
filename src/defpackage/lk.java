package defpackage;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.connection.RealConnection;
import okio.ByteString;
import okio.SegmentedByteString;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public final class lk implements sk, rk, Cloneable, ByteChannel {
    public gl3 a;
    public long b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(lk.this.size(), 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (lk.this.size() > 0) {
                return lk.this.readByte() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            return lk.this.read(bArr, i, i2);
        }

        public String toString() {
            return lk.this + ".inputStream()";
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b implements Closeable {
        public lk a;
        public boolean b;
        public gl3 c;
        public byte[] e;
        public long d = -1;
        public int f = -1;
        public int g = -1;

        public final long H(long j) {
            lk lkVar = this.a;
            if (lkVar == null) {
                fl3.a("not attached to a buffer");
                return 0L;
            }
            if (!this.b) {
                fl3.a("resizeBuffer() only permitted for read/write buffers");
                return 0L;
            }
            long size = lkVar.size();
            if (j <= size) {
                if (j < 0) {
                    hk.a("newSize < 0: ", j);
                    return 0L;
                }
                long j2 = size - j;
                while (true) {
                    if (j2 <= 0) {
                        break;
                    }
                    gl3 gl3Var = lkVar.a;
                    gl3Var.getClass();
                    gl3 gl3Var2 = gl3Var.g;
                    gl3Var2.getClass();
                    int i = gl3Var2.c;
                    long j3 = i - gl3Var2.b;
                    if (j3 > j2) {
                        gl3Var2.c = i - ((int) j2);
                        break;
                    }
                    lkVar.a = gl3Var2.b();
                    kl3.b(gl3Var2);
                    j2 -= j3;
                }
                d0(null);
                this.d = j;
                this.e = null;
                this.f = -1;
                this.g = -1;
            } else if (j > size) {
                long j4 = j - size;
                boolean z = true;
                while (j4 > 0) {
                    gl3 I0 = lkVar.I0(1);
                    int min = (int) Math.min(j4, 8192 - I0.c);
                    I0.c += min;
                    j4 -= min;
                    if (z) {
                        d0(I0);
                        this.d = size;
                        this.e = I0.a;
                        int i2 = I0.c;
                        this.f = i2 - min;
                        this.g = i2;
                        z = false;
                    }
                }
            }
            lkVar.F0(j);
            return size;
        }

        public final int T(long j) {
            gl3 gl3Var;
            lk lkVar = this.a;
            if (lkVar == null) {
                fl3.a("not attached to a buffer");
                return 0;
            }
            if (j < -1 || j > lkVar.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + lkVar.size());
            }
            if (j == -1 || j == lkVar.size()) {
                d0(null);
                this.d = j;
                this.e = null;
                this.f = -1;
                this.g = -1;
                return -1;
            }
            long size = lkVar.size();
            gl3 gl3Var2 = lkVar.a;
            long j2 = 0;
            if (a() != null) {
                long j3 = this.d;
                int i = this.f;
                a().getClass();
                long j4 = j3 - (i - r9.b);
                if (j4 > j) {
                    gl3Var = gl3Var2;
                    gl3Var2 = a();
                    size = j4;
                } else {
                    gl3Var = a();
                    j2 = j4;
                }
            } else {
                gl3Var = gl3Var2;
            }
            if (size - j > j - j2) {
                while (true) {
                    gl3Var.getClass();
                    int i2 = gl3Var.c;
                    int i3 = gl3Var.b;
                    if (j < (i2 - i3) + j2) {
                        break;
                    }
                    j2 += i2 - i3;
                    gl3Var = gl3Var.f;
                }
            } else {
                while (size > j) {
                    gl3Var2.getClass();
                    gl3Var2 = gl3Var2.g;
                    gl3Var2.getClass();
                    size -= gl3Var2.c - gl3Var2.b;
                }
                j2 = size;
                gl3Var = gl3Var2;
            }
            if (this.b) {
                gl3Var.getClass();
                if (gl3Var.d) {
                    gl3 f = gl3Var.f();
                    if (lkVar.a == gl3Var) {
                        lkVar.a = f;
                    }
                    gl3Var = gl3Var.c(f);
                    gl3 gl3Var3 = gl3Var.g;
                    gl3Var3.getClass();
                    gl3Var3.b();
                }
            }
            d0(gl3Var);
            this.d = j;
            gl3Var.getClass();
            this.e = gl3Var.a;
            int i4 = gl3Var.b + ((int) (j - j2));
            this.f = i4;
            int i5 = gl3Var.c;
            this.g = i5;
            return i5 - i4;
        }

        public final gl3 a() {
            return this.c;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a == null) {
                fl3.a("not attached to a buffer");
                return;
            }
            this.a = null;
            d0(null);
            this.d = -1L;
            this.e = null;
            this.f = -1;
            this.g = -1;
        }

        public final void d0(gl3 gl3Var) {
            this.c = gl3Var;
        }

        public final int g() {
            long j = this.d;
            lk lkVar = this.a;
            lkVar.getClass();
            if (j != lkVar.size()) {
                long j2 = this.d;
                return j2 == -1 ? T(0L) : T(j2 + (this.g - this.f));
            }
            fl3.a("no more bytes");
            return 0;
        }
    }

    public static /* synthetic */ b C0(lk lkVar, b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = r.d();
        }
        return lkVar.B0(bVar);
    }

    public boolean A0(long j, ByteString byteString, int i, int i2) {
        byteString.getClass();
        if (j < 0 || i < 0 || i2 < 0 || size() - j < i2 || byteString.G() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (q0(i3 + j) != byteString.i(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.sk
    public boolean B() {
        return this.b == 0;
    }

    public final b B0(b bVar) {
        bVar.getClass();
        return defpackage.b.a(this, bVar);
    }

    @Override // defpackage.sk
    public long C(byte b2, long j, long j2) {
        gl3 gl3Var;
        int i;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > size()) {
            j2 = size();
        }
        if (j == j2 || (gl3Var = this.a) == null) {
            return -1L;
        }
        if (size() - j < j) {
            j3 = size();
            while (j3 > j) {
                gl3Var = gl3Var.g;
                gl3Var.getClass();
                j3 -= gl3Var.c - gl3Var.b;
            }
            while (j3 < j2) {
                byte[] bArr = gl3Var.a;
                int min = (int) Math.min(gl3Var.c, (gl3Var.b + j2) - j3);
                i = (int) ((gl3Var.b + j) - j3);
                while (i < min) {
                    if (bArr[i] != b2) {
                        i++;
                    }
                }
                j3 += gl3Var.c - gl3Var.b;
                gl3Var = gl3Var.f;
                gl3Var.getClass();
                j = j3;
            }
            return -1L;
        }
        while (true) {
            long j4 = (gl3Var.c - gl3Var.b) + j3;
            if (j4 > j) {
                break;
            }
            gl3Var = gl3Var.f;
            gl3Var.getClass();
            j3 = j4;
        }
        while (j3 < j2) {
            byte[] bArr2 = gl3Var.a;
            int min2 = (int) Math.min(gl3Var.c, (gl3Var.b + j2) - j3);
            i = (int) ((gl3Var.b + j) - j3);
            while (i < min2) {
                if (bArr2[i] != b2) {
                    i++;
                }
            }
            j3 += gl3Var.c - gl3Var.b;
            gl3Var = gl3Var.f;
            gl3Var.getClass();
            j = j3;
        }
        return -1L;
        return (i - gl3Var.b) + j3;
    }

    @Override // defpackage.sk
    public long D(ByteString byteString) {
        byteString.getClass();
        return z0(byteString, 0L);
    }

    public String D0(long j, Charset charset) {
        charset.getClass();
        if (j < 0 || j > 2147483647L) {
            hk.a("byteCount: ", j);
            return null;
        }
        if (this.b < j) {
            gk.a();
            return null;
        }
        if (j == 0) {
            return "";
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        int i = gl3Var.b;
        if (i + j > gl3Var.c) {
            return new String(i0(j), charset);
        }
        int i2 = (int) j;
        String str = new String(gl3Var.a, i, i2, charset);
        int i3 = gl3Var.b + i2;
        gl3Var.b = i3;
        this.b -= j;
        if (i3 == gl3Var.c) {
            this.a = gl3Var.b();
            kl3.b(gl3Var);
        }
        return str;
    }

    @Override // defpackage.rk
    public long E(wr3 wr3Var) {
        wr3Var.getClass();
        long j = 0;
        while (true) {
            long read = wr3Var.read(this, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    public String E0() {
        return D0(this.b, ly.b);
    }

    public final void F0(long j) {
        this.b = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0090, code lost:
    
        F0(size() - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
    
        if (r2 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
    
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009e, code lost:
    
        if (r1 >= r14) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
    
        if (size() == r17) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a8, code lost:
    
        if (r2 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00aa, code lost:
    
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
    
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + defpackage.r.k(q0(r17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
    
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d3, code lost:
    
        gk.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d8, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d9, code lost:
    
        if (r2 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00db, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dd, code lost:
    
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009d, code lost:
    
        r14 = 1;
     */
    @Override // defpackage.sk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long G() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lk.G():long");
    }

    public final ByteString G0() {
        if (size() <= 2147483647L) {
            return H0((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public lk clone() {
        return d0();
    }

    public final ByteString H0(int i) {
        if (i == 0) {
            return ByteString.e;
        }
        r.b(size(), 0L, i);
        gl3 gl3Var = this.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            gl3Var.getClass();
            int i5 = gl3Var.c;
            int i6 = gl3Var.b;
            if (i5 == i6) {
                jk.a("s.limit == s.pos");
                return null;
            }
            i3 += i5 - i6;
            i4++;
            gl3Var = gl3Var.f;
        }
        byte[][] bArr = new byte[i4];
        int[] iArr = new int[i4 * 2];
        gl3 gl3Var2 = this.a;
        int i7 = 0;
        while (i2 < i) {
            gl3Var2.getClass();
            bArr[i7] = gl3Var2.a;
            i2 += gl3Var2.c - gl3Var2.b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = gl3Var2.b;
            gl3Var2.d = true;
            i7++;
            gl3Var2 = gl3Var2.f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // defpackage.sk
    public String I(long j) {
        if (j < 0) {
            hk.a("limit < 0: ", j);
            return null;
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long C = C((byte) 10, 0L, j2);
        if (C != -1) {
            return defpackage.b.d(this, C);
        }
        if (j2 < size() && q0(j2 - 1) == 13 && q0(j2) == 10) {
            return defpackage.b.d(this, j2);
        }
        lk lkVar = new lk();
        e0(lkVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + lkVar.Z().n() + (char) 8230);
    }

    public final gl3 I0(int i) {
        if (i < 1 || i > 8192) {
            ik.a("unexpected capacity");
            return null;
        }
        gl3 gl3Var = this.a;
        if (gl3Var != null) {
            gl3Var.getClass();
            gl3 gl3Var2 = gl3Var.g;
            gl3Var2.getClass();
            return (gl3Var2.c + i > 8192 || !gl3Var2.e) ? gl3Var2.c(kl3.c()) : gl3Var2;
        }
        gl3 c = kl3.c();
        this.a = c;
        c.g = c;
        c.f = c;
        return c;
    }

    public lk J0(wr3 wr3Var, long j) {
        wr3Var.getClass();
        while (j > 0) {
            long read = wr3Var.read(this, j);
            if (read == -1) {
                gk.a();
                return null;
            }
            j -= read;
        }
        return this;
    }

    @Override // defpackage.rk
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public lk l0(ByteString byteString) {
        byteString.getClass();
        byteString.N(this, 0, byteString.G());
        return this;
    }

    @Override // defpackage.rk
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public lk write(byte[] bArr) {
        bArr.getClass();
        return write(bArr, 0, bArr.length);
    }

    @Override // defpackage.rk
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public lk write(byte[] bArr, int i, int i2) {
        bArr.getClass();
        long j = i2;
        r.b(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            gl3 I0 = I0(1);
            int min = Math.min(i3 - i, 8192 - I0.c);
            int i4 = i + min;
            pb.f(bArr, I0.a, I0.c, i, i4);
            I0.c += min;
            i = i4;
        }
        F0(size() + j);
        return this;
    }

    @Override // defpackage.rk
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public lk writeByte(int i) {
        gl3 I0 = I0(1);
        byte[] bArr = I0.a;
        int i2 = I0.c;
        I0.c = i2 + 1;
        bArr[i2] = (byte) i;
        F0(size() + 1);
        return this;
    }

    @Override // defpackage.rk
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public lk t0(long j) {
        boolean z;
        if (j == 0) {
            return writeByte(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return O("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        gl3 I0 = I0(i);
        byte[] bArr = I0.a;
        int i2 = I0.c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = defpackage.b.b()[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        I0.c += i;
        F0(size() + i);
        return this;
    }

    @Override // defpackage.sk
    public long P(kq3 kq3Var) {
        kq3Var.getClass();
        long size = size();
        if (size > 0) {
            kq3Var.write(this, size);
        }
        return size;
    }

    @Override // defpackage.rk
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public lk X(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        gl3 I0 = I0(i);
        byte[] bArr = I0.a;
        int i2 = I0.c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = defpackage.b.b()[(int) (15 & j)];
            j >>>= 4;
        }
        I0.c += i;
        F0(size() + i);
        return this;
    }

    @Override // defpackage.rk
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public lk writeInt(int i) {
        gl3 I0 = I0(4);
        byte[] bArr = I0.a;
        int i2 = I0.c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        I0.c = i2 + 4;
        F0(size() + 4);
        return this;
    }

    @Override // defpackage.sk
    public boolean R(long j, ByteString byteString) {
        byteString.getClass();
        return A0(j, byteString, 0, byteString.G());
    }

    @Override // defpackage.rk
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public lk A(int i) {
        return writeInt(r.h(i));
    }

    @Override // defpackage.sk
    public String S(Charset charset) {
        charset.getClass();
        return D0(this.b, charset);
    }

    public lk S0(long j) {
        gl3 I0 = I0(8);
        byte[] bArr = I0.a;
        int i = I0.c;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        I0.c = i + 8;
        F0(size() + 8);
        return this;
    }

    public final long T() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        gl3 gl3Var2 = gl3Var.g;
        gl3Var2.getClass();
        return (gl3Var2.c >= 8192 || !gl3Var2.e) ? size : size - (r2 - gl3Var2.b);
    }

    @Override // defpackage.rk
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public lk w(long j) {
        return S0(r.i(j));
    }

    @Override // defpackage.rk
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public lk writeShort(int i) {
        gl3 I0 = I0(2);
        byte[] bArr = I0.a;
        int i2 = I0.c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        I0.c = i2 + 2;
        F0(size() + 2);
        return this;
    }

    public lk V0(String str, int i, int i2, Charset charset) {
        str.getClass();
        charset.getClass();
        if (i < 0) {
            se4.a("beginIndex < 0: ", i);
            return null;
        }
        if (i2 < i) {
            re4.a("endIndex < beginIndex: ", i2, " < ", i);
            return null;
        }
        if (i2 > str.length()) {
            re4.a("endIndex > string.length: ", i2, " > ", str.length());
            return null;
        }
        if (dq1.a(charset, ly.b)) {
            return W(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        bytes.getClass();
        return write(bytes, 0, bytes.length);
    }

    public lk W0(String str, Charset charset) {
        str.getClass();
        charset.getClass();
        return V0(str, 0, str.length(), charset);
    }

    @Override // defpackage.rk
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public lk O(String str) {
        str.getClass();
        return W(str, 0, str.length());
    }

    @Override // defpackage.rk
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public lk W(String str, int i, int i2) {
        char charAt;
        str.getClass();
        if (i < 0) {
            se4.a("beginIndex < 0: ", i);
            return null;
        }
        if (i2 < i) {
            re4.a("endIndex < beginIndex: ", i2, " < ", i);
            return null;
        }
        if (i2 > str.length()) {
            re4.a("endIndex > string.length: ", i2, " > ", str.length());
            return null;
        }
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (charAt2 < 128) {
                gl3 I0 = I0(1);
                byte[] bArr = I0.a;
                int i3 = I0.c - i;
                int min = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) charAt2;
                while (true) {
                    i = i4;
                    if (i >= min || (charAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                }
                int i5 = I0.c;
                int i6 = (i3 + i) - i5;
                I0.c = i5 + i6;
                F0(size() + i6);
            } else {
                if (charAt2 < 2048) {
                    gl3 I02 = I0(2);
                    byte[] bArr2 = I02.a;
                    int i7 = I02.c;
                    bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                    I02.c = i7 + 2;
                    F0(size() + 2);
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    gl3 I03 = I0(3);
                    byte[] bArr3 = I03.a;
                    int i8 = I03.c;
                    bArr3[i8] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((charAt2 & '?') | 128);
                    I03.c = i8 + 3;
                    F0(size() + 3);
                } else {
                    int i9 = i + 1;
                    char charAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                        writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        gl3 I04 = I0(4);
                        byte[] bArr4 = I04.a;
                        int i11 = I04.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        I04.c = i11 + 4;
                        F0(size() + 4);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    @Override // defpackage.sk
    public ByteString Z() {
        return h(size());
    }

    public lk Z0(int i) {
        if (i < 128) {
            writeByte(i);
            return this;
        }
        if (i < 2048) {
            gl3 I0 = I0(2);
            byte[] bArr = I0.a;
            int i2 = I0.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            I0.c = i2 + 2;
            F0(size() + 2);
            return this;
        }
        if (55296 <= i && i < 57344) {
            writeByte(63);
            return this;
        }
        if (i < 65536) {
            gl3 I02 = I0(3);
            byte[] bArr2 = I02.a;
            int i3 = I02.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            I02.c = i3 + 3;
            F0(size() + 3);
            return this;
        }
        if (i > 1114111) {
            kk.a("Unexpected code point: 0x", r.l(i));
            return null;
        }
        gl3 I03 = I0(4);
        byte[] bArr3 = I03.a;
        int i4 = I03.c;
        bArr3[i4] = (byte) ((i >> 18) | 240);
        bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i4 + 3] = (byte) ((i & 63) | 128);
        I03.c = i4 + 4;
        F0(size() + 4);
        return this;
    }

    public final void a() {
        skip(size());
    }

    @Override // defpackage.sk
    public boolean c0(long j) {
        return this.b >= j;
    }

    @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final lk d0() {
        lk lkVar = new lk();
        if (size() == 0) {
            return lkVar;
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        gl3 d = gl3Var.d();
        lkVar.a = d;
        d.g = d;
        d.f = d;
        for (gl3 gl3Var2 = gl3Var.f; gl3Var2 != gl3Var; gl3Var2 = gl3Var2.f) {
            gl3 gl3Var3 = d.g;
            gl3Var3.getClass();
            gl3Var2.getClass();
            gl3Var3.c(gl3Var2.d());
        }
        lkVar.F0(size());
        return lkVar;
    }

    public final lk e0(lk lkVar, long j, long j2) {
        lkVar.getClass();
        long j3 = j;
        r.b(size(), j3, j2);
        if (j2 != 0) {
            lkVar.F0(lkVar.size() + j2);
            gl3 gl3Var = this.a;
            while (true) {
                gl3Var.getClass();
                int i = gl3Var.c;
                int i2 = gl3Var.b;
                if (j3 < i - i2) {
                    break;
                }
                j3 -= i - i2;
                gl3Var = gl3Var.f;
            }
            gl3 gl3Var2 = gl3Var;
            long j4 = j2;
            while (j4 > 0) {
                gl3Var2.getClass();
                gl3 d = gl3Var2.d();
                int i3 = d.b + ((int) j3);
                d.b = i3;
                d.c = Math.min(i3 + ((int) j4), d.c);
                gl3 gl3Var3 = lkVar.a;
                if (gl3Var3 == null) {
                    d.g = d;
                    d.f = d;
                    lkVar.a = d;
                } else {
                    gl3Var3.getClass();
                    gl3 gl3Var4 = gl3Var3.g;
                    gl3Var4.getClass();
                    gl3Var4.c(d);
                }
                j4 -= d.c - d.b;
                gl3Var2 = gl3Var2.f;
                j3 = 0;
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lk)) {
            return false;
        }
        lk lkVar = (lk) obj;
        if (size() != lkVar.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        gl3 gl3Var2 = lkVar.a;
        gl3Var2.getClass();
        int i = gl3Var.b;
        int i2 = gl3Var2.b;
        long j = 0;
        while (j < size()) {
            long min = Math.min(gl3Var.c - i, gl3Var2.c - i2);
            long j2 = 0;
            while (j2 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (gl3Var.a[i] != gl3Var2.a[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == gl3Var.c) {
                gl3Var = gl3Var.f;
                gl3Var.getClass();
                i = gl3Var.b;
            }
            if (i2 == gl3Var2.c) {
                gl3Var2 = gl3Var2.f;
                gl3Var2.getClass();
                i2 = gl3Var2.b;
            }
            j += min;
        }
        return true;
    }

    @Override // defpackage.sk
    public String f(long j) {
        return D0(j, ly.b);
    }

    @Override // defpackage.rk, defpackage.kq3, java.io.Flushable
    public void flush() {
    }

    @Override // defpackage.sk
    public String g0() {
        return I(Long.MAX_VALUE);
    }

    @Override // defpackage.sk
    public ByteString h(long j) {
        if (j < 0 || j > 2147483647L) {
            hk.a("byteCount: ", j);
            return null;
        }
        if (size() < j) {
            gk.a();
            return null;
        }
        if (j < IjkMediaMeta.AV_CH_TOP_FRONT_LEFT) {
            return new ByteString(i0(j));
        }
        ByteString H0 = H0((int) j);
        skip(j);
        return H0;
    }

    @Override // defpackage.sk
    public int h0() {
        return r.h(readInt());
    }

    public int hashCode() {
        gl3 gl3Var = this.a;
        if (gl3Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = gl3Var.c;
            for (int i3 = gl3Var.b; i3 < i2; i3++) {
                i = (i * 31) + gl3Var.a[i3];
            }
            gl3Var = gl3Var.f;
            gl3Var.getClass();
        } while (gl3Var != this.a);
        return i;
    }

    @Override // defpackage.sk
    public byte[] i0(long j) {
        if (j < 0 || j > 2147483647L) {
            hk.a("byteCount: ", j);
            return null;
        }
        if (size() < j) {
            gk.a();
            return null;
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // defpackage.sk, defpackage.rk
    public lk k() {
        return this;
    }

    @Override // defpackage.rk
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public lk s() {
        return this;
    }

    @Override // defpackage.rk
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public lk F() {
        return this;
    }

    @Override // defpackage.sk
    public short n0() {
        return r.j(readShort());
    }

    @Override // defpackage.sk
    public long p0() {
        return r.i(readLong());
    }

    @Override // defpackage.sk
    public sk peek() {
        return qs2.d(new nx2(this));
    }

    @Override // defpackage.rk
    public lk q() {
        return this;
    }

    public final byte q0(long j) {
        r.b(size(), j, 1L);
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        if (size() - j < j) {
            long size = size();
            while (size > j) {
                gl3Var = gl3Var.g;
                gl3Var.getClass();
                size -= gl3Var.c - gl3Var.b;
            }
            return gl3Var.a[(int) ((gl3Var.b + j) - size)];
        }
        long j2 = 0;
        while (true) {
            int i = gl3Var.c;
            int i2 = gl3Var.b;
            long j3 = (i - i2) + j2;
            if (j3 > j) {
                return gl3Var.a[(int) ((i2 + j) - j2)];
            }
            gl3Var = gl3Var.f;
            gl3Var.getClass();
            j2 = j3;
        }
    }

    @Override // defpackage.sk
    public void r0(long j) {
        if (this.b >= j) {
            return;
        }
        gk.a();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        gl3 gl3Var = this.a;
        if (gl3Var == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), gl3Var.c - gl3Var.b);
        byteBuffer.put(gl3Var.a, gl3Var.b, min);
        int i = gl3Var.b + min;
        gl3Var.b = i;
        this.b -= min;
        if (i == gl3Var.c) {
            this.a = gl3Var.b();
            kl3.b(gl3Var);
        }
        return min;
    }

    public int read(byte[] bArr, int i, int i2) {
        bArr.getClass();
        r.b(bArr.length, i, i2);
        gl3 gl3Var = this.a;
        if (gl3Var == null) {
            return -1;
        }
        int min = Math.min(i2, gl3Var.c - gl3Var.b);
        byte[] bArr2 = gl3Var.a;
        int i3 = gl3Var.b;
        pb.f(bArr2, bArr, i, i3, i3 + min);
        gl3Var.b += min;
        F0(size() - min);
        if (gl3Var.b == gl3Var.c) {
            this.a = gl3Var.b();
            kl3.b(gl3Var);
        }
        return min;
    }

    @Override // defpackage.wr3
    public long read(lk lkVar, long j) {
        lkVar.getClass();
        if (j < 0) {
            hk.a("byteCount < 0: ", j);
            return 0L;
        }
        if (size() == 0) {
            return -1L;
        }
        if (j > size()) {
            j = size();
        }
        lkVar.write(this, j);
        return j;
    }

    @Override // defpackage.sk
    public byte readByte() {
        if (size() == 0) {
            gk.a();
            return (byte) 0;
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        int i = gl3Var.b;
        int i2 = gl3Var.c;
        int i3 = i + 1;
        byte b2 = gl3Var.a[i];
        F0(size() - 1);
        if (i3 != i2) {
            gl3Var.b = i3;
            return b2;
        }
        this.a = gl3Var.b();
        kl3.b(gl3Var);
        return b2;
    }

    @Override // defpackage.sk
    public void readFully(byte[] bArr) {
        bArr.getClass();
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                gk.a();
                return;
            }
            i += read;
        }
    }

    @Override // defpackage.sk
    public int readInt() {
        if (size() < 4) {
            gk.a();
            return 0;
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        int i = gl3Var.b;
        int i2 = gl3Var.c;
        if (i2 - i < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = gl3Var.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        F0(size() - 4);
        if (i5 != i2) {
            gl3Var.b = i5;
            return i6;
        }
        this.a = gl3Var.b();
        kl3.b(gl3Var);
        return i6;
    }

    @Override // defpackage.sk
    public long readLong() {
        if (size() < 8) {
            gk.a();
            return 0L;
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        int i = gl3Var.b;
        int i2 = gl3Var.c;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = gl3Var.a;
        int i3 = i + 7;
        long j = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (bArr[i3] & 255);
        F0(size() - 8);
        if (i4 != i2) {
            gl3Var.b = i4;
            return j2;
        }
        this.a = gl3Var.b();
        kl3.b(gl3Var);
        return j2;
    }

    @Override // defpackage.sk
    public short readShort() {
        if (size() < 2) {
            gk.a();
            return (short) 0;
        }
        gl3 gl3Var = this.a;
        gl3Var.getClass();
        int i = gl3Var.b;
        int i2 = gl3Var.c;
        if (i2 - i < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = gl3Var.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        F0(size() - 2);
        if (i5 == i2) {
            this.a = gl3Var.b();
            kl3.b(gl3Var);
        } else {
            gl3Var.b = i5;
        }
        return (short) i6;
    }

    public long s0(byte b2, long j) {
        return C(b2, j, Long.MAX_VALUE);
    }

    public final long size() {
        return this.b;
    }

    @Override // defpackage.sk
    public void skip(long j) {
        while (j > 0) {
            gl3 gl3Var = this.a;
            if (gl3Var == null) {
                gk.a();
                return;
            }
            int min = (int) Math.min(j, gl3Var.c - gl3Var.b);
            long j2 = min;
            F0(size() - j2);
            j -= j2;
            int i = gl3Var.b + min;
            gl3Var.b = i;
            if (i == gl3Var.c) {
                this.a = gl3Var.b();
                kl3.b(gl3Var);
            }
        }
    }

    @Override // defpackage.sk
    public int t(ju2 ju2Var) {
        ju2Var.getClass();
        int f = defpackage.b.f(this, ju2Var, false, 2, null);
        if (f == -1) {
            return -1;
        }
        skip(ju2Var.k()[f].G());
        return f;
    }

    @Override // defpackage.wr3
    public d54 timeout() {
        return d54.NONE;
    }

    public String toString() {
        return G0().toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085 A[EDGE_INSN: B:40:0x0085->B:37:0x0085 BREAK  A[LOOP:0: B:4:0x000d->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    @Override // defpackage.sk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long v0() {
        /*
            r14 = this;
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L8f
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            gl3 r6 = r14.a
            r6.getClass()
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L18:
            if (r8 >= r9) goto L71
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3c
        L27:
            r11 = 97
            if (r10 < r11) goto L32
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L32
            int r11 = r10 + (-87)
            goto L3c
        L32:
            r11 = 65
            if (r10 < r11) goto L63
            r11 = 70
            if (r10 > r11) goto L63
            int r11 = r10 + (-55)
        L3c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4c:
            lk r14 = new lk
            r14.<init>()
            lk r14 = r14.X(r4)
            lk r14 = r14.writeByte(r10)
            java.lang.String r0 = "Number too large: "
            java.lang.String r14 = r14.E0()
            defpackage.fk.a(r0, r14)
            return r2
        L63:
            if (r0 == 0) goto L67
            r1 = 1
            goto L71
        L67:
            java.lang.String r14 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = defpackage.r.k(r10)
            defpackage.fk.a(r14, r0)
            return r2
        L71:
            if (r8 != r9) goto L7d
            gl3 r7 = r6.b()
            r14.a = r7
            defpackage.kl3.b(r6)
            goto L7f
        L7d:
            r6.b = r8
        L7f:
            if (r1 != 0) goto L85
            gl3 r6 = r14.a
            if (r6 != 0) goto Ld
        L85:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.F0(r1)
            return r4
        L8f:
            gk.a()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lk.v0():long");
    }

    @Override // defpackage.sk
    public InputStream w0() {
        return new a();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            gl3 I0 = I0(1);
            int min = Math.min(i, 8192 - I0.c);
            byteBuffer.get(I0.a, I0.c, min);
            i -= min;
            I0.c += min;
        }
        this.b += remaining;
        return remaining;
    }

    @Override // defpackage.kq3
    public void write(lk lkVar, long j) {
        gl3 gl3Var;
        lkVar.getClass();
        if (lkVar == this) {
            ik.a("source == this");
            return;
        }
        r.b(lkVar.size(), 0L, j);
        while (j > 0) {
            gl3 gl3Var2 = lkVar.a;
            gl3Var2.getClass();
            int i = gl3Var2.c;
            lkVar.a.getClass();
            if (j < i - r1.b) {
                gl3 gl3Var3 = this.a;
                if (gl3Var3 != null) {
                    gl3Var3.getClass();
                    gl3Var = gl3Var3.g;
                } else {
                    gl3Var = null;
                }
                if (gl3Var != null && gl3Var.e) {
                    if ((gl3Var.c + j) - (gl3Var.d ? 0 : gl3Var.b) <= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) {
                        gl3 gl3Var4 = lkVar.a;
                        gl3Var4.getClass();
                        gl3Var4.g(gl3Var, (int) j);
                        lkVar.F0(lkVar.size() - j);
                        F0(size() + j);
                        return;
                    }
                }
                gl3 gl3Var5 = lkVar.a;
                gl3Var5.getClass();
                lkVar.a = gl3Var5.e((int) j);
            }
            gl3 gl3Var6 = lkVar.a;
            gl3Var6.getClass();
            long j2 = gl3Var6.c - gl3Var6.b;
            lkVar.a = gl3Var6.b();
            gl3 gl3Var7 = this.a;
            if (gl3Var7 == null) {
                this.a = gl3Var6;
                gl3Var6.g = gl3Var6;
                gl3Var6.f = gl3Var6;
            } else {
                gl3Var7.getClass();
                gl3 gl3Var8 = gl3Var7.g;
                gl3Var8.getClass();
                gl3Var8.c(gl3Var6).a();
            }
            lkVar.F0(lkVar.size() - j2);
            F0(size() + j2);
            j -= j2;
        }
    }

    @Override // defpackage.sk
    public void x0(lk lkVar, long j) {
        lkVar.getClass();
        if (size() >= j) {
            lkVar.write(this, j);
        } else {
            lkVar.write(this, size());
            gk.a();
        }
    }

    @Override // defpackage.sk
    public byte[] y() {
        return i0(size());
    }

    public long y0(ByteString byteString, long j) {
        int i;
        long j2 = j;
        byteString.getClass();
        long j3 = 0;
        if (byteString.G() <= 0) {
            ik.a("bytes is empty");
            return 0L;
        }
        if (j2 < 0) {
            hk.a("fromIndex < 0: ", j2);
            return 0L;
        }
        gl3 gl3Var = this.a;
        if (gl3Var == null) {
            return -1L;
        }
        if (size() - j2 < j2) {
            j3 = size();
            while (j3 > j2) {
                gl3Var = gl3Var.g;
                gl3Var.getClass();
                j3 -= gl3Var.c - gl3Var.b;
            }
            byte[] r = byteString.r();
            byte b2 = r[0];
            int G = byteString.G();
            long size = (size() - G) + 1;
            while (j3 < size) {
                byte[] bArr = gl3Var.a;
                int min = (int) Math.min(gl3Var.c, (gl3Var.b + size) - j3);
                i = (int) ((gl3Var.b + j2) - j3);
                while (i < min) {
                    if (bArr[i] != b2 || !defpackage.b.c(gl3Var, i + 1, r, 1, G)) {
                        i++;
                    }
                }
                j3 += gl3Var.c - gl3Var.b;
                gl3Var = gl3Var.f;
                gl3Var.getClass();
                j2 = j3;
            }
            return -1L;
        }
        while (true) {
            long j4 = (gl3Var.c - gl3Var.b) + j3;
            if (j4 > j2) {
                break;
            }
            gl3Var = gl3Var.f;
            gl3Var.getClass();
            j3 = j4;
        }
        byte[] r2 = byteString.r();
        byte b3 = r2[0];
        int G2 = byteString.G();
        long size2 = (size() - G2) + 1;
        while (j3 < size2) {
            byte[] bArr2 = gl3Var.a;
            long j5 = size2;
            int min2 = (int) Math.min(gl3Var.c, (gl3Var.b + size2) - j3);
            i = (int) ((gl3Var.b + j2) - j3);
            while (i < min2) {
                if (bArr2[i] == b3 && defpackage.b.c(gl3Var, i + 1, r2, 1, G2)) {
                }
                i++;
            }
            j3 += gl3Var.c - gl3Var.b;
            gl3Var = gl3Var.f;
            gl3Var.getClass();
            size2 = j5;
            j2 = j3;
        }
        return -1L;
        return (i - gl3Var.b) + j3;
    }

    @Override // defpackage.sk
    public long z(ByteString byteString) {
        byteString.getClass();
        return y0(byteString, 0L);
    }

    public long z0(ByteString byteString, long j) {
        int i;
        int i2;
        byteString.getClass();
        long j2 = 0;
        if (j < 0) {
            hk.a("fromIndex < 0: ", j);
            return 0L;
        }
        gl3 gl3Var = this.a;
        if (gl3Var == null) {
            return -1L;
        }
        if (size() - j < j) {
            j2 = size();
            while (j2 > j) {
                gl3Var = gl3Var.g;
                gl3Var.getClass();
                j2 -= gl3Var.c - gl3Var.b;
            }
            if (byteString.G() == 2) {
                byte i3 = byteString.i(0);
                byte i4 = byteString.i(1);
                while (j2 < size()) {
                    byte[] bArr = gl3Var.a;
                    i = (int) ((gl3Var.b + j) - j2);
                    int i5 = gl3Var.c;
                    while (i < i5) {
                        byte b2 = bArr[i];
                        if (b2 != i3 && b2 != i4) {
                            i++;
                        }
                        i2 = gl3Var.b;
                    }
                    j2 += gl3Var.c - gl3Var.b;
                    gl3Var = gl3Var.f;
                    gl3Var.getClass();
                    j = j2;
                }
            } else {
                byte[] r = byteString.r();
                while (j2 < size()) {
                    byte[] bArr2 = gl3Var.a;
                    i = (int) ((gl3Var.b + j) - j2);
                    int i6 = gl3Var.c;
                    while (i < i6) {
                        byte b3 = bArr2[i];
                        for (byte b4 : r) {
                            if (b3 == b4) {
                                i2 = gl3Var.b;
                            }
                        }
                        i++;
                    }
                    j2 += gl3Var.c - gl3Var.b;
                    gl3Var = gl3Var.f;
                    gl3Var.getClass();
                    j = j2;
                }
            }
            return -1L;
        }
        while (true) {
            long j3 = (gl3Var.c - gl3Var.b) + j2;
            if (j3 > j) {
                break;
            }
            gl3Var = gl3Var.f;
            gl3Var.getClass();
            j2 = j3;
        }
        if (byteString.G() == 2) {
            byte i7 = byteString.i(0);
            byte i8 = byteString.i(1);
            while (j2 < size()) {
                byte[] bArr3 = gl3Var.a;
                i = (int) ((gl3Var.b + j) - j2);
                int i9 = gl3Var.c;
                while (i < i9) {
                    byte b5 = bArr3[i];
                    if (b5 != i7 && b5 != i8) {
                        i++;
                    }
                    i2 = gl3Var.b;
                }
                j2 += gl3Var.c - gl3Var.b;
                gl3Var = gl3Var.f;
                gl3Var.getClass();
                j = j2;
            }
        } else {
            byte[] r2 = byteString.r();
            while (j2 < size()) {
                byte[] bArr4 = gl3Var.a;
                i = (int) ((gl3Var.b + j) - j2);
                int i10 = gl3Var.c;
                while (i < i10) {
                    byte b6 = bArr4[i];
                    for (byte b7 : r2) {
                        if (b6 == b7) {
                            i2 = gl3Var.b;
                        }
                    }
                    i++;
                }
                j2 += gl3Var.c - gl3Var.b;
                gl3Var = gl3Var.f;
                gl3Var.getClass();
                j = j2;
            }
        }
        return -1L;
        return (i - i2) + j2;
    }
}
