package com.yunbao.common.http;

/* loaded from: /tmp/classes2.dex */
public abstract class StringHttpCallback {
    public void onError(Throwable th) {
    }

    public void onFinish() {
    }

    public abstract void onSuccess(String str);
}
