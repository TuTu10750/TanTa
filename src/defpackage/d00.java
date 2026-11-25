package defpackage;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.TypeCastException;

/* loaded from: /tmp/classes2.dex */
public final class d00 extends ch {
    public final RectF h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d00(io1 io1Var) {
        super(io1Var);
        io1Var.getClass();
        this.h = new RectF();
    }

    @Override // defpackage.kh1
    public void a(Canvas canvas) {
        canvas.getClass();
        int h = d().h();
        if (h > 1 || (d().i() && h == 1)) {
            o(canvas);
            q(canvas);
        }
    }

    @Override // defpackage.ch
    public int i() {
        return ((int) f()) + 6;
    }

    public final void l(Canvas canvas, float f, float f2, float f3) {
        canvas.drawCircle(f + 3.0f, f2 + 3.0f, f3, e());
    }

    public final void m(Canvas canvas) {
        int c = d().c();
        jo1 jo1Var = jo1.a;
        float b = jo1Var.b(d(), f(), c);
        l(canvas, b + ((jo1Var.b(d(), f(), (c + 1) % d().h()) - b) * d().k()), jo1Var.c(f()), d().b() / 2.0f);
    }

    public final void n(Canvas canvas) {
        float f;
        if (c() == null) {
            k(new ArgbEvaluator());
        }
        int c = d().c();
        float k = d().k();
        jo1 jo1Var = jo1.a;
        float b = jo1Var.b(d(), f(), c);
        float c2 = jo1Var.c(f());
        ArgbEvaluator c3 = c();
        if (c3 != null) {
            Object evaluate = c3.evaluate(k, Integer.valueOf(d().a()), Integer.valueOf(d().e()));
            Paint e = e();
            if (evaluate == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            e.setColor(((Integer) evaluate).intValue());
        }
        l(canvas, b, c2, d().f() / 2.0f);
        ArgbEvaluator c4 = c();
        if (c4 != null) {
            Object evaluate2 = c4.evaluate(1.0f - k, Integer.valueOf(d().a()), Integer.valueOf(d().e()));
            Paint e2 = e();
            if (evaluate2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            e2.setColor(((Integer) evaluate2).intValue());
        }
        if (c == d().h() - 1) {
            f = jo1Var.b(d(), f(), 0);
        } else {
            f = d().f() + b + d().l();
        }
        l(canvas, f, c2, d().b() / 2.0f);
    }

    public final void o(Canvas canvas) {
        float f = d().f();
        e().setColor(d().e());
        int h = d().h();
        for (int i = 0; i < h; i++) {
            jo1 jo1Var = jo1.a;
            l(canvas, jo1Var.b(d(), f(), i), jo1Var.c(f()), f / 2.0f);
        }
    }

    public final void p(Canvas canvas) {
        Object evaluate;
        int c = d().c();
        float k = d().k();
        jo1 jo1Var = jo1.a;
        float b = jo1Var.b(d(), f(), c);
        float c2 = jo1Var.c(f());
        if (c() == null) {
            k(new ArgbEvaluator());
        }
        if (k < 1.0f) {
            ArgbEvaluator c3 = c();
            if (c3 != null) {
                Object evaluate2 = c3.evaluate(k, Integer.valueOf(d().a()), Integer.valueOf(d().e()));
                Paint e = e();
                if (evaluate2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                e.setColor(((Integer) evaluate2).intValue());
            }
            l(canvas, b, c2, (d().b() / 2.0f) - (((d().b() / 2.0f) - (d().f() / 2.0f)) * k));
        }
        if (c == d().h() - 1) {
            ArgbEvaluator c4 = c();
            evaluate = c4 != null ? c4.evaluate(k, Integer.valueOf(d().e()), Integer.valueOf(d().a())) : null;
            Paint e2 = e();
            if (evaluate == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            e2.setColor(((Integer) evaluate).intValue());
            l(canvas, f() / 2.0f, c2, (g() / 2.0f) + (((f() / 2.0f) - (g() / 2.0f)) * k));
            return;
        }
        if (k > 0.0f) {
            ArgbEvaluator c5 = c();
            evaluate = c5 != null ? c5.evaluate(k, Integer.valueOf(d().e()), Integer.valueOf(d().a())) : null;
            Paint e3 = e();
            if (evaluate == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            e3.setColor(((Integer) evaluate).intValue());
            l(canvas, b + d().l() + d().f(), c2, (d().f() / 2.0f) + (((d().b() / 2.0f) - (d().f() / 2.0f)) * k));
        }
    }

    public final void q(Canvas canvas) {
        e().setColor(d().a());
        int j = d().j();
        if (j == 0 || j == 2) {
            m(canvas);
            return;
        }
        if (j == 3) {
            r(canvas);
        } else if (j == 4) {
            p(canvas);
        } else {
            if (j != 5) {
                return;
            }
            n(canvas);
        }
    }

    public final void r(Canvas canvas) {
        float f = d().f();
        float k = d().k();
        int c = d().c();
        float l = d().l() + d().f();
        float b = jo1.a.b(d(), f(), c);
        this.h.set(((fb3.b(((k - 0.5f) * l) * 2.0f, 0.0f) + b) - (d().f() / 2.0f)) + 3.0f, 3.0f, b + fb3.f(k * l * 2.0f, l) + (d().f() / 2.0f) + 3.0f, f + 3.0f);
        canvas.drawRoundRect(this.h, f, f, e());
    }
}
