package defpackage;

import kotlinx.coroutines.h;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* loaded from: /tmp/classes2.dex */
public abstract class ut1 extends LockFreeLinkedListNode implements pn0, vn1 {
    public h d;

    @Override // defpackage.vn1
    public boolean a() {
        return true;
    }

    @Override // defpackage.vn1
    public nq2 c() {
        return null;
    }

    @Override // defpackage.pn0
    public void dispose() {
        u().Z(this);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return na0.a(this) + '@' + na0.b(this) + "[job@" + na0.b(u()) + ']';
    }

    public final h u() {
        h hVar = this.d;
        if (hVar != null) {
            return hVar;
        }
        dq1.k("job");
        return null;
    }

    public abstract boolean v();

    public abstract void w(Throwable th);

    public final void x(h hVar) {
        this.d = hVar;
    }
}
