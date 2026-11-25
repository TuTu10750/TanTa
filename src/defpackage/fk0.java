package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import defpackage.j8;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class fk0 {

    /* loaded from: /tmp/classes2.dex */
    public static class a extends j00 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m00 m00Var, xr3 xr3Var, boolean z) {
            super(m00Var, null, j8.a0.b(), true, CallableMemberDescriptor.Kind.DECLARATION, xr3Var);
            if (m00Var == null) {
                H(0);
            }
            if (xr3Var == null) {
                H(1);
            }
            q1(Collections.EMPTY_LIST, lk0.k(m00Var, z));
        }

        private static /* synthetic */ void H(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 23 || i == 25) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case CrashStatKey.UNEXP_EXIT_TIMES /* 31 */:
            case 33:
            case 35:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[0] = "containingClass";
                break;
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[0] = "source";
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
                objArr[0] = "enumClass";
                break;
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
            case CrashStatKey.UNEXP_LOW_MEM_TIMES /* 29 */:
                objArr[0] = "descriptor";
                break;
            case CrashStatKey.UNEXP_KILLED_TIMES /* 30 */:
            case 32:
            case 34:
                objArr[0] = "owner";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[2] = "createGetter";
                break;
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[2] = "createEnumValuesMethod";
                break;
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
                objArr[2] = "createEnumEntriesProperty";
                break;
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
                objArr[2] = "isEnumValuesMethod";
                break;
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case CrashStatKey.UNEXP_LOW_MEM_TIMES /* 29 */:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case CrashStatKey.UNEXP_KILLED_TIMES /* 30 */:
            case CrashStatKey.UNEXP_EXIT_TIMES /* 31 */:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 32:
            case 33:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 34:
            case 35:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 12 && i != 23 && i != 25) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static zb3 b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, fx1 fx1Var, zo2 zo2Var, j8 j8Var, int i) {
        if (aVar == null) {
            a(32);
        }
        if (j8Var == null) {
            a(33);
        }
        if (fx1Var == null) {
            return null;
        }
        return new ac3(aVar, new p60(aVar, fx1Var, zo2Var, null), j8Var, dp2.a(i));
    }

    public static zb3 c(m00 m00Var, fx1 fx1Var, zo2 zo2Var, j8 j8Var, int i) {
        if (m00Var == null) {
            a(34);
        }
        if (j8Var == null) {
            a(35);
        }
        if (fx1Var == null) {
            return null;
        }
        return new ac3(m00Var, new n60(m00Var, fx1Var, zo2Var, null), j8Var, dp2.a(i));
    }

    public static r33 d(o33 o33Var, j8 j8Var) {
        if (o33Var == null) {
            a(13);
        }
        if (j8Var == null) {
            a(14);
        }
        return j(o33Var, j8Var, true, false, false);
    }

    public static t33 e(o33 o33Var, j8 j8Var, j8 j8Var2) {
        if (o33Var == null) {
            a(0);
        }
        if (j8Var == null) {
            a(1);
        }
        if (j8Var2 == null) {
            a(2);
        }
        return n(o33Var, j8Var, j8Var2, true, false, false, o33Var.j());
    }

    public static o33 f(m00 m00Var) {
        if (m00Var == null) {
            a(26);
        }
        m00 a2 = FindClassInModuleKt.a(lk0.g(m00Var), kt3.a.i());
        if (a2 == null) {
            return null;
        }
        j8.a aVar = j8.a0;
        j8 b = aVar.b();
        Modality modality = Modality.FINAL;
        pk0 pk0Var = ok0.e;
        zo2 zo2Var = e.e;
        CallableMemberDescriptor.Kind kind = CallableMemberDescriptor.Kind.SYNTHESIZED;
        p33 O0 = p33.O0(m00Var, b, modality, pk0Var, false, zo2Var, kind, m00Var.j(), false, false, false, false, false, false);
        r33 r33Var = new r33(O0, aVar.b(), modality, pk0Var, false, false, false, kind, null, m00Var.j());
        O0.U0(r33Var, null);
        zp3 h = KotlinTypeFactory.h(j.b.h(), a2.k(), Collections.singletonList(new va4(m00Var.u())), false);
        List list = Collections.EMPTY_LIST;
        O0.b1(h, list, null, null, list);
        r33Var.P0(O0.getReturnType());
        return O0;
    }

    public static g g(m00 m00Var) {
        if (m00Var == null) {
            a(24);
        }
        j8.a aVar = j8.a0;
        up3 l1 = up3.l1(m00Var, aVar.b(), e.f, CallableMemberDescriptor.Kind.SYNTHESIZED, m00Var.j());
        ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(l1, null, 0, aVar.b(), zo2.i("value"), DescriptorUtilsKt.j(m00Var).W(), false, false, false, null, m00Var.j());
        List list = Collections.EMPTY_LIST;
        up3 R0 = l1.R0(null, null, list, list, Collections.singletonList(valueParameterDescriptorImpl), m00Var.u(), Modality.FINAL, ok0.e);
        if (R0 == null) {
            a(25);
        }
        return R0;
    }

    public static g h(m00 m00Var) {
        if (m00Var == null) {
            a(22);
        }
        up3 l1 = up3.l1(m00Var, j8.a0.b(), e.d, CallableMemberDescriptor.Kind.SYNTHESIZED, m00Var.j());
        List list = Collections.EMPTY_LIST;
        up3 R0 = l1.R0(null, null, list, list, list, DescriptorUtilsKt.j(m00Var).l(Variance.INVARIANT, m00Var.u()), Modality.FINAL, ok0.e);
        if (R0 == null) {
            a(23);
        }
        return R0;
    }

    public static zb3 i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, fx1 fx1Var, j8 j8Var) {
        if (aVar == null) {
            a(30);
        }
        if (j8Var == null) {
            a(31);
        }
        if (fx1Var == null) {
            return null;
        }
        return new ac3(aVar, new wy0(aVar, fx1Var, null), j8Var);
    }

    public static r33 j(o33 o33Var, j8 j8Var, boolean z, boolean z2, boolean z3) {
        if (o33Var == null) {
            a(15);
        }
        if (j8Var == null) {
            a(16);
        }
        return k(o33Var, j8Var, z, z2, z3, o33Var.j());
    }

    public static r33 k(o33 o33Var, j8 j8Var, boolean z, boolean z2, boolean z3, xr3 xr3Var) {
        if (o33Var == null) {
            a(17);
        }
        if (j8Var == null) {
            a(18);
        }
        if (xr3Var == null) {
            a(19);
        }
        return new r33(o33Var, j8Var, o33Var.l(), o33Var.getVisibility(), z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, xr3Var);
    }

    public static j00 l(m00 m00Var, xr3 xr3Var) {
        if (m00Var == null) {
            a(20);
        }
        if (xr3Var == null) {
            a(21);
        }
        return new a(m00Var, xr3Var, false);
    }

    public static t33 m(o33 o33Var, j8 j8Var, j8 j8Var2, boolean z, boolean z2, boolean z3, pk0 pk0Var, xr3 xr3Var) {
        if (o33Var == null) {
            a(7);
        }
        if (j8Var == null) {
            a(8);
        }
        if (j8Var2 == null) {
            a(9);
        }
        if (pk0Var == null) {
            a(10);
        }
        if (xr3Var == null) {
            a(11);
        }
        t33 t33Var = new t33(o33Var, j8Var, o33Var.l(), pk0Var, z, z2, z3, CallableMemberDescriptor.Kind.DECLARATION, null, xr3Var);
        t33Var.Q0(t33.O0(t33Var, o33Var.getType(), j8Var2));
        return t33Var;
    }

    public static t33 n(o33 o33Var, j8 j8Var, j8 j8Var2, boolean z, boolean z2, boolean z3, xr3 xr3Var) {
        if (o33Var == null) {
            a(3);
        }
        if (j8Var == null) {
            a(4);
        }
        if (j8Var2 == null) {
            a(5);
        }
        if (xr3Var == null) {
            a(6);
        }
        return m(o33Var, j8Var, j8Var2, z, z2, z3, o33Var.getVisibility(), xr3Var);
    }

    public static boolean o(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(29);
        }
        return eVar.i() == CallableMemberDescriptor.Kind.SYNTHESIZED && lk0.A(eVar.b());
    }

    public static boolean p(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(28);
        }
        return eVar.getName().equals(e.f) && o(eVar);
    }

    public static boolean q(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(27);
        }
        return eVar.getName().equals(e.d) && o(eVar);
    }
}
