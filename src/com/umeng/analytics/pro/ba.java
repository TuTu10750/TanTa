package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* loaded from: /tmp/classes2.dex */
public class ba {
    public static Handler a = null;
    public static final int b = 101;
    private static HandlerThread c = null;
    private static HashMap<Integer, a> d = null;
    private static final int e = 256;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(Object obj, int i);
    }

    private ba() {
    }

    private static synchronized void a() {
        synchronized (ba.class) {
            try {
                if (c == null) {
                    HandlerThread handlerThread = new HandlerThread("ck_dispatch");
                    c = handlerThread;
                    handlerThread.start();
                    if (a == null) {
                        a = new Handler(c.getLooper()) { // from class: com.umeng.analytics.pro.ba.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (message.what != 256) {
                                    return;
                                }
                                ba.b(message);
                            }
                        };
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, int i, int i2, a aVar, Object obj, long j) {
        if (context == null || aVar == null) {
            return;
        }
        if (d == null) {
            d = new HashMap<>();
        }
        Integer valueOf = Integer.valueOf(i2 / 100);
        if (!d.containsKey(valueOf)) {
            d.put(valueOf, aVar);
        }
        if (c == null || a == null) {
            a();
        }
        try {
            Handler handler = a;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = i;
                obtainMessage.arg1 = i2;
                obtainMessage.obj = obj;
                a.sendMessageDelayed(obtainMessage, j);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i, a aVar, Object obj) {
        a(context, 256, i, aVar, obj, 0L);
    }

    public static void a(Context context, int i, a aVar, Object obj, long j) {
        a(context, 256, i, aVar, obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i = message.arg1;
        Object obj = message.obj;
        Integer valueOf = Integer.valueOf(i / 100);
        HashMap<Integer, a> hashMap = d;
        if (hashMap == null) {
            return;
        }
        a aVar = hashMap.containsKey(valueOf) ? d.get(valueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i);
        }
    }
}
