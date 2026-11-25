package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public final class vi3 implements su0 {
    public static final vi3 b = new vi3();

    @Override // defpackage.su0
    public void a(m00 m00Var, List list) {
        m00Var.getClass();
        list.getClass();
        throw new IllegalStateException("Incomplete hierarchy for class " + m00Var.getName() + ", unresolved classes " + list);
    }

    @Override // defpackage.su0
    public void b(CallableMemberDescriptor callableMemberDescriptor) {
        callableMemberDescriptor.getClass();
        throw new IllegalStateException("Cannot infer visibility for " + callableMemberDescriptor);
    }
}
