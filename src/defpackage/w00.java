package defpackage;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.k;
import kotlin.reflect.jvm.internal.impl.types.m;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public interface w00 extends m, ab4 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a {

        /* renamed from: w00$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0163a extends TypeCheckerState.b.a {
            public final /* synthetic */ w00 a;
            public final /* synthetic */ TypeSubstitutor b;

            public C0163a(w00 w00Var, TypeSubstitutor typeSubstitutor) {
                this.a = w00Var;
                this.b = typeSubstitutor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.b
            public aq3 a(TypeCheckerState typeCheckerState, hx1 hx1Var) {
                typeCheckerState.getClass();
                hx1Var.getClass();
                w00 w00Var = this.a;
                TypeSubstitutor typeSubstitutor = this.b;
                hx1 A = w00Var.A(hx1Var);
                A.getClass();
                fx1 n = typeSubstitutor.n((fx1) A, Variance.INVARIANT);
                n.getClass();
                aq3 b = w00Var.b(n);
                b.getClass();
                return b;
            }
        }

        public static TypeVariance A(w00 w00Var, ra4 ra4Var) {
            ra4Var.getClass();
            if (ra4Var instanceof oa4) {
                Variance p = ((oa4) ra4Var).p();
                p.getClass();
                return za4.a(p);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(ra4Var);
            rn3.a(sb, ", ", zd3.b(ra4Var.getClass()));
            return null;
        }

        public static boolean B(w00 w00Var, hx1 hx1Var, r51 r51Var) {
            hx1Var.getClass();
            r51Var.getClass();
            if (hx1Var instanceof fx1) {
                return ((fx1) hx1Var).getAnnotations().c(r51Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return false;
        }

        public static boolean C(w00 w00Var, ra4 ra4Var, fa4 fa4Var) {
            ra4Var.getClass();
            if (!(ra4Var instanceof oa4)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(ra4Var);
                rn3.a(sb, ", ", zd3.b(ra4Var.getClass()));
                return false;
            }
            if (fa4Var == null ? true : fa4Var instanceof ea4) {
                return TypeUtilsKt.m((oa4) ra4Var, (ea4) fa4Var, null, 4, null);
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(ra4Var);
            rn3.a(sb2, ", ", zd3.b(ra4Var.getClass()));
            return false;
        }

        public static boolean D(w00 w00Var, aq3 aq3Var, aq3 aq3Var2) {
            aq3Var.getClass();
            aq3Var2.getClass();
            if (!(aq3Var instanceof zp3)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(aq3Var);
                rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
                return false;
            }
            if (aq3Var2 instanceof zp3) {
                return ((zp3) aq3Var).L0() == ((zp3) aq3Var2).L0();
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(aq3Var2);
            rn3.a(sb2, ", ", zd3.b(aq3Var2.getClass()));
            return false;
        }

        public static hx1 E(w00 w00Var, List list) {
            list.getClass();
            return cq1.a(list);
        }

        public static boolean F(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                return d.w0((ea4) fa4Var, e.a.b);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean G(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                return ((ea4) fa4Var).v() instanceof m00;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean H(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                z00 v = ((ea4) fa4Var).v();
                m00 m00Var = v instanceof m00 ? (m00) v : null;
                return (m00Var == null || !zl2.a(m00Var) || m00Var.i() == ClassKind.ENUM_ENTRY || m00Var.i() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean I(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                return ((ea4) fa4Var).d();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean J(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                return gx1.a((fx1) hx1Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return false;
        }

        public static boolean K(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                z00 v = ((ea4) fa4Var).v();
                m00 m00Var = v instanceof m00 ? (m00) v : null;
                return (m00Var != null ? m00Var.y0() : null) instanceof uo1;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean L(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                return fa4Var instanceof IntegerLiteralTypeConstructor;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean M(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                return fa4Var instanceof IntersectionTypeConstructor;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean N(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                return ((zp3) aq3Var).O0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return false;
        }

        public static boolean O(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            return hx1Var instanceof yq2;
        }

        public static boolean P(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                return d.w0((ea4) fa4Var, e.a.c);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static boolean Q(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                return n.l((fx1) hx1Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return false;
        }

        public static boolean R(w00 w00Var, qw qwVar) {
            qwVar.getClass();
            return qwVar instanceof mw;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean S(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof fx1) {
                return d.s0((fx1) aq3Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return false;
        }

        public static boolean T(w00 w00Var, qw qwVar) {
            qwVar.getClass();
            if (qwVar instanceof gq2) {
                return ((gq2) qwVar).Z0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(qwVar);
            rn3.a(sb, ", ", zd3.b(qwVar.getClass()));
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean U(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (!(aq3Var instanceof zp3)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(aq3Var);
                rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
                return false;
            }
            if (!gx1.a((fx1) aq3Var)) {
                zp3 zp3Var = (zp3) aq3Var;
                if (!(zp3Var.N0().v() instanceof r94) && (zp3Var.N0().v() != null || (aq3Var instanceof mw) || (aq3Var instanceof gq2) || (aq3Var instanceof gj0) || (zp3Var.N0() instanceof IntegerLiteralTypeConstructor) || V(w00Var, aq3Var))) {
                    return true;
                }
            }
            return false;
        }

        public static boolean V(w00 w00Var, aq3 aq3Var) {
            return (aq3Var instanceof cq3) && w00Var.a(((cq3) aq3Var).F0());
        }

        public static boolean W(w00 w00Var, u94 u94Var) {
            u94Var.getClass();
            if (u94Var instanceof ta4) {
                return ((ta4) u94Var).c();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(u94Var);
            rn3.a(sb, ", ", zd3.b(u94Var.getClass()));
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean X(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                return TypeUtilsKt.p((fx1) aq3Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Y(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                return TypeUtilsKt.q((fx1) aq3Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return false;
        }

        public static boolean Z(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (!(hx1Var instanceof gd4)) {
                return false;
            }
            ((gd4) hx1Var).N0();
            return false;
        }

        public static boolean a(w00 w00Var, fa4 fa4Var, fa4 fa4Var2) {
            fa4Var.getClass();
            fa4Var2.getClass();
            if (!(fa4Var instanceof ea4)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(fa4Var);
                rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
                return false;
            }
            if (fa4Var2 instanceof ea4) {
                return dq1.a(fa4Var, fa4Var2);
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(fa4Var2);
            rn3.a(sb2, ", ", zd3.b(fa4Var2.getClass()));
            return false;
        }

        public static boolean a0(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                z00 v = ((ea4) fa4Var).v();
                return v != null && d.B0(v);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return false;
        }

        public static int b(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                return ((fx1) hx1Var).L0().size();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return 0;
        }

        public static aq3 b0(w00 w00Var, o31 o31Var) {
            o31Var.getClass();
            if (o31Var instanceof l31) {
                return ((l31) o31Var).V0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(o31Var);
            rn3.a(sb, ", ", zd3.b(o31Var.getClass()));
            return null;
        }

        public static t94 c(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                return (t94) aq3Var;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return null;
        }

        public static hx1 c0(w00 w00Var, qw qwVar) {
            qwVar.getClass();
            if (qwVar instanceof gq2) {
                return ((gq2) qwVar).Y0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(qwVar);
            rn3.a(sb, ", ", zd3.b(qwVar.getClass()));
            return null;
        }

        public static qw d(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (!(aq3Var instanceof zp3)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(aq3Var);
                rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
                return null;
            }
            if (aq3Var instanceof cq3) {
                return w00Var.e(((cq3) aq3Var).F0());
            }
            if (aq3Var instanceof gq2) {
                return (gq2) aq3Var;
            }
            return null;
        }

        public static hx1 d0(w00 w00Var, hx1 hx1Var) {
            gd4 b;
            hx1Var.getClass();
            if (hx1Var instanceof gd4) {
                b = x00.b((gd4) hx1Var);
                return b;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return null;
        }

        public static hj0 e(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                if (aq3Var instanceof gj0) {
                    return (gj0) aq3Var;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return null;
        }

        public static TypeCheckerState e0(w00 w00Var, boolean z, boolean z2) {
            return kotlin.reflect.jvm.internal.impl.types.checker.a.b(z, z2, w00Var, null, null, 24, null);
        }

        public static jr0 f(w00 w00Var, o31 o31Var) {
            o31Var.getClass();
            if (o31Var instanceof l31) {
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(o31Var);
            rn3.a(sb, ", ", zd3.b(o31Var.getClass()));
            return null;
        }

        public static aq3 f0(w00 w00Var, hj0 hj0Var) {
            hj0Var.getClass();
            if (hj0Var instanceof gj0) {
                return ((gj0) hj0Var).Z0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hj0Var);
            rn3.a(sb, ", ", zd3.b(hj0Var.getClass()));
            return null;
        }

        public static o31 g(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                gd4 Q0 = ((fx1) hx1Var).Q0();
                if (Q0 instanceof l31) {
                    return (l31) Q0;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return null;
        }

        public static int g0(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                return ((ea4) fa4Var).getParameters().size();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return 0;
        }

        public static jb3 h(w00 w00Var, o31 o31Var) {
            o31Var.getClass();
            if (o31Var instanceof l31) {
                if (o31Var instanceof ib3) {
                    return (ib3) o31Var;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(o31Var);
            rn3.a(sb, ", ", zd3.b(o31Var.getClass()));
            return null;
        }

        public static Collection h0(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            fa4 d = w00Var.d(aq3Var);
            if (d instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) d).j();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return null;
        }

        public static aq3 i(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                gd4 Q0 = ((fx1) hx1Var).Q0();
                if (Q0 instanceof zp3) {
                    return (zp3) Q0;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return null;
        }

        public static u94 i0(w00 w00Var, pw pwVar) {
            pwVar.getClass();
            if (pwVar instanceof NewCapturedTypeConstructor) {
                return ((NewCapturedTypeConstructor) pwVar).e();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(pwVar);
            rn3.a(sb, ", ", zd3.b(pwVar.getClass()));
            return null;
        }

        public static u94 j(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                return TypeUtilsKt.a((fx1) hx1Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static TypeCheckerState.b j0(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                return new C0163a(w00Var, k.c.a((fx1) aq3Var).c());
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return null;
        }

        public static aq3 k(w00 w00Var, aq3 aq3Var, CaptureStatus captureStatus) {
            aq3Var.getClass();
            captureStatus.getClass();
            if (aq3Var instanceof zp3) {
                return kotlin.reflect.jvm.internal.impl.types.checker.d.b((zp3) aq3Var, captureStatus);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return null;
        }

        public static Collection k0(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                Collection c = ((ea4) fa4Var).c();
                c.getClass();
                return c;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return null;
        }

        public static CaptureStatus l(w00 w00Var, qw qwVar) {
            qwVar.getClass();
            if (qwVar instanceof gq2) {
                return ((gq2) qwVar).W0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(qwVar);
            rn3.a(sb, ", ", zd3.b(qwVar.getClass()));
            return null;
        }

        public static pw l0(w00 w00Var, qw qwVar) {
            qwVar.getClass();
            if (qwVar instanceof gq2) {
                return ((gq2) qwVar).N0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(qwVar);
            rn3.a(sb, ", ", zd3.b(qwVar.getClass()));
            return null;
        }

        public static hx1 m(w00 w00Var, aq3 aq3Var, aq3 aq3Var2) {
            aq3Var.getClass();
            aq3Var2.getClass();
            if (!(aq3Var instanceof zp3)) {
                StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
                sb.append(w00Var);
                rn3.a(sb, ", ", zd3.b(w00Var.getClass()));
                return null;
            }
            if (aq3Var2 instanceof zp3) {
                return KotlinTypeFactory.d((zp3) aq3Var, (zp3) aq3Var2);
            }
            StringBuilder sb2 = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb2.append(w00Var);
            rn3.a(sb2, ", ", zd3.b(w00Var.getClass()));
            return null;
        }

        public static fa4 m0(w00 w00Var, aq3 aq3Var) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                return ((zp3) aq3Var).N0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return null;
        }

        public static u94 n(w00 w00Var, hx1 hx1Var, int i) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                return (u94) ((fx1) hx1Var).L0().get(i);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return null;
        }

        public static aq3 n0(w00 w00Var, o31 o31Var) {
            o31Var.getClass();
            if (o31Var instanceof l31) {
                return ((l31) o31Var).W0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(o31Var);
            rn3.a(sb, ", ", zd3.b(o31Var.getClass()));
            return null;
        }

        public static List o(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                return ((fx1) hx1Var).L0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return null;
        }

        public static hx1 o0(w00 w00Var, hx1 hx1Var, boolean z) {
            hx1Var.getClass();
            if (hx1Var instanceof aq3) {
                return w00Var.c((aq3) hx1Var, z);
            }
            if (hx1Var instanceof o31) {
                o31 o31Var = (o31) hx1Var;
                return w00Var.C0(w00Var.c(w00Var.g(o31Var), z), w00Var.c(w00Var.f(o31Var), z));
            }
            fl3.a("sealed");
            return null;
        }

        public static s51 p(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                z00 v = ((ea4) fa4Var).v();
                v.getClass();
                return DescriptorUtilsKt.m((m00) v);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return null;
        }

        public static aq3 p0(w00 w00Var, aq3 aq3Var, boolean z) {
            aq3Var.getClass();
            if (aq3Var instanceof zp3) {
                return ((zp3) aq3Var).R0(z);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(aq3Var);
            rn3.a(sb, ", ", zd3.b(aq3Var.getClass()));
            return null;
        }

        public static ra4 q(w00 w00Var, fa4 fa4Var, int i) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                Object obj = ((ea4) fa4Var).getParameters().get(i);
                obj.getClass();
                return (ra4) obj;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return null;
        }

        public static List r(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                List parameters = ((ea4) fa4Var).getParameters();
                parameters.getClass();
                return parameters;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return null;
        }

        public static PrimitiveType s(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                z00 v = ((ea4) fa4Var).v();
                v.getClass();
                return d.P((m00) v);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return null;
        }

        public static PrimitiveType t(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                z00 v = ((ea4) fa4Var).v();
                v.getClass();
                return d.S((m00) v);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return null;
        }

        public static hx1 u(w00 w00Var, ra4 ra4Var) {
            ra4Var.getClass();
            if (ra4Var instanceof oa4) {
                return TypeUtilsKt.j((oa4) ra4Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(ra4Var);
            rn3.a(sb, ", ", zd3.b(ra4Var.getClass()));
            return null;
        }

        public static hx1 v(w00 w00Var, u94 u94Var) {
            u94Var.getClass();
            if (u94Var instanceof ta4) {
                return ((ta4) u94Var).getType().Q0();
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(u94Var);
            rn3.a(sb, ", ", zd3.b(u94Var.getClass()));
            return null;
        }

        public static ra4 w(w00 w00Var, fa4 fa4Var) {
            fa4Var.getClass();
            if (fa4Var instanceof ea4) {
                z00 v = ((ea4) fa4Var).v();
                if (v instanceof oa4) {
                    return (oa4) v;
                }
                return null;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(fa4Var);
            rn3.a(sb, ", ", zd3.b(fa4Var.getClass()));
            return null;
        }

        public static hx1 x(w00 w00Var, hx1 hx1Var) {
            hx1Var.getClass();
            if (hx1Var instanceof fx1) {
                return vo1.g((fx1) hx1Var);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(hx1Var);
            rn3.a(sb, ", ", zd3.b(hx1Var.getClass()));
            return null;
        }

        public static List y(w00 w00Var, ra4 ra4Var) {
            ra4Var.getClass();
            if (ra4Var instanceof oa4) {
                List upperBounds = ((oa4) ra4Var).getUpperBounds();
                upperBounds.getClass();
                return upperBounds;
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(ra4Var);
            rn3.a(sb, ", ", zd3.b(ra4Var.getClass()));
            return null;
        }

        public static TypeVariance z(w00 w00Var, u94 u94Var) {
            u94Var.getClass();
            if (u94Var instanceof ta4) {
                Variance b = ((ta4) u94Var).b();
                b.getClass();
                return za4.a(b);
            }
            StringBuilder sb = new StringBuilder("ClassicTypeSystemContext couldn't handle: ");
            sb.append(u94Var);
            rn3.a(sb, ", ", zd3.b(u94Var.getClass()));
            return null;
        }
    }

    hx1 C0(aq3 aq3Var, aq3 aq3Var2);

    @Override // defpackage.ya4
    boolean a(aq3 aq3Var);

    @Override // defpackage.ya4
    aq3 b(hx1 hx1Var);

    @Override // defpackage.ya4
    aq3 c(aq3 aq3Var, boolean z);

    @Override // defpackage.ya4
    fa4 d(aq3 aq3Var);

    @Override // defpackage.ya4
    qw e(aq3 aq3Var);

    @Override // defpackage.ya4
    aq3 f(o31 o31Var);

    @Override // defpackage.ya4
    aq3 g(o31 o31Var);
}
