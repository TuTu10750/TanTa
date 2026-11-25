package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class n51 implements wr3 {
    private final wr3 delegate;

    public n51(wr3 wr3Var) {
        wr3Var.getClass();
        this.delegate = wr3Var;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final wr3 m1deprecated_delegate() {
        return this.delegate;
    }

    @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final wr3 delegate() {
        return this.delegate;
    }

    @Override // defpackage.wr3
    public long read(lk lkVar, long j) {
        lkVar.getClass();
        return this.delegate.read(lkVar, j);
    }

    @Override // defpackage.wr3
    public d54 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
