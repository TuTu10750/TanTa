package defpackage;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.c;

/* loaded from: /tmp/classes2.dex */
public final class i10 extends nk3 {
    public static final i10 a = new i10();

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return s30.a(DescriptorUtilsKt.l((m00) obj).b(), DescriptorUtilsKt.l((m00) obj2).b());
        }
    }

    public static final void b(m00 m00Var, LinkedHashSet linkedHashSet, MemberScope memberScope, boolean z) {
        for (ra0 ra0Var : c.a.a(memberScope, hk0.t, null, 2, null)) {
            if (ra0Var instanceof m00) {
                m00 m00Var2 = (m00) ra0Var;
                if (m00Var2.K()) {
                    zo2 name = m00Var2.getName();
                    name.getClass();
                    z00 e = memberScope.e(name, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    m00Var2 = e instanceof m00 ? (m00) e : e instanceof r94 ? ((r94) e).t() : null;
                }
                if (m00Var2 != null) {
                    if (lk0.z(m00Var2, m00Var)) {
                        linkedHashSet.add(m00Var2);
                    }
                    if (z) {
                        MemberScope x0 = m00Var2.x0();
                        x0.getClass();
                        b(m00Var, linkedHashSet, x0, z);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
    public Collection a(m00 m00Var, boolean z) {
        ra0 ra0Var;
        ra0 ra0Var2;
        m00Var.getClass();
        if (m00Var.l() != Modality.SEALED) {
            return s20.k();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z) {
            Iterator it = DescriptorUtilsKt.q(m00Var).iterator();
            while (true) {
                if (!it.hasNext()) {
                    ra0Var = 0;
                    break;
                }
                ra0Var = it.next();
                if (((ra0) ra0Var) instanceof kv2) {
                    break;
                }
            }
            ra0Var2 = ra0Var;
        } else {
            ra0Var2 = m00Var.b();
        }
        if (ra0Var2 instanceof kv2) {
            b(m00Var, linkedHashSet, ((kv2) ra0Var2).s(), z);
        }
        MemberScope x0 = m00Var.x0();
        x0.getClass();
        b(m00Var, linkedHashSet, x0, true);
        return b30.C0(linkedHashSet, new a());
    }
}
