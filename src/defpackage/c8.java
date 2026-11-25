package defpackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;

/* loaded from: /tmp/classes2.dex */
public class c8 implements InvocationHandler {
    public final Class a;
    public final Map b;
    public final wx1 c;
    public final wx1 d;
    public final List e;

    public c8(Class cls, Map map, wx1 wx1Var, wx1 wx1Var2, List list) {
        this.a = cls;
        this.b = map;
        this.c = wx1Var;
        this.d = wx1Var2;
        this.e = list;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object i;
        i = AnnotationConstructorCallerKt.i(this.a, this.b, this.c, this.d, this.e, obj, method, objArr);
        return i;
    }
}
