package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import defpackage.gi3;

/* loaded from: /tmp/classes2.dex */
public class GestureCropImageView extends CropImageView {
    public ScaleGestureDetector G;
    public gi3 H;
    public GestureDetector I;
    public float J;
    public float K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;

    /* loaded from: /tmp/classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.D(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.o(-f, -f2);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends gi3.b {
        public c() {
        }

        @Override // gi3.a
        public boolean a(gi3 gi3Var) {
            GestureCropImageView.this.m(gi3Var.c(), GestureCropImageView.this.J, GestureCropImageView.this.K);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.n(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.J, GestureCropImageView.this.K);
            return true;
        }
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K() {
        this.I = new GestureDetector(getContext(), new b(), null, true);
        this.G = new ScaleGestureDetector(getContext(), new d());
        this.H = new gi3(new c());
    }

    public int getDoubleTapScaleSteps() {
        return this.O;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.O));
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void k() {
        super.k();
        K();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            v();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.J = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.K = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        if (this.N) {
            this.I.onTouchEvent(motionEvent);
        }
        if (this.M) {
            this.G.onTouchEvent(motionEvent);
        }
        if (this.L) {
            this.H.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            B();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.O = i;
    }

    public void setGestureEnabled(boolean z) {
        this.N = z;
    }

    public void setRotateEnabled(boolean z) {
        this.L = z;
    }

    public void setScaleEnabled(boolean z) {
        this.M = z;
    }
}
