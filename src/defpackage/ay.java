package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public abstract class ay implements Iterator, bw1 {
    public abstract char d();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(d());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
