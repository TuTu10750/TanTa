package defpackage;

import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class mc4 extends n70 {
    public static final mc4 b = new mc4();

    @Override // defpackage.n70
    public n70 B0(int i, String str) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // defpackage.n70
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    @Override // defpackage.n70
    public void y0(d dVar, Runnable runnable) {
        ue2.a(dVar.get(jq4.a));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // defpackage.n70
    public boolean z0(d dVar) {
        return false;
    }
}
