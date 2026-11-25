package defpackage;

/* loaded from: /tmp/classes2.dex */
public class ac3 extends y1 {
    public final ra0 c;
    public bc3 d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ac3(ra0 ra0Var, bc3 bc3Var, j8 j8Var) {
        this(ra0Var, bc3Var, j8Var, ls3.i);
        if (ra0Var == null) {
            H(0);
        }
        if (bc3Var == null) {
            H(1);
        }
        if (j8Var == null) {
            H(2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac3(ra0 ra0Var, bc3 bc3Var, j8 j8Var, zo2 zo2Var) {
        super(j8Var, zo2Var);
        if (ra0Var == null) {
            H(3);
        }
        if (bc3Var == null) {
            H(4);
        }
        if (j8Var == null) {
            H(5);
        }
        if (zo2Var == null) {
            H(6);
        }
        this.c = ra0Var;
        this.d = bc3Var;
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = "name";
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i == 7) {
            objArr[1] = "getValue";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 7 && i != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.ra0, defpackage.qf4, defpackage.ta0
    public ra0 b() {
        ra0 ra0Var = this.c;
        if (ra0Var == null) {
            H(8);
        }
        return ra0Var;
    }

    @Override // defpackage.zb3
    public bc3 getValue() {
        bc3 bc3Var = this.d;
        if (bc3Var == null) {
            H(7);
        }
        return bc3Var;
    }
}
