package defpackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class kb2 extends y0 {
    public List a;
    public jb2[] b;
    public MagicIndicator c;
    public ViewPager d;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            kb2.this.g0(i);
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
                if (kb2.this.d != null) {
                    kb2.this.d.setCurrentItem(this.a);
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
            linePagerIndicator.setXOffset(zn0.a(13));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(kb2.this.mContext, p53.n)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(-855638017);
            colorTransitionPagerTitleView.setSelectedColor(o60.b(kb2.this.mContext, p53.n));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(18.0f);
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

    public kb2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(int i) {
        List list;
        jb2[] jb2VarArr = this.b;
        if (jb2VarArr == null) {
            return;
        }
        jb2 jb2Var = jb2VarArr[i];
        if (jb2Var == null && (list = this.a) != null && i < list.size()) {
            FrameLayout frameLayout = (FrameLayout) this.a.get(i);
            if (frameLayout == null) {
                return;
            }
            if (i == 0) {
                jb2Var = new jb2(this.mContext, frameLayout, 1);
            } else if (i == 1) {
                jb2Var = new jb2(this.mContext, frameLayout, 0);
            }
            if (jb2Var == null) {
                return;
            }
            this.b[i] = jb2Var;
            jb2Var.addToParent();
            jb2Var.subscribeActivityLifeCycle();
        }
        if (jb2Var != null) {
            jb2Var.loadData();
        }
    }

    public void f0(int i) {
        ViewPager viewPager = this.d;
        if (viewPager != null) {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem == i) {
                g0(currentItem);
            } else {
                this.d.setCurrentItem(i);
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.n1;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = new ArrayList();
        for (int i = 0; i < 2; i++) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.a.add(frameLayout);
        }
        this.b = new jb2[2];
        ViewPager findViewById = findViewById(c73.y5);
        this.d = findViewById;
        findViewById.setOffscreenPageLimit(1);
        this.d.setAdapter(new dk4(this.a));
        this.d.c(new a());
        this.c = (MagicIndicator) findViewById(c73.V2);
        String[] strArr = {aq4.a(m93.l5), aq4.a(m93.j5)};
        CommonNavigator commonNavigator = new CommonNavigator(this.mContext);
        commonNavigator.setAdapter(new b(strArr));
        this.c.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer();
        titleContainer.setShowDividers(2);
        titleContainer.setDividerDrawable(new c());
        ek4.a(this.c, this.d);
        zu0.c().n(this);
    }

    @Override // defpackage.y0
    public void loadData() {
        ViewPager viewPager = this.d;
        if (viewPager != null) {
            g0(viewPager.getCurrentItem());
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        zu0.c().p(this);
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        jb2[] jb2VarArr = this.b;
        if (jb2VarArr != null) {
            for (jb2 jb2Var : jb2VarArr) {
                if (jb2Var != null) {
                    jb2Var.l0(q41Var.b(), q41Var.a());
                }
            }
        }
    }
}
