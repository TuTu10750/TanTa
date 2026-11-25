package defpackage;

import kotlin.coroutines.d;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* loaded from: /tmp/classes2.dex */
public abstract class ck3 extends vv0 {
    public final int c;
    public final int d;
    public final long e;
    public final String f;
    public CoroutineScheduler g = D0();

    public ck3(int i, int i2, long j, String str) {
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = str;
    }

    public final CoroutineScheduler D0() {
        return new CoroutineScheduler(this.c, this.d, this.e, this.f);
    }

    public final void E0(Runnable runnable, boolean z, boolean z2) {
        this.g.k0(runnable, z, z2);
    }

    @Override // defpackage.n70
    public void y0(d dVar, Runnable runnable) {
        CoroutineScheduler.m0(this.g, runnable, false, false, 6, null);
    }
}
