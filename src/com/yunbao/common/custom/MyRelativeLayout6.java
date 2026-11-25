package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: /tmp/classes2.dex */
public class MyRelativeLayout6 extends RelativeLayout {
    public MyRelativeLayout6(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i) * 13.0f) / 9.0f), 1073741824));
    }
}
