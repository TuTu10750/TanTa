package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public abstract class q82 implements Iterator, bw1 {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
