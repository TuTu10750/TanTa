package defpackage;

import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public interface w94 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public static /* synthetic */ j a(w94 w94Var, j8 j8Var, ea4 ea4Var, ra0 ra0Var, int i, Object obj) {
            if (obj != null) {
                qm.a("Super calls with default arguments not supported in this target, function: toAttributes");
                return null;
            }
            if ((i & 2) != 0) {
                ea4Var = null;
            }
            if ((i & 4) != 0) {
                ra0Var = null;
            }
            return w94Var.a(j8Var, ea4Var, ra0Var);
        }
    }

    j a(j8 j8Var, ea4 ea4Var, ra0 ra0Var);
}
