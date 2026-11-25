package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;

/* loaded from: /tmp/classes2.dex */
public abstract class hq1 {
    public static final im2 a = new im2("InvalidModuleNotifier");

    public static final void a(mm2 mm2Var) {
        mm2Var.getClass();
        ue2.a(mm2Var.Y(a));
        throw new InvalidModuleException("Accessing invalid module descriptor " + mm2Var);
    }
}
