package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: /tmp/classes2.dex */
public abstract class fk3 {
    public static final Collection a(Collection collection, Collection collection2) {
        collection2.getClass();
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final yq3 b(Iterable iterable) {
        iterable.getClass();
        yq3 yq3Var = new yq3();
        for (Object obj : iterable) {
            MemberScope memberScope = (MemberScope) obj;
            if (memberScope != null && memberScope != MemberScope.a.b) {
                yq3Var.add(obj);
            }
        }
        return yq3Var;
    }
}
