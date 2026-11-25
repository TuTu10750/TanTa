package defpackage;

import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* loaded from: /tmp/classes2.dex */
public abstract class et1 {
    public static final dt1 a(TypeUsage typeUsage, boolean z, boolean z2, oa4 oa4Var) {
        typeUsage.getClass();
        return new dt1(typeUsage, null, z2, z, oa4Var != null ? do3.d(oa4Var) : null, null, 34, null);
    }

    public static /* synthetic */ dt1 b(TypeUsage typeUsage, boolean z, boolean z2, oa4 oa4Var, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            oa4Var = null;
        }
        return a(typeUsage, z, z2, oa4Var);
    }
}
