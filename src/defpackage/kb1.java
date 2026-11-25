package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class kb1 implements bn3 {
    public final l81 a;
    public final n81 b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public Object a;
        public int b = -2;

        public a() {
        }

        private final void d() {
            Object invoke;
            int i = this.b;
            kb1 kb1Var = kb1.this;
            if (i == -2) {
                invoke = kb1Var.a.invoke();
            } else {
                n81 n81Var = kb1Var.b;
                Object obj = this.a;
                obj.getClass();
                invoke = n81Var.invoke(obj);
            }
            this.a = invoke;
            this.b = invoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < 0) {
                d();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b < 0) {
                d();
            }
            if (this.b == 0) {
                zm.a();
                return null;
            }
            Object obj = this.a;
            obj.getClass();
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public kb1(l81 l81Var, n81 n81Var) {
        l81Var.getClass();
        n81Var.getClass();
        this.a = l81Var;
        this.b = n81Var;
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        return new a();
    }
}
