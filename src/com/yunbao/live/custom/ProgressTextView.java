package com.yunbao.live.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.ha3;

/* loaded from: /tmp/classes2.dex */
public class ProgressTextView extends AppCompatTextView {
    public int h;
    public int i;
    public int j;
    public RectF k;
    public int l;
    public int m;
    public Paint n;
    public Paint o;
    public int p;

    public ProgressTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.O2);
        this.h = obtainStyledAttributes.getColor(ha3.P2, 0);
        this.i = obtainStyledAttributes.getColor(ha3.Q2, 0);
        this.j = (int) obtainStyledAttributes.getDimension(ha3.S2, 0.0f);
        this.p = obtainStyledAttributes.getInteger(ha3.R2, 10);
        obtainStyledAttributes.recycle();
        s();
    }

    private void s() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setDither(true);
        Paint paint2 = this.n;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.n.setColor(this.h);
        this.n.setStrokeWidth(this.j);
        Paint paint3 = new Paint();
        this.o = paint3;
        paint3.setAntiAlias(true);
        this.o.setDither(true);
        this.o.setStyle(style);
        this.o.setColor(this.i);
        this.o.setStrokeWidth(this.j);
        this.k = new RectF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        int i = this.p;
        if (i == 0) {
            int i2 = this.m;
            canvas.drawCircle(i2, i2, this.l, this.n);
        } else {
            int i3 = this.m;
            if (i != 10) {
                canvas.drawCircle(i3, i3, this.l, this.n);
                canvas2 = canvas;
                canvas2.drawArc(this.k, -90.0f, (this.p * 360) / 10.0f, false, this.o);
                super/*android.view.View*/.onDraw(canvas2);
            }
            canvas.drawCircle(i3, i3, this.l, this.o);
        }
        canvas2 = canvas;
        super/*android.view.View*/.onDraw(canvas2);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.view.View*/.onSizeChanged(i, i2, i3, i4);
        int i5 = i / 2;
        this.m = i5;
        int i6 = this.j / 2;
        this.l = i5 - i6;
        RectF rectF = this.k;
        float f = i6;
        rectF.left = f;
        rectF.top = f;
        float f2 = i - i6;
        rectF.right = f2;
        rectF.bottom = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setProgress(int i) {
        if (i > 10) {
            i = 10;
        }
        if (i < 0) {
            i = 0;
        }
        if (this.p == i) {
            return;
        }
        this.p = i;
        setText(String.valueOf(i));
    }
}
