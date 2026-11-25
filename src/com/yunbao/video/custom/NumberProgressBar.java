package com.yunbao.video.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import defpackage.ia3;

/* loaded from: /tmp/classes2.dex */
public class NumberProgressBar extends View {
    public float A;
    public boolean B;
    public boolean C;
    public boolean D;
    public long a;
    public long b;
    public int c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float h;
    public String i;
    public String j;
    public final int k;
    public final int l;
    public final int m;
    public final float n;
    public final float o;
    public final float p;
    public final float q;
    public float r;
    public float s;
    public float t;
    public String u;
    public Paint v;
    public Paint w;
    public Paint x;
    public RectF y;
    public RectF z;

    /* loaded from: /tmp/classes2.dex */
    public enum ProgressTextVisibility {
        Visible,
        Invisible
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 100L;
        this.b = 0L;
        this.i = "%";
        this.j = "";
        int rgb = Color.rgb(66, 145, 241);
        this.k = rgb;
        int rgb2 = Color.rgb(66, 145, 241);
        this.l = rgb2;
        int rgb3 = Color.rgb(204, 204, 204);
        this.m = rgb3;
        this.y = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.z = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.B = true;
        this.C = true;
        this.D = true;
        float c = c(1.5f);
        this.p = c;
        float c2 = c(1.0f);
        this.q = c2;
        float f = f(10.0f);
        this.o = f;
        float c3 = c(3.0f);
        this.n = c3;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ia3.U1, i, 0);
        this.c = obtainStyledAttributes.getColor(ia3.Y1, rgb2);
        this.d = obtainStyledAttributes.getColor(ia3.e2, rgb3);
        this.e = obtainStyledAttributes.getColor(ia3.Z1, rgb);
        this.f = obtainStyledAttributes.getDimension(ia3.b2, f);
        this.g = obtainStyledAttributes.getDimension(ia3.X1, c);
        this.h = obtainStyledAttributes.getDimension(ia3.d2, c2);
        this.A = obtainStyledAttributes.getDimension(ia3.a2, c3);
        if (obtainStyledAttributes.getInt(ia3.c2, 0) != 0) {
            this.D = false;
        }
        setProgress(obtainStyledAttributes.getInt(ia3.V1, 0));
        setMax(obtainStyledAttributes.getInt(ia3.W1, 100));
        obtainStyledAttributes.recycle();
        d();
    }

    public final void a() {
        this.u = String.format("%d", Long.valueOf((getProgress() * 100) / getMax()));
        String str = this.j + this.u + this.i;
        this.u = str;
        this.r = this.x.measureText(str);
        if (getProgress() == 0) {
            this.C = false;
            this.s = getPaddingLeft();
        } else {
            this.C = true;
            this.z.left = getPaddingLeft();
            this.z.top = (getHeight() / 2.0f) - (this.g / 2.0f);
            this.z.right = (((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (((float) getMax()) * 1.0f)) * ((float) getProgress())) - this.A) + getPaddingLeft();
            this.z.bottom = (getHeight() / 2.0f) + (this.g / 2.0f);
            this.s = this.z.right + this.A;
        }
        this.t = (int) ((getHeight() / 2.0f) - ((this.x.descent() + this.x.ascent()) / 2.0f));
        if (this.s + this.r >= getWidth() - getPaddingRight()) {
            float width = (getWidth() - getPaddingRight()) - this.r;
            this.s = width;
            this.z.right = width - this.A;
        }
        float f = this.s + this.r + this.A;
        if (f >= getWidth() - getPaddingRight()) {
            this.B = false;
            return;
        }
        this.B = true;
        RectF rectF = this.y;
        rectF.left = f;
        rectF.right = getWidth() - getPaddingRight();
        this.y.top = (getHeight() / 2.0f) + ((-this.h) / 2.0f);
        this.y.bottom = (getHeight() / 2.0f) + (this.h / 2.0f);
    }

    public final void b() {
        this.z.left = getPaddingLeft();
        this.z.top = (getHeight() / 2.0f) - (this.g / 2.0f);
        this.z.right = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (((float) getMax()) * 1.0f)) * ((float) getProgress())) + getPaddingLeft();
        this.z.bottom = (getHeight() / 2.0f) + (this.g / 2.0f);
        RectF rectF = this.y;
        rectF.left = this.z.right;
        rectF.right = getWidth() - getPaddingRight();
        this.y.top = (getHeight() / 2.0f) + ((-this.h) / 2.0f);
        this.y.bottom = (getHeight() / 2.0f) + (this.h / 2.0f);
    }

    public float c(float f) {
        return (f * getResources().getDisplayMetrics().density) + 0.5f;
    }

    public final void d() {
        Paint paint = new Paint(1);
        this.v = paint;
        paint.setColor(this.c);
        Paint paint2 = new Paint(1);
        this.w = paint2;
        paint2.setColor(this.d);
        Paint paint3 = new Paint(1);
        this.x = paint3;
        paint3.setColor(this.e);
        this.x.setTextSize(this.f);
    }

    public final int e(int i, boolean z) {
        int paddingTop;
        int paddingBottom;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (z) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i2 = paddingTop + paddingBottom;
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumWidth = (z ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight()) + i2;
        return mode == Integer.MIN_VALUE ? z ? Math.max(suggestedMinimumWidth, size) : Math.min(suggestedMinimumWidth, size) : suggestedMinimumWidth;
    }

    public float f(float f) {
        return f * getResources().getDisplayMetrics().scaledDensity;
    }

    public long getMax() {
        return this.a;
    }

    public String getPrefix() {
        return this.j;
    }

    public long getProgress() {
        return this.b;
    }

    public float getProgressTextSize() {
        return this.f;
    }

    public boolean getProgressTextVisibility() {
        return this.D;
    }

    public int getReachedBarColor() {
        return this.c;
    }

    public float getReachedBarHeight() {
        return this.g;
    }

    public String getSuffix() {
        return this.i;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max((int) this.f, Math.max((int) this.g, (int) this.h));
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return (int) this.f;
    }

    public int getTextColor() {
        return this.e;
    }

    public int getUnreachedBarColor() {
        return this.d;
    }

    public float getUnreachedBarHeight() {
        return this.h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.D) {
            a();
        } else {
            b();
        }
        if (this.C) {
            canvas.drawRect(this.z, this.v);
        }
        if (this.B) {
            canvas.drawRect(this.y, this.w);
        }
        if (this.D) {
            canvas.drawText(this.u, this.s, this.t, this.x);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(e(i, true), e(i2, false));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.e = bundle.getInt("text_color");
        this.f = bundle.getFloat("text_size");
        this.g = bundle.getFloat("reached_bar_height");
        this.h = bundle.getFloat("unreached_bar_height");
        this.c = bundle.getInt("reached_bar_color");
        this.d = bundle.getInt("unreached_bar_color");
        d();
        setMax(bundle.getLong("max"));
        setProgress(bundle.getLong("progress"));
        setPrefix(bundle.getString("prefix"));
        setSuffix(bundle.getString("suffix"));
        setProgressTextVisibility(bundle.getBoolean("text_visibility") ? ProgressTextVisibility.Visible : ProgressTextVisibility.Invisible);
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getProgressTextSize());
        bundle.putFloat("reached_bar_height", getReachedBarHeight());
        bundle.putFloat("unreached_bar_height", getUnreachedBarHeight());
        bundle.putInt("reached_bar_color", getReachedBarColor());
        bundle.putInt("unreached_bar_color", getUnreachedBarColor());
        bundle.putLong("max", getMax());
        bundle.putLong("progress", getProgress());
        bundle.putString("suffix", getSuffix());
        bundle.putString("prefix", getPrefix());
        bundle.putBoolean("text_visibility", getProgressTextVisibility());
        return bundle;
    }

    public void setMax(long j) {
        if (j > 0) {
            this.a = j;
            invalidate();
        }
    }

    public void setPrefix(String str) {
        if (str == null) {
            this.j = "";
        } else {
            this.j = str;
        }
    }

    public void setProgress(long j) {
        if (j > getMax() || j < 0) {
            return;
        }
        this.b = j;
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.e = i;
        this.x.setColor(i);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.f = f;
        this.x.setTextSize(f);
        invalidate();
    }

    public void setProgressTextVisibility(ProgressTextVisibility progressTextVisibility) {
        this.D = progressTextVisibility == ProgressTextVisibility.Visible;
        invalidate();
    }

    public void setReachedBarColor(int i) {
        this.c = i;
        this.v.setColor(i);
        invalidate();
    }

    public void setReachedBarHeight(float f) {
        this.g = f;
    }

    public void setSuffix(String str) {
        if (str == null) {
            this.i = "";
        } else {
            this.i = str;
        }
    }

    public void setUnreachedBarColor(int i) {
        this.d = i;
        this.w.setColor(i);
        invalidate();
    }

    public void setUnreachedBarHeight(float f) {
        this.h = f;
    }
}
