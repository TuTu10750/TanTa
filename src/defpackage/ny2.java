package defpackage;

import java.lang.reflect.Method;
import kotlin.random.Random;

/* loaded from: /tmp/classes2.dex */
public abstract class ny2 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public static final a a = new a();
        public static final Method b;
        public static final Method c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            methods.getClass();
            int length = methods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i2];
                if (dq1.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    parameterTypes.getClass();
                    if (dq1.a(rb.X(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i2++;
            }
            b = method2;
            int length2 = methods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Method method3 = methods[i];
                if (dq1.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i++;
            }
            c = method;
        }
    }

    public void a(Throwable th, Throwable th2) {
        th.getClass();
        th2.getClass();
        Method method = a.b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public Random b() {
        return new qz0();
    }
}
