package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.c73;
import defpackage.kb2;
import defpackage.vq2;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class RankActivity extends AbsActivity {

    /* loaded from: /tmp/classes2.dex */
    public class a implements vq2.b {
        public a() {
        }

        @Override // vq2.b
        public void a() {
            RankActivity.this.finish();
        }
    }

    public static void w1(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) RankActivity.class);
        intent.putExtra("livePosition", i);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.M;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public boolean j1() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        int intExtra = getIntent().getIntExtra("livePosition", 0);
        kb2 kb2Var = new kb2(this.b, (ViewGroup) findViewById(c73.I1));
        kb2Var.addToParent();
        kb2Var.subscribeActivityLifeCycle();
        kb2Var.f0(intExtra);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void u1() {
        vq2 vq2Var = new vq2();
        vq2Var.t2(new a());
        vq2Var.d2(getSupportFragmentManager(), "NotLoginDialogFragment");
    }
}
