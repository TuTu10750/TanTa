package defpackage;

import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.c;

/* loaded from: /tmp/classes2.dex */
public abstract class kj0 {
    public static final Object a(long j, u60 u60Var) {
        if (j <= 0) {
            return qc4.a;
        }
        c cVar = new c(IntrinsicsKt__IntrinsicsJvmKt.c(u60Var), 1);
        cVar.E();
        if (j < Long.MAX_VALUE) {
            b(cVar.getContext()).T(j, cVar);
        }
        Object y = cVar.y();
        if (y == eq1.e()) {
            ma0.c(u60Var);
        }
        return y == eq1.e() ? y : qc4.a;
    }

    public static final jj0 b(d dVar) {
        d.b bVar = dVar.get(kotlin.coroutines.c.d0);
        jj0 jj0Var = bVar instanceof jj0 ? (jj0) bVar : null;
        return jj0Var == null ? pf0.a() : jj0Var;
    }
}
