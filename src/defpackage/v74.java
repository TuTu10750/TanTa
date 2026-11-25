package defpackage;

/* loaded from: /tmp/classes2.dex */
public class v74 extends z1 {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v74(fx1 fx1Var) {
        this(fx1Var, null);
        if (fx1Var == null) {
            b(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v74(fx1 fx1Var, bc3 bc3Var) {
        super(fx1Var, bc3Var);
        if (fx1Var == null) {
            b(1);
        }
    }

    private static /* synthetic */ void b(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        return "{Transient} : " + getType();
    }
}
