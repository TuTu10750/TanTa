package com.yunbao.live.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.ha3;
import defpackage.lx1;
import defpackage.mj;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class FrameImageView extends AppCompatImageView {
    public float d;
    public Bitmap e;
    public List f;
    public int g;
    public Paint h;
    public Rect i;
    public Rect j;
    public boolean k;

    public FrameImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrameImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.B0);
        this.d = obtainStyledAttributes.getFloat(ha3.C0, 0.0f);
        obtainStyledAttributes.recycle();
        this.h = new Paint();
        Paint paint = new Paint();
        this.h = paint;
        paint.setDither(true);
        this.h.setAntiAlias(true);
        this.i = new Rect();
        this.j = new Rect();
        this.g = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(int i) {
        List list = this.f;
        if (list == null || i > list.size() - 1 || this.g == i) {
            return;
        }
        this.g = i;
        lx1.b("FrameImageView----index---->" + i);
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap a = mj.b().a(((Integer) this.f.get(i)).intValue());
        this.e = a;
        this.j.right = a.getWidth();
        this.j.bottom = this.e.getHeight();
        this.k = true;
        invalidate();
    }

    public void d() {
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        if (!this.k) {
            super/*android.view.View*/.onDraw(canvas);
            return;
        }
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.j, this.i, this.h);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        super/*android.view.View*/.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.d), 1073741824));
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Rect rect = this.i;
        rect.left = 0;
        rect.top = 0;
        rect.right = i;
        rect.bottom = i2;
        Rect rect2 = this.j;
        rect2.left = 0;
        rect2.top = 0;
    }

    public void setImageDrawable(Drawable drawable) {
        this.k = false;
        super.setImageDrawable(drawable);
    }

    public void setImageList(List<Integer> list) {
        this.f = list;
    }

    public void setImageResource(int i) {
        this.k = false;
        super.setImageResource(i);
    }
}
