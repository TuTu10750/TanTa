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
import defpackage.p53;
import defpackage.rv3;
import defpackage.t54;
import defpackage.wg1;
import defpackage.xj1;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class SellerRefundDetailActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public ImageView j;
    public TextView k;
    public TextView l;
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
    public String w;
    public JSONObject x;

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
            SellerRefundDetailActivity.this.x = jSONObject2;
            if (SellerRefundDetailActivity.this.f != null) {
                SellerRefundDetailActivity.this.f.setText(jSONObject.getString("status_name"));
            }
            if (SellerRefundDetailActivity.this.g != null) {
                SellerRefundDetailActivity.this.g.setText(jSONObject.getString("status_time"));
            }
            int intValue = jSONObject.getIntValue(cl.i);
            int intValue2 = jSONObject.getIntValue("can_handle");
            if (intValue == 0 && intValue2 == 1) {
                if (SellerRefundDetailActivity.this.i != null) {
                    SellerRefundDetailActivity.this.i.setVisibility(0);
                }
            } else if (SellerRefundDetailActivity.this.h != null) {
                if (SellerRefundDetailActivity.this.h.getVisibility() != 0) {
                    SellerRefundDetailActivity.this.h.setVisibility(0);
                }
                SellerRefundDetailActivity.this.h.setText(jSONObject.getString("status_desc"));
            }
            if (SellerRefundDetailActivity.this.j != null) {
                kn1.f(SellerRefundDetailActivity.this.b, jSONObject2.getString("spec_thumb_format"), SellerRefundDetailActivity.this.j);
            }
            if (SellerRefundDetailActivity.this.k != null) {
                SellerRefundDetailActivity.this.k.setText(jSONObject2.getString("goods_name"));
            }
            if (SellerRefundDetailActivity.this.l != null) {
                SellerRefundDetailActivity.this.l.setText(rv3.a(SellerRefundDetailActivity.this.w, jSONObject2.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (SellerRefundDetailActivity.this.m != null) {
                SellerRefundDetailActivity.this.m.setText(jSONObject2.getString("spec_name"));
            }
            if (SellerRefundDetailActivity.this.n != null) {
                SellerRefundDetailActivity.this.n.setText(rv3.a("x", jSONObject2.getString("nums")));
            }
            if (SellerRefundDetailActivity.this.o != null) {
                SellerRefundDetailActivity.this.o.setText(jSONObject2.getString("username"));
            }
            if (SellerRefundDetailActivity.this.p != null) {
                SellerRefundDetailActivity.this.p.setText(jSONObject2.getString("status_name"));
            }
            if (SellerRefundDetailActivity.this.q != null) {
                SellerRefundDetailActivity.this.q.setText(jSONObject.getIntValue("type") == 0 ? m93.h7 : m93.i7);
            }
            if (SellerRefundDetailActivity.this.r != null) {
                SellerRefundDetailActivity.this.r.setText(rv3.a(SellerRefundDetailActivity.this.w, jSONObject2.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (SellerRefundDetailActivity.this.s != null) {
                SellerRefundDetailActivity.this.s.setText(jSONObject.getString("reason"));
            }
            if (SellerRefundDetailActivity.this.t != null) {
                SellerRefundDetailActivity.this.t.setText(jSONObject.getString("addtime"));
            }
            if (SellerRefundDetailActivity.this.u != null) {
                SellerRefundDetailActivity.this.u.setText(jSONObject2.getString("orderno"));
            }
            if (SellerRefundDetailActivity.this.v != null) {
                SellerRefundDetailActivity.this.v.setText(jSONObject.getString("content"));
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
                SellerRefundDetailActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {
        public c() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            SellerRejectRefundActivity.A1(SellerRefundDetailActivity.this.b, SellerRefundDetailActivity.this.e);
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
            ChatRoomActivity.A1(SellerRefundDetailActivity.this.b, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void U1() {
        if (TextUtils.isEmpty(this.e) || this.x == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(rv3.a("tel:", this.x.getString("phone"))));
        startActivity(intent);
    }

    public static void V1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SellerRefundDetailActivity.class);
        intent.putExtra("mallOrderId", str);
        context.startActivity(intent);
    }

    private void W1() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.e) || (jSONObject = this.x) == null) {
            return;
        }
        xj1.g(jSONObject.getString("uid"), new d());
    }

    private void Y1() {
        WebViewActivity.E1(this.b, rv3.a(wg1.r, "orderid=", this.e, "&user_type=seller"));
    }

    public final void T1() {
        ec2.y0(this.e, 1, null, null, new b());
    }

    public final void X1() {
        new a.j(this.b).o(true).i(o60.b(this.b, p53.i)).e(o60.b(this.b, p53.g)).k(aq4.a(m93.m7)).g(true).d(true).j(aq4.a(m93.p7)).h(new c()).c().show();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.Q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.J6));
        this.e = getIntent().getStringExtra("mallOrderId");
        this.w = aq4.a(m93.O8);
        this.f = (TextView) findViewById(d73.b4);
        this.g = (TextView) findViewById(d73.c4);
        this.h = (TextView) findViewById(d73.d4);
        this.i = findViewById(d73.i2);
        this.j = (ImageView) findViewById(d73.e2);
        this.k = (TextView) findViewById(d73.W1);
        this.l = (TextView) findViewById(d73.Z1);
        this.m = (TextView) findViewById(d73.d2);
        this.n = (TextView) findViewById(d73.X1);
        this.o = (TextView) findViewById(d73.w1);
        this.p = (TextView) findViewById(d73.b3);
        this.q = (TextView) findViewById(d73.M3);
        this.r = (TextView) findViewById(d73.P2);
        this.s = (TextView) findViewById(d73.t3);
        this.t = (TextView) findViewById(d73.i);
        this.u = (TextView) findViewById(d73.Y2);
        this.v = (TextView) findViewById(d73.o3);
        findViewById(d73.c1).setOnClickListener(this);
        findViewById(d73.w).setOnClickListener(this);
        findViewById(d73.y0).setOnClickListener(this);
        findViewById(d73.L).setOnClickListener(this);
        findViewById(d73.o1).setOnClickListener(this);
        ec2.h0(this.e, new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.c1) {
            X1();
            return;
        }
        if (id == d73.w) {
            T1();
            return;
        }
        if (id == d73.y0) {
            W1();
        } else if (id == d73.L) {
            U1();
        } else if (id == d73.o1) {
            Y1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getSellerRefundDetail");
        ec2.u("sellerSetRefund");
        ec2.u("getImUserInfo");
        super.onDestroy();
    }
}
