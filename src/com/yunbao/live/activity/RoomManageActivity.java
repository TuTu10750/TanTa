package com.yunbao.live.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.activity.AbsActivity;
import defpackage.a42;
import defpackage.aq4;
import defpackage.b73;
import defpackage.bi1;
import defpackage.dk4;
import defpackage.ek4;
import defpackage.k0;
import defpackage.m93;
import defpackage.n30;
import defpackage.p53;
import defpackage.x73;
import defpackage.z32;
import defpackage.zh1;
import defpackage.zn0;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class RoomManageActivity extends AbsActivity {
    public List e;
    public MagicIndicator f;
    public k0[] g;
    public ViewPager h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            RoomManageActivity.this.B1(i);
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
                if (RoomManageActivity.this.h != null) {
                    RoomManageActivity.this.h.setCurrentItem(this.a);
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
            linePagerIndicator.setLineWidth(zn0.a(18));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(RoomManageActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(o60.b(RoomManageActivity.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(RoomManageActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(17.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            return colorTransitionPagerTitleView;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends ColorDrawable {
        public c() {
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return zn0.a(30);
        }
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
                k0Var = new z32(this.b, frameLayout);
            } else if (i == 1) {
                k0Var = new a42(this.b, frameLayout);
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
        return x73.k;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.e = new ArrayList();
        for (int i = 0; i < 2; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        ViewPager findViewById = findViewById(b73.g6);
        this.h = findViewById;
        findViewById.setOffscreenPageLimit(1);
        this.h.setAdapter(new dk4(this.e));
        this.h.c(new a());
        this.g = new k0[2];
        this.f = (MagicIndicator) findViewById(b73.e3);
        String[] strArr = {aq4.a(m93.h4), aq4.a(m93.i4)};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new b(strArr));
        this.f.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer();
        titleContainer.setShowDividers(2);
        titleContainer.setDividerDrawable(new c());
        ek4.a(this.f, this.h);
        B1(0);
    }
}
