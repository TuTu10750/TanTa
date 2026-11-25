package com.yunbao.mall.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.RejectRefundBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.m93;
import defpackage.nm3;
import defpackage.rv3;
import defpackage.t54;
import defpackage.z73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class SellerRejectRefundActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public TextView f;
    public EditText g;
    public TextView h;
    public List i;
    public String j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SellerRejectRefundActivity.this.h != null) {
                SellerRejectRefundActivity.this.h.setText(rv3.a(String.valueOf(charSequence.length()), "/300"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                SellerRejectRefundActivity.this.i = JSON.parseArray(Arrays.toString(strArr), RejectRefundBean.class);
                SellerRejectRefundActivity.this.C1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                SellerRejectRefundActivity.this.setResult(-1);
                SellerRejectRefundActivity.this.finish();
            }
            t54.b(str);
        }
    }

    public static void A1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SellerRejectRefundActivity.class);
        intent.putExtra("mallOrderId", str);
        ((Activity) context).startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        nm3 nm3Var = new nm3();
        nm3Var.r2(this.i);
        nm3Var.d2(getSupportFragmentManager(), "SellerRejectReasonDialogFragment");
    }

    private void D1() {
        if (TextUtils.isEmpty(this.j)) {
            t54.a(m93.o7);
        } else {
            ec2.y0(this.e, 0, this.j, this.g.getText().toString().trim(), new c());
        }
    }

    private void z1() {
        if (this.i == null) {
            ec2.c0(new b());
        } else {
            C1();
        }
    }

    public void B1(RejectRefundBean rejectRefundBean) {
        this.j = rejectRefundBean.getId();
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(rejectRefundBean.getName());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.R;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.n7));
        this.e = getIntent().getStringExtra("mallOrderId");
        this.f = (TextView) findViewById(d73.t3);
        this.g = (EditText) findViewById(d73.R1);
        this.h = (TextView) findViewById(d73.F1);
        this.g.addTextChangedListener(new a());
        this.h = (TextView) findViewById(d73.F1);
        findViewById(d73.R0).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.R0) {
            z1();
        } else if (id == d73.n1) {
            D1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getRejectRefundReason");
        ec2.u("sellerSetRefund");
        super.onDestroy();
    }
}
