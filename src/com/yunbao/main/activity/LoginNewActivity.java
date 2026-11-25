package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.d82;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class LoginNewActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("登录");
        d82 d82Var = new d82(this.b, (ViewGroup) findViewById(c73.z5));
        d82Var.addToParent();
        d82Var.subscribeActivityLifeCycle();
        d82Var.loadData();
    }
}
