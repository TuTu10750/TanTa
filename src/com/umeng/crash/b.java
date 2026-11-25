package com.umeng.crash;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public class b {
    private static volatile ScheduledThreadPoolExecutor a;
    private static final ThreadFactory b = new ThreadFactory() { // from class: com.umeng.crash.b.1
        private final AtomicInteger a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "UCrash #" + this.a.addAndGet(1));
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (a == null) {
            synchronized (b.class) {
                try {
                    if (a == null) {
                        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, b);
                        a = scheduledThreadPoolExecutor;
                        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } finally {
                }
            }
        }
        return a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Executor", "execute", th);
        }
    }

    public static void b(Runnable runnable) {
        try {
            a().schedule(runnable, 3L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Executor", "schedule", th);
        }
    }
}
