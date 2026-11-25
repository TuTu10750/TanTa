package defpackage;

import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;

/* loaded from: /tmp/classes2.dex */
public abstract class kf4 {
    public static final d8 a(ey1 ey1Var, pt1 pt1Var) {
        ey1Var.getClass();
        pt1Var.getClass();
        Object obj = null;
        if (pt1Var.D() == null) {
            ik.a("Nullability annotations on unbounded wildcards aren't supported");
            return null;
        }
        Iterator it = new LazyJavaAnnotations(ey1Var, pt1Var, false, 4, null).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            d8 d8Var = (d8) next;
            for (r51 r51Var : os1.f()) {
                if (dq1.a(d8Var.d(), r51Var)) {
                    obj = next;
                    break loop0;
                }
            }
        }
        return (d8) obj;
    }

    public static final boolean b(CallableMemberDescriptor callableMemberDescriptor) {
        callableMemberDescriptor.getClass();
        return (callableMemberDescriptor instanceof e) && dq1.a(callableMemberDescriptor.h0(JavaMethodDescriptor.H), Boolean.TRUE);
    }

    public static final boolean c(JavaTypeEnhancementState javaTypeEnhancementState) {
        javaTypeEnhancementState.getClass();
        return javaTypeEnhancementState.c().invoke(os1.e()) == ReportLevel.STRICT;
    }

    public static final pk0 d(am4 am4Var) {
        am4Var.getClass();
        pk0 g = zr1.g(am4Var);
        g.getClass();
        return g;
    }
}
