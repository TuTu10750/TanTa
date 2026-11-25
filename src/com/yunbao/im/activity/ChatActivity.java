package com.yunbao.im.activity;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.im.dao.IMUserBean;
import defpackage.a73;
import defpackage.j30;
import defpackage.m93;
import defpackage.oj1;
import defpackage.pi3;
import defpackage.t54;
import defpackage.w73;

/* loaded from: /tmp/classes2.dex */
public class ChatActivity extends AbsActivity {
    public oj1 e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements oj1.e {
        public a() {
        }

        @Override // oj1.e
        public void a() {
            ChatActivity.this.onBackPressed();
        }

        @Override // oj1.e
        public void b(IMUserBean iMUserBean) {
            if (!"goodsorder_admin".equals(iMUserBean.getId())) {
                ChatRoomActivity.A1(ChatActivity.this.b, iMUserBean.getUserBean(), iMUserBean.getAttent() == 1, false);
            } else if (j30.q().Q()) {
                t54.a(m93.t0);
            } else {
                pi3.b(ChatActivity.this.b, "com.yunbao.mall.activity.OrderMessageActivity");
            }
        }
    }

    public static void y1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) ChatActivity.class));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return w73.b;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        j30.q().d0(2);
        oj1 oj1Var = new oj1(this.b, (ViewGroup) findViewById(a73.g0), 0);
        this.e = oj1Var;
        oj1Var.B0(new a());
        this.e.addToParent();
        this.e.loadData();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        j30.q().d0(0);
        oj1 oj1Var = this.e;
        if (oj1Var != null) {
            oj1Var.release();
        }
        super.onDestroy();
    }
}
