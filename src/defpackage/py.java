package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.im.bean.ImChatImageBean;
import defpackage.qy;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class py extends l0 {
    public RecyclerView A0;
    public ImageView B0;
    public float C0;
    public int D0;
    public int E0;
    public ValueAnimator F0;
    public int G0;
    public int H0;
    public int I0;
    public int J0;
    public List K0;
    public int L0;
    public int M0;
    public int N0;
    public Drawable O0;
    public View z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            py.this.B0.setTranslationX(py.this.G0 + (py.this.I0 * floatValue));
            py.this.B0.setTranslationY(py.this.H0 + (py.this.J0 * floatValue));
            py.this.B0.setScaleX(((py.this.C0 - 1.0f) * floatValue) + 1.0f);
            py.this.B0.setScaleY(((py.this.C0 - 1.0f) * floatValue) + 1.0f);
            py.this.z0.setAlpha(floatValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* loaded from: /tmp/classes2.dex */
        public class a implements qy.c {
            public a() {
            }

            @Override // qy.c
            public void a() {
                py.this.S1();
            }
        }

        /* renamed from: py$b$b, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0149b implements Runnable {
            public RunnableC0149b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (py.this.B0 != null) {
                    py.this.B0.setVisibility(4);
                }
            }
        }

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (py.this.A0 == null || py.this.K0 == null || py.this.K0.size() <= 0) {
                return;
            }
            qy qyVar = new qy(py.this.x0, py.this.K0);
            qyVar.R(new a());
            py.this.A0.setAdapter(qyVar);
            if (py.this.L0 >= 0 && py.this.L0 < py.this.K0.size()) {
                py.this.A0.v1(py.this.L0);
            }
            if (py.this.B0 != null) {
                py.this.B0.postDelayed(new RunnableC0149b(), 300L);
            }
        }
    }

    @Override // defpackage.l0
    public void C0() {
        ValueAnimator valueAnimator = this.F0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.C0();
    }

    public void C2(ImChatImageBean imChatImageBean, int i, int i2, int i3, int i4, Drawable drawable) {
        this.K0 = imChatImageBean.getList();
        this.L0 = imChatImageBean.getPosition();
        this.G0 = i;
        this.H0 = i2;
        this.M0 = i3;
        this.N0 = i4;
        this.O0 = drawable;
    }

    public void D2() {
        ImageView imageView = this.B0;
        if (imageView == null || this.M0 <= 0 || this.N0 <= 0 || this.O0 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = this.M0;
        layoutParams.height = this.N0;
        this.B0.requestLayout();
        this.B0.setTranslationX(this.G0);
        this.B0.setTranslationY(this.H0);
        this.B0.setImageDrawable(this.O0);
        int i = this.D0;
        int i2 = this.M0;
        this.C0 = i / i2;
        int i3 = (this.E0 / 2) - (this.N0 / 2);
        this.I0 = ((i / 2) - (i2 / 2)) - this.G0;
        this.J0 = i3 - this.H0;
        this.F0.start();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return w73.z;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        gk3 a2 = gk3.a();
        this.D0 = a2.c();
        this.E0 = a2.b();
        this.z0 = this.y0.findViewById(a73.d);
        RecyclerView findViewById = this.y0.findViewById(a73.Y);
        this.A0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.A0.setLayoutManager(new LinearLayoutManager(this.x0, 0, false));
        this.B0 = (ImageView) this.y0.findViewById(a73.H);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.F0 = ofFloat;
        ofFloat.setDuration(300L);
        this.F0.setInterpolator(new AccelerateDecelerateInterpolator());
        this.F0.addUpdateListener(new a());
        this.F0.addListener(new b());
        D2();
    }
}
