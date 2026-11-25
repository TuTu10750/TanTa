package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class ez1 extends n70 implements jj0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(ez1.class, "runningWorkers$volatile");
    public final /* synthetic */ jj0 b;
    public final n70 c;
    public final int d;
    public final String e;
    public final p72 f;
    public final Object g;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* loaded from: /tmp/classes2.dex */
    public final class a implements Runnable {
        public Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (true) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    try {
                        r70.a(EmptyCoroutineContext.a, th);
                    } catch (Throwable th2) {
                        Object obj = ez1.this.g;
                        ez1 ez1Var = ez1.this;
                        synchronized (obj) {
                            ez1.E0().decrementAndGet(ez1Var);
                            throw th2;
                        }
                    }
                }
                Runnable I0 = ez1.this.I0();
                if (I0 == null) {
                    return;
                }
                this.a = I0;
                i++;
                if (i >= 16 && fn0.d(ez1.this.c, ez1.this)) {
                    fn0.c(ez1.this.c, ez1.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ez1(n70 n70Var, int i, String str) {
        jj0 jj0Var = n70Var instanceof jj0 ? (jj0) n70Var : null;
        this.b = jj0Var == null ? pf0.a() : jj0Var;
        this.c = n70Var;
        this.d = i;
        this.e = str;
        this.f = new p72(false);
        this.g = new Object();
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater E0() {
        return h;
    }

    @Override // defpackage.n70
    public n70 B0(int i, String str) {
        fz1.a(i);
        return i >= this.d ? fz1.b(this, str) : super.B0(i, str);
    }

    public final Runnable I0() {
        while (true) {
            Runnable runnable = (Runnable) this.f.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.g) {
                h.decrementAndGet(this);
                if (this.f.c() == 0) {
                    return null;
                }
                h.incrementAndGet(this);
            }
        }
    }

    public final boolean J0() {
        synchronized (this.g) {
            if (h.get(this) >= this.d) {
                return false;
            }
            h.incrementAndGet(this);
            return true;
        }
    }

    @Override // defpackage.jj0
    public void T(long j, zu zuVar) {
        this.b.T(j, zuVar);
    }

    @Override // defpackage.n70
    public String toString() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        return this.c + ".limitedParallelism(" + this.d + ')';
    }

    @Override // defpackage.n70
    public void y0(d dVar, Runnable runnable) {
        Runnable I0;
        this.f.a(runnable);
        if (h.get(this) >= this.d || !J0() || (I0 = I0()) == null) {
            return;
        }
        try {
            fn0.c(this.c, this, new a(I0));
        } catch (Throwable th) {
            h.decrementAndGet(this);
            throw th;
        }
    }
}
