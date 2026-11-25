package defpackage;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c;

/* loaded from: /tmp/classes2.dex */
public final class ks3 {
    public static final ks3 a = new ks3();
    public static final Set b;
    public static final q00 c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements c.InterfaceC0112c {
        public final /* synthetic */ Ref$BooleanRef a;

        public a(Ref$BooleanRef ref$BooleanRef) {
            this.a = ref$BooleanRef;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.c.InterfaceC0112c
        public void a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.c.InterfaceC0112c
        public c.a b(q00 q00Var, xr3 xr3Var) {
            q00Var.getClass();
            xr3Var.getClass();
            if (!dq1.a(q00Var, pu1.a.a())) {
                return null;
            }
            this.a.a = true;
            return null;
        }
    }

    static {
        List n = s20.n(qu1.a, qu1.k, qu1.l, qu1.d, qu1.f, qu1.i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = n.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(q00.m((r51) it.next()));
        }
        b = linkedHashSet;
        q00 m = q00.m(qu1.j);
        m.getClass();
        c = m;
    }

    public final q00 a() {
        return c;
    }

    public final Set b() {
        return b;
    }

    public final boolean c(c cVar) {
        cVar.getClass();
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        cVar.c(new a(ref$BooleanRef), null);
        return ref$BooleanRef.a;
    }
}
