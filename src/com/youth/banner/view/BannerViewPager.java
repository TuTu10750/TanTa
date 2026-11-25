package com.youth.banner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: /tmp/classes2.dex */
public class BannerViewPager extends ViewPager {
    public boolean o0;

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o0 = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.o0 && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.o0 && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.o0 = z;
    }
}
