package defpackage;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.calls.a;
import kotlin.reflect.jvm.internal.calls.c;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public abstract class so1 {
    public static final Object a(Object obj, CallableMemberDescriptor callableMemberDescriptor) {
        fx1 e;
        Class i;
        Method f;
        callableMemberDescriptor.getClass();
        return (((callableMemberDescriptor instanceof o33) && vo1.e((rf4) callableMemberDescriptor)) || (e = e(callableMemberDescriptor)) == null || (i = i(e)) == null || (f = f(i, callableMemberDescriptor)) == null) ? obj : f.invoke(obj, null);
    }

    public static final a b(a aVar, CallableMemberDescriptor callableMemberDescriptor, boolean z) {
        aVar.getClass();
        callableMemberDescriptor.getClass();
        if (!vo1.a(callableMemberDescriptor)) {
            List h = callableMemberDescriptor.h();
            h.getClass();
            if (h == null || !h.isEmpty()) {
                Iterator it = h.iterator();
                while (it.hasNext()) {
                    fx1 type = ((h) it.next()).getType();
                    type.getClass();
                    if (vo1.c(type)) {
                        break;
                    }
                }
            }
            fx1 returnType = callableMemberDescriptor.getReturnType();
            if ((returnType == null || !vo1.c(returnType)) && ((aVar instanceof bk) || !g(callableMemberDescriptor))) {
                return aVar;
            }
        }
        return new c(callableMemberDescriptor, aVar, z);
    }

    public static /* synthetic */ a c(a aVar, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return b(aVar, callableMemberDescriptor, z);
    }

    public static final Method d(Class cls, CallableMemberDescriptor callableMemberDescriptor) {
        cls.getClass();
        callableMemberDescriptor.getClass();
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, callableMemberDescriptor).getReturnType());
            declaredMethod.getClass();
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            yi3.a("No box method found in inline class: ", cls, " (calling ", callableMemberDescriptor);
            return null;
        }
    }

    public static final fx1 e(CallableMemberDescriptor callableMemberDescriptor) {
        zb3 k0 = callableMemberDescriptor.k0();
        zb3 e0 = callableMemberDescriptor.e0();
        if (k0 != null) {
            return k0.getType();
        }
        if (e0 == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
            return e0.getType();
        }
        ra0 b = callableMemberDescriptor.b();
        m00 m00Var = b instanceof m00 ? (m00) b : null;
        if (m00Var != null) {
            return m00Var.u();
        }
        return null;
    }

    public static final Method f(Class cls, CallableMemberDescriptor callableMemberDescriptor) {
        cls.getClass();
        callableMemberDescriptor.getClass();
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            declaredMethod.getClass();
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            yi3.a("No unbox method found in inline class: ", cls, " (calling ", callableMemberDescriptor);
            return null;
        }
    }

    public static final boolean g(CallableMemberDescriptor callableMemberDescriptor) {
        fx1 e = e(callableMemberDescriptor);
        return e != null && vo1.c(e);
    }

    public static final Class h(ra0 ra0Var) {
        if (!(ra0Var instanceof m00) || !vo1.b(ra0Var)) {
            return null;
        }
        m00 m00Var = (m00) ra0Var;
        Class p = if4.p(m00Var);
        if (p != null) {
            return p;
        }
        StringBuilder sb = new StringBuilder("Class object for the class ");
        sb.append(m00Var.getName());
        q00 k = DescriptorUtilsKt.k((z00) ra0Var);
        sb.append(" cannot be found (classId=");
        sb.append(k);
        sb.append(')');
        throw new KotlinReflectionInternalError(sb.toString());
    }

    public static final Class i(fx1 fx1Var) {
        fx1 g;
        fx1Var.getClass();
        Class h = h(fx1Var.N0().v());
        if (h == null) {
            return null;
        }
        if (n.l(fx1Var) && ((g = vo1.g(fx1Var)) == null || n.l(g) || d.s0(g))) {
            return null;
        }
        return h;
    }
}
