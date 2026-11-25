package com.zzhoujay.markdown.style;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: /tmp/classes2.dex */
public class ScaleHeightSpan implements LineHeightSpan {
    private float scale;

    public ScaleHeightSpan(float f) {
        this.scale = f;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        float f = fontMetricsInt.ascent;
        float f2 = this.scale;
        fontMetricsInt.ascent = (int) (f * f2);
        fontMetricsInt.top = (int) (fontMetricsInt.top * f2);
        fontMetricsInt.descent = (int) (fontMetricsInt.descent * f2);
        fontMetricsInt.bottom = (int) (fontMetricsInt.bottom * f2);
    }
}
