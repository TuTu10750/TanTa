package defpackage;

import defpackage.y80;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public class su1 implements y80.c {
    public static final su1 a = new su1();

    @Override // y80.c
    public Iterable a(Object obj) {
        Iterable w;
        w = JvmBuiltInsCustomizer.w((CallableMemberDescriptor) obj);
        return w;
    }
}
