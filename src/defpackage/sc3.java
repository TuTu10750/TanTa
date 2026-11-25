package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: /tmp/classes2.dex */
public final class sc3 {
    public static final sc3 a = new sc3();

    public final r00 a(Class cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            cls.getClass();
        }
        if (!cls.isPrimitive()) {
            q00 a2 = ReflectClassUtilKt.a(cls);
            at1 at1Var = at1.a;
            r51 b = a2.b();
            b.getClass();
            q00 m = at1Var.m(b);
            if (m != null) {
                a2 = m;
            }
            return new r00(a2, i);
        }
        if (dq1.a(cls, Void.TYPE)) {
            q00 m2 = q00.m(e.a.f.l());
            m2.getClass();
            return new r00(m2, i);
        }
        PrimitiveType i2 = JvmPrimitiveType.b(cls.getName()).i();
        i2.getClass();
        if (i > 0) {
            q00 m3 = q00.m(i2.b());
            m3.getClass();
            return new r00(m3, i - 1);
        }
        q00 m4 = q00.m(i2.d());
        m4.getClass();
        return new r00(m4, i);
    }

    public final void b(Class cls, c.InterfaceC0112c interfaceC0112c) {
        cls.getClass();
        interfaceC0112c.getClass();
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        declaredAnnotations.getClass();
        for (Annotation annotation : declaredAnnotations) {
            annotation.getClass();
            f(interfaceC0112c, annotation);
        }
        interfaceC0112c.a();
    }

    public final void c(Class cls, c.d dVar) {
        Constructor<?>[] constructorArr;
        int i;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        declaredConstructors.getClass();
        int length = declaredConstructors.length;
        int i2 = 0;
        while (i2 < length) {
            Constructor<?> constructor = declaredConstructors[i2];
            zo2 zo2Var = ls3.j;
            kp3 kp3Var = kp3.a;
            constructor.getClass();
            c.e a2 = dVar.a(zo2Var, kp3Var.a(constructor));
            if (a2 == null) {
                constructorArr = declaredConstructors;
                i = length;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                declaredAnnotations.getClass();
                for (Annotation annotation : declaredAnnotations) {
                    annotation.getClass();
                    f(a2, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                parameterAnnotations.getClass();
                if (!(parameterAnnotations.length == 0)) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i3 = 0; i3 < length3; i3++) {
                        Annotation[] annotationArr = parameterAnnotations[i3];
                        annotationArr.getClass();
                        int length4 = annotationArr.length;
                        int i4 = 0;
                        while (i4 < length4) {
                            Annotation annotation2 = annotationArr[i4];
                            Class b = wu1.b(wu1.a(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            q00 a3 = ReflectClassUtilKt.a(b);
                            int i5 = length;
                            annotation2.getClass();
                            c.a c = a2.c(i3 + length2, a3, new rc3(annotation2));
                            if (c != null) {
                                a.h(c, annotation2, b);
                            }
                            i4++;
                            declaredConstructors = constructorArr2;
                            length = i5;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                i = length;
                a2.a();
            }
            i2++;
            declaredConstructors = constructorArr;
            length = i;
        }
    }

    public final void d(Class cls, c.d dVar) {
        Field[] declaredFields = cls.getDeclaredFields();
        declaredFields.getClass();
        for (Field field : declaredFields) {
            zo2 i = zo2.i(field.getName());
            i.getClass();
            c.InterfaceC0112c b = dVar.b(i, kp3.a.b(field), null);
            if (b != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                declaredAnnotations.getClass();
                for (Annotation annotation : declaredAnnotations) {
                    annotation.getClass();
                    f(b, annotation);
                }
                b.a();
            }
        }
    }

    public final void e(Class cls, c.d dVar) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        declaredMethods.getClass();
        for (Method method : declaredMethods) {
            zo2 i = zo2.i(method.getName());
            i.getClass();
            c.e a2 = dVar.a(i, kp3.a.c(method));
            if (a2 != null) {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                declaredAnnotations.getClass();
                for (Annotation annotation : declaredAnnotations) {
                    annotation.getClass();
                    f(a2, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                parameterAnnotations.getClass();
                Annotation[][] annotationArr = parameterAnnotations;
                int length = annotationArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Annotation[] annotationArr2 = annotationArr[i2];
                    annotationArr2.getClass();
                    for (Annotation annotation2 : annotationArr2) {
                        Class b = wu1.b(wu1.a(annotation2));
                        q00 a3 = ReflectClassUtilKt.a(b);
                        annotation2.getClass();
                        c.a c = a2.c(i2, a3, new rc3(annotation2));
                        if (c != null) {
                            a.h(c, annotation2, b);
                        }
                    }
                }
                a2.a();
            }
        }
    }

    public final void f(c.InterfaceC0112c interfaceC0112c, Annotation annotation) {
        Class b = wu1.b(wu1.a(annotation));
        c.a b2 = interfaceC0112c.b(ReflectClassUtilKt.a(b), new rc3(annotation));
        if (b2 != null) {
            a.h(b2, annotation, b);
        }
    }

    public final void g(c.a aVar, zo2 zo2Var, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (dq1.a(cls, Class.class)) {
            aVar.d(zo2Var, a((Class) obj));
            return;
        }
        set = xd3.a;
        if (set.contains(cls)) {
            aVar.c(zo2Var, obj);
            return;
        }
        if (ReflectClassUtilKt.g(cls)) {
            if (!cls.isEnum()) {
                cls = cls.getEnclosingClass();
            }
            cls.getClass();
            q00 a2 = ReflectClassUtilKt.a(cls);
            zo2 i = zo2.i(((Enum) obj).name());
            i.getClass();
            aVar.f(zo2Var, a2, i);
            return;
        }
        if (Annotation.class.isAssignableFrom(cls)) {
            Class<?>[] interfaces = cls.getInterfaces();
            interfaces.getClass();
            Class cls2 = (Class) rb.W(interfaces);
            cls2.getClass();
            c.a b = aVar.b(zo2Var, ReflectClassUtilKt.a(cls2));
            if (b == null) {
                return;
            }
            h(b, (Annotation) obj, cls2);
            return;
        }
        if (!cls.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
        c.b e = aVar.e(zo2Var);
        if (e == null) {
            return;
        }
        Class<?> componentType = cls.getComponentType();
        int i2 = 0;
        if (componentType.isEnum()) {
            q00 a3 = ReflectClassUtilKt.a(componentType);
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i2 < length) {
                Object obj2 = objArr[i2];
                obj2.getClass();
                zo2 i3 = zo2.i(((Enum) obj2).name());
                i3.getClass();
                e.d(a3, i3);
                i2++;
            }
        } else if (dq1.a(componentType, Class.class)) {
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            while (i2 < length2) {
                Object obj3 = objArr2[i2];
                obj3.getClass();
                e.e(a((Class) obj3));
                i2++;
            }
        } else if (Annotation.class.isAssignableFrom(componentType)) {
            Object[] objArr3 = (Object[]) obj;
            int length3 = objArr3.length;
            while (i2 < length3) {
                Object obj4 = objArr3[i2];
                c.a b2 = e.b(ReflectClassUtilKt.a(componentType));
                if (b2 != null) {
                    obj4.getClass();
                    h(b2, (Annotation) obj4, componentType);
                }
                i2++;
            }
        } else {
            Object[] objArr4 = (Object[]) obj;
            int length4 = objArr4.length;
            while (i2 < length4) {
                e.c(objArr4[i2]);
                i2++;
            }
        }
        e.a();
    }

    public final void h(c.a aVar, Annotation annotation, Class cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        declaredMethods.getClass();
        for (Method method : declaredMethods) {
            try {
                Object invoke = method.invoke(annotation, null);
                invoke.getClass();
                zo2 i = zo2.i(method.getName());
                i.getClass();
                g(aVar, i, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void i(Class cls, c.d dVar) {
        cls.getClass();
        dVar.getClass();
        e(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }
}
