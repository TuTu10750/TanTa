package com.yunbao.common.http;

import java.io.File;

/* loaded from: /tmp/classes2.dex */
public abstract class FileDownloadCallback {
    public void onError(Throwable th) {
    }

    public void onFinish() {
    }

    public void onProgress(float f) {
    }

    public abstract void onSuccess(File file);
}
