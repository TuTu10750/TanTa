package defpackage;

import defpackage.b92;
import defpackage.d72;
import defpackage.m31;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b;
import kotlin.reflect.jvm.internal.impl.types.checker.e;

/* loaded from: /tmp/classes2.dex */
public final class uu1 extends AbstractDeserializedPackageFragmentProvider {
    public static final a f = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uu1(lu3 lu3Var, ax1 ax1Var, mm2 mm2Var, NotFoundClasses notFoundClasses, r5 r5Var, ky2 ky2Var, uk0 uk0Var, e eVar, kj3 kj3Var) {
        super(lu3Var, ax1Var, mm2Var);
        lu3Var.getClass();
        ax1Var.getClass();
        mm2Var.getClass();
        notFoundClasses.getClass();
        r5Var.getClass();
        ky2Var.getClass();
        uk0Var.getClass();
        eVar.getClass();
        kj3Var.getClass();
        al0 al0Var = new al0(this);
        vk vkVar = vk.r;
        b bVar = new b(mm2Var, notFoundClasses, vkVar);
        d72.a aVar = d72.a.a;
        su0 su0Var = su0.a;
        su0Var.getClass();
        i(new rk0(lu3Var, mm2Var, uk0Var, al0Var, bVar, this, aVar, su0Var, b92.a.a, m31.a.a, s20.n(new kotlin.reflect.jvm.internal.impl.builtins.functions.a(lu3Var, mm2Var), new JvmBuiltInClassDescriptorFactory(lu3Var, mm2Var, null, 4, null)), notFoundClasses, x60.a.a(), r5Var, ky2Var, vkVar.e(), eVar, kj3Var, null, null, 786432, null));
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider
    public dl0 d(r51 r51Var) {
        r51Var.getClass();
        InputStream c = f().c(r51Var);
        if (c != null) {
            return kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.o.a(r51Var, h(), g(), c, false);
        }
        return null;
    }
}
