package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class CustomRecyclerView extends RecyclerView {
    public final GestureDetector T0;
    public boolean U0;
    public boolean V0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            CustomRecyclerView customRecyclerView = CustomRecyclerView.this;
            if (customRecyclerView.V0) {
                customRecyclerView.U0 = true;
            }
        }
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.U0 = false;
        this.V0 = false;
        this.T0 = new GestureDetector(context, new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M1() {
        if (canScrollVertically(-1) || canScrollVertically(1)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    public final void N1(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.V0 = true;
        } else if (action == 1 || action == 3) {
            this.V0 = false;
            this.U0 = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        N1(motionEvent);
        M1();
        return super/*android.view.View*/.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.T0;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
