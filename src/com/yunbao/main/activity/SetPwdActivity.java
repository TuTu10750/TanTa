package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.co3;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class SetPwdActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("设置密码");
        co3 co3Var = new co3(this.b, (ViewGroup) findViewById(c73.z5));
        co3Var.addToParent();
        co3Var.subscribeActivityLifeCycle();
        co3Var.loadData();
    }
}
