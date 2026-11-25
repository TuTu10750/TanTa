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
import defpackage.j30;
import defpackage.k0;
import defpackage.m93;
import defpackage.mx2;
import defpackage.n30;
import defpackage.p53;
import defpackage.yw2;
import defpackage.z73;
import defpackage.zh1;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class PayContentActivity2 extends AbsActivity {
    public List e;
    public MagicIndicator f;
    public k0[] g;
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
            PayContentActivity2.this.B1(i);
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
                if (PayContentActivity2.this.h != null) {
                    PayContentActivity2.this.h.setCurrentItem(this.a);
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
            return null;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(o60.b(PayContentActivity2.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(PayContentActivity2.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(17.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            return colorTransitionPagerTitleView;
        }
    }

    public static void A1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) PayContentActivity2.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(int i) {
        List list;
        k0[] k0VarArr = this.g;
        if (k0VarArr == null) {
            return;
        }
        k0 k0Var = k0VarArr[i];
        if (k0Var == null && (list = this.e) != null && i < list.size()) {
            FrameLayout frameLayout = (FrameLayout) this.e.get(i);
            if (frameLayout == null) {
                return;
            }
            if (i == 0) {
                k0Var = new mx2(this.b, frameLayout, j30.q().C(), true);
            } else if (i == 1) {
                k0Var = new yw2(this.b, frameLayout);
            }
            if (k0Var == null) {
                return;
            }
            this.g[i] = k0Var;
            k0Var.addToParent();
            k0Var.subscribeActivityLifeCycle();
        }
        if (k0Var != null) {
            k0Var.loadData();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.B;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.e = new ArrayList();
        for (int i = 0; i < 2; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        ViewPager findViewById = findViewById(d73.v4);
        this.h = findViewById;
        findViewById.setOffscreenPageLimit(1);
        this.h.setAdapter(new dk4(this.e));
        this.h.c(new a());
        this.g = new k0[2];
        this.f = (MagicIndicator) findViewById(d73.E2);
        String[] strArr = {aq4.a(m93.A7), aq4.a(m93.z7)};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new b(strArr));
        commonNavigator.setAdjustMode(true);
        this.f.setNavigator(commonNavigator);
        ek4.a(this.f, this.h);
        B1(0);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyPayContentList");
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
        k0[] k0VarArr;
        super.onResume();
        if (this.i && (viewPager = this.h) != null && (k0VarArr = this.g) != null) {
            k0VarArr[viewPager.getCurrentItem()].loadData();
        }
        this.i = false;
    }
}
