package defpackage;

import defpackage.bv1;
import defpackage.e31;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: /tmp/classes2.dex */
public final class hv1 {
    public static final hv1 a = new hv1();
    public static final d b;

    static {
        d d = d.d();
        JvmProtoBuf.a(d);
        d.getClass();
        b = d;
    }

    public static /* synthetic */ bv1.a d(hv1 hv1Var, ProtoBuf$Property protoBuf$Property, ap2 ap2Var, cb4 cb4Var, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return hv1Var.c(protoBuf$Property, ap2Var, cb4Var, z);
    }

    public static final boolean f(ProtoBuf$Property protoBuf$Property) {
        protoBuf$Property.getClass();
        e31.b a2 = av1.a.a();
        Object u = protoBuf$Property.u(JvmProtoBuf.e);
        u.getClass();
        Boolean d = a2.d(((Number) u).intValue());
        d.getClass();
        return d.booleanValue();
    }

    public static final Pair h(byte[] bArr, String[] strArr) {
        bArr.getClass();
        strArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair(a.k(byteArrayInputStream, strArr), ProtoBuf$Class.w1(byteArrayInputStream, b));
    }

    public static final Pair i(String[] strArr, String[] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        byte[] e = mi.e(strArr);
        e.getClass();
        return h(e, strArr2);
    }

    public static final Pair j(String[] strArr, String[] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mi.e(strArr));
        return new Pair(a.k(byteArrayInputStream, strArr2), ProtoBuf$Function.E0(byteArrayInputStream, b));
    }

    public static final Pair l(byte[] bArr, String[] strArr) {
        bArr.getClass();
        strArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair(a.k(byteArrayInputStream, strArr), ProtoBuf$Package.d0(byteArrayInputStream, b));
    }

    public static final Pair m(String[] strArr, String[] strArr2) {
        strArr.getClass();
        strArr2.getClass();
        byte[] e = mi.e(strArr);
        e.getClass();
        return l(e, strArr2);
    }

    public final d a() {
        return b;
    }

    public final bv1.b b(ProtoBuf$Constructor protoBuf$Constructor, ap2 ap2Var, cb4 cb4Var) {
        String k0;
        protoBuf$Constructor.getClass();
        ap2Var.getClass();
        cb4Var.getClass();
        GeneratedMessageLite.e eVar = JvmProtoBuf.a;
        eVar.getClass();
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) z33.a(protoBuf$Constructor, eVar);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.z()) ? "<init>" : ap2Var.getString(jvmMethodSignature.x());
        if (jvmMethodSignature == null || !jvmMethodSignature.y()) {
            List<ProtoBuf$ValueParameter> M = protoBuf$Constructor.M();
            M.getClass();
            ArrayList arrayList = new ArrayList(t20.v(M, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : M) {
                hv1 hv1Var = a;
                protoBuf$ValueParameter.getClass();
                String g = hv1Var.g(e43.q(protoBuf$ValueParameter, cb4Var), ap2Var);
                if (g == null) {
                    return null;
                }
                arrayList.add(g);
            }
            k0 = b30.k0(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            k0 = ap2Var.getString(jvmMethodSignature.w());
        }
        return new bv1.b(string, k0);
    }

    public final bv1.a c(ProtoBuf$Property protoBuf$Property, ap2 ap2Var, cb4 cb4Var, boolean z) {
        String g;
        protoBuf$Property.getClass();
        ap2Var.getClass();
        cb4Var.getClass();
        GeneratedMessageLite.e eVar = JvmProtoBuf.d;
        eVar.getClass();
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) z33.a(protoBuf$Property, eVar);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature A = jvmPropertySignature.F() ? jvmPropertySignature.A() : null;
        if (A == null && z) {
            return null;
        }
        int c0 = (A == null || !A.z()) ? protoBuf$Property.c0() : A.x();
        if (A == null || !A.y()) {
            g = g(e43.n(protoBuf$Property, cb4Var), ap2Var);
            if (g == null) {
                return null;
            }
        } else {
            g = ap2Var.getString(A.w());
        }
        return new bv1.a(ap2Var.getString(c0), g);
    }

    public final bv1.b e(ProtoBuf$Function protoBuf$Function, ap2 ap2Var, cb4 cb4Var) {
        String str;
        protoBuf$Function.getClass();
        ap2Var.getClass();
        cb4Var.getClass();
        GeneratedMessageLite.e eVar = JvmProtoBuf.b;
        eVar.getClass();
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) z33.a(protoBuf$Function, eVar);
        int d0 = (jvmMethodSignature == null || !jvmMethodSignature.z()) ? protoBuf$Function.d0() : jvmMethodSignature.x();
        if (jvmMethodSignature == null || !jvmMethodSignature.y()) {
            List o = s20.o(e43.k(protoBuf$Function, cb4Var));
            List<ProtoBuf$ValueParameter> p0 = protoBuf$Function.p0();
            p0.getClass();
            ArrayList arrayList = new ArrayList(t20.v(p0, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : p0) {
                protoBuf$ValueParameter.getClass();
                arrayList.add(e43.q(protoBuf$ValueParameter, cb4Var));
            }
            List v0 = b30.v0(o, arrayList);
            ArrayList arrayList2 = new ArrayList(t20.v(v0, 10));
            Iterator it = v0.iterator();
            while (it.hasNext()) {
                String g = a.g((ProtoBuf$Type) it.next(), ap2Var);
                if (g == null) {
                    return null;
                }
                arrayList2.add(g);
            }
            String g2 = g(e43.m(protoBuf$Function, cb4Var), ap2Var);
            if (g2 == null) {
                return null;
            }
            str = b30.k0(arrayList2, "", "(", ")", 0, null, null, 56, null) + g2;
        } else {
            str = ap2Var.getString(jvmMethodSignature.w());
        }
        return new bv1.b(ap2Var.getString(d0), str);
    }

    public final String g(ProtoBuf$Type protoBuf$Type, ap2 ap2Var) {
        if (protoBuf$Type.l0()) {
            return s00.b(ap2Var.a(protoBuf$Type.W()));
        }
        return null;
    }

    public final dv1 k(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes D = JvmProtoBuf.StringTableTypes.D(inputStream, b);
        D.getClass();
        return new dv1(D, strArr);
    }
}
