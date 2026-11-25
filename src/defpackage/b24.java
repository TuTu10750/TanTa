package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class b24 implements bn3 {
    public final bn3 a;
    public final n81 b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public final Iterator a;
        public int b = -1;
        public Object c;

        public a() {
            this.a = b24.this.a.iterator();
        }

        private final void d() {
            if (this.a.hasNext()) {
                Object next = this.a.next();
                if (((Boolean) b24.this.b.invoke(next)).booleanValue()) {
                    this.b = 1;
                    this.c = next;
                    return;
                }
            }
            this.b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                d();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b == -1) {
                d();
            }
            if (this.b == 0) {
                zm.a();
                return null;
            }
            Object obj = this.c;
            this.c = null;
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b24(bn3 bn3Var, n81 n81Var) {
        bn3Var.getClass();
        n81Var.getClass();
        this.a = bn3Var;
        this.b = n81Var;
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        return new a();
    }
}
