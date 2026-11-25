package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /tmp/classes2.dex */
public final class it0 extends fb {
    public static final it0 a = new it0();

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public it0() {
        super(null);
    }

    @Override // defpackage.fb
    public int g() {
        return 0;
    }

    @Override // defpackage.fb
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Void get(int i) {
        return null;
    }

    @Override // defpackage.fb, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    @Override // defpackage.fb
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void h(int i, Void r2) {
        r2.getClass();
        throw new IllegalStateException();
    }
}
