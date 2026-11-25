package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public abstract class ev0 extends fv0 implements jj0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(ev0.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(ev0.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(ev0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    /* loaded from: /tmp/classes2.dex */
    public final class a extends b {
        public final zu c;

        public a(long j, zu zuVar) {
            super(j);
            this.c = zuVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.e(ev0.this, qc4.a);
        }

        @Override // ev0.b
        public String toString() {
            return super.toString() + this.c;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b implements Runnable, Comparable, pn0, k44 {
        private volatile Object _heap;
        public long a;
        public int b = -1;

        public b(long j) {
            this.a = j;
        }

        @Override // defpackage.k44
        public j44 a() {
            Object obj = this._heap;
            if (obj instanceof j44) {
                return (j44) obj;
            }
            return null;
        }

        @Override // defpackage.k44
        public void c(j44 j44Var) {
            p04 p04Var;
            Object obj = this._heap;
            p04Var = hv0.a;
            if (obj != p04Var) {
                this._heap = j44Var;
            } else {
                ik.a("Failed requirement.");
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j = this.a - bVar.a;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // defpackage.pn0
        public final void dispose() {
            p04 p04Var;
            p04 p04Var2;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    p04Var = hv0.a;
                    if (obj == p04Var) {
                        return;
                    }
                    c cVar = obj instanceof c ? (c) obj : null;
                    if (cVar != null) {
                        cVar.h(this);
                    }
                    p04Var2 = hv0.a;
                    this._heap = p04Var2;
                    qc4 qc4Var = qc4.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // defpackage.k44
        public int getIndex() {
            return this.b;
        }

        public final int h(long j, c cVar, ev0 ev0Var) {
            p04 p04Var;
            synchronized (this) {
                Object obj = this._heap;
                p04Var = hv0.a;
                if (obj == p04Var) {
                    return 2;
                }
                synchronized (cVar) {
                    try {
                        b bVar = (b) cVar.b();
                        if (ev0Var.Y0()) {
                            return 1;
                        }
                        if (bVar == null) {
                            cVar.c = j;
                        } else {
                            long j2 = bVar.a;
                            if (j2 - j < 0) {
                                j = j2;
                            }
                            if (j - cVar.c > 0) {
                                cVar.c = j;
                            }
                        }
                        long j3 = this.a;
                        long j4 = cVar.c;
                        if (j3 - j4 < 0) {
                            this.a = j4;
                        }
                        cVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean i(long j) {
            return j - this.a >= 0;
        }

        @Override // defpackage.k44
        public void setIndex(int i) {
            this.b = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c extends j44 {
        public long c;

        public c(long j) {
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y0() {
        return g.get(this) == 1;
    }

    @Override // defpackage.dv0
    public long G0() {
        b bVar;
        p04 p04Var;
        if (super.G0() == 0) {
            return 0L;
        }
        Object obj = e.get(this);
        if (obj != null) {
            if (!(obj instanceof q72)) {
                p04Var = hv0.b;
                return obj == p04Var ? Long.MAX_VALUE : 0L;
            }
            if (!((q72) obj).j()) {
                return 0L;
            }
        }
        c cVar = (c) f.get(this);
        if (cVar == null || (bVar = (b) cVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j = bVar.a;
        e2.a();
        return fb3.d(j - System.nanoTime(), 0L);
    }

    public final void Q0() {
        p04 p04Var;
        p04 p04Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e;
                p04Var = hv0.b;
                if (a2.a(atomicReferenceFieldUpdater2, this, (Object) null, p04Var)) {
                    return;
                }
            } else {
                if (obj instanceof q72) {
                    ((q72) obj).d();
                    return;
                }
                p04Var2 = hv0.b;
                if (obj == p04Var2) {
                    return;
                }
                q72 q72Var = new q72(8, true);
                q72Var.a((Runnable) obj);
                if (a2.a(e, this, obj, q72Var)) {
                    return;
                }
            }
        }
    }

    public final Runnable R0() {
        p04 p04Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof q72) {
                q72 q72Var = (q72) obj;
                Object m = q72Var.m();
                if (m != q72.h) {
                    return (Runnable) m;
                }
                a2.a(e, this, obj, q72Var.l());
            } else {
                p04Var = hv0.b;
                if (obj == p04Var) {
                    return null;
                }
                if (a2.a(e, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void S0(Runnable runnable) {
        T0();
        if (U0(runnable)) {
            O0();
        } else {
            of0.h.S0(runnable);
        }
    }

    @Override // defpackage.jj0
    public void T(long j, zu zuVar) {
        long c2 = hv0.c(j);
        if (c2 < 4611686018427387903L) {
            e2.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(c2 + nanoTime, zuVar);
            d1(nanoTime, aVar);
            cv.a(zuVar, aVar);
        }
    }

    public final void T0() {
        k44 k44Var;
        c cVar = (c) f.get(this);
        if (cVar == null || cVar.e()) {
            return;
        }
        e2.a();
        long nanoTime = System.nanoTime();
        do {
            synchronized (cVar) {
                try {
                    k44 b2 = cVar.b();
                    if (b2 != null) {
                        b bVar = (b) b2;
                        k44Var = bVar.i(nanoTime) ? U0(bVar) : false ? cVar.i(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((b) k44Var) != null);
    }

    public final boolean U0(Runnable runnable) {
        p04 p04Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (Y0()) {
                return false;
            }
            if (obj == null) {
                if (a2.a(e, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof q72) {
                q72 q72Var = (q72) obj;
                int a2 = q72Var.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    a2.a(e, this, obj, q72Var.l());
                } else if (a2 == 2) {
                    return false;
                }
            } else {
                p04Var = hv0.b;
                if (obj == p04Var) {
                    return false;
                }
                q72 q72Var2 = new q72(8, true);
                q72Var2.a((Runnable) obj);
                q72Var2.a(runnable);
                if (a2.a(e, this, obj, q72Var2)) {
                    return true;
                }
            }
        }
    }

    public boolean Z0() {
        p04 p04Var;
        if (!K0()) {
            return false;
        }
        c cVar = (c) f.get(this);
        if (cVar != null && !cVar.e()) {
            return false;
        }
        Object obj = e.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof q72) {
            return ((q72) obj).j();
        }
        p04Var = hv0.b;
        return obj == p04Var;
    }

    public long a1() {
        if (L0()) {
            return 0L;
        }
        T0();
        Runnable R0 = R0();
        if (R0 == null) {
            return G0();
        }
        R0.run();
        return 0L;
    }

    public final void b1() {
        b bVar;
        e2.a();
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) f.get(this);
            if (cVar == null || (bVar = (b) cVar.j()) == null) {
                return;
            } else {
                N0(nanoTime, bVar);
            }
        }
    }

    public final void c1() {
        e.set(this, null);
        f.set(this, null);
    }

    public final void d1(long j, b bVar) {
        int e1 = e1(j, bVar);
        if (e1 == 0) {
            if (g1(bVar)) {
                O0();
            }
        } else if (e1 == 1) {
            N0(j, bVar);
        } else {
            if (e1 == 2) {
                return;
            }
            fl3.a("unexpected result");
        }
    }

    public final int e1(long j, b bVar) {
        if (Y0()) {
            return 1;
        }
        c cVar = (c) f.get(this);
        if (cVar == null) {
            a2.a(f, this, (Object) null, new c(j));
            Object obj = f.get(this);
            obj.getClass();
            cVar = (c) obj;
        }
        return bVar.h(j, cVar, this);
    }

    public final void f1(boolean z) {
        g.set(this, z ? 1 : 0);
    }

    public final boolean g1(b bVar) {
        c cVar = (c) f.get(this);
        return (cVar != null ? (b) cVar.f() : null) == bVar;
    }

    @Override // defpackage.dv0
    public void shutdown() {
        h44.a.b();
        f1(true);
        Q0();
        do {
        } while (a1() <= 0);
        b1();
    }

    @Override // defpackage.n70
    public final void y0(d dVar, Runnable runnable) {
        S0(runnable);
    }
}
