package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import defpackage.aq4;
import defpackage.d73;
import defpackage.kn1;
import defpackage.m93;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class ShopCertActivity extends AbsActivity {
    public static void w1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ShopCertActivity.class);
        intent.putExtra("mallCertText", str);
        intent.putExtra("mallCertImg", str2);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.l6));
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("mallCertText");
        String stringExtra2 = intent.getStringExtra("mallCertImg");
        ((TextView) findViewById(d73.h4)).setText(stringExtra);
        kn1.f(this.b, stringExtra2, (ImageView) findViewById(d73.x2));
    }
}
