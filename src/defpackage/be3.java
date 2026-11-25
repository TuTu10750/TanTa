package defpackage;

import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.reflect.jvm.internal.CachesKt;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.a;

/* loaded from: /tmp/classes2.dex */
public class be3 extends ae3 {
    public static KDeclarationContainerImpl i(CallableReference callableReference) {
        xv1 owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : a.d;
    }

    @Override // defpackage.ae3
    public aw1 a(FunctionReference functionReference) {
        return new KFunctionImpl(i(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // defpackage.ae3
    public rv1 b(Class cls) {
        return CachesKt.a(cls);
    }

    @Override // defpackage.ae3
    public xv1 c(Class cls, String str) {
        return CachesKt.b(cls);
    }

    @Override // defpackage.ae3
    public gw1 d(MutablePropertyReference1 mutablePropertyReference1) {
        return new KMutableProperty1Impl(i(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // defpackage.ae3
    public jw1 e(PropertyReference0 propertyReference0) {
        return new KProperty0Impl(i(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // defpackage.ae3
    public kw1 f(PropertyReference1 propertyReference1) {
        return new KProperty1Impl(i(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // defpackage.ae3
    public String g(l91 l91Var) {
        KFunctionImpl c;
        aw1 a = ReflectLambdaKt.a(l91Var);
        return (a == null || (c = if4.c(a)) == null) ? super.g(l91Var) : ReflectionObjectRenderer.a.e(c.H());
    }

    @Override // defpackage.ae3
    public String h(Lambda lambda) {
        return g(lambda);
    }
}
