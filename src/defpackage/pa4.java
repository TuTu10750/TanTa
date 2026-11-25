package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import defpackage.nx3;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public class pa4 extends g2 {
    public final n81 k;
    public final List l;
    public boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pa4(ra0 ra0Var, j8 j8Var, boolean z, Variance variance, zo2 zo2Var, int i, xr3 xr3Var, n81 n81Var, nx3 nx3Var, lu3 lu3Var) {
        super(lu3Var, ra0Var, j8Var, zo2Var, variance, z, i, xr3Var, nx3Var);
        if (ra0Var == null) {
            H(19);
        }
        if (j8Var == null) {
            H(20);
        }
        if (variance == null) {
            H(21);
        }
        if (zo2Var == null) {
            H(22);
        }
        if (xr3Var == null) {
            H(23);
        }
        if (nx3Var == null) {
            H(24);
        }
        if (lu3Var == null) {
            H(25);
        }
        this.l = new ArrayList(1);
        this.m = false;
        this.k = n81Var;
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[0] = "storageManager";
                break;
            case 5:
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
                objArr[0] = "bound";
                break;
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[2] = "<init>";
                break;
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
                objArr[2] = "addUpperBound";
                break;
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static pa4 P0(ra0 ra0Var, j8 j8Var, boolean z, Variance variance, zo2 zo2Var, int i, xr3 xr3Var, n81 n81Var, nx3 nx3Var, lu3 lu3Var) {
        if (ra0Var == null) {
            H(12);
        }
        if (j8Var == null) {
            H(13);
        }
        if (variance == null) {
            H(14);
        }
        if (zo2Var == null) {
            H(15);
        }
        if (xr3Var == null) {
            H(16);
        }
        if (nx3Var == null) {
            H(17);
        }
        if (lu3Var == null) {
            H(18);
        }
        return new pa4(ra0Var, j8Var, z, variance, zo2Var, i, xr3Var, n81Var, nx3Var, lu3Var);
    }

    public static pa4 Q0(ra0 ra0Var, j8 j8Var, boolean z, Variance variance, zo2 zo2Var, int i, xr3 xr3Var, lu3 lu3Var) {
        if (ra0Var == null) {
            H(6);
        }
        if (j8Var == null) {
            H(7);
        }
        if (variance == null) {
            H(8);
        }
        if (zo2Var == null) {
            H(9);
        }
        if (xr3Var == null) {
            H(10);
        }
        if (lu3Var == null) {
            H(11);
        }
        return P0(ra0Var, j8Var, z, variance, zo2Var, i, xr3Var, null, nx3.a.a, lu3Var);
    }

    public static oa4 R0(ra0 ra0Var, j8 j8Var, boolean z, Variance variance, zo2 zo2Var, int i, lu3 lu3Var) {
        if (ra0Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (variance == null) {
            H(2);
        }
        if (zo2Var == null) {
            H(3);
        }
        if (lu3Var == null) {
            H(4);
        }
        pa4 Q0 = Q0(ra0Var, j8Var, z, variance, zo2Var, i, xr3.a, lu3Var);
        Q0.M0(DescriptorUtilsKt.j(ra0Var).y());
        Q0.V0();
        return Q0;
    }

    @Override // defpackage.g2
    public void K0(fx1 fx1Var) {
        if (fx1Var == null) {
            H(27);
        }
        n81 n81Var = this.k;
        if (n81Var == null) {
            return;
        }
        n81Var.invoke(fx1Var);
    }

    @Override // defpackage.g2
    public List L0() {
        N0();
        List list = this.l;
        if (list == null) {
            H(28);
        }
        return list;
    }

    public void M0(fx1 fx1Var) {
        if (fx1Var == null) {
            H(26);
        }
        O0();
        S0(fx1Var);
    }

    public final void N0() {
        if (this.m) {
            return;
        }
        di3.a("Type parameter descriptor is not initialized: ", U0());
    }

    public final void O0() {
        if (this.m) {
            di3.a("Type parameter descriptor is already initialized: ", U0());
        }
    }

    public final void S0(fx1 fx1Var) {
        if (gx1.a(fx1Var)) {
            return;
        }
        this.l.add(fx1Var);
    }

    public boolean T0() {
        return this.m;
    }

    public final String U0() {
        return getName() + " declared in " + lk0.m(b());
    }

    public void V0() {
        O0();
        this.m = true;
    }
}
