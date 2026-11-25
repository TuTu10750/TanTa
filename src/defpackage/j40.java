package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class j40 implements ov2 {
    public final List a;
    public final String b;

    public j40(List list, String str) {
        list.getClass();
        str.getClass();
        this.a = list;
        this.b = str;
        list.size();
        b30.M0(list).size();
    }

    @Override // defpackage.ov2
    public void a(r51 r51Var, Collection collection) {
        r51Var.getClass();
        collection.getClass();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            nv2.a((mv2) it.next(), r51Var, collection);
        }
    }

    @Override // defpackage.mv2
    public List b(r51 r51Var) {
        r51Var.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            nv2.a((mv2) it.next(), r51Var, arrayList);
        }
        return b30.I0(arrayList);
    }

    @Override // defpackage.ov2
    public boolean c(r51 r51Var) {
        r51Var.getClass();
        List list = this.a;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!nv2.b((mv2) it.next(), r51Var)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.mv2
    public Collection r(r51 r51Var, n81 n81Var) {
        r51Var.getClass();
        n81Var.getClass();
        HashSet hashSet = new HashSet();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((mv2) it.next()).r(r51Var, n81Var));
        }
        return hashSet;
    }

    public String toString() {
        return this.b;
    }
}
