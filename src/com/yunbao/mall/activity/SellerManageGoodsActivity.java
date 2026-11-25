package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import defpackage.ao3;
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
import defpackage.pm3;
import defpackage.pw3;
import defpackage.rv3;
import defpackage.rx1;
import defpackage.sm3;
import defpackage.um3;
import defpackage.wl3;
import defpackage.z73;
import defpackage.zh1;
import defpackage.zn0;
import defpackage.zu0;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class SellerManageGoodsActivity extends AbsActivity implements View.OnClickListener {
    public List e;
    public MagicIndicator f;
    public k0[] g;
    public ViewPager h;
    public String i;
    public String j;
    public String k;
    public String l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public wl3 q;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            SellerManageGoodsActivity.this.S1(i);
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
                if (SellerManageGoodsActivity.this.h != null) {
                    SellerManageGoodsActivity.this.h.setCurrentItem(this.a);
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
            linePagerIndicator.setColors(Integer.valueOf(o60.b(SellerManageGoodsActivity.this.b, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(o60.b(SellerManageGoodsActivity.this.b, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(SellerManageGoodsActivity.this.b, p53.l));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(14.0f);
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            if (i == 0) {
                SellerManageGoodsActivity.this.m = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 1) {
                SellerManageGoodsActivity.this.p = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 2) {
                SellerManageGoodsActivity.this.n = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 3) {
                SellerManageGoodsActivity.this.o = colorTransitionPagerTitleView;
            }
            return colorTransitionPagerTitleView;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (SellerManageGoodsActivity.this.m != null) {
                SellerManageGoodsActivity.this.m.setText(rv3.a(SellerManageGoodsActivity.this.i, " ", parseObject.getString("onsale")));
            }
            if (SellerManageGoodsActivity.this.p != null) {
                SellerManageGoodsActivity.this.p.setText(rv3.a(SellerManageGoodsActivity.this.l, " ", parseObject.getString("platform")));
            }
            if (SellerManageGoodsActivity.this.n != null) {
                SellerManageGoodsActivity.this.n.setText(rv3.a(SellerManageGoodsActivity.this.j, " ", parseObject.getString("onexamine")));
            }
            if (SellerManageGoodsActivity.this.o != null) {
                SellerManageGoodsActivity.this.o.setText(rv3.a(SellerManageGoodsActivity.this.k, " ", parseObject.getString("remove_shelves")));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements a.n {
        public d() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.h8) {
                SellerAddGoodsActivity.b2(SellerManageGoodsActivity.this.b, null);
            } else if (i == m93.i8) {
                GoodsAddOutSideActivity.L1(SellerManageGoodsActivity.this.b, null);
            } else if (i == m93.z8) {
                SellerAddPlatActivity.A1(SellerManageGoodsActivity.this.b);
            }
        }
    }

    public static void Q1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SellerManageGoodsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1(int i) {
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
                        k0Var = new um3(this.b, frameLayout);
                    } else if (i == 1) {
                        wl3 wl3Var = new wl3(this.b, frameLayout);
                        this.q = wl3Var;
                        k0Var = wl3Var;
                    } else if (i == 2) {
                        k0Var = new pm3(this.b, frameLayout);
                    } else {
                        k0Var = k0Var2;
                        if (i == 3) {
                            k0Var = new sm3(this.b, frameLayout);
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

    public void R1() {
        ec2.O(new c());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.N;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.N5));
        this.i = aq4.a(m93.b6);
        this.j = aq4.a(m93.c6);
        this.k = aq4.a(m93.d6);
        this.l = aq4.a(m93.B8);
        this.e = new ArrayList();
        for (int i = 0; i < 4; i++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        ViewPager findViewById = findViewById(d73.v4);
        this.h = findViewById;
        findViewById.setOffscreenPageLimit(3);
        this.h.setAdapter(new dk4(this.e));
        this.h.c(new a());
        this.g = new k0[4];
        this.f = (MagicIndicator) findViewById(d73.E2);
        String[] strArr = {this.i, this.l, this.j, this.k};
        CommonNavigator commonNavigator = new CommonNavigator(this.b);
        commonNavigator.setAdapter(new b(strArr));
        if (rx1.h()) {
            commonNavigator.setAdjustMode(true);
        }
        this.f.setNavigator(commonNavigator);
        ek4.a(this.f, this.h);
        findViewById(d73.s).setOnClickListener(this);
        zu0.c().n(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.z8), Integer.valueOf(m93.h8), Integer.valueOf(m93.i8)}, new d());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        ec2.u("getGoodsNum");
        ec2.u("getManageGoodsList");
        ec2.u("goodsUpStatus");
        ec2.u("goodsDelete");
        ec2.u("getManagePlatGoods");
        ec2.u("setPlatGoods");
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        R1();
        ViewPager viewPager = this.h;
        if (viewPager != null) {
            S1(viewPager.getCurrentItem());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onSetPlatGoodsEvent(ao3 ao3Var) {
        R1();
        wl3 wl3Var = this.q;
        if (wl3Var != null) {
            wl3Var.loadData();
        }
    }
}
