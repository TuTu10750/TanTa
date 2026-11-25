package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.commonsdk.statistics.UMErrorCode;
import com.yunbao.live.bean.LiveGiftPrizePoolWinBean;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /tmp/classes2.dex */
public class w22 extends b1 {
    public View a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;
    public ValueAnimator g;
    public ScaleAnimation h;
    public RotateAnimation i;
    public int j;
    public ConcurrentLinkedQueue k;
    public boolean l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (w22.this.a != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                w22.this.a.setTranslationX(floatValue);
                w22.this.a.setTranslationY(floatValue * 0.7f);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (w22.this.f != null) {
                w22.this.f.startAnimation(w22.this.i);
            }
            if (w22.this.g != null) {
                w22.this.g.start();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            w22.this.l = false;
            if (w22.this.k == null) {
                return;
            }
            LiveGiftPrizePoolWinBean liveGiftPrizePoolWinBean = (LiveGiftPrizePoolWinBean) w22.this.k.poll();
            w22 w22Var = w22.this;
            if (liveGiftPrizePoolWinBean != null) {
                w22Var.j0(liveGiftPrizePoolWinBean);
            } else {
                if (w22Var.e == null || w22.this.e.getVisibility() != 0) {
                    return;
                }
                w22.this.e.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public w22(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.C1;
    }

    public void i0() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.k;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        ScaleAnimation scaleAnimation = this.h;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        RotateAnimation rotateAnimation = this.i;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        View view = this.a;
        if (view != null) {
            view.setTranslationX(-this.j);
            this.a.setTranslationY(-this.j);
        }
        View view2 = this.f;
        if (view2 != null) {
            view2.clearAnimation();
        }
        View view3 = this.e;
        if (view3 != null) {
            view3.clearAnimation();
            if (this.e.getVisibility() == 0) {
                this.e.setVisibility(4);
            }
        }
    }

    @Override // defpackage.b1
    public void init() {
        this.k = new ConcurrentLinkedQueue();
        this.j = zn0.a(UMErrorCode.E_UM_BE_NOT_MAINPROCESS);
        this.a = findViewById(b73.T3);
        this.b = (ImageView) findViewById(b73.d);
        this.c = (TextView) findViewById(b73.X3);
        this.d = (TextView) findViewById(b73.s1);
        this.f = findViewById(b73.J2);
        this.e = findViewById(b73.q6);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-this.j, this.mParentView.getWidth());
        this.g = ofFloat;
        ofFloat.setDuration(2000L);
        this.g.addUpdateListener(new a());
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.h = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.h.setAnimationListener(new b());
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        this.i = rotateAnimation;
        rotateAnimation.setDuration(1000L);
        this.i.setRepeatCount(2);
        this.i.setInterpolator(new LinearInterpolator());
        this.i.setAnimationListener(new c());
    }

    public void j0(LiveGiftPrizePoolWinBean liveGiftPrizePoolWinBean) {
        if (this.e == null || this.l) {
            return;
        }
        this.l = true;
        if (this.b != null) {
            kn1.g(this.mContext, liveGiftPrizePoolWinBean.getAvatar(), this.b);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(liveGiftPrizePoolWinBean.getName());
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(liveGiftPrizePoolWinBean.getCoin());
        }
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        this.e.startAnimation(this.h);
    }

    @Override // defpackage.b1
    public void release() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.k;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        this.k = null;
        View view = this.f;
        if (view != null) {
            view.clearAnimation();
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.clearAnimation();
        }
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.g.removeAllUpdateListeners();
            this.g.removeAllListeners();
        }
        ScaleAnimation scaleAnimation = this.h;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.h.setAnimationListener(null);
        }
        RotateAnimation rotateAnimation = this.i;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
            this.i.setAnimationListener(null);
        }
    }
}
