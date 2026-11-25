package com.yunbao.live.activity;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.b73;
import defpackage.g02;
import defpackage.u73;

/* loaded from: /tmp/classes2.dex */
public class LiveAddImpressActivity extends AbsActivity {
    public g02 e;

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        String stringExtra = getIntent().getStringExtra("toUid");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        g02 g02Var = new g02(this.b, (ViewGroup) findViewById(b73.A1));
        this.e = g02Var;
        g02Var.subscribeActivityLifeCycle();
        this.e.addToParent();
        this.e.q0(stringExtra);
        this.e.loadData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        g02 g02Var = this.e;
        if (g02Var == null || !g02Var.n0()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            setResult(-1);
            finish();
        }
    }
}
