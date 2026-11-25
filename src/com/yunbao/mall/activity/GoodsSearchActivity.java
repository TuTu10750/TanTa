package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.mall.bean.SearchGoodsBean;
import com.yunbao.mall.bean.SearchPayBean;
import defpackage.aq4;
import defpackage.bi1;
import defpackage.d73;
import defpackage.dk4;
import defpackage.ec2;
import defpackage.ek4;
import defpackage.k0;
import defpackage.m93;
import defpackage.n30;
import defpackage.p53;
import defpackage.rk3;
import defpackage.tk3;
import defpackage.vk3;
import defpackage.z73;
import defpackage.zh1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class GoodsSearchActivity extends AbsActivity {
    public List e;
    public MagicIndicator f;
    public k0[] g;
    public ViewPager h;
    public c i;
    public rk3 j;
    public vk3 k;
    public tk3 l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            GoodsSearchActivity.this.E1(i);
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
                if (GoodsSearchActivity.this.h != null) {
                    GoodsSearchActivity.this.h.setCurrentItem(this.a);
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
            colorTransitionPagerTitleView.setNormalColor(o60.b(GoodsSearchActivity.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(GoodsSearchActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(17.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            return colorTransitionPagerTitleView;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends Handler {
        public GoodsSearchActivity a;

        public c(GoodsSearchActivity goodsSearchActivity) {
            this.a = (GoodsSearchActivity) new WeakReference(goodsSearchActivity).get();
        }

        public void a() {
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GoodsSearchActivity goodsSearchActivity = this.a;
            if (goodsSearchActivity != null) {
                goodsSearchActivity.F1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(int i) {
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
                        rk3 rk3Var = new rk3(this.b, frameLayout, this.i);
                        this.j = rk3Var;
                        k0Var = rk3Var;
                    } else if (i == 1) {
                        vk3 vk3Var = new vk3(this.b, frameLayout, this.i);
                        this.k = vk3Var;
                        k0Var = vk3Var;
                    } else {
                        k0Var = k0Var2;
                        if (i == 2) {
                            tk3 tk3Var = new tk3(this.b, frameLayout, this.i);
                            this.l = tk3Var;
                            k0Var = tk3Var;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        if (this.h.getCurrentItem() == 0) {
            rk3 rk3Var = this.j;
            if (rk3Var != null) {
                rk3Var.j0();
                return;
            }
            return;
        }
        if (this.h.getCurrentItem() == 1) {
            vk3 vk3Var = this.k;
            if (vk3Var != null) {
                vk3Var.j0();
                return;
            }
            return;
        }
        tk3 tk3Var = this.l;
        if (tk3Var != null) {
            tk3Var.j0();
        }
    }

    public void B1() {
        rk3 rk3Var = this.j;
        if (rk3Var != null) {
            rk3Var.g0();
        }
    }

    public void C1() {
        tk3 tk3Var = this.l;
        if (tk3Var != null) {
            tk3Var.g0();
        }
    }

    public void D1() {
        vk3 vk3Var = this.k;
        if (vk3Var != null) {
            vk3Var.g0();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.v;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.e = new ArrayList();
        for (int i = 0; i < 3; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        ViewPager findViewById = findViewById(d73.v4);
        this.h = findViewById;
        findViewById.setOffscreenPageLimit(2);
        this.h.setAdapter(new dk4(this.e));
        this.h.c(new a());
        this.g = new k0[3];
        this.f = (MagicIndicator) findViewById(d73.E2);
        String[] strArr = {aq4.a(m93.T7), aq4.a(m93.y8), aq4.a(m93.U7)};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new b(strArr));
        commonNavigator.setAdjustMode(true);
        this.f.setNavigator(commonNavigator);
        ek4.a(this.f, this.h);
        this.i = new c(this);
        E1(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        SearchPayBean h0;
        SearchGoodsBean h02;
        SearchGoodsBean h03;
        rk3 rk3Var = this.j;
        if (rk3Var != null && (h03 = rk3Var.h0()) != null) {
            Intent intent = new Intent();
            intent.putExtra("mallGoodsId", h03.getId());
            intent.putExtra("mallGoodsName", h03.getName());
            intent.putExtra("liveType", 1);
            setResult(-1, intent);
            finish();
            return;
        }
        vk3 vk3Var = this.k;
        if (vk3Var != null && (h02 = vk3Var.h0()) != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("mallGoodsId", h02.getId());
            intent2.putExtra("mallGoodsName", h02.getName());
            intent2.putExtra("liveType", 3);
            setResult(-1, intent2);
            finish();
            return;
        }
        tk3 tk3Var = this.l;
        if (tk3Var == null || (h0 = tk3Var.h0()) == null) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
            return;
        }
        Intent intent3 = new Intent();
        intent3.putExtra("mallGoodsId", h0.getId());
        intent3.putExtra("mallGoodsName", h0.getName());
        intent3.putExtra("liveType", 2);
        setResult(-1, intent3);
        finish();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("searchGoodsList");
        ec2.u("searchPlatGoodsList");
        ec2.u("searchPayList");
        c cVar = this.i;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
            this.i.a();
        }
        this.i = null;
        super.onDestroy();
    }
}
