package com.umeng.analytics.pro;

import defpackage.xr4;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: /tmp/classes2.dex */
public class dw extends ed {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final ei h = new ei();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    /* loaded from: /tmp/classes2.dex */
    public static class a implements ef {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        @Override // com.umeng.analytics.pro.ef
        public ed a(er erVar) {
            dw dwVar = new dw(erVar, this.a, this.b);
            int i = this.c;
            if (i != 0) {
                dwVar.c(i);
            }
            return dwVar;
        }
    }

    public dw(er erVar) {
        this(erVar, false, true);
    }

    public dw(er erVar, boolean z, boolean z2) {
        super(erVar);
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        d(i2);
        return this.g.d(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.ed
    public ByteBuffer A() {
        int w = w();
        d(w);
        if (this.g.h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.g.f(), this.g.g(), w);
            this.g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.g.d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(byte b2) {
        byte[] bArr = this.i;
        bArr[0] = b2;
        this.g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(double d) {
        a(Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(int i) {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(long j) {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(dy dyVar) {
        a(dyVar.b);
        a(dyVar.c);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(dz dzVar) {
        a(dzVar.a);
        a(dzVar.b);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ea eaVar) {
        a(eaVar.a);
        a(eaVar.b);
        a(eaVar.c);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(eb ebVar) {
        if (this.d) {
            a(b | ebVar.b);
            a(ebVar.a);
            a(ebVar.c);
        } else {
            a(ebVar.a);
            a(ebVar.b);
            a(ebVar.c);
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(eh ehVar) {
        a(ehVar.a);
        a(ehVar.b);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ei eiVar) {
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new dk("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(short s) {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    public String b(int i) {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new dk("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void b() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void c() {
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    @Override // com.umeng.analytics.pro.ed
    public void d() {
        a((byte) 0);
    }

    public void d(int i) {
        if (i < 0) {
            xr4.a("Negative length: ", i);
            return;
        }
        if (this.f) {
            int i2 = this.e - i;
            this.e = i2;
            if (i2 >= 0) {
                return;
            }
            xr4.a("Message length exceeded: ", i);
        }
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
        int w = w();
        if (w < 0) {
            if ((a & w) == b) {
                return new eb(z(), (byte) (w & 255), w());
            }
            throw new ee(4, "Bad version in readMessageBegin");
        }
        if (this.c) {
            throw new ee(4, "Missing version in readMessageBegin, old client?");
        }
        return new eb(b(w), u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public void i() {
    }

    @Override // com.umeng.analytics.pro.ed
    public ei j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.ed
    public void k() {
    }

    @Override // com.umeng.analytics.pro.ed
    public dy l() {
        byte u = u();
        return new dy("", u, u == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.ed
    public void m() {
    }

    @Override // com.umeng.analytics.pro.ed
    public ea n() {
        return new ea(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public void o() {
    }

    @Override // com.umeng.analytics.pro.ed
    public dz p() {
        return new dz(u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public void q() {
    }

    @Override // com.umeng.analytics.pro.ed
    public eh r() {
        return new eh(u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public void s() {
    }

    @Override // com.umeng.analytics.pro.ed
    public boolean t() {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.ed
    public byte u() {
        if (this.g.h() < 1) {
            a(this.m, 0, 1);
            return this.m[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.ed
    public short v() {
        int i;
        byte[] bArr = this.n;
        if (this.g.h() >= 2) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
            i = 0;
        }
        return (short) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
    }

    @Override // com.umeng.analytics.pro.ed
    public int w() {
        int i;
        byte[] bArr = this.o;
        if (this.g.h() >= 4) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
            i = 0;
        }
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    @Override // com.umeng.analytics.pro.ed
    public long x() {
        int i;
        byte[] bArr = this.p;
        if (this.g.h() >= 8) {
            bArr = this.g.f();
            i = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
            i = 0;
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.ed
    public double y() {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.ed
    public String z() {
        int w = w();
        if (this.g.h() < w) {
            return b(w);
        }
        try {
            String str = new String(this.g.f(), this.g.g(), w, "UTF-8");
            this.g.a(w);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new dk("JVM DOES NOT SUPPORT UTF-8");
        }
    }
}
