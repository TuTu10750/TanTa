package defpackage;

import com.umeng.analytics.pro.ek;
import defpackage.lk;
import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public abstract class r {
    public static final lk.b a = new lk.b();
    public static final int b = -1234567890;

    public static final boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        bArr.getClass();
        bArr2.getClass();
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final int c() {
        return b;
    }

    public static final lk.b d() {
        return a;
    }

    public static final int e(ByteString byteString, int i) {
        byteString.getClass();
        return i == b ? byteString.G() : i;
    }

    public static final int f(byte[] bArr, int i) {
        bArr.getClass();
        return i == b ? bArr.length : i;
    }

    public static final lk.b g(lk.b bVar) {
        bVar.getClass();
        return bVar == a ? new lk.b() : bVar;
    }

    public static final int h(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final long i(long j) {
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public static final short j(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final String k(byte b2) {
        return fw3.t(new char[]{c.f()[(b2 >> 4) & 15], c.f()[b2 & ek.m]});
    }

    public static final String l(int i) {
        if (i == 0) {
            return "0";
        }
        int i2 = 0;
        char[] cArr = {c.f()[(i >> 28) & 15], c.f()[(i >> 24) & 15], c.f()[(i >> 20) & 15], c.f()[(i >> 16) & 15], c.f()[(i >> 12) & 15], c.f()[(i >> 8) & 15], c.f()[(i >> 4) & 15], c.f()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        return fw3.u(cArr, i2, 8);
    }
}
