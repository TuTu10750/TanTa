package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public abstract class w0 extends y0 {
    public AppBarLayout a;
    public ViewPager b;
    public MagicIndicator c;
    public TextView d;
    public v0[] e;
    public qa2 f;
    public boolean g;
    public List h;
    public int i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends z8 {
        public a() {
        }

        @Override // defpackage.z8
        public void b(AppBarLayout appBarLayout, int i) {
            if (i == 1) {
                w0.a0(w0.this);
            } else if (i == 2 || i == 3) {
                w0.a0(w0.this);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements AppBarLayout.g {
        public b() {
        }

        public void a(AppBarLayout appBarLayout, int i) {
            w0.this.j0(-i);
            if (w0.this.f != null) {
                int i2 = w0.this.i;
                w0 w0Var = w0.this;
                if (i > i2) {
                    w0Var.f.M(false);
                } else if (i < w0Var.i) {
                    w0.this.f.M(true);
                }
                w0.this.i = i;
            }
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
            w0.this.i0(i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends n30 {
        public final /* synthetic */ String[] b;

        public d(String[] strArr) {
            this.b = strArr;
        }

        @Override // defpackage.n30
        public int a() {
            return this.b.length;
        }

        @Override // defpackage.n30
        public zh1 b(Context context) {
            return w0.this.g0(context);
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            return w0.this.f0(context, this.b, i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager;
            if (j30.q().L() || (viewPager = w0.this.b) == null) {
                return;
            }
            viewPager.setCurrentItem(this.a);
        }
    }

    public w0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public static /* synthetic */ pa2 a0(w0 w0Var) {
        w0Var.getClass();
        return null;
    }

    public bi1 f0(Context context, String[] strArr, int i) {
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        colorTransitionPagerTitleView.setPadding(zn0.a(7), 0, zn0.a(7), 0);
        colorTransitionPagerTitleView.setNormalColor(o60.b(this.mContext, p53.h));
        colorTransitionPagerTitleView.setSelectedColor(o60.b(this.mContext, p53.l));
        colorTransitionPagerTitleView.setText(strArr[i]);
        colorTransitionPagerTitleView.setTextSize(18.0f);
        colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
        colorTransitionPagerTitleView.setOnClickListener(new e(i));
        return colorTransitionPagerTitleView;
    }

    public zh1 g0(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(1);
        linePagerIndicator.setXOffset(zn0.a(5));
        linePagerIndicator.setRoundRadius(zn0.a(2));
        linePagerIndicator.setColors(Integer.valueOf(o60.b(this.mContext, p53.g)));
        return linePagerIndicator;
    }

    public abstract String[] h0();

    public abstract void i0(int i);

    @Override // defpackage.b1
    public void init() {
        AppBarLayout findViewById = findViewById(c73.h);
        this.a = findViewById;
        findViewById.e(new a());
        this.a.e(new b());
        this.h = new ArrayList();
        int length = j30.q().u().length;
        for (int i = 0; i < length; i++) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.h.add(frameLayout);
        }
        this.e = new v0[length];
        ViewPager findViewById2 = findViewById(c73.y5);
        this.b = findViewById2;
        if (length > 1) {
            findViewById2.setOffscreenPageLimit(length - 1);
        }
        this.b.setAdapter(new dk4(this.h));
        this.b.c(new c());
        this.c = (MagicIndicator) findViewById(c73.V2);
        String[] h0 = h0();
        CommonNavigator commonNavigator = new CommonNavigator(this.mContext);
        commonNavigator.setAdapter(new d(h0));
        this.c.setNavigator(commonNavigator);
        ek4.a(this.c, this.b);
        TextView textView = (TextView) findViewById(c73.p4);
        this.d = textView;
        if (textView != null) {
            ik1 h = ck1.e().h();
            l0(h != null ? h.h() : "0");
        }
    }

    public void j0(float f) {
    }

    public void k0(qa2 qa2Var) {
        this.f = qa2Var;
    }

    public void l0(String str) {
        if (this.d != null) {
            boolean equals = "0".equals(str);
            TextView textView = this.d;
            if (equals) {
                if (textView.getVisibility() == 0) {
                    this.d.setVisibility(4);
                }
            } else {
                if (textView.getVisibility() != 0) {
                    this.d.setVisibility(0);
                }
                this.d.setText(str);
            }
        }
    }

    @Override // defpackage.y0
    public void loadData() {
        ViewPager viewPager = this.b;
        if (viewPager != null) {
            i0(viewPager.getCurrentItem());
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        this.f = null;
        super.onDestroy();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        this.g = true;
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        if (isShowed() && this.g) {
            loadData();
        }
        this.g = false;
    }
}
