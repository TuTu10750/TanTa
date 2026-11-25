package defpackage;

import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/classes2.dex */
public abstract class o24 {
    public static final String a = n14.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static dk3 f;

    static {
        long f2;
        int e2;
        int e3;
        long f3;
        f2 = p14.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        b = f2;
        e2 = p14.e("kotlinx.coroutines.scheduler.core.pool.size", fb3.c(n14.a(), 2), 1, 0, 8, null);
        c = e2;
        e3 = p14.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        d = e3;
        f3 = p14.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        e = TimeUnit.SECONDS.toNanos(f3);
        f = gp2.a;
    }

    public static final j24 b(Runnable runnable, long j, boolean z) {
        return new l24(runnable, j, z);
    }

    public static final String c(boolean z) {
        return z ? "Blocking" : "Non-blocking";
    }
}
