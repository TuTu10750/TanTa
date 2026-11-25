package defpackage;

import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: /tmp/classes2.dex */
public abstract class sa0 extends b8 implements ra0 {
    public final zo2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sa0(j8 j8Var, zo2 zo2Var) {
        super(j8Var);
        if (j8Var == null) {
            H(0);
        }
        if (zo2Var == null) {
            H(1);
        }
        this.b = zo2Var;
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i != 2 && i != 3) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (i != 5 && i != 6) {
                objArr[2] = "<init>";
            }
        }
        String format = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static String z0(ra0 ra0Var) {
        if (ra0Var == null) {
            H(4);
        }
        try {
            return DescriptorRenderer.j.q(ra0Var) + "[" + ra0Var.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(ra0Var)) + "]";
        } catch (Throwable unused) {
            return ra0Var.getClass().getSimpleName() + " " + ra0Var.getName();
        }
    }

    public ra0 a() {
        return this;
    }

    @Override // defpackage.ep2
    public zo2 getName() {
        zo2 zo2Var = this.b;
        if (zo2Var == null) {
            H(2);
        }
        return zo2Var;
    }

    public String toString() {
        return z0(this);
    }
}
