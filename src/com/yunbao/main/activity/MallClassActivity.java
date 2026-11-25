package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsHomeClassBean;
import com.yunbao.mall.bean.GoodsSimpleBean;
import defpackage.bi1;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.dc2;
import defpackage.n30;
import defpackage.p53;
import defpackage.u83;
import defpackage.y73;
import defpackage.zh1;
import defpackage.zn0;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class MallClassActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public Drawable j;
    public Drawable k;
    public Drawable l;
    public int m;
    public int n;
    public CommonRefreshView o;
    public MagicIndicator p;
    public List q;
    public int r;
    public String s = "";
    public String t = "";
    public int u;
    public String v;
    public dc2 w;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (MallClassActivity.this.w == null) {
                MallClassActivity mallClassActivity = MallClassActivity.this;
                mallClassActivity.w = new dc2(mallClassActivity.b);
            }
            return MallClassActivity.this.w;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.a0(MallClassActivity.this.v, MallClassActivity.this.s, MallClassActivity.this.t, MallClassActivity.this.u, i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return JSON.parseArray(Arrays.toString(strArr), GoodsSimpleBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                MallClassActivity.this.q = JSON.parseArray(Arrays.toString(strArr), GoodsHomeClassBean.class);
                if (MallClassActivity.this.q == null || MallClassActivity.this.q.size() <= 0) {
                    return;
                }
                MallClassActivity mallClassActivity = MallClassActivity.this;
                mallClassActivity.v = ((GoodsHomeClassBean) mallClassActivity.q.get(0)).getId();
                MallClassActivity.this.P1();
                MallClassActivity.this.O1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends n30 {

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = MallClassActivity.this.r;
                int i2 = this.a;
                if (i != i2) {
                    MallClassActivity.this.r = i2;
                    MallClassActivity.this.p.a(2);
                    MallClassActivity.this.p.c(this.a);
                    MallClassActivity.this.p.b(this.a, 0.0f, 0);
                    MallClassActivity.this.p.a(0);
                    MallClassActivity mallClassActivity = MallClassActivity.this;
                    mallClassActivity.v = ((GoodsHomeClassBean) mallClassActivity.q.get(this.a)).getId();
                    MallClassActivity.this.O1();
                }
            }
        }

        public c() {
        }

        @Override // defpackage.n30
        public int a() {
            if (MallClassActivity.this.q != null) {
                return MallClassActivity.this.q.size();
            }
            return 0;
        }

        @Override // defpackage.n30
        public zh1 b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(1);
            linePagerIndicator.setXOffset(zn0.a(2));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(MallClassActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(o60.b(MallClassActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(MallClassActivity.this.b, p53.g));
            colorTransitionPagerTitleView.setText(((GoodsHomeClassBean) MallClassActivity.this.q.get(i)).getName());
            colorTransitionPagerTitleView.setTextSize(14.0f);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            return colorTransitionPagerTitleView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        CommonRefreshView commonRefreshView = this.o;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    public final void P1() {
        if (this.p == null) {
            return;
        }
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new c());
        this.p.setNavigator(commonNavigator);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        t1(intent.getStringExtra("className"));
        String stringExtra = intent.getStringExtra("classID");
        this.e = (TextView) findViewById(c73.N0);
        this.f = (TextView) findViewById(c73.a5);
        this.g = (TextView) findViewById(c73.V4);
        this.h = (ImageView) findViewById(c73.Q2);
        this.i = (ImageView) findViewById(c73.P2);
        this.j = o60.d(this.b, u83.C);
        this.k = o60.d(this.b, u83.y);
        this.l = o60.d(this.b, u83.z);
        this.m = o60.b(this.b, p53.h);
        this.n = o60.b(this.b, p53.l);
        this.e.setOnClickListener(this);
        findViewById(c73.a1).setOnClickListener(this);
        findViewById(c73.S0).setOnClickListener(this);
        this.p = (MagicIndicator) findViewById(c73.V2);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.o = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.C1);
        this.o.setLayoutManager(new GridLayoutManager(this.b, 2, 1, false));
        RecyclerView.n rq1Var = new rq1(this.b, 0, 10.0f, 0.0f);
        rq1Var.l(true);
        this.o.setItemDecoration(rq1Var);
        this.o.setDataHelper(new a());
        db2.b0(stringExtra, new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.N0) {
            this.s = "";
            this.t = "";
            this.u = 1;
            this.h.setImageDrawable(this.l);
            this.i.setImageDrawable(this.l);
            this.e.setTextColor(this.n);
            this.f.setTextColor(this.m);
            this.g.setTextColor(this.m);
        } else if (id == c73.a1) {
            if ("".equals(this.s) || "desc".equals(this.s)) {
                this.s = "asc";
                this.h.setImageDrawable(this.j);
            } else if ("asc".equals(this.s)) {
                this.s = "desc";
                this.h.setImageDrawable(this.k);
            }
            this.t = "";
            this.u = 0;
            this.i.setImageDrawable(this.l);
            this.e.setTextColor(this.m);
            this.f.setTextColor(this.n);
            this.g.setTextColor(this.m);
        } else if (id == c73.S0) {
            this.s = "";
            if ("".equals(this.t) || "desc".equals(this.t)) {
                this.t = "asc";
                this.i.setImageDrawable(this.j);
            } else if ("asc".equals(this.t)) {
                this.t = "desc";
                this.i.setImageDrawable(this.k);
            }
            this.u = 0;
            this.h.setImageDrawable(this.l);
            this.e.setTextColor(this.m);
            this.f.setTextColor(this.m);
            this.g.setTextColor(this.n);
        }
        O1();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        this.p = null;
        db2.i("getShopThreeClass");
        db2.i("getShopClassList");
        super.onDestroy();
    }
}
