package defpackage;

import defpackage.yl4;

/* loaded from: /tmp/classes2.dex */
public final class nt1 extends am4 {
    public static final nt1 c = new nt1();

    public nt1() {
        super("protected_and_package", true);
    }

    @Override // defpackage.am4
    public Integer a(am4 am4Var) {
        am4Var.getClass();
        if (dq1.a(this, am4Var)) {
            return 0;
        }
        if (am4Var == yl4.b.c) {
            return null;
        }
        return yl4.a.b(am4Var) ? 1 : -1;
    }

    @Override // defpackage.am4
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // defpackage.am4
    public am4 d() {
        return yl4.g.c;
    }
}
