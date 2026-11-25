package com.yunbao.common.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;

/* loaded from: /tmp/classes2.dex */
public class CoinGiveLayout extends FrameLayout {
    public Paint a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public int h;
    public RectF i;

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.drawRoundRect(this.i, this.b, this.c, this.a);
        if (this.e > 0.0f && this.d > 0.0f) {
            Path path = new Path();
            path.moveTo((this.g - this.d) - this.f, this.h - this.e);
            path.rLineTo(0.0f, this.e);
            path.rLineTo(this.d, -this.e);
            path.close();
            canvas.drawPath(path, this.a);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = i;
        this.h = i2;
        RectF rectF = this.i;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = i;
        float f = i2 - this.e;
        rectF.bottom = f > 0.0f ? f : 0.0f;
    }
}
