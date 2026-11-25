package defpackage;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: /tmp/classes2.dex */
public class bk2 implements Comparator {
    public static final bk2 a = new bk2();

    public static Integer b(ra0 ra0Var, ra0 ra0Var2) {
        int c = c(ra0Var2) - c(ra0Var);
        if (c != 0) {
            return Integer.valueOf(c);
        }
        if (lk0.B(ra0Var) && lk0.B(ra0Var2)) {
            return 0;
        }
        int compareTo = ra0Var.getName().compareTo(ra0Var2.getName());
        if (compareTo != 0) {
            return Integer.valueOf(compareTo);
        }
        return null;
    }

    public static int c(ra0 ra0Var) {
        if (lk0.B(ra0Var)) {
            return 8;
        }
        if (ra0Var instanceof c) {
            return 7;
        }
        if (ra0Var instanceof o33) {
            return ((o33) ra0Var).k0() == null ? 6 : 5;
        }
        if (ra0Var instanceof e) {
            return ((e) ra0Var).k0() == null ? 4 : 3;
        }
        if (ra0Var instanceof m00) {
            return 2;
        }
        return ra0Var instanceof r94 ? 1 : 0;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ra0 ra0Var, ra0 ra0Var2) {
        Integer b = b(ra0Var, ra0Var2);
        if (b != null) {
            return b.intValue();
        }
        return 0;
    }
}
