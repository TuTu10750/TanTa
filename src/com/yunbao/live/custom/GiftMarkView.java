package com.yunbao.live.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/* loaded from: /tmp/classes2.dex */
public class GiftMarkView extends View {
    public Context a;
    public int b;
    public int c;
    public int d;
    public Paint e;
    public int f;
    public int g;
    public int h;

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.c;
        if (i != 0) {
            Bitmap bitmap = ((BitmapDrawable) o60.d(this.a, i)).getBitmap();
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.f, this.h), this.e);
        }
        int i2 = this.d;
        if (i2 != 0) {
            Bitmap bitmap2 = ((BitmapDrawable) o60.d(this.a, i2)).getBitmap();
            Rect rect = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            int i3 = this.b;
            canvas.drawBitmap(bitmap2, rect, new Rect(i3 - this.g, 0, i3, this.h), this.e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.b = i;
    }
}
