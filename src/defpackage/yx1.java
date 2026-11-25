package defpackage;

/* loaded from: /tmp/classes2.dex */
public class yx1 extends y1 {
    public final m00 c;
    public final rn1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx1(m00 m00Var) {
        super(j8.a0.b());
        if (m00Var == null) {
            H(0);
        }
        this.c = m00Var;
        this.d = new rn1(m00Var, null);
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.ra0, defpackage.qf4, defpackage.ta0
    public ra0 b() {
        m00 m00Var = this.c;
        if (m00Var == null) {
            H(2);
        }
        return m00Var;
    }

    @Override // defpackage.zb3
    public bc3 getValue() {
        rn1 rn1Var = this.d;
        if (rn1Var == null) {
            H(1);
        }
        return rn1Var;
    }

    @Override // defpackage.sa0
    public String toString() {
        return "class " + this.c.getName() + "::this";
    }
}
