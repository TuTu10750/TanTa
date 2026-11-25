package com.zhpan.bannerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.h;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.IndicatorView;
import defpackage.c83;
import defpackage.gg;
import defpackage.h73;
import defpackage.hg;
import defpackage.io1;
import defpackage.jg;
import defpackage.mh1;
import defpackage.rg;
import defpackage.yd3;
import defpackage.z60;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class BannerViewPager<T> extends RelativeLayout implements cz1 {
    public int a;
    public boolean b;
    public boolean c;
    public mh1 d;
    public RelativeLayout e;
    public ViewPager2 f;
    public gg g;
    public final Handler h;
    public rg i;
    public ViewPager2.i j;
    public final Runnable k;
    public RectF l;
    public Path m;
    public int n;
    public int o;
    public Lifecycle p;
    public final ViewPager2.i q;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ViewPager2.i {
        public a() {
        }

        public void a(int i) {
            super.a(i);
            BannerViewPager.this.y(i);
        }

        public void b(int i, float f, int i2) {
            super.b(i, f, i2);
            BannerViewPager.this.z(i, f, i2);
        }

        public void c(int i) {
            super.c(i);
            BannerViewPager.this.A(i);
        }
    }

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new Handler(Looper.getMainLooper());
        this.k = new Runnable() { // from class: mg
            @Override // java.lang.Runnable
            public final void run() {
                BannerViewPager.this.j();
            }
        };
        this.q = new a();
        k(context, attributeSet);
    }

    public static /* synthetic */ void a(BannerViewPager bannerViewPager, List list) {
        if (!bannerViewPager.isAttachedToWindow() || list == null || bannerViewPager.i == null) {
            return;
        }
        bannerViewPager.S();
        bannerViewPager.i.V(list);
        bannerViewPager.i.p();
        bannerViewPager.E(bannerViewPager.getCurrentItem());
        bannerViewPager.C(list);
        bannerViewPager.R();
    }

    private int getInterval() {
        return this.g.b().e();
    }

    private void setIndicatorValues(List<? extends T> list) {
        hg b = this.g.b();
        this.e.setVisibility(b.d());
        b.u();
        if (this.b) {
            this.e.removeAllViews();
        } else if (this.d == null) {
            this.d = new IndicatorView(getContext());
        }
        m(b.c(), list);
    }

    private void setupViewPager(List<T> list) {
        if (this.i == null) {
            z60.a("You must set adapter for BannerViewPager");
            return;
        }
        hg b = this.g.b();
        if (b.o() != 0) {
            yd3.a(this.f, b.o());
        }
        this.a = 0;
        this.i.U(b.r());
        this.f.setAdapter(this.i);
        if (u()) {
            this.f.j(jg.b(list.size()), false);
        }
        this.f.n(this.q);
        this.f.g(this.q);
        this.f.setOrientation(b.h());
        this.f.setOffscreenPageLimit(b.g());
        q(b);
        p(b.k());
        R();
    }

    public final void A(int i) {
        int Q = this.i.Q();
        boolean r = this.g.b().r();
        int c = jg.c(i, Q);
        this.a = c;
        if (Q > 0 && r && (i == 0 || i == 999)) {
            E(c);
        }
        ViewPager2.i iVar = this.j;
        if (iVar != null) {
            iVar.c(this.a);
        }
        mh1 mh1Var = this.d;
        if (mh1Var != null) {
            mh1Var.c(this.a);
        }
    }

    public void B(final List list) {
        post(new Runnable() { // from class: lg
            @Override // java.lang.Runnable
            public final void run() {
                BannerViewPager.a(BannerViewPager.this, list);
            }
        });
    }

    public final void C(List list) {
        setIndicatorValues(list);
        this.g.b().c().q(jg.c(this.f.getCurrentItem(), list.size()));
        this.d.d();
    }

    public BannerViewPager D(ViewPager2.i iVar) {
        this.j = iVar;
        return this;
    }

    public final void E(int i) {
        boolean u = u();
        ViewPager2 viewPager2 = this.f;
        if (u) {
            viewPager2.j(jg.b(this.i.Q()) + i, false);
        } else {
            viewPager2.j(i, false);
        }
    }

    public BannerViewPager F(rg rgVar) {
        this.i = rgVar;
        return this;
    }

    public BannerViewPager G(boolean z) {
        this.g.b().v(z);
        if (t()) {
            this.g.b().w(true);
        }
        return this;
    }

    public void H(int i, boolean z) {
        if (!u()) {
            this.f.j(i, z);
            return;
        }
        S();
        int currentItem = this.f.getCurrentItem();
        this.f.j(currentItem + (i - jg.c(currentItem, this.i.Q())), z);
        R();
    }

    public BannerViewPager I(int i) {
        this.g.b().A(i);
        return this;
    }

    public BannerViewPager J(int i, int i2) {
        this.g.b().B(i, i2);
        return this;
    }

    public BannerViewPager K(int i, int i2) {
        this.g.b().C(i * 2, i2 * 2);
        return this;
    }

    public BannerViewPager L(mh1 mh1Var) {
        if (mh1Var instanceof View) {
            this.b = true;
            this.d = mh1Var;
        }
        return this;
    }

    public BannerViewPager M(int i) {
        this.g.b().E(i);
        return this;
    }

    public BannerViewPager N(int i) {
        return O(i, 0.85f);
    }

    public BannerViewPager O(int i, float f) {
        this.g.b().J(i);
        this.g.b().I(f);
        return this;
    }

    public BannerViewPager P(int i) {
        Q(i, i);
        return this;
    }

    public BannerViewPager Q(int i, int i2) {
        this.g.b().K(i2);
        this.g.b().G(i);
        return this;
    }

    public void R() {
        rg rgVar;
        if (this.c || !t() || (rgVar = this.i) == null || rgVar.Q() <= 1 || !isAttachedToWindow()) {
            return;
        }
        Lifecycle lifecycle = this.p;
        if (lifecycle == null || lifecycle.b() == Lifecycle.State.e || this.p.b() == Lifecycle.State.c) {
            this.h.postDelayed(this.k, getInterval());
            this.c = true;
        }
    }

    public void S() {
        if (this.c) {
            this.h.removeCallbacks(this.k);
            this.c = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float[] n = this.g.b().n();
        RectF rectF = this.l;
        if (rectF != null && this.m != null && n != null) {
            rectF.right = getWidth();
            this.l.bottom = getHeight();
            this.m.addRoundRect(this.l, n, Path.Direction.CW);
            canvas.clipPath(this.m);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = true;
            S();
        } else if (action == 1 || action == 3 || action == 4) {
            this.c = false;
            R();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g() {
        i(new ArrayList());
    }

    public rg getAdapter() {
        return this.i;
    }

    public int getCurrentItem() {
        return this.a;
    }

    public List<T> getData() {
        rg rgVar = this.i;
        return rgVar != null ? rgVar.O() : Collections.EMPTY_LIST;
    }

    public void i(List list) {
        rg rgVar = this.i;
        if (rgVar == null) {
            z60.a("You must set adapter for BannerViewPager");
        } else {
            rgVar.V(list);
            l();
        }
    }

    public final void j() {
        rg rgVar = this.i;
        if (rgVar == null || rgVar.Q() <= 1 || !t()) {
            return;
        }
        ViewPager2 viewPager2 = this.f;
        viewPager2.j(viewPager2.getCurrentItem() + 1, this.g.b().q());
        this.h.postDelayed(this.k, getInterval());
    }

    public final void k(Context context, AttributeSet attributeSet) {
        gg ggVar = new gg();
        this.g = ggVar;
        ggVar.d(context, attributeSet);
        s();
    }

    public final void l() {
        List O = this.i.O();
        if (O != null) {
            setIndicatorValues(O);
            setupViewPager(O);
            r();
        }
    }

    public final void m(io1 io1Var, List list) {
        if (((View) this.d).getParent() == null) {
            this.e.removeAllViews();
            this.e.addView((View) this.d);
            o();
            n();
        }
        this.d.setIndicatorOptions(io1Var);
        io1Var.v(list.size());
        this.d.d();
    }

    public final void n() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((View) this.d).getLayoutParams();
        int a2 = this.g.b().a();
        if (a2 == 0) {
            layoutParams.addRule(14);
        } else if (a2 == 2) {
            layoutParams.addRule(9);
        } else {
            if (a2 != 4) {
                return;
            }
            layoutParams.addRule(11);
        }
    }

    public final void o() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((View) this.d).getLayoutParams();
        this.g.b().b();
        int a2 = jg.a(10.0f);
        marginLayoutParams.setMargins(a2, a2, a2, a2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g == null || !v()) {
            return;
        }
        R();
    }

    @h(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        S();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (this.g != null && v()) {
            S();
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r0 != 3) goto L24;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.viewpager2.widget.ViewPager2 r0 = r6.f
            boolean r0 = r0.e()
            if (r0 == 0) goto L85
            rg r0 = r6.i
            r1 = 1
            if (r0 == 0) goto L18
            java.util.List r0 = r0.O()
            int r0 = r0.size()
            if (r0 > r1) goto L18
            goto L85
        L18:
            int r0 = r7.getAction()
            if (r0 == 0) goto L60
            if (r0 == r1) goto L57
            r2 = 2
            if (r0 == r2) goto L27
            r1 = 3
            if (r0 == r1) goto L57
            goto L80
        L27:
            float r0 = r7.getX()
            int r0 = (int) r0
            float r2 = r7.getY()
            int r2 = (int) r2
            int r3 = r6.n
            int r3 = r0 - r3
            int r3 = java.lang.Math.abs(r3)
            int r4 = r6.o
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            gg r5 = r6.g
            hg r5 = r5.b()
            int r5 = r5.h()
            if (r5 != r1) goto L51
            r6.x(r2, r3, r4)
            goto L80
        L51:
            if (r5 != 0) goto L80
            r6.w(r0, r3, r4)
            goto L80
        L57:
            android.view.ViewParent r0 = r6.getParent()
            r1 = 0
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L80
        L60:
            float r0 = r7.getX()
            int r0 = (int) r0
            r6.n = r0
            float r0 = r7.getY()
            int r0 = (int) r0
            r6.o = r0
            android.view.ViewParent r0 = r6.getParent()
            gg r2 = r6.g
            hg r2 = r2.b()
            boolean r2 = r2.s()
            r1 = r1 ^ r2
            r0.requestDisallowInterceptTouchEvent(r1)
        L80:
            boolean r6 = super.onInterceptTouchEvent(r7)
            return r6
        L85:
            boolean r6 = super.onInterceptTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhpan.bannerview.BannerViewPager.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @h(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        S();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER_STATE"));
        this.a = bundle.getInt("CURRENT_POSITION");
        this.b = bundle.getBoolean("IS_CUSTOM_INDICATOR");
        H(this.a, false);
    }

    @h(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        R();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE", onSaveInstanceState);
        bundle.putInt("CURRENT_POSITION", this.a);
        bundle.putBoolean("IS_CUSTOM_INDICATOR", this.b);
        return bundle;
    }

    public final void p(int i) {
        float j = this.g.b().j();
        if (i == 4) {
            this.g.g(true, j);
        } else if (i == 8) {
            this.g.g(false, j);
        }
    }

    public final void q(hg hgVar) {
        int l = hgVar.l();
        int f = hgVar.f();
        if (f != -1000 || l != -1000) {
            RecyclerView childAt = this.f.getChildAt(0);
            int h = hgVar.h();
            int i = hgVar.i() + l;
            int i2 = hgVar.i() + f;
            if (i2 < 0) {
                i2 = 0;
            }
            if (i < 0) {
                i = 0;
            }
            if (h == 0) {
                childAt.setPadding(i2, 0, i, 0);
            } else if (h == 1) {
                childAt.setPadding(0, i2, 0, i);
            }
            childAt.setClipToPadding(false);
        }
        this.g.a();
    }

    public final void r() {
        int m = this.g.b().m();
        if (m > 0) {
            pk4.a(this, m);
        }
    }

    public final void s() {
        View.inflate(getContext(), c83.a, this);
        this.f = findViewById(h73.b);
        this.e = (RelativeLayout) findViewById(h73.a);
        this.f.setPageTransformer(this.g.c());
    }

    public void setCurrentItem(int i) {
        H(i, true);
    }

    public final boolean t() {
        return this.g.b().p();
    }

    public final boolean u() {
        rg rgVar;
        gg ggVar = this.g;
        return (ggVar == null || ggVar.b() == null || !this.g.b().r() || (rgVar = this.i) == null || rgVar.Q() <= 1) ? false : true;
    }

    public final boolean v() {
        return this.g.b().t();
    }

    public final void w(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i3 > i2) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (this.g.b().r()) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (this.a != 0 || i - this.n <= 0) {
            getParent().requestDisallowInterceptTouchEvent(this.a != getData().size() - 1 || i - this.n >= 0);
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    public final void x(int i, int i2, int i3) {
        if (i3 <= i2) {
            if (i2 > i3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (this.g.b().r()) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (this.a != 0 || i - this.o <= 0) {
            getParent().requestDisallowInterceptTouchEvent(this.a != getData().size() - 1 || i - this.o >= 0);
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    public final void y(int i) {
        mh1 mh1Var = this.d;
        if (mh1Var != null) {
            mh1Var.b(i);
        }
        ViewPager2.i iVar = this.j;
        if (iVar != null) {
            iVar.a(i);
        }
    }

    public final void z(int i, float f, int i2) {
        int Q = this.i.Q();
        this.g.b().r();
        int c = jg.c(i, Q);
        if (Q > 0) {
            ViewPager2.i iVar = this.j;
            if (iVar != null) {
                iVar.b(c, f, i2);
            }
            mh1 mh1Var = this.d;
            if (mh1Var != null) {
                mh1Var.a(c, f, i2);
            }
        }
    }
}
