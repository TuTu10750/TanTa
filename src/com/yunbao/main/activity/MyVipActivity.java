package com.yunbao.main.activity;

import android.content.Intent;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.ac2;
import defpackage.c73;
import defpackage.lx1;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class MyVipActivity extends AbsActivity {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        String str;
        Intent intent = getIntent();
        if (intent.hasExtra("source")) {
            str = intent.getStringExtra("source");
            lx1.c("9527", "Extra-source:" + str);
        } else if (intent.getData() != null) {
            str = intent.getData().getQueryParameter("source");
            lx1.c("9527", "Data-source:" + str);
        } else {
            str = "";
        }
        t1("VIP");
        ac2 ac2Var = new ac2(this.b, (ViewGroup) findViewById(c73.z5));
        ac2Var.o0(str);
        ac2Var.addToParent();
        ac2Var.subscribeActivityLifeCycle();
        ac2Var.loadData();
    }
}
