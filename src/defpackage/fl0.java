package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

/* loaded from: /tmp/classes2.dex */
public final class fl0 extends p33 implements yk0 {
    public final ProtoBuf$Property C;
    public final ap2 D;
    public final cb4 E;
    public final fg4 F;
    public final bl0 G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fl0(ra0 ra0Var, o33 o33Var, j8 j8Var, Modality modality, pk0 pk0Var, boolean z, zo2 zo2Var, CallableMemberDescriptor.Kind kind, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ProtoBuf$Property protoBuf$Property, ap2 ap2Var, cb4 cb4Var, fg4 fg4Var, bl0 bl0Var) {
        super(ra0Var, o33Var, j8Var, modality, pk0Var, z, zo2Var, kind, xr3.a, z2, z3, z6, false, z4, z5);
        ra0Var.getClass();
        j8Var.getClass();
        modality.getClass();
        pk0Var.getClass();
        zo2Var.getClass();
        kind.getClass();
        protoBuf$Property.getClass();
        ap2Var.getClass();
        cb4Var.getClass();
        fg4Var.getClass();
        this.C = protoBuf$Property;
        this.D = ap2Var;
        this.E = cb4Var;
        this.F = fg4Var;
        this.G = bl0Var;
    }

    @Override // defpackage.p33
    public p33 P0(ra0 ra0Var, Modality modality, pk0 pk0Var, o33 o33Var, CallableMemberDescriptor.Kind kind, zo2 zo2Var, xr3 xr3Var) {
        ra0Var.getClass();
        modality.getClass();
        pk0Var.getClass();
        kind.getClass();
        zo2Var.getClass();
        xr3Var.getClass();
        return new fl0(ra0Var, o33Var, getAnnotations(), modality, pk0Var, i0(), zo2Var, kind, q0(), z(), isExternal(), N(), K(), D(), Z(), R(), g1(), c0());
    }

    @Override // defpackage.cl0
    public cb4 R() {
        return this.E;
    }

    @Override // defpackage.cl0
    public ap2 Z() {
        return this.D;
    }

    @Override // defpackage.cl0
    public bl0 c0() {
        return this.G;
    }

    @Override // defpackage.cl0
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Property D() {
        return this.C;
    }

    public fg4 g1() {
        return this.F;
    }

    @Override // defpackage.p33, defpackage.ck2
    public boolean isExternal() {
        Boolean d = e31.D.d(D().a0());
        d.getClass();
        return d.booleanValue();
    }
}
