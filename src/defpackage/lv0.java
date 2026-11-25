package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /tmp/classes2.dex */
public class lv0 extends Thread {
    public static lv0 c;
    public static ExecutorService d;
    public static final Logger a = Logger.getLogger(lv0.class.getName());
    public static final ThreadFactory b = new a();
    public static int e = 0;

    /* loaded from: /tmp/classes2.dex */
    public static class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            lv0 unused = lv0.c = new lv0(runnable, null);
            lv0.c.setName("EventThread");
            lv0.c.setDaemon(Thread.currentThread().isDaemon());
            return lv0.c;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
                synchronized (lv0.class) {
                    try {
                        lv0.e();
                        if (lv0.e == 0) {
                            lv0.d.shutdown();
                            ExecutorService unused = lv0.d = null;
                            lv0 unused2 = lv0.c = null;
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                try {
                    lv0.a.log(Level.SEVERE, "Task threw exception", th);
                    throw th;
                } catch (Throwable th2) {
                    synchronized (lv0.class) {
                        try {
                            lv0.e();
                            if (lv0.e == 0) {
                                lv0.d.shutdown();
                                ExecutorService unused3 = lv0.d = null;
                                lv0 unused4 = lv0.c = null;
                            }
                            throw th2;
                        } finally {
                        }
                    }
                }
            }
        }
    }

    public lv0(Runnable runnable) {
        super(runnable);
    }

    public /* synthetic */ lv0(Runnable runnable, a aVar) {
        this(runnable);
    }

    public static /* synthetic */ int e() {
        int i = e;
        e = i - 1;
        return i;
    }

    public static void h(Runnable runnable) {
        if (i()) {
            runnable.run();
        } else {
            j(runnable);
        }
    }

    public static boolean i() {
        return Thread.currentThread() == c;
    }

    public static void j(Runnable runnable) {
        ExecutorService executorService;
        synchronized (lv0.class) {
            try {
                e++;
                if (d == null) {
                    d = Executors.newSingleThreadExecutor(b);
                }
                executorService = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        executorService.execute(new b(runnable));
    }
}
