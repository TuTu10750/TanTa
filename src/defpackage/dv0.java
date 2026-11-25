package defpackage;

import kotlinx.coroutines.f;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public abstract class dv0 extends n70 {
    public long b;
    public boolean c;
    public bb d;

    public static /* synthetic */ void I0(dv0 dv0Var, boolean z, int i, Object obj) {
        if (obj != null) {
            qm.a("Super calls with default arguments not supported in this target, function: incrementUseCount");
            return;
        }
        if ((i & 1) != 0) {
            z = false;
        }
        dv0Var.H0(z);
    }

    @Override // defpackage.n70
    public final n70 B0(int i, String str) {
        fz1.a(i);
        return fz1.b(this, str);
    }

    public final void D0(boolean z) {
        long E0 = this.b - E0(z);
        this.b = E0;
        if (E0 <= 0 && this.c) {
            shutdown();
        }
    }

    public final long E0(boolean z) {
        if (z) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1L;
    }

    public final void F0(f fVar) {
        bb bbVar = this.d;
        if (bbVar == null) {
            bbVar = new bb();
            this.d = bbVar;
        }
        bbVar.addLast(fVar);
    }

    public long G0() {
        bb bbVar = this.d;
        return (bbVar == null || bbVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void H0(boolean z) {
        this.b += E0(z);
        if (z) {
            return;
        }
        this.c = true;
    }

    public final boolean J0() {
        return this.b >= E0(true);
    }

    public final boolean K0() {
        bb bbVar = this.d;
        if (bbVar != null) {
            return bbVar.isEmpty();
        }
        return true;
    }

    public final boolean L0() {
        f fVar;
        bb bbVar = this.d;
        if (bbVar == null || (fVar = (f) bbVar.r()) == null) {
            return false;
        }
        fVar.run();
        return true;
    }

    public abstract void shutdown();
}
