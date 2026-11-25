package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class sn {
    public static final a e = new a(null);
    public static final zo2 f;
    public static final r51 g;
    public final r51 a;
    public final r51 b;
    public final zo2 c;
    public final r51 d;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        zo2 zo2Var = ls3.m;
        f = zo2Var;
        r51 k = r51.k(zo2Var);
        k.getClass();
        g = k;
    }

    public sn(r51 r51Var, r51 r51Var2, zo2 zo2Var, r51 r51Var3) {
        r51Var.getClass();
        zo2Var.getClass();
        this.a = r51Var;
        this.b = r51Var2;
        this.c = zo2Var;
        this.d = r51Var3;
    }

    public /* synthetic */ sn(r51 r51Var, r51 r51Var2, zo2 zo2Var, r51 r51Var3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r51Var, r51Var2, zo2Var, (i & 8) != 0 ? null : r51Var3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sn(r51 r51Var, zo2 zo2Var) {
        this(r51Var, null, zo2Var, null, 8, null);
        r51Var.getClass();
        zo2Var.getClass();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sn)) {
            return false;
        }
        sn snVar = (sn) obj;
        return dq1.a(this.a, snVar.a) && dq1.a(this.b, snVar.b) && dq1.a(this.c, snVar.c) && dq1.a(this.d, snVar.d);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        r51 r51Var = this.b;
        int hashCode2 = (((hashCode + (r51Var == null ? 0 : r51Var.hashCode())) * 31) + this.c.hashCode()) * 31;
        r51 r51Var2 = this.d;
        return hashCode2 + (r51Var2 != null ? r51Var2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String b = this.a.b();
        b.getClass();
        sb.append(fw3.E(b, '.', '/', false, 4, null));
        sb.append("/");
        r51 r51Var = this.b;
        if (r51Var != null) {
            sb.append(r51Var);
            sb.append(".");
        }
        sb.append(this.c);
        return sb.toString();
    }
}
