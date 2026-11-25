package defpackage;

import defpackage.ma;

/* loaded from: /tmp/classes2.dex */
public class k12 implements ma.a {
    public static k12 b;
    public boolean a;

    public k12() {
        ma.a(this);
    }

    public static k12 c() {
        if (b == null) {
            synchronized (k12.class) {
                try {
                    if (b == null) {
                        b = new k12();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Override // ma.a
    public void a() {
        f(false);
    }

    @Override // ma.a
    public void b() {
        f(true);
    }

    public void d() {
        if (this.a) {
            return;
        }
        this.a = false;
    }

    public void e(boolean z) {
        this.a = z;
    }

    public final void f(boolean z) {
    }
}
