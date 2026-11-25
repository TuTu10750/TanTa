package com.yunbao.game.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import defpackage.c93;
import defpackage.ea3;
import defpackage.v73;
import defpackage.z63;

/* loaded from: /tmp/classes2.dex */
public class ZpBetView extends RelativeLayout {
    public int a;
    public Context b;
    public TextView c;
    public TextView d;
    public int e;
    public int f;
    public String g;

    public ZpBetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZpBetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ea3.p3);
        this.a = obtainStyledAttributes.getResourceId(ea3.q3, 0);
        obtainStyledAttributes.recycle();
        this.g = context.getString(c93.g);
    }

    public void a() {
        this.e = 0;
        this.f = 0;
        this.c.setVisibility(4);
        this.d.setVisibility(4);
    }

    public final void b() {
        String valueOf;
        int i = this.f;
        if (i < 10000) {
            valueOf = String.valueOf(i);
        } else if (i % 10000 == 0) {
            valueOf = String.valueOf(this.f / 10000) + this.g;
        } else {
            valueOf = String.format("%.1f", Float.valueOf(this.e / 10000.0f)) + this.g;
        }
        if (this.d.getVisibility() == 4) {
            this.d.setVisibility(0);
        }
        this.d.setText(valueOf);
    }

    public final void c() {
        String valueOf;
        int i = this.e;
        if (i >= 10000) {
            int i2 = i % 10000;
            int i3 = this.e;
            if (i2 == 0) {
                valueOf = String.valueOf(i3 / 10000) + this.g;
            } else {
                valueOf = String.format("%.1f", Float.valueOf(i3 / 10000.0f)) + this.g;
            }
        } else {
            valueOf = String.valueOf(i);
        }
        if (this.c.getVisibility() == 4) {
            this.c.setVisibility(0);
        }
        this.c.setText(valueOf);
    }

    public void d(int i, boolean z) {
        this.e += i;
        c();
        if (z) {
            this.f += i;
            b();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(this.b).inflate(v73.d, (ViewGroup) this, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        inflate.setLayoutParams(layoutParams);
        addView(inflate);
        ((ImageView) inflate.findViewById(z63.n)).setImageResource(this.a);
        this.c = (TextView) inflate.findViewById(z63.h);
        this.d = (TextView) inflate.findViewById(z63.g);
    }
}
