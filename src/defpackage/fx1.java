package defpackage;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.b;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class fx1 implements a8, hx1 {
    public int a;

    public fx1() {
    }

    public /* synthetic */ fx1(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int K0() {
        return gx1.a(this) ? super.hashCode() : (((N0().hashCode() * 31) + L0().hashCode()) * 31) + (O0() ? 1 : 0);
    }

    public abstract List L0();

    public abstract j M0();

    public abstract ea4 N0();

    public abstract boolean O0();

    public abstract fx1 P0(c cVar);

    public abstract gd4 Q0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fx1)) {
            return false;
        }
        fx1 fx1Var = (fx1) obj;
        return O0() == fx1Var.O0() && lv3.a.a(Q0(), fx1Var.Q0());
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        return b.a(M0());
    }

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int K0 = K0();
        this.a = K0;
        return K0;
    }

    public abstract MemberScope s();
}
