package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

/* loaded from: /tmp/classes2.dex */
public abstract class r0 extends b1 implements View.OnClickListener {
    public ObjectAnimator a;
    public ObjectAnimator b;
    public boolean c;
    public boolean d;
    public boolean e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            r0 r0Var = r0.this;
            r0Var.e = false;
            r0Var.d = true;
            r0Var.b0();
            r0.this.loadData();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            r0 r0Var = r0.this;
            r0Var.e = false;
            r0Var.d = false;
            r0Var.a0();
        }
    }

    public r0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public r0(Context context, ViewGroup viewGroup, Object... objArr) {
        super(context, viewGroup, objArr);
    }

    public void a0() {
    }

    public void b0() {
    }

    public void hide() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.start();
    }

    @Override // defpackage.b1
    public void init() {
        setStatusHeight();
        int c = gk3.a().c();
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        float f = c;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContentView, "translationX", f, 0.0f);
        this.a = ofFloat;
        ofFloat.setDuration(200L);
        this.a.setInterpolator(accelerateDecelerateInterpolator);
        this.a.addListener(new a());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mContentView, "translationX", 0.0f, f);
        this.b = ofFloat2;
        ofFloat2.setDuration(200L);
        this.b.setInterpolator(accelerateDecelerateInterpolator);
        this.b.addListener(new b());
        findViewById(y63.f).setOnClickListener(this);
    }

    public boolean isShowed() {
        return this.d;
    }

    public abstract void loadData();

    public void onClick(View view) {
        if (view.getId() == y63.f) {
            hide();
        }
    }

    @Override // defpackage.b1
    public void release() {
        ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.a = null;
        ObjectAnimator objectAnimator2 = this.b;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.a = null;
    }

    public void show() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.a.start();
    }
}
