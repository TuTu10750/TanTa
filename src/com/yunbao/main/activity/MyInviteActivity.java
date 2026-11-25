package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.hb2;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class MyInviteActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("邀请奖励");
        hb2 hb2Var = new hb2(this.b, (ViewGroup) findViewById(c73.z5));
        hb2Var.addToParent();
        hb2Var.subscribeActivityLifeCycle();
    }
}
