package defpackage;

import defpackage.gk0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public class lw3 extends dk2 {
    public final mm2 b;
    public final r51 c;

    public lw3(mm2 mm2Var, r51 r51Var) {
        mm2Var.getClass();
        r51Var.getClass();
        this.b = mm2Var;
        this.c = r51Var;
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public Collection f(hk0 hk0Var, n81 n81Var) {
        hk0Var.getClass();
        n81Var.getClass();
        if (!hk0Var.a(hk0.c.f())) {
            return s20.k();
        }
        if (this.c.d() && hk0Var.l().contains(gk0.b.a)) {
            return s20.k();
        }
        Collection r = this.b.r(this.c, n81Var);
        ArrayList arrayList = new ArrayList(r.size());
        Iterator it = r.iterator();
        while (it.hasNext()) {
            zo2 g = ((r51) it.next()).g();
            g.getClass();
            if (((Boolean) n81Var.invoke(g)).booleanValue()) {
                q20.a(arrayList, h(g));
            }
        }
        return arrayList;
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set g() {
        return eo3.e();
    }

    public final sv2 h(zo2 zo2Var) {
        zo2Var.getClass();
        if (zo2Var.j()) {
            return null;
        }
        mm2 mm2Var = this.b;
        r51 c = this.c.c(zo2Var);
        c.getClass();
        sv2 t0 = mm2Var.t0(c);
        if (t0.isEmpty()) {
            return null;
        }
        return t0;
    }

    public String toString() {
        return "subpackages of " + this.c + " from " + this.b;
    }
}
