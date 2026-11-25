package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class nv2 {
    public static final void a(mv2 mv2Var, r51 r51Var, Collection collection) {
        mv2Var.getClass();
        r51Var.getClass();
        collection.getClass();
        if (mv2Var instanceof ov2) {
            ((ov2) mv2Var).a(r51Var, collection);
        } else {
            collection.addAll(mv2Var.b(r51Var));
        }
    }

    public static final boolean b(mv2 mv2Var, r51 r51Var) {
        mv2Var.getClass();
        r51Var.getClass();
        return mv2Var instanceof ov2 ? ((ov2) mv2Var).c(r51Var) : c(mv2Var, r51Var).isEmpty();
    }

    public static final List c(mv2 mv2Var, r51 r51Var) {
        mv2Var.getClass();
        r51Var.getClass();
        ArrayList arrayList = new ArrayList();
        a(mv2Var, r51Var, arrayList);
        return arrayList;
    }
}
