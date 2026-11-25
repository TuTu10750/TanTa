package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class MyLinearLayout6 extends LinearLayout {
    public float a;

    public MyLinearLayout6(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyLinearLayout6(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.W2);
        this.a = obtainStyledAttributes.getFloat(da3.X2, 1.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.a), 1073741824));
    }
}
