package defpackage;

import defpackage.pd3;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* loaded from: /tmp/classes2.dex */
public final class sd3 extends pd3 implements pt1 {
    public final WildcardType b;
    public final Collection c;
    public final boolean d;

    public sd3(WildcardType wildcardType) {
        wildcardType.getClass();
        this.b = wildcardType;
        this.c = s20.k();
    }

    @Override // defpackage.pt1
    public boolean J() {
        Q().getUpperBounds().getClass();
        return !dq1.a(rb.F(r1), Object.class);
    }

    @Override // defpackage.pt1
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public pd3 D() {
        Type[] upperBounds = Q().getUpperBounds();
        Type[] lowerBounds = Q().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + Q());
        }
        if (lowerBounds.length == 1) {
            pd3.a aVar = pd3.a;
            Object W = rb.W(lowerBounds);
            W.getClass();
            return aVar.a((Type) W);
        }
        if (upperBounds.length == 1) {
            Type type = (Type) rb.W(upperBounds);
            if (!dq1.a(type, Object.class)) {
                pd3.a aVar2 = pd3.a;
                type.getClass();
                return aVar2.a(type);
            }
        }
        return null;
    }

    @Override // defpackage.pd3
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public WildcardType Q() {
        return this.b;
    }

    @Override // defpackage.hr1
    public Collection getAnnotations() {
        return this.c;
    }

    @Override // defpackage.hr1
    public boolean o() {
        return this.d;
    }
}
