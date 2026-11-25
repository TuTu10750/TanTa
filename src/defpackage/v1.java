package defpackage;

import java.util.AbstractSet;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public abstract class v1 extends AbstractSet implements Set, hw1 {
    public abstract int g();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return g();
    }
}
