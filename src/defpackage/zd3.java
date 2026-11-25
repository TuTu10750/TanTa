package defpackage;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;

/* loaded from: /tmp/classes2.dex */
public abstract class zd3 {
    public static final ae3 a;
    public static final rv1[] b;

    static {
        ae3 ae3Var = null;
        try {
            ae3Var = (ae3) be3.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (ae3Var == null) {
            ae3Var = new ae3();
        }
        a = ae3Var;
        b = new rv1[0];
    }

    public static aw1 a(FunctionReference functionReference) {
        return a.a(functionReference);
    }

    public static rv1 b(Class cls) {
        return a.b(cls);
    }

    public static xv1 c(Class cls) {
        return a.c(cls, "");
    }

    public static xv1 d(Class cls, String str) {
        return a.c(cls, str);
    }

    public static gw1 e(MutablePropertyReference1 mutablePropertyReference1) {
        return a.d(mutablePropertyReference1);
    }

    public static jw1 f(PropertyReference0 propertyReference0) {
        return a.e(propertyReference0);
    }

    public static kw1 g(PropertyReference1 propertyReference1) {
        return a.f(propertyReference1);
    }

    public static String h(l91 l91Var) {
        return a.g(l91Var);
    }

    public static String i(Lambda lambda) {
        return a.h(lambda);
    }
}
