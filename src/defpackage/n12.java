package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.yunbao.common.CommonAppContext;
import com.yunbao.live.bean.LiveConfigBean;

/* loaded from: /tmp/classes2.dex */
public abstract class n12 {
    public static LiveConfigBean a() {
        LiveConfigBean liveConfigBean = new LiveConfigBean();
        liveConfigBean.setTargetResolution(1);
        liveConfigBean.setTargetFps(15);
        liveConfigBean.setTargetGop(1);
        liveConfigBean.setVideoKBitrate(1200);
        liveConfigBean.setVideoKBitrateMax(1500);
        liveConfigBean.setVideoKBitrateMin(800);
        liveConfigBean.setAudioKBitrate(48000);
        return liveConfigBean;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r3 == null) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b() {
        /*
            java.lang.String r0 = "NONE"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "/proc/meminfo"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r4 = 8192(0x2000, float:1.148E-41)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            if (r2 != 0) goto L48
            java.lang.String r2 = "\\s+"
            java.lang.String[] r1 = r1.split(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            r2 = 1
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            double r1 = r1.doubleValue()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            r4 = 4697254411347427328(0x4130000000000000, double:1048576.0)
            double r1 = r1 / r4
            double r1 = java.lang.Math.ceil(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            int r1 = (int) r1     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            java.lang.String r2 = "GB"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            java.lang.String r0 = defpackage.rv3.a(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            goto L48
        L43:
            r0 = move-exception
            r1 = r3
            goto L5d
        L46:
            r1 = move-exception
            goto L56
        L48:
            r3.close()     // Catch: java.io.IOException -> L4c
            goto L5c
        L4c:
            r1 = move-exception
            r1.printStackTrace()
            goto L5c
        L51:
            r0 = move-exception
            goto L5d
        L53:
            r2 = move-exception
            r3 = r1
            r1 = r2
        L56:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L43
            if (r3 == 0) goto L5c
            goto L48
        L5c:
            return r0
        L5d:
            if (r1 == 0) goto L67
            r1.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r1 = move-exception
            r1.printStackTrace()
        L67:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n12.b():java.lang.String");
    }

    public static String c() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonAppContext.n().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NONE";
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return "WIFI";
        }
        if (type != 0) {
            return "NONE";
        }
        int subtype = activeNetworkInfo.getSubtype();
        TelephonyManager telephonyManager = (TelephonyManager) CommonAppContext.n().getSystemService("phone");
        return (subtype != 13 || telephonyManager.isNetworkRoaming()) ? (subtype == 3 || subtype == 8) ? "NONE" : (subtype != 5 || telephonyManager.isNetworkRoaming()) ? (subtype == 1 || subtype == 2) ? "2G" : (subtype != 4 || telephonyManager.isNetworkRoaming()) ? "NO DISPLAY" : "2G" : "NONE" : "4G";
    }

    public static String d() {
        String a = rv3.a(Build.BRAND, "_", Build.MODEL, "_", Build.VERSION.RELEASE, "_", b(), "_", c());
        lx1.c("开播", "手机信息------> " + a);
        return a;
    }
}
