package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.yunbao.live.bean.LiveLuckGiftWinBean;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /tmp/classes2.dex */
public class t22 extends b1 {
    public int a;
    public int b;
    public View c;
    public TextView d;
    public String e;
    public ObjectAnimator f;
    public ObjectAnimator g;
    public ObjectAnimator h;
    public boolean i;
    public ConcurrentLinkedQueue j;

    /* loaded from: /tmp/classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (t22.this.h != null) {
                t22.this.h.start();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LiveLuckGiftWinBean liveLuckGiftWinBean;
            t22.this.i = false;
            if (t22.this.j == null || (liveLuckGiftWinBean = (LiveLuckGiftWinBean) t22.this.j.poll()) == null) {
                return;
            }
            t22.this.g0(liveLuckGiftWinBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (t22.this.g != null) {
                t22.this.g.start();
            }
        }
    }

    public t22(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void f0() {
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.g;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.h;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = this.j;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
    }

    public void g0(LiveLuckGiftWinBean liveLuckGiftWinBean) {
        if (this.i) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.j;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.offer(liveLuckGiftWinBean);
                return;
            }
            return;
        }
        this.i = true;
        this.d.setText(String.format(this.e, liveLuckGiftWinBean.getUserNiceName(), liveLuckGiftWinBean.getGiftName(), liveLuckGiftWinBean.getLuckTime()));
        this.d.measure(0, 0);
        int width = this.mParentView.getWidth();
        if (this.a != width) {
            this.a = width;
            this.c.getLayoutParams().width = this.a + this.b;
            this.c.requestLayout();
            this.d.setTranslationX(this.a);
            this.f.setFloatValues(this.a, -this.b);
            ObjectAnimator objectAnimator = this.g;
            int i = this.b;
            objectAnimator.setFloatValues(-i, (-i) - this.a);
        }
        this.h.setFloatValues(width, -this.d.getMeasuredWidth());
        this.f.start();
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.A1;
    }

    @Override // defpackage.b1
    public void init() {
        this.j = new ConcurrentLinkedQueue();
        this.e = aq4.a(m93.F3);
        this.c = findViewById(b73.L4);
        this.d = (TextView) findViewById(b73.Q3);
        this.a = this.mParentView.getWidth();
        this.b = zn0.a(20);
        this.c.getLayoutParams().width = this.a + this.b;
        this.c.requestLayout();
        this.d.setTranslationX(this.a);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationX", this.a, -this.b);
        this.f = ofFloat;
        ofFloat.setDuration(400L);
        this.f.setInterpolator(linearInterpolator);
        this.f.addListener(new a());
        View view = this.c;
        int i = this.b;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", -i, (-i) - this.a);
        this.g = ofFloat2;
        ofFloat2.setDuration(400L);
        this.g.setInterpolator(linearInterpolator);
        this.g.addListener(new b());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.d, "translationX", 0.0f);
        this.h = ofFloat3;
        ofFloat3.setDuration(3000L);
        this.h.setInterpolator(linearInterpolator);
        this.h.setRepeatCount(1);
        this.h.addListener(new c());
    }

    @Override // defpackage.b1
    public void release() {
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f.removeAllListeners();
            this.f.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator2 = this.g;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.g.removeAllListeners();
            this.g.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator3 = this.h;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
            this.h.removeAllListeners();
            this.h.removeAllUpdateListeners();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = this.j;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = null;
    }
}
