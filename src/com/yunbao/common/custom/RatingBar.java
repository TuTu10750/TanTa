package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class RatingBar extends FrameLayout implements SeekBar.OnSeekBarChangeListener {
    public Context a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Drawable g;
    public Drawable h;
    public SeekBar i;
    public ImageView[] j;
    public a k;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void o(int i, int i2);
    }

    public RatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.v3);
        this.b = obtainStyledAttributes.getInt(da3.z3, 0);
        this.c = obtainStyledAttributes.getInt(da3.w3, 0);
        this.d = (int) obtainStyledAttributes.getDimension(da3.C3, 0.0f);
        this.e = (int) obtainStyledAttributes.getDimension(da3.A3, 0.0f);
        this.f = (int) obtainStyledAttributes.getDimension(da3.B3, 0.0f);
        this.g = obtainStyledAttributes.getDrawable(da3.y3);
        this.h = obtainStyledAttributes.getDrawable(da3.x3);
        obtainStyledAttributes.recycle();
    }

    public int getFillCount() {
        SeekBar seekBar = this.i;
        if (seekBar != null) {
            return seekBar.getProgress();
        }
        return 0;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        SeekBar seekBar = new SeekBar(this.a);
        this.i = seekBar;
        seekBar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i.setThumb(null);
        this.i.setProgressDrawable(null);
        this.i.setBackground(new ColorDrawable(0));
        this.i.setMax(this.b);
        this.i.setProgress(this.c);
        this.i.setOnSeekBarChangeListener(this);
        addView(this.i);
        LinearLayout linearLayout = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        this.j = new ImageView[this.b];
        for (int i = 0; i < this.b; i++) {
            ImageView imageView = new ImageView(this.a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.d, this.e);
            if (i > 0) {
                layoutParams2.leftMargin = this.f;
            }
            imageView.setLayoutParams(layoutParams2);
            if (i <= this.c - 1) {
                imageView.setImageDrawable(this.h);
            } else {
                imageView.setImageDrawable(this.g);
            }
            this.j[i] = imageView;
            linearLayout.addView(imageView);
        }
        addView(linearLayout);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2;
        this.c = i;
        int i3 = 0;
        while (true) {
            i2 = this.b;
            if (i3 >= i2) {
                break;
            }
            ImageView imageView = this.j[i3];
            if (i3 <= i - 1) {
                imageView.setImageDrawable(this.h);
            } else {
                imageView.setImageDrawable(this.g);
            }
            i3++;
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.o(i, i2);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void setOnRatingChangedListener(a aVar) {
        this.k = aVar;
    }
}
