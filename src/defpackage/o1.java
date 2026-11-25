package defpackage;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public abstract class o1 extends g2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(lu3 lu3Var, ra0 ra0Var, j8 j8Var, zo2 zo2Var, Variance variance, boolean z, int i, xr3 xr3Var, nx3 nx3Var) {
        super(lu3Var, ra0Var, j8Var, zo2Var, variance, z, i, xr3Var, nx3Var);
        if (lu3Var == null) {
            H(0);
        }
        if (ra0Var == null) {
            H(1);
        }
        if (j8Var == null) {
            H(2);
        }
        if (zo2Var == null) {
            H(3);
        }
        if (variance == null) {
            H(4);
        }
        if (xr3Var == null) {
            H(5);
        }
        if (nx3Var == null) {
            H(6);
        }
    }

    public static /* synthetic */ void H(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // defpackage.sa0
    public String toString() {
        String str = "";
        String str2 = E() ? "reified " : "";
        if (p() != Variance.INVARIANT) {
            str = p() + " ";
        }
        return String.format("%s%s%s", str2, str, getName());
    }
}
