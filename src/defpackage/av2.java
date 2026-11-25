package defpackage;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: /tmp/classes2.dex */
public final class av2 implements ViewPager2.k {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public float f;

    public av2(int i, float f, float f2, float f3, float f4) {
        this.a = i;
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        if (0.0f > f || f > 1.0f) {
            ik.a("minScale value should be between 1.0 to 0.0");
            throw null;
        }
        if (0.0f > f3 || f3 > 1.0f) {
            ik.a("unSelectedItemAlpha value should be between 1.0 to 0.0");
            throw null;
        }
        this.f = 0.2f;
    }

    public void a(View view, float f) {
        view.getClass();
        float f2 = this.b;
        this.f = ((double) f2) >= 0.8d ? 0.2f : ((double) f2) >= 0.6d ? 0.3f : 0.4f;
        view.setElevation(-Math.abs(f));
        float max = Math.max(1.0f - Math.abs(f * 0.5f), 0.5f);
        float f3 = this.c;
        if (f3 != 0.0f) {
            float f4 = 1.0f - max;
            if (f <= 0.0f) {
                f3 = -f3;
            }
            view.setRotationY(f4 * f3);
        }
        float max2 = Math.max(1.0f - Math.abs(this.f * f), this.b);
        view.setScaleX(max2);
        view.setScaleY(max2);
        int a = jo1.a(((int) this.e) / 2);
        int i = this.a;
        if (i == 0) {
            view.setTranslationX((a * f) + ((f > 0.0f ? -view.getWidth() : view.getWidth()) * (1.0f - max2)));
        } else {
            if (i != 1) {
                ik.a("Gives correct orientation value, ViewPager2.ORIENTATION_HORIZONTAL or ViewPager2.ORIENTATION_VERTICAL");
                return;
            }
            view.setTranslationY((a * f) + ((f > 0.0f ? -view.getWidth() : view.getWidth()) * (1.0f - max2)));
        }
        if (this.d == 1.0f) {
            return;
        }
        view.setAlpha((f < -1.0f || f > 1.0f) ? 0.5f / Math.abs(f * f) : ((1.0f - Math.abs(f)) * 0.5f) + 0.5f);
    }
}
