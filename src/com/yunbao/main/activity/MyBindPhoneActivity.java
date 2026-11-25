package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.ji;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class MyBindPhoneActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("绑定手机号");
        ji jiVar = new ji(this.b, (ViewGroup) findViewById(c73.z5));
        jiVar.addToParent();
        jiVar.subscribeActivityLifeCycle();
        jiVar.loadData();
    }
}
