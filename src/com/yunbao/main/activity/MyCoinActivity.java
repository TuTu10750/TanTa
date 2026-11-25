package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.aq4;
import defpackage.c73;
import defpackage.m93;
import defpackage.sa2;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class MyCoinActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.Da));
        sa2 sa2Var = new sa2(this.b, (ViewGroup) findViewById(c73.z5));
        sa2Var.addToParent();
        sa2Var.subscribeActivityLifeCycle();
        sa2Var.loadData();
    }
}
