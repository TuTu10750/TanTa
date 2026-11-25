package defpackage;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.TypeCastException;

/* loaded from: /tmp/classes2.dex */
public abstract class ec3 extends ch {
    public RectF h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec3(io1 io1Var) {
        super(io1Var);
        io1Var.getClass();
        this.h = new RectF();
    }

    private final void s(Canvas canvas) {
        float m = d().m();
        float k = d().k();
        int c = d().c();
        float l = d().l() + d().f();
        float b = jo1.a.b(d(), f(), c);
        this.h.set((fb3.b(((k - 0.5f) * l) * 2.0f, 0.0f) + b) - (d().f() / 2.0f), 0.0f, b + fb3.f(k * l * 2.0f, l) + (d().f() / 2.0f), m);
        o(canvas, m, m);
    }

    @Override // defpackage.kh1
    public void a(Canvas canvas) {
        canvas.getClass();
        int h = d().h();
        if (h > 1 || (d().i() && h == 1)) {
            if (h() && d().j() != 0) {
                r(canvas, h);
                l(canvas);
            } else {
                if (d().j() != 4) {
                    n(canvas, h);
                    return;
                }
                for (int i = 0; i < h; i++) {
                    p(canvas, i);
                }
            }
        }
    }

    public final void l(Canvas canvas) {
        e().setColor(d().a());
        int j = d().j();
        if (j == 2) {
            q(canvas);
        } else if (j == 3) {
            s(canvas);
        } else {
            if (j != 5) {
                return;
            }
            m(canvas);
        }
    }

    public final void m(Canvas canvas) {
        int c = d().c();
        float k = d().k();
        float f = c;
        float g = (g() * f) + (f * d().l());
        if (c() == null) {
            k(new ArgbEvaluator());
        }
        if (k < 0.99d) {
            ArgbEvaluator c2 = c();
            if (c2 != null) {
                Object evaluate = c2.evaluate(k, Integer.valueOf(d().a()), Integer.valueOf(d().e()));
                Paint e = e();
                if (evaluate == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                e.setColor(((Integer) evaluate).intValue());
            }
            this.h.set(g, 0.0f, g() + g, d().m());
            o(canvas, d().m(), d().m());
        }
        float l = g + d().l() + d().f();
        if (c == d().h() - 1) {
            l = 0.0f;
        }
        ArgbEvaluator c3 = c();
        if (c3 != null) {
            Object evaluate2 = c3.evaluate(1.0f - k, Integer.valueOf(d().a()), Integer.valueOf(d().e()));
            Paint e2 = e();
            if (evaluate2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            e2.setColor(((Integer) evaluate2).intValue());
        }
        this.h.set(l, 0.0f, g() + l, d().m());
        o(canvas, d().m(), d().m());
    }

    public final void n(Canvas canvas, int i) {
        int i2 = 0;
        float f = 0.0f;
        while (i2 < i) {
            float f2 = i2 == d().c() ? f() : g();
            e().setColor(i2 == d().c() ? d().a() : d().e());
            this.h.set(f, 0.0f, f + f2, d().m());
            o(canvas, d().m(), d().m());
            f += f2 + d().l();
            i2++;
        }
    }

    public abstract void o(Canvas canvas, float f, float f2);

    public final void p(Canvas canvas, int i) {
        float f;
        int a = d().a();
        float l = d().l();
        float m = d().m();
        int c = d().c();
        float f2 = d().f();
        float b = d().b();
        if (c() == null) {
            k(new ArgbEvaluator());
        }
        if (i < c) {
            e().setColor(d().e());
            if (c == d().h() - 1) {
                float f3 = i;
                f = (f3 * f2) + (f3 * l) + ((b - f2) * d().k());
            } else {
                float f4 = i;
                f = (f4 * f2) + (f4 * l);
            }
            this.h.set(f, 0.0f, f2 + f, m);
            o(canvas, m, m);
            return;
        }
        if (i != c) {
            if (c + 1 != i || d().k() == 0.0f) {
                e().setColor(d().e());
                float f5 = i;
                float g = (g() * f5) + (f5 * l) + (b - g());
                this.h.set(g, 0.0f, g() + g, m);
                o(canvas, m, m);
                return;
            }
            return;
        }
        e().setColor(a);
        float k = d().k();
        if (c == d().h() - 1) {
            ArgbEvaluator c2 = c();
            if (c2 != null) {
                Object evaluate = c2.evaluate(k, Integer.valueOf(a), Integer.valueOf(d().e()));
                Paint e = e();
                if (evaluate == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                e.setColor(((Integer) evaluate).intValue());
            }
            float h = ((d().h() - 1) * (d().l() + f2)) + b;
            this.h.set((h - b) + ((b - f2) * k), 0.0f, h, m);
            o(canvas, m, m);
        } else if (k < 1.0f) {
            ArgbEvaluator c3 = c();
            if (c3 != null) {
                Object evaluate2 = c3.evaluate(k, Integer.valueOf(a), Integer.valueOf(d().e()));
                Paint e2 = e();
                if (evaluate2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                e2.setColor(((Integer) evaluate2).intValue());
            }
            float f6 = i;
            float f7 = (f6 * f2) + (f6 * l);
            this.h.set(f7, 0.0f, f7 + f2 + ((b - f2) * (1.0f - k)), m);
            o(canvas, m, m);
        }
        if (c == d().h() - 1) {
            if (k > 0.0f) {
                ArgbEvaluator c4 = c();
                if (c4 != null) {
                    Object evaluate3 = c4.evaluate(1.0f - k, Integer.valueOf(a), Integer.valueOf(d().e()));
                    Paint e3 = e();
                    if (evaluate3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                    }
                    e3.setColor(((Integer) evaluate3).intValue());
                }
                this.h.set(0.0f, 0.0f, f2 + 0.0f + ((b - f2) * k), m);
                o(canvas, m, m);
                return;
            }
            return;
        }
        if (k > 0.0f) {
            ArgbEvaluator c5 = c();
            if (c5 != null) {
                Object evaluate4 = c5.evaluate(1.0f - k, Integer.valueOf(a), Integer.valueOf(d().e()));
                Paint e4 = e();
                if (evaluate4 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                e4.setColor(((Integer) evaluate4).intValue());
            }
            float f8 = i;
            float f9 = (f8 * f2) + (f8 * l) + f2 + l + b;
            this.h.set((f9 - f2) - ((b - f2) * k), 0.0f, f9, m);
            o(canvas, m, m);
        }
    }

    public final void q(Canvas canvas) {
        int c = d().c();
        float l = d().l();
        float m = d().m();
        float f = c;
        float f2 = (f() * f) + (f * l) + ((f() + l) * d().k());
        this.h.set(f2, 0.0f, f() + f2, m);
        o(canvas, m, m);
    }

    public final void r(Canvas canvas, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            e().setColor(d().e());
            float f = i2;
            float f2 = (f() * f) + (f * d().l()) + (f() - g());
            this.h.set(f2, 0.0f, g() + f2, d().m());
            o(canvas, d().m(), d().m());
        }
    }

    public final RectF t() {
        return this.h;
    }
}
