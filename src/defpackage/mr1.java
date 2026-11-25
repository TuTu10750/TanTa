package defpackage;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: /tmp/classes2.dex */
public class mr1 extends j00 implements kr1 {
    public Boolean F;
    public Boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mr1(m00 m00Var, mr1 mr1Var, j8 j8Var, boolean z, CallableMemberDescriptor.Kind kind, xr3 xr3Var) {
        super(m00Var, mr1Var, j8Var, z, kind, xr3Var);
        if (m00Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (kind == null) {
            H(2);
        }
        if (xr3Var == null) {
            H(3);
        }
        this.F = null;
        this.G = null;
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static mr1 t1(m00 m00Var, j8 j8Var, boolean z, xr3 xr3Var) {
        if (m00Var == null) {
            H(4);
        }
        if (j8Var == null) {
            H(5);
        }
        if (xr3Var == null) {
            H(6);
        }
        return new mr1(m00Var, null, j8Var, z, CallableMemberDescriptor.Kind.DECLARATION, xr3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean F() {
        return this.G.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public boolean Q0() {
        return this.F.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public void Y0(boolean z) {
        this.F = Boolean.valueOf(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public void Z0(boolean z) {
        this.G = Boolean.valueOf(z);
    }

    public mr1 s1(m00 m00Var, mr1 mr1Var, CallableMemberDescriptor.Kind kind, xr3 xr3Var, j8 j8Var) {
        if (m00Var == null) {
            H(12);
        }
        if (kind == null) {
            H(13);
        }
        if (xr3Var == null) {
            H(14);
        }
        if (j8Var == null) {
            H(15);
        }
        return new mr1(m00Var, mr1Var, j8Var, this.E, kind, xr3Var);
    }

    @Override // defpackage.j00
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public mr1 L0(ra0 ra0Var, e eVar, CallableMemberDescriptor.Kind kind, zo2 zo2Var, j8 j8Var, xr3 xr3Var) {
        if (ra0Var == null) {
            H(7);
        }
        if (kind == null) {
            H(8);
        }
        if (j8Var == null) {
            H(9);
        }
        if (xr3Var == null) {
            H(10);
        }
        if (kind == CallableMemberDescriptor.Kind.DECLARATION || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            mr1 s1 = s1((m00) ra0Var, (mr1) eVar, kind, xr3Var, j8Var);
            s1.Y0(Q0());
            s1.Z0(F());
            return s1;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + ra0Var + "\nkind: " + kind);
    }

    @Override // defpackage.kr1
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public mr1 L(fx1 fx1Var, List list, fx1 fx1Var2, Pair pair) {
        if (list == null) {
            H(16);
        }
        if (fx1Var2 == null) {
            H(17);
        }
        mr1 L0 = L0(b(), null, i(), null, getAnnotations(), j());
        L0.R0(fx1Var == null ? null : fk0.i(L0, fx1Var, j8.a0.b()), e0(), s20.k(), getTypeParameters(), jf4.a(list, h(), L0), fx1Var2, l(), getVisibility());
        if (pair != null) {
            L0.U0((a.InterfaceC0097a) pair.c(), pair.d());
        }
        return L0;
    }
}
