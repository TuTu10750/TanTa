package defpackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.a;

/* loaded from: /tmp/classes2.dex */
public class gh0 implements a {
    public final Lock b;

    public gh0(Lock lock) {
        lock.getClass();
        this.b = lock;
    }

    public /* synthetic */ gh0(Lock lock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }

    public final Lock a() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.a
    public void lock() {
        this.b.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.a
    public void unlock() {
        this.b.unlock();
    }
}
