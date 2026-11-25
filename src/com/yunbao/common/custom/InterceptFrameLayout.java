package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: /tmp/classes2.dex */
public class InterceptFrameLayout extends FrameLayout {
    public boolean a;
    public a b;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        boolean a();
    }

    public InterceptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.b;
        if (aVar == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean a2 = aVar.a();
        this.a = a2;
        return a2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnInterceptListener(a aVar) {
        this.b = aVar;
    }
}
