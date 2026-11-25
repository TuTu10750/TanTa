package defpackage;

import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationLevelValue;

/* loaded from: /tmp/classes2.dex */
public abstract class zj0 implements Comparable {
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(zj0 zj0Var) {
        zj0Var.getClass();
        int compareTo = b().compareTo(zj0Var.b());
        if (compareTo == 0 && !c() && zj0Var.c()) {
            return 1;
        }
        return compareTo;
    }

    public abstract DeprecationLevelValue b();

    public abstract boolean c();
}
