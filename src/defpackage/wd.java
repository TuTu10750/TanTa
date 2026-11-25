package defpackage;

import android.view.Window;
import android.view.WindowManager;

/* loaded from: /tmp/classes2.dex */
public class wd extends l0 {
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
        return y73.Y;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(300);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }
}
