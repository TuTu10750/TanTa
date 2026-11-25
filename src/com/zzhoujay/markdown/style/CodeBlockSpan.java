package com.zzhoujay.markdown.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.LineHeightSpan;
import android.text.style.ReplacementSpan;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class CodeBlockSpan extends ReplacementSpan implements LineHeightSpan {
    private static final int padding = 30;
    private static final float radius = 10.0f;
    private int baseLine;
    private Drawable drawable;
    private int lineHeight;
    private List<Pair<Integer, Integer>> lines;
    private CharSequence[] ls;
    private int width;

    public CodeBlockSpan(int i, int i2, CharSequence... charSequenceArr) {
        this.width = i;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(radius);
        this.drawable = gradientDrawable;
        this.ls = charSequenceArr;
    }

    private int getTextInLineLen(CharSequence charSequence, int i, int i2, Paint paint) {
        int i3 = i;
        while (paint.measureText(charSequence, i, i3) < this.width - 60 && (i3 = i3 + 1) <= i2) {
        }
        return i3 - 1;
    }

    private int getTextInLineLenInRange(CharSequence charSequence, int i, int i2, int i3, int i4, Paint paint) {
        if (i3 > i2) {
            return i2;
        }
        while (paint.measureText(charSequence, i, i3) < this.width - 60 && (i3 = i3 + 1) <= i2 && i3 <= i4) {
        }
        return i3 - 1;
    }

    private List<Pair<Integer, Integer>> measureTextLine(CharSequence charSequence, int i, int i2, Paint paint) {
        ArrayList arrayList = new ArrayList();
        int textInLineLen = getTextInLineLen(charSequence, i, i2, paint);
        arrayList.add(new Pair(Integer.valueOf(i), Integer.valueOf(textInLineLen)));
        int i3 = textInLineLen;
        while (i3 < i2) {
            int i4 = textInLineLen + i3;
            CodeBlockSpan codeBlockSpan = this;
            CharSequence charSequence2 = charSequence;
            int i5 = i2;
            int textInLineLenInRange = codeBlockSpan.getTextInLineLenInRange(charSequence2, i3, i5, i4 - 4, i4 + 4, paint);
            textInLineLen = textInLineLenInRange - i3;
            arrayList.add(new Pair(Integer.valueOf(i3), Integer.valueOf(textInLineLenInRange)));
            i3 = textInLineLenInRange;
            this = codeBlockSpan;
            charSequence = charSequence2;
            i2 = i5;
        }
        return arrayList;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int size = this.lines.size();
        int i5 = fontMetricsInt.bottom;
        int i6 = fontMetricsInt.top;
        int i7 = i5 - i6;
        this.lineHeight = i7;
        this.baseLine = -i6;
        fontMetricsInt.ascent = i6;
        int i8 = i5 + (size * i7);
        fontMetricsInt.bottom = i8;
        fontMetricsInt.descent = i8;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6 = (int) f;
        this.drawable.setBounds(i6, i3, this.width + i6, i5);
        this.drawable.draw(canvas);
        float f2 = f + 30.0f;
        int i7 = this.baseLine + (this.lineHeight / 2) + i3;
        int i8 = 0;
        for (Pair<Integer, Integer> pair : this.lines) {
            CharSequence charSequence2 = this.ls[i8];
            canvas.drawText(charSequence2, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), f2 + 30.0f, i7, paint);
            if (((Integer) pair.second).intValue() >= charSequence2.length()) {
                i8++;
            }
            i7 += this.lineHeight;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null && this.lines == null) {
            this.lines = new ArrayList();
            for (CharSequence charSequence2 : this.ls) {
                this.lines.addAll(measureTextLine(charSequence2, 0, charSequence2.length(), paint));
            }
        }
        return this.width;
    }
}
