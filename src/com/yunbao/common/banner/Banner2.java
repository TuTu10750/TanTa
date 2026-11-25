package com.yunbao.common.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.yunbao.common.banner.util.ScrollSpeedManger;
import defpackage.da3;
import defpackage.dg;
import defpackage.eg;
import defpackage.fg;
import defpackage.go1;
import defpackage.ho1;
import defpackage.jt2;
import defpackage.kg;
import defpackage.z60;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class Banner2<T, BA extends dg> extends FrameLayout implements fg {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public float G;
    public float H;
    public boolean I;
    public boolean J;
    public Paint K;
    public Paint L;
    public final RecyclerView.i M;
    public ViewPager2 a;
    public b b;
    public jt2 c;
    public dg d;
    public go1 e;
    public androidx.viewpager2.widget.b f;
    public c g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public int l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.i {
        public a() {
        }

        public void a() {
            int itemCount = Banner2.this.getItemCount();
            Banner2 banner2 = Banner2.this;
            if (itemCount <= 1) {
                banner2.E();
            } else {
                banner2.C();
            }
            Banner2.this.u();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b implements Runnable {
        public final WeakReference a;

        public b(Banner2 banner2) {
            this.a = new WeakReference(banner2);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner2 banner2 = (Banner2) this.a.get();
            if (banner2 == null || !banner2.i || (itemCount = banner2.getItemCount()) == 0) {
                return;
            }
            if (banner2.q()) {
                banner2.s((banner2.getCurrentItem() + 1) % itemCount);
                banner2.postDelayed(banner2.b, banner2.j);
                return;
            }
            int currentItem = banner2.getCurrentItem() + 1;
            if (currentItem < itemCount) {
                banner2.s(currentItem);
                if (currentItem < itemCount - 1) {
                    banner2.postDelayed(banner2.b, banner2.j);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends ViewPager2.i {
        public int a = -1;
        public boolean b;

        public c() {
        }

        public void a(int i) {
            if (i == 1 || i == 2) {
                this.b = true;
            } else if (i == 0) {
                this.b = false;
                if (this.a != -1 && Banner2.this.h) {
                    int i2 = this.a;
                    Banner2 banner2 = Banner2.this;
                    if (i2 == 0) {
                        banner2.t(banner2.getRealCount(), false);
                    } else if (i2 == banner2.getItemCount() - 1) {
                        Banner2.this.t(1, false);
                    }
                }
            }
            if (Banner2.this.c != null) {
                Banner2.this.c.b(i);
            }
            if (Banner2.this.getIndicator() != null) {
                Banner2.this.getIndicator().b(i);
            }
        }

        public void b(int i, float f, int i2) {
            int b = kg.b(Banner2.this.q(), i, Banner2.this.getRealCount());
            if (Banner2.this.c != null && b == Banner2.this.getCurrentItem() - 1) {
                Banner2.this.c.a(b, f, i2);
            }
            if (Banner2.this.getIndicator() == null || b != Banner2.this.getCurrentItem() - 1) {
                return;
            }
            Banner2.this.getIndicator().a(b, f, i2);
        }

        public void c(int i) {
            if (this.b) {
                this.a = i;
                int b = kg.b(Banner2.this.q(), i, Banner2.this.getRealCount());
                if (Banner2.this.c != null) {
                    Banner2.this.c.c(b);
                }
                if (Banner2.this.getIndicator() != null) {
                    Banner2.this.getIndicator().c(b);
                }
            }
        }
    }

    public Banner2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = true;
        this.i = true;
        this.j = 3000L;
        this.k = IjkMediaCodecInfo.RANK_LAST_CHANCE;
        this.l = 1;
        this.m = 0.0f;
        this.r = eg.a;
        this.s = eg.b;
        this.t = -1996488705;
        this.u = -2013265920;
        this.v = 1;
        this.C = eg.e;
        this.D = eg.f;
        this.E = 0;
        this.J = true;
        this.M = new a();
        m(context);
        o(context, attributeSet);
    }

    private void setRecyclerViewPadding(int i) {
        y(i, i);
    }

    public Banner2 A(int i) {
        this.l = i;
        return this;
    }

    public Banner2 B(boolean z) {
        getViewPager2().setUserInputEnabled(z);
        return this;
    }

    public Banner2 C() {
        if (this.i) {
            E();
            postDelayed(this.b, this.j);
        }
        return this;
    }

    public void D() {
        E();
        postDelayed(this.b, this.j);
    }

    public Banner2 E() {
        if (this.i) {
            removeCallbacks(this.b);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.m <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.L, 31);
        super.dispatchDraw(canvas);
        if (!this.o && !this.n && !this.q && !this.p) {
            k(canvas);
            l(canvas);
            i(canvas);
            j(canvas);
            canvas.restore();
            return;
        }
        if (this.n) {
            k(canvas);
        }
        if (this.o) {
            l(canvas);
        }
        if (this.p) {
            i(canvas);
        }
        if (this.q) {
            j(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().e()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            C();
        } else if (actionMasked == 0) {
            E();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g() {
        if (getViewPager2() != null && this.g != null) {
            getViewPager2().n(this.g);
            this.g = null;
        }
        E();
    }

    public dg getAdapter() {
        return this.d;
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public go1 getIndicator() {
        return this.e;
    }

    public ho1 getIndicatorConfig() {
        if (getIndicator() != null) {
            getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getItemCount() {
        if (getAdapter() != null) {
            return getAdapter().j();
        }
        return 0;
    }

    public int getRealCount() {
        if (getAdapter() != null) {
            return getAdapter().L();
        }
        return 0;
    }

    public int getScrollTime() {
        return this.k;
    }

    public int getStartPosition() {
        return this.l;
    }

    public ViewPager2 getViewPager2() {
        return this.a;
    }

    public final void i(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f = height;
        path.moveTo(0.0f, f - this.m);
        path.lineTo(0.0f, f);
        path.lineTo(this.m, f);
        float f2 = this.m;
        path.arcTo(new RectF(0.0f, f - (f2 * 2.0f), f2 * 2.0f, f), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.K);
    }

    public final void j(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f = width;
        float f2 = height;
        path.moveTo(f - this.m, f2);
        path.lineTo(f, f2);
        path.lineTo(f, f2 - this.m);
        float f3 = this.m;
        path.arcTo(new RectF(f - (f3 * 2.0f), f2 - (f3 * 2.0f), f, f2), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.K);
    }

    public final void k(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.m);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.m, 0.0f);
        float f = this.m;
        path.arcTo(new RectF(0.0f, 0.0f, f * 2.0f, f * 2.0f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.K);
    }

    public final void l(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f = width;
        path.moveTo(f - this.m, 0.0f);
        path.lineTo(f, 0.0f);
        path.lineTo(f, this.m);
        float f2 = this.m;
        path.arcTo(new RectF(f - (f2 * 2.0f), 0.0f, f, f2 * 2.0f), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.K);
    }

    public final void m(Context context) {
        this.F = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f = new androidx.viewpager2.widget.b();
        this.g = new c();
        this.b = new b(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.a = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setOffscreenPageLimit(2);
        this.a.g(this.g);
        this.a.setPageTransformer(this.f);
        ScrollSpeedManger.a3(this);
        addView(this.a);
        Paint paint = new Paint();
        this.K = paint;
        paint.setColor(-1);
        this.K.setAntiAlias(true);
        this.K.setStyle(Paint.Style.FILL);
        this.K.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.L = paint2;
        paint2.setXfermode(null);
    }

    public final void n() {
        if (getIndicator() == null || getAdapter() == null) {
            return;
        }
        getIndicator().getIndicatorConfig();
        throw null;
    }

    public final void o(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.w);
            this.m = obtainStyledAttributes.getDimensionPixelSize(da3.O, 0);
            this.j = obtainStyledAttributes.getInt(da3.M, 3000);
            this.i = obtainStyledAttributes.getBoolean(da3.x, true);
            this.h = obtainStyledAttributes.getBoolean(da3.L, true);
            this.r = obtainStyledAttributes.getDimensionPixelSize(da3.G, eg.a);
            this.s = obtainStyledAttributes.getDimensionPixelSize(da3.J, eg.b);
            this.t = obtainStyledAttributes.getColor(da3.F, -1996488705);
            this.u = obtainStyledAttributes.getColor(da3.I, -2013265920);
            this.v = obtainStyledAttributes.getInt(da3.y, 1);
            this.w = obtainStyledAttributes.getDimensionPixelSize(da3.K, 0);
            this.x = obtainStyledAttributes.getDimensionPixelSize(da3.A, 0);
            this.y = obtainStyledAttributes.getDimensionPixelSize(da3.C, 0);
            this.z = obtainStyledAttributes.getDimensionPixelSize(da3.E, 0);
            this.A = obtainStyledAttributes.getDimensionPixelSize(da3.D, 0);
            this.B = obtainStyledAttributes.getDimensionPixelSize(da3.B, 0);
            this.C = obtainStyledAttributes.getDimensionPixelSize(da3.z, eg.e);
            this.D = obtainStyledAttributes.getDimensionPixelSize(da3.H, eg.f);
            this.E = obtainStyledAttributes.getInt(da3.N, 0);
            this.n = obtainStyledAttributes.getBoolean(da3.R, false);
            this.o = obtainStyledAttributes.getBoolean(da3.S, false);
            this.p = obtainStyledAttributes.getBoolean(da3.P, false);
            this.q = obtainStyledAttributes.getBoolean(da3.Q, false);
            obtainStyledAttributes.recycle();
        }
        x(this.E);
        v();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C();
    }

    @Override // defpackage.fg
    public void onDestroy(dz1 dz1Var) {
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        E();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.viewpager2.widget.ViewPager2 r0 = r6.getViewPager2()
            boolean r0 = r0.e()
            if (r0 == 0) goto L88
            boolean r0 = r6.J
            if (r0 != 0) goto L10
            goto L88
        L10:
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == 0) goto L70
            r2 = 0
            if (r0 == r1) goto L68
            r3 = 2
            if (r0 == r3) goto L21
            r1 = 3
            if (r0 == r1) goto L68
            goto L83
        L21:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.G
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r6.H
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            androidx.viewpager2.widget.ViewPager2 r4 = r6.getViewPager2()
            int r4 = r4.getOrientation()
            int r5 = r6.F
            if (r4 != 0) goto L51
            float r4 = (float) r5
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L4d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L4d
            goto L4e
        L4d:
            r1 = r2
        L4e:
            r6.I = r1
            goto L5e
        L51:
            float r4 = (float) r5
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L5b
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L5b
            goto L5c
        L5b:
            r1 = r2
        L5c:
            r6.I = r1
        L5e:
            android.view.ViewParent r0 = r6.getParent()
            boolean r1 = r6.I
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L83
        L68:
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L83
        L70:
            float r0 = r7.getX()
            r6.G = r0
            float r0 = r7.getY()
            r6.H = r0
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L83:
            boolean r6 = super.onInterceptTouchEvent(r7)
            return r6
        L88:
            boolean r6 = super.onInterceptTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.common.banner.Banner2.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // defpackage.fg
    public void onStart(dz1 dz1Var) {
        C();
    }

    @Override // defpackage.fg
    public void onStop(dz1 dz1Var) {
        E();
    }

    public Banner2 p(boolean z) {
        this.i = z;
        return this;
    }

    public boolean q() {
        return this.h;
    }

    public Banner2 r(dg dgVar) {
        if (dgVar == null) {
            z60.a("指示器的颜色只能设置成“@color/colorID or #000000”");
            return null;
        }
        this.d = dgVar;
        if (!q()) {
            getAdapter().P(0);
        }
        getAdapter().H(this.M);
        this.a.setAdapter(dgVar);
        t(this.l, false);
        n();
        return this;
    }

    public Banner2 s(int i) {
        return t(i, true);
    }

    public Banner2 t(int i, boolean z) {
        getViewPager2().j(i, z);
        return this;
    }

    public Banner2 u() {
        if (getIndicator() != null) {
            getIndicator().d(getRealCount(), kg.b(q(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    public final void v() {
        if (!q()) {
            p(false);
        }
        A(q() ? this.l : 0);
    }

    public Banner2 w(long j) {
        this.j = j;
        return this;
    }

    public Banner2 x(int i) {
        getViewPager2().setOrientation(i);
        return this;
    }

    public final void y(int i, int i2) {
        RecyclerView childAt = getViewPager2().getChildAt(0);
        int orientation = getViewPager2().getOrientation();
        ViewPager2 viewPager2 = this.a;
        if (orientation == 1) {
            childAt.setPadding(viewPager2.getPaddingLeft(), i, this.a.getPaddingRight(), i2);
        } else {
            childAt.setPadding(i, viewPager2.getPaddingTop(), i2, this.a.getPaddingBottom());
        }
        childAt.setClipToPadding(false);
    }

    public Banner2 z(int i) {
        this.k = i;
        return this;
    }
}
