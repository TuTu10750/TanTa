package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a;
import kotlin.reflect.jvm.internal.impl.types.m;

/* loaded from: /tmp/classes2.dex */
public abstract class ja4 {
    public static final a a(a aVar, Collection collection, boolean z, boolean z2, boolean z3) {
        NullabilityQualifier nullabilityQualifier;
        boolean z4;
        aVar.getClass();
        collection.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            NullabilityQualifier b = b((a) it.next());
            if (b != null) {
                arrayList.add(b);
            }
        }
        NullabilityQualifier e = e(b30.M0(arrayList), b(aVar), z);
        if (e == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                NullabilityQualifier d = ((a) it2.next()).d();
                if (d != null) {
                    arrayList2.add(d);
                }
            }
            nullabilityQualifier = e(b30.M0(arrayList2), aVar.d(), z);
        } else {
            nullabilityQualifier = e;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = collection.iterator();
        while (it3.hasNext()) {
            MutabilityQualifier c = ((a) it3.next()).c();
            if (c != null) {
                arrayList3.add(c);
            }
        }
        MutabilityQualifier mutabilityQualifier = (MutabilityQualifier) d(b30.M0(arrayList3), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, aVar.c(), z);
        NullabilityQualifier nullabilityQualifier2 = null;
        if (nullabilityQualifier != null && !z3 && (!z2 || nullabilityQualifier != NullabilityQualifier.NULLABLE)) {
            nullabilityQualifier2 = nullabilityQualifier;
        }
        boolean z5 = false;
        if (nullabilityQualifier2 == NullabilityQualifier.NOT_NULL) {
            if (!aVar.b()) {
                if (!collection.isEmpty()) {
                    Iterator it4 = collection.iterator();
                    while (it4.hasNext()) {
                        if (((a) it4.next()).b()) {
                        }
                    }
                }
            }
            z4 = true;
            if (nullabilityQualifier2 != null && e != nullabilityQualifier) {
                z5 = true;
            }
            return new a(nullabilityQualifier2, mutabilityQualifier, z4, z5);
        }
        z4 = false;
        if (nullabilityQualifier2 != null) {
            z5 = true;
        }
        return new a(nullabilityQualifier2, mutabilityQualifier, z4, z5);
    }

    public static final NullabilityQualifier b(a aVar) {
        if (aVar.e()) {
            return null;
        }
        return aVar.d();
    }

    public static final boolean c(m mVar, hx1 hx1Var) {
        mVar.getClass();
        hx1Var.getClass();
        r51 r51Var = qu1.u;
        r51Var.getClass();
        return mVar.t0(hx1Var, r51Var);
    }

    public static final Object d(Set set, Object obj, Object obj2, Object obj3, boolean z) {
        Set M0;
        if (!z) {
            if (obj3 != null && (M0 = b30.M0(fo3.l(set, obj3))) != null) {
                set = M0;
            }
            return b30.z0(set);
        }
        Object obj4 = set.contains(obj) ? obj : set.contains(obj2) ? obj2 : null;
        if (dq1.a(obj4, obj) && dq1.a(obj3, obj2)) {
            return null;
        }
        return obj3 == null ? obj4 : obj3;
    }

    public static final NullabilityQualifier e(Set set, NullabilityQualifier nullabilityQualifier, boolean z) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) d(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
