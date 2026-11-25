package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class l24 extends j24 {
    public final Runnable c;

    public l24(Runnable runnable, long j, boolean z) {
        super(j, z);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.run();
    }

    public String toString() {
        String c;
        StringBuilder sb = new StringBuilder("Task[");
        sb.append(na0.a(this.c));
        sb.append('@');
        sb.append(na0.b(this.c));
        sb.append(", ");
        sb.append(this.a);
        sb.append(", ");
        c = o24.c(this.b);
        sb.append(c);
        sb.append(']');
        return sb.toString();
    }
}
