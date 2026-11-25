package com.yunbao.main.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.activity.AbsActivity;
import defpackage.aq4;
import defpackage.bi1;
import defpackage.c73;
import defpackage.ci4;
import defpackage.dk4;
import defpackage.ek4;
import defpackage.j30;
import defpackage.k0;
import defpackage.m93;
import defpackage.n30;
import defpackage.p53;
import defpackage.y73;
import defpackage.yh4;
import defpackage.zh1;
import defpackage.zn0;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class MyVideoActivity extends AbsActivity {
    public List e;
    public MagicIndicator f;
    public k0[] g;
    public ViewPager h;
    public yh4 i;
    public ci4 j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            MyVideoActivity.this.B1(i);
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
                if (MyVideoActivity.this.h != null) {
                    MyVideoActivity.this.h.setCurrentItem(this.a);
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
            linePagerIndicator.setMode(1);
            linePagerIndicator.setXOffset(zn0.a(10));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(MyVideoActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(o60.b(MyVideoActivity.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(MyVideoActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(17.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            return colorTransitionPagerTitleView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(int i) {
        k0 k0Var;
        k0[] k0VarArr = this.g;
        if (k0VarArr == null) {
            return;
        }
        k0 k0Var2 = k0VarArr[i];
        k0 k0Var3 = k0Var2;
        if (k0Var2 == null) {
            List list = this.e;
            k0Var3 = k0Var2;
            if (list != null) {
                k0Var3 = k0Var2;
                if (i < list.size()) {
                    FrameLayout frameLayout = (FrameLayout) this.e.get(i);
                    if (frameLayout == null) {
                        return;
                    }
                    if (i == 0) {
                        yh4 yh4Var = new yh4(this.b, frameLayout, j30.q().C());
                        this.i = yh4Var;
                        k0Var = yh4Var;
                    } else {
                        k0Var = k0Var2;
                        if (i == 1) {
                            ci4 ci4Var = new ci4(this.b, frameLayout);
                            this.j = ci4Var;
                            k0Var = ci4Var;
                        }
                    }
                    if (k0Var == null) {
                        return;
                    }
                    this.g[i] = k0Var;
                    k0Var.addToParent();
                    k0Var.subscribeActivityLifeCycle();
                    k0Var3 = k0Var;
                }
            }
        }
        if (k0Var3 != null) {
            k0Var3.loadData();
        }
    }

    private void C1() {
        yh4 yh4Var = this.i;
        if (yh4Var != null) {
            yh4Var.release();
        }
        this.i = null;
        ci4 ci4Var = this.j;
        if (ci4Var != null) {
            ci4Var.release();
        }
        this.j = null;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.L;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.ka));
        this.e = new ArrayList();
        for (int i = 0; i < 2; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        ViewPager findViewById = findViewById(c73.y5);
        this.h = findViewById;
        findViewById.setOffscreenPageLimit(1);
        this.h.setAdapter(new dk4(this.e));
        this.h.c(new a());
        this.g = new k0[2];
        this.f = (MagicIndicator) findViewById(c73.V2);
        String[] strArr = {aq4.a(m93.wa), aq4.a(m93.va)};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new b(strArr));
        commonNavigator.setAdjustMode(true);
        this.f.setNavigator(commonNavigator);
        ek4.a(this.f, this.h);
        B1(0);
    }

    public void onBackPressed() {
        C1();
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        C1();
        super.onDestroy();
    }
}
