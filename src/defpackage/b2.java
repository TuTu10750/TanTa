package defpackage;

import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: /tmp/classes2.dex */
public abstract class b2 implements MemberScope {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection a(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return i().a(zo2Var, z82Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set b() {
        return i().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection c(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return i().c(zo2Var, z82Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set d() {
        return i().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public z00 e(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return i().e(zo2Var, z82Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public Collection f(hk0 hk0Var, n81 n81Var) {
        hk0Var.getClass();
        n81Var.getClass();
        return i().f(hk0Var, n81Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set g() {
        return i().g();
    }

    public final MemberScope h() {
        if (!(i() instanceof b2)) {
            return i();
        }
        MemberScope i = i();
        i.getClass();
        return ((b2) i).h();
    }

    public abstract MemberScope i();
}
