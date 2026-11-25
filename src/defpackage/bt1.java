package defpackage;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: /tmp/classes2.dex */
public final class bt1 {
    public static final bt1 a = new bt1();

    public static /* synthetic */ m00 f(bt1 bt1Var, r51 r51Var, d dVar, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return bt1Var.e(r51Var, dVar, num);
    }

    public final m00 a(m00 m00Var) {
        m00Var.getClass();
        r51 o = at1.a.o(lk0.m(m00Var));
        if (o == null) {
            vh3.a("Given class ", m00Var, " is not a mutable collection");
            return null;
        }
        m00 o2 = DescriptorUtilsKt.j(m00Var).o(o);
        o2.getClass();
        return o2;
    }

    public final m00 b(m00 m00Var) {
        m00Var.getClass();
        r51 p = at1.a.p(lk0.m(m00Var));
        if (p == null) {
            vh3.a("Given class ", m00Var, " is not a read-only collection");
            return null;
        }
        m00 o = DescriptorUtilsKt.j(m00Var).o(p);
        o.getClass();
        return o;
    }

    public final boolean c(m00 m00Var) {
        m00Var.getClass();
        return at1.a.k(lk0.m(m00Var));
    }

    public final boolean d(m00 m00Var) {
        m00Var.getClass();
        return at1.a.l(lk0.m(m00Var));
    }

    public final m00 e(r51 r51Var, d dVar, Integer num) {
        r51Var.getClass();
        dVar.getClass();
        q00 m = (num == null || !dq1.a(r51Var, at1.a.h())) ? at1.a.m(r51Var) : e.a(num.intValue());
        if (m != null) {
            return dVar.o(m.b());
        }
        return null;
    }

    public final Collection g(r51 r51Var, d dVar) {
        r51Var.getClass();
        dVar.getClass();
        m00 f = f(this, r51Var, dVar, null, 4, null);
        if (f == null) {
            return eo3.e();
        }
        r51 p = at1.a.p(DescriptorUtilsKt.m(f));
        if (p == null) {
            return do3.d(f);
        }
        m00 o = dVar.o(p);
        o.getClass();
        return s20.n(f, o);
    }
}
