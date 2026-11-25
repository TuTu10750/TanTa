package defpackage;

import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public abstract class ua4 implements ta4 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ta4)) {
            return false;
        }
        ta4 ta4Var = (ta4) obj;
        return c() == ta4Var.c() && b() == ta4Var.b() && getType().equals(ta4Var.getType());
    }

    public int hashCode() {
        int hashCode = b().hashCode();
        if (n.w(getType())) {
            return (hashCode * 31) + 19;
        }
        return (hashCode * 31) + (c() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (c()) {
            return "*";
        }
        if (b() == Variance.INVARIANT) {
            return getType().toString();
        }
        return b() + " " + getType();
    }
}
