package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class cq4 extends fx1 {
    public cq4() {
        super(null);
    }

    @Override // defpackage.fx1
    public List L0() {
        return R0().L0();
    }

    @Override // defpackage.fx1
    public j M0() {
        return R0().M0();
    }

    @Override // defpackage.fx1
    public ea4 N0() {
        return R0().N0();
    }

    @Override // defpackage.fx1
    public boolean O0() {
        return R0().O0();
    }

    @Override // defpackage.fx1
    public final gd4 Q0() {
        fx1 R0 = R0();
        while (R0 instanceof cq4) {
            R0 = ((cq4) R0).R0();
        }
        R0.getClass();
        return (gd4) R0;
    }

    public abstract fx1 R0();

    public abstract boolean S0();

    @Override // defpackage.fx1
    public MemberScope s() {
        return R0().s();
    }

    public String toString() {
        return S0() ? R0().toString() : "<Not computed yet>";
    }
}
