package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class m40 implements a14 {
    public final List b;

    public m40(List list) {
        list.getClass();
        this.b = list;
    }

    @Override // defpackage.a14
    public void a(ey1 ey1Var, m00 m00Var, List list) {
        ey1Var.getClass();
        m00Var.getClass();
        list.getClass();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a14) it.next()).a(ey1Var, m00Var, list);
        }
    }

    @Override // defpackage.a14
    public void b(ey1 ey1Var, m00 m00Var, zo2 zo2Var, Collection collection) {
        ey1Var.getClass();
        m00Var.getClass();
        zo2Var.getClass();
        collection.getClass();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a14) it.next()).b(ey1Var, m00Var, zo2Var, collection);
        }
    }

    @Override // defpackage.a14
    public List c(ey1 ey1Var, m00 m00Var) {
        ey1Var.getClass();
        m00Var.getClass();
        List list = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            x20.A(arrayList, ((a14) it.next()).c(ey1Var, m00Var));
        }
        return arrayList;
    }

    @Override // defpackage.a14
    public List d(ey1 ey1Var, m00 m00Var) {
        ey1Var.getClass();
        m00Var.getClass();
        List list = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            x20.A(arrayList, ((a14) it.next()).d(ey1Var, m00Var));
        }
        return arrayList;
    }

    @Override // defpackage.a14
    public void e(ey1 ey1Var, m00 m00Var, zo2 zo2Var, Collection collection) {
        ey1Var.getClass();
        m00Var.getClass();
        zo2Var.getClass();
        collection.getClass();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a14) it.next()).e(ey1Var, m00Var, zo2Var, collection);
        }
    }

    @Override // defpackage.a14
    public void f(ey1 ey1Var, m00 m00Var, zo2 zo2Var, List list) {
        ey1Var.getClass();
        m00Var.getClass();
        zo2Var.getClass();
        list.getClass();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a14) it.next()).f(ey1Var, m00Var, zo2Var, list);
        }
    }

    @Override // defpackage.a14
    public List g(ey1 ey1Var, m00 m00Var) {
        ey1Var.getClass();
        m00Var.getClass();
        List list = this.b;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            x20.A(arrayList, ((a14) it.next()).g(ey1Var, m00Var));
        }
        return arrayList;
    }
}
