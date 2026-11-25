package defpackage;

import defpackage.yl4;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: /tmp/classes2.dex */
public abstract class jd3 extends fd3 implements wc3, ld3, js1 {
    @Override // defpackage.js1
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public ReflectJavaClass P() {
        Class<?> declaringClass = R().getDeclaringClass();
        declaringClass.getClass();
        return new ReflectJavaClass(declaringClass);
    }

    public abstract Member R();

    public final List S(Type[] typeArr, Annotation[][] annotationArr, boolean z) {
        String str;
        typeArr.getClass();
        annotationArr.getClass();
        ArrayList arrayList = new ArrayList(typeArr.length);
        List b = cr1.a.b(R());
        int size = b != null ? b.size() - typeArr.length : 0;
        int length = typeArr.length;
        int i = 0;
        while (i < length) {
            pd3 a = pd3.a.a(typeArr[i]);
            if (b != null) {
                str = (String) b30.e0(b, i + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i + '+' + size + " (name=" + getName() + " type=" + a + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new rd3(a, annotationArr[i], str, z && i == rb.G(typeArr)));
            i++;
        }
        return arrayList;
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
        return (obj instanceof jd3) && dq1.a(R(), ((jd3) obj).R());
    }

    @Override // defpackage.ls1
    public boolean f() {
        return Modifier.isStatic(getModifiers());
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

    @Override // defpackage.ld3
    public int getModifiers() {
        return R().getModifiers();
    }

    @Override // defpackage.ns1
    public zo2 getName() {
        String name = R().getName();
        zo2 i = name != null ? zo2.i(name) : null;
        return i == null ? ls3.b : i;
    }

    @Override // defpackage.ls1
    public am4 getVisibility() {
        int modifiers = getModifiers();
        return Modifier.isPublic(modifiers) ? yl4.h.c : Modifier.isPrivate(modifiers) ? yl4.e.c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? ot1.c : nt1.c : mt1.c;
    }

    public int hashCode() {
        return R().hashCode();
    }

    @Override // defpackage.ls1
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // defpackage.ls1
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // defpackage.hr1
    public boolean o() {
        return false;
    }

    public String toString() {
        return getClass().getName() + ": " + R();
    }

    @Override // defpackage.wc3
    public AnnotatedElement x() {
        Member R = R();
        R.getClass();
        return (AnnotatedElement) R;
    }
}
