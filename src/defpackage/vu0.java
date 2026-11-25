package defpackage;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public final class vu0 extends zp3 {
    public final ea4 b;
    public final MemberScope c;
    public final ErrorTypeKind d;
    public final List e;
    public final boolean f;
    public final String[] g;
    public final String h;

    public vu0(ea4 ea4Var, MemberScope memberScope, ErrorTypeKind errorTypeKind, List list, boolean z, String... strArr) {
        ea4Var.getClass();
        memberScope.getClass();
        errorTypeKind.getClass();
        list.getClass();
        strArr.getClass();
        this.b = ea4Var;
        this.c = memberScope;
        this.d = errorTypeKind;
        this.e = list;
        this.f = z;
        this.g = strArr;
        ov3 ov3Var = ov3.a;
        String b = errorTypeKind.b();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        this.h = String.format(b, Arrays.copyOf(copyOf, copyOf.length));
    }

    public /* synthetic */ vu0(ea4 ea4Var, MemberScope memberScope, ErrorTypeKind errorTypeKind, List list, boolean z, String[] strArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ea4Var, memberScope, errorTypeKind, (i & 8) != 0 ? s20.k() : list, (i & 16) != 0 ? false : z, strArr);
    }

    @Override // defpackage.fx1
    public List L0() {
        return this.e;
    }

    @Override // defpackage.fx1
    public j M0() {
        return j.b.h();
    }

    @Override // defpackage.fx1
    public ea4 N0() {
        return this.b;
    }

    @Override // defpackage.fx1
    public boolean O0() {
        return this.f;
    }

    @Override // defpackage.gd4
    /* renamed from: U0 */
    public zp3 R0(boolean z) {
        ea4 N0 = N0();
        MemberScope s = s();
        ErrorTypeKind errorTypeKind = this.d;
        List L0 = L0();
        String[] strArr = this.g;
        return new vu0(N0, s, errorTypeKind, L0, z, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // defpackage.gd4
    /* renamed from: V0 */
    public zp3 T0(j jVar) {
        jVar.getClass();
        return this;
    }

    public final String W0() {
        return this.h;
    }

    public final ErrorTypeKind X0() {
        return this.d;
    }

    @Override // defpackage.gd4
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public vu0 X0(c cVar) {
        cVar.getClass();
        return this;
    }

    public final vu0 Z0(List list) {
        list.getClass();
        ea4 N0 = N0();
        MemberScope s = s();
        ErrorTypeKind errorTypeKind = this.d;
        boolean O0 = O0();
        String[] strArr = this.g;
        return new vu0(N0, s, errorTypeKind, list, O0, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // defpackage.fx1
    public MemberScope s() {
        return this.c;
    }
}
