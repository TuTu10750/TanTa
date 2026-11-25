package defpackage;

import defpackage.pd3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class kd3 extends jd3 implements ks1 {
    public final Method a;

    public kd3(Method method) {
        method.getClass();
        this.a = method;
    }

    @Override // defpackage.ks1
    public boolean L() {
        return s() != null;
    }

    @Override // defpackage.jd3
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public Method R() {
        return this.a;
    }

    @Override // defpackage.ks1
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public pd3 getReturnType() {
        pd3.a aVar = pd3.a;
        Type genericReturnType = R().getGenericReturnType();
        genericReturnType.getClass();
        return aVar.a(genericReturnType);
    }

    @Override // defpackage.ht1
    public List getTypeParameters() {
        TypeVariable<Method>[] typeParameters = R().getTypeParameters();
        typeParameters.getClass();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new qd3(typeVariable));
        }
        return arrayList;
    }

    @Override // defpackage.ks1
    public List h() {
        Type[] genericParameterTypes = R().getGenericParameterTypes();
        genericParameterTypes.getClass();
        Annotation[][] parameterAnnotations = R().getParameterAnnotations();
        parameterAnnotations.getClass();
        return S(genericParameterTypes, parameterAnnotations, R().isVarArgs());
    }

    @Override // defpackage.ks1
    public er1 s() {
        Object defaultValue = R().getDefaultValue();
        if (defaultValue != null) {
            return uc3.b.a(defaultValue, null);
        }
        return null;
    }
}
