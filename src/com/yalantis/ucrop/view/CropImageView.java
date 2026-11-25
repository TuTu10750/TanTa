package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.TransformImageView;
import defpackage.ba3;
import defpackage.dn1;
import defpackage.e80;
import defpackage.gc3;
import defpackage.ik;
import defpackage.ti;
import defpackage.ui;
import defpackage.y70;
import defpackage.z70;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: /tmp/classes2.dex */
public class CropImageView extends TransformImageView {
    public Runnable A;
    public float B;
    public float C;
    public int D;
    public int E;
    public long F;
    public final RectF u;
    public final Matrix v;
    public float w;
    public float x;
    public y70 y;
    public Runnable z;

    /* loaded from: /tmp/classes2.dex */
    public static class a implements Runnable {
        public final WeakReference a;
        public final long b;
        public final long c = System.currentTimeMillis();
        public final float d;
        public final float e;
        public final float f;
        public final float g;
        public final float h;
        public final float i;
        public final boolean j;

        public a(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.a = new WeakReference(cropImageView);
            this.b = j;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
            this.h = f5;
            this.i = f6;
            this.j = z;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.yalantis.ucrop.view.CropImageView, android.view.View, com.yalantis.ucrop.view.TransformImageView] */
        @Override // java.lang.Runnable
        public void run() {
            ?? r0 = (CropImageView) this.a.get();
            if (r0 == 0) {
                return;
            }
            float min = (float) Math.min(this.b, System.currentTimeMillis() - this.c);
            float b = e80.b(min, 0.0f, this.f, (float) this.b);
            float b2 = e80.b(min, 0.0f, this.g, (float) this.b);
            float a = e80.a(min, 0.0f, this.i, (float) this.b);
            if (min < ((float) this.b)) {
                float[] fArr = r0.e;
                r0.o(b - (fArr[0] - this.d), b2 - (fArr[1] - this.e));
                if (!this.j) {
                    r0.F(this.h + a, r0.u.centerX(), r0.u.centerY());
                }
                if (r0.x()) {
                    return;
                }
                r0.post(this);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b implements Runnable {
        public final WeakReference a;
        public final long b;
        public final long c = System.currentTimeMillis();
        public final float d;
        public final float e;
        public final float f;
        public final float g;

        public b(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.a = new WeakReference(cropImageView);
            this.b = j;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.yalantis.ucrop.view.CropImageView, android.view.View] */
        @Override // java.lang.Runnable
        public void run() {
            ?? r0 = (CropImageView) this.a.get();
            if (r0 == 0) {
                return;
            }
            float min = (float) Math.min(this.b, System.currentTimeMillis() - this.c);
            float a = e80.a(min, 0.0f, this.e, (float) this.b);
            if (min >= ((float) this.b)) {
                r0.B();
            } else {
                r0.F(this.d + a, this.f, this.g);
                r0.post(this);
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.u = new RectF();
        this.v = new Matrix();
        this.x = 10.0f;
        this.A = null;
        this.D = 0;
        this.E = 0;
        this.F = 500L;
    }

    public void A(TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(ba3.Z, 0.0f));
        float abs2 = Math.abs(typedArray.getFloat(ba3.a0, 0.0f));
        if (abs == 0.0f || abs2 == 0.0f) {
            this.w = 0.0f;
        } else {
            this.w = abs / abs2;
        }
    }

    public void B() {
        setImageToWrapCropBounds(true);
    }

    public final void C(float f, float f2) {
        float width = this.u.width();
        float height = this.u.height();
        float max = Math.max(this.u.width() / f, this.u.height() / f2);
        RectF rectF = this.u;
        float f3 = ((width - (f * max)) / 2.0f) + rectF.left;
        float f4 = ((height - (f2 * max)) / 2.0f) + rectF.top;
        this.g.reset();
        this.g.postScale(max, max);
        this.g.postTranslate(f3, f4);
        setImageMatrix(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j, currentScale, f - currentScale, f2, f3);
        this.A = bVar;
        post(bVar);
    }

    public void E(float f) {
        F(f, this.u.centerX(), this.u.centerY());
    }

    public void F(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            n(f / getCurrentScale(), f2, f3);
        }
    }

    public void G(float f) {
        H(f, this.u.centerX(), this.u.centerY());
    }

    public void H(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            n(f / getCurrentScale(), f2, f3);
        }
    }

    public y70 getCropBoundsChangeListener() {
        return this.y;
    }

    public float getMaxScale() {
        return this.B;
    }

    public float getMinScale() {
        return this.C;
    }

    public float getTargetAspectRatio() {
        return this.w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void l() {
        super.l();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.w == 0.0f) {
            this.w = intrinsicWidth / intrinsicHeight;
        }
        int i = this.h;
        float f = this.w;
        int i2 = (int) (i / f);
        int i3 = this.i;
        RectF rectF = this.u;
        if (i2 > i3) {
            rectF.set((i - ((int) (i3 * f))) / 2, 0.0f, r4 + r2, i3);
        } else {
            rectF.set(0.0f, (i3 - i2) / 2, i, i2 + r6);
        }
        u(intrinsicWidth, intrinsicHeight);
        C(intrinsicWidth, intrinsicHeight);
        y70 y70Var = this.y;
        if (y70Var != null) {
            y70Var.a(this.w);
        }
        TransformImageView.b bVar = this.j;
        if (bVar != null) {
            bVar.d(getCurrentScale());
            this.j.a(getCurrentAngle());
        }
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void n(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.n(f, f2, f3);
        } else {
            if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
                return;
            }
            super.n(f, f2, f3);
        }
    }

    public final float[] s() {
        this.v.reset();
        this.v.setRotate(-getCurrentAngle());
        float[] fArr = this.d;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        float[] b2 = gc3.b(this.u);
        this.v.mapPoints(copyOf);
        this.v.mapPoints(b2);
        RectF d = gc3.d(copyOf);
        RectF d2 = gc3.d(b2);
        float f = d.left - d2.left;
        float f2 = d.top - d2.top;
        float f3 = d.right - d2.right;
        float f4 = d.bottom - d2.bottom;
        if (f <= 0.0f) {
            f = 0.0f;
        }
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        if (f3 >= 0.0f) {
            f3 = 0.0f;
        }
        if (f4 >= 0.0f) {
            f4 = 0.0f;
        }
        float[] fArr2 = {f, f2, f3, f4};
        this.v.reset();
        this.v.setRotate(getCurrentAngle());
        this.v.mapPoints(fArr2);
        return fArr2;
    }

    public void setCropBoundsChangeListener(y70 y70Var) {
        this.y = y70Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCropRect(RectF rectF) {
        this.w = rectF.width() / rectF.height();
        this.u.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        t();
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageToWrapCropBounds(boolean z) {
        float f;
        float max;
        if (!this.n || x()) {
            return;
        }
        float[] fArr = this.e;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float currentScale = getCurrentScale();
        float centerX = this.u.centerX() - f2;
        float centerY = this.u.centerY() - f3;
        this.v.reset();
        this.v.setTranslate(centerX, centerY);
        float[] fArr2 = this.d;
        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.v.mapPoints(copyOf);
        boolean y = y(copyOf);
        if (y) {
            float[] s = s();
            float f4 = -(s[0] + s[2]);
            centerY = -(s[1] + s[3]);
            max = 0.0f;
            f = f4;
        } else {
            RectF rectF = new RectF(this.u);
            this.v.reset();
            this.v.setRotate(getCurrentAngle());
            this.v.mapRect(rectF);
            float[] c = gc3.c(this.d);
            f = centerX;
            max = (Math.max(rectF.width() / c[0], rectF.height() / c[1]) * currentScale) - currentScale;
        }
        float f5 = centerY;
        if (z) {
            a aVar = new a(this, this.F, f2, f3, f, f5, currentScale, max, y);
            this.z = aVar;
            post(aVar);
        } else {
            o(f, f5);
            if (y) {
                return;
            }
            F(currentScale + max, this.u.centerX(), this.u.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long j) {
        if (j > 0) {
            this.F = j;
        } else {
            ik.a("Animation duration cannot be negative value.");
        }
    }

    public void setMaxResultImageSizeX(int i) {
        this.D = i;
    }

    public void setMaxResultImageSizeY(int i) {
        this.E = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.x = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTargetAspectRatio(float f) {
        if (getDrawable() == null) {
            this.w = f;
            return;
        }
        if (f == 0.0f) {
            this.w = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.w = f;
        }
        y70 y70Var = this.y;
        if (y70Var != null) {
            y70Var.a(this.w);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        if (getDrawable() == null) {
            return;
        }
        u(r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
    }

    public final void u(float f, float f2) {
        float min = Math.min(Math.min(this.u.width() / f, this.u.width() / f2), Math.min(this.u.height() / f2, this.u.height() / f));
        this.C = min;
        this.B = min * this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w(Bitmap.CompressFormat compressFormat, int i, ti tiVar) {
        v();
        setImageToWrapCropBounds(false);
        dn1 dn1Var = new dn1(this.u, gc3.d(this.d), getCurrentScale(), getCurrentAngle());
        z70 z70Var = new z70(this.D, this.E, compressFormat, i, getImageInputPath(), getImageOutputPath(), getExifInfo());
        z70Var.j(getImageInputUri());
        z70Var.k(getImageOutputUri());
        new ui(getContext(), getViewBitmap(), dn1Var, z70Var, tiVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public boolean x() {
        return y(this.d);
    }

    public boolean y(float[] fArr) {
        this.v.reset();
        this.v.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        this.v.mapPoints(copyOf);
        float[] b2 = gc3.b(this.u);
        this.v.mapPoints(b2);
        return gc3.d(copyOf).contains(gc3.d(b2));
    }

    public void z(float f) {
        m(f, this.u.centerX(), this.u.centerY());
    }
}
