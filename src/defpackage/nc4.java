package defpackage;

import kotlin.Pair;
import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class nc4 extends ek3 {
    public final ThreadLocal e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public nc4(kotlin.coroutines.d r3, defpackage.u60 r4) {
        /*
            r2 = this;
            pc4 r0 = defpackage.pc4.a
            kotlin.coroutines.d$b r1 = r3.get(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.d r0 = r3.plus(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.e = r0
            kotlin.coroutines.d r4 = r4.getContext()
            kotlin.coroutines.c$b r0 = kotlin.coroutines.c.d0
            kotlin.coroutines.d$b r4 = r4.get(r0)
            boolean r4 = r4 instanceof defpackage.n70
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = defpackage.g44.f(r3, r4)
            defpackage.g44.d(r3, r4)
            r2.x0(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nc4.<init>(kotlin.coroutines.d, u60):void");
    }

    @Override // defpackage.ek3, kotlinx.coroutines.a
    public void o0(Object obj) {
        w0();
        Object a = x30.a(obj, this.d);
        u60 u60Var = this.d;
        d context = u60Var.getContext();
        Object f = g44.f(context, null);
        nc4 j = f != g44.a ? k70.j(u60Var, context, f) : null;
        try {
            this.d.resumeWith(a);
            qc4 qc4Var = qc4.a;
            if (j == null || j.v0()) {
                g44.d(context, f);
            }
        } catch (Throwable th) {
            if (j == null || j.v0()) {
                g44.d(context, f);
            }
            throw th;
        }
    }

    @Override // defpackage.ek3
    public void u0() {
        w0();
    }

    public final boolean v0() {
        boolean z = this.threadLocalIsSet && this.e.get() == null;
        this.e.remove();
        return !z;
    }

    public final void w0() {
        if (this.threadLocalIsSet) {
            Pair pair = (Pair) this.e.get();
            if (pair != null) {
                g44.d((d) pair.getFirst(), pair.getSecond());
            }
            this.e.remove();
        }
    }

    public final void x0(d dVar, Object obj) {
        this.threadLocalIsSet = true;
        this.e.set(g94.a(dVar, obj));
    }
}
