package com.yunbao.mall.activity;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.im.activity.ChatActivity;
import defpackage.b5;
import defpackage.ck1;
import defpackage.d73;
import defpackage.ec2;
import defpackage.ik1;
import defpackage.j30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.s4;
import defpackage.z73;
import defpackage.zu0;

/* loaded from: /tmp/classes2.dex */
public class SellerActivity extends AbsActivity {
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public String q;
    public String r;
    public TextView s;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            JSONObject jSONObject = parseObject.getJSONObject("shop_info");
            JSONObject jSONObject2 = parseObject.getJSONObject("balance_info");
            JSONObject jSONObject3 = parseObject.getJSONObject("order_info");
            if (SellerActivity.this.e != null) {
                kn1.g(SellerActivity.this.b, jSONObject.getString("avatar"), SellerActivity.this.e);
            }
            if (SellerActivity.this.f != null) {
                SellerActivity.this.f.setText(jSONObject.getString("name"));
            }
            if (SellerActivity.this.g != null) {
                SellerActivity.this.g.setText(parseObject.getString("seller_desc"));
            }
            if (SellerActivity.this.h != null) {
                SellerActivity.this.h.setText(jSONObject.getString("composite_points"));
            }
            if (SellerActivity.this.i != null) {
                SellerActivity.this.i.setText(SellerActivity.this.P1(jSONObject2.getString("balance")));
            }
            if (SellerActivity.this.j != null) {
                SellerActivity.this.j.setText(SellerActivity.this.P1(jSONObject2.getString("balance_total")));
            }
            if (SellerActivity.this.k != null) {
                SellerActivity.this.k.setText(jSONObject3.getString("wait_payment"));
            }
            if (SellerActivity.this.l != null) {
                SellerActivity.this.l.setText(jSONObject3.getString("wait_shipment"));
            }
            if (SellerActivity.this.m != null) {
                SellerActivity.this.m.setText(jSONObject3.getString("wait_refund"));
            }
            SellerActivity.this.q = jSONObject.getString("certificate_desc");
            SellerActivity.this.r = jSONObject.getString("certificate");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends s4 {
        public b() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            SellerActivity.this.finish();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.n {
        public c() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.h8) {
                SellerAddGoodsActivity.b2(SellerActivity.this.b, null);
            } else if (i == m93.i8) {
                GoodsAddOutSideActivity.L1(SellerActivity.this.b, null);
            } else if (i == m93.z8) {
                SellerAddPlatActivity.A1(SellerActivity.this.b);
            }
        }
    }

    private void O1() {
        ec2.e0(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence P1(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.contains(".")) {
            str = rv3.a(str, ".00");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), str.indexOf("."), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    private void Q1(String str) {
        if (this.s != null) {
            boolean equals = "0".equals(str);
            TextView textView = this.s;
            if (equals) {
                if (textView.getVisibility() == 0) {
                    this.s.setVisibility(4);
                }
            } else {
                if (textView.getVisibility() != 0) {
                    this.s.setVisibility(0);
                }
                this.s.setText(str);
            }
        }
    }

    public final void M1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.z8), Integer.valueOf(m93.h8), Integer.valueOf(m93.i8)}, new c());
    }

    public final void N1() {
        Intent intent = new Intent(this.b, (Class<?>) BuyerActivity.class);
        intent.putExtra("mallGoodsFromShop", true);
        b5.a(this, intent, new b());
    }

    public final void R1() {
        ShopDetailActivity.w1(this.b, this.q, this.r);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.G;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public boolean j1() {
        return true;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        ConfigBean h = j30.q().h();
        if (h != null) {
            ((TextView) findViewById(d73.m4)).setText(h.getShopSystemName());
        }
        this.e = (ImageView) findViewById(d73.l);
        this.f = (TextView) findViewById(d73.R2);
        this.g = (TextView) findViewById(d73.U1);
        this.h = (TextView) findViewById(d73.T3);
        this.i = (TextView) findViewById(d73.f);
        this.j = (TextView) findViewById(d73.C2);
        this.k = (TextView) findViewById(d73.f3);
        this.l = (TextView) findViewById(d73.V3);
        this.m = (TextView) findViewById(d73.D3);
        this.n = (TextView) findViewById(d73.H1);
        this.o = (TextView) findViewById(d73.K1);
        this.p = (TextView) findViewById(d73.J1);
        this.s = (TextView) findViewById(d73.B3);
        zu0.c().n(this);
        ik1 h2 = ck1.e().h();
        Q1(h2 != null ? h2.h() : "0");
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        ec2.u("getSellerHome");
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        O1();
    }

    public void onSellerClick(View view) {
        int id = view.getId();
        if (id == d73.K) {
            N1();
            return;
        }
        if (id == d73.H0) {
            R1();
            return;
        }
        if (id == d73.z) {
            SellerAccountActivity.H1(this.b);
            return;
        }
        if (id == d73.x0) {
            SellerAccountActivity.H1(this.b);
            return;
        }
        if (id == d73.L0) {
            SellerOrderActivity.N1(this.b, 9);
            return;
        }
        if (id == d73.M0) {
            SellerOrderActivity.N1(this.b, 2);
            return;
        }
        if (id == d73.e1) {
            SellerOrderActivity.N1(this.b, 0);
            return;
        }
        if (id == d73.V0) {
            SellerOrderActivity.N1(this.b, 1);
            return;
        }
        if (id == d73.s) {
            M1();
            return;
        }
        if (id == d73.D0) {
            SellerManageGoodsActivity.Q1(this.b);
            return;
        }
        if (id == d73.v) {
            SellerAddressActivity.K1(this.b);
        } else if (id == d73.E0) {
            ChatActivity.y1(this.b);
        } else if (id == d73.C0) {
            SetManageClassActivity.D1(this.b);
        }
    }
}
