package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.analytics.pro.cc;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.net.URL;

/* loaded from: /tmp/classes2.dex */
public class ca {
    public static final String a = "resolve.umeng.com";
    public static final int b = 15000;
    private static ce c = null;
    private static volatile int d = -1;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public static final ca a = new ca();

        private a() {
        }
    }

    private ca() {
    }

    public static ca a() {
        return a.a;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return "https://" + str + "/" + str2;
    }

    public static String b(String str) {
        try {
            String c2 = c(str);
            return str.substring(str.indexOf(c2) + c2.length() + 1);
        } catch (Throwable unused) {
            return "";
        }
    }

    private String c() {
        if (c == null) {
            c = ce.b();
        }
        cc ccVar = new cc("https://resolve.umeng.com/resolve", cc.a.GET, null, c);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 发送domain下发请求。");
        return ccVar.a(b, "");
    }

    private static String c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        c();
        String c2 = ce.b().c();
        if (!TextUtils.isEmpty(c2)) {
            str2 = "https://" + c2 + "/" + str;
        }
        return str2;
    }

    public synchronized boolean b() {
        try {
            if (d < 0) {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "cj_domain", "0");
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> cj_domain读取值：" + imprintProperty);
                if (SdkVersion.MINI_VERSION.equalsIgnoreCase(imprintProperty)) {
                    d = 1;
                } else {
                    d = 0;
                }
            }
            return d <= 0;
        } catch (Throwable th) {
            throw th;
        }
    }
}
