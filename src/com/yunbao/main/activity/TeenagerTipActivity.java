package com.yunbao.main.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class TeenagerTipActivity extends AbsActivity implements View.OnClickListener {
    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.V;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        ((TextView) findViewById(c73.J1)).setText(getIntent().getStringExtra("tip"));
        findViewById(c73.N).setOnClickListener(this);
        findViewById(c73.c0).setOnClickListener(this);
    }

    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.N) {
            w1();
        } else if (id == c73.c0) {
            TeenagerActivity.D1(this.b);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w1() {
        Intent intent = new Intent(this.b, (Class<?>) MainActivity.class);
        intent.putExtra("exit", true);
        startActivity(intent);
    }
}
