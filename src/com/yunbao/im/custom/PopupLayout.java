package com.yunbao.im.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.ga3;

/* loaded from: /tmp/classes2.dex */
public class PopupLayout extends FrameLayout {
    public int a;
    public float b;
    public int c;
    public int d;
    public float e;
    public float f;
    public int g;
    public int h;
    public Paint i;
    public Paint j;
    public RectF k;
    public RectF l;
    public RectF m;
    public RectF n;
    public float o;
    public int p;

    public PopupLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ga3.a2);
        this.a = obtainStyledAttributes.getColor(ga3.d2, 0);
        this.b = obtainStyledAttributes.getDimension(ga3.e2, 0.0f);
        this.c = (int) obtainStyledAttributes.getDimension(ga3.g2, 0.0f);
        this.d = obtainStyledAttributes.getColor(ga3.f2, 0);
        this.e = obtainStyledAttributes.getDimension(ga3.c2, 0.0f);
        this.f = obtainStyledAttributes.getDimension(ga3.b2, 0.0f);
        obtainStyledAttributes.recycle();
        a();
        this.k = new RectF();
        this.l = new RectF();
        this.m = new RectF();
        this.n = new RectF();
        this.o = this.b * 2.0f;
        this.p = this.c / 2;
    }

    public final void a() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setAntiAlias(true);
        this.i.setDither(true);
        this.i.setColor(this.a);
        this.i.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setAntiAlias(true);
        this.j.setDither(true);
        this.j.setStrokeWidth(this.c);
        this.j.setColor(this.d);
        this.j.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f > 0.0f && this.e > 0.0f) {
            Path path = new Path();
            path.moveTo(this.g / 2, this.h - this.p);
            path.rLineTo((-this.e) / 2.0f, -this.f);
            path.rLineTo(((-this.g) / 2) + this.b + (this.e / 2.0f) + this.p, 0.0f);
            path.arcTo(this.l, 90.0f, 90.0f);
            path.rLineTo(0.0f, (-this.h) + this.f + this.o + (this.p * 2));
            path.arcTo(this.k, 180.0f, 90.0f);
            path.rLineTo((this.g - this.o) - (this.p * 2), 0.0f);
            path.arcTo(this.m, -90.0f, 90.0f);
            path.rLineTo(0.0f, ((this.h - this.f) - this.o) - (this.p * 2));
            path.arcTo(this.n, 0.0f, 90.0f);
            path.rLineTo(((-this.g) / 2) + this.b + (this.e / 2.0f) + this.p, 0.0f);
            path.close();
            canvas.drawPath(path, this.i);
            canvas.drawPath(path, this.j);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = i;
        this.h = i2;
        RectF rectF = this.k;
        int i5 = this.p;
        float f = i5;
        rectF.left = f;
        float f2 = i5;
        rectF.top = f2;
        float f3 = this.o;
        rectF.right = f + f3;
        rectF.bottom = f2 + f3;
        RectF rectF2 = this.m;
        float f4 = i5;
        rectF2.top = f4;
        float f5 = i - i5;
        rectF2.right = f5;
        rectF2.left = f5 - f3;
        rectF2.bottom = f4 + f3;
        RectF rectF3 = this.l;
        float f6 = i5;
        rectF3.left = f6;
        rectF3.right = f6 + f3;
        float f7 = this.f;
        float f8 = (i2 - f7) - i5;
        rectF3.bottom = f8;
        rectF3.top = f8 - f3;
        RectF rectF4 = this.n;
        float f9 = i - i5;
        rectF4.right = f9;
        rectF4.left = f9 - f3;
        float f10 = (i2 - f7) - i5;
        rectF4.bottom = f10;
        rectF4.top = f10 - f3;
    }
}
