package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.uc.crashsdk.export.LogType;
import com.zzhoujay.richtext.ImageHolder;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class ie4 extends l0 implements View.OnClickListener {
    public ImageView A0;
    public ValueAnimator B0;
    public View z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ie4.this.z0.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Bundle z = ie4.this.z();
            if (z != null) {
                kn1.f(ie4.this.x0, z.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, ""), ie4.this.A0);
            }
        }
    }

    @Override // defpackage.l0
    public void C0() {
        ValueAnimator valueAnimator = this.B0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.x0 = null;
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return y73.b0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.Z) {
            S1();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
        window.addFlags(ImageHolder.WRAP_CONTENT);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            attributes.layoutInDisplayCutoutMode = 3;
        } else if (i >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.z0 = this.y0.findViewById(c73.x);
        k2(c73.Z).setOnClickListener(this);
        this.A0 = (ImageView) k2(c73.I2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.B0 = ofFloat;
        ofFloat.setDuration(150L);
        this.B0.setInterpolator(new AccelerateDecelerateInterpolator());
        this.B0.addUpdateListener(new a());
        this.B0.addListener(new b());
        this.B0.start();
    }
}
