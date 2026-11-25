package com.umeng.umzid;

import android.content.Context;
import android.os.Build;

/* loaded from: /tmp/classes2.dex */
public class Spy {
    public static boolean initSuccess = false;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID(Build.VERSION.SDK_INT >= 29);
        }
        return null;
    }

    public static native String getNativeID(boolean z);

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z, boolean z2, boolean z3);

    public static synchronized String getTag(Context context) {
        boolean j;
        String nativeTag;
        synchronized (Spy.class) {
            if (context != null) {
                try {
                    j = d.j(context);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                j = false;
            }
            nativeTag = getNativeTag(j, context != null ? d.i(context) : false, Build.VERSION.SDK_INT >= 29);
        }
        return nativeTag;
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
