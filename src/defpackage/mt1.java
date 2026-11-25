package defpackage;

import defpackage.yl4;

/* loaded from: /tmp/classes2.dex */
public final class mt1 extends am4 {
    public static final mt1 c = new mt1();

    public mt1() {
        super("package", false);
    }

    @Override // defpackage.am4
    public Integer a(am4 am4Var) {
        am4Var.getClass();
        if (this == am4Var) {
            return 0;
        }
        return yl4.a.b(am4Var) ? 1 : -1;
    }

    @Override // defpackage.am4
    public String b() {
        return "public/*package*/";
    }

    @Override // defpackage.am4
    public am4 d() {
        return yl4.g.c;
    }
}
