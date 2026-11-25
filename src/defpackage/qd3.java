package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class qd3 extends fd3 implements wc3, gt1 {
    public final TypeVariable a;

    public qd3(TypeVariable typeVariable) {
        typeVariable.getClass();
        this.a = typeVariable;
    }

    @Override // defpackage.gt1
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public List getUpperBounds() {
        Type[] bounds = this.a.getBounds();
        bounds.getClass();
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new dd3(type));
        }
        dd3 dd3Var = (dd3) b30.A0(arrayList);
        return dq1.a(dd3Var != null ? dd3Var.Q() : null, Object.class) ? s20.k() : arrayList;
    }

    @Override // defpackage.hr1
    public /* bridge */ /* synthetic */ dr1 a(r51 r51Var) {
        return a(r51Var);
    }

    @Override // defpackage.wc3, defpackage.hr1
    public tc3 a(r51 r51Var) {
        Annotation[] declaredAnnotations;
        r51Var.getClass();
        AnnotatedElement x = x();
        if (x == null || (declaredAnnotations = x.getDeclaredAnnotations()) == null) {
            return null;
        }
        return xc3.a(declaredAnnotations, r51Var);
    }

    public boolean equals(Object obj) {
        return (obj instanceof qd3) && dq1.a(this.a, ((qd3) obj).a);
    }

    @Override // defpackage.hr1
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // defpackage.wc3, defpackage.hr1
    public List getAnnotations() {
        Annotation[] declaredAnnotations;
        List b;
        AnnotatedElement x = x();
        return (x == null || (declaredAnnotations = x.getDeclaredAnnotations()) == null || (b = xc3.b(declaredAnnotations)) == null) ? s20.k() : b;
    }

    @Override // defpackage.ns1
    public zo2 getName() {
        zo2 i = zo2.i(this.a.getName());
        i.getClass();
        return i;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.hr1
    public boolean o() {
        return false;
    }

    public String toString() {
        return qd3.class.getName() + ": " + this.a;
    }

    @Override // defpackage.wc3
    public AnnotatedElement x() {
        TypeVariable typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }
}
