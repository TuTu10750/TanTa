package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.bean.ImConUserBean;
import com.yunbao.mall.custom.ShopIndicatorTitle;
import defpackage.aq4;
import defpackage.bi1;
import defpackage.d73;
import defpackage.dk4;
import defpackage.ek4;
import defpackage.j30;
import defpackage.k0;
import defpackage.kn1;
import defpackage.m93;
import defpackage.n30;
import defpackage.p53;
import defpackage.xj1;
import defpackage.xo3;
import defpackage.y63;
import defpackage.z73;
import defpackage.zh1;
import defpackage.zn0;
import defpackage.zo3;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class ShopHomeActivity extends AbsActivity implements View.OnClickListener {
    public int e = 2;
    public SmartRefreshLayout f;
    public ClassicsHeader g;
    public List h;
    public MagicIndicator i;
    public k0[] j;
    public ViewPager k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public String t;
    public JSONObject u;
    public String v;
    public boolean w;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ot2 {
        public a() {
        }

        public void onRefresh(ke3 ke3Var) {
            if (ShopHomeActivity.this.k != null) {
                ShopHomeActivity shopHomeActivity = ShopHomeActivity.this;
                shopHomeActivity.P1(shopHomeActivity.k.getCurrentItem());
            }
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
            ShopHomeActivity.this.P1(i);
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
                if (ShopHomeActivity.this.k != null) {
                    ShopHomeActivity.this.k.setCurrentItem(this.a);
                }
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
            linePagerIndicator.setMode(1);
            linePagerIndicator.setXOffset(zn0.a(10));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(ShopHomeActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ShopIndicatorTitle shopIndicatorTitle = new ShopIndicatorTitle(ShopHomeActivity.this.b);
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setPadding(0, 0, 0, 0);
            colorTransitionPagerTitleView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            colorTransitionPagerTitleView.setNormalColor(o60.b(ShopHomeActivity.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(ShopHomeActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(15.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            shopIndicatorTitle.addView(colorTransitionPagerTitleView);
            shopIndicatorTitle.setTitleView(colorTransitionPagerTitleView);
            shopIndicatorTitle.setOnClickListener(new a(i));
            if (ShopHomeActivity.this.w) {
                if (i == 0) {
                    ShopHomeActivity.this.o = new TextView(ShopHomeActivity.this.b);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = zn0.a(5);
                    ShopHomeActivity.this.o.setLayoutParams(layoutParams);
                    shopIndicatorTitle.addView(ShopHomeActivity.this.o);
                    return shopIndicatorTitle;
                }
            } else {
                if (i == 0) {
                    ShopHomeActivity.this.n = new TextView(ShopHomeActivity.this.b);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.leftMargin = zn0.a(5);
                    ShopHomeActivity.this.n.setLayoutParams(layoutParams2);
                    shopIndicatorTitle.addView(ShopHomeActivity.this.n);
                    return shopIndicatorTitle;
                }
                if (i == 1) {
                    ShopHomeActivity.this.o = new TextView(ShopHomeActivity.this.b);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.leftMargin = zn0.a(5);
                    ShopHomeActivity.this.o.setLayoutParams(layoutParams3);
                    shopIndicatorTitle.addView(ShopHomeActivity.this.o);
                }
            }
            return shopIndicatorTitle;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends ColorDrawable {
        public d() {
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return zn0.a(30);
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
            ChatRoomActivity.A1(ShopHomeActivity.this.b, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    public static void M1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) ShopHomeActivity.class);
        intent.putExtra("toUid", str);
        context.startActivity(intent);
    }

    private void N1() {
        JSONObject jSONObject = this.u;
        if (jSONObject != null) {
            ShopDetailActivity.w1(this.b, jSONObject.getString("certificate_desc"), this.u.getString("certificate"));
        }
    }

    private void O1() {
        JSONObject jSONObject = this.u;
        if (jSONObject == null) {
            return;
        }
        xj1.g(jSONObject.getString("uid"), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1(int i) {
        List list;
        k0[] k0VarArr = this.j;
        if (k0VarArr == null) {
            return;
        }
        k0 k0Var = k0VarArr[i];
        if (k0Var == null && (list = this.h) != null && i < list.size()) {
            FrameLayout frameLayout = (FrameLayout) this.h.get(i);
            if (frameLayout == null) {
                return;
            }
            if (this.w) {
                if (i == 0) {
                    k0Var = new zo3(this.b, frameLayout, this.t);
                }
            } else if (i == 0) {
                k0Var = new xo3(this.b, frameLayout, this.t);
            } else if (i == 1) {
                k0Var = new zo3(this.b, frameLayout, this.t);
            }
            if (k0Var == null) {
                return;
            }
            this.j[i] = k0Var;
            k0Var.addToParent();
            k0Var.subscribeActivityLifeCycle();
        }
        if (k0Var != null) {
            k0Var.loadData();
        }
    }

    public void L1() {
        SmartRefreshLayout smartRefreshLayout = this.f;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.x(true);
        }
    }

    public void Q1(JSONObject jSONObject) {
        this.u = jSONObject;
        if (jSONObject != null) {
            if (this.l != null) {
                kn1.g(this.b, jSONObject.getString("avatar"), this.l);
            }
            TextView textView = this.m;
            if (textView != null) {
                textView.setText(this.u.getString("name"));
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setText(String.format(this.v, this.u.getString("goods_nums")));
            }
            TextView textView3 = this.o;
            if (textView3 != null) {
                textView3.setText(String.format(this.v, this.u.getString("platform_goods_nums")));
            }
            TextView textView4 = this.p;
            if (textView4 != null) {
                textView4.setText(String.format(this.v, this.u.getString("sale_nums")));
            }
            TextView textView5 = this.q;
            if (textView5 != null) {
                textView5.setText(this.u.getString("quality_points"));
            }
            TextView textView6 = this.r;
            if (textView6 != null) {
                textView6.setText(this.u.getString("service_points"));
            }
            TextView textView7 = this.s;
            if (textView7 != null) {
                textView7.setText(this.u.getString("express_points"));
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.Y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        ConfigBean h = j30.q().h();
        if (h != null) {
            t1(h.getShopSystemName());
        } else {
            t1(aq4.a(m93.p5));
        }
        String stringExtra = getIntent().getStringExtra("toUid");
        this.t = stringExtra;
        boolean equals = SdkVersion.MINI_VERSION.equals(stringExtra);
        this.w = equals;
        if (equals) {
            this.e = 1;
        }
        this.l = (ImageView) findViewById(d73.l);
        this.m = (TextView) findViewById(d73.R2);
        this.p = (TextView) findViewById(d73.S3);
        this.q = (TextView) findViewById(d73.a2);
        this.r = (TextView) findViewById(d73.f4);
        this.s = (TextView) findViewById(d73.g4);
        findViewById(d73.R).setOnClickListener(this);
        View findViewById = findViewById(d73.y0);
        if (TextUtils.isEmpty(this.t) || !this.t.equals(j30.q().C())) {
            findViewById.setOnClickListener(this);
        } else {
            findViewById.setVisibility(4);
        }
        this.v = aq4.a(m93.x6);
        SmartRefreshLayout findViewById2 = findViewById(y63.a0);
        this.f = findViewById2;
        findViewById2.J(true);
        this.f.I(false);
        this.f.M(new a());
        int b2 = o60.b(this.b, p53.l);
        ClassicsHeader findViewById3 = findViewById(y63.L);
        this.g = findViewById3;
        findViewById3.n(b2);
        this.h = new ArrayList();
        for (int i = 0; i < this.e; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.h.add(frameLayout);
        }
        ViewPager findViewById4 = findViewById(d73.v4);
        this.k = findViewById4;
        int i2 = this.e;
        if (i2 > 1) {
            findViewById4.setOffscreenPageLimit(i2 - 1);
        }
        this.k.setAdapter(new dk4(this.h));
        this.k.c(new b());
        this.j = new k0[this.e];
        this.i = (MagicIndicator) findViewById(d73.E2);
        String[] strArr = this.w ? new String[]{aq4.a(m93.y8)} : new String[]{aq4.a(m93.x8), aq4.a(m93.y8)};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new c(strArr));
        this.i.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer();
        titleContainer.setShowDividers(2);
        titleContainer.setDividerDrawable(new d());
        ek4.a(this.i, this.k);
        P1(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((AbsActivity) this.b).e1()) {
            int id = view.getId();
            if (id == d73.R) {
                N1();
            } else if (id == d73.y0) {
                if (this.w) {
                    com.yunbao.common.utils.a.q(this.b, null, true, aq4.a(m93.D8), true);
                } else {
                    O1();
                }
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        xj1.a("getImUserInfo");
        super.onDestroy();
    }
}
