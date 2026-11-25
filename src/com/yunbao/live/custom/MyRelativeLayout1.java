package com.yunbao.live.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import defpackage.ha3;

/* loaded from: /tmp/classes2.dex */
public class MyRelativeLayout1 extends RelativeLayout {
    public int a;
    public int b;
    public Paint c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;

    public MyRelativeLayout1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyRelativeLayout1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.a2);
        this.d = (int) obtainStyledAttributes.getDimension(ha3.k2, 0.0f);
        this.e = obtainStyledAttributes.getColor(ha3.b2, -16777216);
        this.f = (int) obtainStyledAttributes.getDimension(ha3.e2, 0.0f);
        this.g = (int) obtainStyledAttributes.getDimension(ha3.c2, 0.0f);
        this.h = (int) obtainStyledAttributes.getDimension(ha3.d2, 0.0f);
        this.i = (int) obtainStyledAttributes.getDimension(ha3.f2, 0.0f);
        this.j = (int) obtainStyledAttributes.getDimension(ha3.g2, 0.0f);
        this.k = (int) obtainStyledAttributes.getDimension(ha3.i2, 0.0f);
        this.l = (int) obtainStyledAttributes.getDimension(ha3.j2, 0.0f);
        this.m = (int) obtainStyledAttributes.getDimension(ha3.h2, 0.0f);
        obtainStyledAttributes.recycle();
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setDither(true);
        this.c.setAntiAlias(true);
        this.c.setColor(this.e);
        this.c.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, this.a, this.b);
        int i = this.d;
        Path.Direction direction = Path.Direction.CW;
        path.addRoundRect(rectF, i, i, direction);
        Path path2 = new Path();
        RectF rectF2 = new RectF(this.i, this.j, r3 + this.f, r5 + this.g);
        int i2 = this.h;
        path2.addRoundRect(rectF2, i2, i2, direction);
        Path path3 = new Path();
        int i3 = this.j + this.g + this.l;
        path3.addRect(this.k, i3, this.a - r3, i3 + this.m, direction);
        Path.Op op = Path.Op.DIFFERENCE;
        path.op(path2, op);
        path.op(path3, op);
        canvas.drawPath(path, this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i;
        this.b = i2;
    }
}
