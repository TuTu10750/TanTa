package com.yunbao.game.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.c93;
import defpackage.ea3;

/* loaded from: /tmp/classes2.dex */
public class GameBetCoinView extends LinearLayout {
    public Context a;
    public TextView b;
    public TextView c;
    public TextView d;
    public String e;
    public int f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;

    public GameBetCoinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameBetCoinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ea3.A0);
        this.e = obtainStyledAttributes.getString(ea3.E0);
        this.f = obtainStyledAttributes.getColor(ea3.F0, -13421773);
        this.g = obtainStyledAttributes.getDimension(ea3.G0, 0.0f);
        this.h = (int) obtainStyledAttributes.getDimension(ea3.B0, 0.0f);
        this.i = (int) obtainStyledAttributes.getDimension(ea3.C0, 0.0f);
        this.j = (int) obtainStyledAttributes.getDimension(ea3.D0, 0.0f);
        obtainStyledAttributes.recycle();
        setOrientation(1);
        setGravity(1);
        this.m = context.getString(c93.g);
    }

    public void a() {
        this.k = 0;
        this.l = 0;
        this.c.setText("0");
        this.d.setText("0");
    }

    public void b(int i, int i2) {
        this.k = i;
        this.l = i2;
        d();
        c();
    }

    public final void c() {
        String valueOf;
        int i = this.l;
        if (i < 10000) {
            valueOf = String.valueOf(i);
        } else if (i % 10000 == 0) {
            valueOf = String.valueOf(this.l / 10000) + this.m;
        } else {
            valueOf = String.format("%.1f", Float.valueOf(this.k / 10000.0f)) + this.m;
        }
        this.d.setText(valueOf);
    }

    public final void d() {
        String valueOf;
        int i = this.k;
        if (i >= 10000) {
            int i2 = i % 10000;
            int i3 = this.k;
            if (i2 == 0) {
                valueOf = String.valueOf(i3 / 10000) + this.m;
            } else {
                valueOf = String.format("%.1f", Float.valueOf(i3 / 10000.0f)) + this.m;
            }
        } else {
            valueOf = String.valueOf(i);
        }
        this.c.setText(valueOf);
    }

    public void e(int i, boolean z) {
        this.k += i;
        d();
        if (z) {
            this.l += i;
            c();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.b = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.h, 0, 0);
        this.b.setLayoutParams(layoutParams);
        this.b.setText(this.e);
        this.b.setTextSize(0, this.g);
        this.b.setTextColor(this.f);
        addView(this.b);
        this.c = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, this.i, 0, 0);
        this.c.setLayoutParams(layoutParams2);
        this.c.setText(String.valueOf(this.k));
        this.c.setTextSize(0, this.g);
        this.c.setTextColor(this.f);
        addView(this.c);
        this.d = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, this.j, 0, 0);
        this.d.setLayoutParams(layoutParams3);
        this.d.setText(String.valueOf(this.l));
        this.d.setTextSize(0, this.g);
        this.d.setTextColor(this.f);
        addView(this.d);
    }
}
