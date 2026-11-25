package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* loaded from: /tmp/classes2.dex */
public class kx extends ImageSpan {
    public kx(Drawable drawable) {
        super(drawable, 1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(f, i6);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.descent;
            int i4 = fontMetricsInt2.ascent;
            int i5 = i3 - i4;
            int i6 = bounds.bottom - bounds.top;
            if (i6 > i5) {
                int i7 = (i6 - i5) / 2;
                int i8 = i4 - i7;
                fontMetricsInt.ascent = i8;
                int i9 = i3 + i7;
                fontMetricsInt.descent = i9;
                fontMetricsInt.top = i8;
                fontMetricsInt.bottom = i9;
            } else {
                fontMetricsInt.ascent = i4;
                fontMetricsInt.descent = i3;
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
            }
        }
        return bounds.right;
    }
}
