package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public abstract class h {
    public static final void a(n11 n11Var, uw2 uw2Var, boolean z) {
        n11Var.getClass();
        uw2Var.getClass();
        bb bbVar = new bb();
        for (uw2 uw2Var2 = uw2Var; uw2Var2 != null && !n11Var.j(uw2Var2); uw2Var2 = uw2Var2.j()) {
            bbVar.addFirst(uw2Var2);
        }
        if (z && bbVar.isEmpty()) {
            iv1.a(uw2Var, " already exists.");
            return;
        }
        Iterator<E> it = bbVar.iterator();
        while (it.hasNext()) {
            n11Var.f((uw2) it.next());
        }
    }

    public static final boolean b(n11 n11Var, uw2 uw2Var) {
        n11Var.getClass();
        uw2Var.getClass();
        return n11Var.m(uw2Var) != null;
    }

    public static final k11 c(n11 n11Var, uw2 uw2Var) {
        n11Var.getClass();
        uw2Var.getClass();
        k11 m = n11Var.m(uw2Var);
        if (m != null) {
            return m;
        }
        oq4.a("no such file: ", uw2Var);
        return null;
    }
}
