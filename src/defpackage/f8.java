package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;

/* loaded from: /tmp/classes2.dex */
public final class f8 {
    public final mm2 a;
    public final NotFoundClasses b;

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ProtoBuf$Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            a = iArr;
        }
    }

    public f8(mm2 mm2Var, NotFoundClasses notFoundClasses) {
        mm2Var.getClass();
        notFoundClasses.getClass();
        this.a = mm2Var;
        this.b = notFoundClasses;
    }

    public final d8 a(ProtoBuf$Annotation protoBuf$Annotation, ap2 ap2Var) {
        protoBuf$Annotation.getClass();
        ap2Var.getClass();
        m00 e = e(cp2.a(ap2Var, protoBuf$Annotation.A()));
        Map i = kotlin.collections.a.i();
        if (protoBuf$Annotation.x() != 0 && !xu0.m(e) && lk0.t(e)) {
            Collection m = e.m();
            m.getClass();
            b bVar = (b) b30.z0(m);
            if (bVar != null) {
                List h = bVar.h();
                h.getClass();
                LinkedHashMap linkedHashMap = new LinkedHashMap(fb3.c(sc2.e(t20.v(h, 10)), 16));
                for (Object obj : h) {
                    linkedHashMap.put(((h) obj).getName(), obj);
                }
                List<ProtoBuf$Annotation.Argument> y = protoBuf$Annotation.y();
                y.getClass();
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf$Annotation.Argument argument : y) {
                    argument.getClass();
                    Pair d = d(argument, linkedHashMap, ap2Var);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
                i = kotlin.collections.a.s(arrayList);
            }
        }
        return new e8(e.u(), i, xr3.a);
    }

    public final boolean b(k50 k50Var, fx1 fx1Var, ProtoBuf$Annotation.Argument.Value value) {
        ProtoBuf$Annotation.Argument.Value.Type S = value.S();
        int i = S == null ? -1 : a.a[S.ordinal()];
        if (i == 10) {
            z00 v = fx1Var.N0().v();
            m00 m00Var = v instanceof m00 ? (m00) v : null;
            return m00Var == null || d.l0(m00Var);
        }
        if (i != 13) {
            return dq1.a(k50Var.a(this.a), fx1Var);
        }
        if (!(k50Var instanceof mb) || ((List) ((mb) k50Var).b()).size() != value.J().size()) {
            os2.a("Deserialized ArrayValue should have the same number of elements as the original array value: ", k50Var);
            return false;
        }
        fx1 k = c().k(fx1Var);
        k.getClass();
        mb mbVar = (mb) k50Var;
        Iterable l = s20.l((Collection) mbVar.b());
        if ((l instanceof Collection) && ((Collection) l).isEmpty()) {
            return true;
        }
        Iterator it = l.iterator();
        while (it.hasNext()) {
            int nextInt = ((lp1) it).nextInt();
            k50 k50Var2 = (k50) ((List) mbVar.b()).get(nextInt);
            ProtoBuf$Annotation.Argument.Value H = value.H(nextInt);
            H.getClass();
            if (!b(k50Var2, k, H)) {
                return false;
            }
        }
        return true;
    }

    public final d c() {
        return this.a.q();
    }

    public final Pair d(ProtoBuf$Annotation.Argument argument, Map map, ap2 ap2Var) {
        h hVar = (h) map.get(cp2.b(ap2Var, argument.w()));
        if (hVar == null) {
            return null;
        }
        zo2 b = cp2.b(ap2Var, argument.w());
        fx1 type = hVar.getType();
        type.getClass();
        ProtoBuf$Annotation.Argument.Value x = argument.x();
        x.getClass();
        return new Pair(b, g(type, x, ap2Var));
    }

    public final m00 e(q00 q00Var) {
        return FindClassInModuleKt.c(this.a, q00Var, this.b);
    }

    public final k50 f(fx1 fx1Var, ProtoBuf$Annotation.Argument.Value value, ap2 ap2Var) {
        fx1Var.getClass();
        value.getClass();
        ap2Var.getClass();
        Boolean d = e31.O.d(value.O());
        d.getClass();
        boolean booleanValue = d.booleanValue();
        ProtoBuf$Annotation.Argument.Value.Type S = value.S();
        switch (S == null ? -1 : a.a[S.ordinal()]) {
            case 1:
                byte Q = (byte) value.Q();
                return booleanValue ? new zb4(Q) : new um(Q);
            case 2:
                return new gy((char) value.Q());
            case 3:
                short Q2 = (short) value.Q();
                return booleanValue ? new kc4(Q2) : new ap3(Q2);
            case 4:
                int Q3 = (int) value.Q();
                return booleanValue ? new bc4(Q3) : new qp1(Q3);
            case 5:
                long Q4 = value.Q();
                return booleanValue ? new cc4(Q4) : new x82(Q4);
            case 6:
                return new t31(value.P());
            case 7:
                return new vn0(value.M());
            case 8:
                return new uj(value.Q() != 0);
            case 9:
                return new tv3(ap2Var.getString(value.R()));
            case 10:
                return new sv1(cp2.a(ap2Var, value.K()), value.G());
            case 11:
                return new iu0(cp2.a(ap2Var, value.K()), cp2.b(ap2Var, value.N()));
            case 12:
                ProtoBuf$Annotation F = value.F();
                F.getClass();
                return new i8(a(F, ap2Var));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.a;
                List<ProtoBuf$Annotation.Argument.Value> J = value.J();
                J.getClass();
                ArrayList arrayList = new ArrayList(t20.v(J, 10));
                for (ProtoBuf$Annotation.Argument.Value value2 : J) {
                    zp3 i = c().i();
                    i.getClass();
                    value2.getClass();
                    arrayList.add(f(i, value2, ap2Var));
                }
                return constantValueFactory.a(arrayList, fx1Var);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.S() + " (expected " + fx1Var + ')').toString());
        }
    }

    public final k50 g(fx1 fx1Var, ProtoBuf$Annotation.Argument.Value value, ap2 ap2Var) {
        k50 f = f(fx1Var, value, ap2Var);
        if (!b(f, fx1Var, value)) {
            f = null;
        }
        if (f != null) {
            return f;
        }
        return yu0.b.a("Unexpected argument value: actual type " + value.S() + " != expected type " + fx1Var);
    }
}
