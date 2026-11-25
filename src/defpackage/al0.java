package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class al0 implements l00 {
    public final mv2 a;

    public al0(mv2 mv2Var) {
        mv2Var.getClass();
        this.a = mv2Var;
    }

    @Override // defpackage.l00
    public k00 a(q00 q00Var) {
        k00 a;
        q00Var.getClass();
        mv2 mv2Var = this.a;
        r51 h = q00Var.h();
        h.getClass();
        for (kv2 kv2Var : nv2.c(mv2Var, h)) {
            if ((kv2Var instanceof dl0) && (a = ((dl0) kv2Var).F0().a(q00Var)) != null) {
                return a;
            }
        }
        return null;
    }
}
