package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.LiveClassBean;
import com.yunbao.common.custom.MyViewPager;
import com.yunbao.main.activity.MainActivity;
import com.yunbao.main.custom.MainHomePageTitleView;
import com.yunbao.main.views.CurvedLinePagerIndicator;
import com.yunbao.main.views.MainHomeLiveViewHolder;
import com.yunbao.main.views.MainLiveFollowViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class cb2 extends w0 {
    public MainHomeLiveViewHolder j;
    public bb2 k;
    public MainLiveFollowViewHolder l;
    public int m;
    public View n;
    public View o;
    public int p;
    public ImageView q;
    public ImageView r;
    public MyViewPager s;
    public List t;
    public CurvedLinePagerIndicator u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public List z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cb2 cb2Var = cb2.this;
            cb2Var.p = cb2Var.a.getHeight() - cb2.this.m;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager;
            if (j30.q().L() || (viewPager = cb2.this.b) == null) {
                return;
            }
            viewPager.setCurrentItem(this.a);
        }
    }

    public cb2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.w = true;
        this.x = true;
        this.z = j30.q().t();
    }

    @Override // defpackage.w0
    public bi1 f0(Context context, String[] strArr, int i) {
        MainHomePageTitleView mainHomePageTitleView = new MainHomePageTitleView(context);
        mainHomePageTitleView.setPadding(zn0.a(8), 0, zn0.a(8), 0);
        mainHomePageTitleView.setNormalColor(o60.b(this.mContext, p53.h));
        mainHomePageTitleView.setSelectedColor(o60.b(this.mContext, p53.d));
        mainHomePageTitleView.setNormalTextSize(14);
        mainHomePageTitleView.setSelectedTextSize(16);
        mainHomePageTitleView.setText(strArr[i]);
        mainHomePageTitleView.setTextSize(18.0f);
        mainHomePageTitleView.getPaint().setFakeBoldText(true);
        mainHomePageTitleView.setOnClickListener(new b(i));
        this.t.add(mainHomePageTitleView);
        return mainHomePageTitleView;
    }

    @Override // defpackage.w0
    public zh1 g0(Context context) {
        CurvedLinePagerIndicator curvedLinePagerIndicator = new CurvedLinePagerIndicator(context);
        curvedLinePagerIndicator.setMode(1);
        curvedLinePagerIndicator.setXOffset(zn0.a(5));
        curvedLinePagerIndicator.setCurveHeight(zn0.a(2));
        curvedLinePagerIndicator.setColors(this.v);
        curvedLinePagerIndicator.setLineWidth(20.0f);
        curvedLinePagerIndicator.setLineScale(0.3f);
        this.u = curvedLinePagerIndicator;
        return curvedLinePagerIndicator;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.j1;
    }

    @Override // defpackage.w0
    public String[] h0() {
        return j30.q().u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.w0
    public void i0(int i) {
        List list;
        MainHomeLiveViewHolder mainHomeLiveViewHolder;
        int i2 = 0;
        while (true) {
            if (i2 >= this.t.size()) {
                break;
            }
            MainHomePageTitleView mainHomePageTitleView = (MainHomePageTitleView) this.t.get(i2);
            if (i2 != i) {
                r3 = false;
            }
            mainHomePageTitleView.b(r3);
            i2++;
        }
        ((MainActivity) this.mContext).d1(i == 10);
        View view = this.n;
        if (view != null) {
            view.setMinimumHeight(i == 0 ? 0 : this.m);
        }
        v0[] v0VarArr = this.e;
        if (v0VarArr == null) {
            return;
        }
        v0 v0Var = v0VarArr[i];
        if (v0Var == null && (list = this.h) != null && i < list.size()) {
            FrameLayout frameLayout = (FrameLayout) this.h.get(i);
            if (frameLayout == null) {
                return;
            }
            if (i == 0) {
                MainLiveFollowViewHolder mainLiveFollowViewHolder = new MainLiveFollowViewHolder(this.mContext, frameLayout);
                this.l = mainLiveFollowViewHolder;
                mainHomeLiveViewHolder = mainLiveFollowViewHolder;
            } else {
                if (this.z == null) {
                    this.z = j30.q().t();
                }
                MainHomeLiveViewHolder mainHomeLiveViewHolder2 = new MainHomeLiveViewHolder(this.mContext, frameLayout, ((LiveClassBean) this.z.get(i - 1)).getId());
                this.j = mainHomeLiveViewHolder2;
                mainHomeLiveViewHolder = mainHomeLiveViewHolder2;
            }
            v0Var = mainHomeLiveViewHolder;
            this.e[i] = v0Var;
            v0Var.addToParent();
            v0Var.subscribeActivityLifeCycle();
        }
        v0[] v0VarArr2 = this.e;
        if (v0VarArr2 != null) {
            int length = v0VarArr2.length;
            for (int i3 = 0; i3 < length; i3++) {
                v0 v0Var2 = this.e[i3];
            }
        }
        if (v0Var != null) {
            v0Var.loadData();
        }
    }

    @Override // defpackage.w0, defpackage.b1
    public void init() {
        this.v = o60.b(this.mContext, p53.d);
        this.t = new ArrayList();
        setStatusHeight();
        super.init();
        this.m = gk3.a().d();
        this.n = findViewById(c73.i);
        this.o = findViewById(c73.L1);
        this.a.post(new a());
        this.q = (ImageView) findViewById(c73.W0);
        this.r = (ImageView) findViewById(c73.c1);
        p0();
        this.s = (MyViewPager) this.b;
        if (j30.q().L()) {
            this.s.setCanScroll(false);
        }
        this.b.setCurrentItem(1);
    }

    @Override // defpackage.w0
    public void j0(float f) {
        View view;
        int i = this.p;
        if (i == 0 || (view = this.o) == null) {
            return;
        }
        view.setAlpha(f / i);
    }

    @Override // defpackage.w0, defpackage.y0
    public void loadData() {
        if (this.y) {
            super.loadData();
            return;
        }
        ViewPager viewPager = this.b;
        if (viewPager != null) {
            int currentItem = viewPager.getCurrentItem();
            if (currentItem != 1) {
                this.b.M(1, false);
            } else {
                i0(currentItem);
            }
        }
    }

    public void o0() {
        ViewPager viewPager = this.b;
        if (viewPager == null || viewPager.getCurrentItem() == 1) {
            return;
        }
        this.b.M(1, false);
    }

    @Override // defpackage.w0, defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        if (isShowed()) {
            this.y = true;
            bb2 bb2Var = this.k;
            if (bb2Var == null || !bb2Var.isShowed()) {
                return;
            }
            this.k.n0();
            zh4.c();
        }
    }

    @Override // defpackage.w0, defpackage.b1, defpackage.uy1
    public void onResume() {
        bb2 bb2Var;
        super.onResume();
        if (isShowed()) {
            if (this.y && (bb2Var = this.k) != null && bb2Var.isShowed()) {
                this.k.p0();
                zh4.p();
            }
            this.y = false;
        }
    }

    public final void p0() {
        ConfigBean h = j30.q().h();
        if (h != null) {
            if (h.getLeaderboard_switch() != 1) {
                ImageView imageView = this.r;
                if (imageView == null || imageView.getVisibility() == 8) {
                    return;
                }
                this.r.setVisibility(8);
                return;
            }
            boolean Q = j30.q().Q();
            ImageView imageView2 = this.r;
            if (Q) {
                if (imageView2 == null || imageView2.getVisibility() == 8) {
                    return;
                }
                this.r.setVisibility(8);
                return;
            }
            if (imageView2 == null || imageView2.getVisibility() == 0) {
                return;
            }
            this.r.setVisibility(0);
        }
    }

    public void q0(boolean z) {
        MyViewPager myViewPager = this.s;
        if (myViewPager != null) {
            myViewPager.setCanScroll(z);
        }
    }

    @Override // defpackage.y0
    public void setShowed(boolean z) {
        super.setShowed(z);
        v0[] v0VarArr = this.e;
        if (v0VarArr != null) {
            int length = v0VarArr.length;
            int i = 0;
            while (i < length) {
                v0 v0Var = this.e[i];
                if (v0Var != null) {
                    v0Var.setShowed(i == 0);
                }
                i++;
            }
        }
    }
}
