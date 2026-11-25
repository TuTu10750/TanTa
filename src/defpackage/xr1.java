package defpackage;

import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: /tmp/classes2.dex */
public final class xr1 {
    public final LazyJavaPackageFragmentProvider a;
    public final vs1 b;

    public xr1(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, vs1 vs1Var) {
        lazyJavaPackageFragmentProvider.getClass();
        vs1Var.getClass();
        this.a = lazyJavaPackageFragmentProvider;
        this.b = vs1Var;
    }

    public final LazyJavaPackageFragmentProvider a() {
        return this.a;
    }

    public final m00 b(lr1 lr1Var) {
        lr1Var.getClass();
        r51 d = lr1Var.d();
        if (d != null && lr1Var.I() == LightClassOriginKind.SOURCE) {
            return this.b.d(d);
        }
        lr1 g = lr1Var.g();
        if (g != null) {
            m00 b = b(g);
            MemberScope x0 = b != null ? b.x0() : null;
            z00 e = x0 != null ? x0.e(lr1Var.getName(), NoLookupLocation.FROM_JAVA_LOADER) : null;
            if (e instanceof m00) {
                return (m00) e;
            }
            return null;
        }
        if (d == null) {
            return null;
        }
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this.a;
        r51 e2 = d.e();
        e2.getClass();
        LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) b30.d0(lazyJavaPackageFragmentProvider.b(e2));
        if (lazyJavaPackageFragment != null) {
            return lazyJavaPackageFragment.M0(lr1Var);
        }
        return null;
    }
}
