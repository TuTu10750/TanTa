package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import defpackage.o53;
import defpackage.w53;

/* loaded from: /tmp/classes2.dex */
public class HorizontalProgressWheelView extends View {
    public final Rect a;
    public a b;
    public float c;
    public Paint d;
    public Paint e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public float j;
    public int k;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a();

        void b(float f, float f2);

        void c();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Rect();
        a();
    }

    public final void a() {
        this.k = o60.b(getContext(), o53.m);
        this.f = getContext().getResources().getDimensionPixelSize(w53.i);
        this.g = getContext().getResources().getDimensionPixelSize(w53.f);
        this.h = getContext().getResources().getDimensionPixelSize(w53.g);
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.f);
        this.d.setColor(getResources().getColor(o53.g));
        Paint paint2 = new Paint(this.d);
        this.e = paint2;
        paint2.setColor(this.k);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        this.e.setStrokeWidth(getContext().getResources().getDimensionPixelSize(w53.j));
    }

    public final void b(MotionEvent motionEvent, float f) {
        this.j -= f;
        postInvalidate();
        this.c = motionEvent.getX();
        a aVar = this.b;
        if (aVar != null) {
            aVar.b(-f, this.j);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.a);
        int width = this.a.width() / (this.f + this.h);
        float f = this.j % (r3 + r2);
        for (int i = 0; i < width; i++) {
            int i2 = width / 4;
            if (i < i2) {
                this.d.setAlpha((int) ((i / i2) * 255.0f));
            } else {
                int i3 = (width * 3) / 4;
                Paint paint = this.d;
                if (i > i3) {
                    paint.setAlpha((int) (((width - i) / i2) * 255.0f));
                } else {
                    paint.setAlpha(255);
                }
            }
            float f2 = -f;
            Rect rect = this.a;
            Rect rect2 = this.a;
            canvas.drawLine(rect.left + f2 + ((this.f + this.h) * i), rect.centerY() - (this.g / 4.0f), f2 + rect2.left + ((this.f + this.h) * i), rect2.centerY() + (this.g / 4.0f), this.d);
        }
        canvas.drawLine(this.a.centerX(), this.a.centerY() - (this.g / 2.0f), this.a.centerX(), (this.g / 2.0f) + this.a.centerY(), this.e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getX();
        } else if (action == 1) {
            a aVar = this.b;
            if (aVar != null) {
                this.i = false;
                aVar.a();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.c;
            if (x != 0.0f) {
                if (!this.i) {
                    this.i = true;
                    a aVar2 = this.b;
                    if (aVar2 != null) {
                        aVar2.c();
                    }
                }
                b(motionEvent, x);
            }
        }
        return true;
    }

    public void setMiddleLineColor(int i) {
        this.k = i;
        this.e.setColor(i);
        invalidate();
    }

    public void setScrollingListener(a aVar) {
        this.b = aVar;
    }
}
