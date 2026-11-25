package defpackage;

import java.util.Collection;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class md3 extends fd3 implements qs1 {
    public final r51 a;

    public md3(r51 r51Var) {
        r51Var.getClass();
        this.a = r51Var;
    }

    @Override // defpackage.qs1
    public Collection B() {
        return s20.k();
    }

    @Override // defpackage.hr1
    public dr1 a(r51 r51Var) {
        r51Var.getClass();
        return null;
    }

    @Override // defpackage.qs1
    public r51 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof md3) && dq1.a(d(), ((md3) obj).d());
    }

    @Override // defpackage.hr1
    public List getAnnotations() {
        return s20.k();
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // defpackage.hr1
    public boolean o() {
        return false;
    }

    public String toString() {
        return md3.class.getName() + ": " + d();
    }

    @Override // defpackage.qs1
    public Collection v(n81 n81Var) {
        n81Var.getClass();
        return s20.k();
    }
}
