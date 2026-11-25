package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class BubbleLayout extends FrameLayout {
    public Paint a;
    public float b;
    public int c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;
    public int j;
    public int k;
    public RectF l;
    public RectF m;
    public RectF n;
    public RectF o;

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.Y);
        this.c = obtainStyledAttributes.getColor(da3.d0, 16777215);
        this.d = obtainStyledAttributes.getDimension(da3.e0, 0.0f);
        this.f = obtainStyledAttributes.getDimension(da3.c0, 0.0f);
        this.g = obtainStyledAttributes.getDimension(da3.a0, 0.0f);
        this.h = obtainStyledAttributes.getDimension(da3.b0, 0.0f);
        this.i = obtainStyledAttributes.getInt(da3.Z, 0);
        obtainStyledAttributes.recycle();
        a();
        this.e = this.d * 2.0f;
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        this.o = new RectF();
    }

    public final void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setColor(this.c);
        this.a.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Path path = new Path();
        if (this.i == 0) {
            path.moveTo(this.g, this.d);
            path.arcTo(this.l, 180.0f, 90.0f);
            path.rLineTo((this.j - this.g) - this.e, 0.0f);
            path.arcTo(this.n, -90.0f, 90.0f);
            path.rLineTo(0.0f, this.k - this.e);
            path.arcTo(this.o, 0.0f, 90.0f);
            path.rLineTo((-this.j) + this.e + this.g, 0.0f);
            path.arcTo(this.m, 90.0f, 90.0f);
            path.rLineTo(0.0f, (-this.k) + this.h + (this.f / 2.0f) + this.d);
            path.rLineTo(-this.g, (-this.f) / 2.0f);
            path.rLineTo(this.g, (-this.f) / 2.0f);
        } else {
            path.moveTo(this.j - this.g, this.d);
            path.arcTo(this.n, 0.0f, -90.0f);
            path.rLineTo((-this.j) + this.g + this.e, 0.0f);
            path.arcTo(this.l, 270.0f, -90.0f);
            path.rLineTo(0.0f, this.k - this.e);
            path.arcTo(this.m, 180.0f, -90.0f);
            path.rLineTo((this.j - this.g) - this.e, 0.0f);
            path.arcTo(this.o, 90.0f, -90.0f);
            path.rLineTo(0.0f, (-this.k) + this.h + (this.f / 2.0f) + this.d);
            path.rLineTo(this.g, (-this.f) / 2.0f);
            path.rLineTo(-this.g, (-this.f) / 2.0f);
        }
        path.close();
        canvas.drawPath(path, this.a);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = i;
        this.k = i2;
        int i5 = this.i;
        RectF rectF = this.l;
        if (i5 == 0) {
            float f = this.g;
            rectF.left = f;
            rectF.top = 0.0f;
            float f2 = this.e;
            rectF.right = f + f2;
            rectF.bottom = f2;
            RectF rectF2 = this.m;
            rectF2.left = f;
            rectF2.top = i2 - f2;
            rectF2.right = f + f2;
            rectF2.bottom = i2;
            RectF rectF3 = this.n;
            rectF3.left = i - f2;
            rectF3.top = 0.0f;
            rectF3.right = i;
            rectF3.bottom = f2;
            RectF rectF4 = this.o;
            rectF4.left = i - f2;
            rectF4.top = i2 - f2;
            rectF4.right = i;
            rectF4.bottom = i2;
            return;
        }
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        float f3 = this.e;
        rectF.right = f3;
        rectF.bottom = f3;
        RectF rectF5 = this.m;
        rectF5.left = 0.0f;
        rectF5.top = i2 - f3;
        rectF5.right = f3;
        rectF5.bottom = i2;
        RectF rectF6 = this.n;
        float f4 = this.g;
        rectF6.left = (i - f4) - f3;
        rectF6.top = 0.0f;
        rectF6.right = i - f4;
        rectF6.bottom = f3;
        RectF rectF7 = this.o;
        rectF7.left = (i - f4) - f3;
        rectF7.top = i2 - f3;
        rectF7.right = i - f4;
        rectF7.bottom = i2;
    }
}
