package defpackage;

import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public final class p31 extends l31 implements gb4 {
    public final l31 d;
    public final fx1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p31(l31 l31Var, fx1 fx1Var) {
        super(l31Var.V0(), l31Var.W0());
        l31Var.getClass();
        fx1Var.getClass();
        this.d = l31Var;
        this.e = fx1Var;
    }

    @Override // defpackage.gb4
    public fx1 H() {
        return this.e;
    }

    @Override // defpackage.gd4
    public gd4 R0(boolean z) {
        return hb4.d(F0().R0(z), H().Q0().R0(z));
    }

    @Override // defpackage.gd4
    public gd4 T0(j jVar) {
        jVar.getClass();
        return hb4.d(F0().T0(jVar), H());
    }

    @Override // defpackage.l31
    public zp3 U0() {
        return F0().U0();
    }

    @Override // defpackage.l31
    public String X0(DescriptorRenderer descriptorRenderer, b bVar) {
        descriptorRenderer.getClass();
        bVar.getClass();
        return bVar.f() ? descriptorRenderer.w(H()) : F0().X0(descriptorRenderer, bVar);
    }

    @Override // defpackage.gb4
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public l31 F0() {
        return this.d;
    }

    @Override // defpackage.gd4
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public p31 X0(c cVar) {
        cVar.getClass();
        fx1 a = cVar.a(F0());
        a.getClass();
        return new p31((l31) a, cVar.a(H()));
    }

    @Override // defpackage.l31
    public String toString() {
        return "[@EnhancedForWarnings(" + H() + ")] " + F0();
    }
}
