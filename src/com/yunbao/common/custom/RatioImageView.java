package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class RatioImageView extends AppCompatImageView {
    public float d;

    public RatioImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.D3);
        this.d = obtainStyledAttributes.getFloat(da3.E3, 1.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        super/*android.view.View*/.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.d), 1073741824));
    }
}
