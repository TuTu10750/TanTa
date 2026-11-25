package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class rv2 implements i00 {
    public final Class a;
    public final String b;

    public rv2(Class cls, String str) {
        cls.getClass();
        str.getClass();
        this.a = cls;
        this.b = str;
    }

    @Override // defpackage.i00
    public Class c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof rv2) && dq1.a(c(), ((rv2) obj).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
