package defpackage;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: /tmp/classes2.dex */
public class yj3 implements ViewPager2.k {
    public final float a;

    public yj3(float f) {
        this.a = f;
    }

    public void a(View view, float f) {
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2.0f);
        float f2 = width;
        view.setPivotX(f2 / 2.0f);
        if (f < -1.0f) {
            view.setScaleX(this.a);
            view.setScaleY(this.a);
            view.setPivotX(f2);
            return;
        }
        if (f > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.a);
            view.setScaleY(this.a);
            return;
        }
        float f3 = this.a;
        if (f < 0.0f) {
            float f4 = ((f + 1.0f) * (1.0f - f3)) + f3;
            view.setScaleX(f4);
            view.setScaleY(f4);
            view.setPivotX(f2 * (((-f) * 0.5f) + 0.5f));
            return;
        }
        float f5 = 1.0f - f;
        float f6 = ((1.0f - f3) * f5) + f3;
        view.setScaleX(f6);
        view.setScaleY(f6);
        view.setPivotX(f2 * f5 * 0.5f);
    }
}
