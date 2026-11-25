package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /tmp/classes2.dex */
public final class cb implements Iterator, bw1 {
    public final Object[] a;
    public int b;

    public cb(Object[] objArr) {
        objArr.getClass();
        this.a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return objArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
