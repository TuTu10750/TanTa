package com.yunbao.live.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.b73;
import defpackage.i02;
import defpackage.x73;

/* loaded from: /tmp/classes2.dex */
public class LiveAdminListActivity extends AbsActivity {
    public static void w1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) LiveAdminListActivity.class);
        intent.putExtra("liveUid", str);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        String stringExtra = getIntent().getStringExtra("liveUid");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        i02 i02Var = new i02(this.b, (ViewGroup) findViewById(b73.A1), stringExtra);
        i02Var.addToParent();
        i02Var.subscribeActivityLifeCycle();
        i02Var.loadData();
    }
}
