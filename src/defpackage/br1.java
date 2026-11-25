package defpackage;

import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public final class br1 {
    public static final br1 a = new br1();
    public static a b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public final Method a;
        public final Method b;
        public final Method c;
        public final Method d;

        public a(Method method, Method method2, Method method3, Method method4) {
            this.a = method;
            this.b = method2;
            this.c = method3;
            this.d = method4;
        }

        public final Method a() {
            return this.b;
        }

        public final Method b() {
            return this.d;
        }

        public final Method c() {
            return this.c;
        }

        public final Method d() {
            return this.a;
        }
    }

    public final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    public final a b() {
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        a a2 = a();
        b = a2;
        return a2;
    }

    public final Class[] c(Class cls) {
        cls.getClass();
        Method a2 = b().a();
        if (a2 == null) {
            return null;
        }
        Object invoke = a2.invoke(cls, null);
        invoke.getClass();
        return (Class[]) invoke;
    }

    public final Object[] d(Class cls) {
        cls.getClass();
        Method b2 = b().b();
        if (b2 == null) {
            return null;
        }
        return (Object[]) b2.invoke(cls, null);
    }

    public final Boolean e(Class cls) {
        cls.getClass();
        Method c = b().c();
        if (c == null) {
            return null;
        }
        Object invoke = c.invoke(cls, null);
        invoke.getClass();
        return (Boolean) invoke;
    }

    public final Boolean f(Class cls) {
        cls.getClass();
        Method d = b().d();
        if (d == null) {
            return null;
        }
        Object invoke = d.invoke(cls, null);
        invoke.getClass();
        return (Boolean) invoke;
    }
}
