package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.g;

/* loaded from: /tmp/classes2.dex */
public final class m44 extends ut1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(m44.class, "_state$volatile");
    private volatile /* synthetic */ int _state$volatile;
    public final Thread e = Thread.currentThread();
    public pn0 f;

    public final Void A(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    public final void B(g gVar) {
        pn0 i;
        int i2;
        i = JobKt__JobKt.i(gVar, false, this, 1, null);
        this.f = i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
        do {
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 == 2 || i2 == 3) {
                    return;
                }
                A(i2);
                throw new KotlinNothingValueException();
            }
        } while (!g.compareAndSet(this, i2, 0));
    }

    @Override // defpackage.ut1
    public boolean v() {
        return true;
    }

    @Override // defpackage.ut1
    public void w(Throwable th) {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                A(i);
                throw new KotlinNothingValueException();
            }
        } while (!g.compareAndSet(this, i, 2));
        this.e.interrupt();
        g.set(this, 3);
    }

    public final void y() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
        while (true) {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        A(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (g.compareAndSet(this, i, 1)) {
                pn0 pn0Var = this.f;
                if (pn0Var != null) {
                    pn0Var.dispose();
                    return;
                }
                return;
            }
        }
    }
}
