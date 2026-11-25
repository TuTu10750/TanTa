package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class MyFrameLayout2 extends FrameLayout {
    public float a;
    public float b;

    public MyFrameLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyFrameLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.N2);
        this.a = obtainStyledAttributes.getFloat(da3.P2, 1.0f);
        this.b = obtainStyledAttributes.getDimension(da3.O2, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i) * this.a) + this.b), 1073741824));
    }
}
