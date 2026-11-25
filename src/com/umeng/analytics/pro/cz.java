package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: /tmp/classes2.dex */
public class cz {
    public static final String a = "cl_count";
    public static final String b = "interval_";
    public static final String c = "config_ts";
    private static final String d = "ncc_sp_config_file";

    private cz() {
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(d, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(Context context) {
        SharedPreferences a2;
        if (context == null || (a2 = a(context)) == null) {
            return;
        }
        a2.edit().putInt("cl_count", a2.getInt("cl_count", 0) + 1).apply();
    }

    public static int c(Context context) {
        SharedPreferences a2;
        if (context == null || (a2 = a(context)) == null) {
            return 0;
        }
        return a2.getInt("cl_count", 0);
    }
}
