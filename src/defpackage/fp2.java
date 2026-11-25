package defpackage;

import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class fp2 extends n70 implements jj0 {
    public final /* synthetic */ jj0 b;
    public final n70 c;
    public final String d;

    /* JADX WARN: Multi-variable type inference failed */
    public fp2(n70 n70Var, String str) {
        jj0 jj0Var = n70Var instanceof jj0 ? (jj0) n70Var : null;
        this.b = jj0Var == null ? pf0.a() : jj0Var;
        this.c = n70Var;
        this.d = str;
    }

    @Override // defpackage.jj0
    public void T(long j, zu zuVar) {
        this.b.T(j, zuVar);
    }

    @Override // defpackage.n70
    public String toString() {
        return this.d;
    }

    @Override // defpackage.n70
    public void y0(d dVar, Runnable runnable) {
        this.c.y0(dVar, runnable);
    }

    @Override // defpackage.n70
    public boolean z0(d dVar) {
        return this.c.z0(dVar);
    }
}
