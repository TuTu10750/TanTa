package com.yunbao.video.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import defpackage.ia3;

/* loaded from: /tmp/classes2.dex */
public class VideoLoadingBar extends View {
    public int a;
    public RectF b;
    public Paint c;
    public Paint d;
    public RectF e;
    public float f;
    public boolean g;
    public int h;
    public int i;

    public VideoLoadingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ia3.X0);
        this.h = obtainStyledAttributes.getColor(ia3.Y0, -16777216);
        this.i = obtainStyledAttributes.getColor(ia3.Z0, -1);
        obtainStyledAttributes.recycle();
        b();
    }

    public void a() {
        this.g = false;
        this.f = 0.0f;
    }

    public final void b() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(this.h);
        Paint paint2 = this.c;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.b = new RectF();
        Paint paint3 = new Paint();
        this.d = paint3;
        paint3.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setColor(this.i);
        this.d.setStyle(style);
        this.e = new RectF();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.b;
        rectF.left = 0.0f;
        rectF.right = this.a;
        canvas.drawRect(rectF, this.c);
        if (this.g) {
            if (this.f > 1.0f) {
                this.f = 1.0f;
            }
            float f = this.f;
            int i = this.a;
            float f2 = f * i;
            float f3 = (i - f2) / 2.0f;
            RectF rectF2 = this.e;
            rectF2.left = f3;
            rectF2.right = f3 + f2;
            canvas.drawRect(rectF2, this.d);
            float f4 = this.f;
            if (f4 < 1.0f) {
                this.f = f4 + 0.1f;
                postInvalidateDelayed(20L);
            } else {
                this.f = 0.0f;
                postInvalidateDelayed(150L);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        RectF rectF = this.b;
        rectF.top = 0.0f;
        float f = measuredHeight;
        rectF.bottom = f;
        RectF rectF2 = this.e;
        rectF2.top = 0.0f;
        rectF2.bottom = f;
    }

    public void setLoading(boolean z) {
        if (this.g != z) {
            this.g = z;
            this.f = 0.0f;
            invalidate();
        }
    }
}
