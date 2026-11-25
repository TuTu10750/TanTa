package com.github.kittinunf.fuel.core;

import defpackage.l81;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljavax/net/ssl/SSLSocketFactory;", "invoke"}, k = 3, mv = {1, 4, 0})
/* loaded from: /tmp/classes2.dex */
public final class FuelManager$socketFactory$2 extends Lambda implements l81 {
    final /* synthetic */ FuelManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FuelManager$socketFactory$2(FuelManager fuelManager) {
        super(0);
        this.this$0 = fuelManager;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0025, code lost:
    
        if (r2 != null) goto L8;
     */
    @Override // defpackage.l81
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final javax.net.ssl.SSLSocketFactory invoke() {
        /*
            r2 = this;
            com.github.kittinunf.fuel.core.FuelManager r2 = r2.this$0
            java.security.KeyStore r2 = r2.getKeystore()
            if (r2 == 0) goto L28
            java.lang.String r0 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()
            javax.net.ssl.TrustManagerFactory r0 = javax.net.ssl.TrustManagerFactory.getInstance(r0)
            r0.init(r2)
            java.lang.String r2 = "SSL"
            javax.net.ssl.SSLContext r2 = javax.net.ssl.SSLContext.getInstance(r2)
            javax.net.ssl.TrustManager[] r0 = r0.getTrustManagers()
            r1 = 0
            r2.init(r1, r0, r1)
            javax.net.ssl.SSLSocketFactory r2 = r2.getSocketFactory()
            if (r2 == 0) goto L28
            goto L2c
        L28:
            javax.net.ssl.SSLSocketFactory r2 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory()
        L2c:
            r2.getClass()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.kittinunf.fuel.core.FuelManager$socketFactory$2.invoke():javax.net.ssl.SSLSocketFactory");
    }
}
