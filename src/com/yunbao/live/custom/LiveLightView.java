package com.yunbao.live.custom;

import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /tmp/classes2.dex */
public class LiveLightView extends AppCompatImageView {
    public static int j;
    public boolean d;
    public ValueAnimator e;
    public TimeInterpolator f;
    public ValueAnimator.AnimatorUpdateListener g;
    public AnimatorListenerAdapter h;
    public boolean i;

    public void c() {
        this.i = true;
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.e.isRunning())) {
            this.e.cancel();
        }
        this.g = null;
        this.h = null;
    }

    public void setIdle(boolean z) {
        this.d = z;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.f = timeInterpolator;
    }
}
