package com.zzhoujay.richtext.exceptions;

/* loaded from: /tmp/classes2.dex */
public class BitmapCacheLoadFailureException extends Exception {
    private static final String MESSAGE = "Bitmap 缓存加载失败";

    public BitmapCacheLoadFailureException() {
        super(MESSAGE);
    }

    public BitmapCacheLoadFailureException(Throwable th) {
        super(MESSAGE, th);
    }

    public BitmapCacheLoadFailureException(Throwable th, boolean z, boolean z2) {
        super(MESSAGE, th, z, z2);
    }
}
