package defpackage;

import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* loaded from: /tmp/classes2.dex */
public abstract class la0 {
    public static final ka0 a(BaseContinuationImpl baseContinuationImpl) {
        return (ka0) baseContinuationImpl.getClass().getAnnotation(ka0.class);
    }

    public static final int b(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement c(BaseContinuationImpl baseContinuationImpl) {
        String str;
        baseContinuationImpl.getClass();
        ka0 a = a(baseContinuationImpl);
        if (a == null || a.v() < 1) {
            return null;
        }
        int b = b(baseContinuationImpl);
        int i = b < 0 ? -1 : a.l()[b];
        String b2 = nm2.a.b(baseContinuationImpl);
        if (b2 == null) {
            str = a.c();
        } else {
            str = b2 + '/' + a.c();
        }
        return new StackTraceElement(str, a.m(), a.f(), i);
    }
}
