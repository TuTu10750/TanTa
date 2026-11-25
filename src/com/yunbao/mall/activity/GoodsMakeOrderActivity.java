package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.BuyerAddressBean;
import com.yunbao.mall.bean.GoodsSpecBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.kn1;
import defpackage.ld1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.t54;
import defpackage.z73;
import java.util.Arrays;

/* loaded from: /tmp/classes2.dex */
public class GoodsMakeOrderActivity extends AbsActivity implements View.OnClickListener, ld1.c {
    public double A;
    public double B;
    public BuyerAddressBean C;
    public String D;
    public String E;
    public String F;
    public View e;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public TextView q;
    public TextView r;
    public TextView s;
    public EditText t;
    public String u;
    public String v;
    public GoodsSpecBean w;
    public double x;
    public String y;
    public int z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            for (BuyerAddressBean buyerAddressBean : JSON.parseArray(Arrays.toString(strArr), BuyerAddressBean.class)) {
                if (buyerAddressBean.getIsDefault() == 1) {
                    GoodsMakeOrderActivity.this.F1(buyerAddressBean);
                    return;
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                if (GoodsMakeOrderActivity.this.p != null) {
                    GoodsMakeOrderActivity.this.p.setEnabled(false);
                }
                if (GoodsMakeOrderActivity.this.o != null) {
                    GoodsMakeOrderActivity.this.o.setEnabled(false);
                }
                GoodsMakeOrderActivity.this.D = JSON.parseObject(strArr[0]).getString("orderid");
                GoodsMakeOrderActivity.this.G1();
            }
            t54.b(str);
        }
    }

    public static void D1(Context context, String str, String str2, String str3, GoodsSpecBean goodsSpecBean, int i, double d, String str4, String str5) {
        Intent intent = new Intent(context, (Class<?>) GoodsMakeOrderActivity.class);
        intent.putExtra("mallShopName", str);
        intent.putExtra("mallGoodsId", str2);
        intent.putExtra("mallGoodsName", str3);
        intent.putExtra("mallGoodsSpec", goodsSpecBean);
        intent.putExtra("mallGoodsCount", i);
        intent.putExtra("mallPostage", d);
        intent.putExtra("liveUid", str4);
        intent.putExtra("shareUid", str5);
        context.startActivity(intent);
    }

    private void I1() {
        if (!TextUtils.isEmpty(this.D)) {
            G1();
        } else if (this.C == null) {
            t54.a(m93.E6);
        } else {
            ec2.n(this.C.getId(), this.u, this.w.getId(), this.z, this.t.getText().toString().trim(), this.E, this.F, new b());
        }
    }

    public final void B1() {
        this.z++;
        H1();
    }

    public final void C1() {
        Intent intent = new Intent(this.b, (Class<?>) BuyerAddressActivity.class);
        intent.putExtra("mallBuyerAddress", true);
        startActivityForResult(intent, 100);
    }

    public final void E1() {
        this.z--;
        H1();
    }

    public final void F1(BuyerAddressBean buyerAddressBean) {
        if (buyerAddressBean != null) {
            this.C = buyerAddressBean;
            View view = this.e;
            if (view != null && view.getVisibility() != 0) {
                this.e.setVisibility(0);
            }
            View view2 = this.f;
            if (view2 != null && view2.getVisibility() == 0) {
                this.f.setVisibility(4);
            }
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(rv3.a(buyerAddressBean.getName(), "  ", buyerAddressBean.getPhoneNum()));
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                textView2.setText(rv3.a(buyerAddressBean.getProvince(), " ", buyerAddressBean.getCity(), " ", buyerAddressBean.getZone(), " ", buyerAddressBean.getAddress()));
            }
        }
    }

    public final void G1() {
        ld1 ld1Var = new ld1();
        Bundle bundle = new Bundle();
        bundle.putString("mallOrderId", this.D);
        bundle.putDouble("mallOrderMoney", this.B);
        bundle.putString("mallGoodsName", this.v);
        ld1Var.F1(bundle);
        ld1Var.B2(this);
        ld1Var.d2(getSupportFragmentManager(), "GoodsPayDialogFragment");
    }

    public final void H1() {
        double a2 = pn.a(String.valueOf(this.A), String.valueOf(this.z));
        this.B = this.x + a2;
        this.r.setText(String.valueOf(a2));
        this.n.setText(String.valueOf(this.z));
        this.s.setText(rv3.a(this.y, String.valueOf(this.B)));
        this.o.setEnabled(this.z > 1);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.C6));
        Intent intent = getIntent();
        this.u = intent.getStringExtra("mallGoodsId");
        this.E = intent.getStringExtra("liveUid");
        this.F = intent.getStringExtra("shareUid");
        GoodsSpecBean goodsSpecBean = (GoodsSpecBean) intent.getParcelableExtra("mallGoodsSpec");
        this.w = goodsSpecBean;
        this.z = intent.getIntExtra("mallGoodsCount", 1);
        this.x = intent.getDoubleExtra("mallPostage", 0.0d);
        String stringExtra = intent.getStringExtra("mallShopName");
        this.v = intent.getStringExtra("mallGoodsName");
        this.y = aq4.a(m93.O8);
        this.A = Double.parseDouble(goodsSpecBean.getPrice());
        this.e = findViewById(d73.g2);
        this.f = findViewById(d73.e);
        this.g = (TextView) findViewById(d73.R2);
        this.h = (TextView) findViewById(d73.d);
        this.i = (TextView) findViewById(d73.X3);
        this.j = (ImageView) findViewById(d73.j4);
        this.k = (TextView) findViewById(d73.W1);
        this.l = (TextView) findViewById(d73.c2);
        this.m = (TextView) findViewById(d73.Z1);
        this.n = (TextView) findViewById(d73.F1);
        this.o = findViewById(d73.U0);
        this.p = findViewById(d73.q);
        this.q = (TextView) findViewById(d73.j3);
        this.r = (TextView) findViewById(d73.i3);
        this.s = (TextView) findViewById(d73.P2);
        this.t = (EditText) findViewById(d73.Q2);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        findViewById(d73.v).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
        this.i.setText(stringExtra);
        kn1.f(this.b, goodsSpecBean.getThumb(), this.j);
        this.k.setText(this.v);
        this.l.setText(aq4.b(m93.D6, goodsSpecBean.getName()));
        this.m.setText(rv3.a(this.y, goodsSpecBean.getPrice()));
        this.q.setText(rv3.a(this.y, String.valueOf(this.x)));
        H1();
        ec2.D(new a());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1 && intent != null) {
            F1((BuyerAddressBean) intent.getParcelableExtra("mallBuyerAddress"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.v) {
            C1();
            return;
        }
        if (id == d73.q) {
            B1();
        } else if (id == d73.U0) {
            E1();
        } else if (id == d73.n1) {
            I1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerAddress");
        ec2.u("buyerCreateOrder");
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ld1.c
    public void x0(boolean z) {
        BuyerOrderDetailActivity.f2(this.b, this.D);
        finish();
    }
}
