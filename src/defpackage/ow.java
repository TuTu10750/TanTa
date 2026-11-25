package defpackage;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.c;

/* loaded from: /tmp/classes2.dex */
public final class ow implements nw {
    public final ta4 a;
    public NewCapturedTypeConstructor b;

    public ow(ta4 ta4Var) {
        ta4Var.getClass();
        this.a = ta4Var;
        e().b();
        Variance variance = Variance.INVARIANT;
    }

    @Override // defpackage.ea4
    /* renamed from: b */
    public /* bridge */ /* synthetic */ z00 v() {
        return (z00) f();
    }

    @Override // defpackage.ea4
    public Collection c() {
        fx1 type = e().b() == Variance.OUT_VARIANCE ? e().getType() : q().I();
        type.getClass();
        return r20.e(type);
    }

    @Override // defpackage.ea4
    public boolean d() {
        return false;
    }

    @Override // defpackage.nw
    public ta4 e() {
        return this.a;
    }

    public Void f() {
        return null;
    }

    public final NewCapturedTypeConstructor g() {
        return this.b;
    }

    @Override // defpackage.ea4
    public List getParameters() {
        return s20.k();
    }

    @Override // defpackage.ea4
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ow a(c cVar) {
        cVar.getClass();
        ta4 a = e().a(cVar);
        a.getClass();
        return new ow(a);
    }

    public final void i(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.b = newCapturedTypeConstructor;
    }

    @Override // defpackage.ea4
    public d q() {
        d q = e().getType().N0().q();
        q.getClass();
        return q;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + e() + ')';
    }
}
