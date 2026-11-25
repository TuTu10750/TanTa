package defpackage;

/* loaded from: /tmp/classes2.dex */
public class rn1 implements bc3, a44 {
    public final m00 a;
    public final rn1 b;
    public final m00 c;

    public rn1(m00 m00Var, rn1 rn1Var) {
        m00Var.getClass();
        this.a = m00Var;
        this.b = rn1Var == null ? this : rn1Var;
        this.c = m00Var;
    }

    @Override // defpackage.bc3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public zp3 getType() {
        zp3 u = this.a.u();
        u.getClass();
        return u;
    }

    public boolean equals(Object obj) {
        m00 m00Var = this.a;
        rn1 rn1Var = obj instanceof rn1 ? (rn1) obj : null;
        return dq1.a(m00Var, rn1Var != null ? rn1Var.a : null);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.a44
    public final m00 t() {
        return this.a;
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
