package defpackage;

import java.util.Comparator;

/* loaded from: /tmp/classes2.dex */
public abstract class s30 {
    public static int a(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static Comparator b() {
        hp2 hp2Var = hp2.a;
        hp2Var.getClass();
        return hp2Var;
    }
}
