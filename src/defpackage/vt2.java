package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class vt2 extends fb {
    public final Object a;
    public final int b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public boolean a = true;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.a) {
                this.a = false;
                return vt2.this.j();
            }
            zm.a();
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vt2(Object obj, int i) {
        super(null);
        obj.getClass();
        this.a = obj;
        this.b = i;
    }

    @Override // defpackage.fb
    public int g() {
        return 1;
    }

    @Override // defpackage.fb
    public Object get(int i) {
        if (i == this.b) {
            return this.a;
        }
        return null;
    }

    @Override // defpackage.fb
    public void h(int i, Object obj) {
        obj.getClass();
        throw new IllegalStateException();
    }

    public final int i() {
        return this.b;
    }

    @Override // defpackage.fb, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    public final Object j() {
        return this.a;
    }
}
