package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /tmp/classes2.dex */
public final class ev extends gh0 {
    public final Runnable c;
    public final n81 d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ev(Runnable runnable, n81 n81Var) {
        this(new ReentrantLock(), runnable, n81Var);
        runnable.getClass();
        n81Var.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ev(Lock lock, Runnable runnable, n81 n81Var) {
        super(lock);
        lock.getClass();
        runnable.getClass();
        n81Var.getClass();
        this.c = runnable;
        this.d = n81Var;
    }

    @Override // defpackage.gh0, kotlin.reflect.jvm.internal.impl.storage.a
    public void lock() {
        while (!a().tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.c.run();
            } catch (InterruptedException e) {
                this.d.invoke(e);
                return;
            }
        }
    }
}
