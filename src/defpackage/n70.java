package defpackage;

import defpackage.n70;
import kotlin.coroutines.b;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class n70 extends kotlin.coroutines.a implements c {
    public static final a a = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends b {
        public a() {
            super(c.d0, new n81() { // from class: m70
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return n70.a.c((d.b) obj);
                }
            });
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static n70 c(d.b bVar) {
            if (bVar instanceof n70) {
                return (n70) bVar;
            }
            return null;
        }
    }

    public n70() {
        super(c.d0);
    }

    public static /* synthetic */ n70 C0(n70 n70Var, int i, String str, int i2, Object obj) {
        if (obj != null) {
            qm.a("Super calls with default arguments not supported in this target, function: limitedParallelism");
            return null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return n70Var.B0(i, str);
    }

    public /* synthetic */ n70 A0(int i) {
        return B0(i, null);
    }

    public n70 B0(int i, String str) {
        fz1.a(i);
        return new ez1(this, i, str);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d.b, kotlin.coroutines.d
    public d.b get(d.c cVar) {
        return c.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.c
    public final u60 k0(u60 u60Var) {
        return new en0(this, u60Var);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        return c.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.c
    public final void s0(u60 u60Var) {
        u60Var.getClass();
        ((en0) u60Var).s();
    }

    public String toString() {
        return na0.a(this) + '@' + na0.b(this);
    }

    public abstract void y0(d dVar, Runnable runnable);

    public boolean z0(d dVar) {
        return true;
    }
}
