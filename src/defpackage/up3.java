package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;

/* loaded from: /tmp/classes2.dex */
public class up3 extends a implements g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public up3(ra0 ra0Var, g gVar, j8 j8Var, zo2 zo2Var, CallableMemberDescriptor.Kind kind, xr3 xr3Var) {
        super(ra0Var, gVar, j8Var, zo2Var, kind, xr3Var);
        if (ra0Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (zo2Var == null) {
            H(2);
        }
        if (kind == null) {
            H(3);
        }
        if (xr3Var == null) {
            H(4);
        }
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 13 || i == 18 || i == 23 || i == 24 || i == 29 || i == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 18 || i == 23 || i == 24 || i == 29 || i == 30) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
            case CrashStatKey.UNEXP_LOW_MEM_TIMES /* 29 */:
            case CrashStatKey.UNEXP_KILLED_TIMES /* 30 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[0] = "contextReceiverParameters";
                break;
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 18 || i == 23) {
            objArr[1] = "initialize";
        } else if (i == 24) {
            objArr[1] = "getOriginal";
        } else if (i == 29) {
            objArr[1] = "copy";
        } else if (i != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
            case CrashStatKey.UNEXP_LOW_MEM_TIMES /* 29 */:
            case CrashStatKey.UNEXP_KILLED_TIMES /* 30 */:
                break;
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 13 && i != 18 && i != 23 && i != 24 && i != 29 && i != 30) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static up3 l1(ra0 ra0Var, j8 j8Var, zo2 zo2Var, CallableMemberDescriptor.Kind kind, xr3 xr3Var) {
        if (ra0Var == null) {
            H(5);
        }
        if (j8Var == null) {
            H(6);
        }
        if (zo2Var == null) {
            H(7);
        }
        if (kind == null) {
            H(8);
        }
        if (xr3Var == null) {
            H(9);
        }
        return new up3(ra0Var, null, j8Var, zo2Var, kind, xr3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public a L0(ra0 ra0Var, e eVar, CallableMemberDescriptor.Kind kind, zo2 zo2Var, j8 j8Var, xr3 xr3Var) {
        if (ra0Var == null) {
            H(25);
        }
        if (kind == null) {
            H(26);
        }
        if (j8Var == null) {
            H(27);
        }
        if (xr3Var == null) {
            H(28);
        }
        g gVar = (g) eVar;
        if (zo2Var == null) {
            zo2Var = getName();
        }
        return new up3(ra0Var, gVar, j8Var, zo2Var, kind, xr3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: k1 */
    public g M(ra0 ra0Var, Modality modality, pk0 pk0Var, CallableMemberDescriptor.Kind kind, boolean z) {
        g gVar = (g) super.K0(ra0Var, modality, pk0Var, kind, z);
        if (gVar == null) {
            H(29);
        }
        return gVar;
    }

    @Override // defpackage.ua0, defpackage.sa0, defpackage.ra0, defpackage.z00
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public g a() {
        g gVar = (g) super.a();
        if (gVar == null) {
            H(24);
        }
        return gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public up3 R0(zb3 zb3Var, zb3 zb3Var2, List list, List list2, List list3, fx1 fx1Var, Modality modality, pk0 pk0Var) {
        if (list == null) {
            H(14);
        }
        if (list2 == null) {
            H(15);
        }
        if (list3 == null) {
            H(16);
        }
        if (pk0Var == null) {
            H(17);
        }
        up3 o1 = o1(zb3Var, zb3Var2, list, list2, list3, fx1Var, modality, pk0Var, null);
        if (o1 == null) {
            H(18);
        }
        return o1;
    }

    public up3 o1(zb3 zb3Var, zb3 zb3Var2, List list, List list2, List list3, fx1 fx1Var, Modality modality, pk0 pk0Var, Map map) {
        if (list == null) {
            H(19);
        }
        if (list2 == null) {
            H(20);
        }
        if (list3 == null) {
            H(21);
        }
        if (pk0Var == null) {
            H(22);
        }
        super.R0(zb3Var, zb3Var2, list, list2, list3, fx1Var, modality, pk0Var);
        if (map != null && !map.isEmpty()) {
            this.D = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public e.a v() {
        e.a v = super.v();
        if (v == null) {
            H(30);
        }
        return v;
    }
}
