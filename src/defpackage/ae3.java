package defpackage;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;

/* loaded from: /tmp/classes2.dex */
public class ae3 {
    public aw1 a(FunctionReference functionReference) {
        return functionReference;
    }

    public rv1 b(Class cls) {
        return new u00(cls);
    }

    public xv1 c(Class cls, String str) {
        return new rv2(cls, str);
    }

    public gw1 d(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public jw1 e(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public kw1 f(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public String g(l91 l91Var) {
        String obj = l91Var.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String h(Lambda lambda) {
        return g(lambda);
    }
}
