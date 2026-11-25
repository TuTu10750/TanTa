package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.jd4;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class UpdatePwdActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("修改密码");
        jd4 jd4Var = new jd4(this.b, (ViewGroup) findViewById(c73.z5));
        jd4Var.addToParent();
        jd4Var.subscribeActivityLifeCycle();
        jd4Var.loadData();
    }
}
