package defpackage;

import defpackage.ev0;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: /tmp/classes2.dex */
public final class of0 extends ev0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final of0 h;
    public static final long i;

    static {
        Long l;
        of0 of0Var = new of0();
        h = of0Var;
        dv0.I0(of0Var, false, 1, null);
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        i = TimeUnit.MILLISECONDS.toNanos(l.longValue());
    }

    @Override // defpackage.fv0
    public Thread M0() {
        Thread thread = _thread;
        return thread == null ? i1() : thread;
    }

    @Override // defpackage.fv0
    public void N0(long j, ev0.b bVar) {
        m1();
    }

    @Override // defpackage.ev0
    public void S0(Runnable runnable) {
        if (j1()) {
            m1();
        }
        super.S0(runnable);
    }

    public final synchronized void h1() {
        if (k1()) {
            debugStatus = 3;
            c1();
            notifyAll();
        }
    }

    public final synchronized Thread i1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setContextClassLoader(h.getClass().getClassLoader());
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean j1() {
        return debugStatus == 4;
    }

    public final boolean k1() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    public final synchronized boolean l1() {
        if (k1()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void m1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean Z0;
        h44.a.c(this);
        e2.a();
        try {
            if (!l1()) {
                if (Z0) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long a1 = a1();
                if (a1 == Long.MAX_VALUE) {
                    e2.a();
                    long nanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = i + nanoTime;
                    }
                    long j2 = j - nanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        h1();
                        e2.a();
                        if (Z0()) {
                            return;
                        }
                        M0();
                        return;
                    }
                    a1 = fb3.h(a1, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (a1 > 0) {
                    if (k1()) {
                        _thread = null;
                        h1();
                        e2.a();
                        if (Z0()) {
                            return;
                        }
                        M0();
                        return;
                    }
                    e2.a();
                    LockSupport.parkNanos(this, a1);
                }
            }
        } finally {
            _thread = null;
            h1();
            e2.a();
            if (!Z0()) {
                M0();
            }
        }
    }

    @Override // defpackage.ev0, defpackage.dv0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // defpackage.n70
    public String toString() {
        return "DefaultExecutor";
    }
}
