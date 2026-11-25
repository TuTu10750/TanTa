package defpackage;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.e;

/* loaded from: /tmp/classes2.dex */
public abstract class k70 {
    public static d a(Ref$ObjectRef ref$ObjectRef, boolean z, d dVar, d.b bVar) {
        return dVar.plus(bVar);
    }

    public static d b(d dVar, d.b bVar) {
        return dVar.plus(bVar);
    }

    public static boolean c(boolean z, d.b bVar) {
        return z;
    }

    public static final d d(d dVar, d dVar2, final boolean z) {
        boolean f = f(dVar);
        boolean f2 = f(dVar2);
        if (!f && !f2) {
            return dVar.plus(dVar2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.a = dVar2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.a;
        d dVar3 = (d) dVar.fold(emptyCoroutineContext, new b91() { // from class: i70
            @Override // defpackage.b91
            public final Object invoke(Object obj, Object obj2) {
                return k70.a(Ref$ObjectRef.this, z, (d) obj, (d.b) obj2);
            }
        });
        if (f2) {
            ref$ObjectRef.a = ((d) ref$ObjectRef.a).fold(emptyCoroutineContext, new b91() { // from class: j70
                @Override // defpackage.b91
                public final Object invoke(Object obj, Object obj2) {
                    return k70.b((d) obj, (d.b) obj2);
                }
            });
        }
        return dVar3.plus((d) ref$ObjectRef.a);
    }

    public static final String e(d dVar) {
        return null;
    }

    public static final boolean f(d dVar) {
        return ((Boolean) dVar.fold(Boolean.FALSE, new b91() { // from class: h70
            @Override // defpackage.b91
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(k70.c(((Boolean) obj).booleanValue(), (d.b) obj2));
            }
        })).booleanValue();
    }

    public static final d g(s70 s70Var, d dVar) {
        d d = d(s70Var.f(), dVar, true);
        return (d == in0.a() || d.get(c.d0) != null) ? d : d.plus(in0.a());
    }

    public static final d h(d dVar, d dVar2) {
        return !f(dVar2) ? dVar.plus(dVar2) : d(dVar, dVar2, false);
    }

    public static final nc4 i(t70 t70Var) {
        while (!(t70Var instanceof e) && (t70Var = t70Var.getCallerFrame()) != null) {
            if (t70Var instanceof nc4) {
                return (nc4) t70Var;
            }
        }
        return null;
    }

    public static final nc4 j(u60 u60Var, d dVar, Object obj) {
        if (!(u60Var instanceof t70) || dVar.get(pc4.a) == null) {
            return null;
        }
        nc4 i = i((t70) u60Var);
        if (i != null) {
            i.x0(dVar, obj);
        }
        return i;
    }
}
