package com.zzhoujay.richtext.exceptions;

/* loaded from: /tmp/classes2.dex */
public class BitmapCacheNotFoundException extends Exception {
    private static final String MESSAGE = "Bitmap 缓存不存在";

    public BitmapCacheNotFoundException() {
        super(MESSAGE);
    }

    public BitmapCacheNotFoundException(Throwable th) {
        super(MESSAGE, th);
    }

    public BitmapCacheNotFoundException(Throwable th, boolean z, boolean z2) {
        super(MESSAGE, th, z, z2);
    }
}
