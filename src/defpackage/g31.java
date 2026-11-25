package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class g31 implements bn3 {
    public final bn3 a;
    public final n81 b;
    public final n81 c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public final Iterator a;
        public Iterator b;
        public int c;

        public a() {
            this.a = g31.this.a.iterator();
        }

        public final boolean d() {
            Iterator it = this.b;
            if (it != null && it.hasNext()) {
                this.c = 1;
                return true;
            }
            while (this.a.hasNext()) {
                Iterator it2 = (Iterator) g31.this.c.invoke(g31.this.b.invoke(this.a.next()));
                if (it2.hasNext()) {
                    this.b = it2;
                    this.c = 1;
                    return true;
                }
            }
            this.c = 2;
            this.b = null;
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.c;
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            return d();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i = this.c;
            if (i == 2) {
                zm.a();
                return null;
            }
            if (i == 0 && !d()) {
                zm.a();
                return null;
            }
            this.c = 0;
            Iterator it = this.b;
            it.getClass();
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public g31(bn3 bn3Var, n81 n81Var, n81 n81Var2) {
        bn3Var.getClass();
        n81Var.getClass();
        n81Var2.getClass();
        this.a = bn3Var;
        this.b = n81Var;
        this.c = n81Var2;
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        return new a();
    }
}
