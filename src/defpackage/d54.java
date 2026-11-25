package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public class d54 {
    public static final b Companion = new b(null);
    public static final d54 NONE = new a();
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends d54 {
        @Override // defpackage.d54
        public d54 deadlineNanoTime(long j) {
            return this;
        }

        @Override // defpackage.d54
        public void throwIfReached() {
        }

        @Override // defpackage.d54
        public d54 timeout(long j, TimeUnit timeUnit) {
            timeUnit.getClass();
            return this;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(long j, long j2) {
            return (j != 0 && (j2 == 0 || j < j2)) ? j : j2;
        }
    }

    public void awaitSignal(Condition condition) {
        condition.getClass();
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                condition.await();
                return;
            }
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - System.nanoTime());
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - System.nanoTime();
            }
            if (timeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj = this.cancelMark;
            if (condition.awaitNanos(timeoutNanos) <= 0 && this.cancelMark == obj) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    public d54 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public d54 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final d54 deadline(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j > 0) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        }
        hk.a("duration <= 0: ", j);
        return null;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        fl3.a("No deadline");
        return 0L;
    }

    public d54 deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(d54 d54Var, l81 l81Var) {
        d54Var.getClass();
        l81Var.getClass();
        long timeoutNanos = timeoutNanos();
        long a2 = Companion.a(d54Var.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(a2, timeUnit);
        if (!hasDeadline()) {
            if (d54Var.hasDeadline()) {
                deadlineNanoTime(d54Var.deadlineNanoTime());
            }
            try {
                return (T) l81Var.invoke();
            } finally {
                xo1.b(1);
                timeout(timeoutNanos, timeUnit);
                if (d54Var.hasDeadline()) {
                    clearDeadline();
                }
                xo1.a(1);
            }
        }
        long deadlineNanoTime = deadlineNanoTime();
        if (d54Var.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), d54Var.deadlineNanoTime()));
        }
        try {
            return (T) l81Var.invoke();
        } finally {
            xo1.b(1);
            timeout(timeoutNanos, timeUnit);
            if (d54Var.hasDeadline()) {
                deadlineNanoTime(deadlineNanoTime);
            }
            xo1.a(1);
        }
    }

    public void throwIfReached() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public d54 timeout(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        }
        hk.a("timeout < 0: ", j);
        return null;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(Object obj) {
        obj.getClass();
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object obj2 = this.cancelMark;
            long j = timeoutNanos / 1000000;
            obj.wait(j, (int) (timeoutNanos - (1000000 * j)));
            if (System.nanoTime() - nanoTime >= timeoutNanos && this.cancelMark == obj2) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
