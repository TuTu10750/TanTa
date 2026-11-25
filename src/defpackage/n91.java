package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;

/* loaded from: /tmp/classes2.dex */
public final class n91 extends GivenFunctionsMemberScope {

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            try {
                iArr[FunctionClassKind.f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FunctionClassKind.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n91(lu3 lu3Var, m91 m91Var) {
        super(lu3Var, m91Var);
        lu3Var.getClass();
        m91Var.getClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    public List i() {
        m00 l = l();
        l.getClass();
        int i = a.a[((m91) l).U0().ordinal()];
        return i != 1 ? i != 2 ? s20.k() : r20.e(o91.E.a((m91) l(), true)) : r20.e(o91.E.a((m91) l(), false));
    }
}
