package com.yunbao.common.http.fuel;

import com.netshield.Netshield;
import com.yunbao.common.http.IHttpClient;
import com.yunbao.common.http.IHttpRequest;
import com.yunbao.common.http.fuel.FuelRequest;
import defpackage.j30;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: /tmp/classes2.dex */
public class FuelHttpClient implements IHttpClient {
    private final String mUrl = "http://127.0.0.1:" + Netshield.getLocalhostPort(j30.G()) + "/appapi/";

    public FuelHttpClient() {
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: com.yunbao.common.http.fuel.FuelHttpClient.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        });
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.yunbao.common.http.fuel.FuelHttpClient.2
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: com.yunbao.common.http.fuel.FuelHttpClient.3
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yunbao.common.http.IHttpClient
    public void cancel(String str) {
    }

    @Override // com.yunbao.common.http.IHttpClient
    public IHttpRequest get(String str, String str2) {
        FuelRequest fuelRequest = new FuelRequest(this.mUrl, FuelRequest.Method.GET);
        fuelRequest.setServiceName(str);
        return fuelRequest;
    }

    @Override // com.yunbao.common.http.IHttpClient
    public IHttpRequest getFile(String str, String str2) {
        return new FuelRequest(str, FuelRequest.Method.GET);
    }

    @Override // com.yunbao.common.http.IHttpClient
    public IHttpRequest getString(String str, String str2) {
        return new FuelRequest(str, FuelRequest.Method.GET);
    }

    @Override // com.yunbao.common.http.IHttpClient
    public IHttpRequest post(String str, String str2) {
        FuelRequest fuelRequest = new FuelRequest(this.mUrl, FuelRequest.Method.POST);
        fuelRequest.setServiceName(str);
        return fuelRequest;
    }
}
