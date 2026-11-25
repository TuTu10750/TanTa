package defpackage;

import defpackage.d72;
import defpackage.ky2;
import defpackage.r5;
import defpackage.uk0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.b;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public final class sk0 {
    public static final a b = new a(null);
    public final rk0 a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {

        /* renamed from: sk0$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0155a {
            public final sk0 a;
            public final DeserializedDescriptorResolver b;

            public C0155a(sk0 sk0Var, DeserializedDescriptorResolver deserializedDescriptorResolver) {
                sk0Var.getClass();
                deserializedDescriptorResolver.getClass();
                this.a = sk0Var;
                this.b = deserializedDescriptorResolver;
            }

            public final sk0 a() {
                return this.a;
            }

            public final DeserializedDescriptorResolver b() {
                return this.b;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final C0155a a(ax1 ax1Var, ax1 ax1Var2, qr1 qr1Var, String str, su0 su0Var, zs1 zs1Var) {
            ax1Var.getClass();
            ax1Var2.getClass();
            qr1Var.getClass();
            str.getClass();
            su0Var.getClass();
            zs1Var.getClass();
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            zo2 l = zo2.l("<" + str + '>');
            l.getClass();
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(l, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.E0(moduleDescriptorImpl);
            jvmBuiltIns.J0(moduleDescriptorImpl, true);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            eq3 eq3Var = new eq3();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            LazyJavaPackageFragmentProvider c = tk0.c(qr1Var, moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, ax1Var, deserializedDescriptorResolver, su0Var, zs1Var, eq3Var, null, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, null);
            sk0 a = tk0.a(moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, c, ax1Var, deserializedDescriptorResolver, su0Var, cv1.i);
            deserializedDescriptorResolver.n(a);
            vs1 vs1Var = vs1.a;
            vs1Var.getClass();
            xr1 xr1Var = new xr1(c, vs1Var);
            eq3Var.c(xr1Var);
            uu1 uu1Var = new uu1(lockBasedStorageManager, ax1Var2, moduleDescriptorImpl, notFoundClasses, jvmBuiltIns.I0(), jvmBuiltIns.I0(), uk0.a.a, e.b.a(), new lj3(lockBasedStorageManager, s20.k()));
            moduleDescriptorImpl.Y0(moduleDescriptorImpl);
            moduleDescriptorImpl.S0(new j40(s20.n(xr1Var.a(), uu1Var), "CompositeProvider@RuntimeModuleData for " + moduleDescriptorImpl));
            return new C0155a(a, deserializedDescriptorResolver);
        }
    }

    public sk0(lu3 lu3Var, mm2 mm2Var, uk0 uk0Var, nr1 nr1Var, b bVar, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, NotFoundClasses notFoundClasses, su0 su0Var, b92 b92Var, x60 x60Var, e eVar, x94 x94Var) {
        ky2 I0;
        r5 I02;
        lu3Var.getClass();
        mm2Var.getClass();
        uk0Var.getClass();
        nr1Var.getClass();
        bVar.getClass();
        lazyJavaPackageFragmentProvider.getClass();
        notFoundClasses.getClass();
        su0Var.getClass();
        b92Var.getClass();
        x60Var.getClass();
        eVar.getClass();
        x94Var.getClass();
        d q = mm2Var.q();
        JvmBuiltIns jvmBuiltIns = q instanceof JvmBuiltIns ? (JvmBuiltIns) q : null;
        this.a = new rk0(lu3Var, mm2Var, uk0Var, nr1Var, bVar, lazyJavaPackageFragmentProvider, d72.a.a, su0Var, b92Var, ds1.a, s20.k(), notFoundClasses, x60Var, (jvmBuiltIns == null || (I02 = jvmBuiltIns.I0()) == null) ? r5.a.a : I02, (jvmBuiltIns == null || (I0 = jvmBuiltIns.I0()) == null) ? ky2.b.a : I0, hv1.a.a(), eVar, new lj3(lu3Var, s20.k()), null, x94Var.a(), 262144, null);
    }

    public final rk0 a() {
        return this.a;
    }
}
