package com.yunbao.main.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import defpackage.k03;
import defpackage.zh1;
import defpackage.zn0;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class CurvedLinePagerIndicator extends View implements zh1 {
    public Paint a;
    public Path b;
    public int c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public List k;

    public CurvedLinePagerIndicator(Context context) {
        super(context);
        this.d = 1;
        this.h = -1.0f;
        this.i = 1.0f;
        e();
    }

    @Override // defpackage.zh1
    public void a(int i, float f, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        List list = this.k;
        if (list == null || list.isEmpty()) {
            return;
        }
        k03 k03Var = (k03) this.k.get(i);
        int i3 = k03Var.a;
        int i4 = this.e;
        float f6 = i3 + i4;
        float f7 = k03Var.c - i4;
        if (i < this.k.size() - 1) {
            k03 k03Var2 = (k03) this.k.get(i + 1);
            int i5 = k03Var2.a;
            int i6 = this.e;
            f3 = i5 + i6;
            f2 = k03Var2.c - i6;
        } else {
            f2 = f7;
            f3 = f6;
        }
        float f8 = ((f3 - f6) * f) + f6;
        float f9 = ((f2 - f7) * f) + f7;
        float height = (getHeight() - (this.g / 2.0f)) - zn0.a(4);
        float f10 = this.j + height;
        float f11 = this.h;
        if (f11 > 0.0f) {
            float f12 = f8 + ((f9 - f8) / 2.0f);
            f4 = f12 - (f11 / 2.0f);
            f5 = f12 + (f11 / 2.0f);
        } else {
            float f13 = ((f6 + f7) / 2.0f) + ((((f3 + f2) / 2.0f) * f) / 2.0f);
            float f14 = ((f7 - f6) * this.i) / 2.0f;
            f4 = f13 - f14;
            f5 = f13 + f14;
        }
        this.b.reset();
        this.b.moveTo(f4, height);
        this.b.quadTo(f4 + ((f5 - f4) / 2.0f), f10, f5, height);
        invalidate();
    }

    @Override // defpackage.zh1
    public void b(int i) {
    }

    @Override // defpackage.zh1
    public void c(int i) {
    }

    @Override // defpackage.zh1
    public void d(List list) {
        this.k = list;
    }

    public final void e() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b = new Path();
        this.c = -16777216;
        this.g = zn0.a(3);
        this.j = zn0.a(5);
        this.a.setStrokeWidth(this.g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Path path = this.b;
        if (path != null) {
            canvas.drawPath(path, this.a);
        }
    }

    public void setColors(int... iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        int i = iArr[0];
        this.c = i;
        this.a.setColor(i);
        invalidate();
    }

    public void setCurveHeight(float f) {
        this.j = zn0.a((int) f);
        invalidate();
    }

    public void setLineHeight(float f) {
        this.g = f;
        this.a.setStrokeWidth(f);
        invalidate();
    }

    public void setLineScale(float f) {
        this.i = f;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.h = zn0.a((int) f);
        invalidate();
    }

    public void setMode(int i) {
        this.d = i;
        invalidate();
    }

    public void setRoundRadius(float f) {
        this.f = f;
        invalidate();
    }

    public void setXOffset(int i) {
        this.e = i;
        invalidate();
    }
}
