package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.types.checker.b;

/* loaded from: /tmp/classes2.dex */
public class ek0 implements b.a {
    public final boolean a;
    public final a b;
    public final a c;

    public ek0(boolean z, a aVar, a aVar2) {
        this.a = z;
        this.b = aVar;
        this.c = aVar2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.b.a
    public boolean a(ea4 ea4Var, ea4 ea4Var2) {
        boolean d;
        d = DescriptorEquivalenceForOverrides.d(this.a, this.b, this.c, ea4Var, ea4Var2);
        return d;
    }
}
