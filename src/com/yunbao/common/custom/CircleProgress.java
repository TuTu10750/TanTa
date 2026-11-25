package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class CircleProgress extends View {
    public float a;
    public float b;
    public int c;
    public int d;
    public float e;
    public float f;
    public Paint g;
    public Paint h;
    public float i;
    public RectF j;

    public CircleProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.m0);
        this.c = obtainStyledAttributes.getColor(da3.n0, 0);
        this.d = obtainStyledAttributes.getColor(da3.p0, 0);
        this.a = obtainStyledAttributes.getDimension(da3.r0, 0.0f);
        this.e = obtainStyledAttributes.getFloat(da3.q0, 0.0f);
        this.f = obtainStyledAttributes.getFloat(da3.o0, 0.0f);
        obtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.g.setDither(true);
        this.g.setColor(this.c);
        Paint paint2 = this.g;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.g.setStrokeWidth(this.a);
        Paint paint3 = new Paint();
        this.h = paint3;
        paint3.setAntiAlias(true);
        this.h.setDither(true);
        this.h.setColor(this.d);
        this.h.setStyle(style);
        this.h.setStrokeWidth(this.a);
        this.j = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f = this.i;
        canvas.drawCircle(f, f, this.b, this.g);
        float f2 = this.e;
        if (f2 > 0.0f) {
            float f3 = this.f;
            if (f3 > 0.0f) {
                canvas.drawArc(this.j, -90.0f, (f3 / f2) * 360.0f, false, this.h);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float f = this.a / 2.0f;
        float f2 = i / 2;
        this.i = f2;
        this.b = f2 - f;
        RectF rectF = new RectF();
        this.j = rectF;
        rectF.left = f;
        rectF.top = f;
        float f3 = i - f;
        rectF.right = f3;
        rectF.bottom = f3;
    }

    public void setCurProgress(float f) {
        this.f = f;
        invalidate();
    }

    public void setMaxProgress(float f) {
        this.e = f;
    }
}
