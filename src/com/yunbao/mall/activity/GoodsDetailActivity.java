package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.bean.ImConUserBean;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.mall.bean.GoodsChooseSpecBean;
import com.yunbao.mall.bean.GoodsCommentBean;
import defpackage.aq4;
import defpackage.bd1;
import defpackage.bi1;
import defpackage.d22;
import defpackage.d73;
import defpackage.ec2;
import defpackage.gd1;
import defpackage.id1;
import defpackage.j30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.n30;
import defpackage.od1;
import defpackage.p53;
import defpackage.pd1;
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
import defpackage.zh1;
import defpackage.zn0;
import defpackage.zu0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class GoodsDetailActivity extends AbsActivity implements View.OnClickListener {
    public View A;
    public View B;
    public TextView C;
    public int D;
    public String E;
    public String F;
    public boolean G;
    public boolean H;
    public boolean I;
    public List J;
    public double K;
    public Drawable L;
    public Drawable M;
    public ImageView N;
    public View O;
    public boolean P;
    public String Q = "0";
    public String R;
    public String S;
    public ViewPager e;
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
    public ImageView q;
    public TextView r;
    public View s;
    public String t;
    public MagicIndicator u;
    public String v;
    public View w;
    public View x;
    public RecyclerView y;
    public RecyclerView z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;

        public a(int i, Context context, String str, boolean z, String str2) {
            this.a = i;
            this.b = context;
            this.c = str;
            this.d = z;
            this.e = str2;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            if (this.a == 1) {
                Intent intent = new Intent(this.b, (Class<?>) GoodsOutSideDetailActivity.class);
                intent.putExtra("mallGoodsId", this.c);
                intent.putExtra("mallGoodsFromShop", this.d);
                intent.putExtra("liveUid", this.e);
                this.b.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this.b, (Class<?>) GoodsDetailActivity.class);
            intent2.putExtra("mallGoodsId", this.c);
            intent2.putExtra("mallGoodsFromShop", this.d);
            intent2.putExtra("liveUid", this.e);
            this.b.startActivity(intent2);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ViewPager.j {
        public b() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends n30 {
        public final /* synthetic */ String[] b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = GoodsDetailActivity.this.D;
                int i2 = this.a;
                if (i == i2) {
                    return;
                }
                GoodsDetailActivity.this.D = i2;
                GoodsDetailActivity.this.u.a(2);
                GoodsDetailActivity.this.u.c(this.a);
                GoodsDetailActivity.this.u.b(this.a, 0.0f, 0);
                GoodsDetailActivity.this.u.a(0);
                GoodsDetailActivity.this.C2(this.a);
            }
        }

        public c(String[] strArr) {
            this.b = strArr;
        }

        @Override // defpackage.n30
        public int a() {
            return this.b.length;
        }

        @Override // defpackage.n30
        public zh1 b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(2);
            linePagerIndicator.setLineWidth(zn0.a(20));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(GoodsDetailActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(o60.b(GoodsDetailActivity.this.b, p53.i));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(GoodsDetailActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(14.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            if (i == 1) {
                GoodsDetailActivity.this.C = colorTransitionPagerTitleView;
            }
            return colorTransitionPagerTitleView;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            JSONObject jSONObject = parseObject.getJSONObject("goods_info");
            JSON.parseArray(jSONObject.getString("thumbs_format"), String.class);
            if (GoodsDetailActivity.this.C != null) {
                GoodsDetailActivity.this.C.setText(rv3.a(GoodsDetailActivity.this.v, "(", jSONObject.getString("comment_nums"), ")"));
            }
            List parseArray = JSON.parseArray(parseObject.getString("comment_lists"), GoodsCommentBean.class);
            int size = parseArray.size();
            GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
            if (size != 0) {
                if (goodsDetailActivity.s != null && GoodsDetailActivity.this.s.getVisibility() != 0) {
                    GoodsDetailActivity.this.s.setVisibility(0);
                }
                if (GoodsDetailActivity.this.y != null) {
                    GoodsDetailActivity.this.y.setAdapter(new gd1(GoodsDetailActivity.this.b, parseArray, false));
                }
            } else if (goodsDetailActivity.A != null && GoodsDetailActivity.this.A.getVisibility() != 0) {
                GoodsDetailActivity.this.A.setVisibility(0);
            }
            String string = jSONObject.getString("content");
            boolean isEmpty = TextUtils.isEmpty(string);
            boolean z = !isEmpty;
            ArrayList arrayList = new ArrayList();
            if (!isEmpty) {
                arrayList.add(string);
            }
            JSONArray jSONArray = jSONObject.getJSONArray("pictures_format");
            int size2 = jSONArray.size();
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList.add(jSONArray.getString(i2));
            }
            int size3 = arrayList.size();
            GoodsDetailActivity goodsDetailActivity2 = GoodsDetailActivity.this;
            if (size3 == 0) {
                if (goodsDetailActivity2.B.getVisibility() != 0) {
                    GoodsDetailActivity.this.B.setVisibility(0);
                }
            } else if (goodsDetailActivity2.z != null) {
                GoodsDetailActivity.this.z.setAdapter(new id1(GoodsDetailActivity.this.b, arrayList, z));
            }
            GoodsDetailActivity.this.K = jSONObject.getDoubleValue("postage");
            if (GoodsDetailActivity.this.j != null) {
                GoodsDetailActivity.this.j.setText(aq4.b(m93.B6, jSONObject.getString("postage")));
            }
            if (GoodsDetailActivity.this.k != null) {
                GoodsDetailActivity.this.k.setText(aq4.b(m93.f6, jSONObject.getString("sale_nums")));
            }
            if (GoodsDetailActivity.this.i != null) {
                GoodsDetailActivity.this.i.setText(jSONObject.getString("name"));
            }
            GoodsDetailActivity.this.J = JSON.parseArray(jSONObject.getString("specs_format"), GoodsChooseSpecBean.class);
            if (GoodsDetailActivity.this.J != null && GoodsDetailActivity.this.J.size() > 0) {
                GoodsChooseSpecBean goodsChooseSpecBean = (GoodsChooseSpecBean) GoodsDetailActivity.this.J.get(0);
                goodsChooseSpecBean.setChecked(true);
                if (GoodsDetailActivity.this.g != null) {
                    GoodsDetailActivity.this.g.setText(goodsChooseSpecBean.getPrice());
                }
            }
            if (jSONObject.getIntValue("is_sale_platform") == 1 && GoodsDetailActivity.this.h != null) {
                GoodsDetailActivity.this.h.setText(jSONObject.getIntValue("type") == 2 ? rv3.a(aq4.a(m93.A8), aq4.a(m93.O8), jSONObject.getString("commission")) : null);
            }
            JSONObject jSONObject2 = parseObject.getJSONObject("shop_info");
            GoodsDetailActivity.this.E = jSONObject2.getString("uid");
            if (GoodsDetailActivity.this.q != null) {
                kn1.f(GoodsDetailActivity.this.b, jSONObject2.getString("avatar"), GoodsDetailActivity.this.q);
            }
            if (GoodsDetailActivity.this.r != null) {
                GoodsDetailActivity.this.r.setText(jSONObject2.getString("name"));
            }
            if (GoodsDetailActivity.this.m != null) {
                GoodsDetailActivity.this.m.setText(String.format(GoodsDetailActivity.this.t, jSONObject2.getString("sale_nums")));
            }
            if (GoodsDetailActivity.this.n != null) {
                GoodsDetailActivity.this.n.setText(jSONObject2.getString("quality_points"));
            }
            if (GoodsDetailActivity.this.o != null) {
                GoodsDetailActivity.this.o.setText(jSONObject2.getString("service_points"));
            }
            if (GoodsDetailActivity.this.p != null) {
                GoodsDetailActivity.this.p.setText(jSONObject2.getString("express_points"));
            }
            if (GoodsDetailActivity.this.l != null) {
                GoodsDetailActivity.this.l.setText(rv3.a(jSONObject2.getString("city"), jSONObject2.getString("area")));
            }
            String string2 = jSONObject.getString("uid");
            GoodsDetailActivity.this.G = (TextUtils.isEmpty(string2) || string2.equals(j30.q().C())) ? false : true;
            boolean z2 = GoodsDetailActivity.this.G;
            GoodsDetailActivity goodsDetailActivity3 = GoodsDetailActivity.this;
            if (z2) {
                goodsDetailActivity3.t1(aq4.a(m93.i6));
                if (j30.q().N()) {
                    ec2.f(GoodsDetailActivity.this.F);
                }
            } else {
                goodsDetailActivity3.t1(aq4.a(m93.h6));
            }
            GoodsDetailActivity.this.B2(jSONObject.getIntValue("iscollect") == 1);
            GoodsDetailActivity.this.P = jSONObject.getIntValue(cl.i) == -1;
            if (GoodsDetailActivity.this.P && GoodsDetailActivity.this.O != null && GoodsDetailActivity.this.O.getVisibility() != 0) {
                GoodsDetailActivity.this.O.setVisibility(0);
            }
            GoodsDetailActivity.this.S = jSONObject.getString("share_income");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            ImConUserBean imConUserBean;
            if (i != 0 || strArr.length <= 0 || (imConUserBean = (ImConUserBean) JSON.parseObject(strArr[0], ImConUserBean.class)) == null) {
                return;
            }
            ChatRoomActivity.A1(GoodsDetailActivity.this.b, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                GoodsDetailActivity.this.B2(JSON.parseObject(strArr[0]).getIntValue("iscollect") == 1);
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements vq2.b {
        public g() {
        }

        @Override // vq2.b
        public void a() {
            GoodsDetailActivity.this.finish();
        }
    }

    public static void t2(Context context, String str, int i) {
        u2(context, str, false, i);
    }

    public static void u2(Context context, String str, boolean z, int i) {
        v2(context, str, z, i, "0");
    }

    public static void v2(Context context, String str, boolean z, int i, String str2) {
        if (j30.q().Q()) {
            t54.a(m93.t0);
        } else {
            CommonHttpUtil.checkGoodsExist(str, new a(i, context, str, z, str2));
        }
    }

    private void w2() {
        if (!this.G) {
            t54.a(m93.y7);
        } else {
            if (TextUtils.isEmpty(this.E)) {
                return;
            }
            xj1.g(this.E, new e());
        }
    }

    private void y2() {
        if (!this.G) {
            t54.a(m93.y7);
        } else if (this.H) {
            onBackPressed();
        } else {
            ShopHomeActivity.M1(this.b, this.E);
        }
    }

    private void z2() {
        ec2.N(this.F, new d());
    }

    public final void A2() {
        od1 od1Var = new od1();
        Bundle bundle = new Bundle();
        bundle.putString("mallGoodsId", this.F);
        bundle.putString("tip", rv3.a(aq4.a(m93.O8), this.S));
        od1Var.F1(bundle);
        od1Var.d2(getSupportFragmentManager(), "GoodsShareDialogFragment");
    }

    public final void B2(boolean z) {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setImageDrawable(z ? this.M : this.L);
        }
    }

    public final void C2(int i) {
        View view = this.w;
        if (i == 0) {
            if (view.getVisibility() != 8) {
                this.w.setVisibility(8);
            }
            if (this.x.getVisibility() != 0) {
                this.x.setVisibility(0);
                return;
            }
            return;
        }
        if (view.getVisibility() != 0) {
            this.w.setVisibility(0);
        }
        if (this.x.getVisibility() != 8) {
            this.x.setVisibility(8);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.v = aq4.a(m93.j6);
        Intent intent = getIntent();
        this.F = intent.getStringExtra("mallGoodsId");
        this.H = intent.getBooleanExtra("mallGoodsFromShop", false);
        String stringExtra = intent.getStringExtra("liveUid");
        this.Q = stringExtra;
        if (SdkVersion.MINI_VERSION.equals(stringExtra)) {
            this.Q = "0";
        }
        this.R = intent.getStringExtra("shareUid");
        this.g = (TextView) findViewById(d73.Z1);
        this.h = (TextView) findViewById(d73.n3);
        this.i = (TextView) findViewById(d73.W1);
        this.j = (TextView) findViewById(d73.Y1);
        this.k = (TextView) findViewById(d73.b2);
        this.l = (TextView) findViewById(d73.d);
        this.m = (TextView) findViewById(d73.S3);
        this.n = (TextView) findViewById(d73.a2);
        this.o = (TextView) findViewById(d73.f4);
        this.p = (TextView) findViewById(d73.g4);
        this.t = aq4.a(m93.x6);
        this.q = (ImageView) findViewById(d73.Y3);
        this.r = (TextView) findViewById(d73.X3);
        this.s = findViewById(d73.a0);
        this.O = findViewById(d73.C4);
        findViewById(d73.U).setOnClickListener(this);
        findViewById(d73.f1).setOnClickListener(this);
        findViewById(d73.l1).setOnClickListener(this);
        findViewById(d73.k1).setOnClickListener(this);
        findViewById(d73.y0).setOnClickListener(this);
        findViewById(d73.J).setOnClickListener(this);
        findViewById(d73.X).setOnClickListener(this);
        findViewById(d73.h1).setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.f = (TextView) findViewById(d73.e3);
        ViewPager findViewById = findViewById(d73.w4);
        this.e = findViewById;
        findViewById.c(new b());
        this.u = (MagicIndicator) findViewById(d73.E2);
        String[] strArr = {aq4.a(m93.k6), this.v};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new c(strArr));
        commonNavigator.setAdjustMode(true);
        this.u.setNavigator(commonNavigator);
        this.w = findViewById(d73.l2);
        this.x = findViewById(d73.m2);
        this.y = findViewById(d73.v3);
        this.z = findViewById(d73.w3);
        this.A = findViewById(d73.U2);
        this.B = findViewById(d73.V2);
        this.y.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.z.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.N = (ImageView) findViewById(d73.z2);
        this.L = o60.d(this.b, v83.c);
        this.M = o60.d(this.b, y53.e);
        zu0.c().n(this);
        z2();
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
                s2();
                return;
            }
            if (id == d73.U || id == d73.J) {
                q2();
                return;
            }
            if (id == d73.l1 || id == d73.k1) {
                y2();
                return;
            }
            if (id == d73.y0) {
                if (SdkVersion.MINI_VERSION.equals(this.E)) {
                    com.yunbao.common.utils.a.q(this.b, null, true, aq4.a(m93.D8), true);
                    return;
                } else {
                    w2();
                    return;
                }
            }
            if (id == d73.a0) {
                GoodsCommentActivity.B1(this.b, this.F);
            } else if (id == d73.X) {
                r2();
            } else if (id == d73.h1) {
                A2();
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
    public void onPause() {
        super.onPause();
        this.I = true;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        this.I = false;
    }

    public final void q2() {
        if (!this.G) {
            t54.a(m93.y7);
            return;
        }
        if (this.P) {
            t54.a(m93.w8);
            return;
        }
        List list = this.J;
        if (list == null || list.size() == 0) {
            return;
        }
        pd1 pd1Var = new pd1();
        pd1Var.v2(this.J);
        pd1Var.d2(getSupportFragmentManager(), "GoodsSpecDialogFragment");
    }

    public final void r2() {
        if (this.G) {
            ec2.B0(this.F, new f());
        } else {
            t54.a(m93.y7);
        }
    }

    public final void s2() {
        if (this.G) {
            new bd1().d2(getSupportFragmentManager(), "GoodsCertDialogFragment");
        } else {
            t54.a(m93.y7);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void u1() {
        vq2 vq2Var = new vq2();
        vq2Var.t2(new g());
        vq2Var.d2(getSupportFragmentManager(), "NotLoginDialogFragment");
    }

    public void x2(int i) {
        GoodsChooseSpecBean goodsChooseSpecBean;
        List list = this.J;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator it = this.J.iterator();
        while (true) {
            if (!it.hasNext()) {
                goodsChooseSpecBean = null;
                break;
            } else {
                goodsChooseSpecBean = (GoodsChooseSpecBean) it.next();
                if (goodsChooseSpecBean.isChecked()) {
                    break;
                }
            }
        }
        GoodsChooseSpecBean goodsChooseSpecBean2 = goodsChooseSpecBean;
        if (goodsChooseSpecBean2 == null) {
            return;
        }
        GoodsMakeOrderActivity.D1(this.b, this.r.getText().toString(), this.F, this.i.getText().toString(), goodsChooseSpecBean2, i, this.K, this.Q, this.R);
    }
}
