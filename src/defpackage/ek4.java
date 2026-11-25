package defpackage;

import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /tmp/classes2.dex */
public abstract class ek4 {

    /* loaded from: /tmp/classes2.dex */
    public static class a implements ViewPager.j {
        public final /* synthetic */ MagicIndicator a;

        public a(MagicIndicator magicIndicator) {
            this.a = magicIndicator;
        }

        public void a(int i, float f, int i2) {
            this.a.b(i, f, i2);
        }

        public void b(int i) {
            this.a.a(i);
        }

        public void c(int i) {
            this.a.c(i);
        }
    }

    public static void a(MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.c(new a(magicIndicator));
    }
}
