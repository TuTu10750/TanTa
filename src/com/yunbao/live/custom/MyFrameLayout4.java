package com.yunbao.live.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.gk3;

/* loaded from: /tmp/classes2.dex */
public class MyFrameLayout4 extends FrameLayout {
    public int a;

    public MyFrameLayout4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyFrameLayout4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = gk3.a().c() / 2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.a, 1073741824), i2);
    }
}
