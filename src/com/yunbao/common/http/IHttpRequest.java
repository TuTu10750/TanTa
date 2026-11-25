package com.yunbao.common.http;

import android.net.Uri;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public interface IHttpRequest {
    void execute(Uri uri, UriDownloadCallback uriDownloadCallback);

    void execute(HttpCallback httpCallback);

    void execute(StringHttpCallback stringHttpCallback);

    void execute(File file, String str, FileDownloadCallback fileDownloadCallback);

    IHttpRequest headers(String str, String str2);

    IHttpRequest params(String str, Object obj);
}
