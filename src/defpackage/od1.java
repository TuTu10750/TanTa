package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class od1 extends l0 implements View.OnClickListener {
    public String z0;

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
        return z73.c0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.i1) {
            S1();
            pi3.c(this.x0, this.z0);
        } else if (id == d73.j1) {
            S1();
            pi3.p(this.x0, this.z0);
        } else if (id == d73.M) {
            S1();
        }
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
        Bundle z = z();
        if (z == null) {
            return;
        }
        this.z0 = z.getString("mallGoodsId");
        String string = z.getString("tip");
        TextView textView = (TextView) k2(d73.n3);
        if (TextUtils.isEmpty(string)) {
            textView.setVisibility(8);
        } else {
            textView.setText(aq4.b(m93.M, string));
        }
        k2(d73.i1).setOnClickListener(this);
        k2(d73.j1).setOnClickListener(this);
        k2(d73.M).setOnClickListener(this);
    }
}
