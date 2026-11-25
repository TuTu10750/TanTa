package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.j;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public final class gj0 extends pj0 implements t80, hj0 {
    public static final a d = new a(null);
    public final zp3 b;
    public final boolean c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ gj0 c(a aVar, gd4 gd4Var, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return aVar.b(gd4Var, z, z2);
        }

        public final boolean a(gd4 gd4Var) {
            gd4Var.N0();
            return (gd4Var.N0().v() instanceof oa4) || (gd4Var instanceof gq2);
        }

        public final gj0 b(gd4 gd4Var, boolean z, boolean z2) {
            gd4Var.getClass();
            if (gd4Var instanceof gj0) {
                return (gj0) gd4Var;
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (!z2 && !d(gd4Var, z)) {
                return null;
            }
            if (gd4Var instanceof l31) {
                l31 l31Var = (l31) gd4Var;
                dq1.a(l31Var.V0().N0(), l31Var.W0().N0());
            }
            return new gj0(q31.c(gd4Var).R0(false), z, defaultConstructorMarker);
        }

        public final boolean d(gd4 gd4Var, boolean z) {
            if (!a(gd4Var)) {
                return false;
            }
            z00 v = gd4Var.N0().v();
            pa4 pa4Var = v instanceof pa4 ? (pa4) v : null;
            if (pa4Var == null || pa4Var.T0()) {
                return (z && (gd4Var.N0().v() instanceof oa4)) ? n.l(gd4Var) : !or2.a.a(gd4Var);
            }
            return true;
        }
    }

    public gj0(zp3 zp3Var, boolean z) {
        this.b = zp3Var;
        this.c = z;
    }

    public /* synthetic */ gj0(zp3 zp3Var, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(zp3Var, z);
    }

    @Override // defpackage.t80
    public boolean A0() {
        W0().N0();
        return W0().N0().v() instanceof oa4;
    }

    @Override // defpackage.pj0, defpackage.fx1
    public boolean O0() {
        return false;
    }

    @Override // defpackage.gd4
    /* renamed from: U0 */
    public zp3 R0(boolean z) {
        return z ? W0().R0(z) : this;
    }

    @Override // defpackage.gd4
    /* renamed from: V0 */
    public zp3 T0(j jVar) {
        jVar.getClass();
        return new gj0(W0().T0(jVar), this.c);
    }

    @Override // defpackage.pj0
    public zp3 W0() {
        return this.b;
    }

    public final zp3 Z0() {
        return this.b;
    }

    @Override // defpackage.pj0
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public gj0 Y0(zp3 zp3Var) {
        zp3Var.getClass();
        return new gj0(zp3Var, this.c);
    }

    @Override // defpackage.zp3
    public String toString() {
        return W0() + " & Any";
    }

    @Override // defpackage.t80
    public fx1 z0(fx1 fx1Var) {
        fx1Var.getClass();
        return ms3.d(fx1Var.Q0(), this.c);
    }
}
