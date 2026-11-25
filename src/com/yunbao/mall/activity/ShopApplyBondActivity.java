package com.yunbao.mall.activity;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.j30;
import defpackage.m93;
import defpackage.pi3;
import defpackage.t54;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class ShopApplyBondActivity extends AbsActivity implements View.OnClickListener {

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: com.yunbao.mall.activity.ShopApplyBondActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0060a implements a.m {
            public C0060a() {
            }

            @Override // com.yunbao.common.utils.a.m
            public void b(Dialog dialog, String str) {
                pi3.n(ShopApplyBondActivity.this.b);
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                ShopApplyBondActivity.this.finish();
            } else if (i == 1004) {
                new a.j(ShopApplyBondActivity.this.b).k(aq4.a(m93.k)).j(aq4.a(m93.l)).g(true).o(true).d(true).h(new C0060a()).c().show();
            } else {
                t54.b(str);
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.V;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.A5));
        findViewById(d73.n1).setOnClickListener(this);
        ((TextView) findViewById(d73.n)).setText(getIntent().getStringExtra("mallApplyBond"));
        ConfigBean h = j30.q().h();
        if (h != null) {
            ((TextView) findViewById(d73.l4)).setText(aq4.b(m93.B5, h.getShopSystemName()));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ec2.z0(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("setBond");
        super.onDestroy();
    }
}
