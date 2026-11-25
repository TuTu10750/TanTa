package com.yunbao.video.custom;

import android.view.View;
import android.widget.LinearLayout;
import defpackage.gi4;

/* loaded from: /tmp/classes2.dex */
public class SliderViewContainer extends LinearLayout {
    public View a;
    public long b;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
    }

    public void a() {
    }

    public View getSliderView() {
        return this.a;
    }

    public long getStartTimeMs() {
        return this.b;
    }

    public void setOnStartTimeChangedListener(a aVar) {
    }

    public void setStartTimeMs(long j) {
        this.b = j;
        a();
    }

    public void setVideoProgressControlloer(gi4 gi4Var) {
    }
}
