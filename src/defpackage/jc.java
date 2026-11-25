package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class jc extends d54 {
    private static final a Companion = new a(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static jc head;
    private static final ReentrantLock lock;
    private jc next;
    private int state;
    private long timeoutAt;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final jc c() {
            jc jcVar = jc.head;
            jcVar.getClass();
            jc jcVar2 = jcVar.next;
            if (jcVar2 == null) {
                long nanoTime = System.nanoTime();
                d().await(jc.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                jc jcVar3 = jc.head;
                jcVar3.getClass();
                if (jcVar3.next != null || System.nanoTime() - nanoTime < jc.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return jc.head;
            }
            long a = jcVar2.a(System.nanoTime());
            if (a > 0) {
                d().await(a, TimeUnit.NANOSECONDS);
                return null;
            }
            jc jcVar4 = jc.head;
            jcVar4.getClass();
            jcVar4.next = jcVar2.next;
            jcVar2.next = null;
            jcVar2.state = 2;
            return jcVar2;
        }

        public final Condition d() {
            return jc.condition;
        }

        public final ReentrantLock e() {
            return jc.lock;
        }

        public final void f(jc jcVar, long j, boolean z) {
            if (jc.head == null) {
                jc.head = new jc();
                new b().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                jcVar.timeoutAt = Math.min(j, jcVar.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                jcVar.timeoutAt = j + nanoTime;
            } else {
                if (!z) {
                    jr4.a();
                    return;
                }
                jcVar.timeoutAt = jcVar.deadlineNanoTime();
            }
            long a = jcVar.a(nanoTime);
            jc jcVar2 = jc.head;
            jcVar2.getClass();
            while (jcVar2.next != null) {
                jc jcVar3 = jcVar2.next;
                jcVar3.getClass();
                if (a < jcVar3.a(nanoTime)) {
                    break;
                }
                jcVar2 = jcVar2.next;
                jcVar2.getClass();
            }
            jcVar.next = jcVar2.next;
            jcVar2.next = jcVar;
            if (jcVar2 == jc.head) {
                d().signal();
            }
        }

        public final void g(jc jcVar) {
            for (jc jcVar2 = jc.head; jcVar2 != null; jcVar2 = jcVar2.next) {
                if (jcVar2.next == jcVar) {
                    jcVar2.next = jcVar.next;
                    jcVar.next = null;
                    return;
                }
            }
            fl3.a("node was not found in the queue");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock e;
            jc c;
            while (true) {
                try {
                    e = jc.Companion.e();
                    e.lock();
                    try {
                        c = jc.Companion.c();
                    } finally {
                        e.unlock();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
                if (c == jc.head) {
                    a unused2 = jc.Companion;
                    jc.head = null;
                    return;
                } else {
                    qc4 qc4Var = qc4.a;
                    e.unlock();
                    if (c != null) {
                        c.timedOut();
                    }
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c implements kq3 {
        public final /* synthetic */ kq3 b;

        public c(kq3 kq3Var) {
            this.b = kq3Var;
        }

        @Override // defpackage.kq3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public jc timeout() {
            return jc.this;
        }

        @Override // defpackage.kq3, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            jc jcVar = jc.this;
            kq3 kq3Var = this.b;
            jcVar.enter();
            try {
                kq3Var.close();
                qc4 qc4Var = qc4.a;
                if (jcVar.exit()) {
                    throw jcVar.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!jcVar.exit()) {
                    throw e;
                }
                throw jcVar.access$newTimeoutException(e);
            } finally {
                jcVar.exit();
            }
        }

        @Override // defpackage.kq3, java.io.Flushable
        public void flush() {
            jc jcVar = jc.this;
            kq3 kq3Var = this.b;
            jcVar.enter();
            try {
                kq3Var.flush();
                qc4 qc4Var = qc4.a;
                if (jcVar.exit()) {
                    throw jcVar.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!jcVar.exit()) {
                    throw e;
                }
                throw jcVar.access$newTimeoutException(e);
            } finally {
                jcVar.exit();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.b + ')';
        }

        @Override // defpackage.kq3
        public void write(lk lkVar, long j) {
            lkVar.getClass();
            r.b(lkVar.size(), 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                gl3 gl3Var = lkVar.a;
                gl3Var.getClass();
                while (true) {
                    if (j2 >= IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                        break;
                    }
                    j2 += gl3Var.c - gl3Var.b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    } else {
                        gl3Var = gl3Var.f;
                        gl3Var.getClass();
                    }
                }
                jc jcVar = jc.this;
                kq3 kq3Var = this.b;
                jcVar.enter();
                try {
                    try {
                        kq3Var.write(lkVar, j2);
                        qc4 qc4Var = qc4.a;
                        if (jcVar.exit()) {
                            throw jcVar.access$newTimeoutException(null);
                        }
                        j -= j2;
                    } catch (IOException e) {
                        if (!jcVar.exit()) {
                            throw e;
                        }
                        throw jcVar.access$newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    jcVar.exit();
                    throw th;
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class d implements wr3 {
        public final /* synthetic */ wr3 b;

        public d(wr3 wr3Var) {
            this.b = wr3Var;
        }

        @Override // defpackage.wr3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public jc timeout() {
            return jc.this;
        }

        @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            jc jcVar = jc.this;
            wr3 wr3Var = this.b;
            jcVar.enter();
            try {
                wr3Var.close();
                qc4 qc4Var = qc4.a;
                if (jcVar.exit()) {
                    throw jcVar.access$newTimeoutException(null);
                }
            } catch (IOException e) {
                if (!jcVar.exit()) {
                    throw e;
                }
                throw jcVar.access$newTimeoutException(e);
            } finally {
                jcVar.exit();
            }
        }

        @Override // defpackage.wr3
        public long read(lk lkVar, long j) {
            lkVar.getClass();
            jc jcVar = jc.this;
            wr3 wr3Var = this.b;
            jcVar.enter();
            try {
                long read = wr3Var.read(lkVar, j);
                if (jcVar.exit()) {
                    throw jcVar.access$newTimeoutException(null);
                }
                return read;
            } catch (IOException e) {
                if (jcVar.exit()) {
                    throw jcVar.access$newTimeoutException(e);
                }
                throw e;
            } finally {
                jcVar.exit();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        newCondition.getClass();
        condition = newCondition;
        IDLE_TIMEOUT_MILLIS = 60000L;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(60000L);
    }

    public final long a(long j) {
        return this.timeoutAt - j;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    @Override // defpackage.d54
    public void cancel() {
        super.cancel();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                Companion.g(this);
                this.state = 3;
            }
            qc4 qc4Var = qc4.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                Companion.f(this, timeoutNanos, hasDeadline);
                qc4 qc4Var = qc4.a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean exit() {
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            int i = this.state;
            this.state = 0;
            if (i != 1) {
                return i == 2;
            }
            Companion.g(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final kq3 sink(kq3 kq3Var) {
        kq3Var.getClass();
        return new c(kq3Var);
    }

    public final wr3 source(wr3 wr3Var) {
        wr3Var.getClass();
        return new d(wr3Var);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(l81 l81Var) {
        l81Var.getClass();
        enter();
        try {
            try {
                T t = (T) l81Var.invoke();
                xo1.b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                xo1.a(1);
                return t;
            } catch (IOException e) {
                if (exit()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            xo1.b(1);
            exit();
            xo1.a(1);
            throw th;
        }
    }
}
