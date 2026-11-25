package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class m51 implements kq3 {
    private final kq3 delegate;

    public m51(kq3 kq3Var) {
        kq3Var.getClass();
        this.delegate = kq3Var;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final kq3 m0deprecated_delegate() {
        return this.delegate;
    }

    @Override // defpackage.kq3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final kq3 delegate() {
        return this.delegate;
    }

    @Override // defpackage.kq3, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // defpackage.kq3
    public d54 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // defpackage.kq3
    public void write(lk lkVar, long j) {
        lkVar.getClass();
        this.delegate.write(lkVar, j);
    }
}
