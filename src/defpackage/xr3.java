package defpackage;

/* loaded from: /tmp/classes2.dex */
public interface xr3 {
    public static final xr3 a = new a();

    /* loaded from: /tmp/classes2.dex */
    public static class a implements xr3 {
        public static /* synthetic */ void d(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // defpackage.xr3
        public yr3 a() {
            yr3 yr3Var = yr3.a;
            if (yr3Var == null) {
                d(0);
            }
            return yr3Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    yr3 a();
}
