package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class m8 extends v94 {
    public final j8 a;

    public m8(j8 j8Var) {
        j8Var.getClass();
        this.a = j8Var;
    }

    @Override // defpackage.v94
    public rv1 b() {
        return zd3.b(m8.class);
    }

    @Override // defpackage.v94
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public m8 a(m8 m8Var) {
        return m8Var == null ? this : new m8(l8.a(this.a, m8Var.a));
    }

    public final j8 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m8) {
            return dq1.a(((m8) obj).a, this.a);
        }
        return false;
    }

    @Override // defpackage.v94
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public m8 c(m8 m8Var) {
        if (dq1.a(m8Var, this)) {
            return this;
        }
        return null;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
