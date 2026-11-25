package com.tencent.imsdk.v2;

/* loaded from: /tmp/classes2.dex */
public interface V2TIMValueCallback<T> {
    void onError(int i, String str);

    void onSuccess(T t);
}
