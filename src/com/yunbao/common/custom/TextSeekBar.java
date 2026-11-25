package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import defpackage.da3;
import defpackage.u73;
import defpackage.y63;

/* loaded from: /tmp/classes2.dex */
public class TextSeekBar extends FrameLayout implements SeekBar.OnSeekBarChangeListener {
    public SeekBar a;
    public TextView b;
    public TextView c;
    public Context d;
    public String e;
    public int f;
    public int g;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
    }

    public TextSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = context;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, da3.X4);
        this.e = obtainAttributes.getString(da3.a5);
        this.f = obtainAttributes.getInteger(da3.Y4, 0);
        this.g = obtainAttributes.getInteger(da3.Z4, 100);
        obtainAttributes.recycle();
    }

    public float getFloatProgress() {
        return this.f / 100.0f;
    }

    public int getProgress() {
        return this.f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(this.d).inflate(u73.Z, (ViewGroup) this, false);
        this.a = (SeekBar) inflate.findViewById(y63.d0);
        this.b = (TextView) inflate.findViewById(y63.f0);
        this.c = (TextView) inflate.findViewById(y63.W);
        this.a.setProgress(this.f);
        this.a.setMax(this.g);
        this.a.setOnSeekBarChangeListener(this);
        this.b.setText(this.e);
        this.c.setText(String.valueOf(this.f));
        addView(inflate);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f = i;
        this.c.setText(String.valueOf(i));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        SeekBar seekBar = this.a;
        if (seekBar != null) {
            seekBar.setEnabled(z);
        }
        if (z) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.5f);
        }
    }

    public void setOnSeekChangeListener(a aVar) {
    }

    public void setProgress(int i) {
        this.f = i;
        SeekBar seekBar = this.a;
        if (seekBar != null) {
            seekBar.setProgress(i);
        }
    }
}
