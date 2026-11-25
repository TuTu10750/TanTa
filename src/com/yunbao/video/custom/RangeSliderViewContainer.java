package com.yunbao.video.custom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: /tmp/classes2.dex */
public class RangeSliderViewContainer extends LinearLayout {
    public View a;
    public View b;
    public View c;
    public View d;
    public long e;
    public long f;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
    }

    public ViewGroup getContainer() {
        return (ViewGroup) this.a;
    }

    public long getDuration() {
        return this.f;
    }

    public View getEndView() {
        return this.c;
    }

    public long getStartTimeUs() {
        return this.e;
    }

    public View getStartView() {
        return this.b;
    }

    public void setDurationChangeListener(a aVar) {
    }

    public void setMiddleRangeColor(int i) {
        this.d.setBackgroundColor(i);
    }
}
