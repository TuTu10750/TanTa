package defpackage;

import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class q60 implements s70 {
    public final d a;

    public q60(d dVar) {
        this.a = dVar;
    }

    @Override // defpackage.s70
    public d f() {
        return this.a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + f() + ')';
    }
}
