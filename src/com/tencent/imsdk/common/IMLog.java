package com.tencent.imsdk.common;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: /tmp/classes2.dex */
public class IMLog {
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_OFF = 0;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARN = 5;
    private static final String TAG = "IMLog";

    public static void d(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
    }

    private static void log(int i, String str, String str2) {
        if (!SystemUtil.loadIMLibrary()) {
            Log.e(TAG, "libImSDK.so is not loaded");
            return;
        }
        if (i < 0 || i > 6) {
            e(TAG, "invalid logLevel： " + i);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            e(TAG, "empty logTag");
        } else if (TextUtils.isEmpty(str2)) {
            e(TAG, "empty logContent");
        } else {
            nativeWriteLog(i, str, "", 0, str2);
        }
    }

    public static native void nativeWriteLog(int i, String str, String str2, int i2, String str3);

    public static void v(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
    }

    public static void writeException(String str, String str2, Throwable th) {
        if (!SystemUtil.loadIMLibrary()) {
            Log.e(TAG, "libImSDK.so is not loaded");
            return;
        }
        Log.e(str, str2 + " exception : " + Log.getStackTraceString(th));
    }
}
