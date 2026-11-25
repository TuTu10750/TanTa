package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class ed3 extends jd3 implements vr1 {
    public final Constructor a;

    public ed3(Constructor constructor) {
        constructor.getClass();
        this.a = constructor;
    }

    @Override // defpackage.jd3
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public Constructor R() {
        return this.a;
    }

    @Override // defpackage.ht1
    public List getTypeParameters() {
        TypeVariable[] typeParameters = R().getTypeParameters();
        typeParameters.getClass();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new qd3(typeVariable));
        }
        return arrayList;
    }

    @Override // defpackage.vr1
    public List h() {
        Type[] genericParameterTypes = R().getGenericParameterTypes();
        genericParameterTypes.getClass();
        if (genericParameterTypes.length == 0) {
            return s20.k();
        }
        Class declaringClass = R().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) pb.o(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = R().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            di3.a("Illegal generic signature: ", R());
            return null;
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            parameterAnnotations.getClass();
            parameterAnnotations = (Annotation[][]) pb.o(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        parameterAnnotations.getClass();
        return S(genericParameterTypes, parameterAnnotations, R().isVarArgs());
    }
}
