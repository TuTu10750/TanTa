package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: /tmp/classes2.dex */
public abstract class y40 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(y40.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(y40.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public y40(y40 y40Var) {
        this._prev$volatile = y40Var;
    }

    public final void c() {
        b.set(this, null);
    }

    public final y40 d() {
        y40 h = h();
        while (h != null && h.k()) {
            h = (y40) b.get(h);
        }
        return h;
    }

    public final y40 e() {
        y40 f;
        y40 f2 = f();
        f2.getClass();
        while (f2.k() && (f = f2.f()) != null) {
            f2 = f;
        }
        return f2;
    }

    public final y40 f() {
        Object g = g();
        if (g == x40.a()) {
            return null;
        }
        return (y40) g;
    }

    public final Object g() {
        return a.get(this);
    }

    public final y40 h() {
        return (y40) b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return a2.a(a, this, (Object) null, x40.a());
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            y40 d = d();
            y40 e = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            do {
                obj = atomicReferenceFieldUpdater.get(e);
            } while (!a2.a(atomicReferenceFieldUpdater, e, obj, ((y40) obj) == null ? null : d));
            if (d != null) {
                a.set(d, e);
            }
            if (!e.k() || e.l()) {
                if (d == null || !d.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(y40 y40Var) {
        return a2.a(a, this, (Object) null, y40Var);
    }
}
