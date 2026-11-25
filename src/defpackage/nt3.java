package defpackage;

import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.c;

/* loaded from: /tmp/classes2.dex */
public final class nt3 extends ua4 {
    public final fx1 a;

    public nt3(d dVar) {
        dVar.getClass();
        zp3 I = dVar.I();
        I.getClass();
        this.a = I;
    }

    @Override // defpackage.ta4
    public ta4 a(c cVar) {
        cVar.getClass();
        return this;
    }

    @Override // defpackage.ta4
    public Variance b() {
        return Variance.OUT_VARIANCE;
    }

    @Override // defpackage.ta4
    public boolean c() {
        return true;
    }

    @Override // defpackage.ta4
    public fx1 getType() {
        return this.a;
    }
}
