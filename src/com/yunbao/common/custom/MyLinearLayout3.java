package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import defpackage.da3;
import defpackage.zn0;

/* loaded from: /tmp/classes2.dex */
public class MyLinearLayout3 extends LinearLayout {
    public int a;
    public float b;
    public int c;

    public MyLinearLayout3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyLinearLayout3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context.getResources().getDisplayMetrics().heightPixels;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.S2);
        float f = obtainStyledAttributes.getFloat(da3.T2, 0.0f);
        this.b = f;
        this.c = ((int) (f * this.a)) - zn0.a(48);
        obtainStyledAttributes.recycle();
    }

    public int getHeight2() {
        return this.c;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
    }
}
