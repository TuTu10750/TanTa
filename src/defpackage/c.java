package defpackage;

import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public abstract class c {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:25:0x01ac, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(byte[] r18, int r19) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c.c(byte[], int):int");
    }

    public static final void d(ByteString byteString, lk lkVar, int i, int i2) {
        byteString.getClass();
        lkVar.getClass();
        lkVar.write(byteString.getData(), i, i2);
    }

    public static final int e(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final char[] f() {
        return a;
    }
}
