package com.yunbao.video.activity;

import android.R;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.dh4;
import defpackage.f73;
import defpackage.uw1;

/* loaded from: /tmp/classes2.dex */
public abstract class AbsVideoCommentActivity extends AbsActivity implements uw1.c {
    public dh4 e;
    public uw1 f;

    @Override // uw1.c
    public void h(int i) {
        dh4 dh4Var = this.e;
        if (dh4Var != null) {
            dh4Var.E0(i);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        super.m1();
        this.f = new uw1(findViewById(R.id.content), this);
    }

    public void w1() {
        this.e.A0();
    }

    public void x1(boolean z, boolean z2, boolean z3, String str, String str2) {
        if (this.e == null) {
            dh4 dh4Var = new dh4(this.b, (ViewGroup) findViewById(f73.Q));
            this.e = dh4Var;
            dh4Var.addToParent();
        }
        this.e.G0(str, str2);
        this.e.H0(z, z2, z3);
    }

    public void y1() {
        uw1 uw1Var = this.f;
        if (uw1Var != null) {
            uw1Var.i();
        }
        this.f = null;
        dh4 dh4Var = this.e;
        if (dh4Var != null) {
            dh4Var.release();
        }
        this.e = null;
    }
}
