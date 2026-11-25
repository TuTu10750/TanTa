package com.yunbao.live.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import defpackage.ha3;

/* loaded from: /tmp/classes2.dex */
public class PkProgressBar extends View {
    public Paint a;
    public Paint b;
    public Paint c;
    public Paint d;
    public int e;
    public float f;
    public int g;
    public int h;
    public int i;
    public int j;
    public Rect k;
    public Rect l;
    public int m;
    public float n;

    public PkProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.A2);
        this.e = (int) obtainStyledAttributes.getDimension(ha3.D2, 0.0f);
        this.f = obtainStyledAttributes.getFloat(ha3.E2, 0.5f);
        this.g = obtainStyledAttributes.getColor(ha3.B2, 0);
        this.h = obtainStyledAttributes.getColor(ha3.F2, 0);
        this.i = obtainStyledAttributes.getColor(ha3.C2, 0);
        this.j = obtainStyledAttributes.getColor(ha3.G2, 0);
        obtainStyledAttributes.recycle();
        c();
    }

    public final void a() {
        int i = this.m;
        int i2 = (int) (i * this.f);
        int i3 = this.e;
        if (i2 < i3) {
            i2 = i3;
        }
        if (i2 > i - i3) {
            i2 = i - i3;
        }
        this.k.right = i2;
        this.l.left = i2;
    }

    public final int b(int i) {
        return (int) ((i * this.n) + 0.5f);
    }

    public final void c() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        Paint paint2 = this.a;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.a.setColor(this.g);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setDither(true);
        Paint paint4 = this.c;
        Paint.Style style2 = Paint.Style.STROKE;
        paint4.setStyle(style2);
        this.c.setStrokeWidth(b(1));
        this.c.setColor(this.i);
        Paint paint5 = new Paint();
        this.b = paint5;
        paint5.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setStyle(style);
        this.b.setColor(this.h);
        Paint paint6 = new Paint();
        this.d = paint6;
        paint6.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStyle(style2);
        this.d.setStrokeWidth(b(1));
        this.d.setColor(this.j);
        this.k = new Rect();
        this.l = new Rect();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawRect(this.k, this.a);
        canvas.drawRect(this.k, this.c);
        canvas.drawRect(this.l, this.b);
        canvas.drawRect(this.l, this.d);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.m = i;
        Rect rect = this.k;
        rect.left = 0;
        rect.top = 0;
        rect.bottom = i2;
        Rect rect2 = this.l;
        rect2.top = 0;
        rect2.right = i;
        rect2.bottom = i2;
        a();
    }

    public void setProgress(float f) {
        if (this.f == f) {
            return;
        }
        this.f = f;
        a();
        invalidate();
    }
}
