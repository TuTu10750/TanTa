package com.yunbao.game.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import defpackage.r83;
import defpackage.yh1;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* loaded from: /tmp/classes2.dex */
public class LuckPanView extends View {
    public Paint a;
    public BitmapFactory.Options b;
    public int c;
    public a[] d;
    public int e;
    public int f;
    public float g;
    public Rect h;

    /* loaded from: /tmp/classes2.dex */
    public class a {
        public Bitmap a;
        public Rect b;

        public a(Bitmap bitmap) {
            this.a = bitmap;
            this.b = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public LuckPanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LuckPanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = context.getResources().getDisplayMetrics().density;
        c();
    }

    public final int a(int i) {
        return (int) ((this.g * i) + 0.5f);
    }

    public final Bitmap b(int i) {
        Bitmap bitmap;
        try {
            byte[] c = yh1.c(getResources().openRawResource(i));
            bitmap = BitmapFactory.decodeByteArray(c, 0, c.length, this.b);
        } catch (IOException e) {
            e.printStackTrace();
            bitmap = null;
        }
        return (Bitmap) new SoftReference(bitmap).get();
    }

    public final void c() {
        this.e = a(40);
        this.f = a(45);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.b = options;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 1;
        a[] aVarArr = new a[4];
        this.d = aVarArr;
        aVarArr[0] = new a(b(r83.m));
        this.d[1] = new a(b(r83.n));
        this.d[2] = new a(b(r83.o));
        this.d[3] = new a(b(r83.p));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 20; i++) {
            canvas.save();
            int i2 = this.c;
            canvas.translate(i2, i2);
            int i3 = i % 4;
            canvas.rotate(i * 18, 0.0f, 0.0f);
            canvas.drawBitmap(this.d[i3].a, this.d[i3].b, this.h, this.a);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i / 2;
        this.c = i5;
        int i6 = this.e;
        int i7 = -((int) (i5 * 0.6f));
        this.h = new Rect((-i6) / 2, i7 - this.f, i6 / 2, i7);
    }
}
