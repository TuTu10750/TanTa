package defpackage;

import defpackage.ev0;
import java.util.concurrent.locks.LockSupport;

/* loaded from: /tmp/classes2.dex */
public abstract class fv0 extends dv0 {
    public abstract Thread M0();

    public void N0(long j, ev0.b bVar) {
        of0.h.d1(j, bVar);
    }

    public final void O0() {
        Thread M0 = M0();
        if (Thread.currentThread() != M0) {
            e2.a();
            LockSupport.unpark(M0);
        }
    }
}
