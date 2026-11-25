package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class z1 implements bc3 {
    public final fx1 a;
    public final bc3 b;

    public z1(fx1 fx1Var, bc3 bc3Var) {
        if (fx1Var == null) {
            b(0);
        }
        this.a = fx1Var;
        this.b = bc3Var == null ? this : bc3Var;
    }

    private static /* synthetic */ void b(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.bc3
    public fx1 getType() {
        fx1 fx1Var = this.a;
        if (fx1Var == null) {
            b(1);
        }
        return fx1Var;
    }
}
