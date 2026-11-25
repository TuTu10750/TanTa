package com.github.kittinunf.fuel.util;

import com.umeng.analytics.pro.ek;
import defpackage.b30;
import defpackage.fy;
import defpackage.s20;
import defpackage.t20;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\t\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\tH\u0002\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\t*\u00020\t\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\n\u0010\u000f\u001a\u00020\t*\u00020\t\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\t*\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"BASE64", "", "BASE64_URL_SAFE", "regular", "", "", "", "urlSafe", "decodeBase64", "", "decodeBase64ToArray", "decodeBase64ToString", "encodeBase64", "encodeBase64ToArray", "map", "encodeBase64ToString", "encodeBase64Url", "encodeBase64UrlToString", "fuel"}, k = 2, mv = {1, 4, 0})
/* loaded from: /tmp/classes2.dex */
public final class Base64Kt {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;
    private static final List<Iterable<Character>> regular;
    private static final List<Iterable<Character>> urlSafe;

    static {
        List<Iterable<Character>> n = s20.n(new fy('A', 'Z'), new fy('a', 'z'), new fy('0', '9'), s20.n('+', '/'));
        regular = n;
        urlSafe = s20.n(new fy('A', 'Z'), new fy('a', 'z'), new fy('0', '9'), s20.n('-', '_'));
        List x = t20.x(n);
        ArrayList arrayList = new ArrayList(t20.v(x, 10));
        Iterator it = x.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        BASE64 = b30.F0(arrayList);
        List x2 = t20.x(urlSafe);
        ArrayList arrayList2 = new ArrayList(t20.v(x2, 10));
        Iterator it2 = x2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        BASE64_URL_SAFE = b30.F0(arrayList2);
    }

    public static final byte[] decodeBase64(String str) {
        str.getClass();
        byte[] decodeBase64ToArray = decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return decodeBase64ToArray;
        }
        return null;
    }

    private static final byte[] decodeBase64ToArray(String str) {
        int i;
        char charAt;
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = str.charAt(i6);
            if ('A' <= charAt2 && 'Z' >= charAt2) {
                i = charAt2 - 'A';
            } else if ('a' <= charAt2 && 'z' >= charAt2) {
                i = charAt2 - 'G';
            } else if ('0' <= charAt2 && '9' >= charAt2) {
                i = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                bArr[i5] = (byte) (i4 >> 16);
                int i7 = i5 + 2;
                bArr[i5 + 1] = (byte) (i4 >> 8);
                i5 += 3;
                bArr[i7] = (byte) i4;
            }
        }
        int i8 = i3 % 4;
        if (i8 == 1) {
            return null;
        }
        if (i8 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i8 == 3) {
            int i9 = i4 << 6;
            int i10 = i5 + 1;
            bArr[i5] = (byte) (i9 >> 16);
            i5 += 2;
            bArr[i10] = (byte) (i9 >> 8);
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        return bArr2;
    }

    public static final String decodeBase64ToString(String str) {
        str.getClass();
        byte[] decodeBase64ToArray = decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new String(decodeBase64ToArray, ly.b);
        }
        return null;
    }

    public static final byte[] encodeBase64(byte[] bArr) {
        bArr.getClass();
        return encodeBase64ToArray$default(bArr, null, 1, null);
    }

    private static final byte[] encodeBase64ToArray(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i + 2;
            byte b2 = bArr[i + 1];
            i += 3;
            byte b3 = bArr[i3];
            bArr3[i2] = bArr2[(b & 255) >> 2];
            bArr3[i2 + 1] = bArr2[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr3[i2 + 2] = bArr2[((b2 & ek.m) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr3[i4] = bArr2[b3 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b4 = bArr[i];
            bArr3[i2] = bArr2[(b4 & 255) >> 2];
            bArr3[i2 + 1] = bArr2[(b4 & 3) << 4];
            bArr3[i2 + 2] = 61;
            bArr3[i2 + 3] = 61;
            return bArr3;
        }
        if (length2 != 2) {
            return bArr3;
        }
        int i5 = i + 1;
        byte b5 = bArr[i];
        byte b6 = bArr[i5];
        bArr3[i2] = bArr2[(b5 & 255) >> 2];
        bArr3[i2 + 1] = bArr2[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
        bArr3[i2 + 2] = bArr2[(b6 & ek.m) << 2];
        bArr3[i2 + 3] = 61;
        return bArr3;
    }

    public static /* synthetic */ byte[] encodeBase64ToArray$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64ToArray(bArr, bArr2);
    }

    public static final String encodeBase64ToString(String str) {
        str.getClass();
        Charset charset = ly.b;
        byte[] bytes = str.getBytes(charset);
        bytes.getClass();
        return new String(encodeBase64(bytes), charset);
    }

    public static final byte[] encodeBase64Url(byte[] bArr) {
        bArr.getClass();
        return encodeBase64ToArray(bArr, BASE64_URL_SAFE);
    }

    public static final String encodeBase64UrlToString(String str) {
        str.getClass();
        Charset charset = ly.b;
        byte[] bytes = str.getBytes(charset);
        bytes.getClass();
        return new String(encodeBase64Url(bytes), charset);
    }
}
