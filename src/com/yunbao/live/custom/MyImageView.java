package com.yunbao.live.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.RotateAnimation;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /tmp/classes2.dex */
public class MyImageView extends AppCompatImageView {
    public boolean d;
    public RotateAnimation e;

    public MyImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RotateAnimation rotateAnimation = new RotateAnimation(-30.0f, 30.0f, 1, 0.5f, 1, 0.2f);
        this.e = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.e.setRepeatCount(-1);
        this.e.setRepeatMode(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        if (this.d) {
            return;
        }
        this.d = true;
        startAnimation(this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d() {
        if (this.d) {
            this.d = false;
            clearAnimation();
        }
    }
}
