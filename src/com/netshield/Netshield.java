package com.netshield;

/* loaded from: /tmp/classes2.dex */
public class Netshield {
    static {
        System.loadLibrary("netshield");
    }

    public static native String getClientIP();

    public static native int getLocalhostPort(String str);

    public static native int startHookService();

    public static native int startService(String str, String str2);

    public static native void stopService();
}
