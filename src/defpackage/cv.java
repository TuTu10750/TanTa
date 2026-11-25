package defpackage;

import kotlinx.coroutines.b;
import kotlinx.coroutines.c;

/* loaded from: /tmp/classes2.dex */
public abstract class cv {
    public static final void a(zu zuVar, pn0 pn0Var) {
        c(zuVar, new qn0(pn0Var));
    }

    public static final c b(u60 u60Var) {
        if (!(u60Var instanceof en0)) {
            return new c(u60Var, 1);
        }
        c n = ((en0) u60Var).n();
        if (n != null) {
            if (!n.O()) {
                n = null;
            }
            if (n != null) {
                return n;
            }
        }
        return new c(u60Var, 2);
    }

    public static final void c(zu zuVar, b bVar) {
        if (zuVar instanceof c) {
            ((c) zuVar).H(bVar);
        } else {
            qm.a("third-party implementation of CancellableContinuation is not supported");
        }
    }
}
