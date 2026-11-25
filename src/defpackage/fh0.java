package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class fh0 extends ck3 {
    public static final fh0 h = new fh0();

    public fh0() {
        super(o24.c, o24.d, o24.e, o24.a);
    }

    @Override // defpackage.n70
    public n70 B0(int i, String str) {
        fz1.a(i);
        return i >= o24.c ? fz1.b(this, str) : super.B0(i, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.n70
    public String toString() {
        return "Dispatchers.Default";
    }
}
