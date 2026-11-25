package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.gx2;
import defpackage.ix2;
import defpackage.m93;
import defpackage.wg1;
import defpackage.yw2;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class PayContentActivity1 extends AbsActivity implements View.OnClickListener {

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: com.yunbao.mall.activity.PayContentActivity1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0055a implements a.m {
            public C0055a() {
            }

            @Override // com.yunbao.common.utils.a.m
            public void b(Dialog dialog, String str) {
                WebViewActivity.E1(PayContentActivity1.this.b, wg1.t);
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (parseObject.getIntValue("isauth") == 0) {
                new a.j(PayContentActivity1.this.b).k(parseObject.getString("auth_msg")).g(true).d(true).j(aq4.a(m93.m6)).h(new C0055a()).c().show();
                return;
            }
            int intValue = parseObject.getIntValue("apply_status");
            if (intValue == -2) {
                ix2 ix2Var = new ix2();
                ix2Var.t2(parseObject.getString("desc"), parseObject.getString("payment_title"));
                ix2Var.d2(PayContentActivity1.this.getSupportFragmentManager(), "PayContentTipDialogFragment");
            } else if (intValue == -1 || intValue == 0) {
                gx2 gx2Var = new gx2();
                gx2Var.r2(intValue, parseObject.getString("desc"), parseObject.getString("title"));
                gx2Var.d2(PayContentActivity1.this.getSupportFragmentManager(), "PayContentResultDialogFragment");
            }
        }
    }

    public static void z1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) PayContentActivity1.class));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.A;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.z7));
        findViewById(d73.B).setOnClickListener(this);
        yw2 yw2Var = new yw2(this.b, (ViewGroup) findViewById(d73.B1));
        yw2Var.addToParent();
        yw2Var.loadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d73.B) {
            y1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getPayApplyStatus");
        ec2.u("applyPayOpen");
        super.onDestroy();
    }

    public final void y1() {
        ec2.V(new a());
    }
}
