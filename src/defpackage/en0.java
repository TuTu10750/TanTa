package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.d;
import kotlinx.coroutines.c;
import kotlinx.coroutines.f;

/* loaded from: /tmp/classes2.dex */
public final class en0 extends f implements t70, u60 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(en0.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;
    public final n70 d;
    public final u60 e;
    public Object f;
    public final Object g;

    public en0(n70 n70Var, u60 u60Var) {
        super(-1);
        this.d = n70Var;
        this.e = u60Var;
        this.f = fn0.a();
        this.g = g44.e(getContext());
    }

    @Override // kotlinx.coroutines.f
    public u60 c() {
        return this;
    }

    @Override // defpackage.t70
    public t70 getCallerFrame() {
        u60 u60Var = this.e;
        if (u60Var instanceof t70) {
            return (t70) u60Var;
        }
        return null;
    }

    @Override // defpackage.u60
    public d getContext() {
        return this.e.getContext();
    }

    @Override // kotlinx.coroutines.f
    public Object l() {
        Object obj = this.f;
        this.f = fn0.a();
        return obj;
    }

    public final void m() {
        do {
        } while (h.get(this) == fn0.b);
    }

    public final c n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                h.set(this, fn0.b);
                return null;
            }
            if (obj instanceof c) {
                if (a2.a(h, this, obj, fn0.b)) {
                    return (c) obj;
                }
            } else if (obj != fn0.b && !(obj instanceof Throwable)) {
                vt1.a("Inconsistent state ", obj);
                return null;
            }
        }
    }

    public final c o() {
        Object obj = h.get(this);
        if (obj instanceof c) {
            return (c) obj;
        }
        return null;
    }

    public final boolean q() {
        return h.get(this) != null;
    }

    public final boolean r(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            p04 p04Var = fn0.b;
            if (dq1.a(obj, p04Var)) {
                if (a2.a(h, this, p04Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (a2.a(h, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    @Override // defpackage.u60
    public void resumeWith(Object obj) {
        Object b = x30.b(obj);
        if (fn0.d(this.d, getContext())) {
            this.f = b;
            this.c = 0;
            fn0.c(this.d, getContext(), this);
            return;
        }
        dv0 a = h44.a.a();
        if (a.J0()) {
            this.f = b;
            this.c = 0;
            a.F0(this);
            return;
        }
        a.H0(true);
        try {
            d context = getContext();
            Object f = g44.f(context, this.g);
            try {
                this.e.resumeWith(obj);
                qc4 qc4Var = qc4.a;
                do {
                } while (a.L0());
            } finally {
                g44.d(context, f);
            }
        } catch (Throwable th) {
            try {
                k(th);
            } finally {
                a.D0(true);
            }
        }
    }

    public final void s() {
        m();
        c o = o();
        if (o != null) {
            o.t();
        }
    }

    public final Throwable t(zu zuVar) {
        p04 p04Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            p04Var = fn0.b;
            if (obj != p04Var) {
                if (!(obj instanceof Throwable)) {
                    vt1.a("Inconsistent state ", obj);
                    return null;
                }
                if (a2.a(h, this, obj, (Object) null)) {
                    return (Throwable) obj;
                }
                ik.a("Failed requirement.");
                return null;
            }
        } while (!a2.a(h, this, p04Var, zuVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.d + ", " + na0.c(this.e) + ']';
    }
}
