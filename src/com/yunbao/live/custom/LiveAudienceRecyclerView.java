package com.yunbao.live.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class LiveAudienceRecyclerView extends RecyclerView {
    public float T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;

    public LiveAudienceRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveAudienceRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.T0 = displayMetrics.density;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        this.U0 = M1(10);
        this.X0 = i3 - M1(50);
        this.W0 = i2 - M1(100);
        this.V0 = this.X0 - M1(200);
    }

    public final int M1(int i) {
        return (int) ((this.T0 * i) + 0.5f);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (rawX < this.U0 || rawX > this.W0 || rawY < this.V0 || rawY > this.X0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }
}
