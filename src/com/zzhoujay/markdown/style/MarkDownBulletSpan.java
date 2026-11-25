package com.zzhoujay.markdown.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.widget.TextView;
import com.zzhoujay.markdown.util.NumberKit;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/classes2.dex */
public class MarkDownBulletSpan extends BulletSpan {
    private static final int BULLET_RADIUS = 6;
    private static Path circleBulletPath = null;
    private static final int mGapWidth = 40;
    private static Path rectBulletPath = null;
    private static final int tab = 40;
    private final String index;
    private int level;
    private final int mColor;
    private final boolean mWantColor;
    private int margin;
    private WeakReference<TextView> textViewWeakReference;

    public MarkDownBulletSpan(int i, int i2, int i3) {
        super(40, i2);
        this.level = i;
        if (i3 <= 0) {
            this.index = null;
        } else if (i == 1) {
            this.index = NumberKit.toRomanNumerals(i3);
        } else if (i >= 2) {
            this.index = NumberKit.toABC(i3 - 1);
        } else {
            this.index = i3 + "";
        }
        this.mWantColor = true;
        this.mColor = i2;
    }

    public MarkDownBulletSpan(int i, int i2, int i3, TextView textView) {
        super(40, i2);
        this.level = i;
        if (i3 <= 0) {
            this.index = null;
        } else if (i == 1) {
            this.index = NumberKit.toRomanNumerals(i3);
        } else if (i >= 2) {
            this.index = NumberKit.toABC(i3 - 1);
        } else {
            this.index = i3 + "";
        }
        this.mWantColor = true;
        this.mColor = i2;
        this.textViewWeakReference = new WeakReference<>(textView);
    }

    @Override // android.text.style.BulletSpan, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        Path path;
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            if (this.mWantColor) {
                i8 = paint.getColor();
                paint.setColor(this.mColor);
            } else {
                i8 = 0;
            }
            if (this.index != null) {
                canvas.drawText(this.index + '.', ((i - paint.measureText(this.index)) + this.margin) - 40.0f, i4, paint);
            } else {
                Paint.Style style = paint.getStyle();
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
                    canvas.translate((i + this.margin) - 40, (i3 + i5) / 2.0f);
                    canvas.drawPath(path, paint);
                    canvas.restore();
                } else {
                    canvas.drawCircle((i + this.margin) - 40, (i3 + i5) / 2.0f, 6.0f, paint);
                }
                paint.setStyle(style);
            }
            if (this.mWantColor) {
                paint.setColor(i8);
            }
        }
    }

    @Override // android.text.style.BulletSpan, android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        WeakReference<TextView> weakReference = this.textViewWeakReference;
        TextView textView = weakReference != null ? weakReference.get() : null;
        if (this.index == null || textView == null) {
            this.margin = ((this.level + 1) * 52) + 40;
        } else {
            this.margin = (int) (((textView.getPaint().measureText(this.index) + 40.0f) * (this.level + 1)) + 40.0f);
        }
        return this.margin;
    }
}
