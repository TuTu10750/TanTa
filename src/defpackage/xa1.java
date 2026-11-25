package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class xa1 extends l0 implements et2, View.OnClickListener {
    public ab1 z0;

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
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return v73.a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == z63.a) {
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
        this.y0.findViewById(z63.a).setOnClickListener(this);
        if (this.z0 != null) {
            RecyclerView findViewById = this.y0.findViewById(z63.y);
            findViewById.setHasFixedSize(false);
            findViewById.setLayoutManager(new GridLayoutManager(this.x0, 3, 1, false));
            wa1 wa1Var = new wa1(this.x0, this.z0.d());
            wa1Var.P(this);
            findViewById.setAdapter(wa1Var);
        }
    }

    @Override // defpackage.et2
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(Integer num, int i) {
        S1();
        ab1 ab1Var = this.z0;
        if (ab1Var != null) {
            ab1Var.k(num.intValue());
        }
    }

    public void s2(ab1 ab1Var) {
        this.z0 = ab1Var;
    }
}
