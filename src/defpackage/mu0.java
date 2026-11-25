package defpackage;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.l;

/* loaded from: /tmp/classes2.dex */
public final class mu0 extends p00 {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public mu0(defpackage.zo2 r13) {
        /*
            r12 = this;
            r13.getClass()
            xu0 r0 = defpackage.xu0.a
            mm2 r2 = r0.i()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
            java.util.List r6 = defpackage.s20.k()
            xr3 r7 = defpackage.xr3.a
            r8 = 0
            lu3 r9 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.e
            r1 = r12
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            j8$a r12 = defpackage.j8.a0
            j8 r12 = r12.b()
            r13 = 1
            j00 r12 = defpackage.j00.n1(r1, r12, r13, r7)
            java.util.List r13 = defpackage.s20.k()
            pk0 r2 = defpackage.ok0.d
            r12.q1(r13, r2)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind r13 = kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.SCOPE_FOR_ERROR_CLASS
            zo2 r2 = r12.getName()
            java.lang.String r2 = r2.toString()
            r2.getClass()
            java.lang.String r3 = ""
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
            uu0 r5 = defpackage.xu0.b(r13, r2)
            vu0 r3 = new vu0
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r6 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.y0
            r13 = 0
            java.lang.String[] r2 = new java.lang.String[r13]
            wu0 r4 = r0.e(r6, r2)
            java.lang.String[] r9 = new java.lang.String[r13]
            r10 = 24
            r11 = 0
            r7 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r12.g1(r3)
            java.util.Set r13 = defpackage.do3.d(r12)
            r1.K0(r5, r13, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mu0.<init>(zo2):void");
    }

    @Override // defpackage.g1, defpackage.vw3
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public m00 c(TypeSubstitutor typeSubstitutor) {
        typeSubstitutor.getClass();
        return this;
    }

    @Override // defpackage.g1, defpackage.fm2
    public MemberScope H(l lVar, c cVar) {
        lVar.getClass();
        cVar.getClass();
        ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ERROR_CLASS;
        String zo2Var = getName().toString();
        zo2Var.getClass();
        return xu0.b(errorScopeKind, zo2Var, lVar.toString());
    }

    @Override // defpackage.p00
    public String toString() {
        String b = getName().b();
        b.getClass();
        return b;
    }
}
