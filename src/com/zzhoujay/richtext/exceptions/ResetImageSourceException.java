package com.zzhoujay.richtext.exceptions;

/* loaded from: /tmp/classes2.dex */
public class ResetImageSourceException extends RuntimeException {
    private static final String MESSAGE = "ImageHolder的source只能在INIT阶段修改";

    public ResetImageSourceException() {
        super(MESSAGE);
    }

    public ResetImageSourceException(Throwable th) {
        super(MESSAGE, th);
    }

    public ResetImageSourceException(Throwable th, boolean z, boolean z2) {
        super(MESSAGE, th, z, z2);
    }
}
