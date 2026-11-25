package defpackage;

import kotlin.coroutines.d;
import kotlinx.coroutines.DispatchException;

/* loaded from: /tmp/classes2.dex */
public abstract class r70 {
    public static final void a(d dVar, Throwable th) {
        if (th instanceof DispatchException) {
            th = ((DispatchException) th).getCause();
        }
        try {
            o70 o70Var = (o70) dVar.get(o70.b0);
            if (o70Var != null) {
                o70Var.handleException(dVar, th);
            } else {
                q70.a(dVar, th);
            }
        } catch (Throwable th2) {
            q70.a(dVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        qv0.a(runtimeException, th);
        return runtimeException;
    }
}
