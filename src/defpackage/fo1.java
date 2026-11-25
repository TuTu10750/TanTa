package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class fo1 implements bn3 {
    public final bn3 a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public final Iterator a;
        public int b;

        public a(fo1 fo1Var) {
            this.a = fo1Var.a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public co1 next() {
            int i = this.b;
            this.b = i + 1;
            if (i < 0) {
                s20.u();
            }
            return new co1(i, this.a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public fo1(bn3 bn3Var) {
        bn3Var.getClass();
        this.a = bn3Var;
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        return new a(this);
    }
}
