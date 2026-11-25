package defpackage;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class pd3 implements ct1 {
    public static final a a = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final pd3 a(Type type) {
            type.getClass();
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new nd3(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) ? new zc3(type) : type instanceof WildcardType ? new sd3((WildcardType) type) : new dd3(type);
        }
    }

    public abstract Type Q();

    @Override // defpackage.hr1
    public dr1 a(r51 r51Var) {
        Object obj;
        r51Var.getClass();
        Iterator it = getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            q00 l = ((dr1) next).l();
            if (dq1.a(l != null ? l.b() : null, r51Var)) {
                obj = next;
                break;
            }
        }
        return (dr1) obj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof pd3) && dq1.a(Q(), ((pd3) obj).Q());
    }

    public int hashCode() {
        return Q().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + Q();
    }
}
