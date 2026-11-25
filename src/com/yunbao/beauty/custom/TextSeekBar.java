package com.yunbao.beauty.custom;

import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class TextSeekBar extends FrameLayout {
    public TextView a;
    public SeekBar b;
    public TextView c;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
    }

    public final void a() {
        SeekBar seekBar = this.b;
        if (seekBar != null) {
            int progress = seekBar.getProgress();
            float max = progress / this.b.getMax();
            TextView textView = this.a;
            if (textView != null) {
                textView.setX(((this.b.getX() + this.b.getPaddingLeft()) + (max * ((this.b.getWidth() - this.b.getPaddingLeft()) - this.b.getPaddingRight()))) - (this.a.getWidth() / 2.0f));
                this.a.setText(String.valueOf(progress));
            }
        }
    }

    public void setActionListener(a aVar) {
    }

    public void setLeftText(int i) {
        TextView textView = this.c;
        if (i == 0) {
            textView.setText("");
        } else {
            textView.setVisibility(0);
            this.c.setText(i);
        }
    }

    public void setMax(int i) {
        SeekBar seekBar = this.b;
        if (seekBar == null || seekBar.getMax() == i) {
            return;
        }
        this.b.setMax(i);
    }

    public void setProgress(int i) {
        SeekBar seekBar = this.b;
        if (seekBar != null) {
            seekBar.setProgress(i);
        }
        a();
    }
}
