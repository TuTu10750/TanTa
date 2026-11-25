package defpackage;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.a;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class p30 {
    public static final boolean a(a aVar, m00 m00Var) {
        aVar.getClass();
        m00Var.getClass();
        if (!lk0.x(m00Var)) {
            return false;
        }
        Set b = aVar.b();
        q00 k = DescriptorUtilsKt.k(m00Var);
        return b30.T(b, k != null ? k.g() : null);
    }
}
