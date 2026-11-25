package com.zzhoujay.markdown.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.QuoteSpan;
import android.widget.TextView;
import com.zzhoujay.markdown.util.NumberKit;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/classes2.dex */
public class QuotaBulletSpan extends QuoteSpan {
    private static final int BULLET_RADIUS = 6;
    private static final int GAP_WIDTH = 40;
    private static final int STRIPE_WIDTH = 15;
    private static Path circleBulletPath = null;
    private static final int mGapWidth = 40;
    private static Path rectBulletPath = null;
    private static final int tab = 40;
    private int bulletColor;
    private final String index;
    private int level;
    private int margin;
    private int quotaLevel;
    private WeakReference<TextView> textViewWeakReference;

    public QuotaBulletSpan(int i, int i2, int i3, int i4, int i5, TextView textView) {
        super(i3);
        this.quotaLevel = i;
        this.level = i2;
        if (i5 <= 0) {
            this.index = null;
        } else if (i2 == 1) {
            this.index = NumberKit.toRomanNumerals(i5);
        } else if (i2 >= 2) {
            this.index = NumberKit.toABC(i5 - 1);
        } else {
            this.index = i5 + "";
        }
        this.bulletColor = i4;
        this.textViewWeakReference = new WeakReference<>(textView);
    }

    @Override // android.text.style.QuoteSpan, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Path path;
        Paint.Style style = paint.getStyle();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getColor());
        for (int i8 = 0; i8 <= this.quotaLevel; i8++) {
            canvas.drawRect((i8 * 55) + i, i3, r1 + (i2 * 15), i5, paint);
        }
        paint.setStyle(style);
        paint.setColor(color);
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            int color2 = paint.getColor();
            paint.setColor(this.bulletColor);
            if (this.index != null) {
                canvas.drawText(this.index + '.', ((i - paint.measureText(this.index)) + this.margin) - 40.0f, i4, paint);
            } else {
                Paint.Style style2 = paint.getStyle();
                if (this.level == 1) {
                    paint.setStyle(Paint.Style.STROKE);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                }
                if (canvas.isHardwareAccelerated()) {
                    if (this.level >= 2) {
                        if (rectBulletPath == null) {
                            Path path2 = new Path();
                            rectBulletPath = path2;
                            path2.addRect(-7.2000003f, -7.2000003f, 7.2000003f, 7.2000003f, Path.Direction.CW);
                        }
                        path = rectBulletPath;
                    } else {
                        if (circleBulletPath == null) {
                            Path path3 = new Path();
                            circleBulletPath = path3;
                            path3.addCircle(0.0f, 0.0f, 7.2000003f, Path.Direction.CW);
                        }
                        path = circleBulletPath;
                    }
                    canvas.save();
                    canvas.translate((this.margin + i) - 40, (i3 + i5) / 2.0f);
                    canvas.drawPath(path, paint);
                    canvas.restore();
                } else {
                    canvas.drawCircle((this.margin + i) - 40, (i3 + i5) / 2.0f, 6.0f, paint);
                }
                paint.setStyle(style2);
            }
            paint.setColor(color2);
        }
    }

    @Override // android.text.style.QuoteSpan, android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        int i;
        WeakReference<TextView> weakReference = this.textViewWeakReference;
        if (weakReference == null && (i = this.margin) != 0) {
            return i;
        }
        TextView textView = weakReference.get();
        if (this.index == null || textView == null) {
            this.margin = ((this.level + 1) * 52) + 40;
        } else {
            this.margin = (int) (((textView.getPaint().measureText(this.index) + 40.0f) * (this.level + 1)) + 40.0f);
        }
        int i2 = this.margin + ((this.quotaLevel + 1) * 55);
        this.margin = i2;
        return i2;
    }
}
