package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import defpackage.b5;
import defpackage.d73;
import defpackage.ec2;
import defpackage.kn1;
import defpackage.ld1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.s4;
import defpackage.t54;
import defpackage.wg1;
import defpackage.xj1;
import defpackage.z73;
import okhttp3.HttpUrl;

/* loaded from: /tmp/classes2.dex */
public class BuyerOrderDetailActivity extends AbsActivity {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public ViewGroup E;
    public String F;
    public JSONObject G;
    public JSONObject H;
    public String e;
    public int f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public View k;
    public TextView l;
    public TextView m;
    public View n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public View w;
    public View x;
    public TextView y;
    public TextView z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            int i2 = 0;
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            JSONObject jSONObject = parseObject.getJSONObject("order_info");
            BuyerOrderDetailActivity.this.G = jSONObject;
            JSONObject jSONObject2 = parseObject.getJSONObject("shop_info");
            BuyerOrderDetailActivity.this.H = jSONObject2;
            int intValue = jSONObject.getIntValue(cl.i);
            BuyerOrderDetailActivity.this.f = intValue;
            if (BuyerOrderDetailActivity.this.g != null) {
                BuyerOrderDetailActivity.this.g.setText(jSONObject.getString("status_name"));
            }
            if (BuyerOrderDetailActivity.this.h != null) {
                BuyerOrderDetailActivity.this.h.setText(jSONObject.getString("status_desc"));
            }
            String string = parseObject.getString("express_info");
            if (intValue > 1 && !HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(string)) {
                JSONObject parseObject2 = JSON.parseObject(string);
                if (BuyerOrderDetailActivity.this.k != null && BuyerOrderDetailActivity.this.k.getVisibility() != 0) {
                    BuyerOrderDetailActivity.this.k.setVisibility(0);
                }
                if (BuyerOrderDetailActivity.this.i != null) {
                    BuyerOrderDetailActivity.this.i.setText(parseObject2.getString("state_name"));
                }
                if (BuyerOrderDetailActivity.this.j != null) {
                    BuyerOrderDetailActivity.this.j.setText(parseObject2.getString("desc"));
                }
            } else if (BuyerOrderDetailActivity.this.k != null && BuyerOrderDetailActivity.this.k.getVisibility() != 8) {
                BuyerOrderDetailActivity.this.k.setVisibility(8);
            }
            if (BuyerOrderDetailActivity.this.l != null) {
                BuyerOrderDetailActivity.this.l.setText(rv3.a(jSONObject.getString("username"), " ", jSONObject.getString("phone")));
            }
            if (BuyerOrderDetailActivity.this.m != null) {
                BuyerOrderDetailActivity.this.m.setText(jSONObject.getString("address_format"));
            }
            if (intValue > 0) {
                String string2 = jSONObject.getString("message");
                boolean isEmpty = TextUtils.isEmpty(string2);
                BuyerOrderDetailActivity buyerOrderDetailActivity = BuyerOrderDetailActivity.this;
                if (!isEmpty) {
                    if (buyerOrderDetailActivity.n != null && BuyerOrderDetailActivity.this.n.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.n.setVisibility(0);
                    }
                    if (BuyerOrderDetailActivity.this.o != null) {
                        BuyerOrderDetailActivity.this.o.setText(string2);
                    }
                } else if (buyerOrderDetailActivity.n != null && BuyerOrderDetailActivity.this.n.getVisibility() != 8) {
                    BuyerOrderDetailActivity.this.n.setVisibility(8);
                }
            } else if (BuyerOrderDetailActivity.this.n != null && BuyerOrderDetailActivity.this.n.getVisibility() != 8) {
                BuyerOrderDetailActivity.this.n.setVisibility(8);
            }
            if (BuyerOrderDetailActivity.this.p != null) {
                BuyerOrderDetailActivity.this.p.setText(jSONObject2.getString("name"));
            }
            if (BuyerOrderDetailActivity.this.q != null) {
                kn1.f(BuyerOrderDetailActivity.this.b, jSONObject.getString("spec_thumb_format"), BuyerOrderDetailActivity.this.q);
            }
            if (BuyerOrderDetailActivity.this.r != null) {
                BuyerOrderDetailActivity.this.r.setText(jSONObject.getString("goods_name"));
            }
            if (BuyerOrderDetailActivity.this.s != null) {
                BuyerOrderDetailActivity.this.s.setText(rv3.a(BuyerOrderDetailActivity.this.F, jSONObject.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (BuyerOrderDetailActivity.this.t != null) {
                BuyerOrderDetailActivity.this.t.setText(jSONObject.getString("spec_name"));
            }
            if (BuyerOrderDetailActivity.this.u != null) {
                BuyerOrderDetailActivity.this.u.setText(rv3.a("x", jSONObject.getString("nums")));
            }
            int intValue2 = jSONObject.getIntValue("is_refund");
            if (intValue == 1 || intValue == 2) {
                if (BuyerOrderDetailActivity.this.v != null && BuyerOrderDetailActivity.this.v.getVisibility() != 0) {
                    BuyerOrderDetailActivity.this.v.setVisibility(0);
                }
                if (intValue2 == 1) {
                    if (BuyerOrderDetailActivity.this.w != null && BuyerOrderDetailActivity.this.w.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.w.setVisibility(0);
                    }
                    if (BuyerOrderDetailActivity.this.x != null && BuyerOrderDetailActivity.this.x.getVisibility() == 0) {
                        BuyerOrderDetailActivity.this.x.setVisibility(4);
                    }
                } else if (intValue2 == 0) {
                    if (BuyerOrderDetailActivity.this.w != null && BuyerOrderDetailActivity.this.w.getVisibility() == 0) {
                        BuyerOrderDetailActivity.this.w.setVisibility(4);
                    }
                    if (BuyerOrderDetailActivity.this.x != null && BuyerOrderDetailActivity.this.x.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.x.setVisibility(0);
                    }
                }
            } else if (intValue == 3) {
                if (intValue2 == 1) {
                    if (BuyerOrderDetailActivity.this.v != null && BuyerOrderDetailActivity.this.v.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.v.setVisibility(0);
                    }
                    if (BuyerOrderDetailActivity.this.w != null && BuyerOrderDetailActivity.this.w.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.w.setVisibility(0);
                    }
                    if (BuyerOrderDetailActivity.this.x != null && BuyerOrderDetailActivity.this.x.getVisibility() == 0) {
                        BuyerOrderDetailActivity.this.x.setVisibility(4);
                    }
                } else if (intValue2 == 0 && jSONObject.getIntValue("refund_status") != 0) {
                    if (BuyerOrderDetailActivity.this.v != null && BuyerOrderDetailActivity.this.v.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.v.setVisibility(0);
                    }
                    if (BuyerOrderDetailActivity.this.w != null && BuyerOrderDetailActivity.this.w.getVisibility() == 0) {
                        BuyerOrderDetailActivity.this.w.setVisibility(4);
                    }
                    if (BuyerOrderDetailActivity.this.x != null && BuyerOrderDetailActivity.this.x.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.x.setVisibility(0);
                    }
                } else if (BuyerOrderDetailActivity.this.v != null && BuyerOrderDetailActivity.this.v.getVisibility() != 8) {
                    BuyerOrderDetailActivity.this.v.setVisibility(8);
                }
            } else if (BuyerOrderDetailActivity.this.v != null && BuyerOrderDetailActivity.this.v.getVisibility() != 8) {
                BuyerOrderDetailActivity.this.v.setVisibility(8);
            }
            if (BuyerOrderDetailActivity.this.y != null) {
                BuyerOrderDetailActivity.this.y.setText(rv3.a(BuyerOrderDetailActivity.this.F, jSONObject.getString("postage")));
            }
            if (BuyerOrderDetailActivity.this.z != null) {
                BuyerOrderDetailActivity.this.z.setText(rv3.a(BuyerOrderDetailActivity.this.F, jSONObject.getString("total")));
            }
            String string3 = jSONObject.getString("orderno");
            if (BuyerOrderDetailActivity.this.A != null) {
                BuyerOrderDetailActivity.this.A.setText(aq4.b(m93.Y6, string3));
            }
            if (BuyerOrderDetailActivity.this.B != null) {
                BuyerOrderDetailActivity.this.B.setText(aq4.b(m93.e7, jSONObject.getString("addtime")));
            }
            BuyerOrderDetailActivity buyerOrderDetailActivity2 = BuyerOrderDetailActivity.this;
            if (intValue > 0) {
                if (buyerOrderDetailActivity2.C != null) {
                    if (BuyerOrderDetailActivity.this.C.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.C.setVisibility(0);
                    }
                    BuyerOrderDetailActivity.this.C.setText(aq4.b(m93.f7, jSONObject.getString("type_name")));
                }
                if (BuyerOrderDetailActivity.this.D != null) {
                    if (BuyerOrderDetailActivity.this.D.getVisibility() != 0) {
                        BuyerOrderDetailActivity.this.D.setVisibility(0);
                    }
                    BuyerOrderDetailActivity.this.D.setText(aq4.b(m93.g7, jSONObject.getString("paytime")));
                }
            } else {
                if (buyerOrderDetailActivity2.C != null && BuyerOrderDetailActivity.this.C.getVisibility() == 0) {
                    BuyerOrderDetailActivity.this.C.setVisibility(8);
                }
                if (BuyerOrderDetailActivity.this.D != null && BuyerOrderDetailActivity.this.D.getVisibility() == 0) {
                    BuyerOrderDetailActivity.this.D.setVisibility(8);
                }
            }
            if (BuyerOrderDetailActivity.this.E != null) {
                if (BuyerOrderDetailActivity.this.E.getChildCount() > 0) {
                    BuyerOrderDetailActivity.this.E.removeAllViews();
                }
                if (intValue == -1) {
                    i2 = z73.C1;
                } else if (intValue == 0) {
                    i2 = z73.y1;
                } else if (intValue == 2) {
                    i2 = z73.z1;
                } else if (intValue == 3) {
                    i2 = z73.A1;
                } else if (intValue == 4) {
                    i2 = jSONObject.getIntValue("is_append_evaluate") == 1 ? z73.B1 : z73.D1;
                }
                if (i2 != 0) {
                    LayoutInflater.from(BuyerOrderDetailActivity.this.b).inflate(i2, BuyerOrderDetailActivity.this.E, true);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends s4 {
        public b() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            BuyerOrderDetailActivity.this.f = 5;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            ImConUserBean imConUserBean;
            if (i != 0 || strArr.length <= 0 || (imConUserBean = (ImConUserBean) JSON.parseObject(strArr[0], ImConUserBean.class)) == null) {
                return;
            }
            ChatRoomActivity.A1(BuyerOrderDetailActivity.this.b, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements ld1.c {
        public d() {
        }

        @Override // ld1.c
        public void x0(boolean z) {
            BuyerOrderDetailActivity.this.finish();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    BuyerOrderDetailActivity.this.finish();
                }
                t54.b(str);
            }
        }

        public e() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.m(BuyerOrderDetailActivity.this.e, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    BuyerOrderDetailActivity.this.finish();
                }
                t54.b(str);
            }
        }

        public f() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.k(BuyerOrderDetailActivity.this.e, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    BuyerOrderDetailActivity.this.finish();
                }
                t54.b(str);
            }
        }

        public g() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.q(BuyerOrderDetailActivity.this.e, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends s4 {
        public h() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            View findViewById = BuyerOrderDetailActivity.this.findViewById(d73.Y);
            View findViewById2 = BuyerOrderDetailActivity.this.findViewById(d73.Z);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends s4 {
        public i() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            View findViewById = BuyerOrderDetailActivity.this.findViewById(d73.Z);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public static void f2(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BuyerOrderDetailActivity.class);
        intent.putExtra("mallOrderId", str);
        context.startActivity(intent);
    }

    private void l2() {
        ec2.G(this.e, new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d2() {
        if (TextUtils.isEmpty(this.e) || this.H == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(rv3.a("tel:", this.H.getString("service_phone"))));
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e2() {
        if (TextUtils.isEmpty(this.e) || this.G == null) {
            return;
        }
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.G.getString("orderno")));
        t54.a(m93.u1);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.i;
    }

    public final void g2() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        Intent intent = new Intent(this.b, (Class<?>) BuyerCommentAppendActivity.class);
        intent.putExtra("mallOrderId", this.e);
        b5.a((AbsActivity) this.b, intent, new i());
    }

    public final void h2() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.e) || (jSONObject = this.G) == null) {
            return;
        }
        xj1.g(jSONObject.getString("shop_uid"), new c());
    }

    public final void i2() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        Intent intent = new Intent(this.b, (Class<?>) BuyerCommentActivity.class);
        intent.putExtra("mallOrderId", this.e);
        b5.a(this, intent, new h());
    }

    public final void j2() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.e) || (jSONObject = this.G) == null) {
            return;
        }
        ShopHomeActivity.M1(this.b, jSONObject.getString("shop_uid"));
    }

    public final void k2() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        WebViewActivity.E1(this.b, rv3.a(wg1.q, "orderid=", this.e, "&user_type=buyer"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.g = (TextView) findViewById(d73.b4);
        this.h = (TextView) findViewById(d73.d4);
        this.i = (TextView) findViewById(d73.A4);
        this.j = (TextView) findViewById(d73.B4);
        this.k = findViewById(d73.v2);
        this.l = (TextView) findViewById(d73.w1);
        this.m = (TextView) findViewById(d73.u1);
        this.n = findViewById(d73.o2);
        this.o = (TextView) findViewById(d73.v1);
        this.p = (TextView) findViewById(d73.X3);
        this.q = (ImageView) findViewById(d73.e2);
        this.r = (TextView) findViewById(d73.W1);
        this.s = (TextView) findViewById(d73.Z1);
        this.t = (TextView) findViewById(d73.d2);
        this.u = (TextView) findViewById(d73.X1);
        this.v = findViewById(d73.r2);
        this.w = findViewById(d73.V0);
        this.x = findViewById(d73.Y0);
        this.y = (TextView) findViewById(d73.j3);
        this.z = (TextView) findViewById(d73.P2);
        this.A = (TextView) findViewById(d73.Y2);
        this.B = (TextView) findViewById(d73.X2);
        this.C = (TextView) findViewById(d73.a3);
        this.D = (TextView) findViewById(d73.Z2);
        this.E = (ViewGroup) findViewById(d73.h2);
        this.e = getIntent().getStringExtra("mallOrderId");
        this.F = aq4.a(m93.O8);
        l2();
    }

    public final void m2() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        new a.j(this.b).k(aq4.a(m93.e8)).g(true).d(true).h(new f()).c().show();
    }

    public final void n2() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        new a.j(this.b).k(aq4.a(m93.f8)).g(true).d(true).h(new e()).c().show();
    }

    public final void o2() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        new a.j(this.b).k(aq4.a(m93.d8)).g(true).d(true).h(new g()).c().show();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerOrderDetail");
        ec2.u("buyerConfirmReceive");
        ec2.u("buyerDeleteOrder");
        ec2.u("buyerCancelOrder");
        ec2.u("getImUserInfo");
        super.onDestroy();
    }

    public void orderDetailClick(View view) {
        int id = view.getId();
        if (id == d73.X3) {
            j2();
            return;
        }
        if (id == d73.V0) {
            if (this.f == 5) {
                BuyerRefundDetailActivity.Z1(this.b, this.e);
                return;
            }
            Intent intent = new Intent(this.b, (Class<?>) BuyerRefundApplyActivity.class);
            intent.putExtra("mallOrderId", this.e);
            b5.a(this, intent, new b());
            return;
        }
        if (id == d73.Y0) {
            BuyerRefundDetailActivity.Z1(this.b, this.e);
            return;
        }
        if (id == d73.y0) {
            if (SdkVersion.MINI_VERSION.equals(this.G.getString("shop_uid"))) {
                com.yunbao.common.utils.a.q(this.b, null, true, aq4.a(m93.D8), true);
                return;
            } else {
                h2();
                return;
            }
        }
        if (id == d73.L) {
            d2();
            return;
        }
        if (id == d73.f0) {
            e2();
            return;
        }
        if (id == d73.O) {
            m2();
            return;
        }
        if (id == d73.M0) {
            p2();
            return;
        }
        if (id == d73.r1) {
            k2();
            return;
        }
        if (id == d73.c0) {
            n2();
            return;
        }
        if (id == d73.Y) {
            i2();
        } else if (id == d73.n0) {
            o2();
        } else if (id == d73.Z) {
            g2();
        }
    }

    public final void p2() {
        if (TextUtils.isEmpty(this.e) || this.G == null) {
            return;
        }
        ld1 ld1Var = new ld1();
        Bundle bundle = new Bundle();
        bundle.putString("mallOrderId", this.e);
        bundle.putDouble("mallOrderMoney", this.G.getDoubleValue("total"));
        bundle.putString("mallGoodsName", this.G.getString("goods_name"));
        ld1Var.F1(bundle);
        ld1Var.B2(new d());
        ld1Var.d2(getSupportFragmentManager(), "GoodsPayDialogFragment");
    }
}
