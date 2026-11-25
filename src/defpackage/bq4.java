package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: /tmp/classes2.dex */
public final class bq4 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(bq4.class, Object.class, "lastScheduledTask$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(bq4.class, "producerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(bq4.class, "consumerIndex$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(bq4.class, "blockingTasksInBuffer$volatile");
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final j24 a(j24 j24Var, boolean z) {
        if (z) {
            return b(j24Var);
        }
        j24 j24Var2 = (j24) b.getAndSet(this, j24Var);
        if (j24Var2 == null) {
            return null;
        }
        return b(j24Var2);
    }

    public final j24 b(j24 j24Var) {
        if (e() == 127) {
            return j24Var;
        }
        if (j24Var.b) {
            e.incrementAndGet(this);
        }
        int i = c.get(this) & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, j24Var);
        c.incrementAndGet(this);
        return null;
    }

    public final void c(j24 j24Var) {
        if (j24Var == null || !j24Var.b) {
            return;
        }
        e.decrementAndGet(this);
    }

    public final int e() {
        return c.get(this) - d.get(this);
    }

    public final int i() {
        Object obj = b.get(this);
        int e2 = e();
        return obj != null ? e2 + 1 : e2;
    }

    public final void j(zc1 zc1Var) {
        j24 j24Var = (j24) b.getAndSet(this, null);
        if (j24Var != null) {
            zc1Var.a(j24Var);
        }
        do {
        } while (n(zc1Var));
    }

    public final j24 k() {
        j24 j24Var = (j24) b.getAndSet(this, null);
        return j24Var == null ? m() : j24Var;
    }

    public final j24 l() {
        return o(true);
    }

    public final j24 m() {
        j24 j24Var;
        while (true) {
            int i = d.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (j24Var = (j24) this.a.getAndSet(i2, null)) != null) {
                c(j24Var);
                return j24Var;
            }
        }
    }

    public final boolean n(zc1 zc1Var) {
        j24 m = m();
        if (m == null) {
            return false;
        }
        zc1Var.a(m);
        return true;
    }

    public final j24 o(boolean z) {
        j24 j24Var;
        do {
            j24Var = (j24) b.get(this);
            if (j24Var == null || j24Var.b != z) {
                int i = d.get(this);
                int i2 = c.get(this);
                while (i != i2) {
                    if (z && e.get(this) == 0) {
                        return null;
                    }
                    i2--;
                    j24 q = q(i2, z);
                    if (q != null) {
                        return q;
                    }
                }
                return null;
            }
        } while (!a2.a(b, this, j24Var, (Object) null));
        return j24Var;
    }

    public final j24 p(int i) {
        int i2 = d.get(this);
        int i3 = c.get(this);
        boolean z = i == 1;
        while (i2 != i3) {
            if (z && e.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            j24 q = q(i2, z);
            if (q != null) {
                return q;
            }
            i2 = i4;
        }
        return null;
    }

    public final j24 q(int i, boolean z) {
        int i2 = i & 127;
        j24 j24Var = (j24) this.a.get(i2);
        if (j24Var == null || j24Var.b != z || !ux.a(this.a, i2, j24Var, null)) {
            return null;
        }
        if (z) {
            e.decrementAndGet(this);
        }
        return j24Var;
    }

    public final long r(int i, Ref$ObjectRef ref$ObjectRef) {
        j24 m = i == 3 ? m() : p(i);
        if (m == null) {
            return s(i, ref$ObjectRef);
        }
        ref$ObjectRef.a = m;
        return -1L;
    }

    public final long s(int i, Ref$ObjectRef ref$ObjectRef) {
        j24 j24Var;
        do {
            j24Var = (j24) b.get(this);
            if (j24Var == null) {
                return -2L;
            }
            if (((j24Var.b ? 1 : 2) & i) == 0) {
                return -2L;
            }
            long a = o24.f.a() - j24Var.a;
            long j = o24.b;
            if (a < j) {
                return j - a;
            }
        } while (!a2.a(b, this, j24Var, (Object) null));
        ref$ObjectRef.a = j24Var;
        return -1L;
    }
}
