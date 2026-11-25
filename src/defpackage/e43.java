package defpackage;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;

/* loaded from: /tmp/classes2.dex */
public abstract class e43 {
    public static final ProtoBuf$Type a(ProtoBuf$Type protoBuf$Type, cb4 cb4Var) {
        protoBuf$Type.getClass();
        cb4Var.getClass();
        if (protoBuf$Type.j0()) {
            return protoBuf$Type.R();
        }
        if (protoBuf$Type.k0()) {
            return cb4Var.a(protoBuf$Type.S());
        }
        return null;
    }

    public static final List b(ProtoBuf$Class protoBuf$Class, cb4 cb4Var) {
        protoBuf$Class.getClass();
        cb4Var.getClass();
        List x0 = protoBuf$Class.x0();
        if (x0.isEmpty()) {
            x0 = null;
        }
        if (x0 == null) {
            List<Integer> w0 = protoBuf$Class.w0();
            w0.getClass();
            x0 = new ArrayList(t20.v(w0, 10));
            for (Integer num : w0) {
                num.getClass();
                x0.add(cb4Var.a(num.intValue()));
            }
        }
        return x0;
    }

    public static final List c(ProtoBuf$Function protoBuf$Function, cb4 cb4Var) {
        protoBuf$Function.getClass();
        cb4Var.getClass();
        List Y = protoBuf$Function.Y();
        if (Y.isEmpty()) {
            Y = null;
        }
        if (Y == null) {
            List<Integer> X = protoBuf$Function.X();
            X.getClass();
            Y = new ArrayList(t20.v(X, 10));
            for (Integer num : X) {
                num.getClass();
                Y.add(cb4Var.a(num.intValue()));
            }
        }
        return Y;
    }

    public static final List d(ProtoBuf$Property protoBuf$Property, cb4 cb4Var) {
        protoBuf$Property.getClass();
        cb4Var.getClass();
        List X = protoBuf$Property.X();
        if (X.isEmpty()) {
            X = null;
        }
        if (X == null) {
            List<Integer> W = protoBuf$Property.W();
            W.getClass();
            X = new ArrayList(t20.v(W, 10));
            for (Integer num : W) {
                num.getClass();
                X.add(cb4Var.a(num.intValue()));
            }
        }
        return X;
    }

    public static final ProtoBuf$Type e(ProtoBuf$TypeAlias protoBuf$TypeAlias, cb4 cb4Var) {
        protoBuf$TypeAlias.getClass();
        cb4Var.getClass();
        if (protoBuf$TypeAlias.d0()) {
            ProtoBuf$Type T = protoBuf$TypeAlias.T();
            T.getClass();
            return T;
        }
        if (protoBuf$TypeAlias.e0()) {
            return cb4Var.a(protoBuf$TypeAlias.U());
        }
        fl3.a("No expandedType in ProtoBuf.TypeAlias");
        return null;
    }

    public static final ProtoBuf$Type f(ProtoBuf$Type protoBuf$Type, cb4 cb4Var) {
        protoBuf$Type.getClass();
        cb4Var.getClass();
        if (protoBuf$Type.o0()) {
            return protoBuf$Type.b0();
        }
        if (protoBuf$Type.p0()) {
            return cb4Var.a(protoBuf$Type.c0());
        }
        return null;
    }

    public static final boolean g(ProtoBuf$Function protoBuf$Function) {
        protoBuf$Function.getClass();
        return protoBuf$Function.v0() || protoBuf$Function.w0();
    }

    public static final boolean h(ProtoBuf$Property protoBuf$Property) {
        protoBuf$Property.getClass();
        return protoBuf$Property.s0() || protoBuf$Property.t0();
    }

    public static final ProtoBuf$Type i(ProtoBuf$Class protoBuf$Class, cb4 cb4Var) {
        protoBuf$Class.getClass();
        cb4Var.getClass();
        if (protoBuf$Class.o1()) {
            return protoBuf$Class.J0();
        }
        if (protoBuf$Class.p1()) {
            return cb4Var.a(protoBuf$Class.K0());
        }
        return null;
    }

    public static final ProtoBuf$Type j(ProtoBuf$Type protoBuf$Type, cb4 cb4Var) {
        protoBuf$Type.getClass();
        cb4Var.getClass();
        if (protoBuf$Type.r0()) {
            return protoBuf$Type.e0();
        }
        if (protoBuf$Type.s0()) {
            return cb4Var.a(protoBuf$Type.f0());
        }
        return null;
    }

    public static final ProtoBuf$Type k(ProtoBuf$Function protoBuf$Function, cb4 cb4Var) {
        protoBuf$Function.getClass();
        cb4Var.getClass();
        if (protoBuf$Function.v0()) {
            return protoBuf$Function.f0();
        }
        if (protoBuf$Function.w0()) {
            return cb4Var.a(protoBuf$Function.g0());
        }
        return null;
    }

    public static final ProtoBuf$Type l(ProtoBuf$Property protoBuf$Property, cb4 cb4Var) {
        protoBuf$Property.getClass();
        cb4Var.getClass();
        if (protoBuf$Property.s0()) {
            return protoBuf$Property.e0();
        }
        if (protoBuf$Property.t0()) {
            return cb4Var.a(protoBuf$Property.f0());
        }
        return null;
    }

    public static final ProtoBuf$Type m(ProtoBuf$Function protoBuf$Function, cb4 cb4Var) {
        protoBuf$Function.getClass();
        cb4Var.getClass();
        if (protoBuf$Function.x0()) {
            ProtoBuf$Type h0 = protoBuf$Function.h0();
            h0.getClass();
            return h0;
        }
        if (protoBuf$Function.y0()) {
            return cb4Var.a(protoBuf$Function.i0());
        }
        fl3.a("No returnType in ProtoBuf.Function");
        return null;
    }

    public static final ProtoBuf$Type n(ProtoBuf$Property protoBuf$Property, cb4 cb4Var) {
        protoBuf$Property.getClass();
        cb4Var.getClass();
        if (protoBuf$Property.u0()) {
            ProtoBuf$Type g0 = protoBuf$Property.g0();
            g0.getClass();
            return g0;
        }
        if (protoBuf$Property.v0()) {
            return cb4Var.a(protoBuf$Property.h0());
        }
        fl3.a("No returnType in ProtoBuf.Property");
        return null;
    }

    public static final List o(ProtoBuf$Class protoBuf$Class, cb4 cb4Var) {
        protoBuf$Class.getClass();
        cb4Var.getClass();
        List a1 = protoBuf$Class.a1();
        if (a1.isEmpty()) {
            a1 = null;
        }
        if (a1 == null) {
            List<Integer> Z0 = protoBuf$Class.Z0();
            Z0.getClass();
            a1 = new ArrayList(t20.v(Z0, 10));
            for (Integer num : Z0) {
                num.getClass();
                a1.add(cb4Var.a(num.intValue()));
            }
        }
        return a1;
    }

    public static final ProtoBuf$Type p(ProtoBuf$Type.Argument argument, cb4 cb4Var) {
        argument.getClass();
        cb4Var.getClass();
        if (argument.B()) {
            return argument.y();
        }
        if (argument.C()) {
            return cb4Var.a(argument.z());
        }
        return null;
    }

    public static final ProtoBuf$Type q(ProtoBuf$ValueParameter protoBuf$ValueParameter, cb4 cb4Var) {
        protoBuf$ValueParameter.getClass();
        cb4Var.getClass();
        if (protoBuf$ValueParameter.S()) {
            ProtoBuf$Type M = protoBuf$ValueParameter.M();
            M.getClass();
            return M;
        }
        if (protoBuf$ValueParameter.T()) {
            return cb4Var.a(protoBuf$ValueParameter.N());
        }
        fl3.a("No type in ProtoBuf.ValueParameter");
        return null;
    }

    public static final ProtoBuf$Type r(ProtoBuf$TypeAlias protoBuf$TypeAlias, cb4 cb4Var) {
        protoBuf$TypeAlias.getClass();
        cb4Var.getClass();
        if (protoBuf$TypeAlias.h0()) {
            ProtoBuf$Type a0 = protoBuf$TypeAlias.a0();
            a0.getClass();
            return a0;
        }
        if (protoBuf$TypeAlias.i0()) {
            return cb4Var.a(protoBuf$TypeAlias.b0());
        }
        fl3.a("No underlyingType in ProtoBuf.TypeAlias");
        return null;
    }

    public static final List s(ProtoBuf$TypeParameter protoBuf$TypeParameter, cb4 cb4Var) {
        protoBuf$TypeParameter.getClass();
        cb4Var.getClass();
        List S = protoBuf$TypeParameter.S();
        if (S.isEmpty()) {
            S = null;
        }
        if (S == null) {
            List<Integer> R = protoBuf$TypeParameter.R();
            R.getClass();
            S = new ArrayList(t20.v(R, 10));
            for (Integer num : R) {
                num.getClass();
                S.add(cb4Var.a(num.intValue()));
            }
        }
        return S;
    }

    public static final ProtoBuf$Type t(ProtoBuf$ValueParameter protoBuf$ValueParameter, cb4 cb4Var) {
        protoBuf$ValueParameter.getClass();
        cb4Var.getClass();
        if (protoBuf$ValueParameter.U()) {
            return protoBuf$ValueParameter.O();
        }
        if (protoBuf$ValueParameter.V()) {
            return cb4Var.a(protoBuf$ValueParameter.P());
        }
        return null;
    }
}
