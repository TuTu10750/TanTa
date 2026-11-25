package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class d {
    private static ICrashClient a = null;
    private static int b = 3;
    private static volatile List<ValueCallback<Bundle>> c;
    private static volatile List<ValueCallback<Bundle>> d;
    private static volatile List<ValueCallback<Bundle>> e;
    private static volatile List<ValueCallback<Bundle>> f;
    private static final Object g = new Object();

    public static File a(File file) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return file;
    }

    public static String a(String str, boolean z) {
        ICrashClient iCrashClient = a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z) : "";
    }

    public static void a(ICrashClient iCrashClient) {
        a = iCrashClient;
    }

    public static void a(String str, int i, int i2) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i, i2);
        }
        if (f != null) {
            synchronized (f) {
                try {
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                } finally {
                }
                for (ValueCallback<Bundle> valueCallback : f) {
                    Bundle bundle = new Bundle();
                    bundle.putString("processName", str);
                    bundle.putInt("key", i);
                    bundle.putInt("count", i2);
                    valueCallback.onReceiveValue(bundle);
                }
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean equals = e.h().equals(str2);
        if (a != null) {
            File file = new File(str);
            try {
                if (equals) {
                    a.onLogGenerated(file, str3);
                } else {
                    a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        List<ValueCallback<Bundle>> list = c;
        if (!equals) {
            list = d;
        }
        if (list != null) {
            synchronized (list) {
                try {
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                } finally {
                }
                for (ValueCallback<Bundle> valueCallback : list) {
                    Bundle bundle = new Bundle();
                    bundle.putString("filePathName", str);
                    if (!equals) {
                        bundle.putString("processName", str2);
                    }
                    bundle.putString("logType", str3);
                    valueCallback.onReceiveValue(bundle);
                }
            }
        }
    }

    public static void a(boolean z) {
        ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (e != null) {
            synchronized (e) {
                try {
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                } finally {
                }
                for (ValueCallback<Bundle> valueCallback : e) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isJava", z);
                    valueCallback.onReceiveValue(bundle);
                }
            }
        }
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (c == null) {
            synchronized (g) {
                try {
                    if (c == null) {
                        c = new ArrayList();
                    }
                } finally {
                }
            }
        }
        synchronized (c) {
            try {
                if (c.size() >= b) {
                    return false;
                }
                c.add(valueCallback);
                return true;
            } finally {
            }
        }
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (d == null) {
            synchronized (g) {
                try {
                    if (d == null) {
                        d = new ArrayList();
                    }
                } finally {
                }
            }
        }
        synchronized (d) {
            try {
                if (d.size() >= b) {
                    return false;
                }
                d.add(valueCallback);
                return true;
            } finally {
            }
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (e == null) {
            synchronized (g) {
                try {
                    if (e == null) {
                        e = new ArrayList();
                    }
                } finally {
                }
            }
        }
        synchronized (e) {
            try {
                if (e.size() >= b) {
                    return false;
                }
                e.add(valueCallback);
                return true;
            } finally {
            }
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f == null) {
            synchronized (g) {
                try {
                    if (f == null) {
                        f = new ArrayList();
                    }
                } finally {
                }
            }
        }
        synchronized (f) {
            try {
                if (f.size() >= b) {
                    return false;
                }
                f.add(valueCallback);
                return true;
            } finally {
            }
        }
    }
}
