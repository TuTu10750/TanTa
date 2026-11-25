package defpackage;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class uo1 extends nf4 {
    public final zo2 a;
    public final aq3 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uo1(zo2 zo2Var, aq3 aq3Var) {
        super(null);
        zo2Var.getClass();
        aq3Var.getClass();
        this.a = zo2Var;
        this.b = aq3Var;
    }

    @Override // defpackage.nf4
    public List a() {
        return r20.e(g94.a(this.a, this.b));
    }

    public final zo2 c() {
        return this.a;
    }

    public final aq3 d() {
        return this.b;
    }

    public String toString() {
        return "InlineClassRepresentation(underlyingPropertyName=" + this.a + ", underlyingType=" + this.b + ')';
    }
}
