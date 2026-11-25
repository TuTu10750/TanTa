package defpackage;

import kotlin.reflect.jvm.internal.impl.builtins.a;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public abstract class qk0 {
    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 2) {
            objArr[0] = "companionObject";
        } else if (i != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(CallableMemberDescriptor callableMemberDescriptor) {
        v01 o0;
        if (callableMemberDescriptor == null) {
            a(3);
        }
        if ((callableMemberDescriptor instanceof o33) && (o0 = ((o33) callableMemberDescriptor).o0()) != null && o0.getAnnotations().c(pu1.b)) {
            return true;
        }
        return callableMemberDescriptor.getAnnotations().c(pu1.b);
    }

    public static boolean c(ra0 ra0Var) {
        if (ra0Var == null) {
            a(1);
        }
        return lk0.x(ra0Var) && lk0.w(ra0Var.b()) && !d((m00) ra0Var);
    }

    public static boolean d(m00 m00Var) {
        if (m00Var == null) {
            a(2);
        }
        return p30.a(a.a, m00Var);
    }

    public static boolean e(o33 o33Var) {
        if (o33Var == null) {
            a(0);
        }
        if (o33Var.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (c(o33Var.b())) {
            return true;
        }
        return lk0.x(o33Var.b()) && b(o33Var);
    }
}
