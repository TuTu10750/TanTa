package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.activity.AbsActivity;
import defpackage.aq4;
import defpackage.bi1;
import defpackage.d73;
import defpackage.dk4;
import defpackage.ec2;
import defpackage.ek4;
import defpackage.j0;
import defpackage.m93;
import defpackage.n30;
import defpackage.nl;
import defpackage.p53;
import defpackage.ql;
import defpackage.rx1;
import defpackage.sl;
import defpackage.ul;
import defpackage.wl;
import defpackage.yl;
import defpackage.z73;
import defpackage.zh1;
import defpackage.zn0;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class BuyerOrderActivity extends AbsActivity {
    public List e;
    public MagicIndicator f;
    public j0[] g;
    public ViewPager h;
    public boolean i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            BuyerOrderActivity.this.C1(i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends n30 {
        public final /* synthetic */ String[] b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BuyerOrderActivity.this.h != null) {
                    BuyerOrderActivity.this.h.M(this.a, false);
                }
            }
        }

        public b(String[] strArr) {
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
            linePagerIndicator.setColors(Integer.valueOf(o60.b(BuyerOrderActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            if (rx1.h()) {
                colorTransitionPagerTitleView.setPadding(0, 0, 0, 0);
            }
            colorTransitionPagerTitleView.setNormalColor(o60.b(BuyerOrderActivity.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(BuyerOrderActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(14.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            return colorTransitionPagerTitleView;
        }
    }

    public static void B1(Context context, int i) {
        Intent intent = new Intent(context, (Class<?>) BuyerOrderActivity.class);
        intent.putExtra("mallOrderIndex", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(int i) {
        List list;
        j0[] j0VarArr = this.g;
        if (j0VarArr == null) {
            return;
        }
        j0 j0Var = j0VarArr[i];
        if (j0Var == null && (list = this.e) != null && i < list.size()) {
            FrameLayout frameLayout = (FrameLayout) this.e.get(i);
            if (frameLayout == null) {
                return;
            }
            if (i == 0) {
                j0Var = new nl(this.b, frameLayout);
            } else if (i == 1) {
                j0Var = new sl(this.b, frameLayout);
            } else if (i == 2) {
                j0Var = new yl(this.b, frameLayout);
            } else if (i == 3) {
                j0Var = new ul(this.b, frameLayout);
            } else if (i == 4) {
                j0Var = new ql(this.b, frameLayout);
            } else if (i == 5) {
                j0Var = new wl(this.b, frameLayout);
            }
            if (j0Var == null) {
                return;
            }
            this.g[i] = j0Var;
            j0Var.addToParent();
            j0Var.subscribeActivityLifeCycle();
        }
        if (j0Var != null) {
            j0Var.loadData();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.G6));
        this.e = new ArrayList();
        for (int i = 0; i < 6; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        ViewPager findViewById = findViewById(d73.v4);
        this.h = findViewById;
        findViewById.setOffscreenPageLimit(5);
        this.h.setAdapter(new dk4(this.e));
        this.h.c(new a());
        this.g = new j0[6];
        this.f = (MagicIndicator) findViewById(d73.E2);
        String[] strArr = {aq4.a(m93.H6), aq4.a(m93.r5), aq4.a(m93.s5), aq4.a(m93.t5), aq4.a(m93.u5), aq4.a(m93.v5)};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new b(strArr));
        if (rx1.h()) {
            commonNavigator.setAdjustMode(true);
        }
        this.f.setNavigator(commonNavigator);
        ek4.a(this.f, this.h);
        int intExtra = getIntent().getIntExtra("mallOrderIndex", 0);
        if (intExtra == 0) {
            C1(0);
        } else {
            this.h.M(intExtra, false);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerOrderList");
        ec2.u("buyerDeleteOrder");
        ec2.u("buyerCancelOrder");
        ec2.u("buyerConfirmReceive");
        ec2.u("getImUserInfo");
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
        j0[] j0VarArr;
        j0 j0Var;
        super.onResume();
        if (this.i && (viewPager = this.h) != null && (j0VarArr = this.g) != null && (j0Var = j0VarArr[viewPager.getCurrentItem()]) != null) {
            j0Var.f0();
        }
        this.i = false;
    }
}
