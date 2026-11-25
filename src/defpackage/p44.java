package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;

/* loaded from: /tmp/classes2.dex */
public final class p44 extends uu0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p44(ErrorScopeKind errorScopeKind, String... strArr) {
        super(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
        errorScopeKind.getClass();
        strArr.getClass();
    }

    @Override // defpackage.uu0, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set b() {
        throw new IllegalStateException();
    }

    @Override // defpackage.uu0, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set d() {
        throw new IllegalStateException();
    }

    @Override // defpackage.uu0, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public z00 e(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        throw new IllegalStateException(j() + ", required name: " + zo2Var);
    }

    @Override // defpackage.uu0, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public Collection f(hk0 hk0Var, n81 n81Var) {
        hk0Var.getClass();
        n81Var.getClass();
        throw new IllegalStateException(j());
    }

    @Override // defpackage.uu0, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set g() {
        throw new IllegalStateException();
    }

    @Override // defpackage.uu0, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    /* renamed from: h */
    public Set a(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        throw new IllegalStateException(j() + ", required name: " + zo2Var);
    }

    @Override // defpackage.uu0, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    /* renamed from: i */
    public Set c(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        throw new IllegalStateException(j() + ", required name: " + zo2Var);
    }

    @Override // defpackage.uu0
    public String toString() {
        return "ThrowingScope{" + j() + '}';
    }
}
