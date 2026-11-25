package com.yunbao.live.activity;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.b73;
import defpackage.o12;
import defpackage.u73;

/* loaded from: /tmp/classes2.dex */
public class LiveContributeActivity extends AbsActivity {
    public o12 e;
    public String f;

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        String stringExtra = getIntent().getStringExtra("toUid");
        this.f = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        o12 o12Var = new o12(this.b, (ViewGroup) findViewById(b73.A1), this.f);
        this.e = o12Var;
        o12Var.addToParent();
        this.e.loadData();
    }

    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        o12 o12Var = this.e;
        if (o12Var != null) {
            o12Var.release();
        }
    }

    public String w1() {
        return this.f;
    }
}
