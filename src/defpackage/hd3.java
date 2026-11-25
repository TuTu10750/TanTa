package defpackage;

import defpackage.pd3;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* loaded from: /tmp/classes2.dex */
public final class hd3 extends jd3 implements cs1 {
    public final Field a;

    public hd3(Field field) {
        field.getClass();
        this.a = field;
    }

    @Override // defpackage.cs1
    public boolean G() {
        return R().isEnumConstant();
    }

    @Override // defpackage.cs1
    public boolean O() {
        return false;
    }

    @Override // defpackage.jd3
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public Field R() {
        return this.a;
    }

    @Override // defpackage.cs1
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public pd3 getType() {
        pd3.a aVar = pd3.a;
        Type genericType = R().getGenericType();
        genericType.getClass();
        return aVar.a(genericType);
    }
}
