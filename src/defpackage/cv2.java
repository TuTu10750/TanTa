package defpackage;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public abstract class cv2 {
    public abstract void a(CallableMemberDescriptor callableMemberDescriptor);

    public abstract void b(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void c(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public void d(CallableMemberDescriptor callableMemberDescriptor, Collection collection) {
        callableMemberDescriptor.getClass();
        collection.getClass();
        callableMemberDescriptor.w0(collection);
    }
}
