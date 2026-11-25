package com.yunbao.common.custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class TabButton extends LinearLayout {
    public Context a;
    public float b;
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public ImageView i;
    public TextView j;
    public Drawable[] k;
    public int l;
    public ValueAnimator m;
    public int n;
    public final float o;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = (int) floatValue;
            if (TabButton.this.n != i) {
                TabButton.this.n = i;
                if (TabButton.this.i != null) {
                    TabButton.this.i.setImageDrawable(TabButton.this.k[i]);
                    float f = (floatValue / (TabButton.this.l - 1)) * 1.0f;
                    TabButton.this.i.setScaleX(f);
                    TabButton.this.i.setScaleY(f);
                }
            }
        }
    }

    public TabButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = 1.0f;
        this.a = context;
        this.b = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.J4);
        int resourceId = obtainStyledAttributes.getResourceId(da3.L4, 0);
        this.c = obtainStyledAttributes.getString(da3.Q4);
        this.d = (int) obtainStyledAttributes.getDimension(da3.M4, 0.0f);
        this.e = (int) obtainStyledAttributes.getDimension(da3.P4, 0.0f);
        this.f = obtainStyledAttributes.getColor(da3.N4, 0);
        this.g = obtainStyledAttributes.getColor(da3.O4, 0);
        this.h = obtainStyledAttributes.getBoolean(da3.K4, false);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(resourceId);
            int length = obtainTypedArray.length();
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
            }
            obtainTypedArray.recycle();
            this.l = length;
            if (length > 0) {
                this.k = new Drawable[length];
                for (int i3 = 0; i3 < this.l; i3++) {
                    this.k[i3] = o60.d(context, iArr[i3]);
                }
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, this.l - 1);
        this.m = ofFloat;
        ofFloat.addUpdateListener(new a());
        this.m.setDuration(300L);
        this.m.setInterpolator(new LinearInterpolator());
    }

    public void f() {
        ValueAnimator valueAnimator = this.m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.m.removeAllUpdateListeners();
        }
    }

    public final int g(int i) {
        return (int) ((this.b * i) + 0.5f);
    }

    public void h() {
        this.i.setImageTintList(null);
        this.j.setTextColor(this.h ? this.f : this.g);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setOrientation(1);
        setGravity(1);
        this.i = new ImageView(this.a);
        int i = this.d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.setMargins(0, g(14), 0, 0);
        this.i.setLayoutParams(layoutParams);
        this.i.setPivotX(this.d / 2.0f);
        this.i.setPivotY(this.d - g(5));
        Drawable[] drawableArr = this.k;
        if (drawableArr != null && this.l > 0) {
            boolean z = this.h;
            ImageView imageView = this.i;
            if (z) {
                imageView.setScaleX(1.0f);
                this.i.setScaleY(1.0f);
                this.i.setImageDrawable(this.k[this.l - 1]);
            } else {
                imageView.setImageDrawable(drawableArr[0]);
            }
        }
        this.j = new TextView(this.a);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.j.setTextSize(0, this.e);
        this.j.setText(this.c);
        this.j.setTextColor(this.h ? this.f : this.g);
        addView(this.i);
        addView(this.j);
    }

    public void setChecked(boolean z) {
        this.h = z;
        if (this.k == null || this.l <= 0) {
            return;
        }
        if (z) {
            TextView textView = this.j;
            if (textView != null) {
                textView.setTextColor(this.f);
            }
            ValueAnimator valueAnimator = this.m;
            if (valueAnimator != null) {
                valueAnimator.start();
                return;
            }
            return;
        }
        ValueAnimator valueAnimator2 = this.m;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setScaleX(1.0f);
            this.i.setScaleY(1.0f);
            this.i.setImageDrawable(this.k[0]);
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setTextColor(this.g);
        }
    }

    public void setTint(int i) {
        this.i.setImageTintList(ColorStateList.valueOf(i));
        this.j.setTextColor(this.h ? this.f : -1);
    }
}
