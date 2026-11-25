package com.yunbao.mall.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.RefundReasonBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.kn1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.t54;
import defpackage.z73;
import defpackage.zl;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class BuyerRefundApplyActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public EditText m;
    public TextView n;
    public View o;
    public String p;
    public int q;
    public List r;
    public String s;

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
            if (BuyerRefundApplyActivity.this.n != null) {
                BuyerRefundApplyActivity.this.n.setText(rv3.a(String.valueOf(charSequence.length()), "/300"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject jSONObject = JSON.parseObject(strArr[0]).getJSONObject("order_info");
            if (jSONObject.getIntValue(cl.i) > 1 && BuyerRefundApplyActivity.this.o != null && BuyerRefundApplyActivity.this.o.getVisibility() != 0) {
                BuyerRefundApplyActivity.this.o.setVisibility(0);
            }
            if (BuyerRefundApplyActivity.this.f != null) {
                kn1.f(BuyerRefundApplyActivity.this.b, jSONObject.getString("spec_thumb_format"), BuyerRefundApplyActivity.this.f);
            }
            if (BuyerRefundApplyActivity.this.g != null) {
                BuyerRefundApplyActivity.this.g.setText(jSONObject.getString("goods_name"));
            }
            if (BuyerRefundApplyActivity.this.h != null) {
                BuyerRefundApplyActivity.this.h.setText(rv3.a(BuyerRefundApplyActivity.this.p, jSONObject.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (BuyerRefundApplyActivity.this.i != null) {
                BuyerRefundApplyActivity.this.i.setText(jSONObject.getString("spec_name"));
            }
            if (BuyerRefundApplyActivity.this.j != null) {
                BuyerRefundApplyActivity.this.j.setText(rv3.a("x", jSONObject.getString("nums")));
            }
            if (BuyerRefundApplyActivity.this.l != null) {
                BuyerRefundApplyActivity.this.l.setText(rv3.a(BuyerRefundApplyActivity.this.p, jSONObject.getString("total")));
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
                BuyerRefundApplyActivity.this.r = JSON.parseArray(Arrays.toString(strArr), RefundReasonBean.class);
                BuyerRefundApplyActivity.this.K1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                BuyerRefundApplyActivity.this.setResult(-1);
                BuyerRefundApplyActivity.this.finish();
            }
            t54.b(str);
        }
    }

    private void L1() {
        if (TextUtils.isEmpty(this.s)) {
            t54.a(m93.k7);
        } else {
            ec2.i(this.e, this.m.getText().toString().trim(), this.s, this.q, new d());
        }
    }

    public final void I1() {
        if (this.r == null) {
            ec2.b0(new c());
        } else {
            K1();
        }
    }

    public void J1(RefundReasonBean refundReasonBean) {
        this.s = refundReasonBean.getId();
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(refundReasonBean.getName());
        }
    }

    public final void K1() {
        zl zlVar = new zl();
        zlVar.r2(this.r);
        zlVar.d2(getSupportFragmentManager(), "BuyerRefundReasonDialogFragment");
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.j7));
        this.e = getIntent().getStringExtra("mallOrderId");
        this.p = aq4.a(m93.O8);
        this.f = (ImageView) findViewById(d73.e2);
        this.g = (TextView) findViewById(d73.W1);
        this.h = (TextView) findViewById(d73.Z1);
        this.i = (TextView) findViewById(d73.d2);
        this.j = (TextView) findViewById(d73.X1);
        this.k = (TextView) findViewById(d73.K3);
        this.l = (TextView) findViewById(d73.H3);
        EditText editText = (EditText) findViewById(d73.R1);
        this.m = editText;
        editText.addTextChangedListener(new a());
        this.n = (TextView) findViewById(d73.F1);
        findViewById(d73.a1).setOnClickListener(this);
        View findViewById = findViewById(d73.W0);
        this.o = findViewById;
        findViewById.setOnClickListener(this);
        findViewById(d73.b1).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
        ec2.G(this.e, new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.a1) {
            this.q = 0;
            return;
        }
        if (id == d73.W0) {
            this.q = 1;
        } else if (id == d73.b1) {
            I1();
        } else if (id == d73.n1) {
            L1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerOrderDetail");
        ec2.u("getRefundReasonList");
        ec2.u("buyerApplyRefund");
        super.onDestroy();
    }
}
