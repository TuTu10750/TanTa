package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class cd2 {
    public final String a;
    public final pp1 b;

    public cd2(String str, pp1 pp1Var) {
        str.getClass();
        pp1Var.getClass();
        this.a = str;
        this.b = pp1Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cd2)) {
            return false;
        }
        cd2 cd2Var = (cd2) obj;
        return dq1.a(this.a, cd2Var.a) && dq1.a(this.b, cd2Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
