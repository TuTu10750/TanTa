package defpackage;

import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class q1 extends v1 {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return h((Map.Entry) obj);
        }
        return false;
    }

    public final boolean h(Map.Entry entry) {
        entry.getClass();
        return i(entry);
    }

    public abstract boolean i(Map.Entry entry);

    public abstract /* bridge */ boolean j(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return j((Map.Entry) obj);
        }
        return false;
    }
}
