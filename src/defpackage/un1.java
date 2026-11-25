package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class un1 {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final String e;
    public final q00 f;

    public un1(Object obj, Object obj2, Object obj3, Object obj4, String str, q00 q00Var) {
        str.getClass();
        q00Var.getClass();
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
        this.e = str;
        this.f = q00Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof un1)) {
            return false;
        }
        un1 un1Var = (un1) obj;
        return dq1.a(this.a, un1Var.a) && dq1.a(this.b, un1Var.b) && dq1.a(this.c, un1Var.c) && dq1.a(this.d, un1Var.d) && dq1.a(this.e, un1Var.e) && dq1.a(this.f, un1Var.f);
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        int hashCode2 = (hashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.c;
        int hashCode3 = (hashCode2 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.d;
        return ((((hashCode3 + (obj4 != null ? obj4.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.a + ", compilerVersion=" + this.b + ", languageVersion=" + this.c + ", expectedVersion=" + this.d + ", filePath=" + this.e + ", classId=" + this.f + ')';
    }
}
