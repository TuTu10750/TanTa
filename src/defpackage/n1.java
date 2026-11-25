package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public abstract class n1 implements Iterator, bw1 {
    public int a;
    public Object b;

    public abstract void d();

    public final void e() {
        this.a = 2;
    }

    public final void f(Object obj) {
        this.b = obj;
        this.a = 1;
    }

    public final boolean g() {
        this.a = 3;
        d();
        return this.a == 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i = this.a;
        if (i == 0) {
            return g();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        ik.a("hasNext called when the iterator is in the FAILED state.");
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.a;
        if (i == 1) {
            this.a = 0;
            return this.b;
        }
        if (i == 2 || !g()) {
            zm.a();
            return null;
        }
        this.a = 0;
        return this.b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
