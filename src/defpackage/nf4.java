package defpackage;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class nf4 {
    public nf4() {
    }

    public /* synthetic */ nf4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract List a();

    public final nf4 b(n81 n81Var) {
        n81Var.getClass();
        if (this instanceof uo1) {
            uo1 uo1Var = (uo1) this;
            return new uo1(uo1Var.c(), (aq3) n81Var.invoke(uo1Var.d()));
        }
        if (!(this instanceof vn2)) {
            u.a();
            return null;
        }
        List<Pair> a = a();
        ArrayList arrayList = new ArrayList(t20.v(a, 10));
        for (Pair pair : a) {
            arrayList.add(g94.a((zo2) pair.getFirst(), n81Var.invoke((aq3) pair.getSecond())));
        }
        return new vn2(arrayList);
    }
}
