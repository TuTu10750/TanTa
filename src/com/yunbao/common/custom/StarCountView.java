package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.da3;

/* loaded from: /tmp/classes2.dex */
public class StarCountView extends AppCompatTextView {
    public Drawable h;
    public Drawable i;
    public int j;
    public int k;
    public int l;
    public String m;
    public SpannableStringBuilder n;

    public StarCountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StarCountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.w4);
        this.h = obtainStyledAttributes.getDrawable(da3.x4);
        this.i = obtainStyledAttributes.getDrawable(da3.B4);
        this.j = (int) obtainStyledAttributes.getDimension(da3.y4, 0.0f);
        this.k = obtainStyledAttributes.getInt(da3.A4, 5);
        this.l = obtainStyledAttributes.getInt(da3.z4, 0);
        obtainStyledAttributes.recycle();
        int i2 = this.j;
        if (i2 > 0) {
            this.h.setBounds(0, 0, i2, i2);
            Drawable drawable = this.i;
            int i3 = this.j;
            drawable.setBounds(0, 0, i3, i3);
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.k; i4++) {
            sb.append(String.valueOf(i4));
            if (i4 < this.k - 1) {
                sb.append(" ");
            }
        }
        this.m = sb.toString();
        setFillCount(this.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFillCount(int i) {
        if (this.n == null) {
            this.n = new SpannableStringBuilder();
        }
        this.n.clear();
        this.n.append((CharSequence) this.m);
        for (int i2 = 0; i2 < this.k; i2++) {
            int indexOf = this.m.indexOf(String.valueOf(i2));
            SpannableStringBuilder spannableStringBuilder = this.n;
            if (i2 < i) {
                spannableStringBuilder.setSpan(new ImageSpan(this.h), indexOf, indexOf + 1, 33);
            } else {
                spannableStringBuilder.setSpan(new ImageSpan(this.i), indexOf, indexOf + 1, 33);
            }
        }
        setText(this.n);
    }
}
