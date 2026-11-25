package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.main.activity.RegisterNewActivity;
import com.yunbao.main.custom.MainHomePageTitleView;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

/* loaded from: /tmp/classes2.dex */
public class d82 extends v0 implements View.OnClickListener {
    public LinearLayout a;
    public LinearLayout b;
    public TextView c;
    public TextView d;
    public MagicIndicator e;
    public ViewPager f;
    public int g;
    public List h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            d82.this.g = i;
            d82.this.e.a(2);
            d82.this.e.c(i);
            d82.this.e.b(i, 0.0f, 0);
            d82.this.e.a(0);
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
                int i = d82.this.g;
                int i2 = this.a;
                if (i == i2) {
                    return;
                }
                d82.this.g = i2;
                d82.this.e.a(2);
                d82.this.e.c(this.a);
                d82.this.e.b(this.a, 0.0f, 0);
                d82.this.e.a(0);
                d82.this.f.setCurrentItem(this.a);
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
            linePagerIndicator.setXOffset(zn0.a(2));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(d82.this.mContext, p53.g)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            MainHomePageTitleView mainHomePageTitleView = new MainHomePageTitleView(context);
            mainHomePageTitleView.setPadding(zn0.a(8), 0, zn0.a(8), 0);
            mainHomePageTitleView.setNormalColor(o60.b(d82.this.mContext, p53.h));
            mainHomePageTitleView.setSelectedColor(o60.b(d82.this.mContext, p53.d));
            mainHomePageTitleView.setNormalTextSize(14);
            mainHomePageTitleView.setSelectedTextSize(16);
            mainHomePageTitleView.setText(this.b[i]);
            mainHomePageTitleView.setTextSize(18.0f);
            mainHomePageTitleView.getPaint().setFakeBoldText(true);
            mainHomePageTitleView.setOnClickListener(new a(i));
            return mainHomePageTitleView;
        }
    }

    public d82(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.c1;
    }

    @Override // defpackage.b1
    public void init() {
        this.f = findViewById(c73.z5);
        this.e = (MagicIndicator) findViewById(c73.V2);
        this.a = (LinearLayout) findViewById(c73.t2);
        this.b = (LinearLayout) findViewById(c73.C3);
        this.c = (TextView) findViewById(c73.M4);
        this.d = (TextView) findViewById(c73.N4);
        findViewById(c73.Y4).setOnClickListener(this);
        j30.q().D();
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        g82 g82Var = new g82(this.mContext, frameLayout);
        arrayList.add(frameLayout);
        g82Var.addToParent();
        g82Var.subscribeActivityLifeCycle();
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        k82 k82Var = new k82(this.mContext, frameLayout2);
        arrayList.add(frameLayout2);
        k82Var.addToParent();
        k82Var.subscribeActivityLifeCycle();
        FrameLayout frameLayout3 = new FrameLayout(this.mContext);
        l82 l82Var = new l82(this.mContext, frameLayout3);
        arrayList.add(frameLayout3);
        l82Var.addToParent();
        l82Var.subscribeActivityLifeCycle();
        ArrayList arrayList2 = new ArrayList();
        this.h = arrayList2;
        arrayList2.add(g82Var);
        this.h.add(k82Var);
        this.h.add(l82Var);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        frameLayout3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f.setAdapter(new dk4(arrayList));
        this.f.c(new a());
        this.e = (MagicIndicator) findViewById(d73.E2);
        CommonNavigator commonNavigator = new CommonNavigator(this.mContext);
        commonNavigator.setAdapter(new b(new String[]{"账号+密码", "手机+密码", "手机+验证码"}));
        commonNavigator.setAdjustMode(true);
        this.e.setNavigator(commonNavigator);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.Y4) {
            this.mContext.startActivity(new Intent(this.mContext, (Class<?>) RegisterNewActivity.class));
            this.mContext.finish();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
    }
}
