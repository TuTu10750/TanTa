package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import defpackage.da3;
import defpackage.lx1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class SideIndexBar extends View {
    public float a;
    public int b;
    public List c;
    public Map d;
    public int e;
    public float f;
    public Paint g;
    public Paint h;
    public a i;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(int i);
    }

    public SideIndexBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SideIndexBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.Q3);
        int color = obtainStyledAttributes.getColor(da3.R3, 0);
        int color2 = obtainStyledAttributes.getColor(da3.U3, 0);
        this.b = (int) obtainStyledAttributes.getDimension(da3.S3, 0.0f);
        this.a = obtainStyledAttributes.getDimension(da3.T3, 0.0f);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(color2);
        Paint paint2 = this.g;
        Paint.Align align = Paint.Align.CENTER;
        paint2.setTextAlign(align);
        this.g.setTextSize(this.b);
        Paint paint3 = new Paint(1);
        this.h = paint3;
        paint3.setTextAlign(align);
        this.h.setColor(color);
        this.h.setTextSize(this.b);
    }

    public final int a(float f) {
        float f2 = this.f;
        if (f2 == 0.0f) {
            return -1;
        }
        int i = (int) (f / f2);
        if (i < 0) {
            return 0;
        }
        return i > this.c.size() + (-1) ? this.c.size() - 1 : i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List list = this.c;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f = getHeight() / this.c.size();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            int i2 = this.e;
            List list2 = this.c;
            if (i2 == i) {
                String str = (String) list2.get(i);
                float width = getWidth() / 2;
                float f = this.f;
                canvas.drawText(str, width, (0.85f * f) + (f * i), this.h);
            } else {
                String str2 = (String) list2.get(i);
                float width2 = getWidth() / 2;
                float f2 = this.f;
                canvas.drawText(str2, width2, (0.85f * f2) + (f2 * i), this.g);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        List list = this.c;
        if (list == null || list.size() <= 0) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) ((this.c.size() * this.b) + ((this.c.size() + 1) * this.a)), 1073741824));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a2 = a(motionEvent.getY());
        if (a2 < 0) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return true;
        }
        setSelectionPosition(a2);
        if (this.i == null) {
            return true;
        }
        lx1.c("SideIndexBar", "----touchPos---->" + a2 + "---word--->" + ((String) this.c.get(a2)));
        this.i.a(a2);
        return true;
    }

    public void setActionListener(a aVar) {
        this.i = aVar;
    }

    public void setData(List<String> list) {
        Map map = this.d;
        if (map == null) {
            this.d = new HashMap();
        } else {
            map.clear();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.d.put(list.get(i), Integer.valueOf(i));
        }
        this.c = list;
        requestLayout();
    }

    public void setSelectionIndex(String str) {
        Integer num;
        Map map = this.d;
        if (map == null || (num = (Integer) map.get(str)) == null) {
            return;
        }
        setSelectionPosition(num.intValue());
    }

    public void setSelectionPosition(int i) {
        if (this.e != i) {
            this.e = i;
            invalidate();
        }
    }
}
