package defpackage;

import com.umeng.ccg.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class i51 extends n11 {
    public final n11 e;

    public i51(n11 n11Var) {
        n11Var.getClass();
        this.e = n11Var;
    }

    @Override // defpackage.n11
    public kq3 b(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        return this.e.b(r(uw2Var, "appendingSink", "file"), z);
    }

    @Override // defpackage.n11
    public void c(uw2 uw2Var, uw2 uw2Var2) {
        uw2Var.getClass();
        uw2Var2.getClass();
        this.e.c(r(uw2Var, "atomicMove", "source"), r(uw2Var2, "atomicMove", a.F));
    }

    @Override // defpackage.n11
    public void g(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        this.e.g(r(uw2Var, "createDirectory", "dir"), z);
    }

    @Override // defpackage.n11
    public void i(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        this.e.i(r(uw2Var, "delete", "path"), z);
    }

    @Override // defpackage.n11
    public List k(uw2 uw2Var) {
        uw2Var.getClass();
        List k = this.e.k(r(uw2Var, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        Iterator it = k.iterator();
        while (it.hasNext()) {
            arrayList.add(s((uw2) it.next(), "list"));
        }
        w20.y(arrayList);
        return arrayList;
    }

    @Override // defpackage.n11
    public k11 m(uw2 uw2Var) {
        uw2Var.getClass();
        k11 m = this.e.m(r(uw2Var, "metadataOrNull", "path"));
        if (m == null) {
            return null;
        }
        return m.e() == null ? m : k11.b(m, false, false, s(m.e(), "metadataOrNull"), null, null, null, null, null, 251, null);
    }

    @Override // defpackage.n11
    public e11 n(uw2 uw2Var) {
        uw2Var.getClass();
        return this.e.n(r(uw2Var, "openReadOnly", "file"));
    }

    @Override // defpackage.n11
    public kq3 p(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        return this.e.p(r(uw2Var, "sink", "file"), z);
    }

    @Override // defpackage.n11
    public wr3 q(uw2 uw2Var) {
        uw2Var.getClass();
        return this.e.q(r(uw2Var, "source", "file"));
    }

    public uw2 r(uw2 uw2Var, String str, String str2) {
        uw2Var.getClass();
        str.getClass();
        str2.getClass();
        return uw2Var;
    }

    public uw2 s(uw2 uw2Var, String str) {
        uw2Var.getClass();
        str.getClass();
        return uw2Var;
    }

    public String toString() {
        return zd3.b(getClass()).h() + '(' + this.e + ')';
    }
}
