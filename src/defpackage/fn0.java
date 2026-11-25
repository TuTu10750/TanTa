package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.d;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.g;

/* loaded from: /tmp/classes2.dex */
public abstract class fn0 {
    public static final p04 a = new p04("UNDEFINED");
    public static final p04 b = new p04("REUSABLE_CLAIMED");

    public static final /* synthetic */ p04 a() {
        return a;
    }

    public static final void b(u60 u60Var, Object obj) {
        if (!(u60Var instanceof en0)) {
            u60Var.resumeWith(obj);
            return;
        }
        en0 en0Var = (en0) u60Var;
        Object b2 = x30.b(obj);
        if (d(en0Var.d, en0Var.getContext())) {
            en0Var.f = b2;
            en0Var.c = 1;
            c(en0Var.d, en0Var.getContext(), en0Var);
            return;
        }
        dv0 a2 = h44.a.a();
        if (a2.J0()) {
            en0Var.f = b2;
            en0Var.c = 1;
            a2.F0(en0Var);
            return;
        }
        a2.H0(true);
        try {
            g gVar = (g) en0Var.getContext().get(g.e0);
            if (gVar == null || gVar.a()) {
                u60 u60Var2 = en0Var.e;
                Object obj2 = en0Var.g;
                d context = u60Var2.getContext();
                Object f = g44.f(context, obj2);
                nc4 j = f != g44.a ? k70.j(u60Var2, context, f) : null;
                try {
                    en0Var.e.resumeWith(obj);
                    qc4 qc4Var = qc4.a;
                } finally {
                    if (j == null || j.v0()) {
                        g44.d(context, f);
                    }
                }
            } else {
                CancellationException H = gVar.H();
                en0Var.b(b2, H);
                Result.Companion companion = Result.INSTANCE;
                en0Var.resumeWith(Result.b(b.a(H)));
            }
            do {
            } while (a2.L0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final void c(n70 n70Var, d dVar, Runnable runnable) {
        try {
            n70Var.y0(dVar, runnable);
        } catch (Throwable th) {
            throw new DispatchException(th, n70Var, dVar);
        }
    }

    public static final boolean d(n70 n70Var, d dVar) {
        try {
            return n70Var.z0(dVar);
        } catch (Throwable th) {
            throw new DispatchException(th, n70Var, dVar);
        }
    }
}
