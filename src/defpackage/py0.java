package defpackage;

import java.util.HashSet;
import kotlin.reflect.jvm.internal.impl.types.m;

/* loaded from: /tmp/classes2.dex */
public abstract class py0 {
    public static final hx1 a(m mVar, hx1 hx1Var) {
        mVar.getClass();
        hx1Var.getClass();
        return b(mVar, hx1Var, new HashSet());
    }

    public static final hx1 b(m mVar, hx1 hx1Var, HashSet hashSet) {
        hx1 b;
        fa4 m0 = mVar.m0(hx1Var);
        if (!hashSet.add(m0)) {
            return null;
        }
        ra4 M = mVar.M(m0);
        if (M != null) {
            hx1 b0 = mVar.b0(M);
            hx1 b2 = b(mVar, b0, hashSet);
            if (b2 != null) {
                return ((b2 instanceof aq3) && mVar.S((aq3) b2) && mVar.A0(hx1Var) && (mVar.w(mVar.m0(b0)) || ((b0 instanceof aq3) && mVar.S((aq3) b0)))) ? mVar.Z(b0) : (mVar.A0(b2) || !mVar.z0(hx1Var)) ? b2 : mVar.Z(b2);
            }
            return null;
        }
        if (mVar.w(m0)) {
            hx1 a0 = mVar.a0(hx1Var);
            if (a0 == null || (b = b(mVar, a0, hashSet)) == null) {
                return null;
            }
            if (!mVar.A0(hx1Var)) {
                return b;
            }
            if (!mVar.A0(b) && (!(b instanceof aq3) || !mVar.S((aq3) b))) {
                return mVar.Z(b);
            }
        }
        return hx1Var;
    }
}
