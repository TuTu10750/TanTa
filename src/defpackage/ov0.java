package defpackage;

import java.util.concurrent.CancellationException;

/* loaded from: /tmp/classes2.dex */
public abstract class ov0 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
