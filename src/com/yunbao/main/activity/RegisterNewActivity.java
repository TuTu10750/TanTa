package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.pe3;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class RegisterNewActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("注册");
        pe3 pe3Var = new pe3(this.b, (ViewGroup) findViewById(c73.z5));
        pe3Var.addToParent();
        pe3Var.subscribeActivityLifeCycle();
        pe3Var.loadData();
    }
}
