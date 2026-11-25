package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class LineProgress extends View {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Paint f;
    public Paint g;
    public float h;
    public float[] i;

    public LineProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.T1);
        this.b = obtainStyledAttributes.getColor(da3.W1, 0);
        this.c = obtainStyledAttributes.getColor(da3.U1, 0);
        this.d = obtainStyledAttributes.getInt(da3.X1, 2);
        this.e = obtainStyledAttributes.getInt(da3.V1, 0);
        this.h = obtainStyledAttributes.getDimension(da3.Y1, 0.0f);
        this.i = new float[this.d];
        obtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setColor(this.c);
        Paint paint2 = this.f;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.f.setStrokeWidth(this.h);
        Paint paint3 = new Paint();
        this.g = paint3;
        paint3.setAntiAlias(true);
        this.g.setDither(true);
        this.g.setColor(this.b);
        this.g.setStyle(style);
        this.g.setStrokeWidth(this.h);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i = 0; i < this.d; i++) {
            int i2 = this.e - 1;
            float[] fArr = this.i;
            if (i <= i2) {
                float f = fArr[i];
                canvas.drawLine(f, 0.0f, f, this.a, this.g);
            } else {
                float f2 = fArr[i];
                canvas.drawLine(f2, 0.0f, f2, this.a, this.f);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        this.a = i2;
        float f = this.h;
        if (f <= 0.0f || (i5 = this.d) <= 1) {
            return;
        }
        float f2 = (i - (i5 * f)) / (i5 - 1);
        float f3 = f / 2.0f;
        for (int i6 = 0; i6 < this.d; i6++) {
            this.i[i6] = (i6 * (this.h + f2)) + f3;
        }
    }

    public void setProgress(int i) {
        this.e = i;
        int i2 = this.d;
        if (i > i2) {
            this.e = i2;
        }
        invalidate();
    }
}
