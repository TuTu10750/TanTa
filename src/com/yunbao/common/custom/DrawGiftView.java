package com.yunbao.common.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class DrawGiftView extends View {
    public int a;
    public Paint b;
    public List c;
    public Bitmap d;
    public Rect e;
    public RectF f;
    public float g;
    public float h;
    public a i;
    public int j;
    public float k;
    public float l;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(int i);
    }

    public DrawGiftView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ArrayList();
        Paint paint = new Paint();
        this.b = paint;
        paint.setDither(true);
        this.b.setAntiAlias(true);
        this.e = new Rect();
        this.f = new RectF();
        this.g = context.getResources().getDisplayMetrics().widthPixels / 20;
    }

    public void a() {
        List list = this.c;
        if (list != null) {
            list.clear();
        }
        invalidate();
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this.c.size());
        }
    }

    public void b() {
        List list = this.c;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.c.remove(r0.size() - 1);
        invalidate();
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(this.c.size());
        }
    }

    public List<PointF> getPointList() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        List list = this.c;
        if (list == null || list.size() <= 0 || this.d == null || this.e == null || this.f == null) {
            return;
        }
        for (PointF pointF : this.c) {
            RectF rectF = this.f;
            float f = pointF.x;
            float f2 = this.g;
            rectF.left = f - f2;
            rectF.right = f + f2;
            float f3 = pointF.y;
            float f4 = this.h;
            rectF.top = f3 - f4;
            rectF.bottom = f3 + f4;
            canvas.drawBitmap(this.d, this.e, rectF, this.b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.j = getMeasuredHeight();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d == null) {
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.k = 0.0f;
            this.l = 0.0f;
            if (this.c.size() < 100) {
                this.c.add(new PointF(motionEvent.getX(), motionEvent.getY()));
                invalidate();
                a aVar = this.i;
                if (aVar != null) {
                    aVar.a(this.c.size());
                }
            }
            this.a = 0;
        } else if (action == 2 && this.k != x && this.l != y && motionEvent.getY() <= this.j && this.c.size() < 100) {
            int i = this.a + 1;
            this.a = i;
            if (i % 2 == 0) {
                this.c.add(new PointF(motionEvent.getX(), motionEvent.getY()));
                invalidate();
                a aVar2 = this.i;
                if (aVar2 != null) {
                    aVar2.a(this.c.size());
                }
            }
        }
        this.k = x;
        this.l = y;
        return true;
    }

    public void setActionListener(a aVar) {
        this.i = aVar;
    }

    public void setBitmap(Bitmap bitmap) {
        this.d = bitmap;
        if (bitmap != null) {
            Rect rect = this.e;
            if (rect != null) {
                rect.left = 0;
                rect.top = 0;
                rect.right = bitmap.getWidth();
                this.e.bottom = bitmap.getHeight();
            }
            this.h = (this.g / bitmap.getWidth()) * bitmap.getHeight();
        }
    }
}
