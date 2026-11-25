package defpackage;

import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.d;
import kotlinx.coroutines.f;

/* loaded from: /tmp/classes2.dex */
public abstract class gn0 {
    public static final void a(f fVar, int i) {
        u60 c = fVar.c();
        boolean z = i == 4;
        if (z || !(c instanceof en0) || b(i) != b(fVar.c)) {
            d(fVar, c, z);
            return;
        }
        en0 en0Var = (en0) c;
        n70 n70Var = en0Var.d;
        d context = en0Var.getContext();
        if (fn0.d(n70Var, context)) {
            fn0.c(n70Var, context, fVar);
        } else {
            e(fVar);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final void d(f fVar, u60 u60Var, boolean z) {
        Object g;
        Object l = fVar.l();
        Throwable f = fVar.f(l);
        if (f != null) {
            Result.Companion companion = Result.INSTANCE;
            g = b.a(f);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            g = fVar.g(l);
        }
        Object b = Result.b(g);
        if (!z) {
            u60Var.resumeWith(b);
            return;
        }
        u60Var.getClass();
        en0 en0Var = (en0) u60Var;
        u60 u60Var2 = en0Var.e;
        Object obj = en0Var.g;
        d context = u60Var2.getContext();
        Object f2 = g44.f(context, obj);
        nc4 j = f2 != g44.a ? k70.j(u60Var2, context, f2) : null;
        try {
            en0Var.e.resumeWith(b);
            qc4 qc4Var = qc4.a;
            if (j == null || j.v0()) {
                g44.d(context, f2);
            }
        } catch (Throwable th) {
            if (j == null || j.v0()) {
                g44.d(context, f2);
            }
            throw th;
        }
    }

    public static final void e(f fVar) {
        dv0 a = h44.a.a();
        if (a.J0()) {
            a.F0(fVar);
            return;
        }
        a.H0(true);
        try {
            d(fVar, fVar.c(), true);
            do {
            } while (a.L0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
