package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* loaded from: /tmp/classes2.dex */
public class aq {
    private static HostnameVerifier a;

    private static HostnameVerifier a() {
        if (a == null) {
            a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.aq.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str) || "ulogs.umeng.com".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str) || "cnlogs.umeng.com".equalsIgnoreCase(str);
                }
            };
        }
        return a;
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e = e;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a());
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(ca.b);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setReadTimeout(ca.b);
            httpsURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
            httpsURLConnection.addRequestProperty(str2, UMConfigure.sAppkey);
            httpsURLConnection.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
            httpsURLConnection.connect();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            return httpsURLConnection;
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection2 = httpsURLConnection;
            e.printStackTrace();
            return httpsURLConnection2;
        }
    }

    public static void a(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        int responseCode;
        HttpsURLConnection httpsURLConnection = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ay.a(bArr, byteArrayOutputStream);
                bArr2 = ay.a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable unused) {
                bArr2 = null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "appkey";
            }
            httpsURLConnection = a(str, str2, bArr2);
            if (httpsURLConnection != null && (responseCode = httpsURLConnection.getResponseCode()) != 200) {
                String str3 = "SC";
                if (ar.b.equals(str)) {
                    str3 = "UMC";
                } else if (ar.c.equals(str)) {
                    str3 = "EkvError";
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, str3 + " event report error, http error code: " + responseCode);
            }
            if (httpsURLConnection == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (httpsURLConnection == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        try {
            httpsURLConnection.disconnect();
        } catch (Throwable unused3) {
        }
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] readStreamToByteArray;
        byte[] bArr2 = null;
        try {
            HttpsURLConnection a2 = a(str, "ak", ay.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (a2 != null && a2.getResponseCode() == 200) {
                InputStream inputStream = a2.getInputStream();
                try {
                    readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String headerField = a2.getHeaderField("ak");
                    if (TextUtils.isEmpty(headerField)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                    } else {
                        bArr2 = ay.a(readStreamToByteArray, headerField.getBytes());
                    }
                    HelperUtils.safeClose(inputStream);
                    return bArr2;
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(inputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
