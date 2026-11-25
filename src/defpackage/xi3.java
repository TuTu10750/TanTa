package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class xi3 implements zs1 {
    public static final xi3 a = new xi3();

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements ys1 {
        public final fd3 b;

        public a(fd3 fd3Var) {
            fd3Var.getClass();
            this.b = fd3Var;
        }

        @Override // defpackage.xr3
        public yr3 a() {
            yr3 yr3Var = yr3.a;
            yr3Var.getClass();
            return yr3Var;
        }

        @Override // defpackage.ys1
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public fd3 b() {
            return this.b;
        }

        public String toString() {
            return a.class.getName() + ": " + b();
        }
    }

    @Override // defpackage.zs1
    public ys1 a(as1 as1Var) {
        as1Var.getClass();
        return new a((fd3) as1Var);
    }
}
