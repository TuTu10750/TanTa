package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class ra2 extends n70 {
    @Override // defpackage.n70
    public n70 B0(int i, String str) {
        fz1.a(i);
        return fz1.b(this, str);
    }

    public abstract ra2 D0();

    public final String E0() {
        ra2 ra2Var;
        ra2 c = in0.c();
        if (this == c) {
            return "Dispatchers.Main";
        }
        try {
            ra2Var = c.D0();
        } catch (UnsupportedOperationException unused) {
            ra2Var = null;
        }
        if (this == ra2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
