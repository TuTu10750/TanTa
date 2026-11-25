package defpackage;

import java.util.concurrent.CancellationException;

/* loaded from: /tmp/classes2.dex */
public abstract /* synthetic */ class xx {
    public static final void a(yb3 yb3Var, Throwable th) {
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = ov0.a("Channel was consumed, consumer had failed", th);
            }
        }
        yb3Var.b(r0);
    }
}
