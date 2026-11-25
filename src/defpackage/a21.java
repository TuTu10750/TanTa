package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class a21 implements j8 {
    public final j8 a;
    public final boolean b;
    public final n81 c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a21(j8 j8Var, n81 n81Var) {
        this(j8Var, false, n81Var);
        j8Var.getClass();
        n81Var.getClass();
    }

    public a21(j8 j8Var, boolean z, n81 n81Var) {
        j8Var.getClass();
        n81Var.getClass();
        this.a = j8Var;
        this.b = z;
        this.c = n81Var;
    }

    @Override // defpackage.j8
    public d8 a(r51 r51Var) {
        r51Var.getClass();
        if (((Boolean) this.c.invoke(r51Var)).booleanValue()) {
            return this.a.a(r51Var);
        }
        return null;
    }

    @Override // defpackage.j8
    public boolean c(r51 r51Var) {
        r51Var.getClass();
        if (((Boolean) this.c.invoke(r51Var)).booleanValue()) {
            return this.a.c(r51Var);
        }
        return false;
    }

    public final boolean g(d8 d8Var) {
        r51 d = d8Var.d();
        return d != null && ((Boolean) this.c.invoke(d)).booleanValue();
    }

    @Override // defpackage.j8
    public boolean isEmpty() {
        boolean z;
        j8 j8Var = this.a;
        if (!(j8Var instanceof Collection) || !((Collection) j8Var).isEmpty()) {
            Iterator it = j8Var.iterator();
            while (it.hasNext()) {
                if (g((d8) it.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return this.b ? !z : z;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        j8 j8Var = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : j8Var) {
            if (g((d8) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }
}
