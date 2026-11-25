package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: /tmp/classes2.dex */
public abstract class a {
    private static final int e = 1;
    private final long a;
    private final long b;
    private long c;
    private HandlerThread f;
    private Handler g;
    private boolean d = false;
    private Handler.Callback h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            a aVar;
            synchronized (a.this) {
                try {
                    if (a.this.d) {
                        return true;
                    }
                    long elapsedRealtime = a.this.c - SystemClock.elapsedRealtime();
                    a aVar2 = a.this;
                    if (elapsedRealtime <= 0) {
                        aVar2.c();
                        if (a.this.f != null) {
                            a.this.f.quit();
                        }
                    } else if (elapsedRealtime < aVar2.b) {
                        a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + a.this.b) - SystemClock.elapsedRealtime();
                        while (true) {
                            aVar = a.this;
                            if (elapsedRealtime3 >= 0) {
                                break;
                            }
                            elapsedRealtime3 += aVar.b;
                        }
                        aVar.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime3);
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public a(long j, long j2) {
        this.a = j;
        this.b = j2;
        if (d()) {
            this.g = new Handler(this.h);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
        this.f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f.getLooper(), this.h);
    }

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.d = true;
        this.g.removeMessages(1);
    }

    public abstract void a(long j);

    public final synchronized a b() {
        this.d = false;
        if (this.a <= 0) {
            c();
            return this;
        }
        this.c = SystemClock.elapsedRealtime() + this.a;
        Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public abstract void c();
}
