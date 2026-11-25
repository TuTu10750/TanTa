package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.LiveReceiveGiftBean;

/* loaded from: /tmp/classes2.dex */
public class x22 extends b1 {
    public View a;
    public View b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public int k;
    public ObjectAnimator l;
    public Animation m;
    public boolean n;
    public boolean o;
    public String p;
    public int q;
    public Handler r;
    public o92 s;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (x22.this.b != null) {
                x22.this.b.setTranslationX(-x22.this.k);
            }
            if (x22.this.c != null && x22.this.c.getVisibility() == 0) {
                x22.this.c.setVisibility(4);
            }
            if (x22.this.h != null && x22.this.h.getVisibility() != 0) {
                x22.this.h.setVisibility(0);
                x22.this.h.setText(n52.d(x22.this.q));
            }
            if (x22.this.h != null) {
                x22.this.h.clearAnimation();
                if (x22.this.m != null) {
                    x22.this.h.startAnimation(x22.this.m);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (x22.this.c != null && x22.this.c.getVisibility() != 0) {
                x22.this.c.setVisibility(0);
            }
            if (x22.this.r != null) {
                x22.this.r.sendEmptyMessageDelayed(0, 200L);
            }
        }
    }

    public x22(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void i0() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.clearAnimation();
        }
        o92 o92Var = this.s;
        if (o92Var != null) {
            o92Var.l0();
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.V1;
    }

    public void hide() {
        View view = this.b;
        if (view != null) {
            view.setTranslationX(-this.k);
        }
        TextView textView = this.h;
        if (textView != null && textView.getVisibility() == 0) {
            this.h.setVisibility(4);
        }
        View view2 = this.a;
        if (view2 != null && view2.getVisibility() == 0) {
            this.a.setVisibility(4);
        }
        this.d.setImageDrawable(null);
        this.g.setImageDrawable(null);
        this.n = true;
        this.o = false;
        this.q = 0;
        this.p = null;
        o92 o92Var = this.s;
        if (o92Var != null) {
            o92Var.hide();
        }
    }

    @Override // defpackage.b1
    public void init() {
        this.a = findViewById(b73.L4);
        this.b = findViewById(b73.j);
        this.c = findViewById(b73.Y4);
        this.d = (ImageView) findViewById(b73.d);
        this.e = (TextView) findViewById(b73.X3);
        this.f = (TextView) findViewById(b73.C1);
        this.g = (ImageView) findViewById(b73.h2);
        this.h = (TextView) findViewById(b73.b2);
        this.i = (TextView) findViewById(b73.f2);
        this.j = (TextView) findViewById(b73.V3);
        this.k = zn0.a(214);
        this.r = new a();
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "translationX", 0.0f);
        this.l = ofFloat;
        ofFloat.setDuration(300L);
        this.l.setInterpolator(accelerateDecelerateInterpolator);
        this.l.addListener(new b());
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 0.7f, 1.5f, 0.7f, 1, 0.0f, 1, 1.0f);
        this.m = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.m.setInterpolator(accelerateDecelerateInterpolator);
        this.n = true;
    }

    public void j0() {
        i0();
        hide();
    }

    public void k0() {
        View view = this.b;
        if (view != null) {
            view.setTranslationX(-this.k);
        }
        TextView textView = this.h;
        if (textView != null && textView.getVisibility() == 0) {
            this.h.setVisibility(4);
        }
        View view2 = this.a;
        if (view2 != null && view2.getVisibility() == 0) {
            this.a.setVisibility(4);
        }
        this.d.setImageDrawable(null);
        this.g.setImageDrawable(null);
        this.n = true;
        this.o = false;
        this.q = 0;
        this.p = null;
        o92 o92Var = this.s;
        if (o92Var != null) {
            o92Var.o0(0);
        }
    }

    public boolean l0() {
        if (!this.n) {
            return false;
        }
        o92 o92Var = this.s;
        return o92Var == null || o92Var.m0();
    }

    public boolean m0(LiveReceiveGiftBean liveReceiveGiftBean) {
        if (!TextUtils.isEmpty(this.p) && this.p.equals(liveReceiveGiftBean.getKey())) {
            return true;
        }
        o92 o92Var = this.s;
        return o92Var != null && o92Var.n0(liveReceiveGiftBean);
    }

    public void n0(LiveReceiveGiftBean liveReceiveGiftBean, boolean z) {
        boolean z2;
        TextView textView;
        Animation animation;
        if (liveReceiveGiftBean.getMark() == 3) {
            if (!this.n) {
                k0();
            }
            o0(liveReceiveGiftBean, z);
            return;
        }
        o92 o92Var = this.s;
        if (o92Var != null && !o92Var.m0()) {
            this.s.hide();
        }
        boolean z3 = false;
        this.n = false;
        if (!this.o) {
            this.o = true;
            View view = this.a;
            if (view != null && view.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
        }
        if (z) {
            z2 = true;
        } else {
            kn1.g(this.mContext, liveReceiveGiftBean.getAvatar(), this.d);
            LevelBean s = j30.q().s(liveReceiveGiftBean.getLevel());
            TextView textView2 = this.e;
            if (s != null) {
                textView2.setTextColor(Color.parseColor(s.getColor()));
            } else {
                textView2.setTextColor(-1);
            }
            this.e.setText(liveReceiveGiftBean.getUserNiceName());
            z2 = false;
        }
        if (TextUtils.isEmpty(this.p) || !this.p.equals(liveReceiveGiftBean.getKey())) {
            kn1.f(this.mContext, liveReceiveGiftBean.getGiftIcon(), this.g);
            this.f.setText(n52.e(liveReceiveGiftBean.getGiftName(), liveReceiveGiftBean.getToName()));
            int giftCount = liveReceiveGiftBean.getGiftCount();
            TextView textView3 = this.i;
            if (giftCount > 1) {
                textView3.setText("x" + liveReceiveGiftBean.getGiftCount());
                this.j.setText(m93.K3);
            } else {
                textView3.setText("");
                this.j.setText(m93.J3);
            }
            TextView textView4 = this.h;
            if (textView4 != null && textView4.getVisibility() == 0) {
                this.h.setVisibility(4);
            }
            ObjectAnimator objectAnimator = this.l;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        } else {
            z3 = z2;
        }
        if (z3) {
            this.q++;
        } else {
            this.q = liveReceiveGiftBean.getLianCount();
        }
        TextView textView5 = this.h;
        if (textView5 != null && textView5.getVisibility() == 0) {
            this.h.setText(n52.d(this.q));
        }
        this.p = liveReceiveGiftBean.getKey();
        if (!z3 || (textView = this.h) == null || (animation = this.m) == null) {
            return;
        }
        textView.startAnimation(animation);
    }

    public final void o0(LiveReceiveGiftBean liveReceiveGiftBean, boolean z) {
        if (this.s == null) {
            o92 o92Var = new o92(this.mContext, this.mParentView);
            this.s = o92Var;
            o92Var.addToParent();
        }
        this.s.p0(liveReceiveGiftBean, z);
    }

    @Override // defpackage.b1
    public void release() {
        i0();
        this.mContext = null;
        this.mParentView = null;
        this.p = null;
        this.r = null;
        o92 o92Var = this.s;
        if (o92Var != null) {
            o92Var.release();
        }
        this.s = null;
    }
}
