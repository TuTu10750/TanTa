package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import com.uc.crashsdk.export.ExitType;
import com.zzhoujay.richtext.BuildConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.n;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public abstract class lk0 {
    public static final r51 a = new r51("kotlin.jvm.JvmName");

    public static boolean A(ra0 ra0Var) {
        return D(ra0Var, ClassKind.ENUM_CLASS);
    }

    public static boolean B(ra0 ra0Var) {
        if (ra0Var == null) {
            a(36);
        }
        return D(ra0Var, ClassKind.ENUM_ENTRY);
    }

    public static boolean C(ra0 ra0Var) {
        return D(ra0Var, ClassKind.INTERFACE);
    }

    public static boolean D(ra0 ra0Var, ClassKind classKind) {
        if (classKind == null) {
            a(37);
        }
        return (ra0Var instanceof m00) && ((m00) ra0Var).i() == classKind;
    }

    public static boolean E(ra0 ra0Var) {
        if (ra0Var == null) {
            a(1);
        }
        while (ra0Var != null) {
            if (u(ra0Var) || y(ra0Var)) {
                return true;
            }
            ra0Var = ra0Var.b();
        }
        return false;
    }

    public static boolean F(fx1 fx1Var, ra0 ra0Var) {
        if (fx1Var == null) {
            a(30);
        }
        if (ra0Var == null) {
            a(31);
        }
        z00 v = fx1Var.N0().v();
        if (v == null) {
            return false;
        }
        ra0 a2 = v.a();
        return (a2 instanceof z00) && (ra0Var instanceof z00) && ((z00) ra0Var).k().equals(((z00) a2).k());
    }

    public static boolean G(ra0 ra0Var) {
        return (D(ra0Var, ClassKind.CLASS) || D(ra0Var, ClassKind.INTERFACE)) && ((m00) ra0Var).l() == Modality.SEALED;
    }

    public static boolean H(m00 m00Var, m00 m00Var2) {
        if (m00Var == null) {
            a(28);
        }
        if (m00Var2 == null) {
            a(29);
        }
        return I(m00Var.u(), m00Var2.a());
    }

    public static boolean I(fx1 fx1Var, ra0 ra0Var) {
        if (fx1Var == null) {
            a(32);
        }
        if (ra0Var == null) {
            a(33);
        }
        if (F(fx1Var, ra0Var)) {
            return true;
        }
        Iterator it = fx1Var.N0().c().iterator();
        while (it.hasNext()) {
            if (I((fx1) it.next(), ra0Var)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(ra0 ra0Var) {
        return ra0Var != null && (ra0Var.b() instanceof kv2);
    }

    public static boolean K(rf4 rf4Var, fx1 fx1Var) {
        if (rf4Var == null) {
            a(66);
        }
        if (fx1Var == null) {
            a(67);
        }
        if (rf4Var.i0() || gx1.a(fx1Var)) {
            return false;
        }
        if (n.b(fx1Var)) {
            return true;
        }
        d j = DescriptorUtilsKt.j(rf4Var);
        if (!d.s0(fx1Var)) {
            b bVar = b.a;
            if (!bVar.b(j.W(), fx1Var) && !bVar.b(j.K().u(), fx1Var) && !bVar.b(j.i(), fx1Var) && !dd4.d(fx1Var)) {
                return false;
            }
        }
        return true;
    }

    public static CallableMemberDescriptor L(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(59);
        }
        while (callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            Collection e = callableMemberDescriptor.e();
            if (e.isEmpty()) {
                hu1.a("Fake override should have at least one overridden descriptor: ", callableMemberDescriptor);
                return null;
            }
            callableMemberDescriptor = (CallableMemberDescriptor) e.iterator().next();
        }
        return callableMemberDescriptor;
    }

    public static ya0 M(ya0 ya0Var) {
        if (ya0Var == null) {
            a(64);
        }
        if (ya0Var instanceof CallableMemberDescriptor) {
            return L((CallableMemberDescriptor) ya0Var);
        }
        if (ya0Var == null) {
            a(65);
        }
        return ya0Var;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.ANR_FG_TIMES /* 40 */:
            case CrashStatKey.ANR_FG_CRASH_TIMES /* 42 */:
            case CrashStatKey.ANR_BG_CRASH_TIMES /* 43 */:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case BuildConfig.VERSION_CODE /* 65 */:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.ANR_FG_TIMES /* 40 */:
            case CrashStatKey.ANR_FG_CRASH_TIMES /* 42 */:
            case CrashStatKey.ANR_BG_CRASH_TIMES /* 43 */:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case BuildConfig.VERSION_CODE /* 65 */:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 64:
            case 82:
            case 95:
            case ExitType.UNEXP_FOREGROUND_CRASH /* 97 */:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.ANR_FG_TIMES /* 40 */:
            case CrashStatKey.ANR_FG_CRASH_TIMES /* 42 */:
            case CrashStatKey.ANR_BG_CRASH_TIMES /* 43 */:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case BuildConfig.VERSION_CODE /* 65 */:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[0] = "aClass";
                break;
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[0] = "kotlinType";
                break;
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[0] = "declarationDescriptor";
                break;
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
                objArr[0] = "subClass";
                break;
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
            case CrashStatKey.UNEXP_LOW_MEM_TIMES /* 29 */:
            case 33:
                objArr[0] = "superClass";
                break;
            case CrashStatKey.UNEXP_KILLED_TIMES /* 30 */:
            case 32:
            case 45:
            case 67:
                objArr[0] = "type";
                break;
            case CrashStatKey.UNEXP_EXIT_TIMES /* 31 */:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case CrashStatKey.ANR_BG_TIMES /* 41 */:
            case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
            case 48:
            case 54:
            case 68:
            case 69:
            case 70:
            case IjkMediaMeta.FF_PROFILE_H264_MAIN /* 77 */:
            case 78:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                objArr[0] = "variable";
                break;
            case 71:
                objArr[0] = "f";
                break;
            case 73:
                objArr[0] = "current";
                break;
            case 74:
                objArr[0] = "result";
                break;
            case 75:
                objArr[0] = "memberDescriptor";
                break;
            case 79:
            case 80:
            case 81:
                objArr[0] = "annotated";
                break;
            case 85:
            case 87:
            case 90:
            case 92:
                objArr[0] = "scope";
                break;
            case IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
            case 91:
            case 93:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[1] = "getContainingModule";
                break;
            case CrashStatKey.ANR_FG_TIMES /* 40 */:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case CrashStatKey.ANR_FG_CRASH_TIMES /* 42 */:
            case CrashStatKey.ANR_BG_CRASH_TIMES /* 43 */:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
            case 63:
                objArr[1] = "unwrapSubstitutionOverride";
                break;
            case BuildConfig.VERSION_CODE /* 65 */:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 72:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 76:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 83:
            case 84:
                objArr[1] = "getContainingSourceFile";
                break;
            case 86:
                objArr[1] = "getAllDescriptors";
                break;
            case 89:
                objArr[1] = "getFunctionByName";
                break;
            case 94:
                objArr[1] = "getPropertyByName";
                break;
            case 96:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.ANR_FG_TIMES /* 40 */:
            case CrashStatKey.ANR_FG_CRASH_TIMES /* 42 */:
            case CrashStatKey.ANR_BG_CRASH_TIMES /* 43 */:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case BuildConfig.VERSION_CODE /* 65 */:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[2] = "getParentOfType";
                break;
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[2] = "getContainingModule";
                break;
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
                objArr[2] = "getContainingClass";
                break;
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[2] = "isAncestor";
                break;
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
                objArr[2] = "isDirectSubclass";
                break;
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
            case CrashStatKey.UNEXP_LOW_MEM_TIMES /* 29 */:
                objArr[2] = "isSubclass";
                break;
            case CrashStatKey.UNEXP_KILLED_TIMES /* 30 */:
            case CrashStatKey.UNEXP_EXIT_TIMES /* 31 */:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case CrashStatKey.ANR_BG_TIMES /* 41 */:
                objArr[2] = "getSuperClassType";
                break;
            case IjkMediaMeta.FF_PROFILE_H264_CAVLC_444 /* 44 */:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapSubstitutionOverride";
                break;
            case 64:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
            case 67:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 68:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 69:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 70:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 71:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 73:
            case 74:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 75:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case IjkMediaMeta.FF_PROFILE_H264_MAIN /* 77 */:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 78:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 79:
                objArr[2] = "getJvmName";
                break;
            case 80:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 81:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 82:
                objArr[2] = "getContainingSourceFile";
                break;
            case 85:
                objArr[2] = "getAllDescriptors";
                break;
            case 87:
            case IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                objArr[2] = "getFunctionByName";
                break;
            case 90:
            case 91:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 92:
            case 93:
                objArr[2] = "getPropertyByName";
                break;
            case 95:
                objArr[2] = "getDirectMember";
                break;
            case ExitType.UNEXP_FOREGROUND_CRASH /* 97 */:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.ANR_FG_TIMES /* 40 */:
            case CrashStatKey.ANR_FG_CRASH_TIMES /* 42 */:
            case CrashStatKey.ANR_BG_CRASH_TIMES /* 43 */:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case BuildConfig.VERSION_CODE /* 65 */:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(ra0 ra0Var, ra0 ra0Var2) {
        if (ra0Var == null) {
            a(16);
        }
        if (ra0Var2 == null) {
            a(17);
        }
        return g(ra0Var).equals(g(ra0Var2));
    }

    public static void c(a aVar, Set set) {
        if (aVar == null) {
            a(73);
        }
        if (set == null) {
            a(74);
        }
        if (set.contains(aVar)) {
            return;
        }
        Iterator it = aVar.a().e().iterator();
        while (it.hasNext()) {
            a a2 = ((a) it.next()).a();
            c(a2, set);
            set.add(a2);
        }
    }

    public static Set d(a aVar) {
        if (aVar == null) {
            a(71);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(aVar.a(), linkedHashSet);
        return linkedHashSet;
    }

    public static m00 e(fx1 fx1Var) {
        if (fx1Var == null) {
            a(45);
        }
        return f(fx1Var.N0());
    }

    public static m00 f(ea4 ea4Var) {
        if (ea4Var == null) {
            a(46);
        }
        m00 m00Var = (m00) ea4Var.v();
        if (m00Var == null) {
            a(47);
        }
        return m00Var;
    }

    public static mm2 g(ra0 ra0Var) {
        if (ra0Var == null) {
            a(21);
        }
        mm2 h = h(ra0Var);
        if (h == null) {
            a(22);
        }
        return h;
    }

    public static mm2 h(ra0 ra0Var) {
        if (ra0Var == null) {
            a(23);
        }
        while (ra0Var != null) {
            if (ra0Var instanceof mm2) {
                return (mm2) ra0Var;
            }
            if (ra0Var instanceof sv2) {
                return ((sv2) ra0Var).u0();
            }
            ra0Var = ra0Var.b();
        }
        return null;
    }

    public static mm2 i(fx1 fx1Var) {
        if (fx1Var == null) {
            a(20);
        }
        z00 v = fx1Var.N0().v();
        if (v == null) {
            return null;
        }
        return h(v);
    }

    public static yr3 j(ra0 ra0Var) {
        if (ra0Var == null) {
            a(82);
        }
        if (ra0Var instanceof s33) {
            ra0Var = ((s33) ra0Var).B0();
        }
        if (ra0Var instanceof xa0) {
            yr3 a2 = ((xa0) ra0Var).j().a();
            if (a2 == null) {
                a(83);
            }
            return a2;
        }
        yr3 yr3Var = yr3.a;
        if (yr3Var == null) {
            a(84);
        }
        return yr3Var;
    }

    public static pk0 k(m00 m00Var, boolean z) {
        if (m00Var == null) {
            a(48);
        }
        ClassKind i = m00Var.i();
        if (i == ClassKind.ENUM_CLASS || i.b()) {
            pk0 pk0Var = ok0.a;
            if (pk0Var == null) {
                a(49);
            }
            return pk0Var;
        }
        if (G(m00Var)) {
            if (z) {
                pk0 pk0Var2 = ok0.c;
                if (pk0Var2 == null) {
                    a(50);
                }
                return pk0Var2;
            }
            pk0 pk0Var3 = ok0.a;
            if (pk0Var3 == null) {
                a(51);
            }
            return pk0Var3;
        }
        if (u(m00Var)) {
            pk0 pk0Var4 = ok0.l;
            if (pk0Var4 == null) {
                a(52);
            }
            return pk0Var4;
        }
        pk0 pk0Var5 = ok0.e;
        if (pk0Var5 == null) {
            a(53);
        }
        return pk0Var5;
    }

    public static zb3 l(ra0 ra0Var) {
        if (ra0Var == null) {
            a(0);
        }
        if (ra0Var instanceof m00) {
            return ((m00) ra0Var).J0();
        }
        return null;
    }

    public static s51 m(ra0 ra0Var) {
        if (ra0Var == null) {
            a(2);
        }
        r51 o = o(ra0Var);
        return o != null ? o.j() : p(ra0Var);
    }

    public static r51 n(ra0 ra0Var) {
        if (ra0Var == null) {
            a(3);
        }
        r51 o = o(ra0Var);
        if (o == null) {
            o = p(ra0Var).l();
        }
        if (o == null) {
            a(4);
        }
        return o;
    }

    public static r51 o(ra0 ra0Var) {
        if (ra0Var == null) {
            a(5);
        }
        if ((ra0Var instanceof mm2) || xu0.m(ra0Var)) {
            return r51.c;
        }
        if (ra0Var instanceof sv2) {
            return ((sv2) ra0Var).d();
        }
        if (ra0Var instanceof kv2) {
            return ((kv2) ra0Var).d();
        }
        return null;
    }

    public static s51 p(ra0 ra0Var) {
        if (ra0Var == null) {
            a(6);
        }
        s51 c = m(ra0Var.b()).c(ra0Var.getName());
        if (c == null) {
            a(7);
        }
        return c;
    }

    public static ra0 q(ra0 ra0Var, Class cls) {
        if (cls == null) {
            a(18);
        }
        return r(ra0Var, cls, true);
    }

    public static ra0 r(ra0 ra0Var, Class cls, boolean z) {
        if (cls == null) {
            a(19);
        }
        if (ra0Var == null) {
            return null;
        }
        if (z) {
            ra0Var = ra0Var.b();
        }
        while (ra0Var != null) {
            if (cls.isInstance(ra0Var)) {
                return ra0Var;
            }
            ra0Var = ra0Var.b();
        }
        return null;
    }

    public static m00 s(m00 m00Var) {
        if (m00Var == null) {
            a(44);
        }
        Iterator it = m00Var.k().c().iterator();
        while (it.hasNext()) {
            m00 e = e((fx1) it.next());
            if (e.i() != ClassKind.INTERFACE) {
                return e;
            }
        }
        return null;
    }

    public static boolean t(ra0 ra0Var) {
        return D(ra0Var, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean u(ra0 ra0Var) {
        if (ra0Var == null) {
            a(34);
        }
        return v(ra0Var) && ra0Var.getName().equals(ls3.b);
    }

    public static boolean v(ra0 ra0Var) {
        return D(ra0Var, ClassKind.CLASS);
    }

    public static boolean w(ra0 ra0Var) {
        return v(ra0Var) || A(ra0Var);
    }

    public static boolean x(ra0 ra0Var) {
        return D(ra0Var, ClassKind.OBJECT) && ((m00) ra0Var).y();
    }

    public static boolean y(ra0 ra0Var) {
        return (ra0Var instanceof ya0) && ((ya0) ra0Var).getVisibility() == ok0.f;
    }

    public static boolean z(m00 m00Var, m00 m00Var2) {
        if (m00Var == null) {
            a(26);
        }
        if (m00Var2 == null) {
            a(27);
        }
        Iterator it = m00Var.k().c().iterator();
        while (it.hasNext()) {
            if (F((fx1) it.next(), m00Var2.a())) {
                return true;
            }
        }
        return false;
    }
}
