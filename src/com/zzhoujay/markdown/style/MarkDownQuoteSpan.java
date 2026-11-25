package com.zzhoujay.markdown.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.QuoteSpan;

/* loaded from: /tmp/classes2.dex */
public class MarkDownQuoteSpan extends QuoteSpan {
    private static final int GAP_WIDTH = 40;
    private static final int STRIPE_WIDTH = 15;

    public MarkDownQuoteSpan() {
    }

    public MarkDownQuoteSpan(int i) {
        super(i);
    }

    @Override // android.text.style.QuoteSpan, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getColor());
        canvas.drawRect(i, i3, i + (i2 * 15), i5, paint);
        paint.setStyle(style);
        paint.setColor(color);
    }

    @Override // android.text.style.QuoteSpan, android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 55;
    }
}
