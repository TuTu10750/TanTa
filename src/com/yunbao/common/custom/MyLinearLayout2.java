package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class MyLinearLayout2 extends LinearLayout {
    public float a;
    public int b;

    public MyLinearLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyLinearLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context.getResources().getDisplayMetrics().widthPixels;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.Q2);
        this.b = obtainStyledAttributes.getInteger(da3.R2, 6);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (this.a / this.b), 1073741824), i2);
    }
}
