package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* loaded from: /tmp/classes2.dex */
public class c {
    private static HandlerThread A = null;
    private static HashMap<Integer, a> B = null;
    private static final int C = 256;
    public static Handler a = null;
    public static final int b = 101;
    public static final int c = 102;
    public static final int d = 103;
    public static final int e = 104;
    public static final int f = 105;
    public static final int g = 106;
    public static final int h = 107;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 201;
    public static final int m = 202;
    public static final int n = 203;
    public static final int o = 204;
    public static final int p = 301;
    public static final int q = 302;
    public static final int r = 303;
    public static final int s = 304;
    public static final int t = 305;
    public static final int u = 310;
    public static final int v = 311;
    public static final int w = 312;
    public static final int x = 313;
    public static final int y = 401;
    public static final int z = 402;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(Object obj, int i);
    }

    private c() {
    }

    private static synchronized void a() {
        synchronized (c.class) {
            try {
                if (A == null) {
                    HandlerThread handlerThread = new HandlerThread("ccg_dispatch");
                    A = handlerThread;
                    handlerThread.start();
                    if (a == null) {
                        a = new Handler(A.getLooper()) { // from class: com.umeng.ccg.c.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                c.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, int i2, int i3, a aVar, Object obj, long j2) {
        if (context == null || aVar == null) {
            return;
        }
        if (B == null) {
            B = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i3 / 100);
        if (!B.containsKey(valueOf)) {
            B.put(valueOf, aVar);
        }
        if (A == null || a == null) {
            a();
        }
        try {
            Handler handler = a;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i2;
                obtainMessage.arg1 = i3;
                obtainMessage.obj = obj;
                a.sendMessageDelayed(obtainMessage, j2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i2, a aVar, Object obj) {
        a(context, 256, i2, aVar, obj, 0L);
    }

    public static void a(Context context, int i2, a aVar, Object obj, long j2) {
        a(context, 256, i2, aVar, obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i2 / 100);
        HashMap<Integer, a> hashMap = B;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? B.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i2);
        }
    }
}
