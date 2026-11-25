package defpackage;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class dk2 implements MemberScope {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection a(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return s20.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set b() {
        Collection f = f(hk0.v, FunctionsKt.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : f) {
            if (obj instanceof g) {
                zo2 name = ((g) obj).getName();
                name.getClass();
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection c(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return s20.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set d() {
        Collection f = f(hk0.w, FunctionsKt.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : f) {
            if (obj instanceof g) {
                zo2 name = ((g) obj).getName();
                name.getClass();
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public z00 e(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public Collection f(hk0 hk0Var, n81 n81Var) {
        hk0Var.getClass();
        n81Var.getClass();
        return s20.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set g() {
        return null;
    }
}
