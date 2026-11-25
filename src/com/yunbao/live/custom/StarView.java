package com.yunbao.live.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import defpackage.t83;

/* loaded from: /tmp/classes2.dex */
public class StarView extends View {
    public Context a;
    public int b;
    public float c;
    public int d;
    public Paint e;

    public StarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        this.c = context.getResources().getDisplayMetrics().density;
        this.d = a(14);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setDither(true);
    }

    public final int a(int i) {
        return (int) ((i * this.c) + 0.5f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = ((BitmapDrawable) o60.d(this.a, t83.A0)).getBitmap();
        if (bitmap != null) {
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            int i = this.b;
            int i2 = this.d;
            canvas.drawBitmap(bitmap, rect, new Rect(i - i2, 0, i, i2), this.e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.b = i;
    }
}
