package defpackage;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;

/* loaded from: /tmp/classes2.dex */
public final class cx1 implements xr3 {
    public final LazyJavaPackageFragment b;

    public cx1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        lazyJavaPackageFragment.getClass();
        this.b = lazyJavaPackageFragment;
    }

    @Override // defpackage.xr3
    public yr3 a() {
        yr3 yr3Var = yr3.a;
        yr3Var.getClass();
        return yr3Var;
    }

    public String toString() {
        return this.b + ": " + this.b.N0().keySet();
    }
}
