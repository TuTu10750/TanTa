package defpackage;

import android.animation.ArgbEvaluator;
import android.graphics.Paint;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class ch implements kh1 {
    public static final a g = new a(null);
    public final b a;
    public float b;
    public float c;
    public Paint d;
    public ArgbEvaluator e;
    public io1 f;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public final class b {
        public int a;
        public int b;

        public b() {
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public final void c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public ch(io1 io1Var) {
        io1Var.getClass();
        this.f = io1Var;
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.a = new b();
        if (this.f.j() == 4 || this.f.j() == 5) {
            this.e = new ArgbEvaluator();
        }
    }

    @Override // defpackage.kh1
    public b b(int i, int i2) {
        this.b = fb3.b(this.f.f(), this.f.b());
        this.c = fb3.f(this.f.f(), this.f.b());
        int g2 = this.f.g();
        b bVar = this.a;
        if (g2 == 1) {
            bVar.c(i(), j());
        } else {
            bVar.c(j(), i());
        }
        return this.a;
    }

    public final ArgbEvaluator c() {
        return this.e;
    }

    public final io1 d() {
        return this.f;
    }

    public final Paint e() {
        return this.d;
    }

    public final float f() {
        return this.b;
    }

    public final float g() {
        return this.c;
    }

    public final boolean h() {
        return this.f.f() == this.f.b();
    }

    public int i() {
        return ((int) this.f.m()) + 3;
    }

    public final int j() {
        float h = this.f.h() - 1;
        return ((int) ((this.f.l() * h) + this.b + (h * this.c))) + 6;
    }

    public final void k(ArgbEvaluator argbEvaluator) {
        this.e = argbEvaluator;
    }
}
