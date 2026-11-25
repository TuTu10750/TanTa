package com.yunbao.video.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import defpackage.ia3;

/* loaded from: /tmp/classes2.dex */
public class VideoRecordBtnView extends View {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Paint f;
    public int g;
    public Path h;
    public Path i;

    public VideoRecordBtnView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoRecordBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ia3.q3);
        this.a = (int) obtainStyledAttributes.getDimension(ia3.s3, 0.0f);
        this.b = (int) obtainStyledAttributes.getDimension(ia3.t3, 0.0f);
        this.c = (int) obtainStyledAttributes.getDimension(ia3.u3, 0.0f);
        int color = obtainStyledAttributes.getColor(ia3.r3, 0);
        obtainStyledAttributes.recycle();
        this.d = 100;
        this.e = this.c;
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setColor(color);
        this.f.setStyle(Paint.Style.FILL);
        this.h = new Path();
        this.i = new Path();
    }

    public final int a() {
        return (int) (this.b + (((this.a - r0) * this.d) / 100.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.h.reset();
        Path path = this.h;
        int i = this.g;
        Path.Direction direction = Path.Direction.CW;
        path.addCircle(i, i, i, direction);
        this.i.reset();
        Path path2 = this.i;
        int i2 = this.g;
        path2.addCircle(i2, i2, i2 - this.e, direction);
        this.h.op(this.i, Path.Op.DIFFERENCE);
        canvas.drawPath(this.h, this.f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.g = i / 2;
    }

    public void setRate(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        if (this.d == i) {
            return;
        }
        this.d = i;
        int a = a();
        if (this.e == a) {
            return;
        }
        this.e = a;
        invalidate();
    }
}
