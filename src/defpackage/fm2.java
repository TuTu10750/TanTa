package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.l;

/* loaded from: /tmp/classes2.dex */
public abstract class fm2 implements m00 {
    public static final a a = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope a(m00 m00Var, l lVar, c cVar) {
            MemberScope H;
            m00Var.getClass();
            lVar.getClass();
            cVar.getClass();
            fm2 fm2Var = m00Var instanceof fm2 ? (fm2) m00Var : null;
            if (fm2Var != null && (H = fm2Var.H(lVar, cVar)) != null) {
                return H;
            }
            MemberScope a0 = m00Var.a0(lVar);
            a0.getClass();
            return a0;
        }

        public final MemberScope b(m00 m00Var, c cVar) {
            MemberScope z0;
            m00Var.getClass();
            cVar.getClass();
            fm2 fm2Var = m00Var instanceof fm2 ? (fm2) m00Var : null;
            if (fm2Var != null && (z0 = fm2Var.z0(cVar)) != null) {
                return z0;
            }
            MemberScope D0 = m00Var.D0();
            D0.getClass();
            return D0;
        }
    }

    public abstract MemberScope H(l lVar, c cVar);

    public abstract MemberScope z0(c cVar);
}
