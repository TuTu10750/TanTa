package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/* loaded from: /tmp/classes2.dex */
public class eb1 extends b1 {
    public ImageView a;
    public View b;
    public ObjectAnimator c;
    public ObjectAnimator d;
    public RotateAnimation e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (eb1.this.b == null || eb1.this.e == null) {
                return;
            }
            eb1.this.b.startAnimation(eb1.this.e);
        }
    }

    public eb1(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void d0(int i) {
        this.a.setImageResource(za1.d(i));
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return v73.e;
    }

    public void hide() {
        View view = this.b;
        if (view != null) {
            view.clearAnimation();
        }
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (ImageView) findViewById(z63.n);
        this.b = findViewById(z63.l);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.e = rotateAnimation;
        rotateAnimation.setDuration(5000L);
        this.e.setRepeatCount(-1);
        this.e.setInterpolator(new LinearInterpolator());
        float height = (this.mParentView.getHeight() / 2) + zn0.a(100);
        this.mContentView.setTranslationY(height);
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContentView, "translationY", height, 0.0f);
        this.c = ofFloat;
        ofFloat.setDuration(500L);
        this.c.setInterpolator(accelerateDecelerateInterpolator);
        this.c.addListener(new a());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mContentView, "translationY", 0.0f, height);
        this.d = ofFloat2;
        ofFloat2.setDuration(500L);
        this.d.setInterpolator(accelerateDecelerateInterpolator);
    }

    @Override // defpackage.b1
    public void release() {
        View view = this.b;
        if (view != null) {
            view.clearAnimation();
        }
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    public void show() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }
}
