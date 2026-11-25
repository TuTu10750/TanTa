package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /tmp/classes2.dex */
public abstract class ir4 {
    public static final byte[] a(String str) {
        str.getClass();
        byte[] bytes = str.getBytes(ly.b);
        bytes.getClass();
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        bArr.getClass();
        return new String(bArr, ly.b);
    }
}
