package com.yunbao.common.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class ZoomView extends AppCompatImageView implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static float V = 3.0f;
    public float A;
    public float B;
    public int C;
    public boolean D;
    public View.OnLongClickListener E;
    public int F;
    public int G;
    public int H;
    public int I;
    public d J;
    public int K;
    public boolean L;
    public ImageView.ScaleType M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public float S;
    public float T;
    public boolean U;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public e o;
    public final Matrix p;
    public final RectF q;
    public final float[] r;
    public final Matrix s;
    public final Matrix t;
    public final Matrix u;
    public float v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Runnable {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public long g;
        public boolean h;
        public long i;
        public Interpolator j;
        public float k;
        public float l;
        public boolean m;

        /* JADX WARN: Multi-variable type inference failed */
        public c(float f, float f2, float f3, float f4, float f5, float f6) {
            this.i = -1L;
            this.j = new LinearInterpolator();
            this.a = f;
            this.b = f3;
            this.c = f2;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = 200L;
            this.k = ZoomView.this.getWidth() / 2;
            this.l = ZoomView.this.getHeight() / 2;
            this.m = false;
        }

        public c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            this.i = -1L;
            this.j = new LinearInterpolator();
            this.a = f;
            this.b = f3;
            this.c = f2;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = 300L;
            this.k = f7;
            this.l = f8;
            this.m = true;
        }

        public c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z) {
            this.i = -1L;
            this.j = new LinearInterpolator();
            this.a = f;
            this.b = f3;
            this.c = f2;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = 300L;
            this.k = f7;
            this.l = f8;
            this.m = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZoomView zoomView = ZoomView.this;
            if (!zoomView.Q) {
                zoomView.Q = true;
            }
            float f = 0.0f;
            if (this.i == -1) {
                this.i = System.currentTimeMillis();
            } else {
                float interpolation = this.j.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.i) * 1000) / this.g, 1000L), 0L)) / 1000.0f);
                float f2 = (this.k - this.e) * interpolation;
                float f3 = (this.l - this.f) * interpolation;
                float f4 = this.d;
                float f5 = f4 + ((this.b - f4) * interpolation);
                float f6 = this.c;
                float f7 = f6 + ((this.a - f6) * interpolation);
                Matrix matrix = new Matrix();
                matrix.postTranslate(-ZoomView.this.S, -ZoomView.this.T);
                matrix.postScale(f5, f5, 0.0f, 0.0f);
                matrix.postTranslate(ZoomView.this.S, ZoomView.this.T);
                matrix.postTranslate(this.e - ZoomView.this.S, this.f - ZoomView.this.T);
                matrix.postTranslate(f2, f3);
                ZoomView.this.u.reset();
                ZoomView.this.S(matrix);
                if (this.m) {
                    matrix.postConcat(ZoomView.this.u);
                }
                ZoomView.this.setImageMatrix(matrix);
                ZoomView.this.A = f7;
                f = interpolation;
            }
            if (!this.h && f != 1.0f) {
                ZoomView.this.post(this);
                return;
            }
            ZoomView zoomView2 = ZoomView.this;
            zoomView2.Q = false;
            zoomView2.C = zoomView2.T(this.a);
            ZoomView.this.A = r0.C;
            this.h = true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements Runnable {
        public final h a;
        public int b;
        public int c;

        public d(Context context) {
            this.a = new h(context);
        }

        public void a() {
            this.a.c(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF displayRect = ZoomView.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = Math.round(-displayRect.left);
            float f = i;
            if (f < displayRect.width()) {
                i6 = Math.round(displayRect.width() - f);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = Math.round(-displayRect.top);
            float f2 = i2;
            if (f2 < displayRect.height()) {
                i8 = Math.round(displayRect.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.b = round;
            this.c = round2;
            if (round == i6 && round2 == i8) {
                return;
            }
            this.a.b(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.yunbao.common.custom.ZoomView, android.view.View] */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.yunbao.common.custom.ZoomView, android.widget.ImageView] */
        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.a()) {
                ZoomView.this.U = false;
                return;
            }
            int d = this.a.d();
            int e = this.a.e();
            ZoomView.this.s.set(ZoomView.this.getImageMatrix());
            ZoomView.this.s.postTranslate(this.b - d, this.c - e);
            ?? r2 = ZoomView.this;
            r2.setImageMatrix(r2.s);
            this.b = d;
            this.c = e;
            ?? r0 = ZoomView.this;
            r0.U = true;
            r0.X(r0, this);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        public final ScaleGestureDetector a;
        public final GestureDetector b;
        public VelocityTracker c;
        public boolean d;
        public float e;
        public float f;
        public float g;
        public final float h;
        public final float i;
        public Float k;
        public float l;
        public float m;
        public final Matrix j = new Matrix();
        public boolean n = false;

        public e(Context context) {
            this.a = new ScaleGestureDetector(context, this);
            GestureDetector gestureDetector = new GestureDetector(context, this);
            this.b = gestureDetector;
            gestureDetector.setOnDoubleTapListener(this);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.i = viewConfiguration.getScaledMinimumFlingVelocity();
            this.h = viewConfiguration.getScaledTouchSlop();
        }

        public boolean a() {
            return this.a.isInProgress();
        }

        /* JADX WARN: Type inference failed for: r13v6, types: [com.yunbao.common.custom.ZoomView, android.view.View] */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.yunbao.common.custom.ZoomView, android.view.View] */
        /* JADX WARN: Type inference failed for: r3v8, types: [com.yunbao.common.custom.ZoomView, android.widget.ImageView] */
        /* JADX WARN: Type inference failed for: r9v11, types: [com.yunbao.common.custom.ZoomView, android.widget.ImageView] */
        public boolean b(MotionEvent motionEvent) {
            if (!ZoomView.this.L) {
                return false;
            }
            if (this.b.onTouchEvent(motionEvent)) {
                return true;
            }
            this.a.onTouchEvent(motionEvent);
            if (ZoomView.this.L) {
                int pointerCount = motionEvent.getPointerCount();
                float f = 0.0f;
                float f2 = 0.0f;
                for (int i = 0; i < pointerCount; i++) {
                    f += motionEvent.getX(i);
                    f2 += motionEvent.getY(i);
                }
                float f3 = pointerCount;
                float f4 = f / f3;
                float f5 = f2 / f3;
                if (f3 != this.g) {
                    this.d = false;
                    VelocityTracker velocityTracker = this.c;
                    if (velocityTracker != null) {
                        velocityTracker.clear();
                    }
                    this.e = f4;
                    this.f = f5;
                }
                this.g = f3;
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action == 1) {
                        this.n = false;
                        if (this.d) {
                            this.e = f4;
                            this.f = f5;
                            VelocityTracker velocityTracker2 = this.c;
                            if (velocityTracker2 != null) {
                                velocityTracker2.addMovement(motionEvent);
                                this.c.computeCurrentVelocity(IjkMediaCodecInfo.RANK_MAX);
                                float xVelocity = this.c.getXVelocity();
                                float yVelocity = this.c.getYVelocity();
                                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i && ZoomView.this.getDrawable() != null) {
                                    ?? r1 = ZoomView.this;
                                    r1.J = new d(r1.getContext());
                                    ZoomView.this.J.b(ZoomView.this.getWidth(), ZoomView.this.getHeight(), (int) (-xVelocity), (int) (-yVelocity));
                                    ?? r13 = ZoomView.this;
                                    r13.post(r13.J);
                                }
                            }
                        }
                    } else if (action == 2) {
                        float f6 = f4 - this.e;
                        float f7 = f5 - this.f;
                        if (!this.d && motionEvent.getPointerCount() == 1) {
                            this.d = Math.sqrt((double) ((f6 * f6) + (f7 * f7))) >= ((double) this.h);
                        }
                        if (motionEvent.getPointerCount() > 1) {
                            float Z = ZoomView.this.Z(motionEvent);
                            if (ZoomView.this.D && ZoomView.this.w && Math.abs(Z - this.l) > 10.0f) {
                                ZoomView.this.D = false;
                                ZoomView.this.w = false;
                                ZoomView.this.t.set(ZoomView.this.getImageMatrix());
                            }
                            if (!ZoomView.this.D) {
                                Float f8 = this.k;
                                if (f8 == null) {
                                    this.k = Float.valueOf(Z);
                                } else if (this.n) {
                                    this.k = Float.valueOf(Z);
                                    this.n = false;
                                } else {
                                    float floatValue = Z - f8.floatValue();
                                    if (Math.abs(floatValue) > 1.0f) {
                                        if (ZoomView.this.getDrawable() != null) {
                                            ZoomView.M(ZoomView.this, floatValue);
                                            ZoomView.this.s.set(ZoomView.this.getImageMatrix());
                                            ?? r9 = ZoomView.this;
                                            r9.setImageMatrix(r9.s);
                                        }
                                        this.k = Float.valueOf(Z);
                                    }
                                }
                            }
                        }
                        if (this.d) {
                            if (ZoomView.this.getDrawable() != null) {
                                ZoomView.this.s.set(ZoomView.this.getImageMatrix());
                                ZoomView.this.s.postTranslate(f6, f7);
                                ZoomView.this.u.reset();
                                ZoomView zoomView = ZoomView.this;
                                zoomView.S(zoomView.s);
                                ZoomView.this.s.postConcat(ZoomView.this.u);
                                ?? r3 = ZoomView.this;
                                r3.setImageMatrix(r3.s);
                                if (ZoomView.this.n && !ZoomView.this.o.a() && ((ZoomView.this.K == 2 || ((ZoomView.this.K == 0 && f6 >= 1.0f) || (ZoomView.this.K == 1 && f6 <= -1.0f))) && ZoomView.this.getParent() != null)) {
                                    ZoomView.this.getParent().requestDisallowInterceptTouchEvent(false);
                                }
                            }
                            this.e = f4;
                            this.f = f5;
                            VelocityTracker velocityTracker3 = this.c;
                            if (velocityTracker3 != null) {
                                velocityTracker3.addMovement(motionEvent);
                            }
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            this.l = ZoomView.this.Z(motionEvent);
                            this.d = false;
                        } else if (action == 6) {
                            this.d = true;
                            this.n = true;
                        }
                    }
                    this.g = 0.0f;
                    VelocityTracker velocityTracker4 = this.c;
                    if (velocityTracker4 != null) {
                        velocityTracker4.recycle();
                        this.c = null;
                    }
                } else {
                    VelocityTracker velocityTracker5 = this.c;
                    if (velocityTracker5 == null) {
                        this.c = VelocityTracker.obtain();
                    } else {
                        velocityTracker5.clear();
                    }
                    this.c.addMovement(motionEvent);
                    this.e = f4;
                    this.f = f5;
                    this.k = null;
                    this.d = false;
                }
            }
            return true;
        }

        /* JADX WARN: Type inference failed for: r3v4, types: [com.yunbao.common.custom.ZoomView, android.view.View] */
        /* JADX WARN: Type inference failed for: r3v5, types: [com.yunbao.common.custom.ZoomView, android.view.View] */
        /* JADX WARN: Type inference failed for: r3v8, types: [com.yunbao.common.custom.ZoomView, android.view.View] */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (ZoomView.this.O) {
                try {
                    float scaleWithoutRotation = ZoomView.this.getScaleWithoutRotation();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = ZoomView.this.g;
                    float f2 = ZoomView.this.h;
                    float f3 = ZoomView.this.f;
                    ZoomView zoomView = ZoomView.this;
                    if (!zoomView.W(zoomView.C)) {
                        f = ZoomView.this.k;
                        f2 = ZoomView.this.l;
                        f3 = ZoomView.this.j;
                    }
                    float f4 = f;
                    RectF displayRect = ZoomView.this.getDisplayRect();
                    this.j.reset();
                    float[] fArr = {displayRect.centerX() - x, displayRect.centerY() - y};
                    if (scaleWithoutRotation < f4) {
                        float f5 = f4 / scaleWithoutRotation;
                        this.j.postScale(f5, f5);
                        this.j.mapPoints(fArr);
                        ?? r3 = ZoomView.this;
                        r3.post(new c(r3.C, ZoomView.this.A, f4, scaleWithoutRotation, displayRect.centerX(), displayRect.centerY(), fArr[0] + x, fArr[1] + y));
                    } else if (scaleWithoutRotation < f4 || scaleWithoutRotation >= f2) {
                        float f6 = f3 / scaleWithoutRotation;
                        this.j.postScale(f6, f6);
                        this.j.mapPoints(fArr);
                        ?? r32 = ZoomView.this;
                        r32.post(new c(r32.C, ZoomView.this.A, f3, scaleWithoutRotation, displayRect.centerX(), displayRect.centerY(), fArr[0] + x, fArr[1] + y));
                    } else {
                        float f7 = f2 / scaleWithoutRotation;
                        this.j.postScale(f7, f7);
                        this.j.mapPoints(fArr);
                        float f8 = f2;
                        ?? r33 = ZoomView.this;
                        r33.post(new c(r33.C, ZoomView.this.A, f8, scaleWithoutRotation, displayRect.centerX(), displayRect.centerY(), fArr[0] + x, fArr[1] + y));
                    }
                } catch (Exception unused) {
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ZoomView.this.E != null) {
                ZoomView.this.E.onLongClick(ZoomView.this);
            }
        }

        /* JADX WARN: Type inference failed for: r8v4, types: [com.yunbao.common.custom.ZoomView, android.widget.ImageView] */
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (!ZoomView.this.P) {
                return true;
            }
            float scaleWithoutRotation = ZoomView.this.getScaleWithoutRotation();
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float f = ZoomView.this.h;
            float f2 = ZoomView.this.i;
            ZoomView zoomView = ZoomView.this;
            if (!ZoomView.this.V(zoomView.R(zoomView.A))) {
                f = ZoomView.this.l;
                f2 = ZoomView.this.m;
            }
            if (!ZoomView.this.D || ZoomView.this.getDrawable() == null) {
                return true;
            }
            if (scaleWithoutRotation >= f && scaleFactor > 1.0f) {
                return true;
            }
            if (scaleWithoutRotation < f2 && scaleFactor < 1.0f) {
                return true;
            }
            if (ZoomView.this.w && Math.abs(scaleWithoutRotation - this.m) > this.m * 0.1d) {
                ZoomView.this.w = false;
            }
            ZoomView.this.s.set(ZoomView.this.getImageMatrix());
            ZoomView.this.s.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            ZoomView.this.u.reset();
            ZoomView zoomView2 = ZoomView.this;
            zoomView2.S(zoomView2.s);
            ?? r8 = ZoomView.this;
            r8.setImageMatrix(r8.s);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.m = ZoomView.this.getScaleWithoutRotation();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            ZoomView.A(ZoomView.this);
            ZoomView zoomView = ZoomView.this;
            if (!zoomView.U && zoomView.N) {
                ZoomView.C(ZoomView.this);
                ZoomView.E(ZoomView.this);
            }
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface f {
    }

    /* loaded from: /tmp/classes2.dex */
    public interface g {
    }

    /* loaded from: /tmp/classes2.dex */
    public static class h {
        public boolean a = false;
        public Object b;

        public h(Context context) {
            this.b = new OverScroller(context);
        }

        public boolean a() {
            boolean z = this.a;
            Object obj = this.b;
            return z ? ((Scroller) obj).computeScrollOffset() : ((OverScroller) obj).computeScrollOffset();
        }

        public void b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            boolean z = this.a;
            Object obj = this.b;
            if (z) {
                ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
            } else {
                ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        }

        public void c(boolean z) {
            boolean z2 = this.a;
            Object obj = this.b;
            if (z2) {
                ((Scroller) obj).forceFinished(z);
            } else {
                ((OverScroller) obj).forceFinished(z);
            }
        }

        public int d() {
            boolean z = this.a;
            Object obj = this.b;
            return z ? ((Scroller) obj).getCurrX() : ((OverScroller) obj).getCurrX();
        }

        public int e() {
            boolean z = this.a;
            Object obj = this.b;
            return z ? ((Scroller) obj).getCurrY() : ((OverScroller) obj).getCurrY();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface i {
    }

    /* loaded from: /tmp/classes2.dex */
    public static class j {
        public int a;
        public float b;
        public float c;

        public void a(float f) {
            this.b = f;
        }

        public void b(float f) {
            this.c = f;
        }

        public void c(int i) {
            this.a = i;
        }
    }

    public ZoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ZoomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.75f;
        float f2 = V;
        this.h = f2;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = 1.75f;
        this.l = f2;
        this.m = 1.0f;
        this.n = true;
        this.p = new Matrix();
        this.q = new RectF();
        this.r = new float[9];
        this.s = new Matrix();
        this.t = new Matrix();
        this.u = new Matrix();
        this.v = 0.001f;
        this.K = 2;
        this.M = ImageView.ScaleType.FIT_CENTER;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = false;
        this.U = false;
        super/*android.widget.ImageView*/.setScaleType(ImageView.ScaleType.MATRIX);
        setOnTouchListener(this);
        this.o = new e(context);
        setIsZoomEnabled(true);
    }

    public static /* synthetic */ i A(ZoomView zoomView) {
        zoomView.getClass();
        return null;
    }

    public static /* synthetic */ f C(ZoomView zoomView) {
        zoomView.getClass();
        return null;
    }

    public static /* synthetic */ g E(ZoomView zoomView) {
        zoomView.getClass();
        return null;
    }

    public static /* synthetic */ float M(ZoomView zoomView, float f2) {
        float f3 = zoomView.B + f2;
        zoomView.B = f3;
        return f3;
    }

    private int getTargetDegree() {
        int abs = ((int) Math.abs(this.B)) / 45;
        int i2 = abs % 2;
        float f2 = this.B;
        if (i2 == 0) {
            int i3 = this.C;
            return f2 > 0.0f ? i3 + (abs * 45) : i3 - (abs * 45);
        }
        int i4 = this.C;
        return f2 > 0.0f ? i4 + ((abs + 1) * 45) : i4 - ((abs + 1) * 45);
    }

    public float R(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        while (f2 >= 360.0f) {
            f2 -= 360.0f;
        }
        return f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(Matrix matrix) {
        float f2;
        float f3;
        RectF U = U(matrix);
        if (U == null) {
            return;
        }
        float height = U.height();
        float width = U.width();
        float height2 = getHeight();
        float f4 = 0.0f;
        if (height <= height2) {
            int i2 = b.a[this.M.ordinal()];
            if (i2 != 1) {
                f3 = (i2 != 2 ? (height2 - height) / 2.0f : height2 - height) - U.top;
            } else {
                f2 = U.top;
                f3 = -f2;
            }
        } else {
            f2 = U.top;
            if (f2 <= 0.0f) {
                float f5 = U.bottom;
                f3 = f5 < height2 ? height2 - f5 : 0.0f;
            }
            f3 = -f2;
        }
        float width2 = getWidth();
        if (width <= width2) {
            int i3 = b.a[this.M.ordinal()];
            if (i3 != 1) {
                f4 = (i3 != 2 ? (width2 - width) / 2.0f : width2 - width) - U.left;
            } else {
                f4 = -U.left;
            }
            this.K = 2;
        } else {
            float f6 = U.left;
            if (f6 > 0.0f) {
                this.K = 0;
                f4 = -f6;
            } else {
                float f7 = U.right;
                if (f7 < width2) {
                    f4 = width2 - f7;
                    this.K = 1;
                } else {
                    this.K = -1;
                }
            }
        }
        this.u.postTranslate(f4, f3);
    }

    public final int T(float f2) {
        if (Math.abs(f2 - 0.0f) < 10.0f) {
            return 0;
        }
        if (Math.abs(f2 - 90.0f) < 10.0f) {
            return 90;
        }
        if (Math.abs(f2 - 180.0f) < 10.0f) {
            return 180;
        }
        if (Math.abs(f2 - 270.0f) < 10.0f) {
            return 270;
        }
        if (Math.abs(f2 - 360.0f) < 10.0f) {
            return 360;
        }
        return (int) f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RectF U(Matrix matrix) {
        if (getDrawable() == null) {
            return null;
        }
        this.q.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.q);
        return this.q;
    }

    public final boolean V(float f2) {
        if (f2 < 0.0f || f2 >= 45.0f) {
            return (f2 >= 135.0f && f2 < 225.0f) || f2 >= 315.0f;
        }
        return true;
    }

    public final boolean W(int i2) {
        return i2 == 0 || i2 == 180 || i2 == 360;
    }

    public final void X(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y() {
        setImageMatrix(this.p);
        S(this.p);
    }

    public final float Z(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a0() {
        if (!this.L) {
            b0(getDrawable());
        } else {
            super/*android.widget.ImageView*/.setScaleType(ImageView.ScaleType.MATRIX);
            b0(getDrawable());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.C = 0;
        this.A = 0.0f;
        float width = getWidth();
        float height = getHeight();
        if (width == 0.0f || height == 0.0f) {
            getViewTreeObserver().addOnPreDrawListener(new a());
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > intrinsicWidth) {
            this.x = false;
        } else {
            this.x = true;
        }
        float f2 = intrinsicWidth;
        this.S = (f2 * 1.0f) / 2.0f;
        float f3 = intrinsicHeight;
        this.T = (f3 * 1.0f) / 2.0f;
        this.p.reset();
        float f4 = width / f2;
        float f5 = height / f3;
        V = 3.0f;
        if (f4 > f5) {
            this.y = false;
            this.d = f5;
            if (f5 > 0.0f) {
                float f6 = f4 / f5;
                if (f6 > 3.0f) {
                    V = f6;
                }
            }
        } else {
            this.y = true;
            this.d = f4;
            if (f4 > 0.0f) {
                float f7 = f5 / f4;
                if (f7 > 3.0f) {
                    V = f7;
                }
            }
        }
        float f8 = this.d;
        this.f = f8 * 1.0f;
        this.g = f8 * 1.75f;
        float f9 = V;
        this.h = f9 * f8;
        this.i = f8 * 1.0f;
        float f10 = height / f2;
        float f11 = width / f3;
        if (f10 > f11) {
            this.z = true;
            this.e = f11;
        } else {
            this.z = false;
            this.e = f10;
        }
        float f12 = this.e;
        this.j = f12 * 1.0f;
        this.k = 1.75f * f12;
        this.l = f9 * f12;
        this.m = f12 * 1.0f;
        ImageView.ScaleType scaleType = this.M;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.p.postTranslate((width - f2) / 2.0f, (height - f3) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f4, f5);
            this.p.postScale(max, max);
            this.p.postTranslate((width - (f2 * max)) / 2.0f, (height - (f3 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f4, f5));
            this.p.postScale(min, min);
            this.p.postTranslate((width - (f2 * min)) / 2.0f, (height - (f3 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
            RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
            int i2 = b.a[this.M.ordinal()];
            if (i2 == 1) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i2 == 2) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i2 == 3) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i2 == 4) {
                this.p.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        Y();
    }

    public float getCurRotation() {
        return this.A;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Matrix getDisplayMatrix() {
        this.s.set(getImageMatrix());
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RectF getDisplayRect() {
        S(getImageMatrix());
        return U(getDisplayMatrix());
    }

    public float getHorizontalBaseScaleWithoutRotation() {
        return this.d;
    }

    public final ImageView.ScaleType getScaleType() {
        return this.M;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getScaleWithoutRotation() {
        this.s.set(getImageMatrix());
        this.s.getValues(this.r);
        return this.r[0];
    }

    public float getStartRotation() {
        return this.C;
    }

    public float getVerticalBaseScaleWithoutRotation() {
        return this.e;
    }

    public j getZoomState() {
        j jVar = new j();
        jVar.a(this.A);
        jVar.b(this.B);
        jVar.c(this.C);
        return jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.view.View*/.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.view.View*/.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        super/*android.view.View*/.onDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.L) {
            int top2 = getTop();
            int right = getRight();
            int bottom = getBottom();
            int left = getLeft();
            if (top2 == this.F && bottom == this.H && left == this.I && right == this.G) {
                return;
            }
            b0(getDrawable());
            this.F = top2;
            this.G = right;
            this.H = bottom;
            this.I = left;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b3, code lost:
    
        if (r6 < r9) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01b5, code lost:
    
        r7 = r7 + (r9 - r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01b7, code lost:
    
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01b8, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ca, code lost:
    
        if (java.lang.Math.abs(r6 - r7) > 1.0f) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01cc, code lost:
    
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01ce, code lost:
    
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0200, code lost:
    
        if (r0 < r9) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0202, code lost:
    
        r0 = r6 + (r9 - r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0206, code lost:
    
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0214, code lost:
    
        if (java.lang.Math.abs(r0 - r6) > 1.0f) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x024a, code lost:
    
        if (r6 < r9) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x025a, code lost:
    
        if (java.lang.Math.abs(r6 - r7) > 1.0f) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x028b, code lost:
    
        if (r0 < r9) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x029b, code lost:
    
        if (java.lang.Math.abs(r0 - r6) > 1.0f) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        if (r0 != 3) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0121, code lost:
    
        if (r0 < r9) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0123, code lost:
    
        r8 = r8 + (r9 - r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x015d, code lost:
    
        if (r0 < r9) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r20, android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 747
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.common.custom.ZoomView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.n = z;
    }

    public void setCanDoubleTap(boolean z) {
        this.O = z;
    }

    public void setCanScale(boolean z) {
        this.P = z;
    }

    public void setCanSingleTap(boolean z) {
        this.N = z;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        a0();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a0();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        a0();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a0();
    }

    public final void setIsZoomEnabled(boolean z) {
        this.L = z;
        a0();
    }

    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.E = onLongClickListener;
    }

    public final void setOnPhotoTapListener(f fVar) {
    }

    public void setOnSingleTapConfirmedListener(i iVar) {
    }

    public final void setOnViewTapListener(g gVar) {
    }

    public final void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != ImageView.ScaleType.MATRIX) {
            if (scaleType != this.M) {
                this.M = scaleType;
                a0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in ZoomImageView");
    }
}
