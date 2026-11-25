package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.yunbao.live.custom.FrameImageView;
import com.yunbao.live.custom.PkProgressBar;
import com.yunbao.live.custom.ProgressTextView;

/* loaded from: /tmp/classes2.dex */
public class o32 extends b1 {
    public FrameImageView a;
    public PkProgressBar b;
    public TextView c;
    public TextView d;
    public String e;
    public String f;
    public int g;
    public ValueAnimator h;
    public ValueAnimator i;
    public TextView j;
    public ImageView k;
    public ValueAnimator l;
    public ScaleAnimation m;
    public ValueAnimator n;
    public int o;
    public int p;
    public ProgressTextView q;
    public View r;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            o32.this.c.setTranslationX(floatValue - o32.this.g);
            o32.this.d.setTranslationX(o32.this.g - floatValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (o32.this.b != null && o32.this.b.getVisibility() != 0) {
                o32.this.b.setVisibility(0);
            }
            if (o32.this.c != null) {
                o32.this.c.setBackground(null);
            }
            if (o32.this.d != null) {
                o32.this.d.setBackground(null);
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
            if (o32.this.a != null) {
                o32.this.a.c((int) floatValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ PathMeasure a;
        public final /* synthetic */ float[] b;

        public d(PathMeasure pathMeasure, float[] fArr) {
            this.a = pathMeasure;
            this.b = fArr;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.b, null);
            o32.this.k.setX(this.b[0] - o32.this.o);
            o32.this.k.setY(this.b[1] - o32.this.p);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            o32.this.a.setScaleX(floatValue);
            o32.this.a.setScaleY(floatValue);
            o32.this.a.setAlpha(floatValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;

        public f(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (o32.this.k != null) {
                if (o32.this.a.getVisibility() == 0) {
                    o32.this.a.setVisibility(4);
                }
                o32.this.k.setImageResource(this.a == 0 ? t83.q0 : t83.r0);
                o32.this.k.startAnimation(o32.this.m);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements Animation.AnimationListener {
        public final /* synthetic */ int a;

        public g(int i) {
            this.a = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            o32 o32Var = o32.this;
            o32Var.n = o32Var.o0(this.a);
            o32.this.n.start();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public o32(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.J1;
    }

    @Override // defpackage.b1
    public void init() {
        this.g = gk3.a().c() / 2;
        this.e = aq4.a(m93.Z3);
        this.f = aq4.a(m93.a4);
        FrameImageView frameImageView = (FrameImageView) findViewById(b73.Y1);
        this.a = frameImageView;
        frameImageView.setImageList(f32.c());
        this.b = (PkProgressBar) findViewById(b73.v4);
        View findViewById = findViewById(b73.O4);
        this.r = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = (int) ((gk3.a().c() / 1080.0f) * 960.0f);
        this.r.setLayoutParams(layoutParams);
        this.c = (TextView) findViewById(b73.x3);
        this.d = (TextView) findViewById(b73.H4);
        this.c.setText(this.e + "  0");
        this.d.setText("0  " + this.f);
        this.c.setTranslationX((float) (-this.g));
        this.d.setTranslationX((float) this.g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.g);
        this.h = ofFloat;
        ofFloat.addUpdateListener(new a());
        this.h.addListener(new b());
        this.h.setInterpolator(new AccelerateDecelerateInterpolator());
        this.h.setDuration(400L);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 18.0f);
        this.i = ofFloat2;
        ofFloat2.addUpdateListener(new c());
        this.i.setDuration(800L);
        this.i.setInterpolator(new LinearInterpolator());
        this.j = (TextView) findViewById(b73.e5);
        this.k = (ImageView) findViewById(b73.F4);
        this.o = zn0.a(75) / 2;
        this.p = zn0.a(50) / 2;
        this.q = (ProgressTextView) findViewById(b73.q4);
    }

    public void n0(int i) {
        if (this.k == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.2f);
        this.l = ofFloat;
        ofFloat.addUpdateListener(new e());
        this.l.setDuration(500L);
        this.l.addListener(new f(i));
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.m = scaleAnimation;
        scaleAnimation.setDuration(500L);
        this.m.setAnimationListener(new g(i));
        this.l.start();
    }

    public final ValueAnimator o0(int i) {
        ValueAnimator valueAnimator;
        if (i == 0) {
            valueAnimator = ObjectAnimator.ofFloat(this.k, "translationY", zn0.a(80));
        } else {
            int width = this.mContentView.getWidth();
            int height = this.mContentView.getHeight();
            Path path = new Path();
            path.lineTo(0.0f, 0.0f);
            float f2 = height / 2;
            path.moveTo(width / 2, f2);
            path.arcTo(new RectF(r2 - r8, f2, r2 + r8, r8 + height), -90.0f, i > 0 ? -70.0f : 70.0f);
            PathMeasure pathMeasure = new PathMeasure(path, false);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, pathMeasure.getLength());
            ofFloat.addUpdateListener(new d(pathMeasure, new float[2]));
            valueAnimator = ofFloat;
        }
        valueAnimator.setDuration(1500L);
        return valueAnimator;
    }

    public void p0() {
        TextView textView = this.j;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.j.setVisibility(4);
    }

    public void q0() {
        FrameImageView frameImageView = this.a;
        if (frameImageView != null) {
            frameImageView.setImageResource(t83.q1);
        }
        PkProgressBar pkProgressBar = this.b;
        if (pkProgressBar != null && pkProgressBar.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setBackground(null);
            this.c.setTranslationX(0.0f);
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setBackground(null);
            this.d.setTranslationX(0.0f);
        }
    }

    public void r0(long j, long j2) {
        this.c.setText(this.e + "  " + j);
        this.d.setText(j2 + "  " + this.f);
        PkProgressBar pkProgressBar = this.b;
        if (j == j2) {
            pkProgressBar.setProgress(0.5f);
        } else {
            pkProgressBar.setProgress((((float) j) * 1.0f) / ((float) (j + j2)));
        }
    }

    @Override // defpackage.b1
    public void release() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.i;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.l;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ScaleAnimation scaleAnimation = this.m;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        AppCompatImageView appCompatImageView = this.a;
        if (appCompatImageView != null) {
            appCompatImageView.clearAnimation();
            this.a.d();
        }
        ValueAnimator valueAnimator4 = this.n;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
    }

    public void s0(int i) {
        AppCompatTextView appCompatTextView = this.q;
        if (appCompatTextView == null || appCompatTextView.getVisibility() != 0) {
            return;
        }
        this.q.setProgress(i);
    }

    public void t0(boolean z) {
        AppCompatTextView appCompatTextView = this.q;
        if (appCompatTextView != null) {
            if (z) {
                if (appCompatTextView.getVisibility() != 0) {
                    this.q.setVisibility(0);
                }
            } else if (appCompatTextView.getVisibility() == 0) {
                this.q.setVisibility(4);
            }
        }
    }

    public void u0(String str) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void v0() {
        TextView textView = this.j;
        if (textView == null || textView.getVisibility() == 0) {
            return;
        }
        this.j.setVisibility(0);
    }

    public void w0() {
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        ValueAnimator valueAnimator2 = this.i;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }
}
