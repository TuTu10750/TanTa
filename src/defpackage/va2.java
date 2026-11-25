package defpackage;

import java.util.List;
import kotlin.KotlinNothingValueException;

/* loaded from: /tmp/classes2.dex */
public abstract class va2 {
    public static final vl2 a(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        d();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ vl2 b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        a(th, str);
        return null;
    }

    public static final boolean c(ra2 ra2Var) {
        ra2Var.D0();
        return false;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final ra2 e(ta2 ta2Var, List list) {
        try {
            return ta2Var.b(list);
        } catch (Throwable th) {
            a(th, ta2Var.a());
            return null;
        }
    }
}
