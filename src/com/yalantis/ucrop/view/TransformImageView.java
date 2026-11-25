package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.aw0;
import defpackage.fj;
import defpackage.gc3;
import defpackage.hj;
import defpackage.rz0;

/* loaded from: /tmp/classes2.dex */
public class TransformImageView extends AppCompatImageView {
    public final float[] d;
    public final float[] e;
    public final float[] f;
    public Matrix g;
    public int h;
    public int i;
    public b j;
    public float[] k;
    public float[] l;
    public boolean m;
    public boolean n;
    public int o;
    public String p;
    public String q;
    public Uri r;
    public Uri s;
    public aw0 t;

    /* loaded from: /tmp/classes2.dex */
    public class a implements fj {
        public a() {
        }

        @Override // defpackage.fj
        public void a(Bitmap bitmap, aw0 aw0Var, Uri uri, Uri uri2) {
            TransformImageView.this.r = uri;
            TransformImageView.this.s = uri2;
            TransformImageView.this.p = uri.getPath();
            TransformImageView.this.q = uri2 != null ? uri2.getPath() : null;
            TransformImageView.this.t = aw0Var;
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.m = true;
            transformImageView.setImageBitmap(bitmap);
        }

        @Override // defpackage.fj
        public void onFailure(Exception exc) {
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            b bVar = TransformImageView.this.j;
            if (bVar != null) {
                bVar.c(exc);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(float f);

        void b();

        void c(Exception exc);

        void d(float f);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new float[8];
        this.e = new float[2];
        this.f = new float[9];
        this.g = new Matrix();
        this.m = false;
        this.n = false;
        this.o = 0;
        k();
    }

    public float getCurrentAngle() {
        return h(this.g);
    }

    public float getCurrentScale() {
        return i(this.g);
    }

    public aw0 getExifInfo() {
        return this.t;
    }

    public String getImageInputPath() {
        return this.p;
    }

    public Uri getImageInputUri() {
        return this.r;
    }

    public String getImageOutputPath() {
        return this.q;
    }

    public Uri getImageOutputUri() {
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getMaxBitmapSize() {
        if (this.o <= 0) {
            this.o = hj.b(getContext());
        }
        return this.o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof rz0)) {
            return null;
        }
        return ((rz0) getDrawable()).a();
    }

    public float h(Matrix matrix) {
        return (float) (-(Math.atan2(j(matrix, 1), j(matrix, 0)) * 57.29577951308232d));
    }

    public float i(Matrix matrix) {
        return (float) Math.sqrt(Math.pow(j(matrix, 0), 2.0d) + Math.pow(j(matrix, 3), 2.0d));
    }

    public float j(Matrix matrix, int i) {
        matrix.getValues(this.f);
        return this.f[i];
    }

    public void k() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.k = gc3.b(rectF);
        this.l = gc3.a(rectF);
        this.n = true;
        b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void m(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.g.postRotate(f, f2, f3);
            setImageMatrix(this.g);
            b bVar = this.j;
            if (bVar != null) {
                bVar.a(h(this.g));
            }
        }
    }

    public void n(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.g.postScale(f, f, f2, f3);
            setImageMatrix(this.g);
            b bVar = this.j;
            if (bVar != null) {
                bVar.d(i(this.g));
            }
        }
    }

    public void o(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.g.postTranslate(f, f2);
        setImageMatrix(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super/*android.view.View*/.onLayout(z, i, i2, i3, i4);
        if (z || (this.m && !this.n)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.h = width - paddingLeft;
            this.i = height - paddingTop;
            l();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void p(Uri uri, Uri uri2) {
        int maxBitmapSize = getMaxBitmapSize();
        hj.d(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new a());
    }

    public final void q() {
        this.g.mapPoints(this.d, this.k);
        this.g.mapPoints(this.e, this.l);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new rz0(bitmap));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageMatrix(Matrix matrix) {
        super/*android.widget.ImageView*/.setImageMatrix(matrix);
        this.g.set(matrix);
        q();
    }

    public void setMaxBitmapSize(int i) {
        this.o = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super/*android.widget.ImageView*/.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(b bVar) {
        this.j = bVar;
    }
}
