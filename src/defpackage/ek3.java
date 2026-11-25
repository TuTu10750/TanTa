package defpackage;

import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.a;

/* loaded from: /tmp/classes2.dex */
public class ek3 extends a implements t70 {
    public final u60 d;

    public ek3(d dVar, u60 u60Var) {
        super(dVar, true, true);
        this.d = u60Var;
    }

    @Override // kotlinx.coroutines.h
    public final boolean M() {
        return true;
    }

    @Override // defpackage.t70
    public final t70 getCallerFrame() {
        u60 u60Var = this.d;
        if (u60Var instanceof t70) {
            return (t70) u60Var;
        }
        return null;
    }

    @Override // kotlinx.coroutines.h
    public void m(Object obj) {
        fn0.b(IntrinsicsKt__IntrinsicsJvmKt.c(this.d), x30.a(obj, this.d));
    }

    @Override // kotlinx.coroutines.a
    public void o0(Object obj) {
        u60 u60Var = this.d;
        u60Var.resumeWith(x30.a(obj, u60Var));
    }

    public void u0() {
    }
}
