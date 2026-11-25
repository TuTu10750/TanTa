package com.tencent.imsdk.common;

import com.tencent.imsdk.common.HttpClient;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /tmp/classes2.dex */
public class HttpClient$1$1 extends SSLSocketFactory {
    final /* synthetic */ HttpClient.1 this$0;
    final /* synthetic */ HttpsURLConnection val$httpsConn;

    public HttpClient$1$1(HttpClient.1 r1, HttpsURLConnection httpsURLConnection) {
        this.this$0 = r1;
        this.val$httpsConn = httpsURLConnection;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(str, i, inetAddress, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(inetAddress, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        String requestProperty = this.val$httpsConn.getRequestProperty("Host");
        SSLSocket sSLSocket = (SSLSocket) HttpsURLConnection.getDefaultSSLSocketFactory().createSocket(socket, requestProperty, i, z);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        sSLParameters.setServerNames(Arrays.asList(new SNIHostName(requestProperty)));
        sSLSocket.setSSLParameters(sSLParameters);
        return sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return HttpsURLConnection.getDefaultSSLSocketFactory().getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return HttpsURLConnection.getDefaultSSLSocketFactory().getSupportedCipherSuites();
    }
}
