package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class n00 extends g1 {
    public final ra0 f;
    public final xr3 g;
    public final boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n00(lu3 lu3Var, ra0 ra0Var, zo2 zo2Var, xr3 xr3Var, boolean z) {
        super(lu3Var, zo2Var);
        if (lu3Var == null) {
            A0(0);
        }
        if (ra0Var == null) {
            A0(1);
        }
        if (zo2Var == null) {
            A0(2);
        }
        if (xr3Var == null) {
            A0(3);
        }
        this.f = ra0Var;
        this.g = xr3Var;
        this.h = z;
    }

    private static /* synthetic */ void A0(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.m00, defpackage.ta0
    public ra0 b() {
        ra0 ra0Var = this.f;
        if (ra0Var == null) {
            A0(4);
        }
        return ra0Var;
    }

    public boolean isExternal() {
        return this.h;
    }

    @Override // defpackage.xa0
    public xr3 j() {
        xr3 xr3Var = this.g;
        if (xr3Var == null) {
            A0(5);
        }
        return xr3Var;
    }
}
