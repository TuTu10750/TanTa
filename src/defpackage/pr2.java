package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: /tmp/classes2.dex */
public final class pr2 {
    public final NullabilityQualifier a;
    public final boolean b;

    public pr2(NullabilityQualifier nullabilityQualifier, boolean z) {
        nullabilityQualifier.getClass();
        this.a = nullabilityQualifier;
        this.b = z;
    }

    public /* synthetic */ pr2(NullabilityQualifier nullabilityQualifier, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }

    public static /* synthetic */ pr2 b(pr2 pr2Var, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = pr2Var.a;
        }
        if ((i & 2) != 0) {
            z = pr2Var.b;
        }
        return pr2Var.a(nullabilityQualifier, z);
    }

    public final pr2 a(NullabilityQualifier nullabilityQualifier, boolean z) {
        nullabilityQualifier.getClass();
        return new pr2(nullabilityQualifier, z);
    }

    public final NullabilityQualifier c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pr2)) {
            return false;
        }
        pr2 pr2Var = (pr2) obj;
        return this.a == pr2Var.a && this.b == pr2Var.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.a + ", isForWarningOnly=" + this.b + ')';
    }
}
