package defpackage;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.j;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;

/* loaded from: /tmp/classes2.dex */
public final class gq2 extends zp3 implements qw {
    public final CaptureStatus b;
    public final NewCapturedTypeConstructor c;
    public final gd4 d;
    public final j e;
    public final boolean f;
    public final boolean g;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public gq2(kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus r10, defpackage.gd4 r11, defpackage.ta4 r12, defpackage.oa4 r13) {
        /*
            r9 = this;
            r10.getClass()
            r12.getClass()
            r13.getClass()
            kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor r0 = new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            r1 = r12
            r4 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7 = 56
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r1 = r10
            r3 = r11
            r2 = r0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gq2.<init>(kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus, gd4, ta4, oa4):void");
    }

    public gq2(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, gd4 gd4Var, j jVar, boolean z, boolean z2) {
        captureStatus.getClass();
        newCapturedTypeConstructor.getClass();
        jVar.getClass();
        this.b = captureStatus;
        this.c = newCapturedTypeConstructor;
        this.d = gd4Var;
        this.e = jVar;
        this.f = z;
        this.g = z2;
    }

    public /* synthetic */ gq2(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, gd4 gd4Var, j jVar, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureStatus, newCapturedTypeConstructor, gd4Var, (i & 8) != 0 ? j.b.h() : jVar, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    @Override // defpackage.fx1
    public List L0() {
        return s20.k();
    }

    @Override // defpackage.fx1
    public j M0() {
        return this.e;
    }

    @Override // defpackage.fx1
    public boolean O0() {
        return this.f;
    }

    @Override // defpackage.gd4
    /* renamed from: V0 */
    public zp3 T0(j jVar) {
        jVar.getClass();
        return new gq2(this.b, N0(), this.d, jVar, O0(), this.g);
    }

    public final CaptureStatus W0() {
        return this.b;
    }

    @Override // defpackage.fx1
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public NewCapturedTypeConstructor N0() {
        return this.c;
    }

    public final gd4 Y0() {
        return this.d;
    }

    public final boolean Z0() {
        return this.g;
    }

    @Override // defpackage.zp3
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public gq2 R0(boolean z) {
        return new gq2(this.b, N0(), this.d, M0(), z, false, 32, null);
    }

    @Override // defpackage.gd4
    /* renamed from: b1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public gq2 X0(c cVar) {
        cVar.getClass();
        CaptureStatus captureStatus = this.b;
        NewCapturedTypeConstructor a = N0().a(cVar);
        gd4 gd4Var = this.d;
        return new gq2(captureStatus, a, gd4Var != null ? cVar.a(gd4Var).Q0() : null, M0(), O0(), false, 32, null);
    }

    @Override // defpackage.fx1
    public MemberScope s() {
        return xu0.a(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }
}
