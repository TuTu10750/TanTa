package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class h44 {
    public static final h44 a = new h44();
    public static final ThreadLocal b = i44.a(new p04("ThreadLocalEventLoop"));

    public final dv0 a() {
        ThreadLocal threadLocal = b;
        dv0 dv0Var = (dv0) threadLocal.get();
        if (dv0Var != null) {
            return dv0Var;
        }
        dv0 a2 = gv0.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void b() {
        b.set(null);
    }

    public final void c(dv0 dv0Var) {
        b.set(dv0Var);
    }
}
