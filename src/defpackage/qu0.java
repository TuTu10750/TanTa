package defpackage;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;

/* loaded from: /tmp/classes2.dex */
public final class qu0 implements mm2 {
    public static final qu0 a = new qu0();
    public static final zo2 b;
    public static final List c;
    public static final List d;
    public static final Set e;
    public static final d f;

    static {
        zo2 l = zo2.l(ErrorEntity.ERROR_MODULE.b());
        l.getClass();
        b = l;
        c = s20.k();
        d = s20.k();
        e = eo3.e();
        f = b.h.a();
    }

    @Override // defpackage.mm2
    public boolean G(mm2 mm2Var) {
        mm2Var.getClass();
        return false;
    }

    public zo2 H() {
        return b;
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        va0Var.getClass();
        return null;
    }

    @Override // defpackage.mm2
    public Object Y(im2 im2Var) {
        im2Var.getClass();
        return null;
    }

    @Override // defpackage.ra0, defpackage.z00
    public ra0 a() {
        return this;
    }

    @Override // defpackage.ra0, defpackage.qf4, defpackage.ta0
    public ra0 b() {
        return null;
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        return j8.a0.b();
    }

    @Override // defpackage.ep2
    public zo2 getName() {
        return H();
    }

    @Override // defpackage.mm2
    public d q() {
        return f;
    }

    @Override // defpackage.mm2
    public Collection r(r51 r51Var, n81 n81Var) {
        r51Var.getClass();
        n81Var.getClass();
        return s20.k();
    }

    @Override // defpackage.mm2
    public List r0() {
        return d;
    }

    @Override // defpackage.mm2
    public sv2 t0(r51 r51Var) {
        r51Var.getClass();
        throw new IllegalStateException("Should not be called!");
    }
}
