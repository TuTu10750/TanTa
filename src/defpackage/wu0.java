package defpackage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: /tmp/classes2.dex */
public final class wu0 implements ea4 {
    public final ErrorTypeKind a;
    public final String[] b;
    public final String c;

    public wu0(ErrorTypeKind errorTypeKind, String... strArr) {
        errorTypeKind.getClass();
        strArr.getClass();
        this.a = errorTypeKind;
        this.b = strArr;
        String b = ErrorEntity.ERROR_TYPE.b();
        String b2 = errorTypeKind.b();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        this.c = String.format(b, Arrays.copyOf(new Object[]{String.format(b2, Arrays.copyOf(copyOf, copyOf.length))}, 1));
    }

    @Override // defpackage.ea4
    public ea4 a(c cVar) {
        cVar.getClass();
        return this;
    }

    @Override // defpackage.ea4
    /* renamed from: b */
    public z00 v() {
        return xu0.a.h();
    }

    @Override // defpackage.ea4
    public Collection c() {
        return s20.k();
    }

    @Override // defpackage.ea4
    public boolean d() {
        return false;
    }

    public final ErrorTypeKind f() {
        return this.a;
    }

    public final String g(int i) {
        return this.b[i];
    }

    @Override // defpackage.ea4
    public List getParameters() {
        return s20.k();
    }

    @Override // defpackage.ea4
    public d q() {
        return b.h.a();
    }

    public String toString() {
        return this.c;
    }
}
