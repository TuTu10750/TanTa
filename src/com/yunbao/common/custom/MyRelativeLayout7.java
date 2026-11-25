package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: /tmp/classes2.dex */
public class MyRelativeLayout7 extends RelativeLayout {
    public int a;

    public MyRelativeLayout7(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyRelativeLayout7(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.a = (displayMetrics.widthPixels - ((int) ((displayMetrics.density * 27.0f) + 0.5f))) / 2;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.a, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
