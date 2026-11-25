package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: /tmp/classes2.dex */
public class vq2 extends l0 {
    public b z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            vq2.this.T1();
            if (vq2.this.z0 != null) {
                vq2.this.z0.a();
                vq2.this.z0 = null;
            }
            pi3.k(vq2.this.x0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a();
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
        return u73.q;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(y63.r).setOnClickListener(new a());
    }

    public void t2(b bVar) {
        this.z0 = bVar;
    }
}
