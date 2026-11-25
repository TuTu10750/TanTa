package com.yunbao.common.http;

/* loaded from: /tmp/classes2.dex */
public abstract class UriDownloadCallback {
    public void onError(Throwable th) {
    }

    public void onFinish() {
    }

    public void onProgress(float f) {
    }

    public abstract void onSuccess();
}
