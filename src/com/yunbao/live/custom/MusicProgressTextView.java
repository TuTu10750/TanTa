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
public class MusicProgressTextView extends AppCompatTextView {
    public String h;
    public String i;
    public int j;
    public int k;
    public int l;
    public RectF m;
    public int n;
    public Paint o;
    public Paint p;
    public Paint q;
    public boolean r;

    public MusicProgressTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicProgressTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.O1);
        this.h = obtainStyledAttributes.getString(ha3.S1);
        this.i = obtainStyledAttributes.getString(ha3.Q1);
        this.j = obtainStyledAttributes.getColor(ha3.P1, 0);
        this.k = obtainStyledAttributes.getColor(ha3.R1, 0);
        obtainStyledAttributes.recycle();
        s();
    }

    private void s() {
        Paint paint = new Paint();
        this.o = paint;
        paint.setAntiAlias(true);
        this.o.setDither(true);
        Paint paint2 = this.o;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.o.setColor(this.j);
        Paint paint3 = new Paint();
        this.p = paint3;
        paint3.setAntiAlias(true);
        this.p.setDither(true);
        this.p.setStyle(style);
        this.p.setColor(this.k);
        Paint paint4 = new Paint();
        this.q = paint4;
        paint4.setAntiAlias(true);
        this.q.setDither(true);
        this.q.setStyle(style);
        this.q.setColor(this.k);
        this.m = new RectF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        if (this.r) {
            int i = this.l;
            if (i == 0) {
                int i2 = this.n;
                canvas.drawCircle(i2, i2, i2, this.o);
            } else {
                int i3 = this.n;
                if (i != 100) {
                    canvas.drawCircle(i3, i3, i3, this.o);
                    canvas2 = canvas;
                    canvas2.drawArc(this.m, -90.0f, (this.l * 360) / 100.0f, true, this.p);
                    super/*android.view.View*/.onDraw(canvas2);
                }
                canvas.drawCircle(i3, i3, i3, this.q);
            }
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
        this.n = i / 2;
        RectF rectF = this.m;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        float f = i;
        rectF.right = f;
        rectF.bottom = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setProgress(int i) {
        if (i > 100) {
            i = 100;
        }
        if (i < 0) {
            i = 0;
        }
        this.r = true;
        this.l = i;
        if (i == 0) {
            setText(this.h);
            return;
        }
        if (i == 100) {
            setText(this.i);
            return;
        }
        setText(i + "%");
    }
}
