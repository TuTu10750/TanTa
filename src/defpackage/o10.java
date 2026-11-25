package defpackage;

import java.io.Closeable;

/* loaded from: /tmp/classes2.dex */
public abstract class o10 {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                qv0.a(th, th2);
            }
        }
    }
}
