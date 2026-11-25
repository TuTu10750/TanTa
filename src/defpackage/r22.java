package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.LiveReceiveGiftBean;

/* loaded from: /tmp/classes2.dex */
public class r22 extends b1 {
    public View a;
    public View b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public int h;
    public ObjectAnimator i;
    public boolean j;
    public Handler k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (r22.this.b != null) {
                r22.this.b.setTranslationX(-r22.this.h);
            }
            if (r22.this.c == null || r22.this.c.getVisibility() != 0) {
                return;
            }
            r22.this.c.setVisibility(4);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (r22.this.c != null && r22.this.c.getVisibility() != 0) {
                r22.this.c.setVisibility(0);
            }
            if (r22.this.k != null) {
                r22.this.k.sendEmptyMessageDelayed(0, 200L);
            }
        }
    }

    public r22(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void f0() {
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void g0() {
        f0();
        hide();
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.X1;
    }

    public void h0(LiveReceiveGiftBean liveReceiveGiftBean) {
        if (!this.j) {
            this.j = true;
            View view = this.a;
            if (view != null && view.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
        }
        kn1.g(this.mContext, liveReceiveGiftBean.getAvatar(), this.d);
        LevelBean s = j30.q().s(liveReceiveGiftBean.getLevel());
        TextView textView = this.e;
        if (s != null) {
            textView.setTextColor(Color.parseColor(s.getColor()));
        } else {
            textView.setTextColor(-1);
        }
        this.e.setText(liveReceiveGiftBean.getUserNiceName());
        this.f.setText(n52.e(liveReceiveGiftBean.getGiftName(), liveReceiveGiftBean.getToName()));
        this.g.setText("x" + liveReceiveGiftBean.getGiftCount());
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    public void hide() {
        View view = this.b;
        if (view != null) {
            view.setTranslationX(-this.h);
        }
        View view2 = this.a;
        if (view2 != null && view2.getVisibility() == 0) {
            this.a.setVisibility(4);
        }
        this.d.setImageDrawable(null);
        this.j = false;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = findViewById(b73.L4);
        this.b = findViewById(b73.j);
        this.c = findViewById(b73.Y4);
        this.d = (ImageView) findViewById(b73.d);
        this.e = (TextView) findViewById(b73.X3);
        this.f = (TextView) findViewById(b73.C1);
        this.g = (TextView) findViewById(b73.f2);
        this.h = zn0.a(214);
        this.k = new a();
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "translationX", 0.0f);
        this.i = ofFloat;
        ofFloat.setDuration(300L);
        this.i.setInterpolator(accelerateDecelerateInterpolator);
        this.i.addListener(new b());
    }

    @Override // defpackage.b1
    public void release() {
        f0();
        this.mContext = null;
        this.mParentView = null;
        this.k = null;
    }
}
