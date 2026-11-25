package defpackage;

import defpackage.uc3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: /tmp/classes2.dex */
public final class tc3 extends fd3 implements dr1 {
    public final Annotation a;

    public tc3(Annotation annotation) {
        annotation.getClass();
        this.a = annotation;
    }

    public final Annotation Q() {
        return this.a;
    }

    @Override // defpackage.dr1
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public ReflectJavaClass A() {
        return new ReflectJavaClass(wu1.b(wu1.a(this.a)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof tc3) && this.a == ((tc3) obj).a;
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }

    @Override // defpackage.dr1
    public Collection j() {
        Method[] declaredMethods = wu1.b(wu1.a(this.a)).getDeclaredMethods();
        declaredMethods.getClass();
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            uc3.a aVar = uc3.b;
            Object invoke = method.invoke(this.a, null);
            invoke.getClass();
            arrayList.add(aVar.a(invoke, zo2.i(method.getName())));
        }
        return arrayList;
    }

    @Override // defpackage.dr1
    public q00 l() {
        return ReflectClassUtilKt.a(wu1.b(wu1.a(this.a)));
    }

    @Override // defpackage.dr1
    public boolean n() {
        return false;
    }

    public String toString() {
        return tc3.class.getName() + ": " + this.a;
    }

    @Override // defpackage.dr1
    public boolean w() {
        return false;
    }
}
