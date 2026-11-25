package defpackage;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public final class hl0 extends AbstractTypeAliasDescriptor implements cl0 {
    public final lu3 h;
    public final ProtoBuf$TypeAlias i;
    public final ap2 j;
    public final cb4 k;
    public final fg4 l;
    public final bl0 m;
    public Collection n;
    public zp3 o;
    public zp3 p;
    public List q;
    public zp3 r;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public hl0(defpackage.lu3 r7, defpackage.ra0 r8, defpackage.j8 r9, defpackage.zo2 r10, defpackage.pk0 r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r12, defpackage.ap2 r13, defpackage.cb4 r14, defpackage.fg4 r15, defpackage.bl0 r16) {
        /*
            r6 = this;
            r7.getClass()
            r8.getClass()
            r9.getClass()
            r10.getClass()
            r11.getClass()
            r12.getClass()
            r13.getClass()
            r14.getClass()
            r15.getClass()
            xr3 r4 = defpackage.xr3.a
            r4.getClass()
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r6.h = r7
            r6.i = r12
            r6.j = r13
            r6.k = r14
            r6.l = r15
            r7 = r16
            r6.m = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hl0.<init>(lu3, ra0, j8, zo2, pk0, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias, ap2, cb4, fg4, bl0):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    public List M0() {
        List list = this.q;
        if (list != null) {
            return list;
        }
        dq1.k("typeConstructorParameters");
        return null;
    }

    public ProtoBuf$TypeAlias O0() {
        return this.i;
    }

    public fg4 P0() {
        return this.l;
    }

    public final void Q0(List list, zp3 zp3Var, zp3 zp3Var2) {
        list.getClass();
        zp3Var.getClass();
        zp3Var2.getClass();
        N0(list);
        this.o = zp3Var;
        this.p = zp3Var2;
        this.q = TypeParameterUtilsKt.d(this);
        this.r = F0();
        this.n = L0();
    }

    @Override // defpackage.cl0
    public cb4 R() {
        return this.k;
    }

    @Override // defpackage.vw3
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public r94 c(TypeSubstitutor typeSubstitutor) {
        typeSubstitutor.getClass();
        if (typeSubstitutor.k()) {
            return this;
        }
        lu3 g0 = g0();
        ra0 b = b();
        b.getClass();
        j8 annotations = getAnnotations();
        annotations.getClass();
        zo2 name = getName();
        name.getClass();
        hl0 hl0Var = new hl0(g0, b, annotations, name, getVisibility(), O0(), Z(), R(), P0(), c0());
        List w = w();
        zp3 f0 = f0();
        Variance variance = Variance.INVARIANT;
        fx1 n = typeSubstitutor.n(f0, variance);
        n.getClass();
        zp3 a = xa4.a(n);
        fx1 n2 = typeSubstitutor.n(U(), variance);
        n2.getClass();
        hl0Var.Q0(w, a, xa4.a(n2));
        return hl0Var;
    }

    @Override // defpackage.r94
    public zp3 U() {
        zp3 zp3Var = this.p;
        if (zp3Var != null) {
            return zp3Var;
        }
        dq1.k("expandedType");
        return null;
    }

    @Override // defpackage.cl0
    public ap2 Z() {
        return this.j;
    }

    @Override // defpackage.cl0
    public bl0 c0() {
        return this.m;
    }

    @Override // defpackage.r94
    public zp3 f0() {
        zp3 zp3Var = this.o;
        if (zp3Var != null) {
            return zp3Var;
        }
        dq1.k("underlyingType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
    public lu3 g0() {
        return this.h;
    }

    @Override // defpackage.r94
    public m00 t() {
        if (gx1.a(U())) {
            return null;
        }
        z00 v = U().N0().v();
        if (v instanceof m00) {
            return (m00) v;
        }
        return null;
    }

    @Override // defpackage.z00
    public zp3 u() {
        zp3 zp3Var = this.r;
        if (zp3Var != null) {
            return zp3Var;
        }
        dq1.k("defaultTypeImpl");
        return null;
    }
}
