package defpackage;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class gg0 extends vv0 implements Executor {
    public static final gg0 c = new gg0();
    public static final n70 d;

    static {
        int e;
        wc4 wc4Var = wc4.b;
        e = p14.e("kotlinx.coroutines.io.parallelism", fb3.c(64, n14.a()), 0, 0, 12, null);
        d = n70.C0(wc4Var, e, null, 2, null);
    }

    @Override // defpackage.n70
    public n70 B0(int i, String str) {
        return wc4.b.B0(i, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        y0(EmptyCoroutineContext.a, runnable);
    }

    @Override // defpackage.n70
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // defpackage.n70
    public void y0(d dVar, Runnable runnable) {
        d.y0(dVar, runnable);
    }
}
