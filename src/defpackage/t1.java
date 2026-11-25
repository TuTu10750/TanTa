package defpackage;

import java.util.AbstractList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class t1 extends AbstractList implements List, dw1 {
    public abstract int g();

    public abstract Object h(int i);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return h(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return g();
    }
}
