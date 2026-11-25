package defpackage;

import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class to1 {
    public static final boolean a(m00 m00Var) {
        return dq1.a(DescriptorUtilsKt.l(m00Var), e.r);
    }

    public static final boolean b(ra0 ra0Var) {
        ra0Var.getClass();
        return vo1.b(ra0Var) && !a((m00) ra0Var);
    }

    public static final boolean c(fx1 fx1Var) {
        fx1Var.getClass();
        z00 v = fx1Var.N0().v();
        return v != null && b(v);
    }

    public static final boolean d(fx1 fx1Var) {
        z00 v = fx1Var.N0().v();
        oa4 oa4Var = v instanceof oa4 ? (oa4) v : null;
        if (oa4Var == null) {
            return false;
        }
        return e(TypeUtilsKt.j(oa4Var));
    }

    public static final boolean e(fx1 fx1Var) {
        return c(fx1Var) || d(fx1Var);
    }

    public static final boolean f(CallableMemberDescriptor callableMemberDescriptor) {
        callableMemberDescriptor.getClass();
        b bVar = callableMemberDescriptor instanceof b ? (b) callableMemberDescriptor : null;
        if (bVar == null || ok0.g(bVar.getVisibility())) {
            return false;
        }
        m00 B = bVar.B();
        B.getClass();
        if (vo1.b(B) || lk0.G(bVar.B())) {
            return false;
        }
        List h = bVar.h();
        h.getClass();
        if (h != null && h.isEmpty()) {
            return false;
        }
        Iterator it = h.iterator();
        while (it.hasNext()) {
            fx1 type = ((h) it.next()).getType();
            type.getClass();
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
