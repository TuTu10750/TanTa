package defpackage;

import defpackage.pd3;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: /tmp/classes2.dex */
public final class dd3 extends pd3 implements ur1 {
    public final Type b;
    public final tr1 c;

    public dd3(Type type) {
        tr1 reflectJavaClass;
        type.getClass();
        this.b = type;
        Type Q = Q();
        if (Q instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) Q);
        } else if (Q instanceof TypeVariable) {
            reflectJavaClass = new qd3((TypeVariable) Q);
        } else {
            if (!(Q instanceof ParameterizedType)) {
                we2.a("Not a classifier type (", Q.getClass(), "): ", Q);
                throw null;
            }
            Type rawType = ((ParameterizedType) Q).getRawType();
            rawType.getClass();
            reflectJavaClass = new ReflectJavaClass((Class) rawType);
        }
        this.c = reflectJavaClass;
    }

    @Override // defpackage.ur1
    public List F() {
        List c = ReflectClassUtilKt.c(Q());
        pd3.a aVar = pd3.a;
        ArrayList arrayList = new ArrayList(t20.v(c, 10));
        Iterator it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // defpackage.pd3
    public Type Q() {
        return this.b;
    }

    @Override // defpackage.pd3, defpackage.hr1
    public dr1 a(r51 r51Var) {
        r51Var.getClass();
        return null;
    }

    @Override // defpackage.hr1
    public Collection getAnnotations() {
        return s20.k();
    }

    @Override // defpackage.ur1
    public tr1 k() {
        return this.c;
    }

    @Override // defpackage.hr1
    public boolean o() {
        return false;
    }

    @Override // defpackage.ur1
    public String q() {
        return Q().toString();
    }

    @Override // defpackage.ur1
    public boolean y() {
        Type Q = Q();
        if (Q instanceof Class) {
            TypeVariable[] typeParameters = ((Class) Q).getTypeParameters();
            typeParameters.getClass();
            if (!(typeParameters.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ur1
    public String z() {
        throw new UnsupportedOperationException("Type not found: " + Q());
    }
}
