package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
public class o92 extends b1 {
    public View a;
    public View b;
    public View c;
    public View d;
    public View e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public int n;
    public int o;
    public int p;
    public ObjectAnimator q;
    public ValueAnimator r;
    public ObjectAnimator s;
    public Animation t;
    public boolean u;
    public boolean v;
    public String w;
    public int x;
    public Handler y;
    public String z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1 || o92.this.m == null) {
                    return;
                }
                o92.this.m.setTranslationX(-o92.this.p);
                return;
            }
            if (o92.this.b != null) {
                o92.this.b.setTranslationX(-o92.this.n);
            }
            if (o92.this.j != null && o92.this.j.getVisibility() != 0) {
                o92.this.j.setVisibility(0);
                o92.this.j.setText(n52.d(o92.this.x));
            }
            if (o92.this.j != null) {
                o92.this.j.clearAnimation();
                if (o92.this.t != null) {
                    o92.this.j.startAnimation(o92.this.t);
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
            if (o92.this.y != null) {
                o92.this.y.sendEmptyMessageDelayed(0, 200L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (o92.this.c == null || o92.this.d == null) {
                return;
            }
            o92.this.c.setTranslationX(floatValue);
            o92.this.d.setTranslationX(-floatValue);
            float f = animatedFraction <= 0.4f ? animatedFraction / 0.4f : animatedFraction >= 0.6f ? (1.0f - animatedFraction) / 0.4f : 1.0f;
            o92.this.c.setAlpha(f);
            o92.this.d.setAlpha(f);
        }
    }

    public o92(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.Z1;
    }

    public void hide() {
        View view = this.b;
        if (view != null) {
            view.setTranslationX(-this.n);
        }
        TextView textView = this.j;
        if (textView != null && textView.getVisibility() == 0) {
            this.j.setVisibility(4);
        }
        View view2 = this.a;
        if (view2 != null && view2.getVisibility() == 0) {
            this.a.setVisibility(4);
        }
        Handler handler = this.y;
        if (handler != null) {
            handler.removeMessages(1);
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setTranslationX(-this.p);
        }
        this.f.setImageDrawable(null);
        this.i.setImageDrawable(null);
        this.u = true;
        this.x = 0;
        this.v = false;
        this.w = null;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = findViewById(b73.L4);
        this.b = findViewById(b73.j);
        this.c = findViewById(b73.x3);
        this.d = findViewById(b73.H4);
        this.e = findViewById(b73.Y4);
        this.f = (ImageView) findViewById(b73.d);
        this.m = (TextView) findViewById(b73.s6);
        this.z = aq4.a(m93.L3);
        this.g = (TextView) findViewById(b73.X3);
        this.h = (TextView) findViewById(b73.C1);
        this.i = (ImageView) findViewById(b73.h2);
        this.j = (TextView) findViewById(b73.b2);
        this.k = (TextView) findViewById(b73.f2);
        this.l = (TextView) findViewById(b73.V3);
        this.n = zn0.a(214);
        this.o = zn0.a(50);
        this.p = zn0.a(60);
        this.y = new a();
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "translationX", 0.0f);
        this.q = ofFloat;
        ofFloat.setDuration(300L);
        this.q.setInterpolator(accelerateDecelerateInterpolator);
        this.q.addListener(new b());
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f, 0.7f, 1.5f, 0.7f, 1, 0.0f, 1, 1.0f);
        this.t = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.t.setInterpolator(accelerateDecelerateInterpolator);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-r0, zn0.a(70));
        this.r = ofFloat2;
        ofFloat2.setDuration(400L);
        this.r.addUpdateListener(new c());
        this.u = true;
    }

    public void l0() {
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ObjectAnimator objectAnimator = this.q;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        TextView textView = this.j;
        if (textView != null) {
            textView.clearAnimation();
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public boolean m0() {
        return this.u;
    }

    public boolean n0(LiveReceiveGiftBean liveReceiveGiftBean) {
        return !TextUtils.isEmpty(this.w) && this.w.equals(liveReceiveGiftBean.getKey());
    }

    public void o0(int i) {
        this.x = i;
    }

    public void p0(LiveReceiveGiftBean liveReceiveGiftBean, boolean z) {
        boolean z2;
        TextView textView;
        Animation animation;
        boolean z3 = false;
        this.u = false;
        if (!this.v) {
            this.v = true;
            View view = this.a;
            if (view != null && view.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            ValueAnimator valueAnimator = this.r;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
        if (z) {
            z2 = true;
        } else {
            kn1.g(this.mContext, liveReceiveGiftBean.getAvatar(), this.f);
            LevelBean s = j30.q().s(liveReceiveGiftBean.getLevel());
            TextView textView2 = this.g;
            if (s != null) {
                textView2.setTextColor(Color.parseColor(s.getColor()));
            } else {
                textView2.setTextColor(-1);
            }
            this.g.setText(liveReceiveGiftBean.getUserNiceName());
            z2 = false;
        }
        if (TextUtils.isEmpty(this.w) || !this.w.equals(liveReceiveGiftBean.getKey())) {
            kn1.f(this.mContext, liveReceiveGiftBean.getGiftIcon(), this.i);
            this.h.setText(n52.e(liveReceiveGiftBean.getGiftName(), liveReceiveGiftBean.getToName()));
            int giftCount = liveReceiveGiftBean.getGiftCount();
            TextView textView3 = this.k;
            if (giftCount > 1) {
                textView3.setText("x" + liveReceiveGiftBean.getGiftCount());
                this.l.setText(m93.K3);
            } else {
                textView3.setText("");
                this.l.setText(m93.J3);
            }
            TextView textView4 = this.j;
            if (textView4 != null && textView4.getVisibility() == 0) {
                this.j.setVisibility(4);
            }
            ObjectAnimator objectAnimator = this.q;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        } else {
            z3 = z2;
        }
        if (z3) {
            this.x++;
        } else {
            this.x = liveReceiveGiftBean.getLianCount();
        }
        TextView textView5 = this.j;
        if (textView5 != null && textView5.getVisibility() == 0) {
            this.j.setText(n52.d(this.x));
        }
        this.w = liveReceiveGiftBean.getKey();
        if (z3 && (textView = this.j) != null && (animation = this.t) != null) {
            textView.startAnimation(animation);
        }
        if (liveReceiveGiftBean.getLuck() == 1) {
            q0(liveReceiveGiftBean.getLuckTime());
        }
    }

    public final void q0(String str) {
        TextView textView = this.m;
        if (textView == null) {
            return;
        }
        textView.setText(rv3.a(this.z, str));
        if (this.s == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.m, "translationX", -this.p, this.o);
            this.s = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.s.start();
        Handler handler = this.y;
        if (handler != null) {
            handler.removeMessages(1);
            this.y.sendEmptyMessageDelayed(1, 2200L);
        }
    }

    @Override // defpackage.b1
    public void release() {
        l0();
        this.mContext = null;
        this.mParentView = null;
        this.w = null;
        this.y = null;
        ObjectAnimator objectAnimator = this.q;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.q.removeAllListeners();
        }
        this.q = null;
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.r.removeAllListeners();
        }
        this.r = null;
    }
}
