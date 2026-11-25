package defpackage;

import defpackage.j8;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class k8 implements j8 {
    public final List a;

    public k8(List list) {
        list.getClass();
        this.a = list;
    }

    @Override // defpackage.j8
    public d8 a(r51 r51Var) {
        return j8.b.a(this, r51Var);
    }

    @Override // defpackage.j8
    public boolean c(r51 r51Var) {
        return j8.b.b(this, r51Var);
    }

    @Override // defpackage.j8
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.a.iterator();
    }

    public String toString() {
        return this.a.toString();
    }
}
