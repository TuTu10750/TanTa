package defpackage;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import defpackage.k14;

/* loaded from: /tmp/classes2.dex */
public class j14 extends l0 implements k14.b {
    public k14 z0;

    @Override // defpackage.l0
    public void C0() {
        k14 k14Var = this.z0;
        if (k14Var != null) {
            k14Var.release();
        }
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // k14.b
    public void k0() {
        S1();
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return w73.h;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.e);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(300);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k14 k14Var = new k14(this.x0, (ViewGroup) this.y0);
        this.z0 = k14Var;
        k14Var.e0(this);
        this.z0.addToParent();
        this.z0.loadData();
    }
}
