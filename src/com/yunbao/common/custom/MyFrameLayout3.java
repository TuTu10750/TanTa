package com.yunbao.common.custom;

import android.view.View;
import android.widget.FrameLayout;

/* loaded from: /tmp/classes2.dex */
public class MyFrameLayout3 extends FrameLayout {
    public int a;

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.a, 1073741824), i2);
    }
}
