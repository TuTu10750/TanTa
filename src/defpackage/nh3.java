package defpackage;

import java.util.Comparator;

/* loaded from: /tmp/classes2.dex */
public final class nh3 implements Comparator {
    public static final nh3 a = new nh3();

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        comparable.getClass();
        comparable2.getClass();
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return hp2.a;
    }
}
