package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.reflect.TypesJVMKt;
import okhttp3.HttpUrl;

/* loaded from: /tmp/classes2.dex */
public final class lb1 implements GenericArrayType, Type {
    public final Type a;

    public lb1(Type type) {
        type.getClass();
        this.a = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && dq1.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        String h;
        StringBuilder sb = new StringBuilder();
        h = TypesJVMKt.h(this.a);
        sb.append(h);
        sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
