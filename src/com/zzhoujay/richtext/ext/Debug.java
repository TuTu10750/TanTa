package com.zzhoujay.richtext.ext;

import android.util.Log;
import com.zzhoujay.richtext.RichText;

/* loaded from: /tmp/classes2.dex */
public class Debug {
    public static final String PREF = " --> ";
    private static final String TAG = "RichText";

    public static void e(Throwable th) {
        if (RichText.debugMode) {
            th.printStackTrace();
        }
    }

    public static void log(String str, String str2) {
        if (RichText.debugMode) {
            Log.i(TAG, str + PREF + str2);
        }
    }

    public static void log(String str, String str2, Throwable th) {
        if (RichText.debugMode) {
            Log.i(TAG, str + PREF + str2, th);
        }
    }

    public static void loge(String str, String str2) {
        Log.e(TAG, str + PREF + str2);
    }

    public static void loge(String str, String str2, Throwable th) {
        Log.e(TAG, str + PREF + str2, th);
    }
}
