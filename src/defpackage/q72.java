package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class q72 {
    public static final a e = new a(null);
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(q72.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(q72.class, "_state$volatile");
    public static final p04 h = new p04("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    public final int a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | i;
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (i << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public q72(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            fl3.a("Check failed.");
            throw null;
        }
        if ((i & i2) == 0) {
            return;
        }
        fl3.a("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return e.a(j);
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (this.b || this.f().get(i2 & i3) == null) {
                q72 q72Var = this;
                if (g.compareAndSet(q72Var, j, e.c(j, (i2 + 1) & 1073741823))) {
                    q72Var.f().set(i2 & i3, obj);
                    q72 q72Var2 = q72Var;
                    while ((g.get(q72Var2) & 1152921504606846976L) != 0 && (q72Var2 = q72Var2.l().e(i2, obj)) != null) {
                    }
                    return 0;
                }
                this = q72Var;
            } else {
                int i4 = this.a;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final q72 b(long j) {
        q72 q72Var = new q72(this.a * 2, this.b);
        int i = (int) (1073741823 & j);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) == (i3 & i2)) {
                g.set(q72Var, e.d(j, 1152921504606846976L));
                return q72Var;
            }
            Object obj = f().get(this.c & i);
            if (obj == null) {
                obj = new b(i);
            }
            q72Var.f().set(q72Var.c & i, obj);
            i++;
        }
    }

    public final q72 c(long j) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        while (true) {
            q72 q72Var = (q72) atomicReferenceFieldUpdater.get(this);
            if (q72Var != null) {
                return q72Var;
            }
            a2.a(f, this, (Object) null, b(j));
        }
    }

    public final boolean d() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
            q72 q72Var = this;
            if (atomicLongFieldUpdater.compareAndSet(q72Var, j, 2305843009213693952L | j)) {
                return true;
            }
            this = q72Var;
        }
    }

    public final q72 e(int i, Object obj) {
        Object obj2 = f().get(this.c & i);
        if (!(obj2 instanceof b) || ((b) obj2).a != i) {
            return null;
        }
        f().set(i & this.c, obj);
        return this;
    }

    public final /* synthetic */ AtomicReferenceArray f() {
        return this.d;
    }

    public final int g() {
        long j = g.get(this);
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j)));
    }

    public final boolean j() {
        long j = g.get(this);
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final long k() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            long j2 = 1152921504606846976L | j;
            q72 q72Var = this;
            if (atomicLongFieldUpdater.compareAndSet(q72Var, j, j2)) {
                return j2;
            }
            this = q72Var;
        }
    }

    public final q72 l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j) != 0) {
                return h;
            }
            int i = (int) (1073741823 & j);
            int i2 = this.c;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == (i2 & i)) {
                return null;
            }
            Object obj = this.f().get(this.c & i);
            if (obj == null) {
                if (this.b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i3 = (i + 1) & 1073741823;
                q72 q72Var = this;
                if (g.compareAndSet(q72Var, j, e.b(j, i3))) {
                    q72Var.f().set(q72Var.c & i, null);
                    return obj;
                }
                if (q72Var.b) {
                    q72 q72Var2 = q72Var;
                    do {
                        q72Var2 = q72Var2.n(i, i3);
                    } while (q72Var2 != null);
                    return obj;
                }
                this = q72Var;
            }
        }
    }

    public final q72 n(int i, int i2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            int i3 = (int) (1073741823 & j);
            if ((1152921504606846976L & j) != 0) {
                return this.l();
            }
            q72 q72Var = this;
            if (g.compareAndSet(q72Var, j, e.b(j, i2))) {
                q72Var.f().set(q72Var.c & i3, null);
                return null;
            }
            this = q72Var;
        }
    }
}
