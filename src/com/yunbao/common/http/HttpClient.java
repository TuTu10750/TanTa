package com.yunbao.common.http;

import com.yunbao.common.http.fuel.FuelHttpClient;
import defpackage.rx1;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class HttpClient {
    private static HttpClient sInstance;
    private final IHttpClient mHttpClientImpl = new FuelHttpClient();

    private HttpClient() {
    }

    public static HttpClient getInstance() {
        if (sInstance == null) {
            synchronized (HttpClient.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new HttpClient();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public void cancel(String str) {
        this.mHttpClientImpl.cancel(str);
    }

    public IHttpRequest get(String str, String str2) {
        return this.mHttpClientImpl.get(str, str2).params("language", rx1.c().d());
    }

    public IHttpRequest get(String str, String str2, Map<String, String> map) {
        IHttpRequest iHttpRequest = get(str, str2);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                iHttpRequest.params(entry.getKey(), entry.getValue());
            }
        }
        iHttpRequest.params("language", rx1.c().d());
        return iHttpRequest;
    }

    public IHttpRequest getFile(String str, String str2) {
        return this.mHttpClientImpl.getFile(str, str2);
    }

    public IHttpRequest getString(String str, String str2) {
        return this.mHttpClientImpl.getString(str, str2);
    }

    public IHttpRequest post(String str, String str2) {
        return this.mHttpClientImpl.post(str, str2).params("language", rx1.c().d());
    }

    public IHttpRequest post(String str, String str2, Map<String, String> map) {
        IHttpRequest post = post(str, str2);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                post.params(entry.getKey(), entry.getValue());
            }
        }
        post.params("language", rx1.c().d());
        return post;
    }
}
