package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public abstract class hl3 extends y40 implements uq2 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(hl3.class, "cleanedAndPointers$volatile");
    public final long c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public hl3(long j, hl3 hl3Var, int i) {
        super(hl3Var);
        this.c = j;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // defpackage.y40
    public boolean k() {
        return d.get(this) == r() && !l();
    }

    public final boolean p() {
        return d.addAndGet(this, -65536) == r() && !l();
    }

    public abstract int r();

    public abstract void s(int i, Throwable th, d dVar);

    public final void t() {
        if (d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i == r() && !l()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
