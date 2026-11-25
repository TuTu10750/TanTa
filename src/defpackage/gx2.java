package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class gx2 extends l0 implements View.OnClickListener {
    public String A0;
    public String B0;
    public int z0;

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
        return z73.h0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        S1();
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(270);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(d73.W).setOnClickListener(this);
        ImageView imageView = (ImageView) k2(d73.x2);
        TextView textView = (TextView) k2(d73.m4);
        TextView textView2 = (TextView) k2(d73.O1);
        imageView.setImageResource(this.z0 == 0 ? v83.d : v83.e);
        textView.setText(this.B0);
        textView2.setText(this.A0);
    }

    public void r2(int i, String str, String str2) {
        this.z0 = i;
        this.A0 = str;
        this.B0 = str2;
    }
}
