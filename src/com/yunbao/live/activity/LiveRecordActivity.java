package com.yunbao.live.activity;

import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import defpackage.aq4;
import defpackage.b73;
import defpackage.m93;
import defpackage.u42;
import defpackage.x73;

/* loaded from: /tmp/classes2.dex */
public class LiveRecordActivity extends AbsActivity {
    public UserBean e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements u42.c {
        public a() {
        }

        @Override // u42.c
        public UserBean a() {
            return LiveRecordActivity.this.e;
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.t4));
        UserBean userBean = (UserBean) getIntent().getParcelableExtra("userBean");
        this.e = userBean;
        if (userBean == null) {
            return;
        }
        u42 u42Var = new u42(this.b, (ViewGroup) findViewById(b73.A1), this.e.getId());
        u42Var.i0(new a());
        u42Var.addToParent();
        u42Var.subscribeActivityLifeCycle();
        u42Var.loadData();
    }
}
