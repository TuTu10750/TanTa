package com.yunbao.main.activity;

import android.view.View;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.ck1;
import defpackage.j30;
import defpackage.pi3;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class LoginInvalidActivity extends AbsActivity implements View.OnClickListener {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.D;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        ((TextView) findViewById(c73.J1)).setText(getIntent().getStringExtra("tip"));
        findViewById(c73.c0).setOnClickListener(this);
    }

    public void onBackPressed() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j30.q().b();
        ck1.e().j();
        pi3.k(this.b);
        finish();
    }
}
