package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;

/* loaded from: /tmp/classes2.dex */
public class uu0 implements MemberScope {
    public final ErrorScopeKind b;
    public final String c;

    public uu0(ErrorScopeKind errorScopeKind, String... strArr) {
        errorScopeKind.getClass();
        strArr.getClass();
        this.b = errorScopeKind;
        String b = errorScopeKind.b();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        this.c = String.format(b, Arrays.copyOf(copyOf, copyOf.length));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set b() {
        return eo3.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set d() {
        return eo3.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public z00 e(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        zo2 l = zo2.l(String.format(ErrorEntity.ERROR_CLASS.b(), Arrays.copyOf(new Object[]{zo2Var}, 1)));
        l.getClass();
        return new mu0(l);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public Collection f(hk0 hk0Var, n81 n81Var) {
        hk0Var.getClass();
        n81Var.getClass();
        return s20.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set g() {
        return eo3.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set a(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return do3.d(new ou0(xu0.a.h()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Set c(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        return xu0.a.j();
    }

    public final String j() {
        return this.c;
    }

    public String toString() {
        return "ErrorScope{" + this.c + '}';
    }
}
