package com.yunbao.common.http;

/* loaded from: /tmp/classes2.dex */
public interface IHttpClient {
    void cancel(String str);

    IHttpRequest get(String str, String str2);

    IHttpRequest getFile(String str, String str2);

    IHttpRequest getString(String str, String str2);

    IHttpRequest post(String str, String str2);
}
