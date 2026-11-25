package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class MyLinearLayout4 extends LinearLayout {
    public int a;
    public float b;

    public MyLinearLayout4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyLinearLayout4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.U2);
        this.b = obtainStyledAttributes.getFloat(da3.V2, 1.0f);
        obtainStyledAttributes.recycle();
        a(context);
    }

    public final void a(Context context) {
        this.a = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (this.a / this.b), 1073741824), i2);
    }
}
