package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.bean.ImConUserBean;
import com.yunbao.live.bean.LiveBean;
import defpackage.aq4;
import defpackage.bd1;
import defpackage.d22;
import defpackage.d73;
import defpackage.ec2;
import defpackage.j30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.od1;
import defpackage.pi3;
import defpackage.pw3;
import defpackage.rv3;
import defpackage.t54;
import defpackage.v83;
import defpackage.vq2;
import defpackage.x31;
import defpackage.xj1;
import defpackage.y53;
import defpackage.z73;
import defpackage.zu0;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class GoodsOutSideDetailActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public String p;
    public String q;
    public String r;
    public boolean s;
    public boolean t;
    public String u;
    public Drawable v;
    public Drawable w;
    public ImageView x;
    public View y;
    public boolean z;

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
            JSONObject jSONObject = parseObject.getJSONObject("goods_info");
            GoodsOutSideDetailActivity.this.u = jSONObject.getString("href");
            List parseArray = JSON.parseArray(jSONObject.getString("thumbs_format"), String.class);
            if (parseArray != null && parseArray.size() > 0 && GoodsOutSideDetailActivity.this.i != null) {
                kn1.f(GoodsOutSideDetailActivity.this.b, (String) parseArray.get(0), GoodsOutSideDetailActivity.this.i);
            }
            if (GoodsOutSideDetailActivity.this.g != null) {
                GoodsOutSideDetailActivity.this.g.setText(jSONObject.getString("name"));
            }
            if (GoodsOutSideDetailActivity.this.h != null) {
                GoodsOutSideDetailActivity.this.h.setText(jSONObject.getString("goods_desc"));
            }
            if (GoodsOutSideDetailActivity.this.e != null) {
                GoodsOutSideDetailActivity.this.e.setText(jSONObject.getString("present_price"));
            }
            if (GoodsOutSideDetailActivity.this.f != null) {
                GoodsOutSideDetailActivity.this.f.setText(rv3.a(aq4.a(m93.O8), jSONObject.getString("original_price")));
            }
            JSONObject jSONObject2 = parseObject.getJSONObject("shop_info");
            GoodsOutSideDetailActivity.this.q = jSONObject2.getString("uid");
            if (GoodsOutSideDetailActivity.this.j != null) {
                kn1.f(GoodsOutSideDetailActivity.this.b, jSONObject2.getString("avatar"), GoodsOutSideDetailActivity.this.j);
            }
            if (GoodsOutSideDetailActivity.this.k != null) {
                GoodsOutSideDetailActivity.this.k.setText(jSONObject2.getString("name"));
            }
            if (GoodsOutSideDetailActivity.this.l != null) {
                GoodsOutSideDetailActivity.this.l.setText(String.format(GoodsOutSideDetailActivity.this.p, jSONObject2.getString("sale_nums")));
            }
            if (GoodsOutSideDetailActivity.this.m != null) {
                GoodsOutSideDetailActivity.this.m.setText(jSONObject2.getString("quality_points"));
            }
            if (GoodsOutSideDetailActivity.this.n != null) {
                GoodsOutSideDetailActivity.this.n.setText(jSONObject2.getString("service_points"));
            }
            if (GoodsOutSideDetailActivity.this.o != null) {
                GoodsOutSideDetailActivity.this.o.setText(jSONObject2.getString("express_points"));
            }
            String string = jSONObject.getString("uid");
            GoodsOutSideDetailActivity.this.s = (TextUtils.isEmpty(string) || string.equals(j30.q().C())) ? false : true;
            boolean z = GoodsOutSideDetailActivity.this.s;
            GoodsOutSideDetailActivity goodsOutSideDetailActivity = GoodsOutSideDetailActivity.this;
            if (z) {
                goodsOutSideDetailActivity.t1(aq4.a(m93.i6));
                if (j30.q().N()) {
                    ec2.f(GoodsOutSideDetailActivity.this.r);
                }
            } else {
                goodsOutSideDetailActivity.t1(aq4.a(m93.h6));
            }
            GoodsOutSideDetailActivity.this.e2(jSONObject.getIntValue("iscollect") == 1);
            GoodsOutSideDetailActivity.this.z = jSONObject.getIntValue(cl.i) == -1;
            if (!GoodsOutSideDetailActivity.this.z || GoodsOutSideDetailActivity.this.y == null || GoodsOutSideDetailActivity.this.y.getVisibility() == 0) {
                return;
            }
            GoodsOutSideDetailActivity.this.y.setVisibility(0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public b() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            if (TextUtils.isEmpty(GoodsOutSideDetailActivity.this.u)) {
                t54.a(m93.l8);
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(GoodsOutSideDetailActivity.this.u));
                GoodsOutSideDetailActivity.this.startActivity(intent);
            } catch (Exception unused) {
                t54.a(m93.l8);
            }
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
            ChatRoomActivity.A1(GoodsOutSideDetailActivity.this.b, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                GoodsOutSideDetailActivity.this.e2(JSON.parseObject(strArr[0]).getIntValue("iscollect") == 1);
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements vq2.b {
        public e() {
        }

        @Override // vq2.b
        public void a() {
            GoodsOutSideDetailActivity.this.finish();
        }
    }

    private void Y1() {
        if (this.s) {
            ec2.B0(this.r, new d());
        } else {
            t54.a(m93.y7);
        }
    }

    private void Z1() {
        if (this.s) {
            new bd1().d2(getSupportFragmentManager(), "GoodsCertDialogFragment");
        } else {
            t54.a(m93.y7);
        }
    }

    private void a2() {
        if (!this.s) {
            t54.a(m93.y7);
        } else {
            if (TextUtils.isEmpty(this.q)) {
                return;
            }
            xj1.g(this.q, new c());
        }
    }

    private void b2() {
        if (!this.s) {
            t54.a(m93.y7);
        } else if (this.t) {
            onBackPressed();
        } else {
            ShopHomeActivity.M1(this.b, this.q);
        }
    }

    private void c2() {
        ec2.N(this.r, new a());
    }

    private void d2() {
        od1 od1Var = new od1();
        Bundle bundle = new Bundle();
        bundle.putString("mallGoodsId", this.r);
        od1Var.F1(bundle);
        od1Var.d2(getSupportFragmentManager(), "GoodsShareDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2(boolean z) {
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setImageDrawable(z ? this.w : this.v);
        }
    }

    public final void X1() {
        if (!this.s) {
            t54.a(m93.y7);
        } else if (this.z) {
            t54.a(m93.w8);
        } else {
            new a.j(this.b).k(aq4.a(m93.j8)).g(true).d(true).j(aq4.a(m93.k8)).h(new b()).c().show();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        this.r = intent.getStringExtra("mallGoodsId");
        this.t = intent.getBooleanExtra("mallGoodsFromShop", false);
        this.e = (TextView) findViewById(d73.Z1);
        TextView textView = (TextView) findViewById(d73.c3);
        this.f = textView;
        textView.getPaint().setFlags(16);
        this.g = (TextView) findViewById(d73.W1);
        this.h = (TextView) findViewById(d73.U1);
        this.i = (ImageView) findViewById(d73.e2);
        this.j = (ImageView) findViewById(d73.Y3);
        this.k = (TextView) findViewById(d73.X3);
        this.l = (TextView) findViewById(d73.S3);
        this.m = (TextView) findViewById(d73.a2);
        this.n = (TextView) findViewById(d73.f4);
        this.o = (TextView) findViewById(d73.g4);
        this.p = aq4.a(m93.x6);
        findViewById(d73.f1).setOnClickListener(this);
        findViewById(d73.l1).setOnClickListener(this);
        findViewById(d73.k1).setOnClickListener(this);
        findViewById(d73.y0).setOnClickListener(this);
        findViewById(d73.X).setOnClickListener(this);
        findViewById(d73.J).setOnClickListener(this);
        findViewById(d73.h1).setOnClickListener(this);
        this.y = findViewById(d73.C4);
        this.x = (ImageView) findViewById(d73.z2);
        this.v = o60.d(this.b, v83.c);
        this.w = o60.d(this.b, y53.e);
        zu0.c().n(this);
        c2();
        LiveBean liveBean = (LiveBean) intent.getParcelableExtra("liveBean");
        if (liveBean != null) {
            x31.f().j(1).i(liveBean).g();
        }
    }

    public void onBackPressed() {
        x31.f().e();
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.l1 || id == d73.k1 || ((AbsActivity) this.b).e1()) {
            if (id == d73.f1) {
                Z1();
                return;
            }
            if (id == d73.J) {
                X1();
                return;
            }
            if (id == d73.l1 || id == d73.k1) {
                b2();
                return;
            }
            if (id == d73.y0) {
                a2();
            } else if (id == d73.X) {
                Y1();
            } else if (id == d73.h1) {
                d2();
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        ec2.u(CommonHttpConsts.GET_GOODS_INFO);
        ec2.u("setGoodsCollect");
        xj1.a("getImUserInfo");
        x31.f().e();
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLiveFloatWindowEvent(d22 d22Var) {
        if (d22Var.b() == 1) {
            pi3.j(this.b);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void u1() {
        vq2 vq2Var = new vq2();
        vq2Var.t2(new e());
        vq2Var.d2(getSupportFragmentManager(), "NotLoginDialogFragment");
    }
}
