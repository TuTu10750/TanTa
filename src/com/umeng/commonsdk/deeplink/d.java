package com.umeng.commonsdk.deeplink;

import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public final class d {
    private static final String a = "DeepLinkRequest";

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(int i, Throwable th);

        void a(JSONObject jSONObject, String str, String str2);
    }

    private d() {
    }

    public static void a(JSONObject jSONObject, a aVar) {
        byte[] bytes;
        byte[] a2;
        HttpsURLConnection httpsURLConnection;
        if (aVar == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] DDL request start: url=https://one.umops.com/api/deferredLink");
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                byte[] bytes2 = jSONObject.toString().getBytes("UTF-8");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ay.a(bytes2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bytes = UMConfigure.sAppkey.getBytes("UTF-8");
                a2 = ay.a(byteArray, bytes);
                httpsURLConnection = (HttpsURLConnection) new URL("https://one.umops.com/api/deferredLink").openConnection();
            } catch (Throwable th) {
                th = th;
            }
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(ca.b);
                httpsURLConnection.setReadTimeout(ca.b);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.addRequestProperty("Content-Type", "application/json");
                httpsURLConnection.addRequestProperty("appkey", UMConfigure.sAppkey);
                httpsURLConnection.connect();
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
                outputStream.close();
                if (httpsURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    try {
                        String str = new String(ay.a(HelperUtils.readStreamToByteArray(inputStream), bytes), "UTF-8");
                        JSONObject jSONObject2 = new JSONObject(str);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] DDL response: ".concat(str));
                        int optInt = jSONObject2.optInt(cl.i, 0);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] DDL response status=" + optInt);
                        if (optInt == 1) {
                            aVar.a(jSONObject2.optJSONObject("params"), jSONObject2.optString("targetPath", ""), jSONObject2.optString("refId", ""));
                        } else {
                            aVar.a(-1, new Exception("服务端匹配失败。"));
                        }
                        HelperUtils.safeClose(inputStream);
                    } catch (Throwable th2) {
                        HelperUtils.safeClose(inputStream);
                        throw th2;
                    }
                } else {
                    aVar.a(-4, new Exception("网络错误。"));
                }
                httpsURLConnection.disconnect();
            } catch (Throwable th3) {
                th = th3;
                httpsURLConnection2 = httpsURLConnection;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [deeplink] DDL request error: " + th.getMessage());
                    aVar.a(-4, new Exception("网络错误。"));
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                } catch (Throwable th4) {
                    if (httpsURLConnection2 != null) {
                        try {
                            httpsURLConnection2.disconnect();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
