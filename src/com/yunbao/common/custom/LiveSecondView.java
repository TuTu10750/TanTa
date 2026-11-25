package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.trtc.tuikit.common.util.ScreenUtil;

/* loaded from: /tmp/classes2.dex */
public class LiveSecondView extends FrameLayout {
    public GestureDetector a;
    public View b;
    public Boolean c;
    public b d;

    /* loaded from: /tmp/classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f > 0.0f) {
                Log.i("9527", "Move Right");
                if (LiveSecondView.this.c.booleanValue()) {
                    int screenWidth = ScreenUtil.getScreenWidth(LiveSecondView.this.getContext());
                    Log.i("9527", "width :" + LiveSecondView.this.b.getWidth());
                    if (LiveSecondView.this.d != null) {
                        LiveSecondView.this.d.a(LiveSecondView.this.b.getX(), screenWidth);
                    }
                }
                return true;
            }
            if (f >= 0.0f) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            if (!LiveSecondView.this.c.booleanValue()) {
                int screenWidth2 = ScreenUtil.getScreenWidth(LiveSecondView.this.getContext());
                Log.i("9527", "width :" + LiveSecondView.this.b.getWidth());
                if (LiveSecondView.this.d != null) {
                    LiveSecondView.this.d.a(LiveSecondView.this.b.getX(), screenWidth2 - LiveSecondView.this.b.getWidth());
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float x = LiveSecondView.this.b.getX() - f;
            if (x < ScreenUtil.getScreenWidth(LiveSecondView.this.getContext()) - LiveSecondView.this.b.getWidth() || x >= ScreenUtil.getScreenWidth(LiveSecondView.this.getContext())) {
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            LiveSecondView.this.b.setX(x);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(float f, float f2);
    }

    public LiveSecondView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void d() {
        this.a = new GestureDetector(getContext(), new a());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.a.onTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            int screenWidth = ScreenUtil.getScreenWidth(getContext());
            float f = screenWidth;
            if (this.b.getX() < f) {
                this.b.getWidth();
                Log.i("9527", "width :" + this.b.getWidth());
                float x = this.b.getX();
                if (x <= screenWidth - (this.b.getWidth() / 2)) {
                    f = screenWidth - this.b.getWidth();
                }
                b bVar = this.d;
                if (bVar != null) {
                    bVar.a(x, f);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMoveAction(b bVar) {
        this.d = bVar;
    }

    public void setRecommendLayout(View view) {
        this.b = view;
    }

    public void setRecommendShow(boolean z) {
        this.c = Boolean.valueOf(z);
    }
}
