package defpackage;

import com.google.android.material.appbar.AppBarLayout;

/* loaded from: /tmp/classes2.dex */
public abstract class z8 implements AppBarLayout.g {
    public int a;

    public void a(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (this.a != 1) {
                b(appBarLayout, 1);
            }
            this.a = 1;
            return;
        }
        int abs = Math.abs(i);
        int totalScrollRange = appBarLayout.getTotalScrollRange();
        int i2 = this.a;
        if (abs >= totalScrollRange) {
            if (i2 != 3) {
                b(appBarLayout, 3);
            }
            this.a = 3;
        } else {
            if (i2 != 2) {
                b(appBarLayout, 2);
            }
            this.a = 2;
        }
    }

    public abstract void b(AppBarLayout appBarLayout, int i);
}
