package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class co1 {
    public final int a;
    public final Object b;

    public co1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final int a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final Object d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof co1)) {
            return false;
        }
        co1 co1Var = (co1) obj;
        return this.a == co1Var.a && dq1.a(this.b, co1Var.b);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.a) * 31;
        Object obj = this.b;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ')';
    }
}
