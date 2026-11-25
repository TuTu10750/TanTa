package defpackage;

import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public abstract class bm4 {
    public static final CallableMemberDescriptor a(Collection collection) {
        Integer d;
        collection.getClass();
        collection.isEmpty();
        Iterator it = collection.iterator();
        CallableMemberDescriptor callableMemberDescriptor = null;
        while (it.hasNext()) {
            CallableMemberDescriptor callableMemberDescriptor2 = (CallableMemberDescriptor) it.next();
            if (callableMemberDescriptor == null || ((d = ok0.d(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && d.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        callableMemberDescriptor.getClass();
        return callableMemberDescriptor;
    }
}
