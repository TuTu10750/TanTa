package com.yunbao.main.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.f4;
import defpackage.j30;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class MyActiveActivity extends AbsActivity implements View.OnClickListener {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.I;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        findViewById(c73.F).setOnClickListener(this);
        f4 f4Var = new f4(this.b, (ViewGroup) findViewById(c73.I1), j30.q().C());
        f4Var.addToParent();
        f4Var.subscribeActivityLifeCycle();
        f4Var.loadData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.F) {
            startActivity(new Intent(this.b, (Class<?>) ActivePubActivity.class));
        }
    }
}
