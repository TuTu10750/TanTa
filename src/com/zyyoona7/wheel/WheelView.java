package com.zyyoona7.wheel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.zzhoujay.richtext.ImageHolder;
import defpackage.li1;
import defpackage.ma3;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class WheelView<T> extends View implements Runnable {
    public static final float u0 = m(2.0f);
    public static final float v0 = W(15.0f);
    public static final float w0 = m(2.0f);
    public static final float x0 = m(1.0f);
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public Rect F;
    public float G;
    public boolean H;
    public String I;
    public Camera J;
    public Matrix K;
    public boolean L;
    public int M;
    public float N;
    public float O;
    public List P;
    public boolean Q;
    public VelocityTracker R;
    public int S;
    public int T;
    public Scroller U;
    public int V;
    public int W;
    public Paint a;
    public float b;
    public boolean c;
    public Paint.FontMetrics d;
    public int e;
    public int f;
    public int f0;
    public int g;
    public int g0;
    public int h;
    public float h0;
    public float i;
    public long i0;
    public boolean j;
    public boolean j0;
    public int k;
    public boolean k0;
    public int l;
    public int l0;
    public int m;
    public int m0;
    public boolean n;
    public boolean n0;
    public int o;
    public Typeface o0;
    public float p;
    public Typeface p0;
    public int q;
    public a q0;
    public float r;
    public b r0;
    public Paint.Cap s;
    public c s0;
    public float t;
    public boolean t0;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void d(WheelView wheelView, Object obj, int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(int i, int i2);

        void b(int i);

        void c(int i);

        void e(int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c {
        public SoundPool a = new SoundPool.Builder().build();
        public int b;
        public float c;

        public static c c() {
            return new c();
        }

        public float a() {
            return this.c;
        }

        public void b(Context context, int i) {
            SoundPool soundPool = this.a;
            if (soundPool != null) {
                this.b = soundPool.load(context, i, 1);
            }
        }

        public void d() {
            int i;
            SoundPool soundPool = this.a;
            if (soundPool == null || (i = this.b) == 0) {
                return;
            }
            float f = this.c;
            soundPool.play(i, f, f, 1, 0, 1.0f);
        }

        public void e() {
            SoundPool soundPool = this.a;
            if (soundPool != null) {
                soundPool.release();
                this.a = null;
            }
        }

        public void f(float f) {
            this.c = f;
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint(1);
        this.s = Paint.Cap.ROUND;
        this.P = new ArrayList(1);
        this.Q = false;
        this.g0 = 0;
        this.j0 = false;
        this.n0 = false;
        this.o0 = null;
        this.p0 = null;
        this.t0 = false;
        w(context, attributeSet);
        y(context);
    }

    public static float W(float f) {
        return TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics());
    }

    private int getCurrentPosition() {
        if (this.P.isEmpty()) {
            return -1;
        }
        int i = this.f0;
        int i2 = this.e;
        int k = (i < 0 ? (i - (i2 / 2)) / k() : (i + (i2 / 2)) / k()) % this.P.size();
        return k < 0 ? k + this.P.size() : k;
    }

    public static float m(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public final void A() {
        int i = this.f0;
        if (i != this.g0) {
            this.g0 = i;
            b bVar = this.r0;
            if (bVar != null) {
                bVar.e(i);
            }
            F(this.f0);
            C();
            invalidate();
        }
    }

    public boolean B(int i) {
        return i >= 0 && i < this.P.size();
    }

    public final void C() {
        int i = this.m0;
        int currentPosition = getCurrentPosition();
        if (i != currentPosition) {
            b bVar = this.r0;
            if (bVar != null) {
                bVar.a(i, currentPosition);
            }
            E(i, currentPosition);
            I();
            this.m0 = currentPosition;
        }
    }

    public void D(Object obj, int i) {
    }

    public void E(int i, int i2) {
    }

    public void F(int i) {
    }

    public void G(int i) {
    }

    public void H(int i) {
    }

    public void I() {
        c cVar = this.s0;
        if (cVar == null || !this.t0) {
            return;
        }
        cVar.d();
    }

    public final int J() {
        Paint.FontMetrics fontMetrics = this.a.getFontMetrics();
        float f = fontMetrics.ascent;
        return (int) (f + ((fontMetrics.descent - f) / 2.0f));
    }

    public final void K(float f) {
        int i = this.k;
        if (i == 0) {
            this.w = (int) f;
        } else if (i != 2) {
            this.w = getWidth() / 2;
        } else {
            this.w = (int) (getWidth() - f);
        }
    }

    public final void L() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.R = null;
        }
    }

    public final int M(String str) {
        float f;
        float measureText = this.a.measureText(str);
        float width = getWidth();
        float f2 = this.G * 2.0f;
        if (f2 > width / 10.0f) {
            f = (width * 9.0f) / 10.0f;
            f2 = f / 10.0f;
        } else {
            f = width - f2;
        }
        if (f <= 0.0f) {
            return this.g;
        }
        float f3 = this.b;
        while (measureText > f) {
            f3 -= 1.0f;
            if (f3 <= 0.0f) {
                break;
            }
            this.a.setTextSize(f3);
            measureText = this.a.measureText(str);
        }
        K(f2 / 2.0f);
        return J();
    }

    public final void N() {
        if (this.n0) {
            this.a.setTypeface(this.p0);
        }
    }

    public void O(float f, boolean z) {
        float f2 = this.p;
        if (z) {
            f = m(f);
        }
        this.p = f;
        if (f2 == f) {
            return;
        }
        invalidate();
    }

    public void P(float f, boolean z) {
        float f2 = this.r;
        if (z) {
            f = m(f);
        }
        this.r = f;
        if (f2 == f) {
            return;
        }
        invalidate();
    }

    public void Q(float f, boolean z) {
        float f2 = this.i;
        if (z) {
            f = m(f);
        }
        this.i = f;
        if (f2 == f) {
            return;
        }
        this.f0 = 0;
        g();
        requestLayout();
        invalidate();
    }

    public void R(int i, boolean z) {
        S(i, z, 0);
    }

    public void S(int i, boolean z, int i2) {
        int e;
        if (B(i) && (e = e(i)) != 0) {
            a();
            if (z) {
                Scroller scroller = this.U;
                int i3 = this.f0;
                if (i2 <= 0) {
                    i2 = 250;
                }
                scroller.startScroll(0, i3, 0, e, i2);
                A();
                nj4.c0(this, this);
                return;
            }
            l(e);
            this.l0 = i;
            a aVar = this.q0;
            if (aVar != null) {
                aVar.d(this, this.P.get(i), this.l0);
            }
            D(this.P.get(this.l0), this.l0);
            b bVar = this.r0;
            if (bVar != null) {
                bVar.c(this.l0);
            }
            H(this.l0);
            A();
        }
    }

    public void T(float f, boolean z) {
        float f2 = this.G;
        if (z) {
            f = m(f);
        }
        this.G = f;
        if (f2 == f) {
            return;
        }
        requestLayout();
        invalidate();
    }

    public void U(float f, boolean z) {
        float f2 = this.b;
        if (z) {
            f = W(f);
        }
        this.b = f;
        if (f2 == f) {
            return;
        }
        s();
        g();
        d();
        f();
        this.f0 = this.l0 * this.e;
        requestLayout();
        invalidate();
    }

    public void V(Typeface typeface, boolean z) {
        if (typeface == null || this.a.getTypeface() == typeface) {
            return;
        }
        s();
        this.n0 = z;
        if (z) {
            if (typeface.isBold()) {
                this.o0 = Typeface.create(typeface, 0);
                this.p0 = typeface;
            } else {
                this.o0 = typeface;
                this.p0 = Typeface.create(typeface, 1);
            }
            this.a.setTypeface(this.p0);
        } else {
            this.a.setTypeface(typeface);
        }
        g();
        d();
        this.f0 = this.l0 * this.e;
        f();
        requestLayout();
        invalidate();
    }

    public final void X() {
        int i = this.k;
        if (i == 0) {
            this.a.setTextAlign(Paint.Align.LEFT);
            return;
        }
        Paint paint = this.a;
        if (i != 2) {
            paint.setTextAlign(Paint.Align.CENTER);
        } else {
            paint.setTextAlign(Paint.Align.RIGHT);
        }
    }

    public void a() {
        if (this.U.isFinished()) {
            return;
        }
        this.U.abortAnimation();
    }

    public final int b(int i) {
        return Math.abs(((i / 2) * 2) + 1);
    }

    public final int c(int i) {
        int abs = Math.abs(i);
        int i2 = this.e;
        return abs > i2 / 2 ? this.f0 < 0 ? (-i2) - i : i2 - i : -i;
    }

    public final void d() {
        int i = this.k;
        if (i == 0) {
            this.w = (int) (getPaddingLeft() + this.G);
        } else if (i != 2) {
            this.w = getWidth() / 2;
        } else {
            this.w = (int) ((getWidth() - getPaddingRight()) - this.G);
        }
        Paint.FontMetrics fontMetrics = this.d;
        float f = fontMetrics.ascent;
        this.g = (int) (f + ((fontMetrics.descent - f) / 2.0f));
    }

    public final int e(int i) {
        return (i * this.e) - this.f0;
    }

    public final void f() {
        boolean z = this.j;
        this.V = z ? ImageHolder.WRAP_CONTENT : 0;
        this.W = z ? ImageHolder.MATCH_PARENT : (this.P.size() - 1) * this.e;
    }

    public final void g() {
        this.a.setTextSize(this.b);
        int i = 0;
        while (true) {
            int size = this.P.size();
            Paint paint = this.a;
            if (i >= size) {
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                this.d = fontMetrics;
                this.e = (int) ((fontMetrics.bottom - fontMetrics.top) + this.i);
                return;
            }
            this.f = Math.max((int) paint.measureText(u(this.P.get(i))), this.f);
            i++;
        }
    }

    public int getCurvedArcDirection() {
        return this.M;
    }

    public float getCurvedArcDirectionFactor() {
        return this.N;
    }

    @Deprecated
    public float getCurvedRefractRatio() {
        return this.O;
    }

    public List<T> getData() {
        return this.P;
    }

    public Paint.Cap getDividerCap() {
        return this.s;
    }

    public int getDividerColor() {
        return this.o;
    }

    public float getDividerHeight() {
        return this.p;
    }

    public float getDividerPaddingForWrap() {
        return this.r;
    }

    public int getDividerType() {
        return this.q;
    }

    public String getIntegerFormat() {
        return this.I;
    }

    public float getLineSpacing() {
        return this.i;
    }

    public int getNormalItemTextColor() {
        return this.l;
    }

    public a getOnItemSelectedListener() {
        return this.q0;
    }

    public b getOnWheelChangedListener() {
        return this.r0;
    }

    public float getPlayVolume() {
        c cVar = this.s0;
        if (cVar == null) {
            return 0.0f;
        }
        return cVar.a();
    }

    public float getRefractRatio() {
        return this.O;
    }

    public T getSelectedItemData() {
        return (T) v(this.l0);
    }

    public int getSelectedItemPosition() {
        return this.l0;
    }

    public int getSelectedItemTextColor() {
        return this.m;
    }

    public int getSelectedRectColor() {
        return this.v;
    }

    public int getTextAlign() {
        return this.k;
    }

    public float getTextBoundaryMargin() {
        return this.G;
    }

    public float getTextSize() {
        return this.b;
    }

    public Typeface getTypeface() {
        return this.a.getTypeface();
    }

    public int getVisibleItems() {
        return this.h;
    }

    public final void h() {
        if (this.n0) {
            this.a.setTypeface(this.o0);
        }
    }

    public final void i(Canvas canvas, String str, int i, int i2, int i3, int i4) {
        canvas.save();
        canvas.clipRect(this.B, i, this.D, i2);
        canvas.drawText(str, 0, str.length(), this.w, (this.y + i3) - i4, this.a);
        canvas.restore();
    }

    public final void j(Canvas canvas, String str, int i, int i2, float f, float f2, float f3, int i3) {
        canvas.save();
        canvas.clipRect(this.B, i, this.D, i2);
        o(canvas, str, f, f2, f3, i3);
        canvas.restore();
    }

    public final int k() {
        int i = this.e;
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public final void l(int i) {
        int i2 = this.f0 + i;
        this.f0 = i2;
        if (this.j) {
            return;
        }
        int i3 = this.V;
        if (i2 < i3) {
            this.f0 = i3;
            return;
        }
        int i4 = this.W;
        if (i2 > i4) {
            this.f0 = i4;
        }
    }

    public final void n(Canvas canvas, int i, int i2) {
        WheelView<T> wheelView;
        String t = t(i);
        if (t == null) {
            return;
        }
        int height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2;
        int k = ((i - (this.f0 / k())) * this.e) - i2;
        double d = height;
        if (Math.abs(k) > (3.141592653589793d * d) / 2.0d) {
            return;
        }
        double d2 = k / d;
        float degrees = (float) Math.toDegrees(-d2);
        float sin = (float) (Math.sin(d2) * d);
        float cos = (float) ((1.0d - Math.cos(d2)) * d);
        int cos2 = (int) (Math.cos(d2) * 255.0d);
        int i3 = this.w;
        int M = this.c ? M(t) : this.g;
        if (Math.abs(k) <= 0) {
            this.a.setColor(this.m);
            this.a.setAlpha(255);
            wheelView = this;
            wheelView.j(canvas, t, this.z, this.A, degrees, sin, cos, M);
        } else {
            wheelView = this;
            if (k > 0 && k < wheelView.e) {
                wheelView.a.setColor(wheelView.m);
                wheelView.a.setAlpha(255);
                wheelView.j(canvas, t, wheelView.z, wheelView.A, degrees, sin, cos, M);
                wheelView.a.setColor(wheelView.l);
                wheelView.a.setAlpha(cos2);
                float textSize = wheelView.a.getTextSize();
                wheelView.a.setTextSize(wheelView.O * textSize);
                wheelView.h();
                wheelView.j(canvas, t, wheelView.A, wheelView.E, degrees, sin, cos, wheelView.J());
                wheelView.a.setTextSize(textSize);
                wheelView.N();
            } else if (k >= 0 || k <= (-wheelView.e)) {
                wheelView.a.setColor(wheelView.l);
                wheelView.a.setAlpha(cos2);
                float textSize2 = wheelView.a.getTextSize();
                wheelView.a.setTextSize(wheelView.O * textSize2);
                wheelView.h();
                wheelView.j(canvas, t, wheelView.C, wheelView.E, degrees, sin, cos, wheelView.J());
                wheelView.a.setTextSize(textSize2);
                wheelView.N();
            } else {
                wheelView.a.setColor(wheelView.m);
                wheelView.a.setAlpha(255);
                wheelView.j(canvas, t, wheelView.z, wheelView.A, degrees, sin, cos, M);
                wheelView.a.setColor(wheelView.l);
                wheelView.a.setAlpha(cos2);
                float textSize3 = wheelView.a.getTextSize();
                wheelView.a.setTextSize(wheelView.O * textSize3);
                wheelView.h();
                wheelView.j(canvas, t, wheelView.C, wheelView.z, degrees, sin, cos, wheelView.J());
                wheelView.a.setTextSize(textSize3);
                wheelView.N();
            }
        }
        if (wheelView.c) {
            wheelView.a.setTextSize(wheelView.b);
            wheelView.w = i3;
        }
    }

    public final void o(Canvas canvas, String str, float f, float f2, float f3, int i) {
        this.J.save();
        this.J.translate(0.0f, 0.0f, f3);
        this.J.rotateX(f);
        this.J.getMatrix(this.K);
        this.J.restore();
        int i2 = this.x;
        float f4 = i2;
        int i3 = this.M;
        if (i3 == 0) {
            f4 = (this.N + 1.0f) * i2;
        } else if (i3 == 2) {
            f4 = i2 * (1.0f - this.N);
        }
        float f5 = this.y + f2;
        this.K.preTranslate(-f4, -f5);
        this.K.postTranslate(f4, f5);
        canvas.concat(this.K);
        canvas.drawText(str, 0, str.length(), this.w, f5 - i, this.a);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.s0;
        if (cVar != null) {
            cVar.e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            r4.r(r5)
            r4.p(r5)
            int r0 = r4.f0
            int r1 = r4.k()
            int r0 = r0 / r1
            int r1 = r4.f0
            int r2 = r4.k()
            int r1 = r1 % r2
            int r2 = r4.h
            int r2 = r2 + 1
            int r2 = r2 / 2
            if (r1 >= 0) goto L25
            int r3 = r0 - r2
            int r3 = r3 + (-1)
        L23:
            int r0 = r0 + r2
            goto L30
        L25:
            if (r1 <= 0) goto L2d
            int r3 = r0 - r2
            int r0 = r0 + r2
            int r0 = r0 + 1
            goto L30
        L2d:
            int r3 = r0 - r2
            goto L23
        L30:
            if (r3 >= r0) goto L40
            boolean r2 = r4.L
            if (r2 == 0) goto L3a
            r4.n(r5, r3, r1)
            goto L3d
        L3a:
            r4.q(r5, r3, r1)
        L3d:
            int r3 = r3 + 1
            goto L30
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyyoona7.wheel.WheelView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int paddingBottom;
        boolean z = this.L;
        int i3 = this.e;
        if (z) {
            paddingBottom = (int) ((((i3 * this.h) * 2) / 3.141592653589793d) + getPaddingTop() + getPaddingBottom());
        } else {
            paddingBottom = getPaddingBottom() + (i3 * this.h) + getPaddingTop();
        }
        int paddingLeft = (int) (this.f + getPaddingLeft() + getPaddingRight() + (this.G * 2.0f));
        if (this.L) {
            paddingLeft += (int) (Math.sin(0.06544984694978735d) * paddingBottom);
        }
        setMeasuredDimension(View.resolveSizeAndState(paddingLeft, i, 0), View.resolveSizeAndState(paddingBottom, i2, 0));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.F.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.x = this.F.centerX();
        this.y = this.F.centerY();
        int i5 = this.e;
        float f = this.t;
        this.z = (int) ((r3 - (i5 / 2)) - f);
        this.A = (int) (r3 + (i5 / 2) + f);
        this.B = getPaddingLeft();
        this.C = getPaddingTop();
        this.D = getWidth() - getPaddingRight();
        this.E = getHeight() - getPaddingBottom();
        d();
        f();
        int e = e(this.l0);
        if (e > 0) {
            l(e);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.P.isEmpty()) {
            return super.onTouchEvent(motionEvent);
        }
        z();
        this.R.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (!this.U.isFinished()) {
                this.U.forceFinished(true);
                this.j0 = true;
            }
            this.h0 = motionEvent.getY();
            this.i0 = System.currentTimeMillis();
        } else if (actionMasked == 1) {
            this.j0 = false;
            this.R.computeCurrentVelocity(IjkMediaCodecInfo.RANK_MAX, this.S);
            float yVelocity = this.R.getYVelocity();
            if (Math.abs(yVelocity) > this.T) {
                this.U.forceFinished(true);
                this.k0 = true;
                this.U.fling(0, this.f0, 0, (int) (-yVelocity), 0, 0, this.V, this.W);
            } else {
                int y = System.currentTimeMillis() - this.i0 <= 120 ? (int) (motionEvent.getY() - this.y) : 0;
                int c2 = y + c((this.f0 + y) % k());
                boolean z = c2 < 0 && this.f0 + c2 >= this.V;
                boolean z2 = c2 > 0 && this.f0 + c2 <= this.W;
                if (z || z2) {
                    this.U.startScroll(0, this.f0, 0, c2);
                }
            }
            A();
            nj4.c0(this, this);
            L();
        } else if (actionMasked == 2) {
            float y2 = motionEvent.getY();
            float f = y2 - this.h0;
            b bVar = this.r0;
            if (bVar != null) {
                bVar.b(1);
            }
            G(1);
            if (Math.abs(f) >= 1.0f) {
                l((int) (-f));
                this.h0 = y2;
                A();
            }
        } else if (actionMasked == 3) {
            L();
        }
        return true;
    }

    public final void p(Canvas canvas) {
        if (this.n) {
            this.a.setColor(this.o);
            float strokeWidth = this.a.getStrokeWidth();
            this.a.setStrokeJoin(Paint.Join.ROUND);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            this.a.setStrokeWidth(this.p);
            if (this.q == 0) {
                float f = this.B;
                int i = this.z;
                canvas.drawLine(f, i, this.D, i, this.a);
                float f2 = this.B;
                int i2 = this.A;
                canvas.drawLine(f2, i2, this.D, i2, this.a);
            } else {
                int i3 = this.x;
                int i4 = this.f;
                float f3 = this.r;
                int i5 = (int) ((i3 - (i4 / 2)) - f3);
                int i6 = (int) (i3 + (i4 / 2) + f3);
                int i7 = this.B;
                if (i5 < i7) {
                    i5 = i7;
                }
                int i8 = this.D;
                if (i6 > i8) {
                    i6 = i8;
                }
                float f4 = i5;
                int i9 = this.z;
                float f5 = i6;
                canvas.drawLine(f4, i9, f5, i9, this.a);
                int i10 = this.A;
                canvas.drawLine(f4, i10, f5, i10, this.a);
            }
            this.a.setStrokeWidth(strokeWidth);
        }
    }

    public final void q(Canvas canvas, int i, int i2) {
        WheelView<T> wheelView;
        String t = t(i);
        if (t == null) {
            return;
        }
        int k = ((i - (this.f0 / k())) * this.e) - i2;
        int i3 = this.w;
        int M = this.c ? M(t) : this.g;
        if (Math.abs(k) <= 0) {
            this.a.setColor(this.m);
            wheelView = this;
            wheelView.i(canvas, t, this.z, this.A, k, M);
        } else {
            wheelView = this;
            if (k > 0 && k < wheelView.e) {
                wheelView.a.setColor(wheelView.m);
                wheelView.i(canvas, t, wheelView.z, wheelView.A, k, M);
                wheelView.a.setColor(wheelView.l);
                float textSize = wheelView.a.getTextSize();
                wheelView.a.setTextSize(wheelView.O * textSize);
                wheelView.h();
                wheelView.i(canvas, t, wheelView.A, wheelView.E, k, M);
                wheelView.a.setTextSize(textSize);
                wheelView.N();
            } else if (k >= 0 || k <= (-wheelView.e)) {
                wheelView.a.setColor(wheelView.l);
                float textSize2 = wheelView.a.getTextSize();
                wheelView.a.setTextSize(wheelView.O * textSize2);
                wheelView.h();
                wheelView.i(canvas, t, wheelView.C, wheelView.E, k, M);
                wheelView.a.setTextSize(textSize2);
                wheelView.N();
            } else {
                wheelView.a.setColor(wheelView.m);
                wheelView.i(canvas, t, wheelView.z, wheelView.A, k, M);
                wheelView.a.setColor(wheelView.l);
                float textSize3 = wheelView.a.getTextSize();
                wheelView.a.setTextSize(wheelView.O * textSize3);
                wheelView.h();
                wheelView.i(canvas, t, wheelView.C, wheelView.z, k, M);
                wheelView.a.setTextSize(textSize3);
                wheelView.N();
            }
        }
        if (wheelView.c) {
            wheelView.a.setTextSize(wheelView.b);
            wheelView.w = i3;
        }
    }

    public final void r(Canvas canvas) {
        if (this.u) {
            this.a.setColor(this.v);
            canvas.drawRect(this.B, this.z, this.D, this.A, this.a);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.U.isFinished() && !this.j0 && !this.k0) {
            if (this.e == 0) {
                return;
            }
            b bVar = this.r0;
            if (bVar != null) {
                bVar.b(0);
            }
            G(0);
            int currentPosition = getCurrentPosition();
            if (currentPosition == this.l0) {
                return;
            }
            this.l0 = currentPosition;
            this.m0 = currentPosition;
            a aVar = this.q0;
            if (aVar != null) {
                aVar.d(this, this.P.get(currentPosition), this.l0);
            }
            D(this.P.get(this.l0), this.l0);
            b bVar2 = this.r0;
            if (bVar2 != null) {
                bVar2.c(this.l0);
            }
            H(this.l0);
        }
        if (!this.U.computeScrollOffset()) {
            if (this.k0) {
                this.k0 = false;
                Scroller scroller = this.U;
                int i = this.f0;
                scroller.startScroll(0, i, 0, c(i % k()));
                A();
                nj4.c0(this, this);
                return;
            }
            return;
        }
        int i2 = this.f0;
        int currY = this.U.getCurrY();
        this.f0 = currY;
        if (i2 != currY) {
            b bVar3 = this.r0;
            if (bVar3 != null) {
                bVar3.b(2);
            }
            G(2);
        }
        A();
        nj4.c0(this, this);
    }

    public void s() {
        if (this.U.isFinished()) {
            return;
        }
        this.U.forceFinished(true);
    }

    public void setAutoFitTextSize(boolean z) {
        this.c = z;
        invalidate();
    }

    public void setCurved(boolean z) {
        if (this.L == z) {
            return;
        }
        this.L = z;
        g();
        requestLayout();
        invalidate();
    }

    public void setCurvedArcDirection(int i) {
        if (this.M == i) {
            return;
        }
        this.M = i;
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r3 > 1.0f) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurvedArcDirectionFactor(float r3) {
        /*
            r2 = this;
            float r0 = r2.N
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L7
            return
        L7:
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto Le
        Lc:
            r3 = r0
            goto L15
        Le:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L15
            goto Lc
        L15:
            r2.N = r3
            r2.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyyoona7.wheel.WheelView.setCurvedArcDirectionFactor(float):void");
    }

    @Deprecated
    public void setCurvedRefractRatio(float f) {
        setRefractRatio(f);
    }

    public void setCyclic(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        s();
        f();
        this.f0 = this.l0 * this.e;
        invalidate();
    }

    public void setData(List<T> list) {
        if (list == null) {
            return;
        }
        this.P = list;
        if (this.Q || list.size() <= 0) {
            this.l0 = 0;
            this.m0 = 0;
        } else if (this.l0 >= this.P.size()) {
            int size = this.P.size() - 1;
            this.l0 = size;
            this.m0 = size;
        }
        s();
        g();
        f();
        this.f0 = this.l0 * this.e;
        requestLayout();
        invalidate();
    }

    public void setDividerCap(Paint.Cap cap) {
        if (this.s == cap) {
            return;
        }
        this.s = cap;
        invalidate();
    }

    public void setDividerColor(int i) {
        if (this.o == i) {
            return;
        }
        this.o = i;
        invalidate();
    }

    public void setDividerColorRes(int i) {
        setDividerColor(o60.b(getContext(), i));
    }

    public void setDividerHeight(float f) {
        O(f, false);
    }

    public void setDividerPaddingForWrap(float f) {
        P(f, false);
    }

    public void setDividerType(int i) {
        if (this.q == i) {
            return;
        }
        this.q = i;
        invalidate();
    }

    public void setDrawSelectedRect(boolean z) {
        this.u = z;
        invalidate();
    }

    public void setIntegerFormat(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.I)) {
            return;
        }
        this.I = str;
        g();
        requestLayout();
        invalidate();
    }

    public void setIntegerNeedFormat(String str) {
        this.H = true;
        this.I = str;
        g();
        requestLayout();
        invalidate();
    }

    public void setIntegerNeedFormat(boolean z) {
        if (this.H == z) {
            return;
        }
        this.H = z;
        g();
        requestLayout();
        invalidate();
    }

    public void setLineSpacing(float f) {
        Q(f, false);
    }

    public void setNormalItemTextColor(int i) {
        if (this.l == i) {
            return;
        }
        this.l = i;
        invalidate();
    }

    public void setNormalItemTextColorRes(int i) {
        setNormalItemTextColor(o60.b(getContext(), i));
    }

    public void setOnItemSelectedListener(a aVar) {
        this.q0 = aVar;
    }

    public void setOnWheelChangedListener(b bVar) {
        this.r0 = bVar;
    }

    public void setPlayVolume(float f) {
        c cVar = this.s0;
        if (cVar != null) {
            cVar.f(f);
        }
    }

    public void setRefractRatio(float f) {
        float f2 = this.O;
        this.O = f;
        if (f > 1.0f) {
            this.O = 1.0f;
        } else if (f < 0.0f) {
            this.O = 1.0f;
        }
        if (f2 == this.O) {
            return;
        }
        invalidate();
    }

    public void setResetSelectedPosition(boolean z) {
        this.Q = z;
    }

    public void setSelectedItemPosition(int i) {
        R(i, false);
    }

    public void setSelectedItemTextColor(int i) {
        if (this.m == i) {
            return;
        }
        this.m = i;
        invalidate();
    }

    public void setSelectedItemTextColorRes(int i) {
        setSelectedItemTextColor(o60.b(getContext(), i));
    }

    public void setSelectedRectColor(int i) {
        this.v = i;
        invalidate();
    }

    public void setSelectedRectColorRes(int i) {
        setSelectedRectColor(o60.b(getContext(), i));
    }

    public void setShowDivider(boolean z) {
        if (this.n == z) {
            return;
        }
        this.n = z;
        invalidate();
    }

    public void setSoundEffect(boolean z) {
        this.t0 = z;
    }

    public void setSoundEffectResource(int i) {
        c cVar = this.s0;
        if (cVar != null) {
            cVar.b(getContext(), i);
        }
    }

    public void setTextAlign(int i) {
        if (this.k == i) {
            return;
        }
        this.k = i;
        X();
        d();
        invalidate();
    }

    public void setTextBoundaryMargin(float f) {
        T(f, false);
    }

    public void setTextSize(float f) {
        U(f, false);
    }

    public void setTypeface(Typeface typeface) {
        V(typeface, false);
    }

    public void setVisibleItems(int i) {
        if (this.h == i) {
            return;
        }
        this.h = b(i);
        this.f0 = 0;
        requestLayout();
        invalidate();
    }

    public final String t(int i) {
        int size = this.P.size();
        if (size == 0) {
            return null;
        }
        if (this.j) {
            int i2 = i % size;
            if (i2 < 0) {
                i2 += size;
            }
            return u(this.P.get(i2));
        }
        if (i < 0 || i >= size) {
            return null;
        }
        return u(this.P.get(i));
    }

    public String u(Object obj) {
        return obj == null ? "" : obj instanceof li1 ? ((li1) obj).getWheelText() : obj instanceof Integer ? this.H ? String.format(Locale.getDefault(), this.I, obj) : String.valueOf(obj) : obj instanceof String ? (String) obj : obj.toString();
    }

    public Object v(int i) {
        boolean B = B(i);
        List list = this.P;
        if (B) {
            return list.get(i);
        }
        if (list.size() > 0 && i >= this.P.size()) {
            return this.P.get(r2.size() - 1);
        }
        if (this.P.size() <= 0 || i >= 0) {
            return null;
        }
        return this.P.get(0);
    }

    public final void w(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ma3.a);
        this.b = obtainStyledAttributes.getDimension(ma3.y, v0);
        this.c = obtainStyledAttributes.getBoolean(ma3.b, false);
        this.k = obtainStyledAttributes.getInt(ma3.w, 1);
        int i = ma3.x;
        float f = w0;
        this.G = obtainStyledAttributes.getDimension(i, f);
        this.l = obtainStyledAttributes.getColor(ma3.q, -12303292);
        this.m = obtainStyledAttributes.getColor(ma3.t, -16777216);
        this.i = obtainStyledAttributes.getDimension(ma3.p, u0);
        this.H = obtainStyledAttributes.getBoolean(ma3.o, false);
        String string = obtainStyledAttributes.getString(ma3.n);
        this.I = string;
        if (TextUtils.isEmpty(string)) {
            this.I = "%02d";
        }
        int i2 = obtainStyledAttributes.getInt(ma3.z, 5);
        this.h = i2;
        this.h = b(i2);
        int i3 = obtainStyledAttributes.getInt(ma3.s, 0);
        this.l0 = i3;
        this.m0 = i3;
        this.j = obtainStyledAttributes.getBoolean(ma3.g, false);
        this.n = obtainStyledAttributes.getBoolean(ma3.v, false);
        this.q = obtainStyledAttributes.getInt(ma3.l, 0);
        this.p = obtainStyledAttributes.getDimension(ma3.i, x0);
        this.o = obtainStyledAttributes.getColor(ma3.h, -16777216);
        this.r = obtainStyledAttributes.getDimension(ma3.k, f);
        this.t = obtainStyledAttributes.getDimensionPixelOffset(ma3.j, 0);
        this.u = obtainStyledAttributes.getBoolean(ma3.m, false);
        this.v = obtainStyledAttributes.getColor(ma3.u, 0);
        this.L = obtainStyledAttributes.getBoolean(ma3.c, true);
        this.M = obtainStyledAttributes.getInt(ma3.d, 1);
        this.N = obtainStyledAttributes.getFloat(ma3.e, 0.75f);
        float f2 = obtainStyledAttributes.getFloat(ma3.f, 0.9f);
        float f3 = obtainStyledAttributes.getFloat(ma3.r, 1.0f);
        this.O = f3;
        if (this.L) {
            f3 = Math.min(f2, f3);
        }
        this.O = f3;
        if (f3 > 1.0f) {
            this.O = 1.0f;
        } else if (f3 < 0.0f) {
            this.O = 1.0f;
        }
        obtainStyledAttributes.recycle();
    }

    public final void x(Context context) {
        if (((AudioManager) context.getSystemService("audio")) == null) {
            this.s0.f(0.3f);
            return;
        }
        this.s0.f((r3.getStreamVolume(3) * 1.0f) / r3.getStreamMaxVolume(3));
    }

    public final void y(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.S = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = viewConfiguration.getScaledMinimumFlingVelocity();
        this.U = new Scroller(context);
        this.F = new Rect();
        this.J = new Camera();
        this.K = new Matrix();
        if (!isInEditMode()) {
            this.s0 = c.c();
            x(context);
        }
        g();
        X();
    }

    public final void z() {
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
    }
}
