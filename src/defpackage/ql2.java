package defpackage;

import defpackage.kv1;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: /tmp/classes2.dex */
public abstract class ql2 {
    public static final void a(StringBuilder sb, fx1 fx1Var) {
        sb.append(g(fx1Var));
    }

    public static final String b(e eVar, boolean z, boolean z2) {
        String b;
        eVar.getClass();
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (eVar instanceof c) {
                b = "<init>";
            } else {
                b = eVar.getName().b();
                b.getClass();
            }
            sb.append(b);
        }
        sb.append("(");
        zb3 k0 = eVar.k0();
        if (k0 != null) {
            fx1 type = k0.getType();
            type.getClass();
            a(sb, type);
        }
        Iterator it = eVar.h().iterator();
        while (it.hasNext()) {
            fx1 type2 = ((h) it.next()).getType();
            type2.getClass();
            a(sb, type2);
        }
        sb.append(")");
        if (z) {
            if (dk0.c(eVar)) {
                sb.append("V");
            } else {
                fx1 returnType = eVar.getReturnType();
                returnType.getClass();
                a(sb, returnType);
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String c(e eVar, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return b(eVar, z, z2);
    }

    public static final String d(a aVar) {
        aVar.getClass();
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
        if (lk0.E(aVar)) {
            return null;
        }
        ra0 b = aVar.b();
        m00 m00Var = b instanceof m00 ? (m00) b : null;
        if (m00Var == null || m00Var.getName().j()) {
            return null;
        }
        a a = aVar.a();
        g gVar = a instanceof g ? (g) a : null;
        if (gVar == null) {
            return null;
        }
        return pl2.a(signatureBuildingComponents, m00Var, c(gVar, false, false, 3, null));
    }

    public static final boolean e(a aVar) {
        e k;
        aVar.getClass();
        if (!(aVar instanceof e)) {
            return false;
        }
        e eVar = (e) aVar;
        if (dq1.a(eVar.getName().b(), "remove") && eVar.h().size() == 1 && !SpecialBuiltinMembers.h((CallableMemberDescriptor) aVar)) {
            List h = eVar.a().h();
            h.getClass();
            fx1 type = ((h) b30.y0(h)).getType();
            type.getClass();
            kv1 g = g(type);
            kv1.d dVar = g instanceof kv1.d ? (kv1.d) g : null;
            if ((dVar != null ? dVar.i() : null) != JvmPrimitiveType.INT || (k = BuiltinMethodsWithSpecialGenericSignature.k(eVar)) == null) {
                return false;
            }
            List h2 = k.a().h();
            h2.getClass();
            fx1 type2 = ((h) b30.y0(h2)).getType();
            type2.getClass();
            kv1 g2 = g(type2);
            ra0 b = k.b();
            b.getClass();
            if (dq1.a(DescriptorUtilsKt.m(b), e.a.d0.j()) && (g2 instanceof kv1.c) && dq1.a(((kv1.c) g2).i(), "java/lang/Object")) {
                return true;
            }
        }
        return false;
    }

    public static final String f(m00 m00Var) {
        m00Var.getClass();
        at1 at1Var = at1.a;
        s51 j = DescriptorUtilsKt.l(m00Var).j();
        j.getClass();
        q00 n = at1Var.n(j);
        if (n == null) {
            return dk0.b(m00Var, null, 2, null);
        }
        String f = xu1.b(n).f();
        f.getClass();
        return f;
    }

    public static final kv1 g(fx1 fx1Var) {
        fx1Var.getClass();
        return (kv1) dk0.e(fx1Var, mv1.a, na4.o, ma4.a, null, null, 32, null);
    }
}
