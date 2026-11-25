package com.zzhoujay.markdown.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ReplacementSpan;
import com.zzhoujay.markdown.util.NumberKit;

/* loaded from: /tmp/classes2.dex */
public class MarkDownInnerBulletSpan extends ReplacementSpan {
    private static final int BULLET_RADIUS = 6;
    private static Path circleBulletPath = null;
    private static final int gap = 40;
    private static Path rectBulletPath = null;
    private static final int tab = 40;
    private final String index;
    private int level;
    private final int mColor;
    private int margin;

    public MarkDownInnerBulletSpan(int i, int i2, int i3) {
        this.mColor = i2;
        this.level = i;
        if (i3 <= 0) {
            this.index = null;
            return;
        }
        if (i == 1) {
            this.index = NumberKit.toRomanNumerals(i3) + '.';
            return;
        }
        if (i >= 2) {
            this.index = NumberKit.toABC(i3 - 1) + '.';
            return;
        }
        this.index = i3 + ".";
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Path path;
        int color = paint.getColor();
        paint.setColor(this.mColor);
        String str = this.index;
        if (str != null) {
            canvas.drawText(str, f + 40.0f, i4, paint);
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
                canvas.translate((f + this.margin) - 40.0f, (i3 + i5) / 2.0f);
                canvas.drawPath(path, paint);
                canvas.restore();
            } else {
                canvas.drawCircle((f + this.margin) - 40.0f, (i3 + i5) / 2.0f, 6.0f, paint);
            }
            paint.setStyle(style);
        }
        canvas.drawText(charSequence, i, i2, f + this.margin, i4, paint);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        String str = this.index;
        if (str == null) {
            this.margin = ((this.level + 1) * 52) + 40;
        } else {
            this.margin = (int) (((paint.measureText(str) + 40.0f) * (this.level + 1)) + 40.0f);
        }
        return (int) (this.margin + paint.measureText(charSequence, i, i2));
    }
}
