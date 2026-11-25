package com.yunbao.live.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.ha3;

/* loaded from: /tmp/classes2.dex */
public class MyFrameLayout3 extends FrameLayout {
    public int a;
    public int b;
    public float c;

    public MyFrameLayout3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyFrameLayout3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.a = displayMetrics.widthPixels;
        this.b = displayMetrics.heightPixels;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.U1);
        this.c = obtainStyledAttributes.getFloat(ha3.V1, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (this.a * this.c), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (this.b * this.c), 1073741824));
    }
}
