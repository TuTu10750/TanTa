package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.LiveDanMuBean;

/* loaded from: /tmp/classes2.dex */
public class b90 extends b1 {
    public static final int m = zn0.a(150);
    public static final int n = zn0.a(50);
    public static final int o = zn0.a(15);
    public ImageView a;
    public TextView b;
    public TextView c;
    public int d;
    public int e;
    public ValueAnimator f;
    public ValueAnimator.AnimatorUpdateListener g;
    public Animator.AnimatorListener h;
    public boolean i;
    public boolean j;
    public c k;
    public int l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b90.this.mContentView.setX(floatValue);
            if (b90.this.i || floatValue > (b90.this.d - b90.this.e) - b90.o) {
                return;
            }
            b90.this.i = true;
            if (b90.this.k != null) {
                b90.this.k.b(b90.this.l);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b90.this.removeFromParent();
            b90.this.j = true;
            if (b90.this.k != null) {
                b90.this.k.a(b90.this);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(b90 b90Var);

        void b(int i);
    }

    public b90(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.x1;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (ImageView) findViewById(b73.d);
        this.b = (TextView) findViewById(b73.X3);
        this.c = (TextView) findViewById(b73.C1);
        this.d = gk3.a().c();
        this.g = new a();
        this.h = new b();
    }

    public boolean k0() {
        return this.j;
    }

    public void l0(c cVar) {
        this.k = cVar;
    }

    public void m0(boolean z) {
        this.j = z;
    }

    public void n0(LiveDanMuBean liveDanMuBean, int i) {
        this.l = i;
        kn1.g(this.mContext, liveDanMuBean.getAvatar(), this.a);
        this.b.setText(liveDanMuBean.getUserNiceName());
        LevelBean s = j30.q().s(liveDanMuBean.getLevel());
        if (s != null) {
            this.b.setTextColor(Color.parseColor(s.getColor()));
        }
        this.c.setText(liveDanMuBean.getContent());
        this.i = false;
        this.mContentView.measure(0, 0);
        this.e = this.mContentView.getMeasuredWidth();
        this.mContentView.setX(this.d);
        this.mContentView.setY(m + (i * n));
        addToParent();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.d, -this.e);
        this.f = ofFloat;
        ofFloat.addUpdateListener(this.g);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setDuration((int) ((this.d + this.e) / 0.2f));
        this.f.addListener(this.h);
        this.f.start();
    }

    @Override // defpackage.b1
    public void release() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        removeFromParent();
        this.k = null;
    }
}
