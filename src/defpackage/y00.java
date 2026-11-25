package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class y00 implements ea4 {
    public int a;

    @Override // defpackage.ea4
    /* renamed from: b */
    public abstract z00 v();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ea4) || obj.hashCode() != hashCode()) {
            return false;
        }
        ea4 ea4Var = (ea4) obj;
        if (ea4Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        z00 v = v();
        z00 v2 = ea4Var.v();
        if (v2 != null && g(v) && g(v2)) {
            return h(v2);
        }
        return false;
    }

    public final boolean f(z00 z00Var, z00 z00Var2) {
        z00Var.getClass();
        z00Var2.getClass();
        if (!dq1.a(z00Var.getName(), z00Var2.getName())) {
            return false;
        }
        ra0 b = z00Var.b();
        for (ra0 b2 = z00Var2.b(); b != null && b2 != null; b2 = b2.b()) {
            if (b instanceof mm2) {
                return b2 instanceof mm2;
            }
            if (b2 instanceof mm2) {
                return false;
            }
            if (b instanceof kv2) {
                return (b2 instanceof kv2) && dq1.a(((kv2) b).d(), ((kv2) b2).d());
            }
            if ((b2 instanceof kv2) || !dq1.a(b.getName(), b2.getName())) {
                return false;
            }
            b = b.b();
        }
        return true;
    }

    public final boolean g(z00 z00Var) {
        return (xu0.m(z00Var) || lk0.E(z00Var)) ? false : true;
    }

    public abstract boolean h(z00 z00Var);

    public int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        z00 v = v();
        int hashCode = g(v) ? lk0.m(v).hashCode() : System.identityHashCode(this);
        this.a = hashCode;
        return hashCode;
    }
}
