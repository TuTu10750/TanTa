package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class pj0 extends zp3 {
    @Override // defpackage.fx1
    public List L0() {
        return W0().L0();
    }

    @Override // defpackage.fx1
    public j M0() {
        return W0().M0();
    }

    @Override // defpackage.fx1
    public ea4 N0() {
        return W0().N0();
    }

    @Override // defpackage.fx1
    public boolean O0() {
        return W0().O0();
    }

    public abstract zp3 W0();

    @Override // defpackage.gd4
    public zp3 X0(c cVar) {
        cVar.getClass();
        fx1 a = cVar.a(W0());
        a.getClass();
        return Y0((zp3) a);
    }

    public abstract pj0 Y0(zp3 zp3Var);

    @Override // defpackage.fx1
    public MemberScope s() {
        return W0().s();
    }
}
