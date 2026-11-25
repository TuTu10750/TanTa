package defpackage;

import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: /tmp/classes2.dex */
public final class i20$d implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        chain.getClass();
        return chain.proceed(chain.request()).newBuilder().removeHeader("Pragma").removeHeader("Expires").removeHeader("ETag").removeHeader("Last-Modified").header("Cache-Control", "public, max-age=31536000, immutable").build();
    }
}
