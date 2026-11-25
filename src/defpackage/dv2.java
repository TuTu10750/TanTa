package defpackage;

import defpackage.w00;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.b;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* loaded from: /tmp/classes2.dex */
public final class dv2 implements w00 {
    public final Map a;
    public final b.a b;
    public final c c;
    public final KotlinTypePreparator d;
    public final b91 e;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends TypeCheckerState {
        public final /* synthetic */ dv2 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, boolean z2, dv2 dv2Var, KotlinTypePreparator kotlinTypePreparator, c cVar) {
            super(z, z2, true, dv2Var, kotlinTypePreparator, cVar);
            this.k = dv2Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState
        public boolean f(hx1 hx1Var, hx1 hx1Var2) {
            hx1Var.getClass();
            hx1Var2.getClass();
            if (!(hx1Var instanceof fx1)) {
                ik.a("Failed requirement.");
                return false;
            }
            if (hx1Var2 instanceof fx1) {
                return ((Boolean) this.k.e.invoke(hx1Var, hx1Var2)).booleanValue();
            }
            ik.a("Failed requirement.");
            return false;
        }
    }

    public dv2(Map map, b.a aVar, c cVar, KotlinTypePreparator kotlinTypePreparator, b91 b91Var) {
        aVar.getClass();
        cVar.getClass();
        kotlinTypePreparator.getClass();
        this.a = map;
        this.b = aVar;
        this.c = cVar;
        this.d = kotlinTypePreparator;
        this.e = b91Var;
    }

    @Override // defpackage.ya4
    public aq3 A(hx1 hx1Var) {
        aq3 g;
        hx1Var.getClass();
        o31 l0 = l0(hx1Var);
        if (l0 != null && (g = g(l0)) != null) {
            return g;
        }
        aq3 b = b(hx1Var);
        b.getClass();
        return b;
    }

    @Override // defpackage.ya4
    public boolean A0(hx1 hx1Var) {
        return w00.a.Q(this, hx1Var);
    }

    @Override // defpackage.ya4
    public hx1 B(qw qwVar) {
        return w00.a.c0(this, qwVar);
    }

    @Override // defpackage.ya4
    public List B0(aq3 aq3Var, fa4 fa4Var) {
        aq3Var.getClass();
        fa4Var.getClass();
        return null;
    }

    @Override // defpackage.ya4
    public Collection C(fa4 fa4Var) {
        return w00.a.k0(this, fa4Var);
    }

    @Override // defpackage.w00
    public hx1 C0(aq3 aq3Var, aq3 aq3Var2) {
        return w00.a.m(this, aq3Var, aq3Var2);
    }

    @Override // defpackage.ya4
    public boolean D(fa4 fa4Var) {
        return w00.a.I(this, fa4Var);
    }

    @Override // defpackage.ya4
    public hj0 D0(aq3 aq3Var) {
        return w00.a.e(this, aq3Var);
    }

    @Override // defpackage.ya4
    public Collection E(aq3 aq3Var) {
        return w00.a.h0(this, aq3Var);
    }

    @Override // defpackage.ya4
    public boolean E0(hx1 hx1Var) {
        return w00.a.J(this, hx1Var);
    }

    @Override // defpackage.ya4
    public CaptureStatus F(qw qwVar) {
        return w00.a.l(this, qwVar);
    }

    @Override // defpackage.ya4
    public boolean G(hx1 hx1Var) {
        hx1Var.getClass();
        return j0(A(hx1Var)) != j0(V(hx1Var));
    }

    public final boolean G0(ea4 ea4Var, ea4 ea4Var2) {
        if (this.b.a(ea4Var, ea4Var2)) {
            return true;
        }
        Map map = this.a;
        if (map == null) {
            return false;
        }
        ea4 ea4Var3 = (ea4) map.get(ea4Var);
        ea4 ea4Var4 = (ea4) this.a.get(ea4Var2);
        return (ea4Var3 != null && dq1.a(ea4Var3, ea4Var2)) || (ea4Var4 != null && dq1.a(ea4Var4, ea4Var));
    }

    @Override // defpackage.ya4
    public boolean H(hx1 hx1Var) {
        hx1Var.getClass();
        aq3 b = b(hx1Var);
        return (b != null ? D0(b) : null) != null;
    }

    public TypeCheckerState H0(boolean z, boolean z2) {
        if (this.e != null) {
            return new a(z, z2, this, this.d, this.c);
        }
        return kotlin.reflect.jvm.internal.impl.types.checker.a.a(z, z2, this, this.d, this.c);
    }

    @Override // defpackage.ya4
    public boolean I(aq3 aq3Var) {
        return w00.a.X(this, aq3Var);
    }

    @Override // defpackage.ya4
    public TypeCheckerState.b J(aq3 aq3Var) {
        return w00.a.j0(this, aq3Var);
    }

    @Override // defpackage.ya4
    public boolean K(hx1 hx1Var) {
        hx1Var.getClass();
        return s0(m0(hx1Var)) && !A0(hx1Var);
    }

    @Override // defpackage.ya4
    public hx1 L(List list) {
        return w00.a.E(this, list);
    }

    @Override // defpackage.ya4
    public ra4 M(fa4 fa4Var) {
        return w00.a.w(this, fa4Var);
    }

    @Override // defpackage.ya4
    public boolean N(hx1 hx1Var) {
        hx1Var.getClass();
        aq3 b = b(hx1Var);
        return (b != null ? e(b) : null) != null;
    }

    @Override // defpackage.ya4
    public jb3 O(o31 o31Var) {
        return w00.a.h(this, o31Var);
    }

    @Override // defpackage.ya4
    public List P(hx1 hx1Var) {
        return w00.a.o(this, hx1Var);
    }

    @Override // defpackage.ya4
    public boolean Q(aq3 aq3Var) {
        aq3Var.getClass();
        return o0(d(aq3Var));
    }

    @Override // defpackage.ya4
    public hx1 R(hx1 hx1Var) {
        return w00.a.d0(this, hx1Var);
    }

    @Override // defpackage.ya4
    public boolean S(aq3 aq3Var) {
        return w00.a.S(this, aq3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public boolean T(fa4 fa4Var) {
        return w00.a.a0(this, fa4Var);
    }

    @Override // defpackage.ya4
    public int U(fa4 fa4Var) {
        return w00.a.g0(this, fa4Var);
    }

    @Override // defpackage.ya4
    public aq3 V(hx1 hx1Var) {
        aq3 f;
        hx1Var.getClass();
        o31 l0 = l0(hx1Var);
        if (l0 != null && (f = f(l0)) != null) {
            return f;
        }
        aq3 b = b(hx1Var);
        b.getClass();
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public PrimitiveType W(fa4 fa4Var) {
        return w00.a.s(this, fa4Var);
    }

    @Override // defpackage.ya4
    public boolean X(hx1 hx1Var) {
        return w00.a.Z(this, hx1Var);
    }

    @Override // defpackage.ya4
    public jr0 Y(o31 o31Var) {
        w00.a.f(this, o31Var);
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public hx1 Z(hx1 hx1Var) {
        aq3 c;
        hx1Var.getClass();
        aq3 b = b(hx1Var);
        return (b == null || (c = c(b, true)) == null) ? hx1Var : c;
    }

    @Override // defpackage.w00, defpackage.ya4
    public boolean a(aq3 aq3Var) {
        return w00.a.U(this, aq3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public hx1 a0(hx1 hx1Var) {
        return w00.a.x(this, hx1Var);
    }

    @Override // defpackage.w00, defpackage.ya4
    public aq3 b(hx1 hx1Var) {
        return w00.a.i(this, hx1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public hx1 b0(ra4 ra4Var) {
        return w00.a.u(this, ra4Var);
    }

    @Override // defpackage.w00, defpackage.ya4
    public aq3 c(aq3 aq3Var, boolean z) {
        return w00.a.p0(this, aq3Var, z);
    }

    @Override // defpackage.ya4
    public u94 c0(hx1 hx1Var) {
        return w00.a.j(this, hx1Var);
    }

    @Override // defpackage.w00, defpackage.ya4
    public fa4 d(aq3 aq3Var) {
        return w00.a.m0(this, aq3Var);
    }

    @Override // defpackage.ya4
    public u94 d0(pw pwVar) {
        return w00.a.i0(this, pwVar);
    }

    @Override // defpackage.w00, defpackage.ya4
    public qw e(aq3 aq3Var) {
        return w00.a.d(this, aq3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public s51 e0(fa4 fa4Var) {
        return w00.a.p(this, fa4Var);
    }

    @Override // defpackage.w00, defpackage.ya4
    public aq3 f(o31 o31Var) {
        return w00.a.n0(this, o31Var);
    }

    @Override // defpackage.ya4
    public ra4 f0(fa4 fa4Var, int i) {
        return w00.a.q(this, fa4Var, i);
    }

    @Override // defpackage.w00, defpackage.ya4
    public aq3 g(o31 o31Var) {
        return w00.a.b0(this, o31Var);
    }

    @Override // defpackage.ya4
    public boolean g0(fa4 fa4Var, fa4 fa4Var2) {
        fa4Var.getClass();
        fa4Var2.getClass();
        if (!(fa4Var instanceof ea4)) {
            ik.a("Failed requirement.");
            return false;
        }
        if (fa4Var2 instanceof ea4) {
            return w00.a.a(this, fa4Var, fa4Var2) || G0((ea4) fa4Var, (ea4) fa4Var2);
        }
        ik.a("Failed requirement.");
        return false;
    }

    @Override // defpackage.ya4
    public boolean h(ra4 ra4Var, fa4 fa4Var) {
        return w00.a.C(this, ra4Var, fa4Var);
    }

    @Override // defpackage.bb4
    public boolean h0(aq3 aq3Var, aq3 aq3Var2) {
        return w00.a.D(this, aq3Var, aq3Var2);
    }

    @Override // defpackage.ya4
    public int i(hx1 hx1Var) {
        return w00.a.b(this, hx1Var);
    }

    @Override // defpackage.ya4
    public boolean i0(hx1 hx1Var) {
        return w00.a.O(this, hx1Var);
    }

    @Override // defpackage.ya4
    public boolean j(qw qwVar) {
        return w00.a.R(this, qwVar);
    }

    @Override // defpackage.ya4
    public boolean j0(aq3 aq3Var) {
        return w00.a.N(this, aq3Var);
    }

    @Override // defpackage.ya4
    public boolean k(u94 u94Var) {
        return w00.a.W(this, u94Var);
    }

    @Override // defpackage.ya4
    public u94 k0(aq3 aq3Var, int i) {
        aq3Var.getClass();
        if (i < 0 || i >= i(aq3Var)) {
            return null;
        }
        return y0(aq3Var, i);
    }

    @Override // defpackage.ya4
    public int l(t94 t94Var) {
        t94Var.getClass();
        if (t94Var instanceof aq3) {
            return i((hx1) t94Var);
        }
        if (t94Var instanceof ArgumentList) {
            return ((ArgumentList) t94Var).size();
        }
        StringBuilder sb = new StringBuilder("unknown type argument list type: ");
        sb.append(t94Var);
        f2.a(sb, ", ", zd3.b(t94Var.getClass()));
        return 0;
    }

    @Override // defpackage.ya4
    public o31 l0(hx1 hx1Var) {
        return w00.a.g(this, hx1Var);
    }

    @Override // defpackage.ya4
    public TypeVariance m(u94 u94Var) {
        return w00.a.z(this, u94Var);
    }

    @Override // defpackage.ya4
    public fa4 m0(hx1 hx1Var) {
        hx1Var.getClass();
        aq3 b = b(hx1Var);
        if (b == null) {
            b = A(hx1Var);
        }
        return d(b);
    }

    @Override // defpackage.ya4
    public t94 n(aq3 aq3Var) {
        return w00.a.c(this, aq3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public PrimitiveType n0(fa4 fa4Var) {
        return w00.a.t(this, fa4Var);
    }

    @Override // defpackage.ya4
    public List o(ra4 ra4Var) {
        return w00.a.y(this, ra4Var);
    }

    @Override // defpackage.ya4
    public boolean o0(fa4 fa4Var) {
        return w00.a.L(this, fa4Var);
    }

    @Override // defpackage.ya4
    public boolean p(hx1 hx1Var) {
        hx1Var.getClass();
        o31 l0 = l0(hx1Var);
        if (l0 == null) {
            return false;
        }
        Y(l0);
        return false;
    }

    @Override // defpackage.ya4
    public aq3 p0(hj0 hj0Var) {
        return w00.a.f0(this, hj0Var);
    }

    @Override // defpackage.ya4
    public hx1 q(u94 u94Var) {
        return w00.a.v(this, u94Var);
    }

    @Override // defpackage.ya4
    public boolean q0(fa4 fa4Var) {
        return w00.a.F(this, fa4Var);
    }

    @Override // defpackage.ya4
    public boolean r(fa4 fa4Var) {
        return w00.a.M(this, fa4Var);
    }

    @Override // defpackage.ya4
    public boolean r0(qw qwVar) {
        return w00.a.T(this, qwVar);
    }

    @Override // defpackage.ya4
    public boolean s(aq3 aq3Var) {
        return w00.a.Y(this, aq3Var);
    }

    @Override // defpackage.ya4
    public boolean s0(fa4 fa4Var) {
        return w00.a.P(this, fa4Var);
    }

    @Override // defpackage.ya4
    public pw t(qw qwVar) {
        return w00.a.l0(this, qwVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public boolean t0(hx1 hx1Var, r51 r51Var) {
        return w00.a.B(this, hx1Var, r51Var);
    }

    @Override // defpackage.ya4
    public List u(fa4 fa4Var) {
        return w00.a.r(this, fa4Var);
    }

    @Override // defpackage.ya4
    public u94 u0(t94 t94Var, int i) {
        t94Var.getClass();
        if (t94Var instanceof aq3) {
            return y0((hx1) t94Var, i);
        }
        if (t94Var instanceof ArgumentList) {
            u94 u94Var = ((ArgumentList) t94Var).get(i);
            u94Var.getClass();
            return u94Var;
        }
        StringBuilder sb = new StringBuilder("unknown type argument list type: ");
        sb.append(t94Var);
        f2.a(sb, ", ", zd3.b(t94Var.getClass()));
        return null;
    }

    @Override // defpackage.ya4
    public aq3 v(aq3 aq3Var, CaptureStatus captureStatus) {
        return w00.a.k(this, aq3Var, captureStatus);
    }

    @Override // defpackage.ya4
    public hx1 v0(hx1 hx1Var, boolean z) {
        return w00.a.o0(this, hx1Var, z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m
    public boolean w(fa4 fa4Var) {
        return w00.a.K(this, fa4Var);
    }

    @Override // defpackage.ya4
    public boolean w0(fa4 fa4Var) {
        return w00.a.H(this, fa4Var);
    }

    @Override // defpackage.ya4
    public boolean x(aq3 aq3Var) {
        aq3Var.getClass();
        return y(d(aq3Var));
    }

    @Override // defpackage.ya4
    public aq3 x0(aq3 aq3Var) {
        aq3 p0;
        aq3Var.getClass();
        hj0 D0 = D0(aq3Var);
        return (D0 == null || (p0 = p0(D0)) == null) ? aq3Var : p0;
    }

    @Override // defpackage.ya4
    public boolean y(fa4 fa4Var) {
        return w00.a.G(this, fa4Var);
    }

    @Override // defpackage.ya4
    public u94 y0(hx1 hx1Var, int i) {
        return w00.a.n(this, hx1Var, i);
    }

    @Override // defpackage.ya4
    public TypeVariance z(ra4 ra4Var) {
        return w00.a.A(this, ra4Var);
    }

    @Override // defpackage.ya4
    public boolean z0(hx1 hx1Var) {
        hx1Var.getClass();
        return (hx1Var instanceof aq3) && j0((aq3) hx1Var);
    }
}
