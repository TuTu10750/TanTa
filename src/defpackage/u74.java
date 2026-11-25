package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class u74 implements bn3 {
    public final bn3 a;
    public final n81 b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public final Iterator a;

        public a() {
            this.a = u74.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return u74.this.b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public u74(bn3 bn3Var, n81 n81Var) {
        bn3Var.getClass();
        n81Var.getClass();
        this.a = bn3Var;
        this.b = n81Var;
    }

    public final bn3 d(n81 n81Var) {
        n81Var.getClass();
        return new g31(this.a, this.b, n81Var);
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        return new a();
    }
}
