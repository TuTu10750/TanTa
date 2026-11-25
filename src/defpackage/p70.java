package defpackage;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: /tmp/classes2.dex */
public abstract class p70 {
    public static final Collection a = SequencesKt___SequencesKt.S(kn3.g(ServiceLoader.load(o70.class, o70.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
