package defpackage;

import kotlin.coroutines.d;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* loaded from: /tmp/classes2.dex */
public abstract class tt2 {
    public static final void a(n81 n81Var, Object obj, d dVar) {
        UndeliveredElementException b = b(n81Var, obj, null);
        if (b != null) {
            r70.a(dVar, b);
        }
    }

    public static final UndeliveredElementException b(n81 n81Var, Object obj, UndeliveredElementException undeliveredElementException) {
        try {
            n81Var.invoke(obj);
            return undeliveredElementException;
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                qv0.a(undeliveredElementException, th);
                return undeliveredElementException;
            }
            return new UndeliveredElementException("Exception in undelivered element handler for " + obj, th);
        }
    }

    public static /* synthetic */ UndeliveredElementException c(n81 n81Var, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return b(n81Var, obj, undeliveredElementException);
    }
}
