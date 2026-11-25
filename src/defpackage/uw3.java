package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class uw3 {
    public final Object a;
    public final sw3 b;
    public volatile boolean c = true;

    public uw3(Object obj, sw3 sw3Var) {
        this.a = obj;
        this.b = sw3Var;
    }

    public boolean equals(Object obj) {
        if (obj instanceof uw3) {
            uw3 uw3Var = (uw3) obj;
            if (this.a == uw3Var.a && this.b.equals(uw3Var.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
