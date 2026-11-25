package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: /tmp/classes2.dex */
public final class yo1 extends dk2 {
    public final MemberScope b;

    public yo1(MemberScope memberScope) {
        memberScope.getClass();
        this.b = memberScope;
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set b() {
        return this.b.b();
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set d() {
        return this.b.d();
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public z00 e(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        z00 e = this.b.e(zo2Var, z82Var);
        if (e != null) {
            m00 m00Var = e instanceof m00 ? (m00) e : null;
            if (m00Var != null) {
                return m00Var;
            }
            if (e instanceof r94) {
                return (r94) e;
            }
        }
        return null;
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set g() {
        return this.b.g();
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public List f(hk0 hk0Var, n81 n81Var) {
        hk0Var.getClass();
        n81Var.getClass();
        hk0 n = hk0Var.n(hk0.c.c());
        if (n == null) {
            return s20.k();
        }
        Collection f = this.b.f(n, n81Var);
        ArrayList arrayList = new ArrayList();
        for (Object obj : f) {
            if (obj instanceof a10) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "Classes from " + this.b;
    }
}
