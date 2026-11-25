package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.zzhoujay.richtext.ImageHolder;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class MaxHeightRecyclerView extends RecyclerView {
    public int T0;

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.z2);
        this.T0 = (int) obtainStyledAttributes.getDimension(da3.A2, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i, int i2) {
        if (this.T0 > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 0 || size > this.T0) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.T0, ImageHolder.WRAP_CONTENT);
            }
        }
        super.onMeasure(i, i2);
    }
}
