package defpackage;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: /tmp/classes2.dex */
public final class wr1 {
    public final pr2 a;
    public final Collection b;
    public final boolean c;

    public wr1(pr2 pr2Var, Collection collection, boolean z) {
        pr2Var.getClass();
        collection.getClass();
        this.a = pr2Var;
        this.b = collection;
        this.c = z;
    }

    public /* synthetic */ wr1(pr2 pr2Var, Collection collection, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pr2Var, collection, (i & 4) != 0 ? pr2Var.c() == NullabilityQualifier.NOT_NULL : z);
    }

    public static /* synthetic */ wr1 b(wr1 wr1Var, pr2 pr2Var, Collection collection, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            pr2Var = wr1Var.a;
        }
        if ((i & 2) != 0) {
            collection = wr1Var.b;
        }
        if ((i & 4) != 0) {
            z = wr1Var.c;
        }
        return wr1Var.a(pr2Var, collection, z);
    }

    public final wr1 a(pr2 pr2Var, Collection collection, boolean z) {
        pr2Var.getClass();
        collection.getClass();
        return new wr1(pr2Var, collection, z);
    }

    public final boolean c() {
        return this.c;
    }

    public final pr2 d() {
        return this.a;
    }

    public final Collection e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wr1)) {
            return false;
        }
        wr1 wr1Var = (wr1) obj;
        return dq1.a(this.a, wr1Var.a) && dq1.a(this.b, wr1Var.b) && this.c == wr1Var.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.a + ", qualifierApplicabilityTypes=" + this.b + ", definitelyNotNull=" + this.c + ')';
    }
}
