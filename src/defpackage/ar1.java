package defpackage;

import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public final class ar1 {
    public static final ar1 a = new ar1();
    public static a b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public final Method a;
        public final Method b;

        public a(Method method, Method method2) {
            this.a = method;
            this.b = method2;
        }

        public final Method a() {
            return this.b;
        }

        public final Method b() {
            return this.a;
        }
    }

    public final a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final a b(Object obj) {
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        a a2 = a(obj);
        b = a2;
        return a2;
    }

    public final Method c(Object obj) {
        obj.getClass();
        Method a2 = b(obj).a();
        if (a2 == null) {
            return null;
        }
        Object invoke = a2.invoke(obj, null);
        invoke.getClass();
        return (Method) invoke;
    }

    public final Class d(Object obj) {
        obj.getClass();
        Method b2 = b(obj).b();
        if (b2 == null) {
            return null;
        }
        Object invoke = b2.invoke(obj, null);
        invoke.getClass();
        return (Class) invoke;
    }
}
