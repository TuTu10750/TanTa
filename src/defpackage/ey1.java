package defpackage;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.a;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;

/* loaded from: /tmp/classes2.dex */
public final class ey1 {
    public final ws1 a;
    public final a b;
    public final wx1 c;
    public final wx1 d;
    public final JavaTypeResolver e;

    public ey1(ws1 ws1Var, a aVar, wx1 wx1Var) {
        ws1Var.getClass();
        aVar.getClass();
        wx1Var.getClass();
        this.a = ws1Var;
        this.b = aVar;
        this.c = wx1Var;
        this.d = wx1Var;
        this.e = new JavaTypeResolver(this, aVar);
    }

    public final ws1 a() {
        return this.a;
    }

    public final it1 b() {
        return (it1) this.d.getValue();
    }

    public final wx1 c() {
        return this.c;
    }

    public final mm2 d() {
        return this.a.m();
    }

    public final lu3 e() {
        return this.a.u();
    }

    public final a f() {
        return this.b;
    }

    public final JavaTypeResolver g() {
        return this.e;
    }
}
