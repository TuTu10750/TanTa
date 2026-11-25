package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: /tmp/classes2.dex */
public class SquareRoundedImageView extends RoundedImageView {
    public SquareRoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        super/*android.view.View*/.onMeasure(i, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824));
    }
}
