package com.umeng.analytics.pro;

import defpackage.xr4;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: /tmp/classes2.dex */
public class dx extends ed {
    private static final ei d = new ei("");
    private static final dy e = new dy("", (byte) 0, 0);
    private static final byte[] f;
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;
    byte[] a;
    byte[] b;
    byte[] c;
    private dc m;
    private short n;
    private dy o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* loaded from: /tmp/classes2.dex */
    public static class a implements ef {
        private final long a;

        public a() {
            this.a = -1L;
        }

        public a(int i) {
            this.a = i;
        }

        @Override // com.umeng.analytics.pro.ef
        public ed a(er erVar) {
            return new dx(erVar, this.a);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        public static final byte a = 1;
        public static final byte b = 2;
        public static final byte c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    static {
        f = r0;
        byte[] bArr = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    }

    public dx(er erVar) {
        this(erVar, -1L);
    }

    public dx(er erVar, long j2) {
        super(erVar);
        this.m = new dc(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j2;
    }

    private int E() {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g + i2];
                i3 |= (b2 & Byte.MAX_VALUE) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & Byte.MAX_VALUE) << i5;
                if ((u & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] f2 = this.g.f();
            int g = this.g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                j3 |= (r7 & Byte.MAX_VALUE) << i3;
                if ((f2[g + i2] & 128) != 128) {
                    this.g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                j2 |= (r0 & Byte.MAX_VALUE) << i2;
                if ((u() & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private long a(byte[] bArr) {
        return (bArr[0] & 255) | ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private void a(dy dyVar, byte b2) {
        if (b2 == -1) {
            b2 = e(dyVar.b);
        }
        short s = dyVar.c;
        short s2 = this.n;
        if (s <= s2 || s - s2 > 15) {
            b(b2);
            a(dyVar.c);
        } else {
            d(b2 | ((s - s2) << 4));
        }
        this.n = dyVar.c;
    }

    private void a(byte[] bArr, int i2, int i3) {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    private void b(byte b2) {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.g.b(bArr);
    }

    private void b(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i2 & (-128);
            byte[] bArr = this.a;
            if (i4 == 0) {
                bArr[i3] = (byte) i2;
                this.g.b(bArr, 0, i3 + 1);
                return;
            } else {
                bArr[i3] = (byte) ((i2 & 127) | 128);
                i2 >>>= 7;
                i3++;
            }
        }
    }

    private void b(long j2) {
        int i2 = 0;
        while (true) {
            long j3 = (-128) & j2;
            byte[] bArr = this.b;
            if (j3 == 0) {
                bArr[i2] = (byte) j2;
                this.g.b(bArr, 0, i2 + 1);
                return;
            } else {
                bArr[i2] = (byte) ((127 & j2) | 128);
                j2 >>>= 7;
                i2++;
            }
        }
    }

    private int c(int i2) {
        return (i2 << 1) ^ (i2 >> 31);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & ek.m;
        return i2 == 1 || i2 == 2;
    }

    private byte d(byte b2) {
        byte b3 = (byte) (b2 & ek.m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return ek.m;
            case 10:
                return ek.l;
            case 11:
                return ek.k;
            case 12:
                return (byte) 12;
            default:
                xr4.a("don't know what type: ", b3);
                return (byte) 0;
        }
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private void d(int i2) {
        b((byte) i2);
    }

    private byte e(byte b2) {
        return f[b2];
    }

    private byte[] e(int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) {
        if (i2 < 0) {
            xr4.a("Negative length: ", i2);
            return;
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        xr4.a("Length exceeded max allowed: ", i2);
    }

    private int g(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    @Override // com.umeng.analytics.pro.ed
    public ByteBuffer A() {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.ed
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.ed
    public void a() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(byte b2) {
        b(b2);
    }

    public void a(byte b2, int i2) {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(double d2) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(int i2) {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(long j2) {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(dy dyVar) {
        if (dyVar.b == 2) {
            this.o = dyVar;
        } else {
            a(dyVar, (byte) -1);
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(dz dzVar) {
        a(dzVar.a, dzVar.b);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ea eaVar) {
        int i2 = eaVar.c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(eaVar.b) | (e(eaVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(eb ebVar) {
        b(h);
        d(((ebVar.b << 5) & (-32)) | 1);
        b(ebVar.c);
        a(ebVar.a);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(eh ehVar) {
        a(ehVar.a, ehVar.b);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ei eiVar) {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new dk("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ByteBuffer byteBuffer) {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(short s) {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(boolean z) {
        dy dyVar = this.o;
        if (dyVar == null) {
            b(z ? (byte) 1 : (byte) 2);
        } else {
            a(dyVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void b() {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.ed
    public void c() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void d() {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.ed
    public void e() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void f() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void g() {
    }

    @Override // com.umeng.analytics.pro.ed
    public eb h() {
        byte u = u();
        if (u != -126) {
            throw new ee("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
        }
        byte u2 = u();
        byte b2 = (byte) (u2 & j);
        if (b2 != 1) {
            xr4.a("Expected version 1 but got ", b2);
            return null;
        }
        return new eb(z(), (byte) ((u2 >> 5) & 3), E());
    }

    @Override // com.umeng.analytics.pro.ed
    public void i() {
    }

    @Override // com.umeng.analytics.pro.ed
    public ei j() {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.ed
    public void k() {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.ed
    public dy l() {
        byte u = u();
        if (u == 0) {
            return e;
        }
        short s = (short) ((u & 240) >> 4);
        short v = s == 0 ? v() : (short) (this.n + s);
        byte b2 = (byte) (u & ek.m);
        dy dyVar = new dy("", d(b2), v);
        if (c(u)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = dyVar.c;
        return dyVar;
    }

    @Override // com.umeng.analytics.pro.ed
    public void m() {
    }

    @Override // com.umeng.analytics.pro.ed
    public ea n() {
        int E = E();
        byte u = E == 0 ? (byte) 0 : u();
        return new ea(d((byte) (u >> 4)), d((byte) (u & ek.m)), E);
    }

    @Override // com.umeng.analytics.pro.ed
    public void o() {
    }

    @Override // com.umeng.analytics.pro.ed
    public dz p() {
        byte u = u();
        int i2 = (u >> 4) & 15;
        if (i2 == 15) {
            i2 = E();
        }
        return new dz(d(u), i2);
    }

    @Override // com.umeng.analytics.pro.ed
    public void q() {
    }

    @Override // com.umeng.analytics.pro.ed
    public eh r() {
        return new eh(p());
    }

    @Override // com.umeng.analytics.pro.ed
    public void s() {
    }

    @Override // com.umeng.analytics.pro.ed
    public boolean t() {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.ed
    public byte u() {
        int h2 = this.g.h();
        er erVar = this.g;
        if (h2 <= 0) {
            erVar.d(this.c, 0, 1);
            return this.c[0];
        }
        byte b2 = erVar.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.ed
    public short v() {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.ed
    public int w() {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.ed
    public long x() {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.ed
    public double y() {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.ed
    public String z() {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.g.f(), this.g.g(), E, "UTF-8");
            this.g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new dk("UTF-8 not supported!");
        }
    }
}
