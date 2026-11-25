package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.yunbao.common.http.FileDownloadCallback;
import com.yunbao.common.http.HttpClient;
import com.yunbao.common.http.UriDownloadCallback;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class yn0 {
    public final String a;

    public yn0(String str) {
        this.a = str;
    }

    public void a() {
        HttpClient.getInstance().cancel(this.a);
    }

    public void b(Uri uri, String str, UriDownloadCallback uriDownloadCallback) {
        if (uri == null || TextUtils.isEmpty(str)) {
            return;
        }
        HttpClient.getInstance().getFile(str, this.a).headers("referer", j30.o()).execute(uri, uriDownloadCallback);
    }

    public void c(File file, String str, String str2, FileDownloadCallback fileDownloadCallback) {
        if (file == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        HttpClient.getInstance().getFile(str2, this.a).headers("referer", j30.o()).execute(file, str, fileDownloadCallback);
    }
}
