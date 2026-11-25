package defpackage;

import android.graphics.Canvas;
import defpackage.ch;

/* loaded from: /tmp/classes2.dex */
public final class ap0 implements kh1 {
    public kh1 a;

    public ap0(io1 io1Var) {
        io1Var.getClass();
        c(io1Var);
    }

    @Override // defpackage.kh1
    public void a(Canvas canvas) {
        canvas.getClass();
        kh1 kh1Var = this.a;
        if (kh1Var == null) {
            dq1.k("mIDrawer");
        }
        kh1Var.a(canvas);
    }

    @Override // defpackage.kh1
    public ch.b b(int i, int i2) {
        kh1 kh1Var = this.a;
        if (kh1Var == null) {
            dq1.k("mIDrawer");
        }
        return kh1Var.b(i, i2);
    }

    public final void c(io1 io1Var) {
        this.a = xo0.a.a(io1Var);
    }

    public void d(boolean z, int i, int i2, int i3, int i4) {
    }

    public final void e(io1 io1Var) {
        io1Var.getClass();
        c(io1Var);
    }
}
