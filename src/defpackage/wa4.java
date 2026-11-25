package defpackage;

import defpackage.at1;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.m;

/* loaded from: /tmp/classes2.dex */
public abstract class wa4 {
    public static final Object a(lv1 lv1Var, Object obj, boolean z) {
        lv1Var.getClass();
        obj.getClass();
        return z ? lv1Var.d(obj) : obj;
    }

    public static final Object b(m mVar, hx1 hx1Var, lv1 lv1Var, na4 na4Var) {
        List i;
        mVar.getClass();
        hx1Var.getClass();
        lv1Var.getClass();
        na4Var.getClass();
        fa4 m0 = mVar.m0(hx1Var);
        if (!mVar.y(m0)) {
            return null;
        }
        PrimitiveType n0 = mVar.n0(m0);
        if (n0 != null) {
            return a(lv1Var, lv1Var.f(n0), mVar.A0(hx1Var) || ja4.c(mVar, hx1Var));
        }
        PrimitiveType W = mVar.W(m0);
        if (W != null) {
            return lv1Var.b("[" + JvmPrimitiveType.c(W).d());
        }
        if (mVar.T(m0)) {
            s51 e0 = mVar.e0(m0);
            q00 n = e0 != null ? at1.a.n(e0) : null;
            if (n != null) {
                if (!na4Var.a() && ((i = at1.a.i()) == null || !i.isEmpty())) {
                    Iterator it = i.iterator();
                    while (it.hasNext()) {
                        if (dq1.a(((at1.a) it.next()).d(), n)) {
                            return null;
                        }
                    }
                }
                String f = xu1.b(n).f();
                f.getClass();
                return lv1Var.c(f);
            }
        }
        return null;
    }
}
