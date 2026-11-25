package com.yunbao.im.activity;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.a73;
import defpackage.k14;
import defpackage.w73;

/* loaded from: /tmp/classes2.dex */
public class SystemMessageActivity extends AbsActivity implements k14.b {
    public k14 e;

    public static void w1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SystemMessageActivity.class));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return w73.f;
    }

    @Override // k14.b
    public void k0() {
        onBackPressed();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        k14 k14Var = new k14(this.b, (ViewGroup) findViewById(a73.g0));
        this.e = k14Var;
        k14Var.e0(this);
        this.e.addToParent();
        this.e.loadData();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        k14 k14Var = this.e;
        if (k14Var != null) {
            k14Var.release();
        }
        super.onDestroy();
    }
}
