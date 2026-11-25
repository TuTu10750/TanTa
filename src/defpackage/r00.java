package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class r00 {
    public final q00 a;
    public final int b;

    public r00(q00 q00Var, int i) {
        q00Var.getClass();
        this.a = q00Var;
        this.b = i;
    }

    public final q00 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    public final q00 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r00)) {
            return false;
        }
        r00 r00Var = (r00) obj;
        return dq1.a(this.a, r00Var.a) && this.b == r00Var.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("kotlin/Array<");
        }
        sb.append(this.a);
        int i3 = this.b;
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append(">");
        }
        return sb.toString();
    }
}
