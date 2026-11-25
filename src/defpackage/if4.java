package defpackage;

import defpackage.sv1;
import defpackage.xi3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

/* loaded from: /tmp/classes2.dex */
public abstract class if4 {
    public static final r51 a = new r51("kotlin.jvm.JvmStatic");

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(mb mbVar, ClassLoader classLoader) {
        fx1 c;
        Class n;
        TypedArrayValue typedArrayValue = mbVar instanceof TypedArrayValue ? (TypedArrayValue) mbVar : null;
        if (typedArrayValue != null && (c = typedArrayValue.c()) != null) {
            Iterable iterable = (Iterable) mbVar.b();
            ArrayList arrayList = new ArrayList(t20.v(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(r((k50) it.next(), classLoader));
            }
            PrimitiveType N = d.N(c);
            int i = 0;
            switch (N == null ? -1 : a.a[N.ordinal()]) {
                case -1:
                    if (!d.c0(c)) {
                        os2.a("Not an array type: ", c);
                        break;
                    } else {
                        fx1 type = ((ta4) b30.y0(c.L0())).getType();
                        type.getClass();
                        z00 v = type.N0().v();
                        m00 m00Var = v instanceof m00 ? (m00) v : null;
                        if (m00Var == null) {
                            vt1.a("Not a class type: ", type);
                            return null;
                        }
                        if (d.v0(type)) {
                            int size = ((List) mbVar.b()).size();
                            String[] strArr = new String[size];
                            while (i < size) {
                                Object obj = arrayList.get(i);
                                obj.getClass();
                                strArr[i] = obj;
                                i++;
                            }
                            return strArr;
                        }
                        if (d.l0(m00Var)) {
                            int size2 = ((List) mbVar.b()).size();
                            Class[] clsArr = new Class[size2];
                            while (i < size2) {
                                Object obj2 = arrayList.get(i);
                                obj2.getClass();
                                clsArr[i] = obj2;
                                i++;
                            }
                            return clsArr;
                        }
                        q00 k = DescriptorUtilsKt.k(m00Var);
                        if (k == null || (n = n(classLoader, k, 0, 4, null)) == null) {
                            return null;
                        }
                        Object newInstance = Array.newInstance((Class<?>) n, ((List) mbVar.b()).size());
                        newInstance.getClass();
                        Object[] objArr = (Object[]) newInstance;
                        int size3 = arrayList.size();
                        while (i < size3) {
                            objArr[i] = arrayList.get(i);
                            i++;
                        }
                        return objArr;
                    }
                case 0:
                default:
                    u.a();
                    return null;
                case 1:
                    int size4 = ((List) mbVar.b()).size();
                    boolean[] zArr = new boolean[size4];
                    while (i < size4) {
                        Object obj3 = arrayList.get(i);
                        obj3.getClass();
                        zArr[i] = ((Boolean) obj3).booleanValue();
                        i++;
                    }
                    return zArr;
                case 2:
                    int size5 = ((List) mbVar.b()).size();
                    char[] cArr = new char[size5];
                    while (i < size5) {
                        Object obj4 = arrayList.get(i);
                        obj4.getClass();
                        cArr[i] = ((Character) obj4).charValue();
                        i++;
                    }
                    return cArr;
                case 3:
                    int size6 = ((List) mbVar.b()).size();
                    byte[] bArr = new byte[size6];
                    while (i < size6) {
                        Object obj5 = arrayList.get(i);
                        obj5.getClass();
                        bArr[i] = ((Byte) obj5).byteValue();
                        i++;
                    }
                    return bArr;
                case 4:
                    int size7 = ((List) mbVar.b()).size();
                    short[] sArr = new short[size7];
                    while (i < size7) {
                        Object obj6 = arrayList.get(i);
                        obj6.getClass();
                        sArr[i] = ((Short) obj6).shortValue();
                        i++;
                    }
                    return sArr;
                case 5:
                    int size8 = ((List) mbVar.b()).size();
                    int[] iArr = new int[size8];
                    while (i < size8) {
                        Object obj7 = arrayList.get(i);
                        obj7.getClass();
                        iArr[i] = ((Integer) obj7).intValue();
                        i++;
                    }
                    return iArr;
                case 6:
                    int size9 = ((List) mbVar.b()).size();
                    float[] fArr = new float[size9];
                    while (i < size9) {
                        Object obj8 = arrayList.get(i);
                        obj8.getClass();
                        fArr[i] = ((Float) obj8).floatValue();
                        i++;
                    }
                    return fArr;
                case 7:
                    int size10 = ((List) mbVar.b()).size();
                    long[] jArr = new long[size10];
                    while (i < size10) {
                        Object obj9 = arrayList.get(i);
                        obj9.getClass();
                        jArr[i] = ((Long) obj9).longValue();
                        i++;
                    }
                    return jArr;
                case 8:
                    int size11 = ((List) mbVar.b()).size();
                    double[] dArr = new double[size11];
                    while (i < size11) {
                        Object obj10 = arrayList.get(i);
                        obj10.getClass();
                        dArr[i] = ((Double) obj10).doubleValue();
                        i++;
                    }
                    return dArr;
            }
        }
        return null;
    }

    public static final KCallableImpl b(Object obj) {
        KCallableImpl kCallableImpl = obj instanceof KCallableImpl ? (KCallableImpl) obj : null;
        if (kCallableImpl != null) {
            return kCallableImpl;
        }
        KFunctionImpl c = c(obj);
        return c != null ? c : d(obj);
    }

    public static final KFunctionImpl c(Object obj) {
        KFunctionImpl kFunctionImpl = obj instanceof KFunctionImpl ? (KFunctionImpl) obj : null;
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        FunctionReference functionReference = obj instanceof FunctionReference ? (FunctionReference) obj : null;
        ov1 compute = functionReference != null ? functionReference.compute() : null;
        if (compute instanceof KFunctionImpl) {
            return (KFunctionImpl) compute;
        }
        return null;
    }

    public static final KPropertyImpl d(Object obj) {
        KPropertyImpl kPropertyImpl = obj instanceof KPropertyImpl ? (KPropertyImpl) obj : null;
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        PropertyReference propertyReference = obj instanceof PropertyReference ? (PropertyReference) obj : null;
        ov1 compute = propertyReference != null ? propertyReference.compute() : null;
        if (compute instanceof KPropertyImpl) {
            return (KPropertyImpl) compute;
        }
        return null;
    }

    public static final List e(a8 a8Var) {
        Annotation o;
        a8Var.getClass();
        j8<d8> annotations = a8Var.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (d8 d8Var : annotations) {
            xr3 j = d8Var.j();
            if (j instanceof rc3) {
                o = ((rc3) j).d();
            } else if (j instanceof xi3.a) {
                fd3 b = ((xi3.a) j).b();
                tc3 tc3Var = b instanceof tc3 ? (tc3) b : null;
                o = tc3Var != null ? tc3Var.Q() : null;
            } else {
                o = o(d8Var);
            }
            if (o != null) {
                arrayList.add(o);
            }
        }
        return s(arrayList);
    }

    public static final Class f(Class cls) {
        cls.getClass();
        return Array.newInstance((Class<?>) cls, 0).getClass();
    }

    public static final Object g(Type type) {
        type.getClass();
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (dq1.a(type, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (dq1.a(type, Character.TYPE)) {
                return (char) 0;
            }
            if (dq1.a(type, Byte.TYPE)) {
                return (byte) 0;
            }
            if (dq1.a(type, Short.TYPE)) {
                return (short) 0;
            }
            if (dq1.a(type, Integer.TYPE)) {
                return 0;
            }
            if (dq1.a(type, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (dq1.a(type, Long.TYPE)) {
                return 0L;
            }
            if (dq1.a(type, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (dq1.a(type, Void.TYPE)) {
                fl3.a("Parameter with void type is illegal");
                return null;
            }
            yb4.a("Unknown primitive: ", type);
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.a h(Class cls, g gVar, ap2 ap2Var, cb4 cb4Var, gi giVar, b91 b91Var) {
        List m0;
        cls.getClass();
        gVar.getClass();
        ap2Var.getClass();
        cb4Var.getClass();
        giVar.getClass();
        b91Var.getClass();
        wi3 a2 = hm2.a(cls);
        if (gVar instanceof ProtoBuf$Function) {
            m0 = ((ProtoBuf$Function) gVar).l0();
        } else {
            if (!(gVar instanceof ProtoBuf$Property)) {
                vt1.a("Unsupported message: ", gVar);
                return null;
            }
            m0 = ((ProtoBuf$Property) gVar).m0();
        }
        List list = m0;
        rk0 a3 = a2.a();
        mm2 b = a2.b();
        fg4 b2 = fg4.b.b();
        list.getClass();
        return (kotlin.reflect.jvm.internal.impl.descriptors.a) b91Var.invoke(new MemberDeserializer(new vk0(a3, ap2Var, b, cb4Var, b2, giVar, null, null, list)), gVar);
    }

    public static final zb3 i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        aVar.getClass();
        if (aVar.e0() == null) {
            return null;
        }
        ra0 b = aVar.b();
        b.getClass();
        return ((m00) b).J0();
    }

    public static final r51 j() {
        return a;
    }

    public static final boolean k(lw1 lw1Var) {
        fx1 p;
        lw1Var.getClass();
        KTypeImpl kTypeImpl = lw1Var instanceof KTypeImpl ? (KTypeImpl) lw1Var : null;
        return (kTypeImpl == null || (p = kTypeImpl.p()) == null || !vo1.c(p)) ? false : true;
    }

    public static final Class l(ClassLoader classLoader, q00 q00Var, int i) {
        at1 at1Var = at1.a;
        s51 j = q00Var.b().j();
        j.getClass();
        q00 n = at1Var.n(j);
        if (n != null) {
            q00Var = n;
        }
        String b = q00Var.h().b();
        b.getClass();
        String b2 = q00Var.i().b();
        b2.getClass();
        return m(classLoader, b, b2, i);
    }

    public static final Class m(ClassLoader classLoader, String str, String str2, int i) {
        if (dq1.a(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("[");
            }
            sb.append("L");
        }
        if (str.length() > 0) {
            sb.append(str + '.');
        }
        sb.append(fw3.E(str2, '.', '$', false, 4, null));
        if (i > 0) {
            sb.append(";");
        }
        return bd3.a(classLoader, sb.toString());
    }

    public static /* synthetic */ Class n(ClassLoader classLoader, q00 q00Var, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return l(classLoader, q00Var, i);
    }

    public static final Annotation o(d8 d8Var) {
        m00 i = DescriptorUtilsKt.i(d8Var);
        Class p = i != null ? p(i) : null;
        if (p == null) {
            p = null;
        }
        if (p == null) {
            return null;
        }
        Set<Map.Entry> entrySet = d8Var.k().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : entrySet) {
            zo2 zo2Var = (zo2) entry.getKey();
            k50 k50Var = (k50) entry.getValue();
            ClassLoader classLoader = p.getClassLoader();
            classLoader.getClass();
            Object r = r(k50Var, classLoader);
            Pair a2 = r != null ? g94.a(zo2Var.b(), r) : null;
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return (Annotation) AnnotationConstructorCallerKt.e(p, kotlin.collections.a.s(arrayList), null, 4, null);
    }

    public static final Class p(m00 m00Var) {
        m00Var.getClass();
        xr3 j = m00Var.j();
        j.getClass();
        if (j instanceof dx1) {
            c d = ((dx1) j).d();
            d.getClass();
            return ((ud3) d).e();
        }
        if (j instanceof xi3.a) {
            fd3 b = ((xi3.a) j).b();
            b.getClass();
            return ((ReflectJavaClass) b).x();
        }
        q00 k = DescriptorUtilsKt.k(m00Var);
        if (k == null) {
            return null;
        }
        return l(ReflectClassUtilKt.e(m00Var.getClass()), k, 0);
    }

    public static final KVisibility q(pk0 pk0Var) {
        pk0Var.getClass();
        if (dq1.a(pk0Var, ok0.e)) {
            return KVisibility.a;
        }
        if (dq1.a(pk0Var, ok0.c)) {
            return KVisibility.b;
        }
        if (dq1.a(pk0Var, ok0.d)) {
            return KVisibility.c;
        }
        if (dq1.a(pk0Var, ok0.a) ? true : dq1.a(pk0Var, ok0.b)) {
            return KVisibility.d;
        }
        return null;
    }

    public static final Object r(k50 k50Var, ClassLoader classLoader) {
        if (k50Var instanceof i8) {
            return o((d8) ((i8) k50Var).b());
        }
        if (k50Var instanceof mb) {
            return a((mb) k50Var, classLoader);
        }
        if (k50Var instanceof iu0) {
            Pair pair = (Pair) ((iu0) k50Var).b();
            q00 q00Var = (q00) pair.getFirst();
            zo2 zo2Var = (zo2) pair.getSecond();
            Class n = n(classLoader, q00Var, 0, 4, null);
            if (n != null) {
                return hf4.a(n, zo2Var.b());
            }
            return null;
        }
        if (!(k50Var instanceof sv1)) {
            if (k50Var instanceof yu0 ? true : k50Var instanceof mr2) {
                return null;
            }
            return k50Var.b();
        }
        sv1.b bVar = (sv1.b) ((sv1) k50Var).b();
        if (bVar instanceof sv1.b.C0156b) {
            sv1.b.C0156b c0156b = (sv1.b.C0156b) bVar;
            return l(classLoader, c0156b.b(), c0156b.a());
        }
        if (!(bVar instanceof sv1.b.a)) {
            u.a();
            return null;
        }
        z00 v = ((sv1.b.a) bVar).a().N0().v();
        m00 m00Var = v instanceof m00 ? (m00) v : null;
        if (m00Var != null) {
            return p(m00Var);
        }
        return null;
    }

    public static final List s(List list) {
        List e;
        if (list != null && list.isEmpty()) {
            return list;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (dq1.a(wu1.b(wu1.a((Annotation) it.next())).getSimpleName(), "Container")) {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Annotation annotation = (Annotation) it2.next();
                    Class b = wu1.b(wu1.a(annotation));
                    if (!dq1.a(b.getSimpleName(), "Container") || b.getAnnotation(ye3.class) == null) {
                        e = r20.e(annotation);
                    } else {
                        Object invoke = b.getDeclaredMethod("value", null).invoke(annotation, null);
                        invoke.getClass();
                        e = pb.e((Annotation[]) invoke);
                    }
                    x20.A(arrayList, e);
                }
                return arrayList;
            }
        }
        return list;
    }
}
