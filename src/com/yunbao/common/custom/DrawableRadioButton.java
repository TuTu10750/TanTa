package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class DrawableRadioButton extends AppCompatRadioButton {
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Drawable m;
    public Drawable n;
    public Drawable o;
    public Drawable p;

    public DrawableRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.a1);
        this.e = (int) obtainStyledAttributes.getDimension(da3.m1, 0.0f);
        this.f = (int) obtainStyledAttributes.getDimension(da3.l1, 0.0f);
        this.g = (int) obtainStyledAttributes.getDimension(da3.g1, 0.0f);
        this.h = (int) obtainStyledAttributes.getDimension(da3.f1, 0.0f);
        this.i = (int) obtainStyledAttributes.getDimension(da3.j1, 0.0f);
        this.j = (int) obtainStyledAttributes.getDimension(da3.i1, 0.0f);
        this.k = (int) obtainStyledAttributes.getDimension(da3.d1, 0.0f);
        this.l = (int) obtainStyledAttributes.getDimension(da3.c1, 0.0f);
        this.m = obtainStyledAttributes.getDrawable(da3.k1);
        this.n = obtainStyledAttributes.getDrawable(da3.e1);
        this.o = obtainStyledAttributes.getDrawable(da3.h1);
        this.p = obtainStyledAttributes.getDrawable(da3.b1);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        super/*android.view.View*/.onDraw(canvas);
        setCompoundDrawablesWithIntrinsicBounds(this.n, this.m, this.o, this.p);
    }

    public void setBottomDrawable(Drawable drawable) {
        this.p = drawable;
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            drawable.setBounds(0, 0, this.g, this.h);
        }
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.e, this.f);
        }
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.i, this.j);
        }
        if (drawable4 != null) {
            drawable4.setBounds(0, 0, this.k, this.l);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setLeftDrawable(Drawable drawable) {
        this.n = drawable;
    }

    public void setRightDrawable(Drawable drawable) {
        this.o = drawable;
    }

    public void setTopDrawable(Drawable drawable) {
        this.m = drawable;
    }
}
