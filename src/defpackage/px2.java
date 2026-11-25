package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class px2 {
    public ox2 a;
    public ox2 b;

    public synchronized void a(ox2 ox2Var) {
        try {
            if (ox2Var == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            ox2 ox2Var2 = this.b;
            if (ox2Var2 != null) {
                ox2Var2.c = ox2Var;
                this.b = ox2Var;
            } else {
                if (this.a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = ox2Var;
                this.a = ox2Var;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ox2 b() {
        ox2 ox2Var;
        ox2Var = this.a;
        if (ox2Var != null) {
            ox2 ox2Var2 = ox2Var.c;
            this.a = ox2Var2;
            if (ox2Var2 == null) {
                this.b = null;
            }
        }
        return ox2Var;
    }

    public synchronized ox2 c(int i) {
        try {
            if (this.a == null) {
                wait(i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }
}
