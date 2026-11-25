package defpackage;

import java.util.AbstractCollection;
import java.util.Collection;

/* loaded from: /tmp/classes2.dex */
public abstract class s1 extends AbstractCollection implements Collection, cw1 {
    public abstract int g();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return g();
    }
}
