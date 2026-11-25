package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h;

/* loaded from: /tmp/classes2.dex */
public class ss1 extends p33 implements kr1 {
    public final boolean C;
    public final Pair D;
    public fx1 E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ss1(ra0 ra0Var, j8 j8Var, Modality modality, pk0 pk0Var, boolean z, zo2 zo2Var, xr3 xr3Var, o33 o33Var, CallableMemberDescriptor.Kind kind, boolean z2, Pair pair) {
        super(ra0Var, o33Var, j8Var, modality, pk0Var, z, zo2Var, kind, xr3Var, false, false, false, false, false, false);
        if (ra0Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (modality == null) {
            H(2);
        }
        if (pk0Var == null) {
            H(3);
        }
        if (zo2Var == null) {
            H(4);
        }
        if (xr3Var == null) {
            H(5);
        }
        if (kind == null) {
            H(6);
        }
        this.E = null;
        this.C = z2;
        this.D = pair;
    }

    private static /* synthetic */ void H(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[0] = "enhancedReturnType";
                break;
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[0] = "inType";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[2] = "enhance";
                break;
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[2] = "setInType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(format);
        }
    }

    public static ss1 f1(ra0 ra0Var, j8 j8Var, Modality modality, pk0 pk0Var, boolean z, zo2 zo2Var, xr3 xr3Var, boolean z2) {
        if (ra0Var == null) {
            H(7);
        }
        if (j8Var == null) {
            H(8);
        }
        if (modality == null) {
            H(9);
        }
        if (pk0Var == null) {
            H(10);
        }
        if (zo2Var == null) {
            H(11);
        }
        if (xr3Var == null) {
            H(12);
        }
        return new ss1(ra0Var, j8Var, modality, pk0Var, z, zo2Var, xr3Var, null, CallableMemberDescriptor.Kind.DECLARATION, z2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean F() {
        return false;
    }

    @Override // defpackage.kr1
    public kr1 L(fx1 fx1Var, List list, fx1 fx1Var2, Pair pair) {
        r33 r33Var;
        t33 t33Var;
        if (list == null) {
            H(19);
        }
        if (fx1Var2 == null) {
            H(20);
        }
        o33 a = a() == this ? null : a();
        ss1 ss1Var = new ss1(b(), getAnnotations(), l(), getVisibility(), i0(), getName(), j(), a, i(), this.C, pair);
        r33 f = f();
        if (f != null) {
            r33 r33Var2 = new r33(ss1Var, f.getAnnotations(), f.l(), f.getVisibility(), f.T(), f.isExternal(), f.isInline(), i(), a == null ? null : a.f(), f.j());
            r33Var2.M0(f.d0());
            r33Var2.P0(fx1Var2);
            r33Var = r33Var2;
        } else {
            r33Var = null;
        }
        s33 g = g();
        if (g != null) {
            t33Var = new t33(ss1Var, g.getAnnotations(), g.l(), g.getVisibility(), g.T(), g.isExternal(), g.isInline(), i(), a == null ? null : a.g(), g.j());
            t33Var.M0(t33Var.d0());
            t33Var.Q0((h) g.h().get(0));
        } else {
            t33Var = null;
        }
        ss1Var.V0(r33Var, t33Var, o0(), l0());
        ss1Var.a1(W0());
        l81 l81Var = this.h;
        if (l81Var != null) {
            ss1Var.K0(this.g, l81Var);
        }
        ss1Var.w0(e());
        ss1Var.b1(fx1Var2, getTypeParameters(), e0(), fx1Var != null ? fk0.i(this, fx1Var, j8.a0.b()) : null, s20.k());
        return ss1Var;
    }

    @Override // defpackage.p33
    public p33 P0(ra0 ra0Var, Modality modality, pk0 pk0Var, o33 o33Var, CallableMemberDescriptor.Kind kind, zo2 zo2Var, xr3 xr3Var) {
        if (ra0Var == null) {
            H(13);
        }
        if (modality == null) {
            H(14);
        }
        if (pk0Var == null) {
            H(15);
        }
        if (kind == null) {
            H(16);
        }
        if (zo2Var == null) {
            H(17);
        }
        if (xr3Var == null) {
            H(18);
        }
        return new ss1(ra0Var, getAnnotations(), modality, pk0Var, i0(), zo2Var, xr3Var, o33Var, kind, this.C, this.D);
    }

    @Override // defpackage.p33
    public void Z0(fx1 fx1Var) {
        if (fx1Var == null) {
            H(22);
        }
        this.E = fx1Var;
    }

    @Override // defpackage.p33, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Object h0(a.InterfaceC0097a interfaceC0097a) {
        Pair pair = this.D;
        if (pair == null || !((a.InterfaceC0097a) pair.c()).equals(interfaceC0097a)) {
            return null;
        }
        return this.D.d();
    }

    @Override // defpackage.p33, defpackage.rf4
    public boolean z() {
        fx1 type = getType();
        if (this.C && f50.a(type)) {
            return !ia4.i(type) || d.v0(type);
        }
        return false;
    }
}
