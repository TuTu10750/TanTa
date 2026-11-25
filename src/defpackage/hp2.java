package defpackage;

import java.util.Comparator;

/* loaded from: /tmp/classes2.dex */
public final class hp2 implements Comparator {
    public static final hp2 a = new hp2();

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return nh3.a;
    }
}
