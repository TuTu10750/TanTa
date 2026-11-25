package com.yunbao.mall.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import defpackage.d73;
import defpackage.ec2;
import defpackage.j30;
import defpackage.kn1;
import defpackage.t54;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class BuyerActivity extends AbsActivity {
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public int k;
    public boolean l;
    public String m;

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
            BuyerActivity buyerActivity = BuyerActivity.this;
            buyerActivity.K1(buyerActivity.e, parseObject.getIntValue("wait_payment"));
            BuyerActivity buyerActivity2 = BuyerActivity.this;
            buyerActivity2.K1(buyerActivity2.f, parseObject.getIntValue("wait_shipment"));
            BuyerActivity buyerActivity3 = BuyerActivity.this;
            buyerActivity3.K1(buyerActivity3.g, parseObject.getIntValue("wait_receive"));
            BuyerActivity buyerActivity4 = BuyerActivity.this;
            buyerActivity4.K1(buyerActivity4.h, parseObject.getIntValue("wait_evaluate"));
            BuyerActivity buyerActivity5 = BuyerActivity.this;
            buyerActivity5.K1(buyerActivity5.i, parseObject.getIntValue("refund"));
            BuyerActivity.this.k = parseObject.getIntValue("apply_status");
            BuyerActivity.this.m = parseObject.getString("apply_reason");
            if (BuyerActivity.this.j != null) {
                int i2 = BuyerActivity.this.k;
                BuyerActivity buyerActivity6 = BuyerActivity.this;
                if (i2 == 1) {
                    if (buyerActivity6.j.getVisibility() == 0) {
                        BuyerActivity.this.j.setVisibility(4);
                    }
                } else if (buyerActivity6.j.getVisibility() != 0) {
                    BuyerActivity.this.j.setVisibility(0);
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
            if (i != 0) {
                t54.b(str);
            } else if (strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                ShopApplyActivity.s2(BuyerActivity.this.b, parseObject.getString("cer_no"), parseObject.getString("real_name"), false);
            }
        }
    }

    private void J1() {
        ec2.F(new a());
    }

    public final void H1() {
        ec2.l0(new b());
    }

    public final void I1() {
        int i = this.k;
        if (i == -1) {
            H1();
        } else if (i == 0) {
            ShopApplyResultActivity.x1(this.b, false, this.m);
        } else if (i == 2) {
            ShopApplyResultActivity.x1(this.b, true, this.m);
        }
    }

    public final void K1(TextView textView, int i) {
        if (textView != null) {
            if (i > 0) {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(String.valueOf(i));
            } else if (textView.getVisibility() == 0) {
                textView.setVisibility(4);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void backClick(View view) {
        if (!this.l) {
            super.backClick(view);
        } else {
            setResult(-1);
            finish();
        }
    }

    public void buyerClick(View view) {
        int id = view.getId();
        if (id == d73.T0) {
            GoodsRecordActivity.F1(this.b);
            return;
        }
        if (id == d73.v) {
            BuyerAddressActivity.z1(this.b);
            return;
        }
        if (id == d73.p) {
            BuyerAccountActivity.E1(this.b);
            return;
        }
        if (id == d73.G0) {
            BuyerOrderActivity.B1(this.b, 0);
            return;
        }
        if (id == d73.M0) {
            BuyerOrderActivity.B1(this.b, 1);
            return;
        }
        if (id == d73.e1) {
            BuyerOrderActivity.B1(this.b, 2);
            return;
        }
        if (id == d73.S0) {
            BuyerOrderActivity.B1(this.b, 3);
            return;
        }
        if (id == d73.Y) {
            BuyerOrderActivity.B1(this.b, 4);
            return;
        }
        if (id == d73.V0) {
            BuyerOrderActivity.B1(this.b, 5);
        } else if (id == d73.J0) {
            I1();
        } else if (id == d73.F) {
            onBackPressed();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        ConfigBean h = j30.q().h();
        if (h != null) {
            ((TextView) findViewById(d73.m4)).setText(h.getShopSystemName());
        }
        this.e = (TextView) findViewById(d73.H1);
        this.f = (TextView) findViewById(d73.K1);
        this.g = (TextView) findViewById(d73.I1);
        this.h = (TextView) findViewById(d73.G1);
        this.i = (TextView) findViewById(d73.J1);
        this.j = findViewById(d73.J0);
        ImageView imageView = (ImageView) findViewById(d73.l);
        TextView textView = (TextView) findViewById(d73.R2);
        UserBean D = j30.q().D();
        if (D != null) {
            kn1.f(this.b, D.getAvatar(), imageView);
            textView.setText(D.getUserNiceName());
        }
        boolean booleanExtra = getIntent().getBooleanExtra("mallGoodsFromShop", false);
        this.l = booleanExtra;
        if (booleanExtra) {
            findViewById(d73.l4).setVisibility(0);
            findViewById(d73.F).setVisibility(0);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerHome");
        ec2.u("getUserAuthInfo");
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        J1();
    }
}
