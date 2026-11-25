package defpackage;

import java.util.Iterator;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;

/* loaded from: /tmp/classes2.dex */
public abstract class q70 {
    public static final void a(d dVar, Throwable th) {
        Iterator it = p70.a().iterator();
        while (it.hasNext()) {
            try {
                ((o70) it.next()).handleException(dVar, th);
            } catch (Throwable th2) {
                p70.b(r70.b(th, th2));
            }
        }
        try {
            qv0.a(th, new DiagnosticCoroutineContextException(dVar));
        } catch (Throwable unused) {
        }
        p70.b(th);
    }
}
