package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import defpackage.jr4;
import java.util.HashMap;

/* loaded from: /tmp/classes2.dex */
public class f {
    static final /* synthetic */ boolean a = true;
    private static volatile HandlerThread b;
    private static volatile HandlerThread c;
    private static volatile HandlerThread d;
    private static Handler e;
    private static Handler f;
    private static Handler g;
    private static Handler h;
    private static final HashMap<Object, Object[]> i = new HashMap<>();

    public static Handler a(int i2) {
        if (i2 == 0) {
            if (b == null) {
                a();
            }
            return e;
        }
        if (i2 == 1) {
            if (c == null) {
                b();
            }
            return f;
        }
        if (i2 == 2) {
            if (g == null) {
                g = new Handler(Looper.getMainLooper());
            }
            return g;
        }
        if (i2 == 3) {
            if (h == null) {
                c();
            }
            return h;
        }
        throw new RuntimeException("unknown thread type: " + i2);
    }

    private static synchronized void a() {
        synchronized (f.class) {
            if (b == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
                b = handlerThread;
                handlerThread.start();
                e = new Handler(b.getLooper());
            }
        }
    }

    public static void a(int i2, Object[] objArr) {
        if (i2 != 10) {
            if (a) {
                return;
            }
            jr4.a();
        } else {
            if (!a && objArr == null) {
                jr4.a();
                return;
            }
            Runnable runnable = (Runnable) objArr[0];
            HashMap<Object, Object[]> hashMap = i;
            synchronized (hashMap) {
                try {
                    if (hashMap.get(runnable) != null) {
                        hashMap.remove(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            runnable.run();
        }
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        HashMap<Object, Object[]> hashMap = i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int intValue = ((Integer) objArr[1]).intValue();
        Handler handler = intValue != 0 ? intValue != 1 ? intValue != 2 ? null : g : f : e;
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (hashMap) {
            try {
                if (hashMap.get(runnable) != null) {
                    hashMap.remove(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(int i2, Runnable runnable) {
        return a(i2, runnable, 0L);
    }

    public static boolean a(int i2, Runnable runnable, long j) {
        Handler a2;
        if (runnable == null || (a2 = a(i2)) == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        HashMap<Object, Object[]> hashMap = i;
        synchronized (hashMap) {
            hashMap.put(runnable, new Object[]{eVar, Integer.valueOf(i2)});
        }
        return a2.postDelayed(eVar, j);
    }

    private static synchronized void b() {
        synchronized (f.class) {
            if (c == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
                c = handlerThread;
                handlerThread.start();
                f = new Handler(c.getLooper());
            }
        }
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        HashMap<Object, Object[]> hashMap = i;
        synchronized (hashMap) {
            objArr = hashMap.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        synchronized (f.class) {
            if (d == null) {
                HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
                d = handlerThread;
                handlerThread.start();
                h = new Handler(d.getLooper());
            }
        }
    }
}
