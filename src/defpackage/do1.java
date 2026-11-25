package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class do1 implements Iterable, bw1 {
    public final l81 a;

    public do1(l81 l81Var) {
        l81Var.getClass();
        this.a = l81Var;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new eo1((Iterator) this.a.invoke());
    }
}
