package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.makeramen.roundedimageview.RoundedImageView;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class RatioRoundImageView extends RoundedImageView {
    public float r;

    public RatioRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.D3);
        this.r = obtainStyledAttributes.getFloat(da3.E3, 1.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        super/*android.view.View*/.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.r), 1073741824));
    }
}
