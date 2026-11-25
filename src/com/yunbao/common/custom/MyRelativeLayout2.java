package com.yunbao.common.custom;

import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: /tmp/classes2.dex */
public class MyRelativeLayout2 extends RelativeLayout {
    public int a;
    public float b;
    public float c;

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = (int) (this.a * this.c);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (i3 * this.b), 1073741824));
    }
}
