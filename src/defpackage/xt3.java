package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: /tmp/classes2.dex */
public class xt3 extends l0 implements View.OnClickListener {
    public a z0;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a();
    }

    @Override // defpackage.l0
    public void C0() {
        this.z0 = null;
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.C;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.H) {
            S1();
            return;
        }
        if (id == b73.u) {
            S1();
            a aVar = this.z0;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.a);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        attributes.y = zn0.a(80);
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(b73.H).setOnClickListener(this);
        k2(b73.u).setOnClickListener(this);
    }

    public void r2(a aVar) {
        this.z0 = aVar;
    }
}
