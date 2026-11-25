package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* loaded from: /tmp/classes2.dex */
public class p51 extends d54 {
    public d54 a;

    public p51(d54 d54Var) {
        d54Var.getClass();
        this.a = d54Var;
    }

    public final d54 a() {
        return this.a;
    }

    @Override // defpackage.d54
    public void awaitSignal(Condition condition) {
        condition.getClass();
        this.a.awaitSignal(condition);
    }

    public final p51 b(d54 d54Var) {
        d54Var.getClass();
        this.a = d54Var;
        return this;
    }

    @Override // defpackage.d54
    public d54 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // defpackage.d54
    public d54 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // defpackage.d54
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // defpackage.d54
    public d54 deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }

    @Override // defpackage.d54
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // defpackage.d54
    public void throwIfReached() {
        this.a.throwIfReached();
    }

    @Override // defpackage.d54
    public d54 timeout(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.a.timeout(j, timeUnit);
    }

    @Override // defpackage.d54
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // defpackage.d54
    public void waitUntilNotified(Object obj) {
        obj.getClass();
        this.a.waitUntilNotified(obj);
    }
}
