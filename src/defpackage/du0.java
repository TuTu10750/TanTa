package defpackage;

import defpackage.j8;
import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class du0 implements j8 {
    public final r51 a;

    public du0(r51 r51Var) {
        r51Var.getClass();
        this.a = r51Var;
    }

    @Override // defpackage.j8
    public boolean c(r51 r51Var) {
        return j8.b.b(this, r51Var);
    }

    @Override // defpackage.j8
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public cu0 a(r51 r51Var) {
        r51Var.getClass();
        if (dq1.a(r51Var, this.a)) {
            return cu0.a;
        }
        return null;
    }

    @Override // defpackage.j8
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return s20.k().iterator();
    }
}
