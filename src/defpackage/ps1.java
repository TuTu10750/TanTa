package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* loaded from: /tmp/classes2.dex */
public final class ps1 {
    public static final a d = new a(null);
    public static final ps1 e = new ps1(ReportLevel.STRICT, null, null, 6, null);
    public final ReportLevel a;
    public final jx1 b;
    public final ReportLevel c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ps1 a() {
            return ps1.e;
        }
    }

    public ps1(ReportLevel reportLevel, jx1 jx1Var, ReportLevel reportLevel2) {
        reportLevel.getClass();
        reportLevel2.getClass();
        this.a = reportLevel;
        this.b = jx1Var;
        this.c = reportLevel2;
    }

    public /* synthetic */ ps1(ReportLevel reportLevel, jx1 jx1Var, ReportLevel reportLevel2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i & 2) != 0 ? new jx1(1, 0) : jx1Var, (i & 4) != 0 ? reportLevel : reportLevel2);
    }

    public final ReportLevel b() {
        return this.c;
    }

    public final ReportLevel c() {
        return this.a;
    }

    public final jx1 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ps1)) {
            return false;
        }
        ps1 ps1Var = (ps1) obj;
        return this.a == ps1Var.a && dq1.a(this.b, ps1Var.b) && this.c == ps1Var.c;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        jx1 jx1Var = this.b;
        return ((hashCode + (jx1Var == null ? 0 : jx1Var.hashCode())) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.a + ", sinceVersion=" + this.b + ", reportLevelAfter=" + this.c + ')';
    }
}
