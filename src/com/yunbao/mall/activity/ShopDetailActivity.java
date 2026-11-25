package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.yunbao.common.activity.AbsActivity;
import defpackage.aq4;
import defpackage.d73;
import defpackage.m93;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class ShopDetailActivity extends AbsActivity implements View.OnClickListener {
    public static void w1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ShopDetailActivity.class);
        intent.putExtra("mallCertText", str);
        intent.putExtra("mallCertImg", str2);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.X;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.n6));
        findViewById(d73.R).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d73.R) {
            x1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x1() {
        Intent intent = getIntent();
        ShopCertActivity.w1(this.b, intent.getStringExtra("mallCertText"), intent.getStringExtra("mallCertImg"));
    }
}
