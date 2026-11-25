package defpackage;

import defpackage.y80;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: /tmp/classes2.dex */
public class nk0 implements y80.c {
    public final boolean a;

    public nk0(boolean z) {
        this.a = z;
    }

    @Override // y80.c
    public Iterable a(Object obj) {
        Iterable g;
        g = DescriptorUtilsKt.g(this.a, (CallableMemberDescriptor) obj);
        return g;
    }
}
