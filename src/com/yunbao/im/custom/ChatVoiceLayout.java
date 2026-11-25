package com.yunbao.im.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.yunbao.im.bean.ImMessageBean;
import com.yunbao.im.dao.IMMessageBean;
import defpackage.ga3;
import defpackage.s83;

/* loaded from: /tmp/classes2.dex */
public class ChatVoiceLayout extends FrameLayout {
    public Context a;
    public int b;
    public int c;
    public float d;
    public int e;
    public int f;
    public int g;
    public ImageView h;
    public Drawable[] i;
    public int j;
    public ImMessageBean k;
    public IMMessageBean l;

    public ChatVoiceLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatVoiceLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 2;
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ga3.H);
        this.b = obtainStyledAttributes.getInt(ga3.J, 0);
        this.c = obtainStyledAttributes.getInt(ga3.I, 0);
        obtainStyledAttributes.recycle();
        this.d = context.getResources().getDisplayMetrics().density;
        this.e = c(200);
        this.f = c(24);
        this.g = c(6);
        Drawable[] drawableArr = new Drawable[3];
        this.i = drawableArr;
        if (this.c == 0) {
            drawableArr[0] = o60.d(context, s83.b);
            this.i[1] = o60.d(context, s83.c);
            this.i[2] = o60.d(context, s83.d);
        } else {
            drawableArr[0] = o60.d(context, s83.e);
            this.i[1] = o60.d(context, s83.f);
            this.i[2] = o60.d(context, s83.g);
        }
    }

    public void a(int i) {
        if (i == this.j) {
            return;
        }
        ImageView imageView = this.h;
        if (imageView != null && i >= 0 && i < 3) {
            imageView.setImageDrawable(this.i[i]);
        }
        this.j = i;
    }

    public void b() {
        ImageView imageView;
        if (this.j == 2 || (imageView = this.h) == null) {
            return;
        }
        imageView.setImageDrawable(this.i[2]);
    }

    public final int c(int i) {
        return (int) ((this.d * i) + 0.5f);
    }

    public IMMessageBean getIMMessageBean() {
        return this.l;
    }

    public ImMessageBean getImMessageBean() {
        return this.k;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = new ImageView(this.a);
        int c = c(24);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, c);
        if (this.c == 0) {
            layoutParams.gravity = 19;
        } else {
            layoutParams.gravity = 21;
        }
        this.h.setLayoutParams(layoutParams);
        this.h.setImageDrawable(this.i[2]);
        addView(this.h);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = (this.g * this.b) + this.f;
        int i4 = this.e;
        if (i3 > i4) {
            i3 = i4;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
    }

    public void setDuration(int i) {
        if (this.b == i || this.h == null) {
            return;
        }
        this.b = i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i2 = (this.g * this.b) + this.f;
        int i3 = this.e;
        if (i2 > i3) {
            i2 = i3;
        }
        layoutParams.width = i2;
        setLayoutParams(layoutParams);
    }

    public void setIMMessageBean(IMMessageBean iMMessageBean) {
        this.l = iMMessageBean;
    }

    public void setImMessageBean(ImMessageBean imMessageBean) {
        this.k = imMessageBean;
    }
}
