package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public abstract class s0 extends b1 implements oh1 {
    public final String a;
    public j42 b;
    public boolean c;
    public boolean d;
    public boolean e;
    public ViewGroup f;
    public ViewGroup g;
    public ViewGroup h;
    public ViewGroup i;
    public ViewGroup j;
    public View k;
    public boolean l;
    public TextView m;
    public int n;
    public boolean o;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ViewGroup viewGroup;
            TextView textView = s0.this.m;
            if (textView == null || (viewGroup = (ViewGroup) textView.getParent()) == null) {
                return;
            }
            viewGroup.removeView(s0.this.m);
            s0.this.m = null;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            s0 s0Var = s0.this;
            TextView textView = s0Var.m;
            if (textView != null) {
                int i = s0Var.n - 1;
                s0Var.n = i;
                if (i > 0) {
                    textView.setText(String.valueOf(i));
                } else {
                    textView.setText((CharSequence) null);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public s0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.a = getClass().getSimpleName();
        this.n = 3;
    }

    public s0(Context context, ViewGroup viewGroup, Object... objArr) {
        super(context, viewGroup, objArr);
        this.a = getClass().getSimpleName();
        this.n = 3;
    }

    @Override // defpackage.nh1
    public ViewGroup K() {
        return this.i;
    }

    @Override // defpackage.nh1
    public ViewGroup V() {
        return this.j;
    }

    @Override // defpackage.nh1
    public ViewGroup Z() {
        return this.g;
    }

    public void a0() {
    }

    public abstract float b0();

    public boolean d0() {
        return this.d;
    }

    public abstract void e0();

    public void f0(String str) {
    }

    public abstract void g0(float f);

    public void h0(j42 j42Var) {
        this.b = j42Var;
    }

    public void i0(boolean z) {
        this.l = z;
    }

    @Override // defpackage.b1
    public void init() {
        this.f = (ViewGroup) findViewById(b73.k);
        this.g = (ViewGroup) findViewById(b73.X4);
        this.h = (ViewGroup) findViewById(b73.y3);
        this.i = (ViewGroup) findViewById(b73.I4);
        ViewGroup viewGroup = (ViewGroup) findViewById(b73.p4);
        this.j = viewGroup;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = (int) ((gk3.a().c() / 1080.0f) * 960.0f);
        this.j.setLayoutParams(layoutParams);
        this.c = true;
    }

    public abstract void j0(int i);

    public void k0(String str, String str2, String str3) {
    }

    public void l0() {
        if (this.o) {
            return;
        }
        this.o = true;
        ViewGroup viewGroup = (ViewGroup) this.mContentView;
        TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(x73.t1, viewGroup, false);
        this.m = textView;
        viewGroup.addView(textView);
        this.m.setText(String.valueOf(this.n));
        ScaleAnimation scaleAnimation = new ScaleAnimation(3.0f, 1.0f, 3.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setRepeatCount(2);
        scaleAnimation.setAnimationListener(new a());
        this.m.startAnimation(scaleAnimation);
    }

    public void m0(String str, String str2) {
    }

    public abstract void n0();

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        lx1.c(this.a, "LifeCycle------>onDestroy");
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onReStart() {
        if (this.l) {
            this.l = false;
            e0();
        }
    }

    @Override // defpackage.b1
    public void release() {
        TextView textView = this.m;
        if (textView != null) {
            textView.clearAnimation();
        }
        this.b = null;
    }
}
