package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class eo1 implements Iterator, bw1 {
    public final Iterator a;
    public int b;

    public eo1(Iterator it) {
        it.getClass();
        this.a = it;
    }

    @Override // java.util.Iterator
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final co1 next() {
        int i = this.b;
        this.b = i + 1;
        if (i < 0) {
            s20.u();
        }
        return new co1(i, this.a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
