package com.zzhoujay.richtext.ig;

import com.zzhoujay.richtext.callback.BitmapStream;
import com.zzhoujay.richtext.exceptions.HttpResponseCodeException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: /tmp/classes2.dex */
public class DefaultImageDownloader implements ImageDownloader {
    private static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.zzhoujay.richtext.ig.DefaultImageDownloader.1
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    public static final String GLOBAL_ID = "com.zzhoujay.richtext.ig.DefaultImageDownloader";
    private static SSLContext sslContext;

    /* loaded from: /tmp/classes2.dex */
    public static class BitmapStreamImpl implements BitmapStream {
        private HttpURLConnection connection;
        private InputStream inputStream;
        private final String url;

        private BitmapStreamImpl(String str) {
            this.url = str;
        }

        @Override // com.zzhoujay.richtext.callback.Closeable
        public void close() {
            InputStream inputStream = this.inputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.connection;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

        @Override // com.zzhoujay.richtext.callback.BitmapStream
        public InputStream getInputStream() {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
            this.connection = httpURLConnection;
            httpURLConnection.setConnectTimeout(10000);
            this.connection.setDoInput(true);
            this.connection.addRequestProperty("Connection", "Keep-Alive");
            HttpURLConnection httpURLConnection2 = this.connection;
            if (httpURLConnection2 instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                httpsURLConnection.setHostnameVerifier(DefaultImageDownloader.DO_NOT_VERIFY);
                httpsURLConnection.setSSLSocketFactory(DefaultImageDownloader.sslContext.getSocketFactory());
            }
            this.connection.connect();
            int responseCode = this.connection.getResponseCode();
            if (responseCode != 200) {
                throw new HttpResponseCodeException(responseCode);
            }
            InputStream inputStream = this.connection.getInputStream();
            this.inputStream = inputStream;
            return inputStream;
        }
    }

    static {
        SSLContext sSLContext;
        X509TrustManager x509TrustManager = new X509TrustManager() { // from class: com.zzhoujay.richtext.ig.DefaultImageDownloader.2
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
        };
        try {
            sSLContext = SSLContext.getInstance("SSL");
            sslContext = sSLContext;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e = e;
        }
        try {
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
        } catch (KeyManagementException e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    @Override // com.zzhoujay.richtext.ig.ImageDownloader
    public BitmapStream download(String str) {
        return new BitmapStreamImpl(str);
    }
}
