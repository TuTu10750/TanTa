package defpackage;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public final class qb3 implements sk {
    public final wr3 a;
    public final lk b;
    public boolean c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            qb3 qb3Var = qb3.this;
            if (!qb3Var.c) {
                return (int) Math.min(qb3Var.b.size(), 2147483647L);
            }
            fe1.a("closed");
            return 0;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            qb3.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            qb3 qb3Var = qb3.this;
            if (qb3Var.c) {
                fe1.a("closed");
                return 0;
            }
            if (qb3Var.b.size() == 0) {
                qb3 qb3Var2 = qb3.this;
                if (qb3Var2.a.read(qb3Var2.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return -1;
                }
            }
            return qb3.this.b.readByte() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            if (qb3.this.c) {
                fe1.a("closed");
                return 0;
            }
            r.b(bArr.length, i, i2);
            if (qb3.this.b.size() == 0) {
                qb3 qb3Var = qb3.this;
                if (qb3Var.a.read(qb3Var.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return -1;
                }
            }
            return qb3.this.b.read(bArr, i, i2);
        }

        public String toString() {
            return qb3.this + ".inputStream()";
        }
    }

    public qb3(wr3 wr3Var) {
        wr3Var.getClass();
        this.a = wr3Var;
        this.b = new lk();
    }

    @Override // defpackage.sk
    public boolean B() {
        if (!this.c) {
            return this.b.B() && this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1;
        }
        fl3.a("closed");
        return false;
    }

    @Override // defpackage.sk
    public long C(byte b, long j, long j2) {
        if (this.c) {
            fl3.a("closed");
            return 0L;
        }
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        long j3 = j;
        while (j3 < j2) {
            byte b2 = b;
            long j4 = j2;
            long C = this.b.C(b2, j3, j4);
            if (C == -1) {
                long size = this.b.size();
                if (size >= j4 || this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    break;
                }
                j3 = Math.max(j3, size);
                b = b2;
                j2 = j4;
            } else {
                return C;
            }
        }
        return -1L;
    }

    @Override // defpackage.sk
    public long D(ByteString byteString) {
        byteString.getClass();
        return g(byteString, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r10 = java.lang.Integer.toString(r8, defpackage.jy.a(16));
        r10.getClass();
        defpackage.fk.a("Expected a digit or '-' but was 0x", r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        return 0;
     */
    @Override // defpackage.sk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long G() {
        /*
            r10 = this;
            r0 = 1
            r10.r0(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.c0(r6)
            if (r8 == 0) goto L41
            lk r8 = r10.b
            byte r8 = r8.q0(r4)
            r9 = 48
            if (r8 < r9) goto L1e
            r9 = 57
            if (r8 <= r9) goto L27
        L1e:
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L29
            r5 = 45
            if (r8 == r5) goto L27
            goto L29
        L27:
            r4 = r6
            goto L8
        L29:
            if (r4 == 0) goto L2c
            goto L41
        L2c:
            r10 = 16
            int r10 = defpackage.jy.a(r10)
            java.lang.String r10 = java.lang.Integer.toString(r8, r10)
            r10.getClass()
            java.lang.String r0 = "Expected a digit or '-' but was 0x"
            defpackage.fk.a(r0, r10)
            r0 = 0
            return r0
        L41:
            lk r10 = r10.b
            long r0 = r10.G()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb3.G():long");
    }

    public boolean H(long j, ByteString byteString, int i, int i2) {
        byteString.getClass();
        if (this.c) {
            fl3.a("closed");
            return false;
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.G() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!c0(1 + j2) || this.b.q0(j2) != byteString.i(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.sk
    public String I(long j) {
        if (j < 0) {
            hk.a("limit < 0: ", j);
            return null;
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long C = C((byte) 10, 0L, j2);
        if (C != -1) {
            return b.d(this.b, C);
        }
        if (j2 < Long.MAX_VALUE && c0(j2) && this.b.q0(j2 - 1) == 13 && c0(j2 + 1) && this.b.q0(j2) == 10) {
            return b.d(this.b, j2);
        }
        lk lkVar = new lk();
        lk lkVar2 = this.b;
        lkVar2.e0(lkVar, 0L, Math.min(32L, lkVar2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.b.size(), j) + " content=" + lkVar.Z().n() + (char) 8230);
    }

    @Override // defpackage.sk
    public long P(kq3 kq3Var) {
        lk lkVar;
        kq3Var.getClass();
        long j = 0;
        while (true) {
            long read = this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
            lkVar = this.b;
            if (read == -1) {
                break;
            }
            long T = lkVar.T();
            if (T > 0) {
                j += T;
                kq3Var.write(this.b, T);
            }
        }
        if (lkVar.size() <= 0) {
            return j;
        }
        long size = j + this.b.size();
        lk lkVar2 = this.b;
        kq3Var.write(lkVar2, lkVar2.size());
        return size;
    }

    @Override // defpackage.sk
    public boolean R(long j, ByteString byteString) {
        byteString.getClass();
        return H(j, byteString, 0, byteString.G());
    }

    @Override // defpackage.sk
    public String S(Charset charset) {
        charset.getClass();
        this.b.E(this.a);
        return this.b.S(charset);
    }

    @Override // defpackage.sk
    public ByteString Z() {
        this.b.E(this.a);
        return this.b.Z();
    }

    public long b(byte b) {
        return C(b, 0L, Long.MAX_VALUE);
    }

    public long c(ByteString byteString, long j) {
        byteString.getClass();
        if (this.c) {
            fl3.a("closed");
            return 0L;
        }
        while (true) {
            long y0 = this.b.y0(byteString, j);
            if (y0 != -1) {
                return y0;
            }
            long size = this.b.size();
            if (this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - byteString.G()) + 1);
        }
    }

    @Override // defpackage.sk
    public boolean c0(long j) {
        if (j < 0) {
            hk.a("byteCount < 0: ", j);
            return false;
        }
        if (this.c) {
            fl3.a("closed");
            return false;
        }
        while (this.b.size() < j) {
            if (this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.close();
        this.b.a();
    }

    @Override // defpackage.sk
    public String f(long j) {
        r0(j);
        return this.b.f(j);
    }

    public long g(ByteString byteString, long j) {
        byteString.getClass();
        if (this.c) {
            fl3.a("closed");
            return 0L;
        }
        while (true) {
            long z0 = this.b.z0(byteString, j);
            if (z0 != -1) {
                return z0;
            }
            long size = this.b.size();
            if (this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    @Override // defpackage.sk
    public String g0() {
        return I(Long.MAX_VALUE);
    }

    @Override // defpackage.sk
    public ByteString h(long j) {
        r0(j);
        return this.b.h(j);
    }

    @Override // defpackage.sk
    public int h0() {
        r0(4L);
        return this.b.h0();
    }

    @Override // defpackage.sk
    public byte[] i0(long j) {
        r0(j);
        return this.b.i0(j);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // defpackage.sk, defpackage.rk
    public lk k() {
        return this.b;
    }

    @Override // defpackage.sk
    public short n0() {
        r0(2L);
        return this.b.n0();
    }

    @Override // defpackage.sk
    public long p0() {
        r0(8L);
        return this.b.p0();
    }

    @Override // defpackage.sk
    public sk peek() {
        return qs2.d(new nx2(this));
    }

    @Override // defpackage.sk
    public void r0(long j) {
        if (c0(j)) {
            return;
        }
        gk.a();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.b.size() == 0 && this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        }
        return this.b.read(byteBuffer);
    }

    @Override // defpackage.wr3
    public long read(lk lkVar, long j) {
        lkVar.getClass();
        if (j < 0) {
            hk.a("byteCount < 0: ", j);
            return 0L;
        }
        if (this.c) {
            fl3.a("closed");
            return 0L;
        }
        if (this.b.size() == 0 && this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1L;
        }
        return this.b.read(lkVar, Math.min(j, this.b.size()));
    }

    @Override // defpackage.sk
    public byte readByte() {
        r0(1L);
        return this.b.readByte();
    }

    @Override // defpackage.sk
    public void readFully(byte[] bArr) {
        bArr.getClass();
        try {
            r0(bArr.length);
            this.b.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.b.size() > 0) {
                lk lkVar = this.b;
                int read = lkVar.read(bArr, i, (int) lkVar.size());
                if (read == -1) {
                    jr4.a();
                    return;
                }
                i += read;
            }
            throw e;
        }
    }

    @Override // defpackage.sk
    public int readInt() {
        r0(4L);
        return this.b.readInt();
    }

    @Override // defpackage.sk
    public long readLong() {
        r0(8L);
        return this.b.readLong();
    }

    @Override // defpackage.sk
    public short readShort() {
        r0(2L);
        return this.b.readShort();
    }

    @Override // defpackage.sk
    public void skip(long j) {
        if (this.c) {
            fl3.a("closed");
            return;
        }
        while (j > 0) {
            if (this.b.size() == 0 && this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                gk.a();
                return;
            } else {
                long min = Math.min(j, this.b.size());
                this.b.skip(min);
                j -= min;
            }
        }
    }

    @Override // defpackage.sk
    public int t(ju2 ju2Var) {
        ju2Var.getClass();
        if (this.c) {
            fl3.a("closed");
            return 0;
        }
        do {
            int e = b.e(this.b, ju2Var, true);
            if (e != -2) {
                if (e == -1) {
                    return -1;
                }
                this.b.skip(ju2Var.k()[e].G());
                return e;
            }
        } while (this.a.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1);
        return -1;
    }

    @Override // defpackage.wr3
    public d54 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "buffer(" + this.a + ')';
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r5 = java.lang.Integer.toString(r2, defpackage.jy.a(16));
        r5.getClass();
        defpackage.fk.a("Expected leading [0-9a-fA-F] character but was 0x", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        return 0;
     */
    @Override // defpackage.sk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long v0() {
        /*
            r5 = this;
            r0 = 1
            r5.r0(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.c0(r2)
            if (r2 == 0) goto L49
            lk r2 = r5.b
            long r3 = (long) r0
            byte r2 = r2.q0(r3)
            r3 = 48
            if (r2 < r3) goto L1e
            r3 = 57
            if (r2 <= r3) goto L2f
        L1e:
            r3 = 97
            if (r2 < r3) goto L26
            r3 = 102(0x66, float:1.43E-43)
            if (r2 <= r3) goto L2f
        L26:
            r3 = 65
            if (r2 < r3) goto L31
            r3 = 70
            if (r2 <= r3) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L49
        L34:
            r5 = 16
            int r5 = defpackage.jy.a(r5)
            java.lang.String r5 = java.lang.Integer.toString(r2, r5)
            r5.getClass()
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            defpackage.fk.a(r0, r5)
            r0 = 0
            return r0
        L49:
            lk r5 = r5.b
            long r0 = r5.v0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb3.v0():long");
    }

    @Override // defpackage.sk
    public InputStream w0() {
        return new a();
    }

    @Override // defpackage.sk
    public void x0(lk lkVar, long j) {
        lkVar.getClass();
        try {
            r0(j);
            this.b.x0(lkVar, j);
        } catch (EOFException e) {
            lkVar.E(this.b);
            throw e;
        }
    }

    @Override // defpackage.sk
    public byte[] y() {
        this.b.E(this.a);
        return this.b.y();
    }

    @Override // defpackage.sk
    public long z(ByteString byteString) {
        byteString.getClass();
        return c(byteString, 0L);
    }
}
