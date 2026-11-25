package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /tmp/classes2.dex */
public final class m50 implements bn3 {
    public final AtomicReference a;

    public m50(bn3 bn3Var) {
        bn3Var.getClass();
        this.a = new AtomicReference(bn3Var);
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        bn3 bn3Var = (bn3) this.a.getAndSet(null);
        if (bn3Var != null) {
            return bn3Var.iterator();
        }
        fl3.a("This sequence can be consumed only once.");
        return null;
    }
}
