package defpackage;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: /tmp/classes2.dex */
public final class cr1 {
    public static final cr1 a = new cr1();
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

    public final a a(Member member) {
        member.getClass();
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), ReflectClassUtilKt.e(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List b(Member member) {
        Method a2;
        member.getClass();
        a aVar = b;
        if (aVar == null) {
            synchronized (this) {
                aVar = b;
                if (aVar == null) {
                    aVar = a.a(member);
                    b = aVar;
                }
            }
        }
        Method b2 = aVar.b();
        if (b2 == null || (a2 = aVar.a()) == null) {
            return null;
        }
        Object invoke = b2.invoke(member, null);
        invoke.getClass();
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = a2.invoke(obj, null);
            invoke2.getClass();
            arrayList.add((String) invoke2);
        }
        return arrayList;
    }
}
