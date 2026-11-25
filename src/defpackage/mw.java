package defpackage;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public final class mw extends zp3 implements qw {
    public final ta4 b;
    public final nw c;
    public final boolean d;
    public final j e;

    public mw(ta4 ta4Var, nw nwVar, boolean z, j jVar) {
        ta4Var.getClass();
        nwVar.getClass();
        jVar.getClass();
        this.b = ta4Var;
        this.c = nwVar;
        this.d = z;
        this.e = jVar;
    }

    public /* synthetic */ mw(ta4 ta4Var, nw nwVar, boolean z, j jVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ta4Var, (i & 2) != 0 ? new ow(ta4Var) : nwVar, (i & 4) != 0 ? false : z, (i & 8) != 0 ? j.b.h() : jVar);
    }

    @Override // defpackage.fx1
    public List L0() {
        return s20.k();
    }

    @Override // defpackage.fx1
    public j M0() {
        return this.e;
    }

    @Override // defpackage.fx1
    public boolean O0() {
        return this.d;
    }

    @Override // defpackage.gd4
    /* renamed from: V0 */
    public zp3 T0(j jVar) {
        jVar.getClass();
        return new mw(this.b, N0(), O0(), jVar);
    }

    @Override // defpackage.fx1
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public nw N0() {
        return this.c;
    }

    @Override // defpackage.zp3
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public mw R0(boolean z) {
        return z == O0() ? this : new mw(this.b, N0(), z, M0());
    }

    @Override // defpackage.gd4
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public mw X0(c cVar) {
        cVar.getClass();
        ta4 a = this.b.a(cVar);
        a.getClass();
        return new mw(a, N0(), O0(), M0());
    }

    @Override // defpackage.fx1
    public MemberScope s() {
        return xu0.a(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // defpackage.zp3
    public String toString() {
        StringBuilder sb = new StringBuilder("Captured(");
        sb.append(this.b);
        sb.append(')');
        sb.append(O0() ? "?" : "");
        return sb.toString();
    }
}
