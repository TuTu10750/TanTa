package com.yunbao.game.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: /tmp/classes2.dex */
public class LuckPanWrap extends FrameLayout {
    public float a;

    public LuckPanWrap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int a(int i) {
        return (int) (this.a + i + 0.5f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) / 2) + a(60), 1073741824));
    }
}
