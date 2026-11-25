package defpackage;

import okhttp3.OkHttpClient;

/* loaded from: /tmp/classes2.dex */
public class ps2 {
    public static final ps2 b = new ps2();
    public OkHttpClient a;

    public OkHttpClient a() {
        if (this.a == null) {
            this.a = new OkHttpClient();
        }
        return this.a;
    }
}
