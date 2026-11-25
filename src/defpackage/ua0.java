package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class ua0 extends sa0 implements ta0 {
    public final ra0 c;
    public final xr3 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ua0(ra0 ra0Var, j8 j8Var, zo2 zo2Var, xr3 xr3Var) {
        super(j8Var, zo2Var);
        if (ra0Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (zo2Var == null) {
            H(2);
        }
        if (xr3Var == null) {
            H(3);
        }
        this.c = ra0Var;
        this.d = xr3Var;
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 4 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 4) {
            objArr[1] = "getOriginal";
        } else if (i == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5 && i != 6) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.sa0, defpackage.ra0, defpackage.z00
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public xa0 a() {
        xa0 xa0Var = (xa0) super.a();
        if (xa0Var == null) {
            H(4);
        }
        return xa0Var;
    }

    public ra0 b() {
        ra0 ra0Var = this.c;
        if (ra0Var == null) {
            H(5);
        }
        return ra0Var;
    }

    public xr3 j() {
        xr3 xr3Var = this.d;
        if (xr3Var == null) {
            H(6);
        }
        return xr3Var;
    }
}
