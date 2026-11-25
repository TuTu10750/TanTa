package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public final class ip3 extends AbstractSignatureParts {
    public final a8 a;
    public final boolean b;
    public final ey1 c;
    public final AnnotationQualifierApplicabilityType d;
    public final boolean e;

    public ip3(a8 a8Var, boolean z, ey1 ey1Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2) {
        ey1Var.getClass();
        annotationQualifierApplicabilityType.getClass();
        this.a = a8Var;
        this.b = z;
        this.c = ey1Var;
        this.d = annotationQualifierApplicabilityType;
        this.e = z2;
    }

    public /* synthetic */ ip3(a8 a8Var, boolean z, ey1 ey1Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(a8Var, z, ey1Var, annotationQualifierApplicabilityType, (i & 16) != 0 ? false : z2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean A(hx1 hx1Var) {
        hx1Var.getClass();
        return ((fx1) hx1Var).Q0() instanceof zq2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public boolean h(d8 d8Var, hx1 hx1Var) {
        d8Var.getClass();
        if ((d8Var instanceof o03) && ((o03) d8Var).n()) {
            return true;
        }
        if ((d8Var instanceof LazyJavaAnnotationDescriptor) && !p() && (((LazyJavaAnnotationDescriptor) d8Var).i() || m() == AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS)) {
            return true;
        }
        return hx1Var != null && d.q0((fx1) hx1Var) && i().m(d8Var) && !this.c.a().q().c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public h8 i() {
        return this.c.a().a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public fx1 q(hx1 hx1Var) {
        hx1Var.getClass();
        return hb4.a((fx1) hx1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public ab4 v() {
        return qp3.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable j(hx1 hx1Var) {
        hx1Var.getClass();
        return ((fx1) hx1Var).getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public Iterable l() {
        j8 annotations;
        a8 a8Var = this.a;
        return (a8Var == null || (annotations = a8Var.getAnnotations()) == null) ? s20.k() : annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public AnnotationQualifierApplicabilityType m() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public it1 n() {
        return this.c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean o() {
        a8 a8Var = this.a;
        return (a8Var instanceof h) && ((h) a8Var).j0() != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean p() {
        return this.c.a().q().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public s51 s(hx1 hx1Var) {
        hx1Var.getClass();
        m00 f = n.f((fx1) hx1Var);
        if (f != null) {
            return lk0.m(f);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean u() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean w(hx1 hx1Var) {
        hx1Var.getClass();
        return d.e0((fx1) hx1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean x() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean y(hx1 hx1Var, hx1 hx1Var2) {
        hx1Var.getClass();
        hx1Var2.getClass();
        return this.c.a().k().b((fx1) hx1Var, (fx1) hx1Var2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.AbstractSignatureParts
    public boolean z(ra4 ra4Var) {
        ra4Var.getClass();
        return ra4Var instanceof gy1;
    }
}
