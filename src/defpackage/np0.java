package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class np0 implements bn3, op0 {
    public final bn3 a;
    public final int b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public final Iterator a;
        public int b;

        public a(np0 np0Var) {
            this.a = np0Var.a.iterator();
            this.b = np0Var.b;
        }

        public final void d() {
            while (this.b > 0 && this.a.hasNext()) {
                this.a.next();
                this.b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            d();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public np0(bn3 bn3Var, int i) {
        bn3Var.getClass();
        this.a = bn3Var;
        this.b = i;
        if (i >= 0) {
            return;
        }
        sm.a("count must be non-negative, but was ", i, 46);
        throw null;
    }

    @Override // defpackage.op0
    public bn3 a(int i) {
        int i2 = this.b + i;
        return i2 < 0 ? new np0(this, i) : new np0(this.a, i2);
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        return new a(this);
    }
}
