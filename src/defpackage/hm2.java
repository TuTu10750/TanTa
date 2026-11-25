package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: /tmp/classes2.dex */
public abstract class hm2 {
    public static final ConcurrentMap a = new ConcurrentHashMap();

    public static final wi3 a(Class cls) {
        cls.getClass();
        ClassLoader e = ReflectClassUtilKt.e(cls);
        sm4 sm4Var = new sm4(e);
        ConcurrentMap concurrentMap = a;
        WeakReference weakReference = (WeakReference) concurrentMap.get(sm4Var);
        if (weakReference != null) {
            wi3 wi3Var = (wi3) weakReference.get();
            if (wi3Var != null) {
                return wi3Var;
            }
            concurrentMap.remove(sm4Var, weakReference);
        }
        wi3 a2 = wi3.c.a(e);
        while (true) {
            try {
                ConcurrentMap concurrentMap2 = a;
                WeakReference weakReference2 = (WeakReference) concurrentMap2.putIfAbsent(sm4Var, new WeakReference(a2));
                if (weakReference2 == null) {
                    return a2;
                }
                wi3 wi3Var2 = (wi3) weakReference2.get();
                if (wi3Var2 != null) {
                    return wi3Var2;
                }
                concurrentMap2.remove(sm4Var, weakReference2);
            } finally {
                sm4Var.a(null);
            }
        }
    }
}
