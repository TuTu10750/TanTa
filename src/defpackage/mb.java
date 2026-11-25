package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.d;

/* loaded from: /tmp/classes2.dex */
public class mb extends k50 {
    public final n81 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb(List list, n81 n81Var) {
        super(list);
        list.getClass();
        n81Var.getClass();
        this.b = n81Var;
    }

    @Override // defpackage.k50
    public fx1 a(mm2 mm2Var) {
        mm2Var.getClass();
        fx1 fx1Var = (fx1) this.b.invoke(mm2Var);
        if (!d.c0(fx1Var) && !d.q0(fx1Var)) {
            d.D0(fx1Var);
        }
        return fx1Var;
    }
}
