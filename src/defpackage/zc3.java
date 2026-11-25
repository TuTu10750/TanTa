package defpackage;

import defpackage.pd3;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: /tmp/classes2.dex */
public final class zc3 extends pd3 implements jr1 {
    public final Type b;
    public final pd3 c;
    public final Collection d;
    public final boolean e;

    public zc3(Type type) {
        pd3 a;
        type.getClass();
        this.b = type;
        Type Q = Q();
        if (!(Q instanceof GenericArrayType)) {
            if (Q instanceof Class) {
                Class cls = (Class) Q;
                if (cls.isArray()) {
                    pd3.a aVar = pd3.a;
                    Class<?> componentType = cls.getComponentType();
                    componentType.getClass();
                    a = aVar.a(componentType);
                }
            }
            StringBuilder sb = new StringBuilder("Not an array type (");
            sb.append(Q().getClass());
            wr4.a(sb, "): ", Q());
            throw null;
        }
        pd3.a aVar2 = pd3.a;
        Type genericComponentType = ((GenericArrayType) Q).getGenericComponentType();
        genericComponentType.getClass();
        a = aVar2.a(genericComponentType);
        this.c = a;
        this.d = s20.k();
    }

    @Override // defpackage.pd3
    public Type Q() {
        return this.b;
    }

    @Override // defpackage.jr1
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public pd3 p() {
        return this.c;
    }

    @Override // defpackage.hr1
    public Collection getAnnotations() {
        return this.d;
    }

    @Override // defpackage.hr1
    public boolean o() {
        return this.e;
    }
}
