package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class k50 {
    public final Object a;

    public k50(Object obj) {
        this.a = obj;
    }

    public abstract fx1 a(mm2 mm2Var);

    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Object b = b();
        k50 k50Var = obj instanceof k50 ? (k50) obj : null;
        return dq1.a(b, k50Var != null ? k50Var.b() : null);
    }

    public int hashCode() {
        Object b = b();
        if (b != null) {
            return b.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(b());
    }
}
