package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: /tmp/classes2.dex */
public final class mq1 extends ut1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(mq1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;
    public final n81 e;

    public mq1(n81 n81Var) {
        this.e = n81Var;
    }

    @Override // defpackage.ut1
    public boolean v() {
        return true;
    }

    @Override // defpackage.ut1
    public void w(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}
