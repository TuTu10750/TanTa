package com.yunbao.video.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import defpackage.ia3;
import defpackage.ik;

/* loaded from: /tmp/classes2.dex */
public class RangeSlider extends ViewGroup {
    public final Paint a;
    public final Paint b;
    public final ThumbView c;
    public final ThumbView d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public boolean n;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
    }

    public RangeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RangeSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 0;
        this.j = 5;
        this.k = 1;
        this.l = 5;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ia3.o2);
        this.h = obtainStyledAttributes.getDimensionPixelOffset(ia3.w2, 7);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(ia3.s2, 1);
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(obtainStyledAttributes.getColor(ia3.t2, -1610612736));
        Paint paint2 = new Paint();
        this.a = paint2;
        paint2.setColor(obtainStyledAttributes.getColor(ia3.r2, -16777216));
        this.e = ViewConfiguration.get(context).getScaledTouchSlop();
        Drawable drawable = obtainStyledAttributes.getDrawable(ia3.p2);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(ia3.u2);
        ThumbView thumbView = new ThumbView(context, this.h, drawable == null ? new ColorDrawable(-16777216) : drawable);
        this.c = thumbView;
        ThumbView thumbView2 = new ThumbView(context, this.h, drawable2 == null ? new ColorDrawable(-16777216) : drawable2);
        this.d = thumbView2;
        setTickCount(obtainStyledAttributes.getInteger(ia3.x2, 5));
        j(obtainStyledAttributes.getInteger(ia3.q2, 0), obtainStyledAttributes.getInteger(ia3.v2, this.l));
        obtainStyledAttributes.recycle();
        addView(thumbView);
        addView(thumbView2);
        setWillNotDraw(false);
    }

    private float getIntervalLength() {
        return getRangeLength() / this.l;
    }

    private float getRangeLength() {
        if (getMeasuredWidth() < this.h) {
            return 0.0f;
        }
        return r0 - r1;
    }

    public int a(float f) {
        return Math.round(f / getIntervalLength());
    }

    public final boolean b(int i, int i2) {
        int i3;
        return i < 0 || i > (i3 = this.l) || i2 < 0 || i2 > i3;
    }

    public final boolean c(int i) {
        return i > 1;
    }

    public final void d(int i) {
        float x = this.c.getX() + i;
        float intervalLength = getIntervalLength();
        int i2 = this.i;
        int i3 = this.k;
        float f = (i2 / i3) * intervalLength;
        float f2 = (this.j / i3) * intervalLength;
        if (x <= f || x >= f2 || x >= this.d.getX() - this.h) {
            return;
        }
        this.c.setX(x);
        int a2 = a(x);
        if (this.c.getRangeIndex() != a2) {
            this.c.setTickIndex(a2);
            g(1);
        }
    }

    public final void e(int i) {
        float x = this.d.getX() + i;
        float intervalLength = getIntervalLength();
        int i2 = this.i;
        int i3 = this.k;
        float f = (i2 / i3) * intervalLength;
        float f2 = (this.j / i3) * intervalLength;
        if (x <= f || x >= f2 || x <= this.c.getX() + this.h) {
            return;
        }
        this.d.setX(x);
        int a2 = a(x);
        if (this.d.getRangeIndex() != a2) {
            this.d.setTickIndex(a2);
            g(2);
        }
    }

    public final boolean f(ThumbView thumbView, int i) {
        thumbView.setX(i * getIntervalLength());
        if (thumbView.getRangeIndex() == i) {
            return false;
        }
        thumbView.setTickIndex(i);
        return true;
    }

    public final void g(int i) {
    }

    public int getLeftIndex() {
        return this.c.getRangeIndex();
    }

    public int getRightIndex() {
        return this.d.getRangeIndex();
    }

    public final void h() {
        int a2 = a(this.c.getX());
        int rangeIndex = this.d.getRangeIndex();
        if (a2 >= rangeIndex) {
            a2 = rangeIndex - 1;
        }
        if (f(this.c, a2)) {
            g(1);
        }
        this.c.setPressed(false);
    }

    public final void i() {
        int a2 = a(this.d.getX());
        int rangeIndex = this.c.getRangeIndex();
        if (a2 <= rangeIndex) {
            a2 = rangeIndex + 1;
        }
        if (f(this.d, a2)) {
            g(2);
        }
        this.d.setPressed(false);
    }

    public void j(int i, int i2) {
        if (!b(i, i2)) {
            if (this.c.getRangeIndex() != i) {
                this.c.setTickIndex(i);
            }
            if (this.d.getRangeIndex() != i2) {
                this.d.setTickIndex(i2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Thumb index left " + i + ", or right " + i2 + " is out of bounds. Check that it is greater than the minimum (" + this.i + ") and less than the maximum value (" + this.j + ")");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.c.getMeasuredWidth();
        float x = this.c.getX();
        float x2 = this.d.getX();
        float f = this.m;
        float f2 = measuredHeight;
        float f3 = measuredWidth2 + x;
        canvas.drawRect(f3, 0.0f, x2, f, this.a);
        canvas.drawRect(f3, f2 - f, x2, f2, this.a);
        int i = this.h;
        if (x > i) {
            canvas.drawRect(0.0f, 0.0f, x + i, f2, this.b);
        }
        if (x2 < measuredWidth - this.h) {
            canvas.drawRect(x2, 0.0f, measuredWidth, f2, this.b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.c.getMeasuredWidth();
        int measuredHeight = this.c.getMeasuredHeight();
        this.c.layout(0, 0, measuredWidth, measuredHeight);
        this.d.layout(0, 0, measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
        super.onMeasure(makeMeasureSpec, i2);
        this.c.measure(makeMeasureSpec, i2);
        this.d.measure(makeMeasureSpec, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        ThumbView thumbView = this.c;
        f(thumbView, thumbView.getRangeIndex());
        ThumbView thumbView2 = this.d;
        f(thumbView2, thumbView2.getRangeIndex());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        if (r0 != 3) goto L49;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L93
            if (r0 == r2) goto L68
            r3 = 2
            if (r0 == r3) goto L19
            r5 = 3
            if (r0 == r5) goto L68
            goto Lcf
        L19:
            float r5 = r5.getX()
            int r5 = (int) r5
            boolean r0 = r4.n
            if (r0 != 0) goto L30
            int r0 = r4.f
            int r0 = r5 - r0
            int r0 = java.lang.Math.abs(r0)
            int r3 = r4.e
            if (r0 <= r3) goto L30
            r4.n = r2
        L30:
            boolean r0 = r4.n
            if (r0 == 0) goto L65
            int r0 = r4.g
            int r0 = r5 - r0
            com.yunbao.video.custom.ThumbView r3 = r4.c
            boolean r3 = r3.isPressed()
            if (r3 == 0) goto L4f
            android.view.ViewParent r1 = r4.getParent()
            r1.requestDisallowInterceptTouchEvent(r2)
            r4.d(r0)
            r4.invalidate()
        L4d:
            r1 = r2
            goto L65
        L4f:
            com.yunbao.video.custom.ThumbView r3 = r4.d
            boolean r3 = r3.isPressed()
            if (r3 == 0) goto L65
            android.view.ViewParent r1 = r4.getParent()
            r1.requestDisallowInterceptTouchEvent(r2)
            r4.e(r0)
            r4.invalidate()
            goto L4d
        L65:
            r4.g = r5
            return r1
        L68:
            r4.n = r1
            r4.g = r1
            r4.f = r1
            android.view.ViewParent r5 = r4.getParent()
            r5.requestDisallowInterceptTouchEvent(r1)
            com.yunbao.video.custom.ThumbView r5 = r4.c
            boolean r5 = r5.isPressed()
            if (r5 == 0) goto L84
            r4.h()
            r4.invalidate()
            return r2
        L84:
            com.yunbao.video.custom.ThumbView r5 = r4.d
            boolean r5 = r5.isPressed()
            if (r5 == 0) goto Lcf
            r4.i()
            r4.invalidate()
            return r2
        L93:
            float r0 = r5.getX()
            int r0 = (int) r0
            float r5 = r5.getY()
            int r5 = (int) r5
            r4.f = r0
            r4.g = r0
            r4.n = r1
            com.yunbao.video.custom.ThumbView r3 = r4.c
            boolean r3 = r3.isPressed()
            if (r3 != 0) goto Lb9
            com.yunbao.video.custom.ThumbView r3 = r4.c
            boolean r3 = r3.a(r0, r5)
            if (r3 == 0) goto Lb9
            com.yunbao.video.custom.ThumbView r4 = r4.c
            r4.setPressed(r2)
            return r2
        Lb9:
            com.yunbao.video.custom.ThumbView r3 = r4.d
            boolean r3 = r3.isPressed()
            if (r3 != 0) goto Lcf
            com.yunbao.video.custom.ThumbView r3 = r4.d
            boolean r5 = r3.a(r0, r5)
            if (r5 == 0) goto Lcf
            com.yunbao.video.custom.ThumbView r4 = r4.d
            r4.setPressed(r2)
            return r2
        Lcf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.video.custom.RangeSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setLeftThumbDrawable(Drawable drawable) {
        this.c.setThumbDrawable(drawable);
    }

    public void setLineColor(int i) {
        this.a.setColor(i);
    }

    public void setLineSize(float f) {
        this.m = f;
    }

    public void setMaskColor(int i) {
        this.b.setColor(i);
    }

    public void setRangeChangeListener(a aVar) {
    }

    public void setRightThumbDrawable(Drawable drawable) {
        this.d.setThumbDrawable(drawable);
    }

    public void setThumbWidth(int i) {
        this.h = i;
        this.c.setThumbWidth(i);
        this.d.setThumbWidth(i);
    }

    public void setTickCount(int i) {
        int i2 = (i - this.i) / this.k;
        if (!c(i2)) {
            ik.a("tickCount less than 2; invalid tickCount.");
            return;
        }
        this.j = i;
        this.l = i2;
        this.d.setTickIndex(i2);
    }
}
