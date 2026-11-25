package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.bean.ImConUserBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.kn1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.t54;
import defpackage.wg1;
import defpackage.xj1;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class BuyerRefundDetailActivity extends AbsActivity implements View.OnClickListener {
    public JSONObject A;
    public JSONObject B;
    public String e;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public View j;
    public View k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public View y;
    public String z;

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
            JSONObject jSONObject = parseObject.getJSONObject("refund_info");
            JSONObject jSONObject2 = parseObject.getJSONObject("order_info");
            BuyerRefundDetailActivity.this.A = jSONObject2;
            BuyerRefundDetailActivity.this.B = parseObject.getJSONObject("shop_info");
            if (BuyerRefundDetailActivity.this.f != null) {
                BuyerRefundDetailActivity.this.f.setText(jSONObject.getString("status_name"));
            }
            if (BuyerRefundDetailActivity.this.g != null) {
                BuyerRefundDetailActivity.this.g.setText(jSONObject.getString("status_time"));
            }
            int intValue = jSONObject.getIntValue(cl.i);
            BuyerRefundDetailActivity buyerRefundDetailActivity = BuyerRefundDetailActivity.this;
            if (intValue == 0) {
                if (buyerRefundDetailActivity.i != null && BuyerRefundDetailActivity.this.i.getVisibility() != 0) {
                    BuyerRefundDetailActivity.this.i.setVisibility(0);
                }
                if (BuyerRefundDetailActivity.this.h != null && BuyerRefundDetailActivity.this.h.getVisibility() != 8) {
                    BuyerRefundDetailActivity.this.h.setVisibility(8);
                }
                int intValue2 = jSONObject.getIntValue("is_platform");
                BuyerRefundDetailActivity buyerRefundDetailActivity2 = BuyerRefundDetailActivity.this;
                if (intValue2 == 1) {
                    if (buyerRefundDetailActivity2.j != null && BuyerRefundDetailActivity.this.j.getVisibility() != 0) {
                        BuyerRefundDetailActivity.this.j.setVisibility(0);
                    }
                } else if (buyerRefundDetailActivity2.j != null && BuyerRefundDetailActivity.this.j.getVisibility() != 8) {
                    BuyerRefundDetailActivity.this.j.setVisibility(8);
                }
                int intValue3 = jSONObject.getIntValue("is_reapply");
                BuyerRefundDetailActivity buyerRefundDetailActivity3 = BuyerRefundDetailActivity.this;
                if (intValue3 == 1) {
                    if (buyerRefundDetailActivity3.k != null && BuyerRefundDetailActivity.this.k.getVisibility() != 0) {
                        BuyerRefundDetailActivity.this.k.setVisibility(0);
                    }
                } else if (buyerRefundDetailActivity3.k != null && BuyerRefundDetailActivity.this.k.getVisibility() != 8) {
                    BuyerRefundDetailActivity.this.k.setVisibility(8);
                }
            } else {
                if (buyerRefundDetailActivity.i != null && BuyerRefundDetailActivity.this.i.getVisibility() != 8) {
                    BuyerRefundDetailActivity.this.i.setVisibility(8);
                }
                if (BuyerRefundDetailActivity.this.h != null) {
                    if (BuyerRefundDetailActivity.this.h.getVisibility() != 0) {
                        BuyerRefundDetailActivity.this.h.setVisibility(0);
                    }
                    BuyerRefundDetailActivity.this.h.setText(jSONObject.getString("status_desc"));
                }
            }
            if (BuyerRefundDetailActivity.this.l != null) {
                kn1.f(BuyerRefundDetailActivity.this.b, jSONObject2.getString("spec_thumb_format"), BuyerRefundDetailActivity.this.l);
            }
            if (BuyerRefundDetailActivity.this.m != null) {
                BuyerRefundDetailActivity.this.m.setText(jSONObject2.getString("goods_name"));
            }
            if (BuyerRefundDetailActivity.this.n != null) {
                BuyerRefundDetailActivity.this.n.setText(rv3.a(BuyerRefundDetailActivity.this.z, jSONObject2.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (BuyerRefundDetailActivity.this.o != null) {
                BuyerRefundDetailActivity.this.o.setText(jSONObject2.getString("spec_name"));
            }
            if (BuyerRefundDetailActivity.this.p != null) {
                BuyerRefundDetailActivity.this.p.setText(rv3.a("x", jSONObject2.getString("nums")));
            }
            if (BuyerRefundDetailActivity.this.q != null) {
                BuyerRefundDetailActivity.this.q.setText(jSONObject.getIntValue("type") == 0 ? m93.h7 : m93.i7);
            }
            if (BuyerRefundDetailActivity.this.r != null) {
                BuyerRefundDetailActivity.this.r.setText(rv3.a(BuyerRefundDetailActivity.this.z, jSONObject2.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (BuyerRefundDetailActivity.this.s != null) {
                BuyerRefundDetailActivity.this.s.setText(jSONObject.getString("reason"));
            }
            if (BuyerRefundDetailActivity.this.t != null) {
                BuyerRefundDetailActivity.this.t.setText(jSONObject.getString("addtime"));
            }
            if (BuyerRefundDetailActivity.this.u != null) {
                BuyerRefundDetailActivity.this.u.setText(jSONObject.getString("content"));
            }
            if (jSONObject.getIntValue("shop_result") != -1 || jSONObject.getIntValue("is_platform_interpose") != 0) {
                if (BuyerRefundDetailActivity.this.x != null && BuyerRefundDetailActivity.this.x.getVisibility() != 8) {
                    BuyerRefundDetailActivity.this.x.setVisibility(8);
                }
                if (BuyerRefundDetailActivity.this.y == null || BuyerRefundDetailActivity.this.y.getVisibility() == 8) {
                    return;
                }
                BuyerRefundDetailActivity.this.y.setVisibility(8);
                return;
            }
            if (BuyerRefundDetailActivity.this.x != null) {
                if (BuyerRefundDetailActivity.this.x.getVisibility() != 0) {
                    BuyerRefundDetailActivity.this.x.setVisibility(0);
                }
                BuyerRefundDetailActivity.this.v.setText(jSONObject.getString("shop_refuse_reason"));
            }
            if (BuyerRefundDetailActivity.this.y != null) {
                if (BuyerRefundDetailActivity.this.y.getVisibility() != 0) {
                    BuyerRefundDetailActivity.this.y.setVisibility(0);
                }
                BuyerRefundDetailActivity.this.w.setText(jSONObject.getString("shop_handle_desc"));
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
                BuyerRefundDetailActivity.this.b2();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    BuyerRefundDetailActivity.this.finish();
                }
                t54.b(str);
            }
        }

        public c() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.l(BuyerRefundDetailActivity.this.e, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            ImConUserBean imConUserBean;
            if (i != 0 || strArr.length <= 0 || (imConUserBean = (ImConUserBean) JSON.parseObject(strArr[0], ImConUserBean.class)) == null) {
                return;
            }
            ChatRoomActivity.A1(BuyerRefundDetailActivity.this.b, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X1() {
        if (TextUtils.isEmpty(this.e) || this.B == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(rv3.a("tel:", this.B.getString("service_phone"))));
        startActivity(intent);
    }

    public static void Z1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BuyerRefundDetailActivity.class);
        intent.putExtra("mallOrderId", str);
        context.startActivity(intent);
    }

    private void a2() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.e) || (jSONObject = this.A) == null) {
            return;
        }
        xj1.g(jSONObject.getString("shop_uid"), new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b2() {
        ec2.J(this.e, new a());
    }

    public final void Y1() {
        new a.j(this.b).k(aq4.a(m93.l7)).g(true).d(true).h(new c()).c().show();
    }

    public final void c2() {
        ec2.j(this.e, new b());
    }

    public final void d2() {
        WebViewActivity.E1(this.b, rv3.a(wg1.r, "orderid=", this.e, "&user_type=buyer"));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.J6));
        this.e = getIntent().getStringExtra("mallOrderId");
        this.z = aq4.a(m93.O8);
        this.f = (TextView) findViewById(d73.b4);
        this.g = (TextView) findViewById(d73.c4);
        this.h = (TextView) findViewById(d73.d4);
        this.i = findViewById(d73.i2);
        this.j = findViewById(d73.I0);
        this.k = findViewById(d73.C);
        this.l = (ImageView) findViewById(d73.e2);
        this.m = (TextView) findViewById(d73.W1);
        this.n = (TextView) findViewById(d73.Z1);
        this.o = (TextView) findViewById(d73.d2);
        this.p = (TextView) findViewById(d73.X1);
        this.q = (TextView) findViewById(d73.M3);
        this.r = (TextView) findViewById(d73.P2);
        this.s = (TextView) findViewById(d73.t3);
        this.t = (TextView) findViewById(d73.i);
        this.u = (TextView) findViewById(d73.o3);
        this.v = (TextView) findViewById(d73.O3);
        this.w = (TextView) findViewById(d73.N3);
        this.x = findViewById(d73.t2);
        this.y = findViewById(d73.s2);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        findViewById(d73.N).setOnClickListener(this);
        findViewById(d73.y0).setOnClickListener(this);
        findViewById(d73.L).setOnClickListener(this);
        findViewById(d73.o1).setOnClickListener(this);
        b2();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            b2();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.I0) {
            BuyerRefundOfficialActivity.K1(this.b, this.e);
            return;
        }
        if (id == d73.C) {
            c2();
            return;
        }
        if (id == d73.N) {
            Y1();
            return;
        }
        if (id == d73.y0) {
            if (SdkVersion.MINI_VERSION.equals(this.A.getString("shop_uid"))) {
                com.yunbao.common.utils.a.q(this.b, null, true, aq4.a(m93.D8), true);
                return;
            } else {
                a2();
                return;
            }
        }
        if (id == d73.L) {
            X1();
        } else if (id == d73.o1) {
            d2();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerRefundDetail");
        ec2.u("buyerCancelRefund");
        ec2.u("buyerApplyRefundAgain");
        ec2.u("getImUserInfo");
        super.onDestroy();
    }
}
