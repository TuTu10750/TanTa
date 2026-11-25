package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: /tmp/classes2.dex */
public class p72 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(p72.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public p72(boolean z) {
        this._cur$volatile = new q72(8, z);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            q72 q72Var = (q72) atomicReferenceFieldUpdater.get(this);
            int a2 = q72Var.a(obj);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                a2.a(a, this, q72Var, q72Var.l());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            q72 q72Var = (q72) atomicReferenceFieldUpdater.get(this);
            if (q72Var.d()) {
                return;
            } else {
                a2.a(a, this, q72Var, q72Var.l());
            }
        }
    }

    public final int c() {
        return ((q72) a.get(this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            q72 q72Var = (q72) atomicReferenceFieldUpdater.get(this);
            Object m = q72Var.m();
            if (m != q72.h) {
                return m;
            }
            a2.a(a, this, q72Var, q72Var.l());
        }
    }
}
