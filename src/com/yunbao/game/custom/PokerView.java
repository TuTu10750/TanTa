package com.yunbao.game.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import defpackage.ea3;
import defpackage.yh1;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* loaded from: /tmp/classes2.dex */
public class PokerView extends View {
    public Paint a;
    public Paint b;
    public BitmapFactory.Options c;
    public int d;
    public int e;
    public float f;
    public int g;
    public int h;
    public int i;
    public int j;
    public Rect[] k;
    public Bitmap[] l;
    public Rect m;
    public Bitmap n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public Rect t;
    public int u;
    public int v;
    public float w;
    public boolean x;
    public boolean y;
    public Interpolator z;

    public PokerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PokerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = 0;
        this.r = 0;
        this.f = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ea3.d2);
        this.o = obtainStyledAttributes.getResourceId(ea3.g2, 0);
        this.p = obtainStyledAttributes.getInteger(ea3.f2, 3);
        this.w = obtainStyledAttributes.getFloat(ea3.i2, 0.1f);
        this.j = obtainStyledAttributes.getInt(ea3.e2, 0);
        this.x = obtainStyledAttributes.getBoolean(ea3.h2, true);
        obtainStyledAttributes.recycle();
        e();
    }

    public final void a() {
        int i = this.s;
        int i2 = this.p;
        int i3 = i - (((i * i2) - this.v) / (i2 - 1));
        for (int i4 = 0; i4 < this.p; i4++) {
            Rect rect = this.k[i4];
            Rect rect2 = this.t;
            int i5 = (i3 * i4) + rect2.left;
            rect.left = i5;
            rect.right = i5 + this.s;
            rect.top = rect2.top;
            rect.bottom = rect2.bottom;
        }
    }

    public final int b(int i) {
        return (int) ((this.f * i) + 0.5f);
    }

    public final void c(Canvas canvas) {
        if (!this.x) {
            RectF rectF = new RectF(0.0f, 0.0f, this.d, this.e);
            int i = this.g;
            canvas.drawRoundRect(rectF, i, i, this.a);
            return;
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.d, this.e - this.i);
        int i2 = this.g;
        canvas.drawRoundRect(rectF2, i2, i2, this.a);
        Path path = new Path();
        int i3 = this.j;
        int i4 = this.d;
        if (i3 == 0) {
            path.moveTo(i4 * 0.2f, this.e - this.i);
            path.rLineTo(0.0f, this.i);
            path.rLineTo(this.h, -this.i);
            path.close();
        } else {
            path.moveTo(i4 * 0.8f, this.e - this.i);
            path.rLineTo(0.0f, this.i);
            path.rLineTo(-this.h, -this.i);
            path.close();
        }
        canvas.drawPath(path, this.a);
    }

    public final Bitmap d(int i) {
        Bitmap bitmap;
        try {
            byte[] c = yh1.c(getResources().openRawResource(i));
            bitmap = BitmapFactory.decodeByteArray(c, 0, c.length, this.c);
        } catch (IOException e) {
            e.printStackTrace();
            bitmap = null;
        }
        return (Bitmap) new SoftReference(bitmap).get();
    }

    public final void e() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setColor(-2144128205);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(b(1));
        this.b = new Paint();
        this.a.setAntiAlias(true);
        this.a.setDither(true);
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.c = options;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 1;
        this.g = b(5);
        this.h = b(10);
        this.i = b(10);
        int i = this.p;
        this.l = new Bitmap[i];
        this.k = new Rect[i];
        for (int i2 = 0; i2 < this.p; i2++) {
            this.k[i2] = new Rect();
        }
        this.t = new Rect();
        int i3 = this.o;
        if (i3 != 0) {
            this.n = d(i3);
            Rect rect = new Rect();
            this.m = rect;
            rect.left = 0;
            rect.top = 0;
            rect.right = this.n.getWidth();
            this.m.bottom = this.n.getHeight();
        }
        this.z = new AccelerateDecelerateInterpolator();
    }

    public void f() {
        this.y = true;
        int length = this.l.length;
        for (int i = 0; i < length; i++) {
            Bitmap bitmap = this.l[i];
            if (bitmap != null && !bitmap.isRecycled()) {
                this.l[i].recycle();
            }
        }
    }

    public void g() {
        this.q = 1;
        this.r = 0;
        invalidate();
    }

    public final void h() {
        int interpolation = (int) (this.s + ((this.u - r0) * this.z.getInterpolation(this.r / 10.0f)));
        this.v = interpolation;
        Rect rect = this.t;
        int i = this.g;
        rect.left = i;
        rect.right = i + interpolation;
    }

    public void i(int... iArr) {
        this.q = 2;
        int i = 0;
        while (true) {
            Bitmap[] bitmapArr = this.l;
            if (i >= bitmapArr.length) {
                invalidate();
                return;
            }
            Bitmap bitmap = bitmapArr[i];
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.l[i] = d(iArr[i]);
            i++;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.y) {
            return;
        }
        c(canvas);
        int i = this.q;
        if (i == 1) {
            h();
            a();
            for (int i2 = 0; i2 < this.p; i2++) {
                if (this.y) {
                    return;
                }
                canvas.drawBitmap(this.n, this.m, this.k[i2], this.b);
            }
            int i3 = this.r;
            if (i3 < 10) {
                this.r = i3 + 1;
                postInvalidateDelayed(20L);
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        for (int i4 = 0; i4 < this.p && !this.y; i4++) {
            Rect rect = this.m;
            rect.left = 0;
            rect.top = 0;
            rect.right = this.l[i4].getWidth();
            this.m.bottom = this.l[i4].getHeight();
            canvas.drawBitmap(this.l[i4], this.m, this.k[i4], this.b);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.d == 0) {
            this.d = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.e = measuredHeight;
            int i5 = this.d;
            int i6 = this.g;
            this.u = i5 - (i6 * 2);
            Rect rect = this.t;
            rect.top = i6;
            if (this.x) {
                rect.bottom = (measuredHeight - this.i) - i6;
            } else {
                rect.bottom = measuredHeight - i6;
            }
            this.s = (int) ((r2 / this.p) * (this.w + 1.0f));
        }
    }
}
