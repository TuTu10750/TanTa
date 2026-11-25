package com.yunbao.mall.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import defpackage.a1;
import defpackage.aq4;
import defpackage.bi1;
import defpackage.bm3;
import defpackage.cm3;
import defpackage.d73;
import defpackage.dk4;
import defpackage.ec2;
import defpackage.em3;
import defpackage.gm3;
import defpackage.im3;
import defpackage.km3;
import defpackage.m93;
import defpackage.mm3;
import defpackage.n30;
import defpackage.p53;
import defpackage.rv3;
import defpackage.rx1;
import defpackage.yl3;
import defpackage.z73;
import defpackage.zh1;
import defpackage.zl3;
import defpackage.zn0;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class SellerOrderActivity extends AbsActivity implements View.OnClickListener {
    public ObjectAnimator A;
    public ObjectAnimator B;
    public View C;
    public int D;
    public int E;
    public boolean F;
    public List e;
    public MagicIndicator f;
    public a1[] g;
    public ViewPager h;
    public boolean i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public View x;
    public View y;
    public View z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SellerOrderActivity.this.c1()) {
                SellerOrderActivity.this.O1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SellerOrderActivity.this.P1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements ViewPager.j {
        public c() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            SellerOrderActivity.this.Q1(i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends n30 {
        public final /* synthetic */ String[] b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = this.a;
                d dVar = d.this;
                if (i == 3) {
                    SellerOrderActivity.this.U1();
                } else {
                    SellerOrderActivity.this.T1(i);
                    SellerOrderActivity.this.S1(this.a);
                }
            }
        }

        public d(String[] strArr) {
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
            linePagerIndicator.setColors(Integer.valueOf(o60.b(SellerOrderActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            if (rx1.h()) {
                colorTransitionPagerTitleView.setPadding(0, 0, 0, 0);
            }
            colorTransitionPagerTitleView.setNormalColor(o60.b(SellerOrderActivity.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(SellerOrderActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(14.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            if (i == 0) {
                SellerOrderActivity.this.j = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 1) {
                SellerOrderActivity.this.k = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 2) {
                SellerOrderActivity.this.l = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 3) {
                SellerOrderActivity.this.m = colorTransitionPagerTitleView;
            }
            return colorTransitionPagerTitleView;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SellerOrderActivity.this.y.setAlpha((((Float) valueAnimator.getAnimatedValue()).floatValue() / this.a) + 1.0f);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SellerOrderActivity.this.z != null && SellerOrderActivity.this.z.getVisibility() == 0) {
                SellerOrderActivity.this.z.setVisibility(4);
            }
            SellerOrderActivity.this.F = false;
        }
    }

    public static void N1(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) SellerOrderActivity.class);
        intent.putExtra("mallOrderIndex", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(int i) {
        List list;
        a1[] a1VarArr = this.g;
        if (a1VarArr == null) {
            return;
        }
        a1 a1Var = a1VarArr[i];
        if (a1Var == null && (list = this.e) != null && i < list.size()) {
            FrameLayout frameLayout = (FrameLayout) this.e.get(i);
            if (frameLayout == null) {
                return;
            }
            if (i == 0) {
                a1Var = new mm3(this.b, frameLayout);
            } else if (i == 1) {
                a1Var = new km3(this.b, frameLayout);
            } else if (i == 2) {
                a1Var = new gm3(this.b, frameLayout);
            } else if (i == 4) {
                a1Var = new yl3(this.b, frameLayout);
            } else if (i == 5) {
                a1Var = new im3(this.b, frameLayout);
            } else if (i == 6) {
                a1Var = new cm3(this.b, frameLayout);
            } else if (i == 7) {
                a1Var = new em3(this.b, frameLayout);
            } else if (i == 8) {
                a1Var = new bm3(this.b, frameLayout);
            } else if (i == 9) {
                a1Var = new zl3(this.b, frameLayout);
            }
            if (a1Var == null) {
                return;
            }
            this.g[i] = a1Var;
            a1Var.addToParent();
            a1Var.subscribeActivityLifeCycle();
        }
        if (a1Var != null) {
            a1Var.loadData();
        }
    }

    public final void O1() {
        View view = this.C;
        if (view != null) {
            view.setRotation(90.0f);
        }
        ObjectAnimator objectAnimator = this.A;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.B;
        if (objectAnimator2 != null) {
            objectAnimator2.start();
        }
    }

    public final void P1() {
        int height = this.x.getHeight();
        float f2 = -height;
        this.x.setTranslationY(f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.x, "translationY", 0.0f);
        this.A = ofFloat;
        ofFloat.setDuration(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.x, "translationY", f2);
        this.B = ofFloat2;
        ofFloat2.setDuration(200L);
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.A.setInterpolator(accelerateDecelerateInterpolator);
        this.B.setInterpolator(accelerateDecelerateInterpolator);
        e eVar = new e(height);
        this.A.addUpdateListener(eVar);
        this.B.addUpdateListener(eVar);
        this.B.addListener(new f());
    }

    public void R1(String str) {
        JSONObject parseObject = JSON.parseObject(str);
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(rv3.a(this.n, " ", parseObject.getString("wait_shipment_nums")));
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setText(rv3.a(this.o, " ", parseObject.getString("wait_refund_nums")));
        }
        TextView textView3 = this.l;
        if (textView3 != null) {
            textView3.setText(rv3.a(this.p, " ", parseObject.getString("wait_payment_nums")));
        }
        int i = this.D;
        if (i == 4) {
            this.m.setText(rv3.a(this.r, " ", parseObject.getString("all_refund_nums")));
            return;
        }
        if (i == 5) {
            this.m.setText(rv3.a(this.s, " ", parseObject.getString("wait_receive_nums")));
            return;
        }
        if (i == 6) {
            this.m.setText(rv3.a(this.t, " ", parseObject.getString("wait_evaluate_nums")));
            return;
        }
        if (i == 7) {
            this.m.setText(rv3.a(this.u, parseObject.getString("finished_nums")));
        } else if (i == 8) {
            this.m.setText(rv3.a(this.v, " ", parseObject.getString("closed_nums")));
        } else if (i == 9) {
            this.m.setText(rv3.a(this.w, " ", parseObject.getString("all_nums")));
        }
    }

    public final void S1(int i) {
        O1();
        if (this.D != i) {
            this.D = i;
            ViewPager viewPager = this.h;
            if (viewPager != null) {
                viewPager.M(i, false);
            }
        }
    }

    public final void T1(int i) {
        if (i > 3) {
            i = 3;
        }
        if (this.E != i) {
            this.E = i;
            this.f.a(2);
            this.f.c(i);
            this.f.b(i, 0.0f, 0);
            this.f.a(0);
        }
    }

    public final void U1() {
        if (this.F) {
            return;
        }
        this.F = true;
        View view = this.C;
        if (view != null) {
            view.setRotation(-90.0f);
        }
        View view2 = this.z;
        if (view2 != null && view2.getVisibility() != 0) {
            this.z.setVisibility(0);
        }
        ObjectAnimator objectAnimator = this.A;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.O;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.L5));
        this.n = aq4.a(m93.s5);
        this.o = aq4.a(m93.L6);
        this.p = aq4.a(m93.K6);
        this.q = aq4.a(m93.M6);
        this.r = aq4.a(m93.R6);
        this.s = aq4.a(m93.S6);
        this.t = aq4.a(m93.T6);
        this.u = aq4.a(m93.U6);
        this.v = aq4.a(m93.V6);
        this.w = aq4.a(m93.J0);
        this.x = findViewById(d73.P1);
        this.y = findViewById(d73.W3);
        View findViewById = findViewById(d73.o0);
        this.z = findViewById;
        findViewById.setOnClickListener(new a());
        this.x.post(new b());
        this.C = findViewById(d73.k);
        findViewById(d73.y).setOnClickListener(this);
        findViewById(d73.e1).setOnClickListener(this);
        findViewById(d73.S0).setOnClickListener(this);
        findViewById(d73.r0).setOnClickListener(this);
        findViewById(d73.W).setOnClickListener(this);
        findViewById(d73.x).setOnClickListener(this);
        this.e = new ArrayList();
        for (int i = 0; i < 10; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        ViewPager findViewById2 = findViewById(d73.v4);
        this.h = findViewById2;
        findViewById2.setOffscreenPageLimit(9);
        this.h.setAdapter(new dk4(this.e));
        this.h.c(new c());
        this.g = new a1[10];
        this.f = (MagicIndicator) findViewById(d73.E2);
        if (!rx1.h()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
            marginLayoutParams.rightMargin = zn0.a(20);
            this.f.setLayoutParams(marginLayoutParams);
        }
        String[] strArr = {this.n, this.o, this.p, this.q};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new d(strArr));
        if (rx1.h()) {
            commonNavigator.setAdjustMode(true);
        }
        this.f.setNavigator(commonNavigator);
        int intExtra = getIntent().getIntExtra("mallOrderIndex", 0);
        if (intExtra == 0) {
            Q1(0);
            return;
        }
        T1(intExtra);
        this.D = intExtra;
        this.h.M(intExtra, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.y) {
            T1(3);
            S1(4);
            return;
        }
        if (id == d73.e1) {
            T1(3);
            S1(5);
            return;
        }
        if (id == d73.S0) {
            T1(3);
            S1(6);
            return;
        }
        if (id == d73.r0) {
            T1(3);
            S1(7);
        } else if (id == d73.W) {
            T1(3);
            S1(8);
        } else if (id == d73.x) {
            T1(3);
            S1(9);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getSellerOrderList");
        ec2.u("sellerDeleteOrder");
        ec2.u("getImUserInfo");
        ObjectAnimator objectAnimator = this.B;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.B.removeAllUpdateListeners();
            this.B.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.A;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.A.removeAllUpdateListeners();
            this.A.removeAllListeners();
        }
        this.A = null;
        this.B = null;
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onPause() {
        this.i = true;
        super.onPause();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        ViewPager viewPager;
        a1[] a1VarArr;
        a1 a1Var;
        super.onResume();
        if (this.i && (viewPager = this.h) != null && (a1VarArr = this.g) != null && (a1Var = a1VarArr[viewPager.getCurrentItem()]) != null) {
            a1Var.k0();
        }
        this.i = false;
    }
}
