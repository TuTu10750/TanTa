package com.yunbao.live.music;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.ha3;

/* loaded from: /tmp/classes2.dex */
public class LrcTextView extends AppCompatTextView {
    public float h;
    public int i;
    public int j;
    public int k;
    public Paint l;
    public String m;
    public Paint.FontMetricsInt n;
    public boolean o;

    public LrcTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LrcTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.e1);
        this.h = obtainStyledAttributes.getFloat(ha3.f1, 0.0f);
        this.i = obtainStyledAttributes.getColor(ha3.g1, 0);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        this.l.setDither(true);
        this.l.setColor(this.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        super/*android.view.View*/.onDraw(canvas);
        if (!this.o) {
            this.o = true;
            this.l.setTextSize(getTextSize());
        }
        if (this.n == null) {
            this.n = getPaint().getFontMetricsInt();
        }
        Paint.FontMetricsInt fontMetricsInt = this.n;
        int i = fontMetricsInt.bottom;
        int height = (((((i - fontMetricsInt.top) / 2) - i) + (getHeight() / 2)) + (getPaddingTop() / 2)) - (getPaddingBottom() / 2);
        canvas.save();
        canvas.clipRect(0, 0, (int) (this.h * this.j), this.k);
        canvas.drawText(this.m, 0.0f, height, this.l);
        canvas.restore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.view.View*/.onSizeChanged(i, i2, i3, i4);
        this.j = i;
        this.k = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setProgress(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.h = f;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super/*android.widget.TextView*/.setText(charSequence, bufferType);
        this.m = charSequence.toString();
    }
}
