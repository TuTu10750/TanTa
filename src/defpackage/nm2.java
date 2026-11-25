package defpackage;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: /tmp/classes2.dex */
public final class nm2 {
    public static final nm2 a = new nm2();
    public static final a b = new a(null, null, null);
    public static a c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    public final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = b;
            c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        baseContinuationImpl.getClass();
        a aVar = c;
        if (aVar == null) {
            aVar = a(baseContinuationImpl);
        }
        if (aVar != b && (method = aVar.a) != null && (invoke = method.invoke(baseContinuationImpl.getClass(), null)) != null && (method2 = aVar.b) != null && (invoke2 = method2.invoke(invoke, null)) != null) {
            Method method3 = aVar.c;
            Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
            if (invoke3 instanceof String) {
                return (String) invoke3;
            }
        }
        return null;
    }
}
