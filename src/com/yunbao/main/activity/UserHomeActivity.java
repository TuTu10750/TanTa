package com.yunbao.main.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.live.activity.LiveAddImpressActivity;
import defpackage.b5;
import defpackage.c73;
import defpackage.me4;
import defpackage.s4;
import defpackage.u73;

/* loaded from: /tmp/classes2.dex */
public class UserHomeActivity extends AbsActivity {
    public me4 e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends s4 {
        public a() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (UserHomeActivity.this.e != null) {
                UserHomeActivity.this.e.w1();
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.d;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public boolean j1() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        getWindow().addFlags(128);
        getWindow().addFlags(8192);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("toUid");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("fromLiveRoom", false);
        me4 me4Var = new me4(this.b, (ViewGroup) findViewById(c73.I1), stringExtra, booleanExtra, booleanExtra ? intent.getStringExtra("liveUid") : null);
        this.e = me4Var;
        me4Var.addToParent();
        this.e.subscribeActivityLifeCycle();
        this.e.loadData();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        me4 me4Var = this.e;
        if (me4Var != null) {
            me4Var.release();
        }
        super.onDestroy();
    }

    public void x1(String str) {
        Intent intent = new Intent(this.b, (Class<?>) LiveAddImpressActivity.class);
        intent.putExtra("toUid", str);
        b5.a(this, intent, new a());
    }
}
