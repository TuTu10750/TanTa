package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class b8 implements a8 {
    public final j8 a;

    public b8(j8 j8Var) {
        if (j8Var == null) {
            H(0);
        }
        this.a = j8Var;
    }

    private static /* synthetic */ void H(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(format);
        }
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        j8 j8Var = this.a;
        if (j8Var == null) {
            H(1);
        }
        return j8Var;
    }
}
