package defpackage;

import defpackage.b92;
import defpackage.nx3;
import defpackage.pv2;
import defpackage.sr1;
import defpackage.ts1;
import defpackage.uk0;
import defpackage.xs1;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.types.c;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public abstract class tk0 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements ms1 {
        @Override // defpackage.ms1
        public List a(q00 q00Var) {
            q00Var.getClass();
            return null;
        }
    }

    public static final sk0 a(mm2 mm2Var, lu3 lu3Var, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, ax1 ax1Var, DeserializedDescriptorResolver deserializedDescriptorResolver, su0 su0Var, cv1 cv1Var) {
        mm2Var.getClass();
        lu3Var.getClass();
        notFoundClasses.getClass();
        lazyJavaPackageFragmentProvider.getClass();
        ax1Var.getClass();
        deserializedDescriptorResolver.getClass();
        su0Var.getClass();
        cv1Var.getClass();
        return new sk0(lu3Var, mm2Var, uk0.a.a, new nr1(ax1Var, deserializedDescriptorResolver), ci.a(mm2Var, notFoundClasses, lu3Var, ax1Var, cv1Var), lazyJavaPackageFragmentProvider, notFoundClasses, su0Var, b92.a.a, x60.a.a(), e.b.a(), new x94(r20.e(c.a)));
    }

    public static final LazyJavaPackageFragmentProvider b(qr1 qr1Var, mm2 mm2Var, lu3 lu3Var, NotFoundClasses notFoundClasses, ax1 ax1Var, DeserializedDescriptorResolver deserializedDescriptorResolver, su0 su0Var, zs1 zs1Var, jm2 jm2Var, pv2 pv2Var) {
        qr1Var.getClass();
        mm2Var.getClass();
        lu3Var.getClass();
        notFoundClasses.getClass();
        ax1Var.getClass();
        deserializedDescriptorResolver.getClass();
        su0Var.getClass();
        zs1Var.getClass();
        jm2Var.getClass();
        pv2Var.getClass();
        jp3 jp3Var = jp3.a;
        jp3Var.getClass();
        vs1 vs1Var = vs1.a;
        vs1Var.getClass();
        ts1.a aVar = ts1.a.a;
        lj3 lj3Var = new lj3(lu3Var, s20.k());
        nx3.a aVar2 = nx3.a.a;
        b92.a aVar3 = b92.a.a;
        ReflectionTypes reflectionTypes = new ReflectionTypes(mm2Var, notFoundClasses);
        JavaTypeEnhancementState.a aVar4 = JavaTypeEnhancementState.d;
        h8 h8Var = new h8(aVar4.a());
        xs1.a aVar5 = xs1.a.a;
        return new LazyJavaPackageFragmentProvider(new ws1(lu3Var, qr1Var, ax1Var, deserializedDescriptorResolver, jp3Var, su0Var, vs1Var, aVar, lj3Var, zs1Var, jm2Var, pv2Var, aVar2, aVar3, mm2Var, reflectionTypes, h8Var, new SignatureEnhancement(new ft1(aVar5)), sr1.a.a, aVar5, e.b.a(), aVar4.a(), new a(), null, 8388608, null));
    }

    public static /* synthetic */ LazyJavaPackageFragmentProvider c(qr1 qr1Var, mm2 mm2Var, lu3 lu3Var, NotFoundClasses notFoundClasses, ax1 ax1Var, DeserializedDescriptorResolver deserializedDescriptorResolver, su0 su0Var, zs1 zs1Var, jm2 jm2Var, pv2 pv2Var, int i, Object obj) {
        return b(qr1Var, mm2Var, lu3Var, notFoundClasses, ax1Var, deserializedDescriptorResolver, su0Var, zs1Var, jm2Var, (i & IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) != 0 ? pv2.a.a : pv2Var);
    }
}
