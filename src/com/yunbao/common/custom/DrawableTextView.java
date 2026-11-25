package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class DrawableTextView extends AppCompatTextView {
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public Drawable p;
    public Drawable q;
    public Drawable r;
    public Drawable s;

    public DrawableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.a1);
        this.h = (int) obtainStyledAttributes.getDimension(da3.m1, 0.0f);
        this.i = (int) obtainStyledAttributes.getDimension(da3.l1, 0.0f);
        this.j = (int) obtainStyledAttributes.getDimension(da3.g1, 0.0f);
        this.k = (int) obtainStyledAttributes.getDimension(da3.f1, 0.0f);
        this.l = (int) obtainStyledAttributes.getDimension(da3.j1, 0.0f);
        this.m = (int) obtainStyledAttributes.getDimension(da3.i1, 0.0f);
        this.n = (int) obtainStyledAttributes.getDimension(da3.d1, 0.0f);
        this.o = (int) obtainStyledAttributes.getDimension(da3.c1, 0.0f);
        this.p = obtainStyledAttributes.getDrawable(da3.k1);
        this.q = obtainStyledAttributes.getDrawable(da3.e1);
        this.r = obtainStyledAttributes.getDrawable(da3.h1);
        this.s = obtainStyledAttributes.getDrawable(da3.b1);
        obtainStyledAttributes.recycle();
    }

    public Drawable getBottomDrawable() {
        return this.s;
    }

    public Drawable getLeftDrawable() {
        return this.q;
    }

    public Drawable getRightDrawable() {
        return this.r;
    }

    public Drawable getTopDrawable() {
        return this.p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        super/*android.view.View*/.onDraw(canvas);
        setCompoundDrawablesWithIntrinsicBounds(this.q, this.p, this.r, this.s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBottomDrawable(Drawable drawable) {
        this.s = drawable;
        invalidate();
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            drawable.setBounds(0, 0, this.j, this.k);
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.h, this.i);
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.l, this.m);
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, this.n, this.o);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLeftDrawable(Drawable drawable) {
        this.q = drawable;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRightDrawable(Drawable drawable) {
        this.r = drawable;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTopDrawable(Drawable drawable) {
        this.p = drawable;
        invalidate();
    }
}
