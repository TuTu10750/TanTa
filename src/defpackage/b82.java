package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class b82 extends l0 implements View.OnClickListener {
    @Override // defpackage.l0
    public boolean f2() {
        return false;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return y73.Z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        S1();
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(300);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        TextView textView = (TextView) k2(c73.G4);
        TextView textView2 = (TextView) k2(c73.F4);
        Bundle z = z();
        if (z != null) {
            textView.setText(z.getString("tip"));
            textView2.setText(z.getString("uid"));
        }
        k2(c73.Z).setOnClickListener(this);
    }
}
