package com.yunbao.main.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.rb2;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class PromotionActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("推广素材");
        rb2 rb2Var = new rb2(this.b, (ViewGroup) findViewById(c73.z5));
        rb2Var.addToParent();
        rb2Var.subscribeActivityLifeCycle();
    }
}
