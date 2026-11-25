package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.b;
import androidx.viewpager2.widget.c;

/* loaded from: /tmp/classes2.dex */
public class gg {
    public hg a;
    public final yc b;
    public final b c;
    public c d;
    public ViewPager2.k e;

    public gg() {
        hg hgVar = new hg();
        this.a = hgVar;
        this.b = new yc(hgVar);
        this.c = new b();
    }

    public void a() {
        f();
        ViewPager2.k cVar = new c(this.a.i());
        this.d = cVar;
        this.c.b(cVar);
    }

    public hg b() {
        if (this.a == null) {
            this.a = new hg();
        }
        return this.a;
    }

    public b c() {
        return this.c;
    }

    public void d(Context context, AttributeSet attributeSet) {
        this.b.a(context, attributeSet);
    }

    public void e() {
        ViewPager2.k kVar = this.e;
        if (kVar != null) {
            this.c.c(kVar);
        }
    }

    public void f() {
        ViewPager2.k kVar = this.d;
        if (kVar != null) {
            this.c.c(kVar);
        }
    }

    public void g(boolean z, float f) {
        e();
        if (z) {
            this.e = new av2(this.a.h(), f, 0.0f, 1.0f, 0.0f);
        } else {
            this.e = new yj3(f);
        }
        this.c.b(this.e);
    }
}
