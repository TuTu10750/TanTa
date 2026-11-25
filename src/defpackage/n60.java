package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class n60 extends z1 implements sn1 {
    public final m00 c;
    public final zo2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n60(m00 m00Var, fx1 fx1Var, zo2 zo2Var, bc3 bc3Var) {
        super(fx1Var, bc3Var);
        m00Var.getClass();
        fx1Var.getClass();
        this.c = m00Var;
        this.d = zo2Var;
    }

    @Override // defpackage.sn1
    public zo2 a() {
        return this.d;
    }

    public String toString() {
        return getType() + ": Ctx { " + this.c + " }";
    }
}
