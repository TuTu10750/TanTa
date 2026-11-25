package defpackage;

import kotlinx.coroutines.b;

/* loaded from: /tmp/classes2.dex */
public final class qn0 implements b {
    public final pn0 a;

    public qn0(pn0 pn0Var) {
        this.a = pn0Var;
    }

    @Override // kotlinx.coroutines.b
    public void a(Throwable th) {
        this.a.dispose();
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
