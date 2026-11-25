package defpackage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public final class xu0 {
    public static final xu0 a = new xu0();
    public static final mm2 b = qu0.a;
    public static final mu0 c;
    public static final fx1 d;
    public static final fx1 e;
    public static final o33 f;
    public static final Set g;

    static {
        zo2 l = zo2.l(String.format(ErrorEntity.ERROR_CLASS.b(), Arrays.copyOf(new Object[]{"unknown class"}, 1)));
        l.getClass();
        c = new mu0(l);
        d = d(ErrorTypeKind.v, new String[0]);
        e = d(ErrorTypeKind.x0, new String[0]);
        ru0 ru0Var = new ru0();
        f = ru0Var;
        g = do3.d(ru0Var);
    }

    public static final uu0 a(ErrorScopeKind errorScopeKind, boolean z, String... strArr) {
        errorScopeKind.getClass();
        strArr.getClass();
        return z ? new p44(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length)) : new uu0(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final uu0 b(ErrorScopeKind errorScopeKind, String... strArr) {
        errorScopeKind.getClass();
        strArr.getClass();
        return a(errorScopeKind, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final vu0 d(ErrorTypeKind errorTypeKind, String... strArr) {
        errorTypeKind.getClass();
        strArr.getClass();
        return a.g(errorTypeKind, s20.k(), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final boolean m(ra0 ra0Var) {
        if (ra0Var == null) {
            return false;
        }
        xu0 xu0Var = a;
        return xu0Var.n(ra0Var) || xu0Var.n(ra0Var.b()) || ra0Var == b;
    }

    public static final boolean o(fx1 fx1Var) {
        if (fx1Var == null) {
            return false;
        }
        ea4 N0 = fx1Var.N0();
        return (N0 instanceof wu0) && ((wu0) N0).f() == ErrorTypeKind.y;
    }

    public final vu0 c(ErrorTypeKind errorTypeKind, ea4 ea4Var, String... strArr) {
        errorTypeKind.getClass();
        ea4Var.getClass();
        strArr.getClass();
        return f(errorTypeKind, s20.k(), ea4Var, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final wu0 e(ErrorTypeKind errorTypeKind, String... strArr) {
        errorTypeKind.getClass();
        strArr.getClass();
        return new wu0(errorTypeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final vu0 f(ErrorTypeKind errorTypeKind, List list, ea4 ea4Var, String... strArr) {
        errorTypeKind.getClass();
        list.getClass();
        ea4Var.getClass();
        strArr.getClass();
        return new vu0(ea4Var, b(ErrorScopeKind.ERROR_TYPE_SCOPE, ea4Var.toString()), errorTypeKind, list, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final vu0 g(ErrorTypeKind errorTypeKind, List list, String... strArr) {
        errorTypeKind.getClass();
        list.getClass();
        strArr.getClass();
        return f(errorTypeKind, list, e(errorTypeKind, (String[]) Arrays.copyOf(strArr, strArr.length)), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final mu0 h() {
        return c;
    }

    public final mm2 i() {
        return b;
    }

    public final Set j() {
        return g;
    }

    public final fx1 k() {
        return e;
    }

    public final fx1 l() {
        return d;
    }

    public final boolean n(ra0 ra0Var) {
        return ra0Var instanceof mu0;
    }

    public final String p(fx1 fx1Var) {
        fx1Var.getClass();
        TypeUtilsKt.u(fx1Var);
        ea4 N0 = fx1Var.N0();
        N0.getClass();
        return ((wu0) N0).g(0);
    }
}
