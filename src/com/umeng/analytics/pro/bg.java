package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;

/* loaded from: /tmp/classes2.dex */
public class bg {
    private static bf a = null;
    private static String b = null;
    private static boolean c = false;

    public static synchronized String a(Context context) {
        synchronized (bg.class) {
            if (!UMConfigure.shouldCollectOaid()) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAID(): oaid开关已关闭。");
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context == null) {
                return null;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return null;
            }
            if (a == null) {
                a = bi.a();
            }
            bf bfVar = a;
            if (bfVar != null) {
                try {
                    String a2 = bfVar.a(context);
                    if (!TextUtils.isEmpty(a2)) {
                        b = a2;
                    }
                    c = true;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "OpenDeviceId:getOAID() result: " + b);
                    return b;
                } catch (Throwable unused) {
                }
            }
            return null;
        }
    }

    public static String b(Context context) {
        if (UMConfigure.shouldCollectOaid()) {
            return c ? b : a(context);
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAIDFromCache(): oaid开关已关闭。");
        return null;
    }

    @Deprecated
    public static synchronized String c(Context context) {
        synchronized (bg.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaid(): oaid开关已关闭。");
            return null;
        }
    }

    @Deprecated
    public static synchronized String d(Context context) {
        synchronized (bg.class) {
            if (UMConfigure.shouldCollectOaid()) {
                return null;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaidFromCache(): oaid开关已关闭。");
            return null;
        }
    }
}
