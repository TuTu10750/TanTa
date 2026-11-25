package defpackage;

import java.lang.Thread;
import pl.droidsonroids.gif.a;

/* loaded from: /tmp/classes2.dex */
public abstract class jj3 implements Runnable {
    public final a a;

    public jj3(a aVar) {
        this.a = aVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.e()) {
                return;
            }
            a();
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
