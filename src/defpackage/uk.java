package defpackage;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.e;
import kotlinx.coroutines.g;

/* loaded from: /tmp/classes2.dex */
public abstract /* synthetic */ class uk {
    public static final dj0 a(s70 s70Var, d dVar, CoroutineStart coroutineStart, b91 b91Var) {
        d g = k70.g(s70Var, dVar);
        ej0 zx1Var = coroutineStart.c() ? new zx1(g, b91Var) : new ej0(g, true);
        zx1Var.t0(coroutineStart, zx1Var, b91Var);
        return zx1Var;
    }

    public static /* synthetic */ dj0 b(s70 s70Var, d dVar, CoroutineStart coroutineStart, b91 b91Var, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = EmptyCoroutineContext.a;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.a;
        }
        return tk.a(s70Var, dVar, coroutineStart, b91Var);
    }

    public static final g c(s70 s70Var, d dVar, CoroutineStart coroutineStart, b91 b91Var) {
        d g = k70.g(s70Var, dVar);
        gt3 iy1Var = coroutineStart.c() ? new iy1(g, b91Var) : new gt3(g, true);
        iy1Var.t0(coroutineStart, iy1Var, b91Var);
        return iy1Var;
    }

    public static /* synthetic */ g d(s70 s70Var, d dVar, CoroutineStart coroutineStart, b91 b91Var, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = EmptyCoroutineContext.a;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.a;
        }
        return tk.c(s70Var, dVar, coroutineStart, b91Var);
    }

    public static final Object e(d dVar, b91 b91Var, u60 u60Var) {
        Object v0;
        d context = u60Var.getContext();
        d h = k70.h(context, dVar);
        tt1.e(h);
        if (h == context) {
            ek3 ek3Var = new ek3(h, u60Var);
            v0 = oc4.d(ek3Var, ek3Var, b91Var);
        } else {
            c.b bVar = c.d0;
            if (dq1.a(h.get(bVar), context.get(bVar))) {
                nc4 nc4Var = new nc4(h, u60Var);
                d context2 = nc4Var.getContext();
                Object f = g44.f(context2, null);
                try {
                    Object d = oc4.d(nc4Var, nc4Var, b91Var);
                    g44.d(context2, f);
                    v0 = d;
                } catch (Throwable th) {
                    g44.d(context2, f);
                    throw th;
                }
            } else {
                e eVar = new e(h, u60Var);
                dv.c(b91Var, eVar, eVar);
                v0 = eVar.v0();
            }
        }
        if (v0 == eq1.e()) {
            ma0.c(u60Var);
        }
        return v0;
    }
}
