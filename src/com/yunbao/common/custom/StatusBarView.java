package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: /tmp/classes2.dex */
public class StatusBarView extends View {
    public final int a;

    public StatusBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StatusBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.a = resources.getDimensionPixelSize(identifier);
        } else {
            this.a = 0;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.a, 1073741824));
    }
}
